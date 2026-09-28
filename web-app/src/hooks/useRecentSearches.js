import { useState, useCallback } from 'react';

const KEY = 'quickart_recent_v1';
const MAX = 8;

function load() {
  try {
    const raw = localStorage.getItem(KEY);
    return raw ? JSON.parse(raw) : [];
  } catch {
    return [];
  }
}

function save(items) {
  try {
    localStorage.setItem(KEY, JSON.stringify(items));
  } catch {}
}

export function useRecentSearches() {
  const [recents, setRecents] = useState(load);

  const push = useCallback((query) => {
    const q = query.trim();
    if (!q) return;
    setRecents((prev) => {
      const filtered = prev.filter((r) => r.toLowerCase() !== q.toLowerCase());
      const next = [q, ...filtered].slice(0, MAX);
      save(next);
      return next;
    });
  }, []);

  const remove = useCallback((query) => {
    setRecents((prev) => {
      const next = prev.filter((r) => r !== query);
      save(next);
      return next;
    });
  }, []);

  const clear = useCallback(() => {
    save([]);
    setRecents([]);
  }, []);

  return { recents, push, remove, clear };
}
