/**
 * SKU normalizer — CJS port of adapters/normalizer.js
 * Parses raw product names into structured fields for NormalizedSKU shape.
 */

'use strict';

// ─── Constants (inline from shared/constants.js) ──────────────────────────────

const UNIT_MAP = {
  g: 1, gm: 1, gms: 1, gram: 1, grams: 1,
  kg: 1000, kgs: 1000, kilogram: 1000, kilograms: 1000,
  ml: 1, millilitre: 1, millilitres: 1, milliliter: 1, milliliters: 1,
  l: 1000, ltr: 1000, litre: 1000, litres: 1000, liter: 1000, liters: 1000,
  pcs: 1, pc: 1, piece: 1, pieces: 1, pack: 1, nos: 1, no: 1,
};

const BASE_UNIT_LABEL = {
  weight: '100g',
  volume: '100ml',
  count: 'pc',
};

// ─── Regexes ──────────────────────────────────────────────────────────────────

const QTY_REGEX = /(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|gram|grams|kilogram|kilograms|ml|millilitre|millilitres|milliliter|milliliters|l|ltr|litre|litres|liter|liters|pcs|pc|piece|pieces|pack|nos|no)/gi;
const PACK_REGEX = /pack\s+of\s+(\d+)\s*[x×]\s*(\d+(?:\.\d+)?)\s*(kg|g|gm|ml|l|ltr|pcs)/i;
const UNIT_X_COUNT_REGEX = /^(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|ml|l|ltr|pcs)\s*[x×]\s*(\d+(?:\.\d+)?)$/i;
const COUNT_X_UNIT_REGEX = /^(\d+(?:\.\d+)?)\s*[x×]\s*(\d+(?:\.\d+)?)\s*(kg|kgs|g|gm|gms|ml|l|ltr|pcs)$/i;

// ─── Helpers ──────────────────────────────────────────────────────────────────

function unitDimension(unitLower) {
  const weight = new Set(['g', 'gm', 'gms', 'gram', 'grams', 'kg', 'kgs', 'kilogram', 'kilograms']);
  const volume = new Set(['ml', 'millilitre', 'millilitres', 'milliliter', 'milliliters', 'l', 'ltr', 'litre', 'litres', 'liter', 'liters']);
  if (weight.has(unitLower)) return 'weight';
  if (volume.has(unitLower)) return 'volume';
  return 'count';
}

function toBaseUnit(qty, unit) {
  return qty * (UNIT_MAP[unit] ?? 1);
}

// ─── extractQuantity ──────────────────────────────────────────────────────────

function extractQuantity(name) {
  if (!name) return null;

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

  const unitXCount = name.trim().match(UNIT_X_COUNT_REGEX);
  if (unitXCount) {
    const singleQty = parseFloat(unitXCount[1]);
    const unit = unitXCount[2].toLowerCase();
    const count = parseFloat(unitXCount[3]);
    const totalBase = toBaseUnit(singleQty * count, unit);
    const dim = unitDimension(unit);
    const baseUnitStr = dim === 'weight' ? 'g' : dim === 'volume' ? 'ml' : 'pcs';
    const totalKgOrL = totalBase / 1000;
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

// ─── extractBrand ─────────────────────────────────────────────────────────────

const KNOWN_BRANDS = new Set([
  'amul', 'nestlé', 'nestle', 'britannia', 'haldirams', "haldiram's",
  'parle', 'maggi', 'munch', 'kitkat', "lay's", 'lays', 'kurkure',
  'quaker', 'saffola', 'fortune', 'aashirvaad', 'tata', 'lipton',
  'red label', 'bru', 'nescafe', 'horlicks', 'boost', 'complan',
  'dabur', 'patanjali', 'himalaya', 'dove', 'lux', 'lifebuoy',
  'colgate', 'pepsodent', 'closeup', 'sensodyne',
  'mother dairy', 'go cheese', 'heritage', 'milkbasket',
  'paper boat', 'real', 'tropicana', 'minute maid',
  'farm fresh', 'fresho', 'organic tattva',
]);

function extractBrand(name) {
  if (!name) return '';
  const lower = name.toLowerCase().trim();
  for (const brand of KNOWN_BRANDS) {
    if (lower.startsWith(brand)) {
      return name.substring(0, brand.length).trim();
    }
  }
  const firstWord = name.split(/[\s\-,–]/)[0];
  return firstWord ?? '';
}

// ─── computePricePerUnit ──────────────────────────────────────────────────────

function computePricePerUnit(price, quantityInBaseUnit, baseUnit) {
  if (!quantityInBaseUnit || quantityInBaseUnit <= 0) {
    return { value: null, label: null };
  }
  let value, label;
  if (baseUnit === 'count') {
    value = price / quantityInBaseUnit;
    label = `₹${value.toFixed(1)} / pc`;
  } else {
    value = (price / quantityInBaseUnit) * 100;
    const unitLabel = BASE_UNIT_LABEL[baseUnit];
    label = `₹${value.toFixed(1)} / ${unitLabel}`;
  }
  return { value, label };
}

// ─── normalizeProduct ─────────────────────────────────────────────────────────

function normalizeProduct(raw, platform, searchRank, mapFn) {
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

module.exports = { extractQuantity, extractBrand, computePricePerUnit, normalizeProduct };
