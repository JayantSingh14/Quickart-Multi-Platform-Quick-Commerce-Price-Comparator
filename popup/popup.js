/**
 * Popup controller — orchestrates UI state and communicates with
 * the background service worker via chrome.runtime.sendMessage.
 *
 * Views:
 *   welcome  → initial landing
 *   loading  → search in progress
 *   empty    → no results
 *   results  → grouped SKU cards
 *   cart     → local cart with checkout redirect
 *
 * Edge cases handled:
 *  - User not connected → banner shown, search disabled
 *  - Session stale      → banner shown, search still attempted
 *  - Search while typing debounced → only fires after 400ms pause
 *  - Cart badge updates on every cart change
 *  - Image load errors  → fallback placeholder shown
 *  - Checkout with empty cart → button disabled
 */

import { groupAndRank } from '../adapters/grouper.js';

// ─── DOM refs ─────────────────────────────────────────────────────────────────

const searchInput   = document.getElementById('searchInput');
const searchBtn     = document.getElementById('searchBtn');
const cartBtn       = document.getElementById('cartBtn');
const cartBadge     = document.getElementById('cartBadge');
const connectBanner = document.getElementById('connectBanner');
const connectMsg    = document.getElementById('connectMsg');

const welcomeState  = document.getElementById('welcomeState');
const loadingState  = document.getElementById('loadingState');
const emptyState    = document.getElementById('emptyState');
const emptyStateMsg = document.getElementById('emptyStateMsg');
const resultsView   = document.getElementById('resultsView');
const resultsMeta   = document.getElementById('resultsMeta');
const resultsList   = document.getElementById('resultsList');

const cartView      = document.getElementById('cartView');
const cartList      = document.getElementById('cartList');
const cartSummary   = document.getElementById('cartSummary');
const backBtn       = document.getElementById('backBtn');
const clearCartBtn  = document.getElementById('clearCartBtn');

// ─── State ─────────────────────────────────────────────────────────────────────

let currentGroups = [];   // last search results
let cartItems = [];       // local cart items
let isConnected = false;
let debounceTimer = null;
let lastQuery = '';

// ─── Init ─────────────────────────────────────────────────────────────────────

async function init() {
  await checkConnection();
  await refreshCart();
  bindEvents();
}

// ─── Connection check ─────────────────────────────────────────────────────────

async function checkConnection() {
  try {
    const resp = await sendMessage({ type: 'GET_SESSION_STATUS' });

    if (resp.connected) {
      isConnected = true;
      connectBanner.classList.add('hidden');
    } else {
      isConnected = false;
      connectBanner.classList.remove('hidden');

      if (resp.reason === 'session_stale') {
        connectMsg.textContent = 'Session stale — open a platform again';
      } else {
        connectMsg.textContent = 'Open Zepto, Blinkit, Instamart, or Flipkart to connect';
      }
    }
  } catch {
    isConnected = false;
    connectBanner.classList.remove('hidden');
    connectMsg.textContent = 'Extension error — try reloading';
  }
}

// ─── Search ───────────────────────────────────────────────────────────────────

async function doSearch(query) {
  if (!query.trim()) {
    showView('welcome');
    return;
  }

  if (query === lastQuery) return;
  lastQuery = query;

  showView('loading');
  searchBtn.disabled = true;

  try {
    const resp = await sendMessage({ type: 'SEARCH', query });

    if (!resp.ok) {
      if (resp.needsAuth) {
        isConnected = false;
        connectBanner.classList.remove('hidden');
        connectMsg.textContent = 'Session expired — please reconnect';
        showView('empty');
        emptyStateMsg.textContent = 'Authentication required.';
        return;
      }
      showView('empty');
      emptyStateMsg.textContent = resp.error ?? 'Something went wrong.';
      return;
    }

    if (resp.isStale) {
      connectBanner.classList.remove('hidden');
      connectMsg.textContent = 'A session may be stale — refresh by visiting its website';
    }

    if (resp.warnings?.includes('instamart_no_tab')) {
      connectBanner.classList.remove('hidden');
      connectMsg.textContent = 'Instamart: keep swiggy.com/instamart open in a tab for results';
    }

    if (resp.warnings?.includes('instamart_waf_error')) {
      connectBanner.classList.remove('hidden');
      connectMsg.textContent = 'Instamart: session expired — reload your Swiggy tab and search again';
    }

    const skus = resp.results ?? [];

    if (skus.length === 0) {
      showView('empty');
      emptyStateMsg.textContent = `No results for "${query}".`;
      return;
    }

    currentGroups = groupAndRank(skus);
    renderResults(query, currentGroups);
    showView('results');

  } catch (err) {
    showView('empty');
    emptyStateMsg.textContent = 'Search failed. Please try again.';
    console.error('[Quickart Popup] search error:', err);
  } finally {
    searchBtn.disabled = false;
  }
}

// ─── Render results ───────────────────────────────────────────────────────────

function renderResults(query, groups) {
  const cartPlatformIds = new Set(cartItems.map((i) => `${i.platform}:${i.platformId}`));

  resultsMeta.textContent =
    `${groups.length} product${groups.length !== 1 ? 's' : ''} · ${
      new Set(groups.flatMap((g) => g.skus.map((s) => s.platform))).size
    } platform${groups.length !== 1 ? 's' : ''}`;

  resultsList.innerHTML = '';

  for (const group of groups) {
    const card = buildGroupCard(group, cartPlatformIds);
    resultsList.appendChild(card);
  }
}

function buildGroupCard(group, cartPlatformIds) {
  const card = document.createElement('div');
  card.className = 'group-card';

  // ── Group header ────────────────────────────────────────────────
  const firstSku = group.skus[0];
  const platformCount = group.platformCount;

  card.innerHTML = `
    <div class="group-header">
      <img
        class="group-img"
        src="${firstSku.imageUrl || ''}"
        alt=""
        onerror="this.src=''; this.style.background='#f1f5f9'"
      />
      <div class="group-info">
        <div class="group-name" title="${group.canonicalName}">${group.canonicalName}</div>
        <div class="group-meta">
          ${platformCount} platform${platformCount !== 1 ? 's' : ''}
          ${group.displayQuantity ? '· ' + group.displayQuantity : ''}
        </div>
      </div>
      <div class="group-best-price">
        <div class="best-price-value">₹${group.bestPrice}</div>
        ${group.bestPricePerUnitLabel
          ? `<div class="best-price-unit">${group.bestPricePerUnitLabel}</div>`
          : ''}
      </div>
    </div>
    <div class="sku-list" id="skuList_${group.groupId}"></div>
  `;

  // ── SKU rows ────────────────────────────────────────────────────
  const skuList = card.querySelector(`#skuList_${group.groupId}`);
  const isBestInGroup = true;

  group.skus.forEach((sku, idx) => {
    const inCart = cartPlatformIds.has(`${sku.platform}:${sku.platformId}`);
    const isBest = idx === 0;
    const discount = sku.mrp > sku.price
      ? Math.round(((sku.mrp - sku.price) / sku.mrp) * 100)
      : 0;

    const row = document.createElement('div');
    row.className = 'sku-row';
    row.innerHTML = `
      <span class="platform-badge platform-${sku.platform}">${sku.platform}</span>
      <div class="sku-price-wrap">
        <div style="display:flex; align-items:baseline; gap:6px;">
          <span class="sku-price">₹${sku.price}</span>
          ${sku.mrp > sku.price
            ? `<span class="sku-mrp">₹${sku.mrp}</span>`
            : ''}
        </div>
        <div class="sku-per-unit" style="display:flex; gap:4px; font-size:11px; margin-top:2px;">
          ${sku.displayQuantity ? `<span style="font-weight:500; color:#334155;">${sku.displayQuantity}</span>` : ''}
          ${sku.displayQuantity && sku.pricePerUnitLabel ? '<span style="color:#cbd5e1;">·</span>' : ''}
          ${sku.pricePerUnitLabel ? `<span>${sku.pricePerUnitLabel}</span>` : ''}
        </div>
      </div>
      ${isBest ? '<span class="best-tag">BEST</span>' : ''}
      <button
        class="add-btn ${inCart ? 'in-cart' : ''}"
        data-platform="${sku.platform}"
        data-platform-id="${sku.platformId}"
        title="${inCart ? 'In cart' : 'Add to cart'}"
      >${inCart ? '✓' : '+'}</button>
    `;

    // Wire add button
    row.querySelector('.add-btn').addEventListener('click', (e) => {
      e.stopPropagation();
      handleAddToCart(sku, row.querySelector('.add-btn'));
    });

    skuList.appendChild(row);
  });

  return card;
}

// ─── Cart operations ──────────────────────────────────────────────────────────

async function handleAddToCart(sku, btn) {
  const isInCart = btn.classList.contains('in-cart');

  if (isInCart) {
    // Toggle off — remove from cart
    const resp = await sendMessage({
      type: 'REMOVE_FROM_CART',
      platform: sku.platform,
      platformId: sku.platformId,
    });
    if (resp.ok) {
      btn.classList.remove('in-cart');
      btn.textContent = '+';
      cartItems = resp.cart.items;
      updateCartBadge();
    }
  } else {
    const cartItem = {
      platform: sku.platform,
      platformId: sku.platformId,
      name: sku.rawName,
      brand: sku.brand,
      quantity: 1,
      unitPrice: sku.price,
      mrp: sku.mrp,
      imageUrl: sku.imageUrl,
      deepLink: sku.deepLink,
      groupId: sku.groupId ?? '',
    };
    const resp = await sendMessage({ type: 'ADD_TO_CART', item: cartItem });
    if (resp.ok) {
      btn.classList.add('in-cart');
      btn.textContent = '✓';
      cartItems = resp.cart.items;
      updateCartBadge();
    }
  }
}

async function refreshCart() {
  const resp = await sendMessage({ type: 'GET_CART' });
  if (resp.ok) {
    cartItems = resp.cart.items ?? [];
    updateCartBadge();
  }
}

function updateCartBadge() {
  const total = cartItems.reduce((sum, i) => sum + i.quantity, 0);
  if (total > 0) {
    cartBadge.textContent = total > 99 ? '99+' : total;
    cartBadge.classList.remove('hidden');
  } else {
    cartBadge.classList.add('hidden');
  }
}

// ─── Cart view ────────────────────────────────────────────────────────────────

function renderCartView() {
  cartList.innerHTML = '';

  if (cartItems.length === 0) {
    cartList.innerHTML = '<div class="empty-cart">Your cart is empty.<br/>Add items from search results.</div>';
    cartSummary.innerHTML = '';
    return;
  }

  cartItems.forEach((item) => {
    const el = document.createElement('div');
    el.className = 'cart-item';
    el.innerHTML = `
      <img
        class="cart-item-img"
        src="${item.imageUrl || ''}"
        alt=""
        onerror="this.src=''; this.style.background='#f1f5f9'"
      />
      <div class="cart-item-info">
        <div class="cart-item-name" title="${item.name}">${item.name}</div>
        <div class="cart-item-meta">
          <span class="platform-badge platform-${item.platform}">${item.platform}</span>
          ₹${item.unitPrice} each
        </div>
      </div>
      <div class="qty-controls">
        <button class="qty-btn dec-btn" data-platform="${item.platform}" data-id="${item.platformId}">−</button>
        <span class="qty-num">${item.quantity}</span>
        <button class="qty-btn inc-btn" data-platform="${item.platform}" data-id="${item.platformId}">+</button>
      </div>
      <div class="cart-item-price">₹${(item.unitPrice * item.quantity).toFixed(0)}</div>
    `;

    el.querySelector('.dec-btn').addEventListener('click', () =>
      handleQtyChange(item.platform, item.platformId, item.quantity - 1)
    );
    el.querySelector('.inc-btn').addEventListener('click', () =>
      handleQtyChange(item.platform, item.platformId, item.quantity + 1)
    );

    cartList.appendChild(el);
  });

  renderCartSummary();
}

function renderCartSummary() {
  const total = cartItems.reduce((sum, i) => sum + i.unitPrice * i.quantity, 0);
  const itemCount = cartItems.reduce((sum, i) => sum + i.quantity, 0);

  // Group by platform for checkout options
  const byPlatform = {};
  for (const item of cartItems) {
    if (!byPlatform[item.platform]) byPlatform[item.platform] = 0;
    byPlatform[item.platform] += item.unitPrice * item.quantity;
  }

  const platforms = Object.keys(byPlatform);
  const primaryPlatform = platforms.length === 1
    ? platforms[0]
    : platforms.reduce((a, b) => byPlatform[a] >= byPlatform[b] ? a : b);

  cartSummary.innerHTML = `
    <div class="cart-total-row">
      <span class="cart-total-label">${itemCount} item${itemCount !== 1 ? 's' : ''}</span>
      <span class="cart-total-value">₹${total.toFixed(0)}</span>
    </div>
    <button
      class="checkout-btn"
      id="checkoutBtn"
      ${cartItems.length === 0 ? 'disabled' : ''}
    >
      Checkout on ${capitalize(primaryPlatform)} ↗
    </button>
    ${platforms.length > 1
      ? `<div style="font-size:11px;color:#94a3b8;margin-top:6px;text-align:center">
           Items from ${platforms.map(capitalize).join(', ')} · multiple checkouts needed
         </div>`
      : ''}
  `;

  document.getElementById('checkoutBtn')?.addEventListener('click', () =>
    handleCheckout(primaryPlatform)
  );
}

async function handleQtyChange(platform, platformId, newQty) {
  const resp = await sendMessage({
    type: 'UPDATE_CART_QTY',
    platform,
    platformId,
    quantity: newQty,
  });
  if (resp.ok) {
    cartItems = resp.cart.items;
    updateCartBadge();
    renderCartView();
  }
}

function handleCheckout(platform) {
  const platformItems = cartItems.filter((i) => i.platform === platform);
  if (platformItems.length === 0) return;

  // Build Zepto search URL as fallback (deep linking to multi-item cart
  // requires reverse-engineered cart API — phase 2).
  // For now: open Zepto and let user see the first item.
  let checkoutUrl = 'https://www.zepto.com';

  if (platform === 'zepto') {
    if (platformItems.length === 1) {
      checkoutUrl = platformItems[0].deepLink || 'https://www.zepto.com';
    } else {
      checkoutUrl = 'https://www.zepto.com';
    }
  } else if (platform === 'blinkit') {
    if (platformItems.length === 1) {
      checkoutUrl = platformItems[0].deepLink || 'https://blinkit.com';
    } else {
      checkoutUrl = 'https://blinkit.com';
    }
  } else if (platform === 'swiggy') {
    if (platformItems.length === 1) {
      checkoutUrl = platformItems[0].deepLink || 'https://www.swiggy.com/instamart';
    } else {
      checkoutUrl = 'https://www.swiggy.com/instamart';
    }
  } else if (platform === 'flipkart') {
    if (platformItems.length === 1) {
      checkoutUrl = platformItems[0].deepLink || 'https://www.flipkart.com/flipkart-minutes';
    } else {
      checkoutUrl = 'https://www.flipkart.com/flipkart-minutes';
    }
  }

  chrome.tabs.create({ url: checkoutUrl });
}

// ─── Events ───────────────────────────────────────────────────────────────────

function bindEvents() {
  // Search on Enter or button click
  searchInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      clearTimeout(debounceTimer);
      doSearch(searchInput.value.trim());
    }
  });

  searchInput.addEventListener('input', () => {
    clearTimeout(debounceTimer);
    const q = searchInput.value.trim();
    if (!q) { showView('welcome'); lastQuery = ''; return; }
    debounceTimer = setTimeout(() => doSearch(q), 400);
  });

  searchBtn.addEventListener('click', () => {
    clearTimeout(debounceTimer);
    doSearch(searchInput.value.trim());
  });

  // Cart toggle
  cartBtn.addEventListener('click', () => {
    renderCartView();
    showView('cart');
  });

  backBtn.addEventListener('click', () => {
    if (currentGroups.length > 0) {
      showView('results');
    } else {
      showView('welcome');
    }
  });

  clearCartBtn.addEventListener('click', async () => {
    await sendMessage({ type: 'CLEAR_CART' });
    cartItems = [];
    updateCartBadge();
    renderCartView();
  });
}

// ─── View management ──────────────────────────────────────────────────────────

const VIEWS = ['welcomeState', 'loadingState', 'emptyState', 'resultsView', 'cartView'];

function showView(name) {
  const map = {
    welcome: 'welcomeState',
    loading: 'loadingState',
    empty:   'emptyState',
    results: 'resultsView',
    cart:    'cartView',
  };
  const activeId = map[name];
  for (const id of VIEWS) {
    document.getElementById(id).classList.toggle('hidden', id !== activeId);
  }
}

// ─── Utilities ────────────────────────────────────────────────────────────────

function sendMessage(msg) {
  return new Promise((resolve, reject) => {
    chrome.runtime.sendMessage(msg, (resp) => {
      if (chrome.runtime.lastError) {
        reject(new Error(chrome.runtime.lastError.message));
      } else {
        resolve(resp);
      }
    });
  });
}

function capitalize(str) {
  return str ? str[0].toUpperCase() + str.slice(1) : '';
}

// ─── Debug panel ──────────────────────────────────────────────────────────────
// Access by opening popup then appending #debug to the popup URL,
// OR just press Ctrl+Shift+D while popup is open.

const debugPanel = document.getElementById('debugPanel');

function debugLog(...args) {
  const line = args.map((a) =>
    typeof a === 'object' ? JSON.stringify(a, null, 2) : String(a)
  ).join(' ');
  debugPanel.textContent += line + '\n';
  debugPanel.scrollTop = debugPanel.scrollHeight;
  console.log('[Quickart Debug]', ...args);
}

async function showDebugPanel() {
  debugPanel.classList.remove('hidden');
  debugPanel.textContent = '';

  debugLog('=== Quickart Debug ===');
  debugLog('Time:', new Date().toISOString());

  try {
    const status = await sendMessage({ type: 'GET_SESSION_STATUS' });
    debugLog('Session status:', status);

    if (status.connected) {
      debugLog('✓ Connected — capturedAt:', new Date(status.capturedAt).toLocaleTimeString());
      debugLog('  storeId:', status.storeId ?? 'none');
    } else {
      debugLog('✗ Not connected — reason:', status.reason);
    }
  } catch (e) {
    debugLog('ERROR getting status:', e.message);
  }

  try {
    const cart = await sendMessage({ type: 'GET_CART' });
    debugLog('Cart items:', cart.cart?.items?.length ?? 0);
  } catch (e) {
    debugLog('ERROR getting cart:', e.message);
  }

  debugLog('\nTo enable verbose header logging on zepto.com:');
  debugLog('  Run in zepto.com console:');
  debugLog('  localStorage.setItem("quickart_debug", "1")');
  debugLog('  Then reload zepto.com and look for [Quickart] logs.');
}

document.addEventListener('keydown', (e) => {
  if (e.ctrlKey && e.shiftKey && e.key === 'D') showDebugPanel();
});

if (location.hash === '#debug') showDebugPanel();

// ─── Boot ─────────────────────────────────────────────────────────────────────

init().catch(console.error);
