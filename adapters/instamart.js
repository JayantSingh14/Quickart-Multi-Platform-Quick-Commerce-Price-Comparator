/**
 * Instamart platform adapter
 *
 * WHY NO DIRECT FETCH:
 * Swiggy's WAF uses TLS/HTTP2 fingerprinting (JA3/JA4). Extension service worker
 * requests have a different fingerprint than real browser page requests, so direct
 * fetch from the background always gets ERR_NON_2XX_3XX_RESPONSE in the body.
 *
 * FIX: The actual HTTP call is executed inside an open Swiggy tab via
 * chrome.scripting.executeScript (world: MAIN). That runs as a true same-origin
 * request, indistinguishable from Swiggy's own React app.
 *
 * This file handles: building request args + parsing/normalizing the response.
 * The tab-based fetch lives in background/service-worker.js (needs chrome.scripting).
 */

import { SWIGGY_CONFIG, PLATFORMS } from '../shared/constants.js';
import { normalizeProduct } from './normalizer.js';

const PLATFORM = PLATFORMS.SWIGGY;

// ─── Request builder ──────────────────────────────────────────────────────────

/**
 * Builds the args needed to execute the search from within a Swiggy page context.
 * All values are JSON-serializable so they can be passed as executeScript args.
 *
 * @returns {{ queryString: string, matcher: string, buildVersion: string, bodyJson: string }}
 */
export function buildInstamartFetchArgs(query, session, page = 0) {
  const offset = page * 20;

  const storeId          = session.storeId          || SWIGGY_CONFIG.FALLBACK_STORE_ID;
  const primaryStoreId   = session.primaryStoreId   || SWIGGY_CONFIG.FALLBACK_PRIMARY_STORE_ID;
  const secondaryStoreId = session.secondaryStoreId || SWIGGY_CONFIG.FALLBACK_SECONDARY_STORE_ID;

  const queryStringObj = {
    offset: String(offset),
    custom_back: 'true',
    ageConsent: 'false',
    voiceSearchTrackingId: '',
    storeId,
    primaryStoreId,
    secondaryStoreId,
  };
  
  if (session.layoutId) {
    queryStringObj.layoutId = session.layoutId;
  }

  const queryString = new URLSearchParams(queryStringObj).toString();

  const bodyJson = JSON.stringify({
    facets: [],
    sortAttribute: '',
    query,
    search_results_offset: String(offset),
    page_type: 'INSTAMART_AUTO_SUGGEST_PAGE',
    is_pre_search_tag: false,
  });

  return {
    queryString,
    extraHeaders: session.extraHeaders || {},
    bodyJson,
  };
}

// ─── Response parser ──────────────────────────────────────────────────────────

/**
 * Actual response shape (confirmed from live API):
 *
 * data.cards[]
 *   .card.card   (@type: GridWidget)
 *     .gridElements.infoWithStyle   (@type: ItemCollectionCard)
 *       .items[]                    ← one product group (all pack sizes)
 *         .brand
 *         .inStock
 *         .productId
 *         .variations[]             ← one entry per pack size / SKU
 *             .skuId                ← use as product ID
 *             .displayName
 *             .brandName
 *             .quantityDescription  ← pack size label e.g. "1 kg"
 *             .imageIds[]
 *             .inventory.inStock
 *             .price
 *                 .mrp.units        ← string, in RUPEES (not paise)
 *                 .offerPrice.units ← string, in RUPEES
 */
function extractProductsFromResponse(data) {
  // Guard: error body like {"statusCode":"ERR_NON_2XX_3XX_RESPONSE"}
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
        // Carry parent-level fields so the mapper can fall back to them
        variation._parentBrand  = item.brand  ?? '';
        variation._parentInStock = item.inStock ?? true;
        variations.push(variation);
      }
    }
  }

  return variations;
}

// ─── Product field mapper ─────────────────────────────────────────────────────

const SWIGGY_CDN = 'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_300,h_300/';

function mapInstamartProduct(raw) {
  const id   = raw.skuId ?? '';
  const name = raw.displayName ?? '';
  const brand = raw.brandName || raw._parentBrand || '';
  const packsize = raw.quantityDescription ?? '';

  // Prices are in RUPEES as strings — e.g. "64", "74". No paise conversion.
  const price = parseFloat(raw.price?.offerPrice?.units ?? raw.price?.mrp?.units ?? '0') || null;
  const mrp   = parseFloat(raw.price?.mrp?.units ?? raw.price?.offerPrice?.units ?? '0') || price;

  // Pick the first IMAGE-type media, fallback to first imageId
  let imageUrl = '';
  const firstImageMedia = Array.isArray(raw.medias)
    ? raw.medias.find(m => m.type === 'MEDIA_TYPE_IMAGE')
    : null;
  const imageId = firstImageMedia?.id ?? raw.imageIds?.[0] ?? '';
  if (imageId) imageUrl = `${SWIGGY_CDN}${imageId}`;

  const inStock = raw.inventory?.inStock === true || raw._parentInStock === true;
  const deepLink = `https://www.swiggy.com/instamart/item-page/${id}`;

  return { id, name, brand, price, mrp, imageUrl, packsize, inStock, deepLink };
}

// ─── Public API ───────────────────────────────────────────────────────────────

/**
 * Parse a raw Instamart search response into NormalizedSKUs.
 * Called by the service worker after the tab-context fetch returns raw JSON.
 */
export function parseInstamartResults(rawData) {
  const rawProducts = extractProductsFromResponse(rawData);
  const normalized = [];

  rawProducts.forEach((raw, i) => {
    const mapped = mapInstamartProduct(raw);
    if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
    normalized.push(normalizeProduct(raw, PLATFORM, i + 1, () => mapped));
  });

  return normalized;
}
