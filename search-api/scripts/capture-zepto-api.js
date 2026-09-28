/**
 * Capture Zepto BFF API calls with full request details.
 * Run: node scripts/capture-zepto-api.js
 *
 * Launches Playwright, sets location, performs a search,
 * and dumps every bff-gateway.zepto.com request/response to stdout.
 */

'use strict';

const { chromium } = require('playwright');
const fs = require('fs');

const LAT = 12.9716;  // Bangalore
const LON = 77.5946;
const QUERY = 'atta';
const OUT_FILE = '/tmp/zepto_api_capture.json';

const UA = 'Mozilla/5.0 (Linux; Android 14; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.82 Mobile Safari/537.36';

const delay = ms => new Promise(r => setTimeout(r, ms));
const captured = [];

async function main() {
  console.log('Launching browser...');
  const browser = await chromium.launch({ headless: false, args: ['--no-sandbox'] });
  const context = await browser.newContext({
    userAgent: UA,
    viewport: { width: 390, height: 844 },   // iPhone 14 viewport
    geolocation: { latitude: LAT, longitude: LON },
    permissions: ['geolocation'],
  });

  const page = await context.newPage();

  // ── Capture ALL bff-gateway requests ────────────────────────────────────────
  page.on('request', req => {
    const url = req.url();
    if (!url.includes('bff-gateway.zepto.com')) return;
    const entry = {
      type: 'request',
      method: req.method(),
      url,
      headers: req.headers(),
      postData: req.postData() || null,
      timestamp: new Date().toISOString(),
    };
    captured.push(entry);
    console.log(`\n→ REQUEST: ${req.method()} ${url}`);
    if (entry.postData) {
      try {
        const parsed = JSON.parse(entry.postData);
        console.log('  BODY:', JSON.stringify(parsed, null, 2).slice(0, 800));
      } catch {
        console.log('  BODY:', entry.postData.slice(0, 400));
      }
    }
    const importantHeaders = ['x-store-id', 'x-device-id', 'x-session-id',
      'x-user-id', 'authorization', 'x-auth-token', 'x-app-version',
      'x-platform', 'x-latitude', 'x-longitude', 'x-tenant-id',
      'x-channel', 'appversion', 'cookie'];
    for (const h of importantHeaders) {
      if (req.headers()[h]) console.log(`  ${h}: ${req.headers()[h]}`);
    }
  });

  page.on('response', async res => {
    const url = res.url();
    if (!url.includes('bff-gateway.zepto.com')) return;
    let body = null;
    try { body = await res.text(); } catch {}
    const entry = {
      type: 'response',
      status: res.status(),
      url,
      headers: res.headers(),
      body: body ? body.slice(0, 5000) : null,
      timestamp: new Date().toISOString(),
    };
    captured.push(entry);
    console.log(`\n← RESPONSE: ${res.status()} ${url}`);
    if (body) {
      try {
        const j = JSON.parse(body);
        // Show structure without full data
        const keys = Object.keys(j);
        console.log('  Top-level keys:', keys.join(', '));
      } catch {}
    }
  });

  // ── Navigate home and set location ─────────────────────────────────────────
  console.log('\nNavigating to zepto.com...');
  await page.goto('https://www.zepto.com/', { waitUntil: 'domcontentloaded', timeout: 30000 });
  await delay(3000);

  // Click "Select Location"
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
  console.log('Clicked Select Location:', clicked);
  await delay(1000);

  // Click "Use My Current Location"
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
  console.log('Clicked Use My Current Location');

  // Wait for location to be set (up to 10s)
  for (let i = 0; i < 20; i++) {
    const ready = await page.evaluate(() => {
      const t = document.body?.innerText || '';
      return !t.includes('Select Location') && (t.includes('min') || t.includes('Search'));
    });
    if (ready) { console.log('✅ Location set!'); break; }
    await delay(500);
  }

  await delay(2000);

  // ── Search ──────────────────────────────────────────────────────────────────
  console.log(`\nSearching for "${QUERY}"...`);
  await page.goto(`https://www.zepto.com/search?query=${encodeURIComponent(QUERY)}`, {
    waitUntil: 'domcontentloaded', timeout: 20000,
  });
  await page.waitForLoadState('networkidle', { timeout: 15000 }).catch(() => {});
  await delay(3000);

  // ── Save ────────────────────────────────────────────────────────────────────
  fs.writeFileSync(OUT_FILE, JSON.stringify(captured, null, 2));
  console.log(`\n\nSaved ${captured.length} captured entries to ${OUT_FILE}`);
  console.log('\n=== SUMMARY ===');
  for (const e of captured) {
    if (e.type === 'request') {
      console.log(`  ${e.method} ${e.url.replace('https://bff-gateway.zepto.com', '')}`);
    }
  }

  await browser.close();
}

main().catch(e => { console.error(e); process.exit(1); });
