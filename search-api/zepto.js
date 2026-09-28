/**
 * Zepto server-side search module.
 *
 * Flow:
 *   1. Launch headless Chromium with browser geolocation set to user's lat/lon
 *   2. Navigate to zepto.com — React app detects location, stores store_id in localStorage
 *   3. Navigate to search URL — React app POSTs to bff-gateway.zepto.com with session headers
 *   4. Intercept response via page.route(), parse products
 *
 * Session persists across searches (headless browser stays alive, location re-used).
 */

'use strict';

const { normalizeProduct } = require('./normalizer.js');

const log = (...a) => console.log('[zepto]', ...a);

const UA = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36';

const delay = ms => new Promise(r => setTimeout(r, ms));

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
    log('Launching headless Chromium...');
    const { chromium } = require('playwright');
    _browser = await chromium.launch({
      headless: false,
      args: ['--no-sandbox', '--disable-blink-features=AutomationControlled'],
    });
    _context = await _browser.newContext({
      userAgent: UA,
      viewport: { width: 1280, height: 800 },
      geolocation: { latitude: lat, longitude: lon },
      permissions: ['geolocation'],
    });
    await _context.addInitScript(() => {
      Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
    });
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

/** Per-request counter: 3× "Something went wrong" → stop (no uncertain + ETA spam). */
const MAX_ZEPTO_SWG_STRIKES = 3;
let _zeptoSwgStrikes = 0;

function resetZeptoSwgStrikes() {
  _zeptoSwgStrikes = 0;
}

/** Zepto full-page error — only match the real heading (button heuristics false-positive during SPA load). */
async function zeptoPageShowsSomethingWentWrong(page) {
  if (!page || page.isClosed()) return false;
  return page.evaluate(() =>
    (document.body?.innerText || '').toLowerCase().includes('something went wrong')
  );
}

/**
 * If the page shows "Something went wrong", reload home once (until strike limit).
 * At MAX_ZEPTO_SWG_STRIKES total detections, tear down and throw unavailable (no further ETA/search).
 */
async function ensureZeptoNotSomethingWentWrong(page) {
  if (!(await zeptoPageShowsSomethingWentWrong(page))) return;
  _zeptoSwgStrikes++;
  log(`Something went wrong (strike ${_zeptoSwgStrikes}/${MAX_ZEPTO_SWG_STRIKES})`);
  if (_zeptoSwgStrikes >= MAX_ZEPTO_SWG_STRIKES) {
    log('Zepto: max SWG strikes — stopping (unavailable)');
    await resetAll();
    throw new Error('Zepto: unavailable (SWG)');
  }
  log('Something went wrong — retrying once...');
  await page.goto('https://www.zepto.com/', {
    waitUntil: 'domcontentloaded', timeout: 30000,
  }).catch(e => log('goto warn:', e.message));
  await delay(600);
  if (!(await zeptoPageShowsSomethingWentWrong(page))) return;
  _zeptoSwgStrikes++;
  log(`Something went wrong after reload (strike ${_zeptoSwgStrikes}/${MAX_ZEPTO_SWG_STRIKES})`);
  if (_zeptoSwgStrikes >= MAX_ZEPTO_SWG_STRIKES) {
    log('Zepto: max SWG strikes — stopping (unavailable)');
    await resetAll();
    throw new Error('Zepto: unavailable (SWG)');
  }
  log('Something went wrong after retry — assuming Zepto is down, closing browser');
  await resetAll();
  throw new Error('Zepto: Something went wrong (site may be down)');
}

// ─── Location setup ───────────────────────────────────────────────────────────

async function setLocation(page, lat, lon) {
  log(`Setting location (${lat}, ${lon})...`);
  await _context.setGeolocation({ latitude: lat, longitude: lon });

  for (let attempt = 1; attempt <= 3; attempt++) {
    log(`Navigate to Zepto home (attempt ${attempt}/3)`);
    await page.goto('https://www.zepto.com/', {
      waitUntil: 'domcontentloaded', timeout: 30000,
    }).catch(e => log('goto warn:', e.message));

    await delay(500);
    await page.waitForLoadState('load').catch(() => {});
    await delay(1200);
    await ensureZeptoNotSomethingWentWrong(page);

    // Step 1: Click "Select Location" to open the location picker
    const openedPicker = await page.evaluate(() => {
      const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
      let node;
      while ((node = walker.nextNode())) {
        if (node.textContent.trim() === 'Select Location') {
          node.parentElement?.dispatchEvent(
            new MouseEvent('click', { bubbles: true, cancelable: true })
          );
          return true;
        }
      }
      return false;
    });

    if (openedPicker) {
      log('Clicked "Select Location"');
      await delay(450);

      // Step 2: Click "Use My Current Location" inside the picker
      const usedGeo = await page.evaluate(() => {
        const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
        let node;
        while ((node = walker.nextNode())) {
          if (node.textContent.trim() === 'Use My Current Location') {
            node.parentElement?.dispatchEvent(
              new MouseEvent('click', { bubbles: true, cancelable: true })
            );
            return true;
          }
        }
        return false;
      });

      if (usedGeo) {
        log('Clicked "Use My Current Location"');
        await delay(1200);
        await page.waitForLoadState('domcontentloaded').catch(() => {});
        await delay(400);
      }
    }

    // Poll up to ~6s — detect error page as soon as it hydrates (do not wait full poll for "min")
    let ready = false;
    let swgRecovered = false;
    for (let t = 0; t < 24; t++) {
      if (await zeptoPageShowsSomethingWentWrong(page)) {
        log('Something went wrong during location setup — reload or bail');
        await ensureZeptoNotSomethingWentWrong(page);
        swgRecovered = true;
        break;
      }
      ready = await page.evaluate(() => {
        const txt = document.body.innerText || '';
        return !txt.includes('Select Location') &&
               (txt.includes('min') || txt.includes('Search') ||
                txt.includes('Delivering') || txt.includes('Order now'));
      });
      if (ready) break;
      await delay(250);
    }

    if (ready) { log('✅ Location confirmed!'); return; }
    if (swgRecovered) {
      // ensure() already reloaded or threw; do not decrement attempt (that caused infinite attempt 1/3)
      continue;
    }
    log('Location not confirmed yet, retrying...');
    await delay(500);
  }

  log('⚠️ Location setup uncertain, proceeding anyway...');
}

// ─── Product parser ───────────────────────────────────────────────────────────

function extractZeptoProducts(json) {
  if (Array.isArray(json?.layout)) {
    const products = [];
    for (const section of json.layout) {
      if (section?.widgetId !== 'PRODUCT_GRID') continue;
      for (const item of section.data?.resolver?.data?.items || []) {
        const p = item.productResponse ?? item.product ?? item;
        if (p) products.push(p);
      }
    }
    if (products.length > 0) return products;
  }
  if (Array.isArray(json?.data?.products)) return json.data.products;
  if (Array.isArray(json?.products))       return json.products;
  if (Array.isArray(json?.data))           return json.data;
  return [];
}

function mapZeptoProduct(raw) {
  const prod    = raw.product ?? raw;
  const variant = raw.productVariant ?? raw;

  const id      = prod.id ?? raw.productId ?? raw.variantId ?? raw.id;
  const name    = prod.name ?? raw.productName ?? raw.name ?? '';
  const brand   = prod.brand ?? prod.manufacturerName ?? raw.brand ?? '';
  const packsize = variant.formattedPacksize ??
                   (variant.weightInGms ? `${variant.weightInGms} g` : '');

  // Zepto prices are in paisa — divide by 100
  const rawPrice = raw.discountedSellingPrice ?? raw.sellingPrice ??
                   variant.discountedPrice ?? raw.price ?? null;
  const price = rawPrice !== null ? rawPrice / 100 : null;
  const rawMrp = raw.mrp ?? variant.mrp ?? rawPrice;
  const mrp   = rawMrp  !== null ? rawMrp  / 100 : null;

  const images = variant.images ?? raw.images ?? raw.productImages ?? [];
  let imageUrl = '';
  if (images.length > 0) {
    if (typeof images[0] === 'string')  imageUrl = images[0];
    else if (images[0].path)            imageUrl = `https://cdn.zeptonow.com/${images[0].path}`;
    else if (images[0].url)             imageUrl = images[0].url;
  }
  if (!imageUrl) imageUrl = raw.image ?? raw.imageUrl ?? raw.thumbnail ?? '';

  const inStock = raw.outOfStock !== undefined
    ? !raw.outOfStock
    : (raw.inStock ?? raw.available ?? true);

  const deepLink = id
    ? `https://www.zepto.com/pn/${encodeURIComponent(name.toLowerCase().replace(/[^a-z0-9]+/g, '-'))}/${id}`
    : 'https://www.zepto.com';

  return { id, name, brand, price, mrp, imageUrl, inStock, deepLink, packsize };
}

// ─── ETA parser ───────────────────────────────────────────────────────────────

/** Deep walk for etaInMinutes / serviceability (BFF shape drift). */
function parseZeptoEtaDeep(obj, depth = 0) {
  if (depth > 22 || obj == null) return null;
  if (typeof obj !== 'object') return null;
  if (Array.isArray(obj)) {
    for (const x of obj) {
      const r = parseZeptoEtaDeep(x, depth + 1);
      if (r) return r;
    }
    return null;
  }
  const etaInfo = obj.etaInfo;
  if (etaInfo?.isDeliverable === false) return { unavailable: true, label: 'Unavailable' };
  if (etaInfo?.etaInMinutes != null) {
    const mins = parseInt(String(etaInfo.etaInMinutes), 10);
    if (!Number.isNaN(mins) && mins > 0) return { eta: mins, label: `${mins} min` };
  }
  if (obj.storeServiceableResponse?.serviceable === false) {
    return { unavailable: true, label: 'Unavailable' };
  }
  if (obj.etaInMinutes != null && typeof obj.etaInMinutes !== 'object') {
    const mins = parseInt(String(obj.etaInMinutes), 10);
    if (!Number.isNaN(mins) && mins > 0) return { eta: mins, label: `${mins} min` };
  }
  for (const k of Object.keys(obj)) {
    const r = parseZeptoEtaDeep(obj[k], depth + 1);
    if (r) return r;
  }
  return null;
}

function parseZeptoEta(json) {
  const serviceable = json?.storeServiceableResponse?.serviceable;
  const etaInfo     = json?.pageLayout?.header?.widget?.data?.etaInfo;
  if (serviceable === false || etaInfo?.isDeliverable === false) {
    return { unavailable: true, label: 'Unavailable' };
  }
  if (etaInfo?.etaInMinutes) {
    const mins = parseInt(etaInfo.etaInMinutes, 10);
    return { eta: mins, label: `${mins} min` };
  }
  return parseZeptoEtaDeep(json);
}

async function parseZeptoEtaFromDom(page) {
  return page.evaluate(() => {
    function ok(n) {
      return n >= 1 && n <= 120 ? { eta: n, label: `${n} min` } : null;
    }
    const t = document.body?.innerText || '';
    const m = t.match(/\b(\d{1,2})\s*mins?\b/i);
    if (m) return ok(parseInt(m[1], 10));
    const aria = document.querySelector('[aria-label*="min"]');
    if (aria) {
      const mm = (aria.getAttribute('aria-label') || '').match(/(\d{1,2})/);
      if (mm) return ok(parseInt(mm[1], 10));
    }
    return null;
  });
}

/** Matches home/layout BFF calls (not /search). */
function isZeptoEtaBffUrl(url) {
  if (!url.includes('bff-gateway.zepto.com')) return false;
  if (url.includes('/search')) return false;
  const path = url.split('?')[0];
  if (/\/(cart|checkout|payment|order)\b/i.test(path)) return false;
  return /get_page|\/layout\/|\/page\/v\d|home_page|page_init|initial_content/i.test(path);
}

// ─── Search ───────────────────────────────────────────────────────────────────

async function executeSearch(page, query, retries = 3) {
  for (let attempt = 1; attempt <= retries; attempt++) {
    log(`Searching "${query}" (attempt ${attempt}/${retries})...`);

    const result = await new Promise(async (resolve) => {
      let captured = false;
      const timer = setTimeout(() => {
        page.unroute(/bff-gateway\.zepto\.com.*\/search/, handler).catch(() => {});
        resolve(null);
      }, 20000);

      async function handler(route) {
        const res  = await route.fetch();
        const body = await res.text();
        if (res.status() === 200 && body.length > 200 && !captured) {
          try {
            const json     = JSON.parse(body);
            const products = extractZeptoProducts(json);
            if (products.length > 0) {
              captured = true;
              clearTimeout(timer);
              page.unroute(/bff-gateway\.zepto\.com.*\/search/, handler).catch(() => {});
              resolve(json);
              await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
              return;
            }
          } catch {}
        }
        await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
      }

      await page.route(/bff-gateway\.zepto\.com.*\/search/, handler);

      // Reset to home before each search attempt to avoid SPA stale state
      if (attempt > 1 || page.url().includes('/search')) {
        await page.goto('https://www.zepto.com/', {
          waitUntil: 'domcontentloaded', timeout: 15000,
        }).catch(() => {});
        await delay(1000);
        await ensureZeptoNotSomethingWentWrong(page);
      }

      await page.goto(
        `https://www.zepto.com/search?query=${encodeURIComponent(query)}`,
        { waitUntil: 'domcontentloaded', timeout: 20000 }
      ).catch(e => log('search nav warn:', e.message));

      await page.waitForLoadState('networkidle', { timeout: 10000 }).catch(() => {});

      // SWG on the search page → reload in place (keeps the route handler alive)
      if (!captured && await zeptoPageShowsSomethingWentWrong(page)) {
        log('SWG on search page — reloading...');
        await page.reload({ waitUntil: 'domcontentloaded', timeout: 15000 }).catch(() => {});
        await page.waitForLoadState('networkidle', { timeout: 10000 }).catch(() => {});
      }

      if (!captured) await delay(3000);

      if (!captured) {
        clearTimeout(timer);
        await page.unroute(/bff-gateway\.zepto\.com.*\/search/, handler).catch(() => {});
        resolve(null);
      }
    });

    if (result) return result;
    log(`Attempt ${attempt} failed, retrying...`);
  }

  throw new Error(`Zepto search failed after ${retries} attempts`);
}

// ─── Public: searchZepto ──────────────────────────────────────────────────────

async function searchZepto(query, { lat, lon } = {}) {
  if (lat == null || lon == null) throw new Error('lat/lon required for Zepto');

  const locKey = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;
  log(`search: "${query}" lat:${lat} lon:${lon}`);

  try {
    resetZeptoSwgStrikes();
    await getContext(lat, lon);
    if (!_page || _page.isClosed()) _page = await _context.newPage();

    if (_locKey !== locKey) {
      await setLocation(_page, lat, lon);
      _locKey = locKey;
    } else {
      log('Location already set, reusing session');
    }

    const rawData    = await executeSearch(_page, query);
    const rawProducts = extractZeptoProducts(rawData);

    const normalized = [];
    rawProducts.forEach((raw, i) => {
      const mapped = mapZeptoProduct(raw);
      if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
      normalized.push(normalizeProduct(raw, 'zepto', i + 1, () => mapped));
    });

    log(`results: ${normalized.length}`);
    return normalized;

  } catch (err) {
    log('Error:', err.message);
    const alreadyReset =
      err.message.includes('Something went wrong (site may be down)') ||
      err.message.includes('unavailable (SWG)');
    if (!alreadyReset) await resetAll();
    throw err;
  }
}

// ─── Public: getZeptoEta ─────────────────────────────────────────────────────

let _etaInProgress = null;
let _etaCache      = null;
const ETA_CACHE_TTL     = 5 * 60 * 1000;
const ETA_CACHE_ENABLED = process.env.ETA_CACHE !== '0';

async function getZeptoEta({ lat, lon }) {
  if (lat == null || lon == null) return null;
  if (_etaInProgress) return _etaInProgress;

  _etaInProgress = (async () => {
    const locKey = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;

    if (ETA_CACHE_ENABLED && _etaCache?.locKey === locKey && Date.now() < _etaCache.expiresAt) {
      log('ETA from cache');
      return _etaCache.result;
    }

    log(`getEta lat:${lat} lon:${lon}`);
    try {
      resetZeptoSwgStrikes();
      await getContext(lat, lon);
      if (!_page || _page.isClosed()) _page = await _context.newPage();

      if (_locKey !== locKey) {
        await setLocation(_page, lat, lon);
        _locKey = locKey;
      }

      if (_page && !_page.isClosed()) {
        await ensureZeptoNotSomethingWentWrong(_page);
      }

      for (let attempt = 1; attempt <= 2; attempt++) {
        log(`ETA attempt ${attempt}/2`);

        const eta = await new Promise((resolve, reject) => {
          let captured = false;
          const BFF_PATTERN = /bff-gateway\.zepto\.com/;
          const timer = setTimeout(() => {
            _page.unroute(BFF_PATTERN, handler).catch(() => {});
            resolve(null);
          }, 12000);

          function finish(result) {
            if (captured) return;
            captured = true;
            clearTimeout(timer);
            _page.unroute(BFF_PATTERN, handler).catch(() => {});
            resolve(result);
          }

          async function handler(route) {
            const u = route.request().url();
            if (!isZeptoEtaBffUrl(u)) {
              await route.continue();
              return;
            }
            const res  = await route.fetch();
            const body = await res.text();
            if (res.status() === 200 && body.length > 50 && !captured) {
              try {
                const json   = JSON.parse(body);
                const result = parseZeptoEta(json);
                if (result) {
                  finish(result);
                  await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
                  return;
                }
              } catch {}
            }
            await route.fulfill({ status: res.status(), headers: res.headers(), body }).catch(() => {});
          }

          (async () => {
            try {
              await _page.route(BFF_PATTERN, handler);
              await _page.goto('https://www.zepto.com/', {
                waitUntil: 'domcontentloaded', timeout: 20000,
              }).catch(() => {});
              await _page.waitForLoadState('domcontentloaded').catch(() => {});
              await delay(400);

              await ensureZeptoNotSomethingWentWrong(_page);

              for (let i = 0; i < 28 && !captured; i++) {
                const domEta = await parseZeptoEtaFromDom(_page);
                if (domEta) {
                  log(`ETA: from DOM (${domEta.label})`);
                  finish(domEta);
                  break;
                }
                await delay(200);
              }
              if (!captured) await delay(900);

              if (!captured) {
                clearTimeout(timer);
                await _page.unroute(BFF_PATTERN, handler).catch(() => {});
                resolve(null);
              }
            } catch (e) {
              clearTimeout(timer);
              if (_page) await _page.unroute(BFF_PATTERN, handler).catch(() => {});
              reject(e);
            }
          })();
        });

        if (eta) {
          if (ETA_CACHE_ENABLED) _etaCache = { locKey, result: eta, expiresAt: Date.now() + ETA_CACHE_TTL };
          log(`ETA result: ${eta.label}`);
          return eta;
        }
        log(`ETA attempt ${attempt} got no result, retrying...`);
      }

      log('ETA: no result after attempts');
      return null;
    } catch (err) {
      if (err.message.includes('unavailable (SWG)')) {
        log('ETA: Zepto unavailable (SWG limit)');
        return { unavailable: true, label: 'Unavailable' };
      }
      log('ETA error:', err.message);
      return null;
    }
  })().finally(() => { _etaInProgress = null; });

  return _etaInProgress;
}

module.exports = { searchZepto, getZeptoEta };
