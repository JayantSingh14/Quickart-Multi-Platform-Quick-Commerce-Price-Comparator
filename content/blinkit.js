/**
 * Blinkit content script - Background Header Cloning
 * Injected strictly into the MAIN world of blinkit.com
 */

(function () {
  if (window.__quickart_blinkit_injected) return;
  window.__quickart_blinkit_injected = true;

  let lastBodyFingerprint = null;

  function log(...args) {
    console.log('[Quickart Blinkit]', ...args);
  }

  // Communicates extracted local state to background worker
  function relayToBackground(payload) {
    window.postMessage({ __quickart: true, ...payload }, '*');
  }

  // ─── Fetch Interception (Vasooli Method) ────────────────────────────────────
  // We globally intercept ANY API calls made down to Blinkit's V1 APIs
  // cloning the exact header payloads produced by React to bypass encryption and gating.

  const _originalFetch = window.fetch;
  const _originalXhrOpen = XMLHttpRequest.prototype.open;
  const _originalXhrSetRequestHeader = XMLHttpRequest.prototype.setRequestHeader;
  const _originalXhrSend = XMLHttpRequest.prototype.send;

  function normalizeHeaders(hInit) {
    const res = {};
    if (!hInit) return res;
    if (typeof hInit.entries === 'function') {
      for (const [k, v] of hInit.entries()) res[k.toLowerCase()] = v;
    } else if (Array.isArray(hInit)) {
      for (const [k, v] of hInit) res[k.toLowerCase()] = v;
    } else {
      for (const [k, v] of Object.entries(hInit)) res[k.toLowerCase()] = v;
    }
    return res;
  }

  function handleInterceptedHeaders(headers) {
    try {
      // Ensure we only relay fully authenticated headers that Blinkit attached auth_key/session_uuid to natively
      if (headers['auth_key'] || headers['session_uuid'] || headers['lat']) {
        const fp = JSON.stringify({ headers });
        if (fp !== lastBodyFingerprint) {
          lastBodyFingerprint = fp;
          relayToBackground({
            type: 'BLINKIT_SEARCH_BODY_OBSERVED',
            body: null,
            headers,
            capturedAt: Date.now(),
          });
        }
      }
    } catch (e) {
      log('Error handling intercepted headers:', e);
    }
  }

  window.fetch = async function (input, init) {
    const url = typeof input === 'string' ? input : input.url;

    if (url.includes('blinkit.com/v1/') || url.includes('/v1/')) {
      handleInterceptedHeaders(normalizeHeaders(input instanceof Request ? input.headers : init?.headers));
    }

    return _originalFetch.apply(this, arguments);
  };

  XMLHttpRequest.prototype.open = function(method, url, async, user, password) {
    this._quickartUrl = typeof url === 'string' ? url : (url ? url.toString() : '');
    this._quickartHeaders = {};
    return _originalXhrOpen.apply(this, arguments);
  };

  XMLHttpRequest.prototype.setRequestHeader = function(header, value) {
    if (this._quickartHeaders) {
      this._quickartHeaders[header.toLowerCase()] = value;
    }
    return _originalXhrSetRequestHeader.apply(this, arguments);
  };

  XMLHttpRequest.prototype.send = function(body) {
    if (this._quickartUrl && (this._quickartUrl.includes('blinkit.com/v1/') || this._quickartUrl.includes('/v1/'))) {
      handleInterceptedHeaders(this._quickartHeaders);
    }
    return _originalXhrSend.apply(this, arguments);
  };

  log('Native exact-header-clone Dual Interceptor installed smoothly ✓');

})();
