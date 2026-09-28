/**
 * Flipkart Minutes search module.
 *
 * Flow:
 *   1. Launch headed Chromium with browser geolocation set to user's lat/lon
 *   2. Navigate to flipkart-minutes-store → "Select delivery address" dialog appears
 *   3. Click "Use my current location" → Flipkart confirms location via browser geolocation
 *   4. Navigate to search URL, intercept Rome API response (page/fetch)
 *   5. Parse products from Rome API slots → NormalizedSKU[]
 *
 * Session is persisted across searches (browser stays open, location re-used).
 */

'use strict';

const fs = require('fs').promises;
const path = require('path');

const { normalizeProduct } = require('./normalizer.js');

const ROME_PAGE_FETCH_URL =
  'https://2.rome.api.flipkart.com/api/4/page/fetch?cacheFirst=false';
const FLIPKART_SESSION_PATH = path.join(__dirname, '.session-cache', 'flipkart-cookies.json');

const log = (...a) => console.log('[flipkart]', ...a);

const UA = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36';

const delay = (ms) => new Promise(r => setTimeout(r, ms));
const randDelay = (lo, hi) => delay(Math.floor(Math.random() * (hi - lo + 1)) + lo);

// ─── Singleton browser ────────────────────────────────────────────────────────

let _browser  = null;
let _context  = null;
let _page     = null;
let _locKey   = null;
let _initProm = null;

async function getContext(lat, lon) {
  if (_context) return _context;
  if (_initProm) return _initProm;

  _initProm = (async () => {
    log('Launching headed Chromium...');
    const { chromium } = require('playwright');
    _browser = await chromium.launch({
      headless: false,
      args: ['--no-sandbox', '--disable-blink-features=AutomationControlled'],
    });
    _context = await _browser.newContext({
      userAgent: UA,
      viewport: { width: 1280, height: 800 },
      geolocation: (lat != null && lon != null) ? { latitude: lat, longitude: lon } : undefined,
      permissions: ['geolocation'],
    });
    await _context.addInitScript(() => {
      Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
    });
    await loadSavedCookiesIfAny(_context);
    _initProm = null;
    return _context;
  })();

  return _initProm;
}

async function resetAll() {
  _locKey = null; _page = null; _initProm = null;
  try { await _context?.close(); } catch {}
  try { await _browser?.close(); } catch {}
  _context = null; _browser = null;
}

// ─── Location setup via "Use my current location" ────────────────────────────

/** Set Minutes location. Pass `context` for isolated ETA runs; `saveSession` for search-only cookie cache. */
async function setLocation(page, lat, lon, opts = {}) {
  const ctx = opts.context ?? _context;
  const saveSession = opts.saveSession !== false;

  log(`Setting location via geolocation (${lat}, ${lon})...`);

  await ctx.setGeolocation({ latitude: lat, longitude: lon });

  for (let attempt = 1; attempt <= 4; attempt++) {
    log(`Navigate to Flipkart Minutes (attempt ${attempt}/4)`);
    await page.goto(
      'https://www.flipkart.com/flipkart-minutes-store?marketplace=HYPERLOCAL',
      { waitUntil: 'domcontentloaded', timeout: 30000 }
    ).catch(e => log('goto warn:', e.message));

    await randDelay(2000, 3000);

    // Click "Use my current location" — use TreeWalker to find the exact text node,
    // then dispatchEvent with bubbles:true to hit React's synthetic event handler.
    const clicked = await page.evaluate(() => {
      const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
      let node;
      while ((node = walker.nextNode())) {
        if (node.textContent.trim() === 'Use my current location') {
          // Dispatch once on the direct parent — bubbles:true propagates to
          // React's root listener without risk of double-firing
          node.parentElement?.dispatchEvent(
            new MouseEvent('click', { bubbles: true, cancelable: true })
          );
          return true;
        }
      }
      return false;
    });

    if (clicked) {
      log('Clicked "Use my current location"');
      // Wait for Flipkart to reverse-geocode and potentially show a confirm step
      await randDelay(3000, 4000);

      // Some Flipkart flows show a secondary confirm button after detecting location
      const confirmed2 = await page.evaluate(() => {
        const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
        let node;
        while ((node = walker.nextNode())) {
          const txt = node.textContent.trim();
          if (/^(confirm location|use this location|deliver here|confirm)$/i.test(txt)) {
            node.parentElement?.dispatchEvent(
              new MouseEvent('click', { bubbles: true, cancelable: true })
            );
            return txt;
          }
        }
        return null;
      });
      if (confirmed2) log(`Clicked secondary confirm: "${confirmed2}"`);

      await randDelay(2000, 3000);
      await page.waitForLoadState('networkidle', { timeout: 15000 }).catch(() => {});
    }

    // Poll for up to 8s for the dialog to dismiss and content to appear
    let confirmed = false;
    for (let t = 0; t < 8; t++) {
      confirmed = await page.evaluate(() => {
        const body = document.body.innerText;
        return !body.includes('Select delivery address') &&
               (body.includes('min') || body.includes('Categories') || body.includes('Search'));
      });
      if (confirmed) break;
      await delay(1000);
    }

    if (confirmed) {
      log('✅ Location confirmed!');
      if (saveSession) await saveFlipkartSession(ctx).catch(() => {});
      return;
    }

    log(`Location not confirmed yet, retrying...`);
    await randDelay(2000, 3000);
  }

  log('⚠️ Could not confirm location, proceeding anyway...');
}

// ─── Product parser (mirrors extension adapters/flipkart.js) ──────────────────

function extractProductsFromHtml(html) {
  const marker = 'window.__INITIAL_STATE__ = ';
  const markerIdx = html.indexOf(marker);
  if (markerIdx === -1) return [];

  const jsonStart = html.indexOf('{', markerIdx + marker.length);
  const scriptEnd = html.indexOf('</script>', jsonStart);
  if (jsonStart === -1 || scriptEnd === -1) return [];

  let state;
  try {
    state = JSON.parse(html.slice(jsonStart, scriptEnd).replace(/;\s*$/, '').trim());
  } catch { return []; }

  const slots = state?.multiWidgetState?.widgetsData?.slots ?? [];
  return extractFromSlots(slots);
}

function extractFromRomeResponse(json) {
  const slots = json?.RESPONSE?.slots ?? [];
  return extractFromSlots(slots);
}

function extractFromSlots(slots) {
  const rawProducts = [];
  for (const slot of slots) {
    // Rome API shape
    const products = slot?.widget?.data?.products ||
                     slot?.slotData?.widget?.data?.products;
    if (!Array.isArray(products)) continue;

    for (const product of products) {
      const v = product?.productInfo?.value;
      if (!v?.id || !v?.titles?.title) continue;

      const prices = Array.isArray(v.pricing?.prices) ? v.pricing.prices : [];
      const mrpEntry = prices.find(p => p.priceType === 'MRP');
      const sellingPrice = v.pricing?.finalPrice?.value
        ?? prices.find(p => p.priceType === 'FSP')?.value ?? null;

      const rawImgUrl = v.media?.images?.[0]?.url ?? '';
      const imageUrl = rawImgUrl
        .replace('{@width}', '300').replace('{@height}', '300').replace('{@quality}', '90');

      rawProducts.push({
        id:       v.id,
        name:     v.titles.title,
        brand:    v.titles.superTitle ?? '',
        packsize: v.titles.subtitle   ?? '',
        price:    sellingPrice,
        mrp:      mrpEntry?.value ?? sellingPrice,
        imageUrl,
        inStock:  v.availability?.displayState === 'IN_STOCK',
        productUrl: v.productUrl ?? '',
      });
    }
  }
  return rawProducts;
}

function mapFlipkartProduct(raw) {
  const deepLink = raw.productUrl
    ? `https://www.flipkart.com${raw.productUrl}`
    : 'https://www.flipkart.com/flipkart-minutes-store?marketplace=HYPERLOCAL';
  return {
    id: raw.id ?? '', name: raw.name ?? '', brand: raw.brand ?? '',
    packsize: raw.packsize ?? '',
    price:  typeof raw.price  === 'number' ? raw.price  : null,
    mrp:    typeof raw.mrp    === 'number' ? raw.mrp    : null,
    imageUrl: raw.imageUrl ?? '', inStock: raw.inStock ?? true, deepLink,
  };
}

// ─── Rome page/fetch (ETA) — 2.rome.api.flipkart.com ───────────────────────────

function cookiesToHeader(cookies) {
  if (!Array.isArray(cookies)) return '';
  return cookies.map((c) => `${c.name}=${c.value}`).join('; ');
}

async function loadSavedCookiesIfAny(context) {
  try {
    const raw = await fs.readFile(FLIPKART_SESSION_PATH, 'utf8');
    const parsed = JSON.parse(raw);
    if (Array.isArray(parsed) && parsed.length) await context.addCookies(parsed);
  } catch {}
}

async function saveFlipkartSession(context) {
  try {
    await fs.mkdir(path.dirname(FLIPKART_SESSION_PATH), { recursive: true });
    const cookies = await context.cookies();
    await fs.writeFile(FLIPKART_SESSION_PATH, JSON.stringify(cookies, null, 2), 'utf8');
    log('Saved Flipkart session cookies to .session-cache/');
  } catch (e) {
    log('saveFlipkartSession:', e.message);
  }
}

function buildRomeLocationContext(pincode, lat, lon) {
  const pin =
    pincode != null && String(pincode).trim() !== ''
      ? parseInt(String(pincode).replace(/\D/g, ''), 10)
      : NaN;
  if (!Number.isNaN(pin) && pin > 0) return { pincode: pin, changed: false };
  if (typeof lat === 'number' && typeof lon === 'number') {
    return { lat, lng: lon, changed: false };
  }
  return { changed: false };
}

function buildRomePageFetchBody(pincode, lat, lon) {
  return {
    pageUri: '/flipkart-minutes-store?marketplace=HYPERLOCAL',
    pageContext: {
      trackingContext: {},
      fetchSeoData: true,
      networkSpeed: 10000,
    },
    locationContext: buildRomeLocationContext(pincode, lat, lon),
  };
}

async function readFlipkartCookieHeaderForDirectFetch() {
  const env = process.env.FLIPKART_COOKIE;
  if (env && String(env).trim()) return String(env).trim();
  try {
    const raw = await fs.readFile(FLIPKART_SESSION_PATH, 'utf8');
    const parsed = JSON.parse(raw);
    const h = cookiesToHeader(parsed);
    return h || '';
  } catch {
    return '';
  }
}

async function tryFlipkartEtaDirectFetch(lat, lon, pincode) {
  const cookie = await readFlipkartCookieHeaderForDirectFetch();
  if (!cookie) return null;

  const body = buildRomePageFetchBody(pincode, lat, lon);
  const lc = body.locationContext;
  if (!lc.pincode && (lc.lat == null || lc.lng == null)) return null;

  const headers = {
    Accept: '*/*',
    'Accept-Language': 'en-GB,en;q=0.9',
    'Content-Type': 'application/json',
    Origin: 'https://www.flipkart.com',
    Referer: 'https://www.flipkart.com/',
    'Sec-Fetch-Dest': 'empty',
    'Sec-Fetch-Mode': 'cors',
    'Sec-Fetch-Site': 'same-site',
    'User-Agent': UA,
    'X-User-Agent': `${UA} FKUA/msite/0.0.4/msite/Mobile`,
    flipkart_secure: 'true',
    Cookie: cookie,
  };

  try {
    const res = await fetch(ROME_PAGE_FETCH_URL, {
      method: 'POST',
      headers,
      body: JSON.stringify(body),
    });
    const text = await res.text();
    if (res.status !== 200) {
      log(`Rome direct fetch: HTTP ${res.status}`);
      return null;
    }
    const json = JSON.parse(text);
    return parseFlipkartEta(json);
  } catch (e) {
    log('Rome direct fetch error:', e.message);
    return null;
  }
}

// ─── Search via page navigation + DOM state ───────────────────────────────────
//
// Flipkart Minutes is a CSR SPA. After navigation and React hydration we read
// window.__INITIAL_STATE__ from the JS context and also check the DOM for the
// closed-store state. We do a single attempt (no retries on closed/no-session)
// to avoid 3× slow timeouts when Flipkart requires a logged-in session.

async function executeSearch(page, query, retries = 3) {
  const searchUrl = `https://www.flipkart.com/search?q=${encodeURIComponent(query)}&marketplace=HYPERLOCAL`;

  // Check current store home page state before searching
  // (setLocation leaves the browser on the store home)
  const storeHomeText = await page.evaluate(() => (document.body?.innerText || '').slice(0, 5000));
  if (/closed for the day|back at \d+\s*am/i.test(storeHomeText)) {
    log('Store is closed for the day — skipping search');
    return [];
  }
  // If the page shows generic marketing/SEO content, the session lacks a real
  // HYPERLOCAL login. Fail immediately rather than retrying 3 times.
  if (/shop for instant satisfaction with flipkart minutes/i.test(storeHomeText)) {
    log('Flipkart shows marketing page — HYPERLOCAL search requires a logged-in session');
    throw new Error('Flipkart: HYPERLOCAL search requires a logged-in Flipkart session');
  }

  for (let attempt = 1; attempt <= retries; attempt++) {
    log(`Searching "${query}" (attempt ${attempt}/${retries})...`);

    // Reset to store home before each retry; re-check closed state
    if (attempt > 1 || page.url().includes('/search')) {
      await page.goto(
        'https://www.flipkart.com/flipkart-minutes-store?marketplace=HYPERLOCAL',
        { waitUntil: 'domcontentloaded', timeout: 15000 }
      ).catch(() => {});
      await delay(1500);
      const storeText = await page.evaluate(() => (document.body?.innerText || '').slice(0, 5000));
      if (/closed for the day|back at \d+\s*am|store.*closed/i.test(storeText)) {
        log('Store is closed for the day — skipping search');
        return [];
      }
    }

    // Register a response listener for the Rome API (fires if products are fetched CSR)
    const romePromise = page.waitForResponse(
      res => /flipkart\.com\/api\/4\/page\/fetch/.test(res.url()) && res.status() === 200,
      { timeout: 18000 }
    ).catch(() => null);

    await page.goto(searchUrl, { waitUntil: 'domcontentloaded', timeout: 20000 })
      .catch(e => log('search nav warn:', e.message));

    await page.waitForLoadState('networkidle', { timeout: 15000 }).catch(() => {});
    await delay(1500);

    // Check DOM text for closed-store state (only visible after React hydrates)
    const pageText = await page.evaluate(() => (document.body?.innerText || '').slice(0, 5000));
    if (/closed for the day|back at \d+\s*am|store.*closed/i.test(pageText)) {
      log('Store is closed for the day — no products available');
      return [];
    }

    // Try window.__INITIAL_STATE__ from the JS context (populated after hydration)
    const stateJson = await page.evaluate(() => {
      try { return window.__INITIAL_STATE__ ? JSON.stringify(window.__INITIAL_STATE__) : null; }
      catch { return null; }
    });
    if (stateJson) {
      try {
        const state = JSON.parse(stateJson);
        const slots = state?.multiWidgetState?.widgetsData?.slots ?? [];
        const products = extractFromSlots(slots);
        if (products.length > 0) {
          log(`Found ${products.length} products from window.__INITIAL_STATE__`);
          return products;
        }
      } catch {}
    }

    // Fall back: check if the Rome API response had products
    const romeRes = await romePromise;
    if (romeRes) {
      try {
        const json = await romeRes.json();
        const products = extractFromRomeResponse(json);
        if (products.length > 0) {
          log(`Found ${products.length} products from Rome API`);
          return products;
        }
      } catch {}
    }

    log(`Attempt ${attempt}: no products found (session may require Flipkart login)`);
    if (attempt < retries) await randDelay(2000, 3000);
  }

  throw new Error(`Flipkart search failed after ${retries} attempts`);
}

// ─── Public API ───────────────────────────────────────────────────────────────

async function searchFlipkart(query, { lat, lon, pincode } = {}) {
  log(`search: "${query}" lat:${lat} lon:${lon} pincode:${pincode}`);

  // Need at least lat/lon for geolocation-based location
  if (lat == null || lon == null) {
    throw new Error('lat/lon required for Flipkart Minutes location');
  }

  const locKey = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;

  try {
    await getContext(lat, lon);

    if (!_page || _page.isClosed()) {
      _page = await _context.newPage();
    }

    if (_locKey !== locKey) {
      await setLocation(_page, lat, lon);
      _locKey = locKey;
    } else {
      log('Location already set, reusing session');
    }

    const rawProducts = await executeSearch(_page, query);

    const normalized = [];
    rawProducts.forEach((raw, i) => {
      const mapped = mapFlipkartProduct(raw);
      if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
      normalized.push(normalizeProduct(raw, 'flipkart', i + 1, () => mapped));
    });

    log(`results: ${normalized.length}`);
    return normalized;

  } catch (err) {
    log('Error:', err.message);
    await resetAll();
    throw err;
  }
}

// ─── ETA ──────────────────────────────────────────────────────────────────────

function findEtaMinutes(obj, depth = 0) {
  if (depth > 22 || !obj || typeof obj !== 'object') return null;
  if (Array.isArray(obj)) {
    for (const item of obj) {
      const f = findEtaMinutes(item, depth + 1);
      if (f != null) return f;
    }
    return null;
  }
  for (const [key, val] of Object.entries(obj)) {
    if (key.includes('sla_callout') && val?.value?.label_0?.value) {
      const raw = val.value.label_0.value.text;
      if (raw != null && raw !== '') {
        const n = parseInt(String(raw).replace(/[^\d]/g, ''), 10);
        if (!Number.isNaN(n) && n > 0) return n;
      }
    }
    if (val && typeof val === 'object') {
      const found = findEtaMinutes(val, depth + 1);
      if (found != null) return found;
    }
  }
  return null;
}

function parseFlipkartEta(json) {
  const pageTitle = json?.RESPONSE?.pageData?.pageTitle ?? '';
  if (pageTitle.toLowerCase().includes('unserviceable')) {
    return { unavailable: true, label: 'Unavailable' };
  }
  const mins = findEtaMinutes(json?.RESPONSE);
  if (mins != null && mins > 0) return { eta: mins, label: `${mins} min` };
  return null;
}

/** ETA often lives in `window.__INITIAL_STATE__` after location — not only Rome API. */
function parseEtaFromPageHtml(html) {
  const markers = ['window.__INITIAL_STATE__ = ', '__INITIAL_STATE__='];
  for (const marker of markers) {
    const markerIdx = html.indexOf(marker);
    if (markerIdx === -1) continue;
    const jsonStart = html.indexOf('{', markerIdx + marker.length);
    const scriptEnd = html.indexOf('</script>', jsonStart);
    if (jsonStart === -1 || scriptEnd === -1) continue;
    let state;
    try {
      state = JSON.parse(html.slice(jsonStart, scriptEnd).replace(/;\s*$/, '').trim());
    } catch {
      continue;
    }
    const mins = findEtaMinutes(state);
    if (mins != null && mins > 0) return { eta: mins, label: `${mins} min` };
  }
  return null;
}

function parseEtaFromNextDataHtml(html) {
  const m = html.match(/<script[^>]+id=["']__NEXT_DATA__["'][^>]*>([^<]+)<\/script>/i);
  if (!m) return null;
  try {
    const data = JSON.parse(m[1]);
    const mins = findEtaMinutes(data);
    if (mins != null && mins > 0) return { eta: mins, label: `${mins} min` };
  } catch {}
  return null;
}

/** Last resort: Rome widget JSON embedded in HTML without standard script markers. */
function parseEtaFromHtmlRawLoose(html) {
  const m = html.match(/sla_callout[^]{0,1200}?"text"\s*:\s*(\d+)/i);
  if (m) {
    const n = parseInt(m[1], 10);
    if (n > 0 && n <= 180) return { eta: n, label: `${n} min` };
  }
  return null;
}

/** Visible header text (Flipkart shows "NN min" — state may not expose __INITIAL_STATE__). */
async function parseFlipkartEtaFromVisibleText(page) {
  const text = await page.evaluate(() => document.body?.innerText || '');
  const head = text.slice(0, 4500);
  const patterns = [
    /\b(\d{1,2})\s*min\b/i,
    /delivery\s+in\s+(\d{1,2})\s*min/i,
    /(\d{1,2})\s*minutes?\b/i,
  ];
  for (const re of patterns) {
    const m = head.match(re);
    if (m) {
      const n = parseInt(m[1], 10);
      if (n >= 1 && n <= 120) return { eta: n, label: `${n} min` };
    }
  }
  return null;
}

/**
 * DOM layout often splits "6" and "min" across sibling divs (no stable classes). Detect that + normal "NN min" text.
 */
async function parseFlipkartEtaFromDom(page) {
  return page.evaluate(() => {
    function ok(n) {
      return n >= 1 && n <= 120 ? { eta: n, label: `${n} min` } : null;
    }
    const head = (document.body?.innerText || '').slice(0, 7000);
    const m0 = head.match(/\b(\d{1,2})\s*min\b/i);
    if (m0) return ok(parseInt(m0[1], 10));

    const candidates = document.querySelectorAll('div, span, section, header');
    for (const el of candidates) {
      const ch = el.children;
      if (!ch || ch.length < 2) continue;
      for (let i = 0; i < ch.length - 1; i++) {
        const a = (ch[i].textContent || '').trim();
        const b = (ch[i + 1].textContent || '').trim();
        if (/^\d{1,2}$/.test(a) && /^min$/i.test(b)) return ok(parseInt(a, 10));
      }
    }

    for (const el of candidates) {
      if (el.children && el.children.length >= 2) {
        const parts = [...el.children].map((c) => (c.textContent || '').trim()).filter(Boolean);
        for (let i = 0; i < parts.length - 1; i++) {
          if (/^\d{1,2}$/.test(parts[i]) && /^min$/i.test(parts[i + 1])) return ok(parseInt(parts[i], 10));
        }
      }
    }

    for (const el of document.querySelectorAll('[aria-label]')) {
      const lab = el.getAttribute('aria-label') || '';
      const m = lab.match(/\b(\d{1,2})\s*min\b/i);
      if (m) return ok(parseInt(m[1], 10));
    }
    return null;
  });
}

let _etaInProgress = null;
let _etaCache = null; // { locKey, result, expiresAt }
const ETA_CACHE_TTL = 5 * 60 * 1000;
const ETA_CACHE_ENABLED = process.env.ETA_CACHE !== '0';

async function getFlipkartEta({ lat, lon, pincode } = {}) {
  if (lat == null || lon == null) return null;
  if (_etaInProgress) return _etaInProgress;

  _etaInProgress = (async () => {
    const locKey = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;

    if (ETA_CACHE_ENABLED && _etaCache?.locKey === locKey && Date.now() < _etaCache.expiresAt) {
      log('ETA from cache');
      return _etaCache.result;
    }

    log(`getEta lat:${lat} lon:${lon} pincode:${pincode ?? 'n/a'}`);

    try {
      // 1) Direct curl-style fetch (saved cookies or FLIPKART_COOKIE env)
      const direct = await tryFlipkartEtaDirectFetch(lat, lon, pincode);
      if (direct) {
        if (ETA_CACHE_ENABLED) _etaCache = { locKey, result: direct, expiresAt: Date.now() + ETA_CACHE_TTL };
        log(`ETA result (direct Rome): ${direct.label}`);
        return direct;
      }

      // 2) Fresh browser each time: after first location set, Flipkart often does not call Rome ETA again;
      //    ETA is embedded in __INITIAL_STATE__ / DOM. Reused singleton sessions miss that.
      log('ETA: launching fresh browser context');
      const { chromium } = require('playwright');
      const browser = await chromium.launch({
        headless: false,
        args: ['--no-sandbox', '--disable-blink-features=AutomationControlled'],
      });
      const context = await browser.newContext({
        userAgent: UA,
        viewport: { width: 1280, height: 800 },
        geolocation: { latitude: lat, longitude: lon },
        permissions: ['geolocation'],
      });
      await context.addInitScript(() => {
        Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
      });
      const page = await context.newPage();

      const romePromise = page
        .waitForResponse(
          (r) => r.url().includes('/api/4/page/fetch') && r.status() === 200,
          { timeout: 90000 }
        )
        .catch(() => null);

      try {
        await setLocation(page, lat, lon, { context, saveSession: false });
        await delay(1500);

        const html = await page.content();

        // DOM first (split "6" + "min" siblings, aria-label); then full text; then embedded JSON; then Rome.
        let eta = await parseFlipkartEtaFromDom(page);
        if (!eta) eta = await parseFlipkartEtaFromVisibleText(page);
        if (!eta) eta = parseEtaFromPageHtml(html);
        if (!eta) eta = parseEtaFromNextDataHtml(html);
        if (!eta) eta = parseEtaFromHtmlRawLoose(html);
        if (!eta) {
          const sj = await page.evaluate(() => {
            try {
              return JSON.stringify(window.__INITIAL_STATE__ || null);
            } catch {
              return null;
            }
          });
          if (sj) {
            try {
              const state = JSON.parse(sj);
              const mins = findEtaMinutes(state);
              if (mins != null && mins > 0) eta = { eta: mins, label: `${mins} min` };
            } catch {}
          }
        }
        if (!eta) {
          const resp = await romePromise;
          if (resp) {
            try {
              eta = parseFlipkartEta(await resp.json());
            } catch (e) {
              log('ETA: Rome response parse:', e.message);
            }
          }
        }

        if (eta) {
          if (ETA_CACHE_ENABLED) _etaCache = { locKey, result: eta, expiresAt: Date.now() + ETA_CACHE_TTL };
          log(`ETA result: ${eta.label}`);
          return eta;
        }
        log('ETA: could not read minutes from page state or Rome response');
        return null;
      } finally {
        await browser.close().catch(() => {});
      }
    } catch (err) {
      log('ETA error:', err.message);
      return null;
    }
  })().finally(() => { _etaInProgress = null; });

  return _etaInProgress;
}

module.exports = {
  searchFlipkart,
  getFlipkartEta,
  /** Exposed for scripts/tests — parses Rome page/fetch JSON */
  parseFlipkartEta,
};
