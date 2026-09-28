const { chromium } = require('playwright');
const fs = require('fs');

(async () => {
    // Launch non-headless to lower chances of Cloudflare blocking us instantly
    const browser = await chromium.launch({ headless: false });
    const context = await browser.newContext({
        userAgent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
    });
    
    // Attempt to bypass simple bot detection
    await context.addInitScript(() => {
        Object.defineProperty(navigator, 'webdriver', {
            get: () => undefined,
        });
    });

    const page = await context.newPage();
    const apiCalls = [];

    // Listen to network responses
    page.on('response', async (res) => {
        const url = res.url();
        const req = res.request();
        if (req.resourceType() === 'fetch' || req.resourceType() === 'xhr') {
            const method = req.method();
            const status = res.status();
            
            try {
                const headers = req.headers();
                let body = null;
                try {
                    body = await res.json();
                } catch (e) {
                    body = 'Not JSON or Failed to parse';
                }
                
                apiCalls.push({
                    url,
                    method,
                    status,
                    headers,
                    body
                });
            } catch (e) {
                // silently ignore aborted requests
            }
        }
    });

    try {
        console.log("Navigating to Zepto... please wait.");
        await page.goto('https://www.zeptonow.com/', { waitUntil: 'domcontentloaded', timeout: 30000 });
        
        console.log("Waiting 10 seconds for initial API calls to resolve...");
        await page.waitForTimeout(10000); // give it time to fetch location data
    } catch (err) {
        console.error("Error during navigation:", err.message);
    } finally {
        fs.writeFileSync('zepto_apis.json', JSON.stringify(apiCalls, null, 2));
        console.log(`Successfully intercepted ${apiCalls.length} Zepto API calls. Saved to zepto_apis.json.`);
        await browser.close();
    }
})();
