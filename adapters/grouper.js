/**
 * SKU Grouper + Ranking Engine
 *
 * Takes an array of NormalizedSKUs (from one or more platforms) and produces
 * ranked SKUGroups ready for display.
 *
 * Grouping rules:
 *  1. Group by (brand + productFamily). Different grammages of same product
 *     start in the same parent group.
 *  2. Grammage split: if a specific grammage appears on >= 2 platforms,
 *     it gets its own dedicated group.
 *  3. Grammages on only 1 platform remain in the parent catch-all group
 *     (shown as "Other sizes").
 *
 * Ranking rules:
 *  Inter-group  → primary: platformCount DESC, tiebreaker: weightedSearchScore DESC
 *  Intra-group  → pricePerBaseUnit ASC (lowest price first)
 *                 If pricePerBaseUnit unavailable, fall back to raw price ASC
 *
 * Edge cases handled:
 *  - All products from a single platform → groups still formed, no split possible
 *  - Products with no quantity info → grouped by name similarity only
 *  - Same product, wildly different prices → no special handling, user sees all
 *  - Identical platformId from same platform → deduplicated (take lower price)
 */

// ─── Helpers ─────────────────────────────────────────────────────────────────

/**
 * Slugify a string for use as a map key.
 * "Quaker Rolled Oats" → "quaker rolled oats"
 */
function slug(str) {
  return (str ?? '').toLowerCase().trim().replace(/\s+/g, ' ');
}

/**
 * Generate a stable group key from brand + productFamily.
 * productFamily is productName with quantity info stripped.
 */
function familyKey(sku) {
  const brand = slug(sku.brand);
  // Strip display quantity from productName to get family name
  let family = slug(sku.productName);
  if (sku.displayQuantity) {
    family = family.replace(slug(sku.displayQuantity), '').trim();
  }
  // Also strip raw quantity patterns e.g. "1 kg", "500g"
  family = family.replace(/\d+(?:\.\d+)?\s*(?:kg|g|gm|ml|l|ltr|pcs|pc|pack)/gi, '').trim();
  return `${brand}||${family}`;
}

/**
 * Generate a key for a specific grammage variant.
 * Two SKUs match grammage if same family AND same quantityInBaseUnit.
 */
function grammageKey(sku) {
  return `${familyKey(sku)}||${sku.quantityInBaseUnit ?? 'unknown'}`;
}

/**
 * Deduplicate SKUs: if same platform+platformId appears twice, keep lower price.
 */
function deduplicateSKUs(skus) {
  const seen = new Map();
  for (const sku of skus) {
    const key = `${sku.platform}:${sku.platformId}`;
    const existing = seen.get(key);
    if (!existing || sku.price < existing.price) {
      seen.set(key, sku);
    }
  }
  return Array.from(seen.values());
}

// ─── Weighted search score ────────────────────────────────────────────────────

/**
 * Compute a weighted search rank score for a set of SKUs.
 * Lower searchRank (position 1) = higher score.
 * Score = average of (100 / searchRank) across all SKUs in the group.
 */
function weightedSearchScore(skus) {
  if (skus.length === 0) return 0;
  const sum = skus.reduce((acc, sku) => acc + 100 / (sku.searchRank || 999), 0);
  return sum / skus.length;
}

// ─── Intra-group sort ─────────────────────────────────────────────────────────

function sortSkusWithinGroup(skus) {
  return [...skus].sort((a, b) => {
    // Primary: pricePerBaseUnit (normalized, apples-to-apples comparison)
    if (a.pricePerBaseUnit !== null && b.pricePerBaseUnit !== null) {
      return a.pricePerBaseUnit - b.pricePerBaseUnit;
    }
    // Fallback: raw price
    return a.price - b.price;
  });
}

// ─── Group builder ────────────────────────────────────────────────────────────

function buildGroup(groupId, skus, isGrammageGroup) {
  const sorted = sortSkusWithinGroup(skus);
  const best = sorted[0];

  const platforms = new Set(skus.map((s) => s.platform));

  // Canonical name: prefer grammage group name, else family name from first SKU
  const canonicalName = isGrammageGroup && best.displayQuantity
    ? `${best.brand} ${best.productName} ${best.displayQuantity}`.trim()
    : `${best.brand} ${best.productName}`.trim();

  return {
    groupId,
    canonicalName,
    brand: best.brand,
    productFamily: best.productName,
    quantity: best.quantity,
    unit: best.unit,
    quantityInBaseUnit: best.quantityInBaseUnit,
    displayQuantity: best.displayQuantity,
    isGrammageGroup,
    skus: sorted,
    platformCount: platforms.size,
    bestPrice: best.price,
    bestPlatform: best.platform,
    bestPricePerUnit: best.pricePerBaseUnit,
    bestPricePerUnitLabel: best.pricePerUnitLabel,
    weightedSearchScore: weightedSearchScore(skus),
    groupScore: 0, // filled in by rankGroups
  };
}

// ─── Main grouping logic ──────────────────────────────────────────────────────

/**
 * Group and rank an array of NormalizedSKUs.
 *
 * @param {NormalizedSKU[]} skus
 * @returns {SKUGroup[]}  Ranked array, best group first.
 */
export function groupAndRank(skus) {
  if (!skus || skus.length === 0) return [];

  const deduped = deduplicateSKUs(skus);

  // ── Step 1: Bucket by product family ──────────────────────────────────────
  // familyBuckets: Map<familyKey, NormalizedSKU[]>
  const familyBuckets = new Map();
  for (const sku of deduped) {
    const key = familyKey(sku);
    if (!familyBuckets.has(key)) familyBuckets.set(key, []);
    familyBuckets.get(key).push(sku);
  }

  // ── Step 2: Within each family, apply grammage split ──────────────────────
  const groups = [];
  let groupCounter = 0;

  for (const [, familySkus] of familyBuckets) {
    // Sub-bucket by grammage
    const grammageMap = new Map(); // grammageKey → NormalizedSKU[]
    const unknownQty = [];         // SKUs with no quantity info

    for (const sku of familySkus) {
      if (sku.quantityInBaseUnit === null) {
        unknownQty.push(sku);
        continue;
      }
      const gKey = grammageKey(sku);
      if (!grammageMap.has(gKey)) grammageMap.set(gKey, []);
      grammageMap.get(gKey).push(sku);
    }

    const orphans = [...unknownQty]; // will collect single-platform grammages too

    for (const [, gramSkus] of grammageMap) {
      const distinctPlatforms = new Set(gramSkus.map((s) => s.platform));

      if (distinctPlatforms.size >= 2) {
        // Enough platforms → dedicated grammage group
        groups.push(buildGroup(`g${++groupCounter}`, gramSkus, true));
      } else {
        // Single platform → orphan, goes into catch-all
        orphans.push(...gramSkus);
      }
    }

    // Orphan catch-all group (may have mixed grammages from 1 platform each)
    if (orphans.length > 0) {
      groups.push(buildGroup(`g${++groupCounter}`, orphans, false));
    }
  }

  // ── Step 3: Rank groups ───────────────────────────────────────────────────
  return rankGroups(groups);
}

// ─── Inter-group ranking ──────────────────────────────────────────────────────

/**
 * Sort groups:
 *  Primary  → platformCount DESC (more platforms = more relevant)
 *  Tiebreak → weightedSearchScore DESC (higher avg rank on platforms = better match)
 */
function rankGroups(groups) {
  return groups
    .map((g) => ({
      ...g,
      groupScore: g.platformCount * 10000 + g.weightedSearchScore,
    }))
    .sort((a, b) => b.groupScore - a.groupScore);
}
