import React, { useEffect } from 'react';
import { getPlatform, PLATFORM_ORDER } from '../lib/platforms';

function CartItemRow({ item, onQtyChange, onRemove }) {
  const platform = getPlatform(item.platform);

  return (
    <div className="cart-item">
      <div className="cart-item-img-wrap">
        {item.imageUrl ? (
          <img
            src={item.imageUrl}
            alt={item.name}
            className="cart-item-img"
            onError={(e) => { e.target.style.display = 'none'; }}
          />
        ) : (
          <div className="cart-item-img-placeholder" />
        )}
      </div>

      <div className="cart-item-info">
        <p className="cart-item-name">{item.name}</p>
        {item.displayQuantity && (
          <p className="cart-item-size">{item.displayQuantity}</p>
        )}
        <p className="cart-item-price">₹{(item.unitPrice * item.quantity).toFixed(0)}</p>
      </div>

      <div className="cart-item-controls">
        <div className="qty-control">
          <button
            className="qty-btn minus"
            onClick={() => onQtyChange(item.quantity - 1)}
            aria-label="Decrease"
          >
            <svg width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
              <line x1="5" y1="12" x2="19" y2="12" />
            </svg>
          </button>
          <span className="qty-num">{item.quantity}</span>
          <button
            className="qty-btn plus"
            onClick={() => onQtyChange(item.quantity + 1)}
            aria-label="Increase"
          >
            <svg width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
              <line x1="12" y1="5" x2="12" y2="19" /><line x1="5" y1="12" x2="19" y2="12" />
            </svg>
          </button>
        </div>
        <button className="cart-remove-btn" onClick={onRemove} aria-label="Remove item">
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
            <polyline points="3 6 5 6 21 6" />
            <path d="M19 6l-1 14H6L5 6" />
            <path d="M10 11v6M14 11v6" />
            <path d="M9 6V4h6v2" />
          </svg>
        </button>
      </div>
    </div>
  );
}

function PlatformSection({ platformKey, items, onQtyChange, onRemove }) {
  const platform = getPlatform(platformKey);
  const subtotal = items.reduce((s, i) => s + i.quantity * i.unitPrice, 0);

  const handleCheckout = () => {
    window.open(platform.checkoutUrl, '_blank', 'noopener,noreferrer');
  };

  return (
    <div className="cart-platform-section">
      <div className="cart-platform-header">
        <span
          className="cart-platform-badge"
          style={{ background: platform.bg, border: `1px solid ${platform.border}`, color: platform.color }}
        >
          {platform.name}
        </span>
        <span className="cart-platform-subtotal">₹{subtotal.toFixed(0)}</span>
      </div>

      <div className="cart-item-list">
        {items.map((item) => (
          <CartItemRow
            key={`${item.platform}-${item.platformId}`}
            item={item}
            onQtyChange={(qty) => onQtyChange(item.platform, item.platformId, qty)}
            onRemove={() => onRemove(item.platform, item.platformId)}
          />
        ))}
      </div>

      <button
        className="checkout-btn"
        style={{ background: platform.color }}
        onClick={handleCheckout}
      >
        <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
          <path d="M18 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V8a2 2 0 012-2h6" />
          <polyline points="15 3 21 3 21 9" />
          <line x1="10" y1="14" x2="21" y2="3" />
        </svg>
        Checkout on {platform.name}
      </button>
    </div>
  );
}

export function CartDrawer({ isOpen, onClose, cart }) {
  const { byPlatform, totalItems, totalPrice, updateQty, removeItem, clearCart } = cart;

  // Lock body scroll when open
  useEffect(() => {
    if (isOpen) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = '';
    }
    return () => { document.body.style.overflow = ''; };
  }, [isOpen]);

  // Close on Escape
  useEffect(() => {
    const handler = (e) => { if (e.key === 'Escape') onClose(); };
    window.addEventListener('keydown', handler);
    return () => window.removeEventListener('keydown', handler);
  }, [onClose]);

  const platformKeys = PLATFORM_ORDER.filter((p) => byPlatform[p]?.length > 0);
  const multiPlatform = platformKeys.length > 1;

  return (
    <>
      {/* Backdrop */}
      <div
        className={`cart-backdrop ${isOpen ? 'open' : ''}`}
        onClick={onClose}
        aria-hidden="true"
      />

      {/* Drawer */}
      <div
        className={`cart-drawer ${isOpen ? 'open' : ''}`}
        role="dialog"
        aria-modal="true"
        aria-label="Shopping cart"
      >
        {/* Drawer header */}
        <div className="cart-drawer-header">
          <div className="cart-drawer-title">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
              <path d="M6 2L3 6v14a2 2 0 002 2h14a2 2 0 002-2V6l-3-4z" />
              <line x1="3" y1="6" x2="21" y2="6" />
              <path d="M16 10a4 4 0 01-8 0" />
            </svg>
            <span>My Cart</span>
            {totalItems > 0 && <span className="cart-count-badge">{totalItems}</span>}
          </div>
          <div className="cart-drawer-actions">
            {totalItems > 0 && (
              <button className="cart-clear-btn" onClick={clearCart} title="Clear cart">
                Clear
              </button>
            )}
            <button className="cart-close-btn" onClick={onClose} aria-label="Close cart">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
                <line x1="18" y1="6" x2="6" y2="18" /><line x1="6" y1="6" x2="18" y2="18" />
              </svg>
            </button>
          </div>
        </div>

        {/* Drawer body */}
        <div className="cart-drawer-body">
          {totalItems === 0 ? (
            <div className="cart-empty">
              <div className="cart-empty-icon">
                <svg width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.2" strokeLinecap="round" strokeLinejoin="round" opacity="0.3">
                  <path d="M6 2L3 6v14a2 2 0 002 2h14a2 2 0 002-2V6l-3-4z" />
                  <line x1="3" y1="6" x2="21" y2="6" />
                  <path d="M16 10a4 4 0 01-8 0" />
                </svg>
              </div>
              <p className="cart-empty-title">Your cart is empty</p>
              <p className="cart-empty-sub">Add items from the search results to compare and checkout</p>
            </div>
          ) : (
            <>
              {multiPlatform && (
                <div className="cart-multi-warning">
                  <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
                    <circle cx="12" cy="12" r="10" />
                    <line x1="12" y1="8" x2="12" y2="12" />
                    <line x1="12" y1="16" x2="12.01" y2="16" />
                  </svg>
                  Items from {platformKeys.length} platforms require separate checkouts
                </div>
              )}

              {platformKeys.map((platformKey) => (
                <PlatformSection
                  key={platformKey}
                  platformKey={platformKey}
                  items={byPlatform[platformKey]}
                  onQtyChange={updateQty}
                  onRemove={removeItem}
                />
              ))}
            </>
          )}
        </div>

        {/* Drawer footer */}
        {totalItems > 0 && (
          <div className="cart-drawer-footer">
            <div className="cart-total-row">
              <span className="cart-total-label">Total ({totalItems} item{totalItems !== 1 ? 's' : ''})</span>
              <span className="cart-total-amount">₹{totalPrice.toFixed(0)}</span>
            </div>
            {multiPlatform && (
              <p className="cart-total-note">Across {platformKeys.length} platforms</p>
            )}
          </div>
        )}
      </div>
    </>
  );
}
