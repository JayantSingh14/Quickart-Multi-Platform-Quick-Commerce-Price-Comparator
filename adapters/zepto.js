/**
 * Zepto platform adapter — Vasooli Header Cloning Method
 *
 * This version uses EXACT headers intercepted from the live
 * background Zepto app, ensuring perfectly valid request-signatures,
 * session_ids, and store_ids natively.
 */

import { ZEPTO_CONFIG, PLATFORMS } from '../shared/constants.js';
import { normalizeProduct } from './normalizer.js';

const PLATFORM = PLATFORMS.ZEPTO;

// ─── UUID helper ──────────────────────────────────────────────────────────────

function uuid() { return crypto.randomUUID(); }

// ─── HTTP Proxy (Background Execution) ───────────────────────────────────────

async function zeptoFetch(endpoint, body, session) {
  const url = `${ZEPTO_CONFIG.BFF_BASE}${endpoint}`;

  // Clone intercepted native headers perfectly to mirror Vasooli
  const headers = {
    ...(session.extraHeaders || {})
  };

  if (session.cookieString) {
    headers['cookie'] = session.cookieString;
  }

  // We only replace strictly required fresh fields, omitting nothing else
  headers['request_id'] = uuid();
  headers['requestid'] = headers['request_id'];

  if (session.sessionId) {
    headers['session_id'] = session.sessionId;
    headers['sessionid'] = session.sessionId;
  }
  if (session.storeId) {
    headers['store_id'] = session.storeId;
    headers['storeid'] = session.storeId;
  }

  // Fetch API sets its own content length natively
  delete headers['content-length'];
  delete headers['Content-Length'];

  // Host and Origin headers are intercepted by Chrome's declarativeNetRequest rules
  // so we do not have to spoof them here against the fetch API specs.

  console.log('[Quickart Zepto Proxy] POST', url);
  console.log('[Quickart Zepto Proxy] Headers Cloned & Sent:\n', JSON.stringify(headers, null, 2));

  if (!headers['store_ids'] && !headers['store_id']) {
    throw new Error('Cannot search Zepto: Missing `store_id` in intercepted headers. Please visit zepto.com and select a valid delivery location first!');
  }

  const response = await fetch(url, {
    method: 'POST',
    headers,
    credentials: 'omit', // cookies are in session.cookieString naturally or implicitly handled
    body: JSON.stringify(body),
  });

  if (!response.ok) {
    let detail = '';
    try { detail = await response.text(); } catch { }
    console.error(`[Quickart Zepto Proxy] ${response.status}:`, detail);
    const err = new Error(`Zepto API Error ${response.status}: ${endpoint}`);
    err.status = response.status;
    err.detail = detail;
    throw err;
  }

  const json = await response.json();
  console.log('[Quickart Zepto Proxy] Response OK. Keys:', Object.keys(json ?? {}));
  console.log('Total Product Count', json.totalProductCount);
  return json;
}

// ─── Response parser ──────────────────────────────────────────────────────────

function extractProductsFromResponse(data) {
  if (Array.isArray(data?.layout)) {
    const products = [];
    for (const section of data.layout) {
      if (section?.widgetId !== "PRODUCT_GRID") continue;

      for (const item of section.data?.resolver?.data?.items || []) {
        const p = item.productResponse ?? item.product ?? item;
        if (p) products.push(p);
      }
    }
    if (products.length > 0) return products;
  }

  if (Array.isArray(data?.data?.products)) return data.data.products;
  if (Array.isArray(data?.products)) return data.products;
  if (Array.isArray(data?.data)) return data.data;

  return [];
}

// ─── Product field mapper ─────────────────────────────────────────────────────

function mapZeptoProduct(raw) {
  const prod = raw.product ?? raw;
  const variant = raw.productVariant ?? raw;

  const id = prod.id ?? raw.productId ?? raw.variantId ?? raw.id;
  const name = prod.name ?? raw.productName ?? raw.name ?? '';
  const brand = prod.brand ?? prod.manufacturerName ?? raw.brand ?? '';

  const packsize = variant.formattedPacksize ?? (variant.weightInGms ? `${variant.weightInGms} g` : '');

  // Zepto prices are in paisa, divide by 100
  const rawPrice = raw.discountedSellingPrice ?? raw.sellingPrice ?? variant.discountedPrice ?? raw.price ?? null;
  const price = rawPrice !== null ? rawPrice / 100 : null;

  const rawMrp = raw.mrp ?? variant.mrp ?? rawPrice;
  const mrp = rawMrp !== null ? rawMrp / 100 : null;

  const images = variant.images ?? raw.images ?? raw.productImages ?? [];

  let imageUrl = '';
  if (images.length > 0) {
    if (typeof images[0] === 'string') {
      imageUrl = images[0];
    } else if (images[0].path) {
      imageUrl = `https://cdn.zeptonow.com/${images[0].path}`;
    } else if (images[0].url) {
      imageUrl = images[0].url;
    }
  }

  if (!imageUrl) {
    imageUrl = raw.image ?? raw.imageUrl ?? raw.thumbnail ?? '';
  }

  const inStock = raw.outOfStock !== undefined ? !raw.outOfStock : (raw.inStock ?? raw.available ?? true);
  const deepLink = id ? `https://www.zepto.com/pn/${encodeURIComponent(name.toLowerCase().replace(/[^a-z0-9]+/g, '-'))}/${id}` : 'https://www.zepto.com';

  return { id, name, brand, price, mrp, imageUrl, inStock, deepLink, packsize };
}

// ─── Public API ───────────────────────────────────────────────────────────────

export async function searchZepto(query, session, page = 0) {
  // If Zepto needs userSessionId matching sessionId natively:
  const body = {
    query: query.trim(),
    pageNumber: page,
    mode: 'AUTOSUGGEST',
    intentId: crypto.randomUUID(),
    ...(session.sessionId && { userSessionId: session.sessionId }),
  };

  const data = await zeptoFetch(ZEPTO_CONFIG.ENDPOINTS.SEARCH, body, session);
  const rawProducts = extractProductsFromResponse(data);

  const normalized = [];
  rawProducts.forEach((raw, i) => {
    const mapped = mapZeptoProduct(raw);
    if (!mapped.id || mapped.price === null) return;
    normalized.push(normalizeProduct(raw, PLATFORM, i + 1, () => mapped));
  });

  return normalized;
}
