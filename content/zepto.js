/**
 * Zepto content script - Background Header Cloning
 * Injected strictly into the MAIN world of zepto.com
 */

(function () {
  if (window.__quickart_zepto_injected) return;
  window.__quickart_zepto_injected = true;

  const SEARCH_PATH = '/user-search-service/api/v3/search';
  let lastBodyFingerprint = null;

  function log(...args) {
    console.log('[Quickart Zepto]', ...args);
  }

  // Helper to cleanly extract nested keys
  function extractSessionFromPage() {
    const result = {
      storeId: undefined,
      storeIds: undefined,
      storeEtas: undefined,
      sessionId: undefined,
      deviceId: undefined,
    };

    try {
      // ── header-store → store_id, store_ids, store_etas ────────────────────
      const headerStore = localStorage.getItem('header-store');
      if (headerStore) {
        try {
          const parsed = JSON.parse(headerStore);
          result.storeId   = parsed.storeId ?? parsed.store_id ?? parsed.id ?? parsed.storeID;
          result.storeIds  = parsed.storeIds ?? parsed.store_ids;
          result.storeEtas = parsed.storeEtas ?? parsed.store_etas;
        } catch (e) {
          log('header-store parse error', e);
        }
      }

      // ── user → sessionId ──────────────────────────────────────────────────
      const userStr = localStorage.getItem('user');
      if (userStr) {
        try {
          const parsed = JSON.parse(userStr);
          result.sessionId = parsed.sessionId ?? parsed.session_id ?? parsed.token;
        } catch (e) {
          log('user parse error', e);
        }
      }

      // ── device_id → deviceId ──────────────────────────────────────────────
      result.deviceId = localStorage.getItem('device_id') ?? localStorage.getItem('deviceId');

    } catch (err) {
      log('Storage extraction failed:', err);
    }

    return result;
  }

  // Communicates extracted local state to background worker
  function relayToBackground(payload) {
    window.postMessage({ __quickart: true, ...payload }, '*');
  }

  function doRelay() {
    const session = extractSessionFromPage();
    relayToBackground({ type: 'ZEPTO_SESSION_CAPTURED', session });
  }

  doRelay();
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', doRelay);
  }
  window.addEventListener('load', doRelay);

  // ─── Fetch Interception (Vasooli Method) ────────────────────────────────────
  // We globally intercept ANY API calls made down to Zepto's BFF Gateway,
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
      if (headers['session_id'] || headers['store_id'] || headers['store_ids']) {
        const fp = JSON.stringify({ headers });
        if (fp !== lastBodyFingerprint) {
          lastBodyFingerprint = fp;
          relayToBackground({
            type: 'ZEPTO_SEARCH_BODY_OBSERVED',
            body: null,
            headers,
            capturedAt: Date.now(),
          });
          doRelay();
        }
      }
    } catch (e) {
      log('Error handling intercepted headers:', e);
    }
  }

  window.fetch = async function (input, init) {
    const url = typeof input === 'string' ? input : input.url;

    if (url.includes('bff-gateway.zepto.com')) {
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
    if (this._quickartUrl && this._quickartUrl.includes('bff-gateway.zepto.com')) {
      handleInterceptedHeaders(this._quickartHeaders);
    }
    return _originalXhrSend.apply(this, arguments);
  };

  log('Native Dual XHR + Fetch interceptor installed seamlessly ✓');

})();
