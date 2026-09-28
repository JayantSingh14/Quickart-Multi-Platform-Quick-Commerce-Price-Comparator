// Storage keys
export const STORAGE_KEYS = {
  ZEPTO_SESSION: 'zepto_session',
  BLINKIT_SESSION: 'blinkit_session',
  INSTAMART_SESSION: 'instamart_session',
  FLIPKART_SESSION: 'flipkart_session',
  CART: 'cart',
  MAPPING_CACHE: 'mapping_cache',
};

// Platform identifiers
export const PLATFORMS = {
  ZEPTO: 'zepto',
  BLINKIT: 'blinkit',
  SWIGGY: 'swiggy',
  FLIPKART: 'flipkart',
};

// Zepto API config
// NOTE: These endpoints are discovered by intercepting zepto.com network calls.
// Update here if endpoints change — all Zepto logic reads from this single source.
export const ZEPTO_CONFIG = {
  BFF_BASE: 'https://bff-gateway.zepto.com',
  WEB_BASE: 'https://www.zepto.com',

  ENDPOINTS: {
    // Discovered by intercepting zepto.com network calls
    SEARCH: '/user-search-service/api/v3/search',
    SEARCH_FILTERS: '/user-search-service/api/v3/search/filters',
  },

  // Headers Zepto expects on every request.
  // Values are captured from real browser session via content script.
  REQUIRED_HEADERS: [
    'authorization',
    'x-device-id',
    'x-request-id',
    'x-latitude',
    'x-longitude',
    'x-store-id',
    'x-session-id',
  ],

  // How long a captured session is considered valid before forcing re-capture.
  // Zepto web sessions typically last 30+ days, but we refresh conservatively.
  SESSION_TTL_MS: 12 * 60 * 60 * 1000, // 12 hours
};

export const BLINKIT_CONFIG = {
  SEARCH_BASE: 'https://blinkit.com',
  ENDPOINTS: {
    SEARCH: '/v1/layout/search',
  },
  SESSION_TTL_MS: 12 * 60 * 60 * 1000,
};

export const FLIPKART_CONFIG = {
  SEARCH_BASE: 'https://www.flipkart.com',
  ENDPOINTS: {
    SEARCH: '/search',
  },
  // How long a "seen Flipkart tab" marker is considered valid.
  SESSION_TTL_MS: 12 * 60 * 60 * 1000,
};

export const SWIGGY_CONFIG = {
  SEARCH_BASE: 'https://www.swiggy.com',
  ENDPOINTS: {
    SEARCH: '/api/instamart/search/v2',
  },
  SESSION_TTL_MS: 12 * 60 * 60 * 1000,

  // Fallback store IDs used when the session hasn't captured them yet.
  // These are the Swiggy Instamart store IDs for HSR Layout, Bengaluru.
  // They will be overridden once the user visits swiggy.com and a real session is captured.
  FALLBACK_STORE_ID: '1231052',
  FALLBACK_PRIMARY_STORE_ID: '1231052',
  FALLBACK_SECONDARY_STORE_ID: '1392660',
  FALLBACK_LAYOUT_ID: '4987',
};

// Unit normalization: everything maps to a base unit for price-per-unit math.
// Base unit for weight: grams. Base unit for volume: millilitres. Per piece: 1.
export const UNIT_MAP = {
  // weight
  g: 1,
  gm: 1,
  gms: 1,
  gram: 1,
  grams: 1,
  kg: 1000,
  kgs: 1000,
  kilogram: 1000,
  kilograms: 1000,

  // volume
  ml: 1,
  millilitre: 1,
  millilitres: 1,
  milliliter: 1,
  milliliters: 1,
  l: 1000,
  ltr: 1000,
  litre: 1000,
  litres: 1000,
  liter: 1000,
  liters: 1000,

  // count — treat 1 piece = 1 "unit", no conversion
  pcs: 1,
  pc: 1,
  piece: 1,
  pieces: 1,
  pack: 1,
  nos: 1,
  no: 1,
};

// Human-readable base unit label per dimension
export const BASE_UNIT_LABEL = {
  weight: '100g',
  volume: '100ml',
  count: 'pc',
};
