/**
 * One-off: headless Playwright — wait for GET …/consumerweb/eta 200 + JSON.
 * Run: node scripts/smoke-blinkit-eta.js
 */
'use strict';

const path = require('path');
require('dotenv').config({ path: path.join(__dirname, '..', '.env') });

const { chromium } = require('playwright');

const LAT = 28.6139;
const LON = 77.209;

async function main() {
  console.log('Launching Chromium (headless)...');
  const browser = await chromium.launch({
    headless: true,
    args: ['--no-sandbox', '--disable-blink-features=AutomationControlled'],
  });
  const context = await browser.newContext({
    userAgent:
      'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
    viewport: { width: 1280, height: 800 },
    geolocation: { latitude: LAT, longitude: LON },
    permissions: ['geolocation'],
  });
  await context.addInitScript(() => {
    Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
  });
  const page = await context.newPage();

  const etaPromise = page.waitForResponse(
    (r) => r.url().includes('/consumerweb/eta') && r.status() === 200,
    { timeout: 60000 }
  );

  await page.goto('https://blinkit.com/', { waitUntil: 'domcontentloaded', timeout: 30000 });
  await new Promise((r) => setTimeout(r, 2000));

  const clicked = await page.evaluate(() => {
    const labels = ['Detect my location', 'Use current location', 'Detect location'];
    const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT);
    let node;
    while ((node = walker.nextNode())) {
      const t = node.textContent.trim();
      if (labels.some((l) => t === l || (l.length > 8 && t.includes(l)))) {
        const el = node.parentElement;
        if (el) {
          el.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true }));
          return true;
        }
      }
    }
    return false;
  });
  console.log('Clicked detect location:', clicked);
  if (!clicked) {
    await page.reload({ waitUntil: 'domcontentloaded' });
    await new Promise((r) => setTimeout(r, 2500));
  }

  const res = await etaPromise;
  const text = await res.text();
  console.log('ETA URL:', res.url());
  const json = JSON.parse(text);
  console.log('ETA JSON keys:', Object.keys(json));
  const mins =
    json.eta_in_minutes ??
    json.response?.eta_in_minutes ??
    json.data?.eta_in_minutes;
  console.log('eta_in_minutes (resolved):', mins);
  await browser.close();
  process.exit(0);
}

main().catch((e) => {
  console.error('FAIL:', e.message);
  process.exit(1);
});
