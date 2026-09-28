import React, { useState, useEffect, useCallback, useRef } from 'react';
import { searchProducts, getSessionStatuses, setSearchLocation, getSearchLocation, getETAs } from './lib/bridge';
import { groupAndRank } from './lib/grouper';
import { useCart } from './hooks/useCart';
import { useRecentSearches } from './hooks/useRecentSearches';
import { Header } from './components/Header';
import { GroupCard } from './components/GroupCard';
import { CartDrawer } from './components/CartDrawer';
import { SkeletonCard } from './components/SkeletonCard';
import './index.css';

const PLATFORMS_META = [
  { key: 'zepto',    name: 'Zepto',      color: '#9B51E0' },
  { key: 'blinkit',  name: 'Blinkit',    color: '#F5A623' },
  { key: 'swiggy',   name: 'Instamart',  color: '#FF5200' },
  { key: 'flipkart', name: 'Fk Minutes', color: '#2874F0' },
];

function RecentSearches({ recents, onSelect, onRemove, onClear }) {
  if (recents.length === 0) return null;

  return (
    <div className="recent-searches">
      <div className="recent-header">
        <span className="recent-label">Recent searches</span>
        <button className="recent-clear-all" onClick={onClear}>Clear all</button>
      </div>
      <div className="recent-list">
        {recents.map((q) => (
          <div key={q} className="recent-item">
            <button className="recent-item-btn" onClick={() => onSelect(q)}>
              <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
                <circle cx="12" cy="12" r="10" />
                <polyline points="12 6 12 12 16 14" />
              </svg>
              <span>{q}</span>
            </button>
            <button
              className="recent-item-remove"
              onClick={() => onRemove(q)}
              aria-label={`Remove "${q}"`}
            >
              <svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
                <line x1="18" y1="6" x2="6" y2="18" />
                <line x1="6" y1="6" x2="18" y2="18" />
              </svg>
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

function HeroSection({ query, onQueryChange, sessionStatus, recents, onSelectRecent, onRemoveRecent, onClearRecents }) {
  return (
    <section className="hero-section">
      <h1 className="hero-title">
        Compare prices across <span>all platforms</span>
      </h1>
      <p className="hero-sub">
        Search once — see Zepto, Blinkit, Instamart &amp; Flipkart Minutes side by side
      </p>

      {/* Big search bar */}
      <div className="hero-search search-wrap">
        <svg className="search-ico" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
          <circle cx="11" cy="11" r="8" /><path d="M21 21l-4.35-4.35" />
        </svg>
        <input
          type="text"
          className="search-field"
          placeholder="Search milk, eggs, chips, atta..."
          value={query}
          onChange={(e) => onQueryChange(e.target.value)}
          autoFocus
        />
        {query && (
          <button className="search-clear" onClick={() => onQueryChange('')} aria-label="Clear">
            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
              <line x1="18" y1="6" x2="6" y2="18" /><line x1="6" y1="6" x2="18" y2="18" />
            </svg>
          </button>
        )}
      </div>

      {/* Recent searches */}
      <RecentSearches
        recents={recents}
        onSelect={onSelectRecent}
        onRemove={onRemoveRecent}
        onClear={onClearRecents}
      />

      {/* Platform live status */}
      <div className="platform-status-row">
        {PLATFORMS_META.map((p) => {
          const live = sessionStatus?.[p.key] === true;
          return (
            <span
              key={p.key}
              className={`platform-status-chip ${live ? 'live' : ''}`}
              style={{ '--c': p.color }}
            >
              <span className="chip-dot" />
              {p.name}
            </span>
          );
        })}
      </div>
    </section>
  );
}

function ConnectionBanner({ sessionStatus, bridgeConnected, hasResults }) {
  if (hasResults) return null;

  if (!bridgeConnected) {
    return (
      <div className="conn-banner error-banner">
        <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
          <circle cx="12" cy="12" r="10" /><line x1="12" y1="8" x2="12" y2="12" /><line x1="12" y1="16" x2="12.01" y2="16" />
        </svg>
        <span>
          <strong>Extension not found.</strong> Install the Quickart extension, then reload this page.
        </span>
      </div>
    );
  }

  const disconnected = sessionStatus
    ? PLATFORMS_META.filter((p) => sessionStatus[p.key] === false)
    : [];

  if (disconnected.length === 0) return null;

  return (
    <div className="conn-banner warn-banner">
      <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
        <path d="M10.29 3.86L1.82 18a2 2 0 001.71 3h16.94a2 2 0 001.71-3L13.71 3.86a2 2 0 00-3.42 0z" />
        <line x1="12" y1="9" x2="12" y2="13" /><line x1="12" y1="17" x2="12.01" y2="17" />
      </svg>
      <span>
        Open{' '}
        {disconnected.map((p, i) => (
          <React.Fragment key={p.key}>
            {i > 0 && (i === disconnected.length - 1 ? ' & ' : ', ')}
            <strong style={{ color: p.color }}>{p.name}</strong>
          </React.Fragment>
        ))}{' '}
        in a tab to capture your session
      </span>
    </div>
  );
}

function EmptyResults({ query }) {
  return (
    <div className="empty-state">
      <div className="empty-icon">
        <svg width="44" height="44" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.3" strokeLinecap="round" strokeLinejoin="round">
          <circle cx="11" cy="11" r="8" /><path d="M21 21l-4.35-4.35" />
          <line x1="8" y1="11" x2="14" y2="11" />
        </svg>
      </div>
      <p className="empty-title">No results for &ldquo;{query}&rdquo;</p>
      <p className="empty-sub">Try a different term — "milk", "bread", "chips"</p>
    </div>
  );
}

// ─── Location picker ──────────────────────────────────────────────────────────

const GEOAPIFY_KEY = '958ddc3d04414dd9b6451aba3a847934';

async function reverseLookupPincode(lat, lon) {
  const url = `https://api.geoapify.com/v1/geocode/reverse?lat=${lat}&lon=${lon}&apiKey=${GEOAPIFY_KEY}`;
  const res = await fetch(url);
  const data = await res.json();
  return data?.features?.[0]?.properties?.postcode ?? null;
}

function LocationBar({ onLocationSet }) {
  const [pincode, setPincode] = useState('');
  const [geoStatus, setGeoStatus] = useState('idle'); // idle | loading | ok | error
  const [detectedPincode, setDetectedPincode] = useState(null);
  const geoStarted = useRef(false); // prevents React StrictMode double-fire

  // On mount: silently request geolocation
  useEffect(() => {
    if (geoStarted.current) return;
    geoStarted.current = true;
    if (!navigator.geolocation) return;
    setGeoStatus('loading');
    navigator.geolocation.getCurrentPosition(
      async ({ coords }) => {
        const { latitude: lat, longitude: lon } = coords;
        try {
          const pc = await reverseLookupPincode(lat, lon);
          if (pc) { setDetectedPincode(pc); setPincode(pc); }
          setGeoStatus('ok');
          onLocationSet({ lat, lon, pincode: pc });
        } catch {
          setGeoStatus('ok');
          onLocationSet({ lat, lon });
        }
      },
      () => setGeoStatus('error'),
      { timeout: 8000 }
    );
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  const handleGeo = () => {
    if (!navigator.geolocation) return;
    setGeoStatus('loading');
    navigator.geolocation.getCurrentPosition(
      async ({ coords }) => {
        const { latitude: lat, longitude: lon } = coords;
        try {
          const pc = await reverseLookupPincode(lat, lon);
          if (pc) { setDetectedPincode(pc); setPincode(pc); }
          setGeoStatus('ok');
          onLocationSet({ lat, lon, pincode: pc });
        } catch {
          setGeoStatus('ok');
          onLocationSet({ lat, lon });
        }
      },
      () => setGeoStatus('error'),
      { timeout: 8000 }
    );
  };

  const handlePincodeSubmit = (e) => {
    e.preventDefault();
    const p = pincode.trim();
    if (!/^\d{6}$/.test(p)) return;
    onLocationSet({ pincode: p });
  };

  return (
    <div className="location-bar">
      <button
        className={`geo-btn ${geoStatus}`}
        onClick={handleGeo}
        title="Use my location"
        aria-label="Detect my location"
      >
        {geoStatus === 'loading' ? (
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" className="spin">
            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"/>
          </svg>
        ) : (
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
            <circle cx="12" cy="12" r="3"/><path d="M12 2v3M12 19v3M2 12h3M19 12h3"/>
          </svg>
        )}
        {geoStatus === 'ok'
          ? (detectedPincode || 'Located')
          : geoStatus === 'error' ? 'Failed'
          : geoStatus === 'loading' ? 'Detecting...'
          : 'Use location'}
      </button>

      <form className="pincode-form" onSubmit={handlePincodeSubmit}>
        <input
          className="pincode-input"
          type="text"
          inputMode="numeric"
          pattern="\d{6}"
          maxLength={6}
          placeholder="Pincode"
          value={pincode}
          onChange={(e) => setPincode(e.target.value.replace(/\D/g, ''))}
          aria-label="Enter pincode"
        />
        <button type="submit" className="pincode-submit" aria-label="Set pincode">
          <svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
            <polyline points="9 18 15 12 9 6"/>
          </svg>
        </button>
      </form>
    </div>
  );
}

// ─── ETA row ──────────────────────────────────────────────────────────────────

function EtaRow({ etas }) {
  const hasAnyEta = PLATFORMS_META.some(p => etas?.[p.key]);
  if (!hasAnyEta) return null;

  return (
    <div className="eta-row">
      <span className="eta-row-label">
        <svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
          <circle cx="12" cy="12" r="10"/><polyline points="12 6 12 12 16 14"/>
        </svg>
        Delivery time
      </span>
      <div className="eta-chips">
        {PLATFORMS_META.map((p) => {
          const eta = etas?.[p.key];
          const loaded = eta != null;
          const unavailable = eta?.unavailable === true;
          return (
            <span
              key={p.key}
              className={`eta-chip ${loaded ? (unavailable ? 'eta-chip--unavailable' : 'eta-chip--loaded') : 'eta-chip--pending'}`}
              style={{ '--c': p.color }}
            >
              <span className="eta-chip-name">{p.name}</span>
              {loaded
                ? <strong className="eta-chip-val">{eta.label}</strong>
                : <span className="eta-chip-skeleton" />}
            </span>
          );
        })}
      </div>
    </div>
  );
}

// ─── App ──────────────────────────────────────────────────────────────────────

export default function App() {
  const [query, setQuery] = useState('');
  const [isSearching, setIsSearching] = useState(false);
  const [results, setResults] = useState([]);
  const [sessionStatus, setSessionStatus] = useState(null);
  const [bridgeConnected, setBridgeConnected] = useState(true);
  const [error, setError] = useState(null);
  const [cartOpen, setCartOpen] = useState(false);
  const [etas, setEtas] = useState({});

  const cart = useCart();
  const { recents, push: pushRecent, remove: removeRecent, clear: clearRecents } = useRecentSearches();
  const reqId = useRef(0);
  const etaFetching = useRef(false);

  const handleLocationSet = useCallback((loc) => {
    setSearchLocation(loc);
    if (etaFetching.current) return;
    etaFetching.current = true;
    getETAs({ lat: loc.lat, lon: loc.lon }, (etaData) => {
      setEtas((prev) => ({ ...prev, ...etaData }));
    });
    // Reset flag after a short delay — allows re-fetch if location changes later
    setTimeout(() => { etaFetching.current = false; }, 3000);
  }, []);

  useEffect(() => {
    (async () => {
      try {
        const status = await getSessionStatuses();
        setSessionStatus(status);
        setBridgeConnected(true);
      } catch {
        setBridgeConnected(false);
      }
    })();
  }, []);

  const executeSearch = useCallback(async (q) => {
    if (!q.trim()) {
      setResults([]);
      setIsSearching(false);
      return;
    }
    const id = ++reqId.current;
    setIsSearching(true);
    setError(null);
    try {
      const rawItems = await searchProducts(q);
      if (reqId.current !== id) return;
      const grouped = groupAndRank(rawItems);
      setResults(grouped);
      if (grouped.length > 0) pushRecent(q);
    } catch (err) {
      if (reqId.current !== id) return;
      setError(err.message);
    } finally {
      if (reqId.current === id) setIsSearching(false);
    }
  }, [pushRecent]);

  useEffect(() => {
    const t = setTimeout(() => executeSearch(query), 800);
    return () => clearTimeout(t);
  }, [query, executeSearch]);

  const handleSelectRecent = (q) => setQuery(q);

  const showHero     = !query && !isSearching;
  const showResults  = !isSearching && results.length > 0;
  const showEmpty    = !isSearching && !!query && results.length === 0 && !error;
  const showSkeleton = isSearching;

  return (
    <div className="app">
      <Header
        query={query}
        onQueryChange={setQuery}
        totalItems={cart.totalItems}
        onCartOpen={() => setCartOpen(true)}
        sessionStatus={sessionStatus}
        showSearchInHeader={!!query || isSearching}
      />

      <main className="main-content">
        <ConnectionBanner
          sessionStatus={sessionStatus}
          bridgeConnected={bridgeConnected}
          hasResults={results.length > 0}
        />

        {showHero && (
          <HeroSection
            query={query}
            onQueryChange={setQuery}
            sessionStatus={sessionStatus}
            recents={recents}
            onSelectRecent={handleSelectRecent}
            onRemoveRecent={removeRecent}
            onClearRecents={clearRecents}
          />
        )}

        <LocationBar onLocationSet={handleLocationSet} />

        <EtaRow etas={etas} />

        {error && (
          <div className="error-msg">
            <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
              <circle cx="12" cy="12" r="10" />
              <line x1="12" y1="8" x2="12" y2="12" />
              <line x1="12" y1="16" x2="12.01" y2="16" />
            </svg>
            {error}
          </div>
        )}

        {(showSkeleton || showResults) && (
          <div className="results-bar">
            {showResults && (
              <p className="results-meta">
                <strong>{results.length}</strong> product group{results.length !== 1 ? 's' : ''} for &ldquo;{query}&rdquo;
              </p>
            )}
          </div>
        )}

        <div className="product-grid">
          {showSkeleton &&
            Array.from({ length: 6 }).map((_, i) => <SkeletonCard key={i} />)}
          {showResults &&
            results.map((group, i) => (
              <GroupCard key={`${group.groupId}-${i}`} group={group} cart={cart} />
            ))}
        </div>

        {showEmpty && <EmptyResults query={query} />}
      </main>

      <CartDrawer
        isOpen={cartOpen}
        onClose={() => setCartOpen(false)}
        cart={cart}
      />
    </div>
  );
}
