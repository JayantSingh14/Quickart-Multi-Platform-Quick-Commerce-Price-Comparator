/**
 * Blinkit platform adapter - Vasooli Header Cloning Method
 */

import { BLINKIT_CONFIG, PLATFORMS } from '../shared/constants.js';
import { normalizeProduct } from './normalizer.js';

const PLATFORM = PLATFORMS.BLINKIT;

// ─── HTTP Proxy (Background Execution) ───────────────────────────────────────

async function blinkitFetch(endpoint, query, session) {
  const url = `${BLINKIT_CONFIG.SEARCH_BASE}${endpoint}?q=${encodeURIComponent(query)}&search_type=type_to_search`;

  // Clone intercepted native headers perfectly
  const headers = {
    ...(session.extraHeaders || {})
  };

  // We only replace strictly required fresh fields, omitting nothing else
  if (session.authKey) headers['auth_key'] = session.authKey;
  if (session.sessionUuid) headers['session_uuid'] = session.sessionUuid;
  if (session.latitude) headers['lat'] = session.latitude;
  if (session.longitude) headers['lon'] = session.longitude;

  if (session.cookieString) {
    headers['cookie'] = session.cookieString;
  }

  // Fetch API sets its own content length natively
  delete headers['content-length'];
  delete headers['Content-Length'];

  console.log('[Quickart Blinkit Proxy] POST', url);
  console.log('[Quickart Blinkit Proxy] Headers Cloned & Sent:\n', JSON.stringify(headers, null, 2));

  if (!headers['auth_key']) {
    throw new Error('Cannot search Blinkit: Missing `auth_key` in intercepted headers. Please visit blinkit.com and verify your session!');
  }

  const response = await fetch(url, {
    method: 'POST',
    headers,
    credentials: 'omit', // cookies are in session.cookieString inherently
  });

  if (!response.ok) {
    let detail = '';
    try { detail = await response.text(); } catch { }
    console.error(`[Quickart Blinkit Proxy] ${response.status}:`, detail);
    const err = new Error(`Blinkit API Error ${response.status}: ${endpoint}`);
    err.status = response.status;
    err.detail = detail;
    throw err;
  }

  const json = await response.json();
  console.log('[Quickart Blinkit Proxy] Response OK. Success:', json.is_success);
  return json;
}

// ─── Response parser ──────────────────────────────────────────────────────────

function extractProductsFromResponse(data) {
  if (data?.is_success && Array.isArray(data?.response?.snippets)) {
    const products = [];
    for (const snippet of data.response.snippets) {
      if (snippet?.data?.identity?.id && snippet?.data?.name?.text) {
        products.push(snippet.data);
      }
    }
    if (products.length > 0) return products;
  }

  return [];
}

// ─── Product field mapper ─────────────────────────────────────────────────────

function mapBlinkitProduct(raw) {
  const id = raw.identity?.id ?? raw.id;
  const name = raw.name?.text ?? '';
  const brand = raw.atc_action?.add_to_cart?.cart_item?.brand ?? '';

  const packsize = raw.variant?.text ?? '';

  // Extract prices. Usually "₹94", substring to strip the symbol
  let rawPrice = raw.normal_price?.text ?? '';
  let price = null;
  if (rawPrice) {
    price = parseFloat(rawPrice.replace(/[^0-9.]/g, ''));
  }

  let rawMrp = raw.mrp?.text ?? '';
  let mrp = price;
  if (rawMrp) {
    mrp = parseFloat(rawMrp.replace(/[^0-9.]/g, ''));
  }

  const imageUrl = raw.image?.url ?? '';

  // Check inventory or sold out flags
  const inStock = !(raw.is_sold_out) && (raw.inventory > 0 || raw.inventory === undefined);
  const deepLink = `https://blinkit.com/prn/${encodeURIComponent(name.toLowerCase().replace(/[^a-z0-9]+/g, '-'))}/prid/${id}`;

  return { id, name, brand, price, mrp, imageUrl, packsize, inStock, deepLink };
}

// ─── Public API ───────────────────────────────────────────────────────────────

export async function searchBlinkit(query, session, page = 0) {
  const data = await blinkitFetch(BLINKIT_CONFIG.ENDPOINTS.SEARCH, query, session);
  const rawProducts = extractProductsFromResponse(data);

  const normalized = [];
  rawProducts.forEach((raw, i) => {
    const mapped = mapBlinkitProduct(raw);
    if (!mapped.id || mapped.price === null) return;
    normalized.push(normalizeProduct(raw, PLATFORM, i + 1, () => mapped));
  });

  return normalized;
}
