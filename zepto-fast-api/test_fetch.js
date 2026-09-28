async function getEta() {
  const url = 'https://bff-gateway.zepto.com/lms/api/v2/get_page?latitude=12.96902&longitude=77.75395&page_type=HOME&version=v2&show_new_eta_banner=true&page_size=3&enforce_platform_type=DESKTOP';
  
  const start = Date.now();
  const response = await fetch(url, {
    headers: {
      'tenant': 'ZEPTO',
      'platform': 'WEB'
    }
  });
  
  const duration = Date.now() - start;
  console.log(`Status: ${response.status}`);
  console.log(`Latency: ${duration}ms`);
  
  if (response.ok) {
    const data = await response.json();
    const storeResponse = data.storeDetailsResponse || {};
    const etaInfo = data.pageLayout?.header?.widget?.data?.etaInfo || {};
    
    console.log(`Store Name: ${storeResponse.name}`);
    console.log(`ETA: ${etaInfo.etaInMinutes} minutes`);
    console.log(`Deliverable: ${etaInfo.isDeliverable}`);
  }
}

getEta();
