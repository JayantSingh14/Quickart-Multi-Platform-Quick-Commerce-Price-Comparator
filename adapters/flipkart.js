/**
 * Flipkart Minutes platform adapter
 *
 * Flipkart's HYPERLOCAL search returns a full server-rendered HTML page.
 * Unlike Swiggy (which requires tab-based executeScript due to TLS fingerprinting),
 * Flipkart accepts direct fetch from the extension service worker as long as we
 * replay the captured session cookies — same approach as Zepto and Blinkit.
 *
 * The HTML embeds all product data in window.__INITIAL_STATE__. We extract it
 * with a string search (no DOMParser — not available in service workers) and
 * parse just the JSON portion.
 *
 * Response shape (confirmed from live API):
 *   window.__INITIAL_STATE__
 *     .multiWidgetState.widgetsData.slots[]
 *       .slotData.widget  (type: PRODUCT_SUMMARY_EXTENDED)
 *         .data.products[]
 *           .productInfo.value
 *             .id                         ← Flipkart FSN (product ID)
 *             .titles.title               ← full name
 *             .titles.superTitle          ← brand
 *             .titles.subtitle            ← pack size e.g. "1 kg"
 *             .pricing.finalPrice.value   ← selling price, number, INR
 *             .pricing.prices[]           ← find priceType=MRP for MRP
 *             .media.images[0].url        ← image URL with {@width}/{@height}/{@quality} placeholders
 *             .availability.displayState  ← "IN_STOCK" or other
 *             .productUrl                 ← relative URL e.g. "/fortune.../p/itm...?pid=...&marketplace=HYPERLOCAL"
 */

import { PLATFORMS } from '../shared/constants.js';
import { normalizeProduct } from './normalizer.js';

const PLATFORM = PLATFORMS.FLIPKART;

// ─── HTML parser ──────────────────────────────────────────────────────────────

/**
 * Extracts raw product objects from the Flipkart search HTML response.
 * Uses string search to locate window.__INITIAL_STATE__ — DOMParser is not
 * available in service worker contexts.
 */
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
  } catch {
    return [];
  }

  const slots = state?.multiWidgetState?.widgetsData?.slots ?? [];
  const rawProducts = [];

  for (const slot of slots) {
    const products = slot?.slotData?.widget?.data?.products;
    if (!Array.isArray(products)) continue;

    for (const product of products) {
      const v = product?.productInfo?.value;
      if (!v?.id || !v?.titles?.title) continue;

      const prices = Array.isArray(v.pricing?.prices) ? v.pricing.prices : [];
      const mrpEntry = prices.find(p => p.priceType === 'MRP');
      const sellingPrice = v.pricing?.finalPrice?.value
        ?? prices.find(p => p.priceType === 'FSP')?.value
        ?? null;

      // Image URL has {@width}, {@height}, {@quality} placeholders
      const rawImgUrl = v.media?.images?.[0]?.url ?? '';
      const imageUrl = rawImgUrl
        .replace('{@width}', '300')
        .replace('{@height}', '300')
        .replace('{@quality}', '90');

      rawProducts.push({
        id:         v.id,
        name:       v.titles.title,
        brand:      v.titles.superTitle ?? '',
        packsize:   v.titles.subtitle   ?? '',
        price:      sellingPrice,
        mrp:        mrpEntry?.value ?? sellingPrice,
        imageUrl,
        inStock:    v.availability?.displayState === 'IN_STOCK',
        productUrl: v.productUrl ?? '',
      });
    }
  }

  return rawProducts;
}

// ─── Product field mapper ─────────────────────────────────────────────────────

function mapFlipkartProduct(raw) {
  const id       = raw.id       ?? '';
  const name     = raw.name     ?? '';
  const brand    = raw.brand    ?? '';
  const packsize = raw.packsize ?? '';
  const price    = typeof raw.price === 'number' ? raw.price : null;
  const mrp      = typeof raw.mrp   === 'number' ? raw.mrp  : price;
  const imageUrl = raw.imageUrl ?? '';
  const inStock  = raw.inStock  ?? true;

  // productUrl is a relative path — prepend Flipkart origin
  const deepLink = raw.productUrl
    ? `https://www.flipkart.com${raw.productUrl}`
    : 'https://www.flipkart.com/flipkart-minutes-store?marketplace=HYPERLOCAL';

  return { id, name, brand, price, mrp, imageUrl, packsize, inStock, deepLink };
}

// ─── Public API ───────────────────────────────────────────────────────────────

export async function searchFlipkart(query, session, page = 0) {
  const url = `https://www.flipkart.com/search?q=${encodeURIComponent(query)}&marketplace=HYPERLOCAL`;

  // Find a Flipkart tab
  const tabs = await new Promise(r =>
    chrome.tabs.query({ url: '*://*.flipkart.com/*', status: 'complete' }, r)
  );

  if (!tabs || tabs.length === 0) {
    const err = new Error('No Flipkart tab open. Please keep flipkart.com open in a browser tab for Flipkart Minutes search.');
    err.noTab = true;
    throw err;
  }

  const tabId = tabs[0].id;
  console.log('[Quickart BG] Flipkart search via tab', tabId, url);

  const execResults = await chrome.scripting.executeScript({
    target: { tabId },
    world: 'MAIN',
    func: async (fetchUrl) => {
      try {
        const response = await fetch(fetchUrl, {
          method: 'GET',
          headers: {
            'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8',
          },
          // Same-origin executes include cookies natively
        });
        if (!response.ok) return { __error: response.status };
        return await response.text();
      } catch (e) {
        return { __error: e.message };
      }
    },
    args: [url],
  });

  const html = execResults?.[0]?.result;

  if (!html) throw new Error('Flipkart tab return no html');
  if (html.__error) throw new Error(`Flipkart tab search error: ${html.__error}`);
  const rawProducts = extractProductsFromHtml(html);

  console.log('[Quickart Flipkart] Extracted', rawProducts.length, 'products from HTML');

  const normalized = [];
  rawProducts.forEach((raw, i) => {
    const mapped = mapFlipkartProduct(raw);
    if (!mapped.id || mapped.price === null || mapped.price <= 0) return;
    normalized.push(normalizeProduct(raw, PLATFORM, i + 1, () => mapped));
  });

  return normalized;
}
