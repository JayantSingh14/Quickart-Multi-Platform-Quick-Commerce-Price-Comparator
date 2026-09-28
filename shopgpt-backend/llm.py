"""
LLM provider abstraction.

Switch between Ollama (local, for dev/testing) and Groq (cloud, for production)
by setting environment variables:

    LLM_PROVIDER=ollama  (default)
    LLM_PROVIDER=groq
    GROQ_API_KEY=gsk_...
    GROQ_MODEL=llama-3.3-70b-versatile   (optional override)
    OLLAMA_BASE_URL=http://localhost:11434 (optional override)
    OLLAMA_MODEL=qwen2.5:7b              (optional override)

Both providers expose the same two functions:
    stream_chat()   → async generator of text chunks
    complete()      → single-shot full response string
"""

import os
import json
import logging
import asyncio
import httpx
from typing import AsyncGenerator, List, Dict, Any, Optional

logger = logging.getLogger(__name__)

# ── Config ────────────────────────────────────────────────────────────────────

PROVIDER = os.getenv("LLM_PROVIDER", "ollama").lower()

OLLAMA_BASE_URL = os.getenv("OLLAMA_BASE_URL", "http://localhost:11434")
OLLAMA_MODEL    = os.getenv("OLLAMA_MODEL",    "qwen2.5:7b")

GROQ_BASE_URL = "https://api.groq.com/openai/v1"
GROQ_API_KEY  = os.getenv("GROQ_API_KEY", "")
GROQ_MODEL    = os.getenv("GROQ_MODEL",   "llama-3.3-70b-versatile")

if PROVIDER == "groq" and not GROQ_API_KEY:
    logger.warning("LLM_PROVIDER=groq but GROQ_API_KEY is not set. Calls will fail with 401.")

_SEP = "─" * 64


def _log_payload(call_type: str, messages: List[Dict]) -> None:
    """Log every message being sent to the LLM."""
    lines = [f"\n{_SEP}", f"[LLM → {PROVIDER.upper()}]  {call_type}  ({len(messages)} messages)"]
    for i, m in enumerate(messages):
        role    = m.get("role", "?")
        content = m.get("content", "")
        preview = content if len(content) <= 900 else content[:900] + "…"
        lines.append(f"  [{i}] {role:10s}: {preview}")
    lines.append(_SEP)
    logger.info("\n".join(lines))


def _log_response(call_type: str, response: str) -> None:
    """Log the full LLM response."""
    preview = response if len(response) <= 900 else response[:900] + "…"
    logger.info(f"\n{_SEP}\n[LLM ← {PROVIDER.upper()}]  {call_type}\n{preview}\n{_SEP}")


# ── Public API ────────────────────────────────────────────────────────────────

async def stream_chat(
    messages: List[Dict[str, str]],
    system_prompt: str,
) -> AsyncGenerator[str, None]:
    """Yield raw text chunks from the configured provider."""
    full_messages = [{"role": "system", "content": system_prompt}] + messages
    _log_payload("stream_chat", full_messages)
    if PROVIDER == "groq":
        async for chunk in _groq_stream(full_messages):
            yield chunk
    else:
        async for chunk in _ollama_stream(full_messages):
            yield chunk
    # Note: full streamed response is logged by the caller (main.py)
    # where the accumulated buffer is already available.


async def complete(
    messages: List[Dict[str, str]],
    system_prompt: str,
    json_mode: bool = False,
    timeout: float = 30.0,
) -> str:
    """Single non-streaming completion. Returns the full response text."""
    full_messages = [{"role": "system", "content": system_prompt}] + messages
    _log_payload("complete", full_messages)
    if PROVIDER == "groq":
        result = await _groq_complete(full_messages, json_mode, timeout)
    else:
        result = await _ollama_complete(full_messages, json_mode, timeout)
    _log_response("complete", result)
    return result


# ── Ollama ────────────────────────────────────────────────────────────────────

async def _ollama_stream(messages: List[Dict]) -> AsyncGenerator[str, None]:
    payload: Dict[str, Any] = {
        "model": OLLAMA_MODEL,
        "messages": messages,
        "stream": True,
    }
    try:
        async with httpx.AsyncClient(timeout=60.0) as client:
            async with client.stream("POST", f"{OLLAMA_BASE_URL}/api/chat", json=payload) as resp:
                if resp.status_code != 200:
                    logger.error(f"Ollama stream error {resp.status_code}")
                    return
                async for line in resp.aiter_lines():
                    if not line:
                        continue
                    try:
                        data = json.loads(line)
                        content = data.get("message", {}).get("content", "")
                        if content:
                            yield content
                    except json.JSONDecodeError:
                        pass
    except httpx.ConnectError:
        raise ConnectionError(f"Cannot reach Ollama at {OLLAMA_BASE_URL}. Is it running?")


async def _ollama_complete(messages: List[Dict], json_mode: bool, timeout: float) -> str:
    payload: Dict[str, Any] = {
        "model": OLLAMA_MODEL,
        "messages": messages,
        "stream": False,
    }
    if json_mode:
        payload["format"] = "json"

    async with httpx.AsyncClient(timeout=timeout) as client:
        resp = await client.post(f"{OLLAMA_BASE_URL}/api/chat", json=payload)
        resp.raise_for_status()
        return resp.json().get("message", {}).get("content", "")


# ── Groq (OpenAI-compatible) ──────────────────────────────────────────────────

def _groq_headers() -> Dict[str, str]:
    return {
        "Authorization": f"Bearer {GROQ_API_KEY}",
        "Content-Type": "application/json",
    }


async def _groq_stream(messages: List[Dict]) -> AsyncGenerator[str, None]:
    payload: Dict[str, Any] = {
        "model": GROQ_MODEL,
        "messages": messages,
        "stream": True,
    }
    try:
        async with httpx.AsyncClient(timeout=60.0) as client:
            async with client.stream(
                "POST",
                f"{GROQ_BASE_URL}/chat/completions",
                headers=_groq_headers(),
                json=payload,
            ) as resp:
                if resp.status_code != 200:
                    body = await resp.aread()
                    logger.error(f"Groq stream error {resp.status_code}: {body.decode()}")
                    return
                async for line in resp.aiter_lines():
                    if not line.startswith("data: "):
                        continue
                    payload_str = line[6:].strip()
                    if payload_str == "[DONE]":
                        return
                    try:
                        data = json.loads(payload_str)
                        content = data["choices"][0]["delta"].get("content", "")
                        if content:
                            yield content
                    except (json.JSONDecodeError, KeyError, IndexError):
                        pass
    except httpx.ConnectError:
        raise ConnectionError("Cannot reach Groq API.")


async def _groq_complete(messages: List[Dict], json_mode: bool, timeout: float) -> str:
    payload: Dict[str, Any] = {
        "model": GROQ_MODEL,
        "messages": messages,
        "stream": False,
    }
    if json_mode:
        # Groq requires the word "JSON" to appear in the prompt for json_object mode
        payload["response_format"] = {"type": "json_object"}

    async with httpx.AsyncClient(timeout=timeout) as client:
        resp = await client.post(
            f"{GROQ_BASE_URL}/chat/completions",
            headers=_groq_headers(),
            json=payload,
        )
        resp.raise_for_status()
        return resp.json()["choices"][0]["message"]["content"]
