/**
 * Background service worker — the central hub of the extension.
 *
 * Responsibilities:
 *  1. Receive ZEPTO_SESSION_CAPTURED messages from content script → persist
 *  2. Route SEARCH / ADD_TO_CART / GET_CART messages from popup
 *  3. On browser startup: validate stored session, schedule silent re-auth if stale
 *  4. Expose a session-status check so popup can show "Connected / Disconnected"
 */

import { ZEPTO_CONFIG, STORAGE_KEYS, BLINKIT_CONFIG, SWIGGY_CONFIG, FLIPKART_CONFIG } from '../shared/constants.js';
import {
  getZeptoSession,
  saveZeptoSession,
  clearZeptoSession,
  getBlinkitSession,
  saveBlinkitSession,
  clearBlinkitSession,
  getInstamartSession,
  saveInstamartSession,
  clearInstamartSession,
  getFlipkartSession,
  saveFlipkartSession,
  clearFlipkartSession,
  addToCart,
  removeFromCart,
  updateCartItemQty,
  getCart,
  clearCart,
} from '../shared/storage.js';
import { searchZepto } from '../adapters/zepto.js';
import { searchBlinkit } from '../adapters/blinkit.js';
import { buildInstamartFetchArgs, parseInstamartResults } from '../adapters/instamart.js';
import { searchFlipkart } from '../adapters/flipkart.js';

// ─── Message router ──────────────────────────────────────────────────────────

chrome.runtime.onMessage.addListener((message, _sender, sendResponse) => {
  // Return true to keep the message channel open for async responses
  handleMessage(message)
    .then(sendResponse)
    .catch((err) => {
      console.error('[Quickart BG] message handler error:', err);
      sendResponse({ ok: false, error: err.message });
    });
  return true;
});

async function handleMessage(message) {
  switch (message.type) {
    case 'ZEPTO_SESSION_CAPTURED':
      return onSessionCaptured(message);

    case 'ZEPTO_SEARCH_BODY_OBSERVED':
      return onSearchBodyObserved(message);

    case 'BLINKIT_SESSION_CAPTURED':
      return onBlinkitSessionCaptured(message);

    case 'BLINKIT_SEARCH_BODY_OBSERVED':
      return onBlinkitSearchBodyObserved(message);

    case 'INSTAMART_SESSION_CAPTURED':
      return onInstamartSessionCaptured(message);

    case 'INSTAMART_SEARCH_BODY_OBSERVED':
      return onInstamartSearchBodyObserved(message);

    case 'INSTAMART_HOME_OBSERVED':
      return onInstamartHomeObserved(message);

    case 'GET_SESSION_STATUS':
      return getSessionStatus();

    case 'GET_ETA':
      return onGetEta(message);

    case 'CLEAR_SESSION':
      await clearZeptoSession();
      return { ok: true };

    case 'SEARCH':
      return onSearch(message);

    case 'ADD_TO_CART':
      return onAddToCart(message);

    case 'REMOVE_FROM_CART':
      return onRemoveFromCart(message);

    case 'UPDATE_CART_QTY':
      return onUpdateCartQty(message);

    case 'GET_CART':
      return onGetCart();

    case 'CLEAR_CART':
      await clearCart();
      return { ok: true };

    default:
      return { ok: false, error: `Unknown message type: ${message.type}` };
  }
}

// ─── Session capture ─────────────────────────────────────────────────────────

async function onSessionCaptured({ capturedAt, sessionData = {} }) {
  const cookies = await getCookiesForZepto();

  if (cookies.length === 0) {
    console.warn('[Quickart BG] No Zepto cookies found — user may not be logged in.');
    return { ok: false, error: 'No cookies found. Please log in to Zepto first.' };
  }

  const existing = await getZeptoSession() ?? {};

  // Build cookie string: merge HttpOnly cookies (from chrome.cookies API)
  // with JS-visible cookies relayed from content script
  const httpOnlyCookieStr = buildCookieString(cookies);
  const jsCookieStr = sessionData.jsCookies ?? '';
  // Merge: start with JS cookies, override/append HttpOnly ones
  const allCookieMap = new Map();
  for (const part of [...jsCookieStr.split(';'), ...httpOnlyCookieStr.split(';')]) {
    const [k, ...rest] = part.trim().split('=');
    if (k) allCookieMap.set(k.trim(), rest.join('='));
  }
  const cookieString = Array.from(allCookieMap.entries())
    .map(([k, v]) => `${k}=${v}`).join('; ');

  const session = {
    ...existing,
    cookieString,
    capturedAt,
    deviceId:  sessionData.deviceId  ?? existing.deviceId  ?? null,
    sessionId: sessionData.sessionId ?? existing.sessionId ?? null,
    storeId:   sessionData.storeId   ?? existing.storeId   ?? null,
    storeIds:  sessionData.storeIds  ?? existing.storeIds  ?? null,
    storeEtas: sessionData.storeEtas ?? existing.storeEtas ?? null,
    latitude:  sessionData.latitude  ?? existing.latitude  ?? null,
    longitude: sessionData.longitude ?? existing.longitude ?? null,
    xsrfToken: sessionData.xsrfToken ?? existing.xsrfToken ?? null,
  };

  await saveZeptoSession(session);
  console.log('[Quickart BG] Session captured. Keys from localStorage:', {
    deviceId: !!session.deviceId,
    sessionId: !!session.sessionId,
    storeId: !!session.storeId,
    csrfSecret: !!session.csrfSecret,
    xsrfToken: !!session.xsrfToken,
    cookies: cookies.length,
  });
  return { ok: true };
}

async function onSearchBodyObserved({ body, headers, capturedAt }) {
  const session = await getZeptoSession();
  if (!session) return { ok: false };

  console.log('[Quickart BG] Search body observed:', body);
  console.log('[Quickart BG] Search headers observed:', headers);

  // Extract location fields from the body
  if (body) {
    session.latitude  = body.latitude  ?? body.lat  ?? session.latitude;
    session.longitude = body.longitude ?? body.lng  ?? session.longitude;
    session.storeId   = body.storeId   ?? body.store_id ?? body.storeId ?? session.storeId;
    session.observedSearchBody = body;
  }

  // Store non-auth headers (x-app-version, x-channel, x-store-id, etc.)
  // These are required by Zepto even though auth is via cookies.
  if (headers && Object.keys(headers).length > 0) {
    session.extraHeaders = headers;
    
    // Aggressively extract critical keys from the real headers in case localStorage parsing failed
    session.sessionId = headers['session_id'] ?? session.sessionId;
    session.deviceId = headers['device_id'] ?? session.deviceId;
    session.storeId = headers['store_id'] ?? session.storeId;
    session.csrfSecret = headers['x-csrf-secret'] ?? session.csrfSecret;
    session.xsrfToken = headers['x-xsrf-token'] ?? session.xsrfToken;
    session.xTimezone = headers['x-timezone'] ?? session.xTimezone;
    if (headers['store_ids']) session.storeIds = headers['store_ids'];
    if (headers['store_etas']) {
      try {
        session.storeEtas = typeof headers['store_etas'] === 'string' 
          ? JSON.parse(headers['store_etas']) 
          : headers['store_etas'];
      } catch (e) {}
    }

    console.log('[Quickart BG] Extra headers stored & parsed:', {
      session_id: !!session.sessionId,
      store_id: !!session.storeId,
      device_id: !!session.deviceId
    });
  }

  await saveZeptoSession(session);
  return { ok: true };
}

// ─── Session capture (Blinkit) ───────────────────────────────────────────────

async function onBlinkitSessionCaptured({ capturedAt, sessionData = {} }) {
  const cookies = await getCookiesForBlinkit();
  if (cookies.length === 0) return { ok: false, error: 'No Blinkit cookies' };

  const existing = await getBlinkitSession() ?? {};
  const cookieString = buildCookieString(cookies);

  const session = {
    ...existing,
    cookieString,
    capturedAt,
  };

  await saveBlinkitSession(session);
  return { ok: true };
}

async function onBlinkitSearchBodyObserved({ body, headers, capturedAt }) {
  const session = await getBlinkitSession() ?? {};
  
  session.extraHeaders = headers;
  session.authKey = headers['auth_key'] ?? session.authKey;
  session.sessionUuid = headers['session_uuid'] ?? session.sessionUuid;
  session.latitude = headers['lat'] ?? session.latitude;
  session.longitude = headers['lon'] ?? session.longitude;
  
  // Implicitly try grabbing cookies just in case DNR missed something natively
  const cookies = await getCookiesForBlinkit();
  if (cookies.length > 0) {
    session.cookieString = buildCookieString(cookies);
  }
  
  session.capturedAt = capturedAt;

  await saveBlinkitSession(session);
  console.log('[Quickart BG] Blinkit Extracted Session:', { auth_key: !!session.authKey });
  return { ok: true };
}

// ─── Session capture (Instamart) ─────────────────────────────────────────────

async function onInstamartSessionCaptured({ capturedAt, sessionData = {} }) {
  const cookies = await getCookiesForInstamart();
  if (cookies.length === 0) return { ok: false, error: 'No Instamart cookies' };

  const existing = await getInstamartSession() ?? {};
  const cookieString = buildCookieString(cookies);

  const session = {
    ...existing,
    cookieString,
    capturedAt,
  };

  await saveInstamartSession(session);
  return { ok: true };
}

async function onInstamartSearchBodyObserved({ body, headers, storeParams = {}, capturedAt }) {
  const session = await getInstamartSession() ?? {};

  session.extraHeaders = headers;
  session.matcher = headers['matcher'] ?? session.matcher;
  session.buildVersion = headers['x-build-version'] ?? session.buildVersion;

  // Capture store IDs and layoutId from the intercepted request URL params
  if (storeParams.storeId) session.storeId = storeParams.storeId;
  if (storeParams.primaryStoreId) session.primaryStoreId = storeParams.primaryStoreId;
  if (storeParams.secondaryStoreId) session.secondaryStoreId = storeParams.secondaryStoreId;
  if (storeParams.layoutId) session.layoutId = storeParams.layoutId;

  const cookies = await getCookiesForInstamart();
  if (cookies.length > 0) {
    session.cookieString = buildCookieString(cookies);
    // Try to extract storeId from strId cookie if not already set
    if (!session.storeId) {
      const strIdCookie = cookies.find(c => c.name === 'strId');
      if (strIdCookie?.value) session.storeId = strIdCookie.value;
    }
  }

  session.capturedAt = capturedAt;

  await saveInstamartSession(session);
  console.log('[Quickart BG] Instamart session captured:', {
    matcher: !!session.matcher,
    buildVersion: !!session.buildVersion,
    storeId: session.storeId || 'none',
  });
  return { ok: true };
}

async function onInstamartHomeObserved({ eta, capturedAt }) {
  if (!eta?.value) return { ok: false };
  const session = await getInstamartSession() ?? {};
  session.eta = { value: eta.value, unit: eta.unit, capturedAt };
  await saveInstamartSession(session);
  console.log('[Quickart BG] Instamart ETA captured:', eta.value, eta.unit);
  return { ok: true };
}

// ─── Cookie helpers ───────────────────────────────────────────────────────────

async function getCookiesForZepto() {
  // Use `url` instead of `domain` — this returns ALL cookies that would be
  // sent to that URL, including HttpOnly ones. Domain filter misses some.
  const results = await Promise.all([
    new Promise(r => chrome.cookies.getAll({ url: 'https://www.zepto.com' },   c => r(c ?? []))),
    new Promise(r => chrome.cookies.getAll({ url: 'https://bff-gateway.zepto.com' }, c => r(c ?? []))),
  ]);

  // Merge, deduplicate by name (prefer www.zepto.com value)
  const seen = new Map();
  for (const cookie of [...results[0], ...results[1]]) {
    if (!seen.has(cookie.name)) seen.set(cookie.name, cookie);
  }
  const cookies = Array.from(seen.values());
  console.log('[Quickart BG] All Zepto cookies found:', cookies.map(c => c.name));
  return cookies;
}

async function getCookiesForInstamart() {
  // Swiggy sets cookies on both www.swiggy.com and the apex .swiggy.com domain.
  // Query both URLs to get all cookies (including HttpOnly aws-waf-token, sid, etc.)
  const results = await Promise.all([
    new Promise(r => chrome.cookies.getAll({ url: 'https://www.swiggy.com' }, c => r(c ?? []))),
    new Promise(r => chrome.cookies.getAll({ domain: '.swiggy.com' }, c => r(c ?? []))),
  ]);
  const seen = new Map();
  // Prefer www.swiggy.com values over apex domain values on conflict
  for (const cookie of [...results[1], ...results[0]]) {
    if (!seen.has(cookie.name)) seen.set(cookie.name, cookie);
  }
  const cookies = Array.from(seen.values());
  console.log('[Quickart BG] Instamart cookies found:', cookies.map(c => c.name));
  return cookies;
}

async function getCookiesForBlinkit() {
  const results = await Promise.all([
    new Promise(r => chrome.cookies.getAll({ url: 'https://blinkit.com' }, c => r(c ?? []))),
    new Promise(r => chrome.cookies.getAll({ url: 'https://www.blinkit.com' }, c => r(c ?? []))),
  ]);
  const seen = new Map();
  for (const cookie of [...results[0], ...results[1]]) {
    if (!seen.has(cookie.name)) seen.set(cookie.name, cookie);
  }
  return Array.from(seen.values());
}

function buildCookieString(cookies) {
  return cookies.map((c) => `${c.name}=${c.value}`).join('; ');
}

// ─── Session status ──────────────────────────────────────────────────────────

async function getSessionStatus() {
  const [zeptoSess, blinkitSess, instamartSess, flipkartSess] = await Promise.all([
    getZeptoSession(),
    getBlinkitSession(),
    getInstamartSession(),
    getFlipkartSession(),
  ]);

  let zeptoConnected = false;
  if (zeptoSess?.cookieString) {
    const ageMs = Date.now() - zeptoSess.capturedAt;
    zeptoConnected = ageMs <= ZEPTO_CONFIG.SESSION_TTL_MS;
  }

  let blinkitConnected = false;
  if (blinkitSess?.cookieString || blinkitSess?.authKey) {
    const ageMs = Date.now() - blinkitSess.capturedAt;
    blinkitConnected = ageMs <= BLINKIT_CONFIG.SESSION_TTL_MS;
  }

  let instamartConnected = false;
  if (instamartSess?.matcher || instamartSess?.cookieString) {
    const ageMs = Date.now() - instamartSess.capturedAt;
    instamartConnected = ageMs <= SWIGGY_CONFIG.SESSION_TTL_MS;
  }

  let flipkartConnected = false;
  if (flipkartSess?.capturedAt) {
    const ageMs = Date.now() - flipkartSess.capturedAt;
    flipkartConnected = ageMs <= FLIPKART_CONFIG.SESSION_TTL_MS;
  }

  const anyConnected = zeptoConnected || blinkitConnected || instamartConnected || flipkartConnected;

  return {
    connected: anyConnected,
    zepto: zeptoConnected,
    blinkit: blinkitConnected,
    instamart: instamartConnected,
    flipkart: flipkartConnected,
    reason: anyConnected ? null : 'no_sessions',
  };
}

// ─── ETA ─────────────────────────────────────────────────────────────────────

async function onGetEta({ lat, lon }) {
  const [zeptoSess, blinkitSess, instamartSess] = await Promise.all([
    getZeptoSession(),
    getBlinkitSession(),
    getInstamartSession(),
  ]);

  const results = {};

  // ── Zepto ETA (retry up to 3x if unavailable — API sometimes returns false unserviceable) ──
  if (zeptoSess?.cookieString) {
    const latitude  = lat ?? zeptoSess.latitude  ?? null;
    const longitude = lon ?? zeptoSess.longitude ?? null;
    if (latitude == null || longitude == null) {
      console.warn('[ETA] Zepto: no lat/lon available, skipping');
    } else {
      const fetchZeptoEta = async () => {
        const storeId   = zeptoSess.storeId ?? '';
        const storeEtas = storeId ? JSON.stringify({ [storeId]: 10 }) : '{}';
        const headers = {
          'accept': 'application/json, text/plain, */*',
          'app_sub_platform': 'WEB',
          'app_version': '14.37.0',
          'appversion': '14.37.0',
          'auth_from_cookie': 'true',
          'auth_revamp_flow': 'v2',
          'compatible_components': 'WIDGET_BASED_ETA,NEW_ETA_BANNER,HOMEPAGE_V2',
          'platform': 'WEB',
          'tenant': 'ZEPTO',
          'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
          'cookie': zeptoSess.cookieString,
          ...(zeptoSess.sessionId  && { 'session_id': zeptoSess.sessionId, 'sessionid': zeptoSess.sessionId }),
          ...(zeptoSess.deviceId   && { 'device_id': zeptoSess.deviceId, 'deviceid': zeptoSess.deviceId }),
          ...(storeId               && { 'store_id': storeId, 'store_ids': storeId, 'storeid': storeId }),
          ...(storeId               && { 'store_etas': storeEtas }),
          ...(zeptoSess.csrfSecret && { 'x-csrf-secret': zeptoSess.csrfSecret }),
          ...(zeptoSess.xsrfToken  && { 'x-xsrf-token': zeptoSess.xsrfToken }),
          ...(zeptoSess.xTimezone  && { 'x-timezone': zeptoSess.xTimezone }),
          ...(zeptoSess.extraHeaders ?? {}),
        };
        const url = `https://bff-gateway.zepto.com/lms/api/v2/get_page?latitude=${latitude}&longitude=${longitude}&page_type=HOME&version=v2&show_new_eta_banner=true&page_size=3`;
        const resp = await fetch(url, { method: 'GET', headers });
        if (!resp.ok) return null;
        const json = await resp.json();
        const serviceable = json?.storeServiceableResponse?.serviceable;
        const etaInfo     = json?.pageLayout?.header?.widget?.data?.etaInfo;
        if (serviceable === false || etaInfo?.isDeliverable === false) {
          return { unavailable: true, label: 'Unavailable' };
        }
        if (etaInfo?.etaInMinutes) {
          return { eta: parseInt(etaInfo.etaInMinutes, 10), label: `${etaInfo.etaInMinutes} min` };
        }
        return null;
      };

      try {
        for (let attempt = 1; attempt <= 3; attempt++) {
          const eta = await fetchZeptoEta();
          if (eta && !eta.unavailable) { results.zepto = eta; break; }
          if (eta?.unavailable && attempt === 3) { results.zepto = eta; break; }
          if (eta?.unavailable) {
            console.warn(`[ETA] Zepto unavailable (attempt ${attempt}/3), retrying...`);
            await new Promise(r => setTimeout(r, 1500));
          }
        }
      } catch (e) {
        console.warn('[ETA] Zepto ETA fetch failed:', e.message);
      }
    }
  }

  // ── Blinkit ETA (retry up to 2x if unavailable) ──────────────────────────────
  if (blinkitSess?.cookieString || blinkitSess?.authKey) {
    const latitude  = lat ?? blinkitSess.latitude  ?? null;
    const longitude = lon ?? blinkitSess.longitude ?? null;
    if (latitude == null || longitude == null) {
      console.warn('[ETA] Blinkit: no lat/lon available, skipping');
    } else {
      const fetchBlinkitEta = async () => {
        const headers = {
          'accept': '*/*',
          'app_client': 'consumer_web',
          'app_version': '52434332',
          'content-type': 'application/json',
          'platform': 'mobile_web',
          'lat': String(latitude),
          'lon': String(longitude),
          'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
          ...(blinkitSess.cookieString && { 'cookie': blinkitSess.cookieString }),
          ...(blinkitSess.authKey      && { 'auth_key': blinkitSess.authKey }),
          ...(blinkitSess.sessionUuid  && { 'session_uuid': blinkitSess.sessionUuid }),
          ...(blinkitSess.extraHeaders ?? {}),
        };
        const resp = await fetch('https://blinkit.com/v1/consumerweb/eta', { method: 'GET', headers });
        if (resp.status === 403 || resp.status === 404) return { unavailable: true, label: 'Unavailable' };
        if (!resp.ok) return null;
        const json = await resp.json();
        const mins = json?.eta_in_minutes;
        if (mins == null) return { unavailable: true, label: 'Unavailable' };
        return { eta: mins, label: `${mins} min` };
      };

      try {
        for (let attempt = 1; attempt <= 3; attempt++) {
          const eta = await fetchBlinkitEta();
          if (eta && !eta.unavailable) { results.blinkit = eta; break; }
          if (eta?.unavailable && attempt === 3) { results.blinkit = eta; break; }
          if (eta?.unavailable) {
            console.warn(`[ETA] Blinkit unavailable (attempt ${attempt}/3), retrying...`);
            await new Promise(r => setTimeout(r, 1500));
          }
        }
      } catch (e) {
        console.warn('[ETA] Blinkit ETA fetch failed:', e.message);
      }
    }
  }

  // Instamart ETA — from cached home/v2 interception (TTL: 30 min)
  if (instamartSess?.eta?.value && instamartSess.eta.capturedAt) {
    const ageMs = Date.now() - instamartSess.eta.capturedAt;
    if (ageMs < 30 * 60 * 1000) {
      const mins = instamartSess.eta.value;
      results.swiggy = { eta: parseInt(mins, 10), label: `${mins} min` };
    }
  }

  return { ok: true, ...results };
}

// ─── Search ──────────────────────────────────────────────────────────────────

async function onSearch({ query, page = 0 }) {
  if (!query?.trim()) {
    return { ok: false, error: 'Empty query' };
  }

  const [zeptoSess, blinkitSess, instamartSess, flipkartSess] = await Promise.all([
    getZeptoSession(),
    getBlinkitSession(),
    getInstamartSession(),
    getFlipkartSession(),
  ]);

  if (!zeptoSess && !blinkitSess && !instamartSess && !flipkartSess) {
    return { ok: false, error: 'not_connected', needsAuth: true };
  }

  const tasks = [];
  const warnings = [];

  if (zeptoSess) {
    tasks.push(searchZepto(query, zeptoSess, page).catch(err => {
      if (err.status === 401 || err.status === 403) clearZeptoSession();
      console.warn('Zepto search failed:', err);
      return [];
    }));
  }

  if (blinkitSess) {
    tasks.push(searchBlinkit(query, blinkitSess, page).catch(err => {
      if (err.status === 401 || err.status === 403) clearBlinkitSession();
      console.warn('Blinkit search failed:', err);
      return [];
    }));
  }

  if (instamartSess) {
    tasks.push(searchInstamartViaTab(query, instamartSess, page).catch(err => {
      if (err.status === 401 || err.status === 403) clearInstamartSession();
      if (err.noTab) warnings.push('instamart_no_tab');
      if (err.swiggyBackendError) warnings.push('instamart_waf_error');
      console.warn('Instamart search failed:', err.message);
      return [];
    }));
  }

  if (flipkartSess) {
    tasks.push(searchFlipkart(query, flipkartSess, page).catch(err => {
      if (err.status === 401 || err.status === 403) clearFlipkartSession();
      if (err.noTab) warnings.push('flipkart_no_tab');
      console.warn('Flipkart search failed:', err.message);
      return [];
    }));
  }

  const resultsMatrix = await Promise.all(tasks);
  const combinedResults = resultsMatrix.flat();

  return { ok: true, results: combinedResults, warnings, isStale: false };
}

// ─── Instamart tab-context search ────────────────────────────────────────────
//
// WHY: Swiggy's WAF uses TLS/HTTP2 fingerprinting. Extension service worker
// requests have a different fingerprint than real browser page requests, so a
// direct fetch() from here always returns {"statusCode":"ERR_NON_2XX_3XX_RESPONSE"}.
//
// FIX: Execute the fetch inside an actual open Swiggy tab using
// chrome.scripting.executeScript (world: MAIN). This is a true same-origin request
// — cookies included automatically, fingerprint identical to Swiggy's own React app.

async function searchInstamartViaTab(query, session, page = 0) {
  // Find a completed Swiggy tab to run the search in
  const tabs = await new Promise(r =>
    chrome.tabs.query({ url: 'https://www.swiggy.com/*', status: 'complete' }, r)
  );

  if (!tabs || tabs.length === 0) {
    const err = new Error('No Swiggy tab open. Please keep swiggy.com/instamart open in a browser tab for Instamart search.');
    err.noTab = true;
    throw err;
  }

  const tabId = tabs[0].id;
  const { queryString, extraHeaders, bodyJson } = buildInstamartFetchArgs(query, session, page);

  console.log('[Quickart BG] Instamart search via tab', tabId, '| query:', query, '| params:', queryString);

  // This function runs inside the Swiggy page — true same-origin fetch.
  // Args must be JSON-serializable (no functions, no class instances).
  const execResults = await chrome.scripting.executeScript({
    target: { tabId },
    world: 'MAIN',
    func: async (queryString, extraHeaders, bodyJson) => {
      const headers = { ...extraHeaders, 'content-type': 'application/json', 'accept': '*/*' };

      try {
        const response = await fetch(`/api/instamart/search/v2?${queryString}`, {
          method: 'POST',
          headers,
          body: bodyJson,
          // Same-origin — cookies included automatically, no credentials option needed
        });

        if (!response.ok) return { __error: response.status };
        const json = await response.json();
        // Detect Swiggy's internal error body (HTTP 200 but error payload)
        if (json?.statusCode && !json?.data) return { __swiggyError: json.statusCode };
        return json;
      } catch (e) {
        return { __error: e.message };
      }
    },
    args: [queryString, extraHeaders, bodyJson],
  });

  const rawData = execResults?.[0]?.result;

  if (!rawData) {
    throw new Error('Instamart tab search returned no data');
  }

  if (rawData.__error) {
    const err = new Error(`Instamart tab search error: ${rawData.__error}`);
    err.status = typeof rawData.__error === 'number' ? rawData.__error : 0;
    throw err;
  }

  if (rawData.__swiggyError) {
    // Swiggy backend returned an error body on HTTP 200 — usually WAF/session issue
    console.warn('[Quickart BG] Instamart backend error:', rawData.__swiggyError, '| queryString was:', queryString);
    const err = new Error(`Instamart backend error: ${rawData.__swiggyError}. Try reloading your Swiggy tab.`);
    err.swiggyBackendError = true;
    throw err;
  }

  console.log('[Quickart BG] Instamart tab search OK, parsing results...');
  return parseInstamartResults(rawData);
}

// ─── Cart ─────────────────────────────────────────────────────────────────────

async function onAddToCart({ item }) {
  if (!item?.platformId) return { ok: false, error: 'Invalid item' };
  const cart = await addToCart(item);
  return { ok: true, cart };
}

async function onRemoveFromCart({ platform, platformId }) {
  const cart = await removeFromCart(platform, platformId);
  return { ok: true, cart };
}

async function onUpdateCartQty({ platform, platformId, quantity }) {
  const cart = await updateCartItemQty(platform, platformId, quantity);
  return { ok: true, cart };
}

async function onGetCart() {
  const cart = await getCart();
  return { ok: true, cart };
}

// ─── Lifecycle ───────────────────────────────────────────────────────────────

// On browser startup, log session status — useful for debugging.
// In a future version this is where we'd trigger background data refresh.
chrome.runtime.onStartup.addListener(async () => {
  const status = await getSessionStatus();
  console.log('[Quickart BG] Browser started. Session status:', status);

  if (status.connected) {
    console.log('[Quickart BG] Session valid, ready to serve searches.');
  } else {
    console.log('[Quickart BG] No valid session. User needs to visit zepto.com.');
  }
});

chrome.runtime.onInstalled.addListener(({ reason }) => {
  if (reason === 'install') {
    console.log('[Quickart BG] Extension installed. Waiting for first Zepto session.');
  }
  // Capture Flipkart session immediately if user already has a Flipkart tab open
  tryCaptureFlipkartSession();
});

// ─── Auto-capture session when user visits zepto.com ─────────────────────────
// This is more reliable than intercepting fetch calls. As soon as Chrome loads
// any zepto.com page, we check if the user is logged in (has auth cookies) and
// capture the session automatically — no fetch patching required.

chrome.tabs.onUpdated.addListener(async (tabId, changeInfo, tab) => {
  if (changeInfo.status !== 'complete') return;

  if (tab.url?.includes('zepto.com')) {
    console.log('[Quickart BG] Zepto tab detected, checking cookies...');
    await tryCaptureZeptoSession();
  } else if (tab.url?.includes('swiggy.com')) {
    console.log('[Quickart BG] Swiggy tab detected, checking cookies...');
    await tryCaptureInstamartSession();
  } else if (tab.url?.includes('flipkart.com')) {
    console.log('[Quickart BG] Flipkart tab detected, marking session...');
    await tryCaptureFlipkartSession();
  }
});

async function tryCaptureZeptoSession() {
  const cookies = await getCookiesForZepto();

  if (cookies.length === 0) {
    console.log('[Quickart BG] No Zepto cookies — user not logged in yet.');
    return;
  }

  // Check if any cookie looks like an auth cookie (not just analytics)
  const authCookies = cookies.filter((c) =>
    /session|token|auth|user|uid|id|login|logged/i.test(c.name)
  );

  if (authCookies.length === 0) {
    console.log('[Quickart BG] Cookies found but none look like auth cookies:', cookies.map(c => c.name));
    // Still save — Zepto might use non-obvious cookie names
  }

  const existing = await getZeptoSession();
  const cookieString = buildCookieString(cookies);

  // Only update if cookie string changed (avoid unnecessary writes)
  if (existing?.cookieString === cookieString) {
    console.log('[Quickart BG] Session already up to date.');
    return;
  }

  const session = {
    ...(existing ?? {}),  // preserve deviceId, sessionId, storeId etc from content script
    cookieString,
    capturedAt: Date.now(),
  };

  await saveZeptoSession(session);
  console.log('[Quickart BG] Session auto-captured. Cookies:', cookies.map(c => c.name));
}

async function tryCaptureInstamartSession() {
  const cookies = await getCookiesForInstamart();

  if (cookies.length === 0) {
    console.log('[Quickart BG] No Swiggy cookies — user may not be logged in.');
    return;
  }

  const existing = await getInstamartSession();
  const cookieString = buildCookieString(cookies);

  // Only update if cookie string changed
  if (existing?.cookieString === cookieString) {
    console.log('[Quickart BG] Instamart session already up to date.');
    return;
  }

  // Extract storeId from strId cookie if present
  const strIdCookie = cookies.find(c => c.name === 'strId');

  const session = {
    ...(existing ?? {}),  // preserve matcher, buildVersion, storeId etc from content script
    cookieString,
    capturedAt: Date.now(),
    ...(strIdCookie?.value ? { storeId: strIdCookie.value, primaryStoreId: strIdCookie.value } : {}),
  };

  await saveInstamartSession(session);
  console.log('[Quickart BG] Instamart session auto-captured. Cookies:', cookies.map(c => c.name));
}

async function tryCaptureFlipkartSession() {
  // Flipkart doesn't need explicit header capture — cookies are included automatically
  // via same-origin executeScript. We just mark that the user has visited Flipkart so
  // the session status check knows to attempt Flipkart Minutes searches.
  //
  // NOTE: Flipkart stores auth cookies (T, at, SN) on the root .flipkart.com domain.
  // We need https://*.flipkart.com/* in host_permissions to read them.
  const [wwwCookies, rootCookies] = await Promise.all([
    new Promise(r => chrome.cookies.getAll({ domain: 'www.flipkart.com' }, r)),
    new Promise(r => chrome.cookies.getAll({ domain: 'flipkart.com' }, r)),
  ]);
  const cookies = [...wwwCookies, ...rootCookies];

  if (cookies.length === 0) {
    console.log('[Quickart BG] No Flipkart cookies found — user may not have visited flipkart.com.');
    return;
  }

  const existing = await getFlipkartSession();
  const cookieString = buildCookieString(cookies);
  
  if (existing?.cookieString === cookieString) return;

  await saveFlipkartSession({ capturedAt: Date.now(), cookieString });
  console.log('[Quickart BG] Flipkart session marked. Cookies updated.');
}
