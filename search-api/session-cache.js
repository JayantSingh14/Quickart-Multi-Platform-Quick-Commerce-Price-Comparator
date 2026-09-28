/**
 * In-memory + file-backed session cache.
 *
 * Stores:
 *   - aws-waf-token for Instamart (TTL: 55 min — tokens expire in ~1 hour)
 *   - Flipkart session cookies (TTL: 24 hours)
 *   - Instamart storeIds per lat/lon (TTL: 24 hours)
 */

'use strict';

const fs = require('fs');
const path = require('path');

const CACHE_DIR = path.join(__dirname, '.session-cache');
const FK_SESSION_FILE = path.join(CACHE_DIR, 'flipkart_session.json');
const IM_TOKEN_FILE = path.join(CACHE_DIR, 'instamart_waf_token.json');

if (!fs.existsSync(CACHE_DIR)) {
  fs.mkdirSync(CACHE_DIR, { recursive: true });
}

// ── In-memory caches ──────────────────────────────────────────────────────────

// { token: string, expiresAt: number }
let _instamartWafToken = null;
const IM_WAF_TTL_MS = 55 * 60 * 1000; // 55 minutes

// Map<`${lat},${lon}` → { primaryStoreId, secondaryStoreId, expiresAt }>
const _storeIdCache = new Map();
const STORE_ID_TTL_MS = 24 * 60 * 60 * 1000; // 24 hours

// ── Instamart WAF token ───────────────────────────────────────────────────────

function loadInstamartWafToken() {
  try {
    if (!fs.existsSync(IM_TOKEN_FILE)) return null;
    const data = JSON.parse(fs.readFileSync(IM_TOKEN_FILE, 'utf8'));
    if (!data.token || !data.expiresAt) return null;
    if (Date.now() > data.expiresAt) return null;
    return data;
  } catch {
    return null;
  }
}

function saveInstamartWafToken(token) {
  const expiresAt = Date.now() + IM_WAF_TTL_MS;
  const data = { token, expiresAt };
  try {
    fs.writeFileSync(IM_TOKEN_FILE, JSON.stringify(data));
  } catch {}
  _instamartWafToken = data;
  return data;
}

function getInstamartWafToken() {
  if (_instamartWafToken && Date.now() < _instamartWafToken.expiresAt) {
    return _instamartWafToken.token;
  }
  const fromFile = loadInstamartWafToken();
  if (fromFile) {
    _instamartWafToken = fromFile;
    return fromFile.token;
  }
  return null;
}

// ── Instamart storeIds by location ────────────────────────────────────────────

function getStoreIds(lat, lon) {
  const key = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;
  const entry = _storeIdCache.get(key);
  if (entry && Date.now() < entry.expiresAt) return entry;
  return null;
}

function setStoreIds(lat, lon, storeIds) {
  const key = `${Math.round(lat * 1000)},${Math.round(lon * 1000)}`;
  _storeIdCache.set(key, { ...storeIds, expiresAt: Date.now() + STORE_ID_TTL_MS });
}

// ── Flipkart session ──────────────────────────────────────────────────────────

const FK_TTL_MS = 24 * 60 * 60 * 1000; // 24 hours
let _flipkartSession = null;

function loadFlipkartSession() {
  try {
    if (!fs.existsSync(FK_SESSION_FILE)) return null;
    const data = JSON.parse(fs.readFileSync(FK_SESSION_FILE, 'utf8'));
    if (!data.cookies || !data.timestamp) return null;
    const age = Date.now() - new Date(data.timestamp).getTime();
    if (age > FK_TTL_MS) return null;
    return data;
  } catch {
    return null;
  }
}

function saveFlipkartSession(session) {
  const data = { ...session, timestamp: new Date().toISOString() };
  try {
    fs.writeFileSync(FK_SESSION_FILE, JSON.stringify(data, null, 2));
  } catch {}
  _flipkartSession = data;
  return data;
}

function getFlipkartSession() {
  if (_flipkartSession) {
    const age = Date.now() - new Date(_flipkartSession.timestamp).getTime();
    if (age < FK_TTL_MS) return _flipkartSession;
  }
  const fromFile = loadFlipkartSession();
  if (fromFile) {
    _flipkartSession = fromFile;
    return fromFile;
  }
  return null;
}

module.exports = {
  getInstamartWafToken,
  saveInstamartWafToken,
  getStoreIds,
  setStoreIds,
  getFlipkartSession,
  saveFlipkartSession,
};
