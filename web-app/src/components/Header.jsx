import React from 'react';

export function Header({ query, onQueryChange, totalItems, onCartOpen, sessionStatus, showSearchInHeader }) {
  const connectedCount = sessionStatus
    ? ['zepto', 'blinkit', 'swiggy', 'flipkart'].filter((p) => sessionStatus[p] === true).length
    : 0;

  return (
    <header className="site-header">
      <div className="header-inner">
        {/* Logo */}
        <a href="/" className="logo" onClick={(e) => e.preventDefault()}>
          <span className="logo-icon">
            <svg width="26" height="26" viewBox="0 0 28 28" fill="none">
              <rect width="28" height="28" rx="7" fill="#2563EB" />
              <path d="M7 14.5L11.5 19L21 9" stroke="white" strokeWidth="2.5" strokeLinecap="round" strokeLinejoin="round" />
            </svg>
          </span>
          <span className="logo-text">quick<strong>art</strong></span>
        </a>

        {/* Search — only visible in header when user has typed something */}
        {showSearchInHeader && (
          <div className="header-search">
            <div className="search-wrap">
              <svg className="search-ico" width="17" height="17" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
                <circle cx="11" cy="11" r="8" /><path d="M21 21l-4.35-4.35" />
              </svg>
              <input
                type="text"
                className="search-field"
                placeholder="Search products..."
                value={query}
                onChange={(e) => onQueryChange(e.target.value)}
                autoFocus
              />
              {query && (
                <button
                  className="search-clear"
                  onClick={() => onQueryChange('')}
                  aria-label="Clear search"
                >
                  <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
                    <line x1="18" y1="6" x2="6" y2="18" /><line x1="6" y1="6" x2="18" y2="18" />
                  </svg>
                </button>
              )}
            </div>
          </div>
        )}

        {/* Right side */}
        <div className="header-actions">
          {sessionStatus && (
            <div className="conn-pill" title={`${connectedCount} platform${connectedCount !== 1 ? 's' : ''} connected`}>
              <span className={`conn-dot ${connectedCount > 0 ? 'on' : 'off'}`} />
              <span className="conn-text">{connectedCount}/4 live</span>
            </div>
          )}

          <button className="cart-btn" onClick={onCartOpen} aria-label="Open cart">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
              <path d="M6 2L3 6v14a2 2 0 002 2h14a2 2 0 002-2V6l-3-4z" />
              <line x1="3" y1="6" x2="21" y2="6" />
              <path d="M16 10a4 4 0 01-8 0" />
            </svg>
            {totalItems > 0 && (
              <span className="cart-badge">{totalItems > 99 ? '99+' : totalItems}</span>
            )}
          </button>
        </div>
      </div>
    </header>
  );
}
