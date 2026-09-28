/**
 * Blinkit server-side search module.
 *
 * Flow:
 *   1. Launch headless Chromium with browser geolocation set to user's lat/lon
 *   2. Navigate to blinkit.com — React app reads geolocation, sends lat/lon in all API headers
 *   3. Navigate to search URL — React app POSTs to blinkit.com/v1/layout/search
 *   4. Intercept response via page.route(), parse products
 *
 * Session persists across searches (headless browser stays alive, location re-used).
 */

'use strict';

const { normalizeProduct } = require('./normalizer.js');

const log = (...a) => console.log('[blinkit]', ...a);

const UA = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36';

const delay = ms => new Promise(r => setTimeout(r, ms));

// ─── Singleton browser ────────────────────────────────────────────────────────

let _browser    = null;
let _context    = null;
let _page       = null;
let _locKey     = null;
let _initProm   = null;
let _capturedEta = null; // ETA result captured during setLocation

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
  _locKey = null; _page = null; _initProm = null; _capturedEta = null;
  try { await _context?.close(); } catch {}
  try { await _browser?.close(); } catch {}
  _context = null; _browser = null;
}

// ─── Location setup ───────────────────────────────────────────────────────────
// After geolocation + "Detect my location", Blinkit GETs /v1/consumerweb/eta.
// We wait for that HTTP response (same as Network tab) — no route.fetch() so
// the browser sends the real headers/cookies Blinkit expects.

function isBlinkitEtaUrl(url) {
  try {
    const u = url || '';
    return /blinkit\.com\/.+\/consumerweb\/eta/i.test(u) || u.includes('/consumerweb/eta');
  } catch {
    return false;
  }
}

/** Register before the action that triggers the ETA request; await after. */
function waitForEtaHttp200(page, timeoutMs = 35000) {
  return page.waitForResponse(
    (res) => isBlinkitEtaUrl(res.url()) && res.status() === 200,
    { timeout: timeoutMs }
  );
}

async function setLocation(page, lat, lon) {
  log(`Setting location (${lat}, ${lon})...`);
  await _context.setGeolocation({ latitude: lat, longitude: lon });
  _capturedEta = null;

  for (let attempt = 1; attempt <= 4; attempt++) {
    log(`Navigate to Blinkit home (attempt ${attempt}/4)`);

    await page.goto('https://blinkit.com/', {
      waitUntil: 'domcontentloaded', timeout: 30000,
    }).catch(e => log('goto warn:', e.message));

    await delay(2000);

    // Register before any action that triggers GET …/consumerweb/eta (Network tab).
    const etaPromise = waitForEtaHttp200(page, 35000);

    const clicked = await page.evaluate(() => {
      const labels = ['Detect my location', 'Use current location', 'Detect location'];
      const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
      let node;
      while ((node = walker.nextNode())) {
        const t = node.textContent.trim();
        if (labels.some((l) => t === l || (l.length > 8 && t.includes(l)))) {
          const el = node.parentElement;
          if (el) {
            el.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true }));
            return true;
          }
        }
      }
      return false;
    });

    if (clicked) {
      log('Clicked location-detect control');
    } else {
      log('No detect button — reloading (ETA may still fire with geolocation)');
      await page.reload({ waitUntil: 'domcontentloaded', timeout: 25000 }).catch(e => log('reload warn:', e.message));
      await delay(2500);
    }

    try {
      const res = await etaPromise;
      const body = await res.text();
      log(`ETA response ${res.status()} len=${body.length} snippet=${body.slice(0, 160)}`);
      let json;
      try {
        json = JSON.parse(body);
      } catch {
        log('ETA: non-JSON body');
      }
      if (json) {
        const parsed = parseBlinkitEta(json);
        if (parsed) _capturedEta = parsed;
      }
    } catch (e) {
      log(`ETA wait failed: ${e.message}`);
    }

    if (_capturedEta) log(`ETA captured during setLocation: ${_capturedEta.label}`);

    let ready = false;
    for (let t = 0; t < 3; t++) {
      ready = await page.evaluate(() => {
        const txt = document.body.innerText || '';
        return !txt.includes('Detect my location') &&
               (txt.includes('min') || txt.includes('Search for') ||
                txt.includes('Delivering') || txt.includes('Groceries'));
      });
      if (ready) break;
      await delay(1000);
    }

    if (ready) { log('✅ Location confirmed!'); return; }
    log('Location not confirmed yet, retrying...');
    await delay(1000);
  }

  log('⚠️ Location setup uncertain, proceeding anyway...');
}

// ─── Product parser ───────────────────────────────────────────────────────────

function extractBlinkitProducts(json) {
  if (json?.is_success && Array.isArray(json?.response?.snippets)) {
    const products = [];
    for (const snippet of json.response.snippets) {
      if (snippet?.data?.identity?.id && snippet?.data?.name?.text) {
        products.push(snippet.data);
      }
    }
    if (products.length > 0) return products;
  }
  return [];
}

function mapBlinkitProduct(raw) {
  const id      = raw.identity?.id ?? raw.id;
  const name    = raw.name?.text ?? '';
  const brand   = raw.atc_action?.add_to_cart?.cart_item?.brand ?? '';
  const packsize = raw.variant?.text ?? '';

  const rawPrice = raw.normal_price?.text ?? '';
  const price    = rawPrice ? parseFloat(rawPrice.replace(/[^0-9.]/g, '')) : null;
  const rawMrp   = raw.mrp?.text ?? '';
  const mrp      = rawMrp ? parseFloat(rawMrp.replace(/[^0-9.]/g, '')) : price;

  const imageUrl = raw.image?.url ?? '';
  const inStock  = !raw.is_sold_out && (raw.inventory > 0 || raw.inventory === undefined);
  const deepLink = `https://blinkit.com/prn/${encodeURIComponent(name.toLowerCase().replace(/[^a-z0-9]+/g, '-'))}/prid/${id}`;

  return { id, name, brand, price, mrp, imageUrl, packsize, inStock, deepLink };
}

// ─── ETA parser ───────────────────────────────────────────────────────────────

function parseBlinkitEta(json) {
  if (!json || typeof json !== 'object') return null;
  let mins =
    json.eta_in_minutes ??
    json.response?.eta_in_minutes ??
    json.data?.eta_in_minutes ??
    json.response?.data?.eta_in_minutes;
  if (mins == null && typeof json.title === 'string') {
    const m = json.title.match(/(\d+)\s*min/i);
    if (m) mins = parseInt(m[1], 10);
  }
  if (mins == null && typeof json.subtitle === 'string') {
    const m = json.subtitle.match(/(\d+)\s*min/i);
    if (m) mins = parseInt(m[1], 10);
  }
  const n = mins == null ? NaN : Number(mins);
  if (!Number.isFinite(n)) return { unavailable: true, label: 'Unavailable' };
  return { eta: n, label: `${n} min` };
}

// ─── Search ───────────────────────────────────────────────────────────────────

async function executeSearch(page, query, retries = 3) {
  for (let attempt = 1; attempt <= retries; attempt++) {
    log(`Searching "${query}" (attempt ${attempt}/${retries})...`);

    // Reset to home before each attempt to clear SPA state
    if (attempt > 1 || page.url().includes('/s/')) {
      await page.goto('https://blinkit.com/', {
        waitUntil: 'domcontentloaded', timeout: 15000,
      }).catch(() => {});
      await delay(1000);
    }

    // Register listener BEFORE navigation so no response is missed
    const responsePromise = page.waitForResponse(
      res => /blinkit\.com\/v1\/layout\/search/.test(res.url()) && res.status() === 200,
      { timeout: 20000 }
    ).catch(() => null);

    await page.goto(
      `https://blinkit.com/s/?q=${encodeURIComponent(query)}`,
      { waitUntil: 'domcontentloaded', timeout: 20000 }
    ).catch(e => log('search nav warn:', e.message));

    await page.waitForLoadState('networkidle', { timeout: 10000 }).catch(() => {});

    const res = await responsePromise;
    if (res) {
      try {
        const body = await res.text();
        const json = JSON.parse(body);
        const products = extractBlinkitProducts(json);
        if (products.length > 0) return json;
      } catch (e) {
        log('response parse error:', e.message);
      }
    }

    log(`Attempt ${attempt} failed, retrying...`);
  }

  throw new Error(`Blinkit search failed after ${retries} attempts`);
}

// ─── Public: searchBlinkit ────────────────────────────────────────────────────

async function searchBlinkit(query, { lat, lon } = {}) {
  if (lat == null || lon == null) throw new Error('lat/lon required for Blinkit');

  const locKey = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;
  log(`search: "${query}" lat:${lat} lon:${lon}`);

  try {
    await getContext(lat, lon);
    if (!_page || _page.isClosed()) _page = await _context.newPage();

    if (_locKey !== locKey) {
      await setLocation(_page, lat, lon);
      _locKey = locKey;
    } else {
      log('Location already set, reusing session');
    }

    const rawData     = await executeSearch(_page, query);
    const rawProducts = extractBlinkitProducts(rawData);

    const normalized = [];
    rawProducts.forEach((raw, i) => {
      const mapped = mapBlinkitProduct(raw);
      if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
      normalized.push(normalizeProduct(raw, 'blinkit', i + 1, () => mapped));
    });

    log(`results: ${normalized.length}`);
    return normalized;

  } catch (err) {
    log('Error:', err.message);
    await resetAll();
    throw err;
  }
}

// ─── Public: getBlinkitEta ────────────────────────────────────────────────────

let _etaInProgress = null;
let _etaCache      = null;
const ETA_CACHE_TTL     = 5 * 60 * 1000;
const ETA_CACHE_ENABLED = process.env.ETA_CACHE !== '0';

async function getBlinkitEta({ lat, lon }) {
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
      await getContext(lat, lon);
      if (!_page || _page.isClosed()) _page = await _context.newPage();

      if (_locKey !== locKey || !_capturedEta) {
        await setLocation(_page, lat, lon);
        _locKey = locKey;
      }

      // ETA is captured from the real GET …/consumerweb/eta response during setLocation
      // naturally after "Detect my location". No separate navigation needed.
      if (_capturedEta) {
        if (ETA_CACHE_ENABLED) _etaCache = { locKey, result: _capturedEta, expiresAt: Date.now() + ETA_CACHE_TTL };
        log(`ETA result: ${_capturedEta.label}`);
        return _capturedEta;
      }

      log('ETA: not captured during setLocation');
      return null;
    } catch (err) {
      log('ETA error:', err.message);
      return null;
    }
  })().finally(() => { _etaInProgress = null; });

  return _etaInProgress;
}

module.exports = { searchBlinkit, getBlinkitEta };
