/**
 * Instamart search module — Headed Playwright + Extension Adapter Bridge
 *
 * WAF bypass strategy:
 *   - Launch a real headed Chromium browser (headless: false)
 *   - Set location ONCE via the native Swiggy UI:
 *       1. Navigate to swiggy.com/instamart
 *       2. When the location popup appears, click the search box,
 *          type the pincode, click the first result
 *       3. Click "Confirm Location" on the map page
 *   - After location is confirmed, execute ALL subsequent searches via
 *     page.evaluate() using the exact same fetch() call as adapters/instamart.js
 *   - The headed page has real browser fingerprint + aws-waf-token cookie → no 403
 *
 * "Something went wrong" errors → retry up to MAX_NAV_RETRIES times.
 * Location is set once and re-used for all queries at the same lat/lon.
 */

'use strict';

const { normalizeProduct } = require('./normalizer.js');

const log = (...a) => console.log('[instamart]', ...a);

const MAX_NAV_RETRIES = 4;
const SEARCH_URL    = 'https://www.swiggy.com/api/instamart/search/v2';
const INSTAMART_URL = 'https://www.swiggy.com/instamart?entryId=1234&entryName=mainTileEntry4&v=1';
const SWIGGY_CDN = 'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_300,h_300/';

// ─── Singleton browser state ──────────────────────────────────────────────────

let _browser  = null;
let _context  = null;
let _page     = null;           // persistent warm page (keeps WAF cookies alive)
let _locKey   = null;           // "$lat,$lon" of currently-set location
let _initProm = null;

const delay = (ms) => new Promise(r => setTimeout(r, ms));
const randDelay = (lo, hi) => delay(Math.floor(Math.random() * (hi - lo + 1)) + lo);

// ─── Browser lifecycle ────────────────────────────────────────────────────────

async function getBrowser() {
  if (_browser) return _browser;
  if (_initProm) return _initProm;

  _initProm = (async () => {
    log('Launching headed Chromium...');
    const { chromium } = require('playwright');
    _browser = await chromium.launch({
      headless: false,
      args: [
        '--no-sandbox',
        '--disable-setuid-sandbox',
        '--disable-blink-features=AutomationControlled',
      ],
    });
    _initProm = null;
    return _browser;
  })();

  return _initProm;
}

async function getContext() {
  if (_context) return _context;
  const browser = await getBrowser();
  _context = await browser.newContext({
    userAgent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
    viewport: { width: 1280, height: 800 },
  });
  await _context.addInitScript(() => {
    Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
  });
  return _context;
}

async function resetAll() {
  _locKey  = null;
  _page    = null;
  _initProm = null;
  try { await _context?.close(); } catch {}
  try { await _browser?.close(); } catch {}
  _context = null;
  _browser = null;
}

// ─── Navigation with "Something went wrong" retry ────────────────────────────

async function safeGoto(page, url, retries = MAX_NAV_RETRIES) {
  for (let attempt = 1; attempt <= retries; attempt++) {
    log(`Navigate to ${url} (attempt ${attempt}/${retries})`);
    try {
      await page.goto(url, { waitUntil: 'domcontentloaded', timeout: 30000 });
    } catch (e) {
      log('goto warning:', e.message);
    }
    await randDelay(800, 1200);

    // Check for "Something went wrong" splash
    const hasError = await page.evaluate(() => {
      const el = document.querySelector('[data-testid="error-button"]');
      return el !== null || document.body.innerText.includes('Something went wrong');
    });

    if (!hasError) return; // good

    log(`⚠️  "Something went wrong" on attempt ${attempt}`);
    if (attempt < retries) {
      // Try clicking "Try Again"
      await page.evaluate(() => {
        const btn = document.querySelector('[data-testid="error-button"] button')
          || [...document.querySelectorAll('button')].find(b => b.textContent.includes('Try again'));
        if (btn) btn.click();
      });
      await randDelay(1500, 2500);
    }
  }
  throw new Error(`"Something went wrong" persisted after ${retries} attempts at ${url}`);
}

/** True when Swiggy shows error splash — use to decide ETA reload vs skipping a healthy page. */
async function instamartPageShowsError(page) {
  return page.evaluate(() => {
    const t = document.body?.innerText || '';
    return (
      document.querySelector('[data-testid="error-button"]') !== null ||
      t.includes('Something went wrong') ||
      t.includes("Couldn't load") ||
      t.includes('Could not load')
    );
  });
}

// ─── Location setup via Swiggy UI (pincode → first result → Confirm) ─────────

/**
 * Uses the Swiggy popup UI to search by pincode and confirm location.
 *
 * Exact confirmed flow (from live browser inspection):
 *   1. Navigate to swiggy.com/instamart  →  popup appears
 *   2. The popup shows a DIV with text "Search for an area or address" (NOT an input yet)
 *      Click that div → the real input._1wkJd with placeholder "Search for area, street name…" appears
 *   3. Type pincode → div results appear below → click first one
 *   4. Map page with "Confirm Location" button → click it
 *   5. Homepage reloads showing delivery ETA
 */
async function setLocationByPincode(page, pincode) {
  log(`Setting location via pincode: ${pincode}`);

  await safeGoto(page, INSTAMART_URL);

  // ----- Step 1: If popup not already showing an input, open it -----
  // First check if the real input is already visible
  let inputAlreadyVisible = await page.locator('input._1wkJd').isVisible().catch(() => false);

  if (!inputAlreadyVisible) {
    log('Looking for location trigger element (the clickable "Search for an area or address" div)...');

    // The popup shows a div/button-like element. Click it to reveal the real input.
    const triggered = await page.evaluate(() => {
      // Try the clickable search placeholder text in the popup
      const allEls = document.querySelectorAll('div, p, span, button');
      for (const el of allEls) {
        const txt = el.textContent.trim();
        if (
          el.offsetParent !== null &&
          el.children.length === 0 && // leaf node, like a placeholder span
          (txt === 'Search for an area or address' || txt.includes('Search for an area'))
        ) {
          el.click();
          return 'popup-search-trigger';
        }
      }
      // Also try the address bar at the top if popup is not showing
      const addressBar = document.querySelector('[data-testid="DEFAULT_ADDRESS_TITLE"]')
        || document.querySelector('[data-testid="address-bar"]');
      if (addressBar && addressBar.offsetParent !== null) {
        addressBar.click();
        return 'address-bar';
      }
      return null;
    });

    log(`Triggered: ${triggered}`);
    await randDelay(400, 700);
  }

  // ----- Step 2: Wait for actual input and type pincode -----
  log('Waiting for search input and typing pincode...');

  // The actual input has class _1wkJd, placeholder "Search for area, street name…"
  // Use a broad fallback too
  const inputLocator = page.locator([
    'input._1wkJd',
    'input[placeholder*="area, street"]',
    'input[placeholder*="Search for area"]',
    'input[placeholder*="area or address"]',
  ].join(', ')).first();

  try {
    await inputLocator.waitFor({ state: 'visible', timeout: 8000 });
    await inputLocator.click();
    await randDelay(120, 220);
    await inputLocator.fill('');
    await inputLocator.type(String(pincode), { delay: 35 });
    log(`Typed pincode: ${pincode}`);
    await randDelay(700, 1100);
  } catch (e) {
    log('Search input error:', e.message);
    throw new Error(`Location search input not found: ${e.message}`);
  }

  // ----- Step 3: Click first autocomplete result -----
  log('Clicking first autocomplete result...');
  try {
    // Results are plain divs — wait a moment then grab the first visible one
    await randDelay(350, 550);

    const clicked = await page.evaluate((pin) => {
      // Approach 1: find divs that contain the pincode text in results area
      const allDivs = Array.from(document.querySelectorAll('div'));
      for (const el of allDivs) {
        if (
          el.offsetParent !== null &&
          el.children.length <= 2 &&        // shallow: result row
          el.textContent.includes(pin) &&
          el.textContent.trim().length < 200 // not a huge container
        ) {
          el.click();
          return el.textContent.trim().slice(0, 80);
        }
      }

      // Approach 2: any li or role=option
      const listItems = document.querySelectorAll('li, [role="option"]');
      for (const el of listItems) {
        if (el.offsetParent !== null && el.textContent.trim().length > 0) {
          el.click();
          return el.textContent.trim().slice(0, 80);
        }
      }
      return null;
    }, String(pincode));

    if (!clicked) throw new Error('No autocomplete results found');
    log(`Clicked result: "${clicked}"`);
  } catch (e) {
    throw new Error(`Could not click search result: ${e.message}`);
  }

  // ----- Step 4: Wait for map + Confirm Location -----
  log('Waiting for Confirm Location button...');
  await randDelay(900, 1400);

  try {
    await page.waitForFunction(() => {
      const btns = document.querySelectorAll('button');
      return [...btns].some(b => b.textContent.includes('Confirm'));
    }, { timeout: 10000 }).catch(() => {});

    const confirmed = await page.evaluate(() => {
      const btn = [...document.querySelectorAll('button')].find(
        b => b.textContent.trim().toLowerCase().includes('confirm') && b.offsetParent !== null
      );
      if (btn) { btn.click(); return btn.textContent.trim(); }
      return null;
    });

    log(confirmed ? `✅ Clicked "${confirmed}"` : '⚠️ Confirm button not found, continuing...');
  } catch (e) {
    log('Confirm button warning:', e.message);
  }

  // ----- Step 5: Wait for homepage with location set -----
  await randDelay(900, 1400);
  await page.waitForLoadState('domcontentloaded').catch(() => {});

  const locationOk = await page.evaluate(() =>
    document.body.innerText.includes('Mins') ||
    document.body.innerText.includes('Delivery') ||
    document.body.innerText.includes('Select Your Location') === false
  );

  log(locationOk ? '✅ Location set successfully!' : '⚠️ Location state uncertain, continuing...');
}

// ─── Response parser (mirrors adapters/instamart.js exactly) ─────────────────

function extractProductsFromResponse(data) {
  if (data?.statusCode && !data?.data) return [];
  const cards = data?.data?.cards;
  if (!Array.isArray(cards)) return [];

  const variations = [];
  for (const topCard of cards) {
    const inner = topCard?.card?.card;
    if (!inner) continue;
    const items = inner?.gridElements?.infoWithStyle?.items;
    if (!Array.isArray(items)) continue;

    for (const item of items) {
      if (!Array.isArray(item?.variations)) continue;
      for (const variation of item.variations) {
        if (!variation?.skuId || !variation?.displayName) continue;
        variation._parentBrand   = item.brand   ?? '';
        variation._parentInStock = item.inStock  ?? true;
        variations.push(variation);
      }
    }
  }
  return variations;
}

function mapInstamartProduct(raw) {
  const id       = raw.skuId ?? '';
  const name     = raw.displayName ?? '';
  const brand    = raw.brandName || raw._parentBrand || '';
  const packsize = raw.quantityDescription ?? '';
  const price    = parseFloat(raw.price?.offerPrice?.units ?? raw.price?.mrp?.units ?? '0') || null;
  const mrp      = parseFloat(raw.price?.mrp?.units ?? raw.price?.offerPrice?.units ?? '0') || price;

  const firstImageMedia = Array.isArray(raw.medias)
    ? raw.medias.find(m => m.type === 'MEDIA_TYPE_IMAGE') : null;
  const imageId  = firstImageMedia?.id ?? raw.imageIds?.[0] ?? '';
  const imageUrl = imageId ? `${SWIGGY_CDN}${imageId}` : '';
  const inStock  = raw.inventory?.inStock === true || raw._parentInStock === true;
  const deepLink = `https://www.swiggy.com/instamart/item-page/${id}`;

  return { id, name, brand, price, mrp, imageUrl, packsize, inStock, deepLink };
}

// ─── Extract storeIds by intercepting real Swiggy API calls after location set ─

/**
 * Trigger a lightweight Swiggy request on the page, intercept it to capture
 * the real storeId that Swiggy assigned for this location.
 * Falls back to navigating to the search page and reading URL params.
 */
async function extractStoreIds(page, context) {
  // Method 1: check strId cookie (Swiggy sets this after location confirmation)
  const cookies = await context.cookies(['https://www.swiggy.com']);
  const strIdCookie = cookies.find(c => c.name === 'strId');
  if (strIdCookie?.value) {
    const sid = strIdCookie.value;
    log(`Got storeId from strId cookie: ${sid}`);
    return { storeId: sid, primaryStoreId: sid, secondaryStoreId: '1392660' };
  }

  // Method 2: read from page URL query params (Swiggy puts storeId in search URL)
  const urlParams = await page.evaluate(() => {
    const p = new URLSearchParams(window.location.search);
    return { storeId: p.get('storeId'), primaryStoreId: p.get('primaryStoreId') };
  });
  if (urlParams.storeId) {
    log(`Got storeId from URL params: ${urlParams.storeId}`);
    return {
      storeId: urlParams.storeId,
      primaryStoreId: urlParams.primaryStoreId || urlParams.storeId,
      secondaryStoreId: '1392660',
    };
  }

  // Method 3: intercept a real Swiggy homepage XHR that carries storeId
  // Navigate to instamart page and listen for an API call that includes storeId
  log('Intercepting real Swiggy request to get storeId...');
  let capturedStoreId = null;

  const captureHandler = (response) => {
    const url = response.url();
    if (url.includes('/api/instamart/') && url.includes('storeId')) {
      const u = new URL(url);
      const sid = u.searchParams.get('storeId') || u.searchParams.get('primaryStoreId');
      if (sid) capturedStoreId = sid;
    }
  };
  page.on('response', captureHandler);

  try {
    // Navigate to instamart homepage to trigger API calls with storeId
    await page.goto(INSTAMART_URL, {
      waitUntil: 'domcontentloaded', timeout: 20000
    }).catch(() => {});
    await delay(3000); // give time for API calls to fire
  } finally {
    page.off('response', captureHandler);
  }

  if (capturedStoreId) {
    log(`Got storeId from intercepted request: ${capturedStoreId}`);
    return { storeId: capturedStoreId, primaryStoreId: capturedStoreId, secondaryStoreId: '1392660' };
  }

  // Fallback: use defaults (Swiggy's API usually still works, just might show wrong location)
  log('⚠️ Could not extract storeId, using defaults');
  return { storeId: '1231052', primaryStoreId: '1231052', secondaryStoreId: '1392660' };
}

// ─── Search via navigation + response interception ────────────────────────────
// Navigate to Swiggy's own search URL and intercept the API response.
// Swiggy's frontend generates all required headers (matcher, x-build-version, etc.)
// so we never hit ERR_NON_2XX_3XX_RESPONSE from missing headers.

async function executeSearch(page, query, retries = 3) {
  for (let attempt = 1; attempt <= retries; attempt++) {
    log(`Searching for "${query}" (attempt ${attempt}/${retries})...`);

    const result = await new Promise(async (resolve) => {
      let captured = false;
      const timer = setTimeout(() => {
        page.unroute(/swiggy\.com\/api\/instamart\/search/, handler).catch(() => {});
        resolve(null);
      }, 20000);

      async function handler(route) {
        const res = await route.fetch();
        const body = await res.text();
        if (res.status() === 200 && body.length > 500 && !captured) {
          try {
            const json = JSON.parse(body);
            if (json?.data?.cards) {
              captured = true;
              clearTimeout(timer);
              page.unroute(/swiggy\.com\/api\/instamart\/search/, handler).catch(() => {});
              resolve(json);
            }
          } catch {}
        }
        await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
      }

      await page.route(/swiggy\.com\/api\/instamart\/search/, handler);

      // Navigate via homepage first to reset SPA state for subsequent searches
      if (attempt > 1 || page.url().includes('/search')) {
        await page.goto(INSTAMART_URL, { waitUntil: 'domcontentloaded', timeout: 15000 }).catch(() => {});
        await delay(1500);
      }

      await page.goto(
        `https://www.swiggy.com/instamart/search?query=${encodeURIComponent(query)}`,
        { waitUntil: 'domcontentloaded', timeout: 20000 }
      ).catch((e) => log('search nav warn:', e.message));

      await page.waitForLoadState('networkidle', { timeout: 12000 }).catch(() => {});

      // If SWG appears on the search page, a simple reload is usually sufficient
      if (!captured) {
        const hasSWG = await page.evaluate(() =>
          (document.body?.innerText || '').includes('Something went wrong')
        );
        if (hasSWG) {
          log('SWG on search page — reloading...');
          await page.reload({ waitUntil: 'domcontentloaded', timeout: 15000 }).catch(() => {});
          await page.waitForLoadState('networkidle', { timeout: 10000 }).catch(() => {});
        }
      }

      if (!captured) await delay(3000);

      if (!captured) {
        clearTimeout(timer);
        await page.unroute(/swiggy\.com\/api\/instamart\/search/, handler).catch(() => {});
        resolve(null);
      }
    });

    if (result) return result;
    log(`Attempt ${attempt} failed, retrying...`);
    await randDelay(2000, 3000);
  }

  throw new Error(`Search failed after ${retries} attempts`);
}

// ─── Location cache ───────────────────────────────────────────────────────────

const _storeIdCache = new Map();
const STORE_ID_TTL  = 12 * 60 * 60 * 1000; // 12 hours

function cachedStoreIds(key) {
  const e = _storeIdCache.get(key);
  if (e && Date.now() < e.expiresAt) return e;
  return null;
}
function cacheStoreIds(key, ids) {
  _storeIdCache.set(key, { ...ids, expiresAt: Date.now() + STORE_ID_TTL });
}

// ─── Public API ───────────────────────────────────────────────────────────────

/**
 * Search Instamart for a query at a given location.
 *
 * @param {string} query
 * @param {{ lat: number, lon: number, pincode?: string|number, address?: string }} location
 * @returns {Promise<NormalizedSKU[]>}
 */
async function searchInstamart(query, { lat, lon, pincode, address = '' }) {
  log(`search: "${query}" lat:${lat} lon:${lon} pincode:${pincode}`);

  const locKey = (lat != null && lon != null)
    ? `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`
    : `pincode:${pincode}`;

  try {
    const ctx = await getContext();

    // Get or create the persistent warm page
    if (!_page || _page.isClosed()) {
      _page = await ctx.newPage();
    }

    // Set location if needed (once per unique lat/lon)
    if (_locKey !== locKey) {
      const pincodeStr = String(pincode || '').trim();
      if (!pincodeStr) throw new Error('pincode required to set Instamart location');
      await setLocationByPincode(_page, pincodeStr);
      _locKey = locKey;
    } else {
      log('Location already set, re-using warm session');
    }

    // Get or extract storeIds
    let storeIds = cachedStoreIds(locKey);
    if (!storeIds) {
      storeIds = await extractStoreIds(_page, ctx);
      cacheStoreIds(locKey, storeIds);
      log('StoreIds extracted:', storeIds);
    } else {
      log('StoreIds from cache:', storeIds.storeId);
    }

    // Navigate to Instamart homepage before searching (ensures same-origin context is active)
    const currentUrl = _page.url();
    if (!currentUrl.includes('swiggy.com/instamart')) {
      log('Navigating back to Instamart before search...');
      await safeGoto(_page, INSTAMART_URL);
    }

    // Execute search by navigating to search URL and intercepting Swiggy's own API call
    const rawData = await executeSearch(_page, query);

    // Parse results (mirrors extension adapter logic)
    const rawProducts = extractProductsFromResponse(rawData);
    const normalized = [];
    rawProducts.forEach((raw, i) => {
      const mapped = mapInstamartProduct(raw);
      if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
      normalized.push(normalizeProduct(raw, 'swiggy', i + 1, () => mapped));
    });

    log(`results: ${normalized.length}`);
    return normalized;

  } catch (err) {
    log('Error:', err.message);

    // WAF/session errors → full teardown so next request re-initializes
    if (
      err.message.includes('WAF') ||
      err.message.includes('ERR_NON_2XX_3XX') ||
      err.message.includes('Something went wrong')
    ) {
      log('Resetting browser context due to error...');
      await resetAll();
    }

    throw err;
  }
}

// ─── ETA ──────────────────────────────────────────────────────────────────────

/** Walk JSON for serviceability SLA (handles API shape drift). */
function extractInstamartEtaDeep(obj, depth = 0) {
  if (depth > 28 || !obj) return null;
  if (typeof obj === 'string') {
    const m = obj.match(/\b(\d{1,2})\s*(?:min|mins|MIN|MINS)\b/i);
    if (m) {
      const n = parseInt(m[1], 10);
      if (n >= 1 && n <= 120) return { eta: n, label: `${n} min` };
    }
    return null;
  }
  if (typeof obj !== 'object') return null;
  if (Array.isArray(obj)) {
    for (const x of obj) {
      const r = extractInstamartEtaDeep(x, depth + 1);
      if (r) return r;
    }
    return null;
  }
  const sd = obj.serviceabilityDetails;
  if (sd?.sla?.value != null && sd.sla.value !== '') {
    const raw = sd.sla.value;
    const n = parseInt(String(raw).replace(/\D/g, ''), 10);
    if (!Number.isNaN(n) && n > 0) return { eta: n, label: `${String(raw).trim()} min` };
  }
  const sla = obj.sla;
  if (sla?.value != null && sla.value !== '' && (!sla.unit || String(sla.unit).toUpperCase().includes('MIN'))) {
    const n = parseInt(String(sla.value).replace(/\D/g, ''), 10);
    if (!Number.isNaN(n) && n > 0) return { eta: n, label: `${String(sla.value).trim()} min` };
  }
  for (const k of Object.keys(obj)) {
    const r = extractInstamartEtaDeep(obj[k], depth + 1);
    if (r) return r;
  }
  return null;
}

function parseEtaFromHomeResponse(json) {
  if (!json || typeof json !== 'object') return null;
  try {
    const configs = json?.data?.configs?.IM_PAGE_CONFIGS?.configInfo ?? [];
    for (const item of configs) {
      const podList = item?.card?.podDetailsList ?? [];
      const primary = podList.find(p => p.priority === 'PRIORITY_PRIMARY') ?? podList[0];
      const sla = primary?.serviceabilityDetails?.sla;
      if (sla?.value) {
        return { eta: parseInt(sla.value, 10), label: `${sla.value} min` };
      }
    }
  } catch {}
  return extractInstamartEtaDeep(json);
}

/** Swiggy often returns 200 + `{ stack, statusCode }` (error) before/alongside real home — not always Java-style `at ` traces. */
function isInstamartHomeErrorEnvelope(json) {
  if (!json || typeof json !== 'object') return false;
  if (json.data?.configs?.IM_PAGE_CONFIGS != null) return false;
  if (json.data?.configs && Object.keys(json.data.configs).length > 0) return false;
  if (typeof json.stack === 'string' && json.stack.length > 0 && json.statusCode != null && !json.data) return true;
  return false;
}

/**
 * Robust DOM ETA: stable data-testid first, then "NN mins" near Delivery, then body scan.
 * Returns early without waiting for home API when the UI already shows ETA.
 */
async function parseInstamartEtaFromDom(page) {
  return page.evaluate(() => {
    function ok(n) {
      return n >= 1 && n <= 120 ? { eta: n, label: `${n} min` } : null;
    }
    function fromText(t) {
      if (!t || typeof t !== 'string') return null;
      const m = t.match(/(\d{1,2})\s*mins?\b/i);
      if (m) return ok(parseInt(m[1], 10));
      const m2 = t.match(/\b(\d{1,2})\s*min\b/i);
      if (m2) return ok(parseInt(m2[1], 10));
      return null;
    }

    const testId = document.querySelector('[data-testid="address-name"]');
    if (testId) {
      const r = fromText(testId.textContent || '');
      if (r) return r;
      const span = testId.querySelector('span');
      if (span) {
        const r2 = fromText(span.textContent || '');
        if (r2) return r2;
      }
    }

    for (const el of document.querySelectorAll('[data-testid*="address"]')) {
      const r = fromText(el.textContent || '');
      if (r) return r;
    }

    if (document.body) {
      const head = (document.body.innerText || '').slice(0, 9000);
      const nearDelivery = head.match(/(\d{1,2})\s*mins?\b[^]{0,40}delivery/i);
      if (nearDelivery) return ok(parseInt(nearDelivery[1], 10));
    }

    const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_ELEMENT);
    let el;
    while ((el = walker.nextNode())) {
      const lab = el.getAttribute?.('aria-label') || '';
      const m = lab.match(/(\d{1,2})\s*mins?\b/i);
      if (m && lab.length < 120) return ok(parseInt(m[1], 10));
    }
    return null;
  });
}

async function parseInstamartEtaFromVisibleText(page) {
  return parseInstamartEtaFromDom(page);
}

// Singleton lock + ETA cache
let _etaInProgress = null;
let _etaCache = null; // { locKey, result, expiresAt }
const ETA_CACHE_TTL = 5 * 60 * 1000;
const ETA_CACHE_ENABLED = process.env.ETA_CACHE !== '0';

function getCachedEta(locKey) {
  if (!ETA_CACHE_ENABLED) return null;
  if (_etaCache?.locKey === locKey && Date.now() < _etaCache.expiresAt) return _etaCache.result;
  return null;
}
function setCachedEta(locKey, result) {
  if (!ETA_CACHE_ENABLED) return;
  _etaCache = { locKey, result, expiresAt: Date.now() + ETA_CACHE_TTL };
}

async function getInstamartEta({ lat, lon, pincode }) {
  if (_etaInProgress) return _etaInProgress;

  _etaInProgress = (async () => {
    log(`getEta lat:${lat} lon:${lon} pincode:${pincode}`);

    const locKey = (lat != null && lon != null)
      ? `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`
      : `pincode:${pincode}`;

    const cached = getCachedEta(locKey);
    if (cached) { log('ETA from cache'); return cached; }

    try {
      const ctx = await getContext();
      if (!_page || _page.isClosed()) _page = await ctx.newPage();

      if (_locKey !== locKey) {
        const pincodeStr = String(pincode || '').trim();
        if (!pincodeStr) throw new Error('pincode required');
        await setLocationByPincode(_page, pincodeStr);
        _locKey = locKey;
        const rightAfter = await parseInstamartEtaFromDom(_page);
        if (rightAfter) {
          setCachedEta(locKey, rightAfter);
          log(`ETA result (after location): ${rightAfter.label}`);
          return rightAfter;
        }
      }

      // Retry up to 3 times — two-step navigation avoids reload WAF token issues
      for (let attempt = 1; attempt <= 3; attempt++) {
        log(`ETA attempt ${attempt}/3`);

        const eta = await new Promise(async (resolve) => {
          let finished = false;
          const HOME_ROUTE = /swiggy\.com\/api\/instamart\/home\/v\d+/;
          const timer = setTimeout(() => {
            finish(null);
          }, 28000);

          function finish(result) {
            if (finished) return;
            finished = true;
            clearTimeout(timer);
            _page.unroute(HOME_ROUTE, handler).catch(() => {});
            resolve(result);
          }

          async function handler(route) {
            const res = await route.fetch();
            const body = await res.text();
            if (res.status() === 200 && !finished) {
              try {
                const json = JSON.parse(body);
                if (isInstamartHomeErrorEnvelope(json)) {
                  log('ETA: skipping home error payload (waiting for real home data)');
                } else {
                  const result = parseEtaFromHomeResponse(json);
                  if (result) {
                    log(`ETA: from home API (${result.label})`);
                    finish(result);
                    await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
                    return;
                  }
                  log(`ETA: parsed null (top-level keys: ${Object.keys(json || {}).join(', ')})`);
                }
              } catch {}
            }
            await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
          }

          await _page.route(HOME_ROUTE, handler);

          const u = _page.url() || '';
          if (attempt === 1) {
            if (u.includes('/instamart')) {
              const bad = await instamartPageShowsError(_page).catch(() => false);
              if (bad) {
                log('ETA: attempt 1 — reload (error UI)');
                await _page.reload({ waitUntil: 'domcontentloaded', timeout: 25000 }).catch(() => {});
              } else {
                log('ETA: attempt 1 — skip reload (UI OK), DOM + home API');
              }
            } else {
              await _page.goto('https://www.swiggy.com/', { waitUntil: 'domcontentloaded', timeout: 15000 }).catch(() => {});
              await _page.goto(INSTAMART_URL, { waitUntil: 'domcontentloaded', timeout: 20000 }).catch(() => {});
            }
          } else {
            log(`ETA: attempt ${attempt} — reload Instamart only`);
            if ((_page.url() || '').includes('/instamart')) {
              await _page.reload({ waitUntil: 'domcontentloaded', timeout: 25000 }).catch(() => {});
            } else {
              await _page.goto(INSTAMART_URL, { waitUntil: 'domcontentloaded', timeout: 20000 }).catch(() => {});
            }
          }

          await _page.waitForLoadState('domcontentloaded').catch(() => {});
          await delay(450);

          for (let i = 0; i < 28 && !finished; i++) {
            const domEta = await parseInstamartEtaFromDom(_page);
            if (domEta) {
              log(`ETA: from DOM (${domEta.label})`);
              finish(domEta);
              break;
            }
            await delay(280);
          }

          // If DOM/API didn't finish yet, wait for home API or 28s timer (no early finish(null)).
          if (!finished) await delay(2200);
        });

        if (eta) { setCachedEta(locKey, eta); log(`ETA result: ${eta.label}`); return eta; }

        try {
          const vis = await parseInstamartEtaFromVisibleText(_page);
          if (vis) {
            setCachedEta(locKey, vis);
            log(`ETA result (visible text): ${vis.label}`);
            return vis;
          }
        } catch {}
        log(`ETA attempt ${attempt} failed`);
      }

      log('ETA: all attempts failed');
      try {
        if (_page && !_page.isClosed()) {
          const fallback = await parseInstamartEtaFromVisibleText(_page);
          if (fallback) {
            setCachedEta(locKey, fallback);
            log(`ETA result (visible text, final): ${fallback.label}`);
            return fallback;
          }
        }
      } catch {}
      return null;

    } catch (err) {
      log('ETA error:', err.message);
      return null;
    }
  })().finally(() => { _etaInProgress = null; });

  return _etaInProgress;
}

module.exports = { searchInstamart, getInstamartEta };
