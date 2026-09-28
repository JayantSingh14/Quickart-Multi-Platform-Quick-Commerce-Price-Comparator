window.addEventListener('message', (event) => {
  if (event.source !== window) return;
  if (!event.data?.__quickart) return;

  const { type, ...payload } = event.data;

  if (type === 'BLINKIT_SESSION_CAPTURED' || type === 'BLINKIT_SEARCH_BODY_OBSERVED') {
    chrome.runtime.sendMessage({ type, ...payload }, () => {
      void chrome.runtime.lastError;
    });
  }
});
