"""
Weight-aware group ranker.

Scores and sorts product groups based on how well they match
the quantity/weight the user asked for.

Scoring table:
    Exact weight match  (≤ 5 % diff)  → 100 pts
    Close weight match  (≤ 30 % diff) →  70 pts
    Same unit, far off  (≤ 200 % diff) →  40 pts
    Same unit, very far              →  20 pts
    Wrong unit                        →  10 pts
    No weight context in query        →  60 pts  (sort by price)

Within the same score tier, groups are ordered by their cheapest
platform price (ascending).
"""

from typing import Any, Dict, List, Optional, Tuple

from grouper import parse_weight


def rank_groups(
    groups: List[Dict[str, Any]],
    query: str,
) -> List[Dict[str, Any]]:
    """
    Re-order groups so the one that best matches the user's requested
    weight/quantity appears first.

    Args:
        groups:  Output of grouper.group_items()
        query:   Raw user query string, e.g. "find me atta 1 kg"

    Returns:
        Sorted list of groups, best match first.
    """
    target = parse_weight(query)

    scored = [(_score(group, target), group) for group in groups]
    scored.sort(key=lambda x: (
        -x[0],                                            # higher score first
        x[1]['matches'][0]['price'] if x[1]['matches'] else 9_999,  # cheaper first
    ))
    ranked = [g for _, g in scored]
    return _ensure_platform_diversity(ranked, base_count=6)


def _ensure_platform_diversity(
    ranked: List[Dict[str, Any]],
    base_count: int = 6,
) -> List[Dict[str, Any]]:
    """
    Take the top `base_count` groups, then append the best-ranked group from
    any platform not yet represented.  Guarantees every platform that returned
    results has at least one card visible, even if its items are more expensive.
    """
    result = list(ranked[:base_count])

    represented: set = set()
    for g in result:
        for m in g.get('matches', []):
            represented.add(m['platform'])

    for g in ranked[base_count:]:
        platforms = {m['platform'] for m in g.get('matches', [])}
        missing = platforms - represented
        if missing:
            result.append(g)
            represented |= missing

    return result


def _score(group: Dict[str, Any], target: Optional[Tuple[float, str]]) -> int:
    if target is None:
        # No weight in query — all groups are equal; sort only by price downstream
        return 60

    target_value, target_unit = target
    group_value = group.get('weightValue')
    group_unit  = group.get('weightUnit')

    if group_value is None or group_unit is None:
        return 30

    if group_unit != target_unit:
        return 10

    if target_value == 0:
        return 60

    diff_ratio = abs(group_value - target_value) / target_value

    if diff_ratio <= 0.05:
        return 100   # e.g. asked 1 kg, found 1 kg
    if diff_ratio <= 0.30:
        return 70    # e.g. asked 1 kg, found 900 g
    if diff_ratio <= 2.00:
        return 40    # e.g. asked 1 kg, found 500 g
    return 20        # e.g. asked 1 kg, found 50 g
