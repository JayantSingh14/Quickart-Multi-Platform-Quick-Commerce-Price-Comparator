import { useState, useRef, useEffect, useCallback } from 'react';
import ReactMarkdown from 'react-markdown';
import remarkGfm from 'remark-gfm';
import ProductGroup from './ProductGroup';
import SuggestionChips from './SuggestionChips';
import styles from './Chat.module.css';

const API               = 'http://localhost:8000';
const SEARCH_TIMEOUT_MS = 15_000;

// ── Chat persistence ──────────────────────────────────────────────────────────

const STORE_VER  = 'shopgpt_v1';
const IDX_KEY    = `${STORE_VER}_index`;
const LAST_KEY   = `${STORE_VER}_last`;
const chatKey    = id => `${STORE_VER}_chat_${id}`;

function readIndex() {
  try { return JSON.parse(localStorage.getItem(IDX_KEY) ?? '[]'); }
  catch { return []; }
}

function readChat(id) {
  try { return JSON.parse(localStorage.getItem(chatKey(id)) ?? 'null'); }
  catch { return null; }
}

/** Persist a chat and return the updated index sorted newest-first. */
function persistChat(id, title, messages) {
  const clean = messages.map(m => ({ ...m, searchPhase: null })); // strip transient state
  const entry = { id, title, messages: clean, updatedAt: Date.now() };
  try { localStorage.setItem(chatKey(id), JSON.stringify(entry)); } catch {}

  let idx = readIndex().filter(c => c.id !== id);
  idx.unshift({ id, title, updatedAt: entry.updatedAt });
  idx = idx.slice(0, 50);
  try { localStorage.setItem(IDX_KEY, JSON.stringify(idx)); } catch {}
  return idx;
}

function deleteChat(id) {
  try { localStorage.removeItem(chatKey(id)); } catch {}
  const idx = readIndex().filter(c => c.id !== id);
  try { localStorage.setItem(IDX_KEY, JSON.stringify(idx)); } catch {}
  return idx;
}

function deriveTitle(messages) {
  const first = messages.find(m => m.role === 'user');
  if (!first?.content) return 'New chat';
  const t = first.content.trim().replace(/\s+/g, ' ');
  return t.length > 45 ? t.slice(0, 45) + '…' : t;
}

function formatRelativeDate(ts) {
  if (!ts) return '';
  const diff = Date.now() - ts;
  const mins  = Math.floor(diff / 60_000);
  const hours = Math.floor(diff / 3_600_000);
  const days  = Math.floor(diff / 86_400_000);
  if (mins  <  1) return 'just now';
  if (mins  < 60) return `${mins}m ago`;
  if (hours < 24) return `${hours}h ago`;
  if (days  ===1) return 'Yesterday';
  if (days  <  7) return `${days}d ago`;
  return new Date(ts).toLocaleDateString('en-IN', { day: 'numeric', month: 'short' });
}

const STARTER_PROMPTS = [
  { icon: '🔍', text: 'Find cheapest 1 kg atta nearby' },
  { icon: '🍲', text: 'I want to make dal makhani — what do I need?' },
  { icon: '🧈', text: 'Compare Amul butter 500g prices' },
  { icon: '🥗', text: 'Plan a week of healthy breakfasts for me' },
];

const PLATFORM_META = {
  zepto:     { label: 'Zepto',     color: 'var(--zepto)' },
  blinkit:   { label: 'Blinkit',   color: 'var(--blinkit)' },
  instamart: { label: 'Instamart', color: 'var(--swiggy)' },
  flipkart:  { label: 'Flipkart',  color: 'var(--flipkart)' },
};

// ── Helpers ───────────────────────────────────────────────────────────────────

function makeId() {
  return `msg_${Date.now()}_${Math.random().toString(36).slice(2, 7)}`;
}

function makeAssistantMsg(overrides = {}) {
  return {
    id: makeId(), role: 'assistant', content: '',
    products: null, suggestions: null, searchPhase: null, error: null,
    etaMap: null,   // { zepto: "12 min", blinkit: "8 min", swiggy: "15 min" }
    ...overrides,
  };
}

/** Async generator over a text/event-stream response body. */
async function* readSSE(response) {
  const reader  = response.body.getReader();
  const decoder = new TextDecoder();
  let buffer    = '';
  while (true) {
    const { value, done } = await reader.read();
    if (done) break;
    buffer += decoder.decode(value, { stream: true });
    const parts = buffer.split('\n\n');
    buffer = parts.pop() ?? '';
    for (const part of parts) {
      if (!part.startsWith('data: ')) continue;
      const raw = part.slice(6).trim();
      if (!raw) continue;
      try { yield JSON.parse(raw); } catch {}
    }
  }
}

// ── Component ─────────────────────────────────────────────────────────────────

export default function Chat() {
  const [messages, setMessages]             = useState([]);
  const [input, setInput]                   = useState('');
  const [isStreaming, setIsStreaming]        = useState(false);
  const [platformStatus, setPlatformStatus] = useState({});
  // 'checking' | 'installed' | 'missing' | 'dismissed'
  const [extensionStatus, setExtensionStatus] = useState('checking');
  const [activeChatId, setActiveChatId]     = useState(null);
  const [chatList, setChatList]             = useState([]);

  const bottomRef          = useRef(null);
  const inputRef           = useRef(null);
  const pendingMsgIdRef    = useRef(null);          // assistant msg waiting for results
  const currentQueryRef    = useRef('');             // full query string for this search turn
  const pendingSearchesRef = useRef(new Map());      // reqId → { done, gotResults }
  const allResultsRef      = useRef([]);             // merged results from all sub-searches
  const searchTimeoutRef   = useRef(null);
  const etaPendingRef      = useRef(null);           // { reqId, msgId } for in-flight ETA call

  // ── Persistence — load on mount ──────────────────────────────────────────

  useEffect(() => {
    const idx    = readIndex();
    setChatList(idx);
    const lastId = localStorage.getItem(LAST_KEY);
    if (lastId) {
      const saved = readChat(lastId);
      if (saved?.messages?.length > 0) {
        setMessages(saved.messages);
        setActiveChatId(lastId);
        return;
      }
    }
    // No previous chat — generate a fresh ID (messages stay empty)
    setActiveChatId(makeId());
  }, []);

  // ── Persistence — auto-save when streaming ends ───────────────────────────

  useEffect(() => {
    // Run only when streaming transitions to false and we have content
    if (isStreaming) return;
    // Read current values via closure (this effect fires after render so they're fresh)
    if (!activeChatId || messages.length === 0) return;
    const title  = deriveTitle(messages);
    const newIdx = persistChat(activeChatId, title, messages);
    setChatList(newIdx);
    localStorage.setItem(LAST_KEY, activeChatId);
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [isStreaming]); // intentionally: only fire on streaming-end

  // ── Extension detection (one-shot on mount, 2.5 s timeout) ───────────────

  useEffect(() => {
    const PING = '__shopgpt_init__';
    let resolved = false;

    const onPing = (event) => {
      if (event.data?.__quickart_response === 'GET_SESSION_STATUS' &&
          event.data?.__requestId === PING) {
        resolved = true;
        setExtensionStatus('installed');
        // Service worker spreads response directly — no nested 'status' key
        setPlatformStatus({
          zepto:     !!event.data.zepto,
          blinkit:   !!event.data.blinkit,
          instamart: !!event.data.instamart,
          flipkart:  !!event.data.flipkart,
        });
        window.__quickart_available = true;
        cleanup();
      }
    };

    const cleanup = () => {
      window.removeEventListener('message', onPing);
      clearTimeout(missTimer);
    };

    window.addEventListener('message', onPing);
    window.postMessage({ __quickart_request: 'GET_SESSION_STATUS', __requestId: PING }, '*');

    const missTimer = setTimeout(() => {
      if (!resolved) setExtensionStatus('missing');
      window.removeEventListener('message', onPing);
    }, 2500);

    return cleanup;
  }, []);

  // ── Periodic platform-status refresh ─────────────────────────────────────

  useEffect(() => {
    const id = setInterval(() => {
      if (window.__quickart_available) {
        window.postMessage({ __quickart_request: 'GET_SESSION_STATUS' }, '*');
      }
    }, 30_000);
    return () => clearInterval(id);
  }, []);

  // ── Scroll to bottom ──────────────────────────────────────────────────────

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages]);

  // ── Atomic state helpers ──────────────────────────────────────────────────

  const updateMsg = useCallback((id, patch) => {
    setMessages(prev => prev.map(m => m.id === id ? { ...m, ...patch } : m));
  }, []);

  const appendContent = useCallback((id, chunk) => {
    setMessages(prev => prev.map(m => m.id === id ? { ...m, content: m.content + chunk } : m));
  }, []);

  // ── Stream LLM commentary + chips after products appear ───────────────────

  const getSearchSummary = useCallback(async (msgId, query, groups) => {
    try {
      const response = await fetch(`${API}/api/search-summary`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ query, groups: groups.slice(0, 3) }),
      });
      if (!response.ok) return;
      for await (const event of readSSE(response)) {
        if (event.type === 'text')        appendContent(msgId, event.content ?? '');
        if (event.type === 'suggestions') updateMsg(msgId, { suggestions: event.items });
        if (event.type === 'done')        break;
      }
    } catch (e) {
      console.warn('[ShopGPT] Search summary failed:', e);
    }
  }, [appendContent, updateMsg]);

  // ── Rank, show products, then get summary ─────────────────────────────────

  const finishSearch = useCallback(async () => {
    const msgId   = pendingMsgIdRef.current;
    const query   = currentQueryRef.current;
    const results = allResultsRef.current;

    if (!msgId) return;

    if (!results.length) {
      updateMsg(msgId, {
        searchPhase: null,
        error: 'No results found. Try visiting the store apps first to connect your sessions.',
      });
      pendingMsgIdRef.current = null;
      return;
    }

    // Cache per platform
    const byPlatform = {};
    results.forEach(item => { (byPlatform[item.platform] ??= []).push(item); });
    Object.entries(byPlatform).forEach(([platform, items]) => {
      fetch(`${API}/api/cache/results`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ platform, pincode: '000000', query, items }),
      }).catch(() => {});
    });

    updateMsg(msgId, { searchPhase: 'ranking' });

    try {
      const res  = await fetch(`${API}/api/rank-items`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ query, items: results }),
      });
      const data = await res.json();
      const groups = data.status === 'success' ? (data.groups ?? []) : [];

      updateMsg(msgId, { searchPhase: null, products: groups });

      if (groups.length > 0) {
        // Fetch live delivery ETAs in parallel with the LLM summary
        const etaReqId = `eta_${Date.now()}`;
        etaPendingRef.current = { reqId: etaReqId, msgId };
        window.postMessage({ __quickart_request: 'GET_ETA', __requestId: etaReqId }, '*');

        await getSearchSummary(msgId, query, groups);
      }
    } catch {
      updateMsg(msgId, { searchPhase: null, error: 'Could not fetch rankings. Please try again.' });
    }

    pendingMsgIdRef.current = null;
  }, [updateMsg, getSearchSummary]);

  // ── Extension message listener ────────────────────────────────────────────

  useEffect(() => {
    const handler = async (event) => {
      if (!event.data?.__quickart_response) return;

      // Periodic status pings (not the init ping — that has its own listener)
      if (event.data.__quickart_response === 'GET_SESSION_STATUS' &&
          event.data.__requestId !== '__shopgpt_init__') {
        setPlatformStatus({
          zepto:     !!event.data.zepto,
          blinkit:   !!event.data.blinkit,
          instamart: !!event.data.instamart,
          flipkart:  !!event.data.flipkart,
        });
        return;
      }

      // ETA response from extension
      if (event.data.__quickart_response === 'GET_ETA') {
        const pending = etaPendingRef.current;
        if (!pending || event.data.__requestId !== pending.reqId) return;
        const eta = {};
        ['zepto', 'blinkit', 'swiggy', 'flipkart'].forEach(p => {
          if (event.data[p]?.label) eta[p] = event.data[p].label;
        });
        // Instamart results come back under the 'swiggy' key
        if (eta.swiggy) eta.instamart = eta.swiggy;
        updateMsg(pending.msgId, { etaMap: eta });
        etaPendingRef.current = null;
        return;
      }

      // Search result from extension
      if (event.data.__quickart_response === 'SEARCH') {
        const reqId   = event.data.__requestId;
        const pending = pendingSearchesRef.current;
        if (!pending.has(reqId)) return;

        const entry = pending.get(reqId);
        entry.done = true;
        if (event.data.ok && event.data.results?.length) {
          allResultsRef.current.push(...event.data.results);
          entry.gotResults = true;
        }

        const allDone = [...pending.values()].every(e => e.done);
        if (allDone) {
          clearTimeout(searchTimeoutRef.current);
          searchTimeoutRef.current = null;
          await finishSearch();
        }
      }
    };

    window.addEventListener('message', handler);
    return () => window.removeEventListener('message', handler);
  }, [finishSearch]);

  // ── Send ──────────────────────────────────────────────────────────────────

  const handleSend = useCallback(async (text) => {
    const query = (text ?? input).trim();
    if (!query || isStreaming) return;

    setInput('');
    if (inputRef.current) inputRef.current.style.height = 'auto';
    setIsStreaming(true);

    currentQueryRef.current    = query;
    allResultsRef.current      = [];
    pendingSearchesRef.current = new Map();

    const userMsg = { id: makeId(), role: 'user', content: query };
    const asstMsg = makeAssistantMsg();
    setMessages(prev => [...prev, userMsg, asstMsg]);
    pendingMsgIdRef.current = null;

    // History: text only (no product JSON — keeps context window clean)
    const history = [
      ...messages.map(m => ({ role: m.role, content: m.content })),
      { role: 'user', content: query },
    ];

    try {
      const response = await fetch(`${API}/api/chat-stream`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ messages: history }),
      });

      for await (const event of readSSE(response)) {
        switch (event.type) {

          case 'text':
            appendContent(asstMsg.id, event.content ?? '');
            break;

          case 'tool_call':
            if (event.tool === 'initiate_search') {
              // Split "atta 1kg, ghee 500g" → parallel searches per item
              const subQueries = event.query
                .split(',').map(s => s.trim()).filter(Boolean);

              const newPending = new Map();
              subQueries.forEach(q => {
                const reqId = `s_${Date.now()}_${Math.random().toString(36).slice(2, 6)}`;
                newPending.set(reqId, { query: q, done: false, gotResults: false });
              });

              pendingSearchesRef.current = newPending;
              pendingMsgIdRef.current    = asstMsg.id;
              allResultsRef.current      = [];

              updateMsg(asstMsg.id, {
                searchPhase: 'searching',
                searchCount: subQueries.length,
              });

              // Fire all sub-searches simultaneously
              newPending.forEach((entry, reqId) => {
                window.postMessage({
                  __quickart_request: 'SEARCH',
                  query: entry.query,
                  __requestId: reqId,
                }, '*');
              });

              // Safety net: after 15s show whatever we have
              searchTimeoutRef.current = setTimeout(async () => {
                if (!pendingMsgIdRef.current) return;
                pendingSearchesRef.current.forEach(e => { e.done = true; });
                if (allResultsRef.current.length > 0) {
                  await finishSearch();
                } else {
                  updateMsg(asstMsg.id, {
                    searchPhase: null,
                    error: 'Search timed out. Ensure the Quickart extension is active and you have visited the store apps.',
                  });
                  pendingMsgIdRef.current = null;
                }
              }, SEARCH_TIMEOUT_MS);
            }
            break;

          case 'suggestions':
            updateMsg(asstMsg.id, { suggestions: event.items ?? [] });
            break;

          case 'error':
            updateMsg(asstMsg.id, { error: event.message ?? 'An error occurred.' });
            break;
        }
      }
    } catch (err) {
      updateMsg(asstMsg.id, { error: 'Could not reach ShopGPT backend. Is it running on port 8000?' });
      console.error('[ShopGPT] Stream error:', err);
    } finally {
      setIsStreaming(false);
      setTimeout(() => inputRef.current?.focus(), 50);
    }
  }, [input, isStreaming, messages, appendContent, updateMsg, finishSearch]);

  const handleKeyDown = (e) => {
    if (e.key === 'Enter' && !e.shiftKey) { e.preventDefault(); handleSend(); }
  };

  const handleTextareaInput = (e) => {
    const el = e.target;
    el.style.height = 'auto';
    el.style.height = `${Math.min(el.scrollHeight, 160)}px`;
  };

  const _clearSearchState = useCallback(() => {
    clearTimeout(searchTimeoutRef.current);
    searchTimeoutRef.current   = null;
    pendingMsgIdRef.current    = null;
    pendingSearchesRef.current = new Map();
    allResultsRef.current      = [];
    etaPendingRef.current      = null;
  }, []);

  const handleNewChat = useCallback(() => {
    // Save current conversation before wiping
    if (activeChatId && messages.length > 0) {
      const title  = deriveTitle(messages);
      const newIdx = persistChat(activeChatId, title, messages);
      setChatList(newIdx);
    }
    _clearSearchState();
    const newId = makeId();
    setActiveChatId(newId);
    localStorage.setItem(LAST_KEY, newId);
    setMessages([]);
    setInput('');
    setIsStreaming(false);
    if (inputRef.current) inputRef.current.style.height = 'auto';
    setTimeout(() => inputRef.current?.focus(), 50);
  }, [activeChatId, messages, _clearSearchState]);

  const switchToChat = useCallback((id) => {
    if (id === activeChatId || isStreaming) return;
    // Save current before switching
    if (activeChatId && messages.length > 0) {
      const title  = deriveTitle(messages);
      const newIdx = persistChat(activeChatId, title, messages);
      setChatList(newIdx);
    }
    _clearSearchState();
    const saved = readChat(id);
    setMessages(saved?.messages ?? []);
    setActiveChatId(id);
    setInput('');
    setIsStreaming(false);
    localStorage.setItem(LAST_KEY, id);
    setTimeout(() => inputRef.current?.focus(), 50);
  }, [activeChatId, messages, isStreaming, _clearSearchState]);

  const handleDeleteChat = useCallback((e, id) => {
    e.stopPropagation();
    const newIdx = deleteChat(id);
    setChatList(newIdx);
    if (id === activeChatId) {
      // Switch to the next most recent chat, or start fresh
      const next = newIdx[0];
      if (next) {
        switchToChat(next.id);
      } else {
        _clearSearchState();
        const newId = makeId();
        setActiveChatId(newId);
        setMessages([]);
        setInput('');
      }
    }
  }, [activeChatId, switchToChat, _clearSearchState]);

  // ── Render ────────────────────────────────────────────────────────────────

  const connectedCount = Object.values(platformStatus).filter(Boolean).length;

  return (
    <div className={styles.layout}>

      {/* ── Sidebar ─────────────────────────────────────────────────────── */}
      <aside className={styles.sidebar}>
        {/* Logo + New chat */}
        <div className={styles.sidebarHeader}>
          <div className={styles.logo}>
            <span className={styles.logoIcon}>S</span>
            <span className={styles.logoText}>ShopGPT</span>
          </div>
          <button className={styles.newChatBtn} onClick={handleNewChat} disabled={isStreaming}>
            <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5">
              <line x1="12" y1="5" x2="12" y2="19"/>
              <line x1="5" y1="12" x2="19" y2="12"/>
            </svg>
            New chat
          </button>
        </div>

        {/* Chat history */}
        <div className={styles.chatList}>
          {chatList.length === 0 && (
            <p className={styles.chatListEmpty}>No chats yet</p>
          )}
          {chatList.map(chat => (
            <div
              key={chat.id}
              className={`${styles.chatItem} ${chat.id === activeChatId ? styles.chatItemActive : ''}`}
              onClick={() => switchToChat(chat.id)}
              role="button"
              tabIndex={0}
              onKeyDown={e => e.key === 'Enter' && switchToChat(chat.id)}
            >
              <span className={styles.chatItemTitle}>{chat.title || 'New chat'}</span>
              <div className={styles.chatItemMeta}>
                <span className={styles.chatItemDate}>{formatRelativeDate(chat.updatedAt)}</span>
                <button
                  className={styles.chatItemDelete}
                  onClick={e => handleDeleteChat(e, chat.id)}
                  aria-label="Delete chat"
                >✕</button>
              </div>
            </div>
          ))}
        </div>

        {/* Store connections */}
        <div className={styles.sidebarBottom}>
          <p className={styles.statusLabel}>Store connections</p>
          {Object.entries(PLATFORM_META).map(([key, meta]) => (
            <div key={key} className={styles.statusRow}>
              <span
                className={styles.statusDot}
                style={{ background: platformStatus[key] ? meta.color : 'var(--surface-3)' }}
              />
              <span className={styles.statusName}>{meta.label}</span>
              <span className={styles.statusTag}>
                {platformStatus[key] ? 'Connected' : 'Not visited'}
              </span>
            </div>
          ))}
          {connectedCount === 0 && (
            <p className={styles.statusHint}>Visit each store app once to connect</p>
          )}
        </div>
      </aside>

      {/* ── Main ─────────────────────────────────────────────────────────── */}
      <div className={styles.main}>

        {/* Extension warning banner */}
        {extensionStatus === 'missing' && (
          <div className={styles.extensionBanner}>
            <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
              <circle cx="12" cy="12" r="10"/><line x1="12" y1="8" x2="12" y2="12"/>
              <line x1="12" y1="16" x2="12.01" y2="16"/>
            </svg>
            <span>
              Quickart extension not detected — price searches won't work.{' '}
              <span className={styles.bannerHelp}>Load the extension from the /extension folder in Chrome (Developer mode).</span>
            </span>
            <button
              className={styles.bannerClose}
              onClick={() => setExtensionStatus('dismissed')}
              aria-label="Dismiss"
            >✕</button>
          </div>
        )}

        {/* Message thread */}
        <div className={styles.thread}>
          {messages.length === 0 ? (
            <EmptyState onSelect={handleSend} />
          ) : (
            messages.map(msg => (
              <MessageRow key={msg.id} msg={msg} onChipClick={handleSend} />
            ))
          )}
          <div ref={bottomRef} />
        </div>

        {/* Input */}
        <div className={styles.inputWrap}>
          <div className={styles.inputBox}>
            <textarea
              ref={inputRef}
              className={styles.textarea}
              value={input}
              onChange={e => setInput(e.target.value)}
              onKeyDown={handleKeyDown}
              onInput={handleTextareaInput}
              placeholder="Ask me to find products or suggest a recipe…"
              rows={1}
              disabled={isStreaming}
            />
            <button
              className={styles.sendBtn}
              onClick={() => handleSend()}
              disabled={isStreaming || !input.trim()}
              aria-label="Send"
            >
              {isStreaming ? (
                <span className={styles.spinner} />
              ) : (
                <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5">
                  <line x1="22" y1="2" x2="11" y2="13"/>
                  <polygon points="22 2 15 22 11 13 2 9 22 2"/>
                </svg>
              )}
            </button>
          </div>
          <p className={styles.inputHint}>
            ShopGPT uses live store data · Prices may vary
          </p>
        </div>

      </div>
    </div>
  );
}

// ── Empty state ───────────────────────────────────────────────────────────────

function EmptyState({ onSelect }) {
  return (
    <div className={styles.emptyState}>
      <div className={styles.emptyIcon}><span>S</span></div>
      <h2 className={styles.emptyTitle}>What can I help you find?</h2>
      <p className={styles.emptySubtitle}>
        Compare prices across Zepto, Blinkit & Instamart — or ask for a recipe.
      </p>
      <div className={styles.starterGrid}>
        {STARTER_PROMPTS.map((p, i) => (
          <button key={i} className={styles.starterChip} onClick={() => onSelect(p.text)}>
            <span className={styles.starterIcon}>{p.icon}</span>
            <span>{p.text}</span>
          </button>
        ))}
      </div>
    </div>
  );
}

// ── MessageRow ────────────────────────────────────────────────────────────────

function MessageRow({ msg, onChipClick }) {
  if (msg.role === 'user') {
    return (
      <div className={`${styles.row} ${styles.rowUser} animate-up`}>
        <div className={styles.userBubble}>{msg.content}</div>
      </div>
    );
  }

  const searchingText = msg.searchCount > 1
    ? `Searching ${msg.searchCount} items across stores…`
    : 'Searching stores…';

  return (
    <div className={`${styles.row} ${styles.rowAssistant} animate-up`}>
      <div className={styles.asstAvatar}>S</div>
      <div className={styles.asstBody}>

        {/* Streamed text (markdown) */}
        {msg.content && (
          <div className={styles.asstText}>
            <ReactMarkdown remarkPlugins={[remarkGfm]}>{msg.content}</ReactMarkdown>
          </div>
        )}

        {/* Search / ranking indicator */}
        {msg.searchPhase && (
          <div className={styles.searchStatus}>
            <span className={styles.searchDot} />
            <span className={styles.searchDot} />
            <span className={styles.searchDot} />
            <span className={styles.searchStatusText}>
              {msg.searchPhase === 'searching' ? searchingText : 'Grouping & ranking results…'}
            </span>
          </div>
        )}

        {/* Product cards */}
        {msg.products?.length > 0 && (
          <div className={`${styles.productList} animate-up`}>
            {msg.products.map((group, i) => (
              <ProductGroup key={i} group={group} rank={i} etaMap={msg.etaMap ?? {}} />
            ))}
          </div>
        )}
        {msg.products?.length === 0 && !msg.error && (
          <p className={styles.noResults}>
            No products found. Try visiting the store apps first to activate your sessions.
          </p>
        )}

        {/* Error */}
        {msg.error && <p className={styles.errorText}>{msg.error}</p>}

        {/* Suggestion chips */}
        {msg.suggestions?.length > 0 && !msg.searchPhase && (
          <SuggestionChips chips={msg.suggestions} onChipClick={onChipClick} />
        )}

      </div>
    </div>
  );
}
