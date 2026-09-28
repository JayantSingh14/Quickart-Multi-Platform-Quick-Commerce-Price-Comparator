window.addEventListener('message', (event) => {
  if (event.source !== window) return;
  if (!event.data?.__quickart) return;

  const { type, ...payload } = event.data;

  if (type === 'INSTAMART_SESSION_CAPTURED' || type === 'INSTAMART_SEARCH_BODY_OBSERVED' || type === 'INSTAMART_HOME_OBSERVED') {
    chrome.runtime.sendMessage({ type, ...payload }, () => {
      void chrome.runtime.lastError;
    });
  }
});
