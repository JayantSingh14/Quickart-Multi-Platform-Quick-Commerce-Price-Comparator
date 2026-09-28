// ─── Bridge context ─────────────────────────────────────────────────────────────
// Content scripts defined in manifest.json usually run in the 'ISOLATED' world.
// However, to read `localStorage` values set by the zepto.com React app, we
// injected `zepto.js` into the 'MAIN' world dynamically.
//
// This bridge simply listens for messages from `zepto.js` (same document,
// `window.postMessage`) and relays them to the background service worker
// using `chrome.runtime.sendMessage`.

window.addEventListener('message', (event) => {
  // Only handle our own messages from the same page
  if (event.source !== window) return;
  if (!event.data?.__quickart) return;

  const { type, ...payload } = event.data;

  if (type === 'ZEPTO_SESSION_CAPTURED' || type === 'ZEPTO_SEARCH_BODY_OBSERVED') {
    chrome.runtime.sendMessage({ type, ...payload }, () => {
      // Ignore chrome.runtime.lastError — extension may be reloading
      void chrome.runtime.lastError;
    });
  }
});
