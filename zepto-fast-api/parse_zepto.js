const fs = require('fs');
const apis = JSON.parse(fs.readFileSync('zepto_apis.json'));

const keywords = ['eta', 'store', 'location', 'checkout', 'layout', 'cart'];
const relevantApis = apis.filter(api => {
    return keywords.some(kw => api.url.toLowerCase().includes(kw)) && api.url.includes('zepto');
});

const uniqueEndpoints = new Map();

relevantApis.forEach(api => {
    const urlObj = new URL(api.url);
    const basePath = urlObj.pathname;
    if (!uniqueEndpoints.has(basePath)) {
        uniqueEndpoints.set(basePath, {
            method: api.method,
            url: api.url,
            headers: api.headers,
            sampleResponse: JSON.stringify(api.body).substring(0, 500)
        });
    }
});

console.log(`Found ${uniqueEndpoints.size} unique relevant endpoints`);
for (const [path, data] of uniqueEndpoints.entries()) {
    console.log("=========================================");
    console.log(`Endpoint: ${data.method} ${data.url}`);
    
    // Log important headers
    const importantHeaders = ['authorization', 'device-id', 'tenant', 'x-csrf-token', 'app-version'];
    const headers = {};
    for (const h of importantHeaders) {
        if (data.headers[h] || data.headers[h.toLowerCase()]) {
            headers[h] = data.headers[h] || data.headers[h.toLowerCase()];
        }
    }
    console.log("Important Headers:", headers);
    console.log("Sample Response:", data.sampleResponse);
}
