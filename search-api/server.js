/**
 * Quickart Search API Server
 *
 * POST /api/search
 *   Body: { query: string, lat: number, lon: number, pincode?: string, address?: string }
 *   Response: { swiggy?: NormalizedSKU[], flipkart?: NormalizedSKU[], errors?: object }
 *
 * POST /api/eta
 *   Body: { lat: number, lon: number, pincode?: string }
 *   Response: { swiggy?: EtaResult, flipkart?: EtaResult }
 *
 * GET /api/health
 *   Response: { ok: true }
 *
 * Run: node server.js
 * Default port: 3210 (set PORT env var to override)
 */

'use strict';

const path = require('path');
require('dotenv').config({ path: path.join(__dirname, '.env') });

const http = require('http');

const PORT           = parseInt(process.env.PORT || '3210', 10);
const API_KEY        = process.env.API_KEY || '';               // require X-Api-Key header if set
const MAX_CONCURRENT = parseInt(process.env.MAX_CONCURRENT || '3', 10);

// Comma-separated list of allowed origins, e.g. "https://quickart.app,chrome-extension://abc"
// Defaults to '*' (open) — set this in production.
const ALLOWED_ORIGINS = process.env.ALLOWED_ORIGINS
  ? process.env.ALLOWED_ORIGINS.split(',').map(s => s.trim())
  : ['*'];

// Rate limits (requests per minute per IP)
const RATE_SEARCH = parseInt(process.env.RATE_LIMIT_SEARCH || '20', 10);
const RATE_ETA    = parseInt(process.env.RATE_LIMIT_ETA    || '10', 10);

const { searchInstamart, getInstamartEta } = require('./instamart.js');
const { searchFlipkart,  getFlipkartEta  } = require('./flipkart.js');
const { searchZepto,     getZeptoEta     } = require('./zepto.js');
const { searchBlinkit,   getBlinkitEta   } = require('./blinkit.js');

// ─── CORS ────────────────────────────────────────────────────────────────────

function getAllowOrigin(req) {
  if (ALLOWED_ORIGINS.includes('*')) return '*';
  const origin = req.headers.origin || '';
  return ALLOWED_ORIGINS.includes(origin) ? origin : null;
}

function corsHeaders(req) {
  const allowOrigin = getAllowOrigin(req);
  return {
    'Access-Control-Allow-Origin':  allowOrigin || '',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
    'Access-Control-Allow-Headers': 'Content-Type, X-Api-Key',
    'Content-Type': 'application/json',
  };
}

function send(res, status, body, req) {
  res.writeHead(status, corsHeaders(req || {}));
  res.end(JSON.stringify(body));
}

// ─── API key auth ─────────────────────────────────────────────────────────────

function isAuthorized(req) {
  if (!API_KEY) return true;                            // not configured → open
  return req.headers['x-api-key'] === API_KEY;
}

// ─── In-flight concurrency cap ────────────────────────────────────────────────

let _inFlight = 0;

// ─── Sliding-window rate limiter (in-memory, per IP) ─────────────────────────

const _rateLimitBuckets = new Map(); // ip -> [timestamp, ...]

function isRateLimited(ip, limitPerMin) {
  const now    = Date.now();
  const cutoff = now - 60_000;
  let hits = (_rateLimitBuckets.get(ip) || []).filter(t => t > cutoff);
  if (hits.length >= limitPerMin) {
    _rateLimitBuckets.set(ip, hits);
    return true;
  }
  hits.push(now);
  _rateLimitBuckets.set(ip, hits);
  return false;
}

// Prune stale entries every 5 minutes to avoid memory leak
setInterval(() => {
  const cutoff = Date.now() - 60_000;
  for (const [ip, hits] of _rateLimitBuckets) {
    if (!hits.some(t => t > cutoff)) _rateLimitBuckets.delete(ip);
  }
}, 5 * 60_000).unref();

function clientIp(req) {
  // Trust X-Forwarded-For only if you put a trusted proxy (e.g. Cloud Load Balancer) in front.
  // On a raw VM without a proxy, use remoteAddress directly.
  return (process.env.TRUST_PROXY === '1'
    ? (req.headers['x-forwarded-for'] || '').split(',')[0].trim()
    : null)
    || req.socket?.remoteAddress
    || 'unknown';
}

// ─── Request body reader (with size cap) ─────────────────────────────────────

const MAX_BODY = 10 * 1024; // 10 KB

function readJson(req) {
  return new Promise((resolve, reject) => {
    let data = '';
    let size = 0;
    req.on('data', (chunk) => {
      size += chunk.length;
      if (size > MAX_BODY) {
        req.destroy(new Error('Request body too large'));
        return;
      }
      data += chunk;
    });
    req.on('end', () => {
      try { resolve(data ? JSON.parse(data) : {}); }
      catch { reject(new Error('Invalid JSON body')); }
    });
    req.on('error', reject);
  });
}

// ─── Shared pre-flight checks ─────────────────────────────────────────────────

/**
 * Returns true if the request should be rejected (response already sent).
 */
function rejectIfInvalid(req, res, rateLimit) {
  const origin = getAllowOrigin(req);
  if (ALLOWED_ORIGINS[0] !== '*' && !origin) {
    send(res, 403, { error: 'Origin not allowed' }, req);
    return true;
  }

  if (!isAuthorized(req)) {
    send(res, 401, { error: 'Unauthorized' }, req);
    return true;
  }

  const ip = clientIp(req);
  if (isRateLimited(ip, rateLimit)) {
    res.writeHead(429, { ...corsHeaders(req), 'Retry-After': '60' });
    res.end(JSON.stringify({ error: 'Too many requests — please slow down' }));
    return true;
  }

  if (_inFlight >= MAX_CONCURRENT) {
    send(res, 503, { error: 'Server busy, try again shortly' }, req);
    return true;
  }

  return false;
}

// ─── ETA handler ─────────────────────────────────────────────────────────────

/** Wraps a promise; logs wall time per platform (parallel batch = slowest wins). */
function etaTimed(label, promise, timings) {
  const t0 = Date.now();
  return promise.then(
    (value) => {
      const ms = Date.now() - t0;
      timings[label] = ms;
      console.log(`[eta] ${label} done in ${ms}ms`);
      return value;
    },
    (err) => {
      const ms = Date.now() - t0;
      timings[label] = ms;
      console.log(`[eta] ${label} failed in ${ms}ms:`, err?.message || err);
      return null;
    }
  );
}

async function handleEta(req, res) {
  if (rejectIfInvalid(req, res, RATE_ETA)) return;

  let body;
  try { body = await readJson(req); } catch { return send(res, 200, {}, req); }

  const { lat, lon, pincode } = body;
  const canFetch = (typeof lat === 'number' && typeof lon === 'number') || !!pincode;
  if (!canFetch) return send(res, 200, {}, req);

  _inFlight++;
  try {
    const batchStart = Date.now();
    const etaTimings = {};
    console.log('[eta] parallel batch started (swiggy, flipkart, zepto, blinkit)');

    const [instamartEta, flipkartEta, zeptoEta, blinkitEta] = await Promise.all([
      etaTimed('swiggy (instamart)', getInstamartEta({ lat, lon, pincode }).catch(() => null), etaTimings),
      etaTimed('flipkart', getFlipkartEta({ lat, lon, pincode }).catch(() => null), etaTimings),
      etaTimed('zepto', getZeptoEta({ lat, lon }).catch(() => null), etaTimings),
      etaTimed('blinkit', getBlinkitEta({ lat, lon }).catch(() => null), etaTimings),
    ]);

    const totalMs = Date.now() - batchStart;
    const slowest = Object.entries(etaTimings).sort((a, b) => b[1] - a[1])[0];
    console.log(
      `[eta] batch finished in ${totalMs}ms (Promise.all wall time ≈ slowest individual)`
    );
    if (slowest) {
      console.log(`[eta] slowest platform: ${slowest[0]} (${slowest[1]}ms)`);
    }

    const result = {};
    if (instamartEta) result.swiggy   = instamartEta;
    if (flipkartEta)  result.flipkart = flipkartEta;
    if (zeptoEta)     result.zepto    = zeptoEta;
    if (blinkitEta)   result.blinkit  = blinkitEta;
    send(res, 200, result, req);
  } finally {
    _inFlight--;
  }
}

// ─── Search handler ───────────────────────────────────────────────────────────

async function handleSearch(req, res) {
  if (rejectIfInvalid(req, res, RATE_SEARCH)) return;

  let body;
  try { body = await readJson(req); }
  catch { return send(res, 400, { error: 'Invalid JSON body' }, req); }

  const { query, lat, lon, pincode, address } = body;

  if (!query || typeof query !== 'string' || !query.trim()) {
    return send(res, 400, { error: 'query is required' }, req);
  }

  const hasLatLon = typeof lat === 'number' && typeof lon === 'number';
  const canSearchInstamart = hasLatLon || !!pincode;
  const canSearchLatLon    = hasLatLon; // Zepto, Blinkit, Flipkart need lat/lon

  console.log(`[search] "${query}" lat=${lat} lon=${lon} pincode=${pincode} ip=${clientIp(req)}`);

  _inFlight++;
  try {
    const tasks = {};

    if (canSearchInstamart) {
      tasks.swiggy = searchInstamart(query.trim(), { lat, lon, pincode, address: address || '' })
        .catch((err) => { console.error('[search] instamart error:', err.message); return { __error: err.message }; });
    }

    if (canSearchLatLon) {
      tasks.flipkart = searchFlipkart(query.trim(), { lat, lon, pincode })
        .catch((err) => { console.error('[search] flipkart error:', err.message); return { __error: err.message }; });

      tasks.zepto = searchZepto(query.trim(), { lat, lon })
        .catch((err) => { console.error('[search] zepto error:', err.message); return { __error: err.message }; });

      tasks.blinkit = searchBlinkit(query.trim(), { lat, lon })
        .catch((err) => { console.error('[search] blinkit error:', err.message); return { __error: err.message }; });
    }

    const [swiggyResult, flipkartResult, zeptoResult, blinkitResult] = await Promise.all([
      tasks.swiggy   ?? Promise.resolve(null),
      tasks.flipkart ?? Promise.resolve(null),
      tasks.zepto    ?? Promise.resolve(null),
      tasks.blinkit  ?? Promise.resolve(null),
    ]);

    const responseBody = {};
    const errors = {};

    const assign = (key, result) => {
      if (result === null) return;
      if (result?.__error) errors[key] = result.__error;
      else responseBody[key] = result;
    };

    assign('swiggy',   swiggyResult);
    assign('flipkart', flipkartResult);
    assign('zepto',    zeptoResult);
    assign('blinkit',  blinkitResult);

    if (Object.keys(errors).length > 0) responseBody.errors = errors;

    send(res, 200, responseBody, req);
  } finally {
    _inFlight--;
  }
}

// ─── HTTP server ──────────────────────────────────────────────────────────────

const server = http.createServer(async (req, res) => {
  if (req.method === 'OPTIONS') {
    res.writeHead(204, corsHeaders(req));
    res.end();
    return;
  }

  const url = req.url?.split('?')[0];

  if (url === '/api/health' && req.method === 'GET') {
    return send(res, 200, { ok: true, inFlight: _inFlight }, req);
  }

  if (url === '/api/search' && req.method === 'POST') {
    try { await handleSearch(req, res); }
    catch (err) {
      console.error('[server] Unhandled error:', err);
      send(res, 500, { error: 'Internal server error' }, req);
    }
    return;
  }

  if (url === '/api/eta' && req.method === 'POST') {
    try { await handleEta(req, res); }
    catch (err) {
      console.error('[server] ETA error:', err);
      send(res, 200, {}, req);
    }
    return;
  }

  send(res, 404, { error: 'Not found' }, req);
});

server.listen(PORT, () => {
  console.log(`[quickart-search-api] Listening on http://localhost:${PORT}`);
  console.log(`  Rate limits  : search=${RATE_SEARCH}/min  eta=${RATE_ETA}/min`);
  console.log(`  Concurrency  : max ${MAX_CONCURRENT} in-flight`);
  console.log(`  API key auth : ${API_KEY ? 'enabled' : 'disabled (set API_KEY to enable)'}`);
  console.log(`  CORS origins : ${ALLOWED_ORIGINS.join(', ')}`);
});
