/**
 * Extension bridge — communicates with the Quickart Chrome extension
 * via window.postMessage (relayed by content/webpage-bridge.js).
 *
 * The extension must be installed and the content script must be active
 * on this page (localhost) for this to work.
 */

let idCounter = 0;
const pending = new Map();
let bridgeInitialized = false;

export function initBridge() {
  if (bridgeInitialized) return;
  bridgeInitialized = true;

  window.addEventListener('message', (event) => {
    if (event.source !== window) return;
    if (!event.data || !event.data.__quickart_response) return;

    const { __requestId, ...rest } = event.data;
    const resolver = pending.get(__requestId);
    if (resolver) {
      pending.delete(__requestId);
      resolver(rest);
    }
  });
}

export function sendToExtension(type, payload = {}, timeoutMs = 15000) {
  return new Promise((resolve, reject) => {
    const id = `qr_${++idCounter}_${Date.now()}`;

    const timer = setTimeout(() => {
      pending.delete(id);
      reject(new Error('EXTENSION_TIMEOUT'));
    }, timeoutMs);

    pending.set(id, (data) => {
      clearTimeout(timer);
      resolve(data);
    });

    window.postMessage(
      { __quickart_request: type, __requestId: id, ...payload },
      '*'
    );
  });
}

export async function checkSessionStatus() {
  try {
    const resp = await sendToExtension('GET_SESSION_STATUS', {}, 5000);
    return resp;
  } catch {
    return { connected: false, reason: 'no_extension' };
  }
}

export async function searchProducts(query) {
  const resp = await sendToExtension('SEARCH', { query }, 20000);
  return resp;
}
