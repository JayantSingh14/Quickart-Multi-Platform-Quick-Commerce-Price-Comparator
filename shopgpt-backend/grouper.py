"""
Deterministic SKU grouper.

Groups raw scraped items from multiple platforms into product groups
without using an LLM. The algorithm:

  1. Extract and normalize the weight/volume from each product name.
  2. Strip weight + noise words to get a clean name token set.
  3. Group items whose token sets overlap above a threshold AND whose
     normalized weights match within a small tolerance.
  4. Within each group, sort platform matches cheapest-first.

No external dependencies — standard library only.
"""

import re
from typing import Any, Dict, List, Optional, Tuple

# ── Weight extraction ─────────────────────────────────────────────────────────

_WEIGHT_RE = re.compile(
    r'(\d+(?:\.\d+)?)\s*'
    r'(kg|kgs|kilogram|kilograms|'
    r'g|gm|gms|gram|grams|'
    r'l|ltr|ltrs|litre|litres|liter|liters|'
    r'ml|milliliter|milliliters|millilitre|millilitres|'
    r'piece|pieces|pc|pcs|pack|pkt)',
    re.IGNORECASE,
)

# Multiplier-pack pattern: "6 x 100ml", "4x250g"
_MULTIPACK_RE = re.compile(
    r'(\d+)\s*[xX×]\s*(\d+(?:\.\d+)?)\s*'
    r'(kg|g|gm|grams|l|ltr|ml)',
    re.IGNORECASE,
)


def parse_weight(text: str) -> Optional[Tuple[float, str]]:
    """
    Return (normalized_value, canonical_unit) from a product name/quantity string.
    Returns None if no weight found.

    Canonical units:  "g"  (grams),  "ml" (millilitres),  "pc" (pieces/packs)

    Examples:
        "Aashirvaad Atta 1kg"  → (1000.0, "g")
        "Amul Milk 500ml"      → (500.0,  "ml")
        "Eggs 6 pieces"        → (6.0,    "pc")
        "4x250ml Juice"        → (1000.0, "ml")   ← multipack: 4×250
    """
    # Check multipack first
    mp = _MULTIPACK_RE.search(text)
    if mp:
        count = float(mp.group(1))
        unit_val = float(mp.group(2))
        unit = mp.group(3).lower()
        total = count * unit_val
        return _to_canonical(total, unit)

    matches = _WEIGHT_RE.findall(text)
    if not matches:
        return None

    # Prefer the last match (most specific in product names like "Atta 1kg Bag")
    value_str, unit = matches[-1]
    return _to_canonical(float(value_str), unit.lower())


def _to_canonical(value: float, unit: str) -> Tuple[float, str]:
    if unit in ('kg', 'kgs', 'kilogram', 'kilograms'):
        return (value * 1000, 'g')
    if unit in ('g', 'gm', 'gms', 'gram', 'grams'):
        return (value, 'g')
    if unit in ('l', 'ltr', 'ltrs', 'litre', 'litres', 'liter', 'liters'):
        return (value * 1000, 'ml')
    if unit in ('ml', 'milliliter', 'milliliters', 'millilitre', 'millilitres'):
        return (value, 'ml')
    if unit in ('piece', 'pieces', 'pc', 'pcs', 'pack', 'pkt'):
        return (value, 'pc')
    return (value, unit)


def _format_weight(value: float, unit: str) -> str:
    """Human-readable weight string, e.g. 1000g → '1 kg', 500ml → '500 ml'."""
    if unit == 'g':
        if value >= 1000 and value % 1000 == 0:
            return f"{int(value // 1000)} kg"
        if value >= 1000:
            return f"{value / 1000:g} kg"
        return f"{value:g} g"
    if unit == 'ml':
        if value >= 1000 and value % 1000 == 0:
            return f"{int(value // 1000)} L"
        if value >= 1000:
            return f"{value / 1000:g} L"
        return f"{value:g} ml"
    if unit == 'pc':
        return f"{value:g} pc"
    return f"{value:g} {unit}"


# ── Name normalization ────────────────────────────────────────────────────────

_NOISE = {
    # Generic descriptors that don't differentiate products
    'fresh', 'new', 'premium', 'organic', 'natural', 'pure', 'best',
    'quality', 'special', 'classic', 'original', 'authentic', 'real',
    'super', 'ultra', 'extra', 'mini', 'regular', 'standard',
    # Packaging words
    'pouch', 'bag', 'box', 'bottle', 'jar', 'sachet', 'tin', 'can',
    'tetra', 'carton', 'container', 'refill',
    # Determiners / prepositions
    'the', 'a', 'an', 'of', 'with', 'for', 'and', 'in', 'by', 'from',
    # Common filler
    'combo', 'offer', 'pack', 'value',
}


def _normalize_tokens(name: str) -> frozenset:
    """
    Strip weight info + noise, return a frozenset of meaningful tokens.
    Used for fuzzy similarity comparison.
    """
    cleaned = _WEIGHT_RE.sub(' ', name)           # remove weight info
    cleaned = _MULTIPACK_RE.sub(' ', cleaned)
    cleaned = re.sub(r'[^a-z0-9\s]', ' ', cleaned.lower())
    tokens = {t for t in cleaned.split() if len(t) > 1 and t not in _NOISE}
    return frozenset(tokens)


def _jaccard(a: frozenset, b: frozenset) -> float:
    """Jaccard similarity (token set). Range 0–1."""
    if not a and not b:
        return 1.0
    if not a or not b:
        return 0.0
    return len(a & b) / len(a | b)


# ── Grouping ──────────────────────────────────────────────────────────────────

SIMILARITY_THRESHOLD = 0.55   # min token overlap to consider same product
WEIGHT_TOLERANCE     = 0.05   # 5 % tolerance on normalized weight values


def group_items(items: List[Dict[str, Any]]) -> List[Dict[str, Any]]:
    """
    Group raw scraped items into product groups.

    Input item fields used:
        rawName / name     product name string
        displayQuantity    fallback for weight extraction
        price              numeric price
        platform           platform identifier string
        platformId         platform-specific product ID
        imageUrl           product image URL

    Returns a list of group dicts:
    {
        "groupName":       str,   # best human-readable name for the group
        "normalizedWeight": str,  # e.g. "1 kg", "500 ml"
        "weightValue":     float | None,
        "weightUnit":      str | None,
        "matches": [
            {
                "platform":       str,
                "id":             str,
                "price":          float,
                "name":           str,
                "imageUrl":       str,
                "displayQuantity": str,
            }
        ]
    }
    Matches within each group are sorted cheapest-first.
    Groups with no valid price are dropped.
    """
    # Pre-process
    processed = []
    for item in items:
        name = item.get('rawName') or item.get('name') or ''
        qty  = item.get('displayQuantity', '')

        weight = parse_weight(name) or parse_weight(qty)
        tokens = _normalize_tokens(name)

        processed.append({
            'raw':          item,
            'tokens':       tokens,
            'weight_value': weight[0] if weight else None,
            'weight_unit':  weight[1] if weight else None,
        })

    assigned = [False] * len(processed)
    groups: List[Dict[str, Any]] = []

    for i, pi in enumerate(processed):
        if assigned[i]:
            continue

        members = [i]
        assigned[i] = True

        for j, pj in enumerate(processed):
            if assigned[j] or j == i:
                continue

            # Units must match (don't group g items with ml items)
            if pi['weight_unit'] != pj['weight_unit']:
                continue

            # Weights must match within tolerance
            vi, vj = pi['weight_value'], pj['weight_value']
            if vi is not None and vj is not None:
                avg = (vi + vj) / 2
                if avg > 0 and abs(vi - vj) / avg > WEIGHT_TOLERANCE:
                    continue
            elif vi != vj:
                # one has a weight, the other doesn't → different groups
                continue

            # Names must be similar
            if _jaccard(pi['tokens'], pj['tokens']) >= SIMILARITY_THRESHOLD:
                members.append(j)
                assigned[j] = True

        # Build group
        rep_raw = processed[members[0]]['raw']
        wv = processed[members[0]]['weight_value']
        wu = processed[members[0]]['weight_unit']

        matches = []
        for idx in members:
            raw = processed[idx]['raw']
            price = raw.get('price')
            if price is None:
                continue
            try:
                price = float(price)
            except (TypeError, ValueError):
                continue
            matches.append({
                'platform':        raw.get('platform', ''),
                'id':              raw.get('platformId', ''),
                'price':           price,
                'name':            raw.get('rawName') or raw.get('name', ''),
                'imageUrl':        raw.get('imageUrl', ''),
                'displayQuantity': raw.get('displayQuantity', ''),
            })

        if not matches:
            continue

        matches.sort(key=lambda x: x['price'])

        groups.append({
            'groupName':        rep_raw.get('rawName') or rep_raw.get('name', ''),
            'normalizedWeight': _format_weight(wv, wu) if wv and wu else rep_raw.get('displayQuantity', ''),
            'weightValue':      wv,
            'weightUnit':       wu,
            'matches':          matches,
        })

    return groups
