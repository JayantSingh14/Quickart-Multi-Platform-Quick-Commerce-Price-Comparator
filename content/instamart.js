/**
 * Instamart content script - Background Header Cloning
 * Injected strictly into the MAIN world of swiggy.com
 */

(function () {
  if (window.__quickart_instamart_injected) return;
  window.__quickart_instamart_injected = true;

  let lastBodyFingerprint = null;

  function log(...args) {
    console.log('[Quickart Instamart]', ...args);
  }

  function relayToBackground(payload) {
    window.postMessage({ __quickart: true, ...payload }, '*');
  }

  // ─── Fetch Interception (Vasooli Method) ────────────────────────────────────
  // Intercept API calls to Swiggy's Instamart endpoints to clone auth headers.

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

  // Extract storeId from URL query params of an intercepted Instamart request
  function extractParamsFromUrl(url) {
    try {
      const u = new URL(url, 'https://www.swiggy.com');
      return {
        storeId: u.searchParams.get('storeId') || '',
        primaryStoreId: u.searchParams.get('primaryStoreId') || '',
        secondaryStoreId: u.searchParams.get('secondaryStoreId') || '',
        layoutId: u.searchParams.get('layoutId') || '',
      };
    } catch {
      return {};
    }
  }

  function handleInterceptedHeaders(headers, url) {
    try {
      // Only relay if we have at least the matcher or x-build-version header
      // These are specific to Swiggy's Instamart API calls
      if (headers['matcher'] || headers['x-build-version']) {
        const storeParams = url ? extractParamsFromUrl(url) : {};
        const fp = JSON.stringify({ headers, storeParams });
        if (fp !== lastBodyFingerprint) {
          lastBodyFingerprint = fp;
          relayToBackground({
            type: 'INSTAMART_SEARCH_BODY_OBSERVED',
            body: null,
            headers,
            storeParams,
            capturedAt: Date.now(),
          });
        }
      }
    } catch (e) {
      log('Error handling intercepted headers:', e);
    }
  }

  function parseInstamartEta(json) {
    try {
      const configs = json?.data?.configs?.IM_PAGE_CONFIGS?.configInfo ?? [];
      for (const item of configs) {
        const podList = item?.card?.podDetailsList ?? [];
        // Prefer PRIMARY pod, fall back to first serviceable one
        const primary = podList.find(p => p.priority === 'PRIORITY_PRIMARY') ?? podList[0];
        const sla = primary?.serviceabilityDetails?.sla;
        if (sla?.value && sla?.unit) {
          return { value: sla.value, unit: sla.unit }; // e.g. { value: "31", unit: "MINS" }
        }
      }
    } catch {}
    return null;
  }

  window.fetch = async function (input, init) {
    const url = typeof input === 'string' ? input : input?.url;

    if (url && url.includes('/api/instamart/')) {
      handleInterceptedHeaders(
        normalizeHeaders(input instanceof Request ? input.headers : init?.headers),
        url
      );

      // Intercept home/v2 response to capture ETA
      if (url.includes('/home/v2')) {
        const response = await _originalFetch.apply(this, arguments);
        try {
          const clone = response.clone();
          clone.json().then(json => {
            const eta = parseInstamartEta(json);
            if (eta) {
              relayToBackground({
                type: 'INSTAMART_HOME_OBSERVED',
                eta,
                capturedAt: Date.now(),
              });
            }
          }).catch(() => {});
        } catch {}
        return response;
      }
    }

    return _originalFetch.apply(this, arguments);
  };

  XMLHttpRequest.prototype.open = function (method, url, async, user, password) {
    this._quickartUrl = typeof url === 'string' ? url : (url ? url.toString() : '');
    this._quickartHeaders = {};
    return _originalXhrOpen.apply(this, arguments);
  };

  XMLHttpRequest.prototype.setRequestHeader = function (header, value) {
    if (this._quickartHeaders) {
      this._quickartHeaders[header.toLowerCase()] = value;
    }
    return _originalXhrSetRequestHeader.apply(this, arguments);
  };

  XMLHttpRequest.prototype.send = function (body) {
    if (this._quickartUrl && this._quickartUrl.includes('/api/instamart/')) {
      handleInterceptedHeaders(this._quickartHeaders, this._quickartUrl);
    }
    return _originalXhrSend.apply(this, arguments);
  };

  log('Instamart header interceptor installed ✓');

})();
