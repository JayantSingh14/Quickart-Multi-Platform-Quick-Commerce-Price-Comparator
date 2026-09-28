/**
 * Run Zepto search through mitmproxy to capture real API calls.
 * node scripts/capture-via-proxy.js
 */
'use strict';

const { chromium } = require('playwright');

const LAT = 12.9716;
const LON = 77.5946;
const QUERY = 'atta';

const UA = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36';
const delay = ms => new Promise(r => setTimeout(r, ms));

async function main() {
  const browser = await chromium.launch({
    headless: false,
    args: ['--no-sandbox', '--ignore-certificate-errors'],
    proxy: { server: 'http://127.0.0.1:8081' },
  });
  const context = await browser.newContext({
    userAgent: UA,
    viewport: { width: 1280, height: 800 },
    geolocation: { latitude: LAT, longitude: LON },
    permissions: ['geolocation'],
    ignoreHTTPSErrors: true,
    proxy: { server: 'http://127.0.0.1:8081' },
  });

  const page = await context.newPage();

  console.log('Navigating to zepto.com...');
  await page.goto('https://www.zepto.com/', { waitUntil: 'domcontentloaded', timeout: 30000 });
  await delay(3000);

  const clicked = await page.evaluate(() => {
    const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
    let node;
    while ((node = walker.nextNode())) {
      if (node.textContent.trim() === 'Select Location') {
        node.parentElement?.dispatchEvent(new MouseEvent('click', { bubbles: true }));
        return true;
      }
    }
    return false;
  });
  console.log('Select Location clicked:', clicked);
  await delay(800);

  await page.evaluate(() => {
    const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
    let node;
    while ((node = walker.nextNode())) {
      if (node.textContent.trim() === 'Use My Current Location') {
        node.parentElement?.dispatchEvent(new MouseEvent('click', { bubbles: true }));
        return true;
      }
    }
    return false;
  });
  console.log('Use My Current Location clicked');

  for (let i = 0; i < 20; i++) {
    const ready = await page.evaluate(() => {
      const t = document.body?.innerText || '';
      return !t.includes('Select Location') && (t.includes('min') || t.includes('Search'));
    });
    if (ready) { console.log('✅ Location set!'); break; }
    await delay(500);
  }
  await delay(2000);

  console.log(`\nSearching for "${QUERY}"...`);
  await page.goto(`https://www.zepto.com/search?query=${encodeURIComponent(QUERY)}`, {
    waitUntil: 'domcontentloaded', timeout: 20000,
  });
  await page.waitForLoadState('networkidle', { timeout: 15000 }).catch(() => {});
  await delay(3000);

  console.log('\nDone — check /tmp/mitmdump_capture.log for API details');
  await browser.close();
}

main().catch(e => { console.error(e); process.exit(1); });
