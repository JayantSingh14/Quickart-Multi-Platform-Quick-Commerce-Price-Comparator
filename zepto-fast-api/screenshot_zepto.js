const { chromium } = require('playwright');
const fs = require('fs');

(async () => {
    const browser = await chromium.launch({ headless: false });
    const context = await browser.newContext({
        userAgent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
    });
    
    await context.addInitScript(() => {
        Object.defineProperty(navigator, 'webdriver', {
            get: () => undefined,
        });
    });

    const page = await context.newPage();
    try {
        await page.goto('https://www.zeptonow.com/', { waitUntil: 'domcontentloaded', timeout: 30000 });
        await page.waitForTimeout(5000);
        
        await page.screenshot({ path: 'zepto.png' });
        fs.writeFileSync('zepto.html', await page.content());
        console.log("Saved zepto.png and zepto.html");
    } catch (err) {
        console.log(err);
    } finally {
        await browser.close();
    }
})();
