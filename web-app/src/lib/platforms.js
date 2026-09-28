export const PLATFORMS = {
  zepto: {
    name: 'Zepto',
    shortName: 'Zepto',
    color: '#9B51E0',
    colorRgb: '155, 81, 224',
    bg: 'rgba(155, 81, 224, 0.12)',
    border: 'rgba(155, 81, 224, 0.28)',
    checkoutUrl: 'https://www.zepto.com/',
    tagline: '10-minute delivery',
  },
  blinkit: {
    name: 'Blinkit',
    shortName: 'Blinkit',
    color: '#F5A623',
    colorRgb: '245, 166, 35',
    bg: 'rgba(245, 166, 35, 0.12)',
    border: 'rgba(245, 166, 35, 0.28)',
    checkoutUrl: 'https://blinkit.com/',
    tagline: 'Blink & it\'s done',
  },
  swiggy: {
    name: 'Instamart',
    shortName: 'Instamart',
    color: '#FF5200',
    colorRgb: '255, 82, 0',
    bg: 'rgba(255, 82, 0, 0.12)',
    border: 'rgba(255, 82, 0, 0.28)',
    checkoutUrl: 'https://www.swiggy.com/instamart',
    tagline: 'Swiggy Instamart',
  },
  flipkart: {
    name: 'Flipkart Minutes',
    shortName: 'Fk Minutes',
    color: '#2874F0',
    colorRgb: '40, 116, 240',
    bg: 'rgba(40, 116, 240, 0.12)',
    border: 'rgba(40, 116, 240, 0.28)',
    checkoutUrl: 'https://www.flipkart.com/grocery',
    tagline: 'Flipkart Minutes',
  },
};

export function getPlatform(key) {
  return PLATFORMS[key] ?? {
    name: key,
    shortName: key,
    color: '#6B7280',
    colorRgb: '107, 114, 128',
    bg: 'rgba(107, 114, 128, 0.12)',
    border: 'rgba(107, 114, 128, 0.28)',
    checkoutUrl: '#',
    tagline: '',
  };
}

export const PLATFORM_ORDER = ['zepto', 'blinkit', 'swiggy', 'flipkart'];
