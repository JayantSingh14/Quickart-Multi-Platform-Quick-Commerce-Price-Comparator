/**
 * Webpage bridge — injected into custom Quickart webpages (localhost or custom domains).
 *
 * Exposes a message bridge for web applications to communicate with the extension background script.
 * The webapp can dispatch searches via:
 * window.postMessage({ __quickart_request: 'SEARCH', query: '...' })
 */

window.addEventListener('message', (event) => {
  // Only handle our own messages from the same window
  if (event.source !== window) return;
  if (!event.data || !event.data.__quickart_request) return;

  const { __quickart_request, __requestId, ...payload } = event.data;

  // Send the request to the extension's background script
  chrome.runtime.sendMessage({ type: __quickart_request, ...payload }, (response) => {
    if (chrome.runtime.lastError) {
      console.error('[Quickart Bridge] Extension error:', chrome.runtime.lastError.message);
      window.postMessage({
        __quickart_response: __quickart_request,
        __requestId,
        ok: false,
        error: chrome.runtime.lastError.message
      }, '*');
      return;
    }

    // Pass the response back to the web application
    window.postMessage({
      __quickart_response: __quickart_request,
      __requestId,
      ...response
    }, '*');
  });
});
