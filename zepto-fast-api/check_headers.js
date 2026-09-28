const fs = require('fs');
const apis = JSON.parse(fs.readFileSync('zepto_apis.json'));
const bff = apis.find(a => a.url.includes('bff-gateway'));
console.log(JSON.stringify(bff.headers, null, 2));
