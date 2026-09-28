"""
ShopGPT Backend

SSE event format — every event is:
    data: {"type": "<event_type>", ...fields}\n\n

Event types:
    text        LLM is streaming a response token       { content: str }
    tool_call   LLM wants the extension to search       { tool: "initiate_search", query: str }
    suggestions Contextual follow-up chips              { items: [{label, action, query?}] }
    error       Something went wrong                    { message: str }
    done        Stream is finished                      {}
"""

import asyncio
import json
import logging
import re
from typing import Any, Dict, List, Optional

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import StreamingResponse
from pydantic import BaseModel

import llm
from cache import get_cached_data, set_cached_data
from grouper import group_items
from ranker import rank_groups

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

app = FastAPI(title="ShopGPT Backend")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# ── Models ────────────────────────────────────────────────────────────────────

class Message(BaseModel):
    role: str
    content: str

class ChatRequest(BaseModel):
    messages: List[Message]
    pincode: Optional[str] = None

class SearchResult(BaseModel):
    platform: str
    pincode: str
    query: str
    items: List[Dict[str, Any]]

class RankRequest(BaseModel):
    query: str
    items: List[Dict[str, Any]]

class SummaryRequest(BaseModel):
    query: str
    groups: List[Dict[str, Any]]

# ── System prompts ────────────────────────────────────────────────────────────

CHAT_SYSTEM_PROMPT = """You are ShopGPT, a smart shopping assistant for Indian quick-commerce apps (Zepto, Blinkit, Swiggy Instamart, Flipkart Minutes).

## SEARCH RULE — highest priority
When the user explicitly wants to find, buy, check prices, or compare products, output ONLY this on a single line with no other text before or after:
[SEARCH: item1, item2, ...]

Examples:
  "find me atta 1kg"                       → [SEARCH: atta 1kg]
  "how much does amul butter 500g cost?"   → [SEARCH: amul butter 500g]
  "I need eggs, milk and bread"            → [SEARCH: eggs, milk, bread]

## RESPONSE RULE
For recipes, meal plans, health tips, and general questions — respond in clean markdown.
Keep responses concise and practical. Use bullet points for ingredients and steps.
Do NOT include a [SEARCH:...] tag in informational responses.
"""

SEARCH_SUMMARY_PROMPT = """You are a direct shopping assistant. Given product search results, write exactly ONE sentence.

Rules:
- Name the cheapest product and its platform and price
- Add per-unit cost if weight is available, e.g. "at ₹58 (₹5.8/100g)"
- No greeting, no "Great news", no markdown — just the plain sentence
- Example: "Best deal is Patanjali Atta 1kg on Zepto at ₹45 (₹4.5/100g)."
"""

SEARCH_SUGGESTION_PROMPT = """You generate 3 follow-up action chips for a shopping price-comparison app.
Output ONLY a JSON array. No explanation.

Rules:
- Chip 1: A related item to search for — action: "search"
- Chip 2: A useful filter or variant — action: "followup", e.g. "Show only 500g options"
- Chip 3: Another related search — action: "search"
- Labels must be under 40 characters

Format: [{"label": "...", "action": "search"|"followup", "query": "..." (required for search)}]
"""

SUGGESTION_SYSTEM_PROMPT = """You generate follow-up suggestion chips for a shopping assistant app.
Given an assistant response, output exactly 3 chips as a JSON array.

Rules:
1. If the response contains a recipe or ingredient list, chip 1 MUST have:
   {"label": "Find prices for ingredients", "action": "search", "query": "<comma-separated raw ingredients>"}
   Extract only shoppable grocery items (not quantities, not methods).
2. Other chips use "action": "followup" and have a short label (under 45 chars) the user can click.
3. Make chips specific to THIS response — not generic.

Output ONLY the JSON array. No explanation, no markdown fences.
"""

# ── SSE helpers ───────────────────────────────────────────────────────────────

def sse(event_type: str, **kwargs) -> str:
    return f"data: {json.dumps({'type': event_type, **kwargs})}\n\n"

# Sentinel the LLM uses to request a product search
_SEARCH_RE = re.compile(r'\[SEARCH:\s*(.+?)\]', re.DOTALL | re.IGNORECASE)

# ── Chat stream ───────────────────────────────────────────────────────────────

@app.post("/api/chat-stream")
async def chat_stream(req: ChatRequest):
    async def generate():
        messages = [m.dict() for m in req.messages]

        try:
            accumulated = ""
            search_triggered = False
            emitted_to = 0  # cursor: how far into `accumulated` we've safely emitted

            async for chunk in llm.stream_chat(messages, CHAT_SYSTEM_PROMPT):
                accumulated += chunk

                # Detect completed search sentinel anywhere in buffer
                match = _SEARCH_RE.search(accumulated)
                if match:
                    query = match.group(1).strip()
                    logger.info(f"[Tool Call] initiate_search → '{query}'")
                    # Emit only the tool call — suppress all buffered text
                    yield sse("tool_call", tool="initiate_search", query=query)
                    search_triggered = True
                    break

                # Stream text up to the first unprocessed '[' (potential sentinel start).
                # This prevents ANY sentinel fragment from leaking to the UI regardless
                # of how the LLM splits the token stream.
                bracket_idx = accumulated.find('[', emitted_to)
                if bracket_idx == -1:
                    # No '[' anywhere ahead — safe to emit all new content
                    to_emit = accumulated[emitted_to:]
                    if to_emit:
                        yield sse("text", content=to_emit)
                    emitted_to = len(accumulated)
                else:
                    # Emit only up to the bracket; hold the rest
                    to_emit = accumulated[emitted_to:bracket_idx]
                    if to_emit:
                        yield sse("text", content=to_emit)
                    emitted_to = bracket_idx

            # Log the full LLM response (streaming accumulation complete)
            if accumulated.strip():
                preview = accumulated if len(accumulated) <= 900 else accumulated[:900] + "…"
                logger.info(f"\n{'─'*64}\n[LLM ← chat-stream]\n{preview}\n{'─'*64}")

            # After a normal (non-search) response, generate suggestion chips
            if not search_triggered and accumulated.strip():
                try:
                    raw_suggestions = await asyncio.wait_for(
                        llm.complete(
                            [{"role": "user", "content": f"Assistant response:\n{accumulated}"}],
                            SUGGESTION_SYSTEM_PROMPT,
                            json_mode=True,
                            timeout=20.0,
                        ),
                        timeout=22.0,
                    )
                    suggestions = json.loads(raw_suggestions)
                    if isinstance(suggestions, list) and suggestions:
                        yield sse("suggestions", items=suggestions[:3])
                except asyncio.TimeoutError:
                    logger.warning("Suggestion generation timed out — skipping chips.")
                except Exception as e:
                    logger.warning(f"Suggestion generation failed: {e}")

        except ConnectionError as e:
            yield sse("error", message=str(e))
        except Exception as e:
            logger.error(f"Chat stream error: {e}", exc_info=True)
            yield sse("error", message="Something went wrong. Please try again.")

        yield sse("done")

    return StreamingResponse(generate(), media_type="text/event-stream")


# ── Cache endpoints ───────────────────────────────────────────────────────────

@app.post("/api/cache/results")
async def save_results(result: SearchResult):
    cache_key = f"{result.pincode}_{result.query.lower().strip()}"
    set_cached_data(result.platform, cache_key, result.items)

    # Log raw extension payload
    lines = [
        f"\n{'─'*64}",
        f"[EXT → CACHE]  platform={result.platform}  query='{result.query}'  items={len(result.items)}",
    ]
    for i, item in enumerate(result.items[:5]):
        lines.append(f"  [{i}] {json.dumps(item, ensure_ascii=False)}")
    if len(result.items) > 5:
        lines.append(f"  … and {len(result.items) - 5} more items")
    lines.append("─" * 64)
    logger.info("\n".join(lines))

    return {"status": "success"}


@app.get("/api/cache/results")
async def get_results(platform: str, pincode: str, query: str):
    cache_key = f"{pincode}_{query.lower().strip()}"
    data = get_cached_data(platform, cache_key)
    if data:
        return {"hit": True, "items": data}
    return {"hit": False}


# ── Rank / group endpoint ─────────────────────────────────────────────────────

@app.post("/api/rank-items")
async def rank_items(req: RankRequest):
    """
    Deterministically group and rank scraped items.
    No LLM calls — pure algorithmic processing.
    Fast, consistent, no hallucinated IDs.
    """
    # Log raw items received for ranking
    lines = [
        f"\n{'─'*64}",
        f"[EXT → RANK]  query='{req.query}'  items={len(req.items)}",
    ]
    for i, item in enumerate(req.items[:5]):
        lines.append(f"  [{i}] {json.dumps(item, ensure_ascii=False)}")
    if len(req.items) > 5:
        lines.append(f"  … and {len(req.items) - 5} more items")
    lines.append("─" * 64)
    logger.info("\n".join(lines))

    try:
        # Deduplicate by platformId+platform to avoid double-counting
        seen = set()
        unique_items = []
        for item in req.items:
            key = (item.get("platform", ""), item.get("platformId", ""))
            if key not in seen:
                seen.add(key)
                unique_items.append(item)

        groups = group_items(unique_items)
        ranked = rank_groups(groups, req.query)

        logger.info(
            f"[Rank] '{req.query}' → {len(unique_items)} items → "
            f"{len(groups)} groups → top {min(6, len(ranked))} returned"
        )
        return {"status": "success", "groups": ranked[:6]}

    except Exception as e:
        logger.error(f"Rank error: {e}", exc_info=True)
        return {"status": "error", "error": str(e), "groups": []}


# ── Search summary endpoint ───────────────────────────────────────────────────

@app.post("/api/search-summary")
async def search_summary(req: SummaryRequest):
    """
    After products are shown, stream a one-sentence LLM commentary on the
    best deal, then emit contextual suggestion chips.
    This gives the assistant a "voice" after a product search.
    """
    async def generate():
        if not req.groups:
            yield sse("done")
            return

        # Build a compact, readable description of top results
        lines = []
        for g in req.groups[:3]:
            if not g.get("matches"):
                continue
            best = g["matches"][0]
            weight = g.get("normalizedWeight", "")
            per_unit = _calc_per_unit(best["price"], g.get("weightValue"), g.get("weightUnit"))
            line = (
                f"- {g['groupName']}"
                + (f" {weight}" if weight else "")
                + f": {best['platform']} ₹{best['price']}"
                + (f" ({per_unit})" if per_unit else "")
            )
            lines.append(line)

        if not lines:
            yield sse("done")
            return

        results_text = "\n".join(lines)
        summary_prompt = f'User searched: "{req.query}"\nTop results:\n{results_text}'

        logger.info(f"\n{'─'*64}\n[SUMMARY PROMPT]\n{summary_prompt}\n{'─'*64}")

        # Stream the one-sentence commentary
        try:
            async for chunk in llm.stream_chat(
                [{"role": "user", "content": summary_prompt}],
                SEARCH_SUMMARY_PROMPT,
            ):
                yield sse("text", content=chunk)
        except Exception as e:
            logger.warning(f"Search summary stream error: {e}")

        # Then generate contextual chips for the search results
        try:
            chips_prompt = f'User searched: "{req.query}". Results include: {", ".join(g["groupName"] for g in req.groups[:3])}'
            raw = await asyncio.wait_for(
                llm.complete(
                    [{"role": "user", "content": chips_prompt}],
                    SEARCH_SUGGESTION_PROMPT,
                    json_mode=True,
                    timeout=15.0,
                ),
                timeout=17.0,
            )
            chips = json.loads(raw)
            if isinstance(chips, list) and chips:
                yield sse("suggestions", items=chips[:3])
        except asyncio.TimeoutError:
            logger.warning("Post-search chips timed out.")
        except Exception as e:
            logger.warning(f"Post-search chips failed: {e}")

        yield sse("done")

    return StreamingResponse(generate(), media_type="text/event-stream")


def _calc_per_unit(price: float, weight_value, weight_unit) -> Optional[str]:
    """Return a human-readable per-unit price string, or None."""
    if not weight_value or not weight_unit:
        return None
    try:
        wv = float(weight_value)
        if wv <= 0:
            return None
        if weight_unit == "g" and wv >= 50:
            return f"₹{price / wv * 100:.1f}/100g"
        if weight_unit == "ml" and wv >= 50:
            return f"₹{price / wv * 100:.1f}/100ml"
    except (TypeError, ValueError):
        pass
    return None
