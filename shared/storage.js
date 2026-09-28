/**
 * Typed wrapper around chrome.storage.local.
 * All reads return null on missing keys (never throws).
 * All writes are fire-and-forget unless you await them.
 */

import { STORAGE_KEYS } from './constants.js';

// ---------- Low-level helpers ----------

function chromeGet(keys) {
  return new Promise((resolve) => chrome.storage.local.get(keys, resolve));
}

function chromeSet(obj) {
  return new Promise((resolve) => chrome.storage.local.set(obj, resolve));
}

function chromeRemove(keys) {
  return new Promise((resolve) => chrome.storage.local.remove(keys, resolve));
}

// ---------- Session ----------

/**
 * @typedef {Object} ZeptoSession
 * @property {Object} headers       - Key-value map of captured request headers
 * @property {number} capturedAt    - Unix ms timestamp of capture
 * @property {string} [storeId]     - Zepto store ID (location-specific)
 * @property {string} [latitude]
 * @property {string} [longitude]
 */

export async function getZeptoSession() {
  const data = await chromeGet(STORAGE_KEYS.ZEPTO_SESSION);
  return data[STORAGE_KEYS.ZEPTO_SESSION] ?? null;
}

export async function saveZeptoSession(session) {
  await chromeSet({ [STORAGE_KEYS.ZEPTO_SESSION]: session });
}

export async function clearZeptoSession() {
  await chromeRemove(STORAGE_KEYS.ZEPTO_SESSION);
}

export async function getBlinkitSession() {
  const data = await chromeGet(STORAGE_KEYS.BLINKIT_SESSION);
  return data[STORAGE_KEYS.BLINKIT_SESSION] ?? null;
}

export async function saveBlinkitSession(session) {
  await chromeSet({ [STORAGE_KEYS.BLINKIT_SESSION]: session });
}

export async function clearBlinkitSession() {
  await chromeRemove(STORAGE_KEYS.BLINKIT_SESSION);
}

export async function getInstamartSession() {
  const data = await chromeGet(STORAGE_KEYS.INSTAMART_SESSION);
  return data[STORAGE_KEYS.INSTAMART_SESSION] ?? null;
}

export async function saveInstamartSession(session) {
  await chromeSet({ [STORAGE_KEYS.INSTAMART_SESSION]: session });
}

export async function clearInstamartSession() {
  await chromeRemove(STORAGE_KEYS.INSTAMART_SESSION);
}

export async function getFlipkartSession() {
  const data = await chromeGet(STORAGE_KEYS.FLIPKART_SESSION);
  return data[STORAGE_KEYS.FLIPKART_SESSION] ?? null;
}

export async function saveFlipkartSession(session) {
  await chromeSet({ [STORAGE_KEYS.FLIPKART_SESSION]: session });
}

export async function clearFlipkartSession() {
  await chromeRemove(STORAGE_KEYS.FLIPKART_SESSION);
}

// ---------- Cart ----------

/**
 * @typedef {Object} CartItem
 * @property {string} platform
 * @property {string} platformId
 * @property {string} name
 * @property {string} brand
 * @property {number} quantity       - units the user wants to buy
 * @property {number} unitPrice
 * @property {number} mrp
 * @property {string} imageUrl
 * @property {string} deepLink
 * @property {string} groupId
 */

export async function getCart() {
  const data = await chromeGet(STORAGE_KEYS.CART);
  return data[STORAGE_KEYS.CART] ?? { items: [], updatedAt: null };
}

export async function saveCart(cart) {
  cart.updatedAt = Date.now();
  await chromeSet({ [STORAGE_KEYS.CART]: cart });
}

export async function addToCart(item) {
  const cart = await getCart();
  const idx = cart.items.findIndex(
    (i) => i.platform === item.platform && i.platformId === item.platformId
  );
  if (idx >= 0) {
    cart.items[idx].quantity += item.quantity ?? 1;
  } else {
    cart.items.push({ ...item, quantity: item.quantity ?? 1 });
  }
  await saveCart(cart);
  return cart;
}

export async function removeFromCart(platform, platformId) {
  const cart = await getCart();
  cart.items = cart.items.filter(
    (i) => !(i.platform === platform && i.platformId === platformId)
  );
  await saveCart(cart);
  return cart;
}

export async function updateCartItemQty(platform, platformId, quantity) {
  const cart = await getCart();
  const item = cart.items.find(
    (i) => i.platform === platform && i.platformId === platformId
  );
  if (!item) return cart;
  if (quantity <= 0) {
    return removeFromCart(platform, platformId);
  }
  item.quantity = quantity;
  await saveCart(cart);
  return cart;
}

export async function clearCart() {
  await chromeSet({
    [STORAGE_KEYS.CART]: { items: [], updatedAt: Date.now() },
  });
}

// ---------- Mapping cache ----------

/**
 * Cache maps "{platform}:{platformId}" → { groupId, canonicalName, mappedAt }
 * Stored as a flat object for O(1) lookups.
 */

export async function getMappingCache() {
  const data = await chromeGet(STORAGE_KEYS.MAPPING_CACHE);
  return data[STORAGE_KEYS.MAPPING_CACHE] ?? {};
}

export async function saveMappingCache(cache) {
  await chromeSet({ [STORAGE_KEYS.MAPPING_CACHE]: cache });
}

export async function upsertMappings(entries) {
  // entries: [{ platform, platformId, groupId, canonicalName }]
  const cache = await getMappingCache();
  for (const e of entries) {
    cache[`${e.platform}:${e.platformId}`] = {
      groupId: e.groupId,
      canonicalName: e.canonicalName,
      mappedAt: Date.now(),
    };
  }
  await saveMappingCache(cache);
}

export async function lookupMapping(platform, platformId) {
  const cache = await getMappingCache();
  return cache[`${platform}:${platformId}`] ?? null;
}
