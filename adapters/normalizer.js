/**
 * SKU normalizer — parses raw product names into structured fields.
 *
 * Input:  "Quaker Rolled Oats - 1 Kg (Pack of 2)"
 * Output: { brand, productName, quantity: 1000, unit: 'g', baseUnit: 'weight',
 *           quantityInBaseUnit: 1000, displayQuantity: '1 kg' }
 *
 * Edge cases handled:
 *  - "500 gm" / "500g" / "500 G" → all normalize to { quantity: 500, unit: 'g' }
 *  - "1 kg" → { quantity: 1000, unit: 'g' } (converted to base)
 *  - "1 L" / "1 ltr" → { quantity: 1000, unit: 'ml' }
 *  - "Pack of 6 x 200ml" → quantity: 1200ml total
 *  - "6 pcs" → { quantity: 6, unit: 'pcs', baseUnit: 'count' }
 *  - Quantity embedded in name: "Amul Taaza 1L Milk" → extracted correctly
 */

import { UNIT_MAP, BASE_UNIT_LABEL } from '../shared/constants.js';

// ─── Quantity extraction ─────────────────────────────────────────────────────

// Matches patterns like: "1 kg", "500g", "1.5 L", "250 ml", "6 pcs", "6 nos"
const QTY_REGEX = /(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|gram|grams|kilogram|kilograms|ml|millilitre|millilitres|milliliter|milliliters|l|ltr|litre|litres|liter|liters|pcs|pc|piece|pieces|pack|nos|no)/gi;

// Matches "pack of N x Qunit" e.g. "Pack of 6 x 200ml"
const PACK_REGEX = /pack\s+of\s+(\d+)\s*[x×]\s*(\d+(?:\.\d+)?)\s*(kg|g|gm|ml|l|ltr|pcs)/i;

// Matches "Qunit x N" e.g. "1 kg x 2", "500 ml x 4", "200g x 3"
// This is Instamart/Swiggy's quantityDescription format for multi-packs.
const UNIT_X_COUNT_REGEX = /^(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|ml|l|ltr|pcs)\s*[x×]\s*(\d+(?:\.\d+)?)$/i;

// Matches "N x Qunit" e.g. "2 x 1 kg", "4 x 500g" (without "pack of" prefix)
const COUNT_X_UNIT_REGEX = /^(\d+(?:\.\d+)?)\s*[x×]\s*(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|ml|l|ltr|pcs)$/i;

/**
 * Determine the dimension of a unit string.
 * @param {string} unitLower
 * @returns {'weight'|'volume'|'count'}
 */
function unitDimension(unitLower) {
  const weight = new Set(['g', 'gm', 'gms', 'gram', 'grams', 'kg', 'kgs', 'kilogram', 'kilograms']);
  const volume = new Set(['ml', 'millilitre', 'millilitres', 'milliliter', 'milliliters', 'l', 'ltr', 'litre', 'litres', 'liter', 'liters']);
  if (weight.has(unitLower)) return 'weight';
  if (volume.has(unitLower)) return 'volume';
  return 'count';
}

/**
 * Convert quantity to base unit (grams or millilitres or pieces).
 * @param {number} qty
 * @param {string} unit  lower-cased unit string
 * @returns {number}
 */
function toBaseUnit(qty, unit) {
  const multiplier = UNIT_MAP[unit] ?? 1;
  return qty * multiplier;
}

/**
 * Extract quantity info from a product name string.
 * Returns the best match (prefers explicit qty like "1 kg" over "6 pcs").
 *
 * @param {string} name
 * @returns {{ quantity: number, unit: string, quantityInBaseUnit: number,
 *             baseUnit: 'weight'|'volume'|'count', displayQuantity: string } | null}
 */
export function extractQuantity(name) {
  if (!name) return null;

  // ── Most-specific patterns first ─────────────────────────────────────────────

  // "Pack of N x Q unit" e.g. "Pack of 6 x 200ml"
  const packMatch = name.match(PACK_REGEX);
  if (packMatch) {
    const count = parseFloat(packMatch[1]);
    const singleQty = parseFloat(packMatch[2]);
    const unit = packMatch[3].toLowerCase();
    const totalBase = toBaseUnit(singleQty * count, unit);
    const dim = unitDimension(unit);
    const baseUnitStr = dim === 'weight' ? 'g' : dim === 'volume' ? 'ml' : 'pcs';
    return {
      quantity: singleQty * count,
      unit: baseUnitStr,
      quantityInBaseUnit: totalBase,
      baseUnit: dim,
      displayQuantity: `${count} × ${singleQty}${unit}`,
    };
  }

  // "Q unit x N" e.g. "1 kg x 2", "500 ml x 4" — Instamart quantityDescription format
  const unitXCount = name.trim().match(UNIT_X_COUNT_REGEX);
  if (unitXCount) {
    const singleQty = parseFloat(unitXCount[1]);
    const unit = unitXCount[2].toLowerCase();
    const count = parseFloat(unitXCount[3]);
    const totalBase = toBaseUnit(singleQty * count, unit);
    const dim = unitDimension(unit);
    const baseUnitStr = dim === 'weight' ? 'g' : dim === 'volume' ? 'ml' : 'pcs';
    // displayQuantity: convert to clean total e.g. "2 kg" if exact, else "1 kg × 2"
    const totalKgOrL = totalBase / (dim === 'weight' ? 1000 : 1000);
    const displayQty = (dim !== 'count' && Number.isInteger(totalKgOrL) && totalKgOrL >= 1)
      ? `${totalKgOrL} ${dim === 'weight' ? 'kg' : 'L'}`
      : `${singleQty}${unit} × ${count}`;
    return {
      quantity: singleQty * count,
      unit: baseUnitStr,
      quantityInBaseUnit: totalBase,
      baseUnit: dim,
      displayQuantity: displayQty,
    };
  }

  // "N x Q unit" e.g. "2 x 1 kg", "4 x 500g" (without "pack of" prefix)
  const countXUnit = name.trim().match(COUNT_X_UNIT_REGEX);
  if (countXUnit) {
    const count = parseFloat(countXUnit[1]);
    const singleQty = parseFloat(countXUnit[2]);
    const unit = countXUnit[3].toLowerCase();
    const totalBase = toBaseUnit(singleQty * count, unit);
    const dim = unitDimension(unit);
    const baseUnitStr = dim === 'weight' ? 'g' : dim === 'volume' ? 'ml' : 'pcs';
    return {
      quantity: singleQty * count,
      unit: baseUnitStr,
      quantityInBaseUnit: totalBase,
      baseUnit: dim,
      displayQuantity: `${count} × ${singleQty}${unit}`,
    };
  }

  // General quantity match — collect all matches, pick best
  const matches = [];
  let m;
  QTY_REGEX.lastIndex = 0;
  while ((m = QTY_REGEX.exec(name)) !== null) {
    const qty = parseFloat(m[1]);
    const unit = m[2].toLowerCase();
    const dim = unitDimension(unit);
    const base = toBaseUnit(qty, unit);
    matches.push({ qty, unit, dim, base, raw: m[0] });
  }

  if (matches.length === 0) return null;

  // Prefer weight/volume over count; among same dimension prefer larger quantity
  const weightVol = matches.filter((m) => m.dim !== 'count');
  const chosen = weightVol.length > 0
    ? weightVol.reduce((a, b) => (a.base >= b.base ? a : b))
    : matches[0];

  const baseUnitStr = chosen.dim === 'weight' ? 'g' : chosen.dim === 'volume' ? 'ml' : 'pcs';
  return {
    quantity: chosen.qty,
    unit: baseUnitStr,
    quantityInBaseUnit: chosen.base,
    baseUnit: chosen.dim,
    displayQuantity: chosen.raw.trim(),
  };
}

// ─── Brand extraction ────────────────────────────────────────────────────────

// Known quick-commerce brands for better extraction.
// Not exhaustive — we fall back to first word if brand not recognized.
const KNOWN_BRANDS = new Set([
  'amul', 'nestlé', 'nestle', 'britannia', 'haldirams', "haldiram's",
  'parle', 'maggi', 'munch', 'kitkat', 'lay\'s', 'lays', 'kurkure',
  'quaker', 'saffola', 'fortune', 'aashirvaad', 'tata', 'lipton',
  'red label', 'bru', 'nescafe', 'horlicks', 'boost', 'complan',
  'dabur', 'patanjali', 'himalaya', 'dove', 'lux', 'lifebuoy',
  'colgate', 'pepsodent', 'closeup', 'sensodyne',
  'mother dairy', 'go cheese', 'heritage', 'milkbasket',
  'paper boat', 'real', 'tropicana', 'minute maid',
  'farm fresh', 'fresho', 'organic tattva',
]);

/**
 * Extract brand from product name.
 * Strategy: check against known brands → else use first word(s).
 */
export function extractBrand(name) {
  if (!name) return '';
  const lower = name.toLowerCase().trim();

  // Check two-word brands first, then single-word
  for (const brand of KNOWN_BRANDS) {
    if (lower.startsWith(brand)) {
      return name.substring(0, brand.length).trim();
    }
  }

  // Fallback: first word before space/dash/comma
  const firstWord = name.split(/[\s\-,–]/)[0];
  return firstWord ?? '';
}

// ─── Full normalizer ─────────────────────────────────────────────────────────

/**
 * Compute price per base unit.
 * @param {number} price
 * @param {number} quantityInBaseUnit  in grams or ml or pieces
 * @param {'weight'|'volume'|'count'} baseUnit
 * @returns {{ value: number, label: string }}  e.g. { value: 18.9, label: "₹18.9 / 100g" }
 */
export function computePricePerUnit(price, quantityInBaseUnit, baseUnit) {
  if (!quantityInBaseUnit || quantityInBaseUnit <= 0) {
    return { value: null, label: null };
  }

  let value, label;
  if (baseUnit === 'count') {
    value = price / quantityInBaseUnit;
    label = `₹${value.toFixed(1)} / pc`;
  } else {
    // Express as price per 100g or 100ml
    value = (price / quantityInBaseUnit) * 100;
    const unitLabel = BASE_UNIT_LABEL[baseUnit];
    label = `₹${value.toFixed(1)} / ${unitLabel}`;
  }

  return { value, label };
}

/**
 * Normalize a raw platform SKU into the common NormalizedSKU shape.
 *
 * @param {Object} raw            Platform-specific raw product object
 * @param {string} platform       'zepto' | 'blinkit' | 'swiggy'
 * @param {number} searchRank     1-based position in search results
 * @param {Function} mapFn        Platform-specific field mapper → { id, name, brand, price, mrp, imageUrl, inStock, deepLink }
 * @returns {import('./types.js').NormalizedSKU}
 */
export function normalizeProduct(raw, platform, searchRank, mapFn) {
  const mapped = mapFn(raw);

  const extractionStr = mapped.packsize ? `${mapped.name} ${mapped.packsize}` : mapped.name;
  const qtyInfo = extractQuantity(extractionStr) ?? {
    quantity: null,
    unit: null,
    quantityInBaseUnit: null,
    baseUnit: 'count',
    displayQuantity: null,
  };

  if (mapped.packsize) {
    qtyInfo.displayQuantity = mapped.packsize;
  }

  const brand = mapped.brand || extractBrand(mapped.name);

  // Product name = full name minus brand prefix and quantity suffix (best effort)
  let productName = mapped.name;
  if (brand && productName.toLowerCase().startsWith(brand.toLowerCase())) {
    productName = productName.substring(brand.length).replace(/^[\s\-–,]+/, '');
  }

  const pricePerUnit = computePricePerUnit(
    mapped.price,
    qtyInfo.quantityInBaseUnit,
    qtyInfo.baseUnit
  );

  return {
    platform,
    platformId: String(mapped.id),
    rawName: mapped.name,
    brand,
    productName,
    quantity: qtyInfo.quantity,
    unit: qtyInfo.unit,
    quantityInBaseUnit: qtyInfo.quantityInBaseUnit,
    baseUnit: qtyInfo.baseUnit,
    displayQuantity: qtyInfo.displayQuantity,
    price: mapped.price,
    mrp: mapped.mrp ?? mapped.price,
    pricePerBaseUnit: pricePerUnit.value,
    pricePerUnitLabel: pricePerUnit.label,
    imageUrl: mapped.imageUrl ?? '',
    inStock: mapped.inStock ?? true,
    searchRank,
    deepLink: mapped.deepLink ?? '',
  };
}
