/**
 * Quickart Web Extension Bridge + Search API Bridge
 *
 * Strategy:
 *   - Extension handles Zepto & Blinkit
 *   - Search API server handles Instamart & Flipkart Minutes
 *   - Both are called in parallel; results are merged as they arrive.
 *   - If extension is unavailable, server results still work (and vice versa).
 */

// ─── Extension postMessage bridge ─────────────────────────────────────────────

const generateId = () => Math.random().toString(36).substring(2, 9);

export const sendToExtension = (requestType, payload = {}) => {
  return new Promise((resolve, reject) => {
    const requestId = generateId();

    const handleMessage = (event) => {
      if (event.source !== window) return;
      const { data } = event;
      if (data && data.__quickart_response === requestType && data.__requestId === requestId) {
        window.removeEventListener('message', handleMessage);
        if (data.ok === false) {
          reject(new Error(data.error || 'Extension request failed'));
        } else {
          resolve(data);
        }
      }
    };

    window.addEventListener('message', handleMessage);

    window.postMessage({ __quickart_request: requestType, __requestId: requestId, ...payload }, '*');

    setTimeout(() => {
      window.removeEventListener('message', handleMessage);
      reject(new Error('Extension timeout'));
    }, 15000);
  });
};

// ─── Server API bridge ────────────────────────────────────────────────────────

// Override via localStorage: localStorage.setItem('quickart_api_url', 'http://your-server:3210')
const getApiBase = () =>
  localStorage.getItem('quickart_api_url') ||
  (import.meta.env.VITE_SEARCH_API_URL ?? 'http://localhost:3210');

let _location = null; // { lat, lon, pincode, address }

/**
 * Sets the location context for server-side search calls.
 * Called from App when geolocation or pincode changes.
 */
export function setSearchLocation(loc) {
  _location = loc;
}

export function getSearchLocation() {
  return _location;
}

async function searchViaServer(query) {
  const base = getApiBase();
  const loc = _location ?? {};
  const body = { query, ...loc };

  const res = await fetch(`${base}/api/search`, {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify(body),
    signal: AbortSignal.timeout(20000),
  });

  if (!res.ok) throw new Error(`Search API ${res.status}`);
  return res.json(); // { swiggy?: [], flipkart?: [], errors?: {} }
}

// ─── Combined search ──────────────────────────────────────────────────────────

/**
 * Runs extension search + server search in parallel.
 * Returns merged NormalizedSKU[] — server results for swiggy/flipkart,
 * extension results for zepto/blinkit (and fallback swiggy/flipkart if server is down).
 */
export const searchProducts = async (query) => {
  const extensionPromise = sendToExtension('SEARCH', { query })
    .then((r) => r.results || [])
    .catch(() => []);

  const serverPromise = searchViaServer(query)
    .then((data) => {
      const items = [];
      if (Array.isArray(data.swiggy)) items.push(...data.swiggy);
      if (Array.isArray(data.flipkart)) items.push(...data.flipkart);
      return items;
    })
    .catch(() => []);

  const [extensionItems, serverItems] = await Promise.all([extensionPromise, serverPromise]);

  // Extension result platforms win over server if both return same platform
  // (shouldn't happen — extension does zepto/blinkit, server does swiggy/flipkart)
  const extensionPlatforms = new Set(extensionItems.map((i) => i.platform));
  const deduped = serverItems.filter((i) => !extensionPlatforms.has(i.platform));

  return [...extensionItems, ...deduped];
};

/**
 * Checks if the user has authenticated sessions for Blinkit and Zepto.
 */
export const getSessionStatuses = async () => {
  const result = await sendToExtension('GET_SESSION_STATUS');
  return result || {};
};

/**
 * Fetches ETAs from all platforms, calling the callback as each platform responds.
 * Zepto + Blinkit: via extension (fast, ~1-3s).
 * Instamart + Flipkart: via server (slow on first launch, ~30-60s).
 * onUpdate is called incrementally so the UI updates as ETAs arrive.
 */
export const getETAs = ({ lat, lon } = {}, onUpdate = () => {}) => {
  const base = getApiBase();
  const loc  = _location ?? {};

  // Extension — Zepto + Blinkit (fast)
  sendToExtension('GET_ETA', { lat, lon })
    .then((r) => {
      const update = {};
      if (r.zepto   != null) update.zepto   = r.zepto;
      if (r.blinkit != null) update.blinkit = r.blinkit;
      if (Object.keys(update).length > 0) onUpdate(update);
    })
    .catch(() => {});

  // Server — Instamart + Flipkart (slow on first launch)
  const body = { lat: lat ?? loc.lat, lon: lon ?? loc.lon, pincode: loc.pincode };
  fetch(`${base}/api/eta`, {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify(body),
    signal: AbortSignal.timeout(90000), // 90s — first launch needs browser warmup
  })
    .then((res) => (res.ok ? res.json() : {}))
    .then((data) => { if (Object.keys(data).length > 0) onUpdate(data); })
    .catch(() => {});
};
