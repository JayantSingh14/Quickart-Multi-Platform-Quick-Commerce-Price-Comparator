import React, { useState } from 'react';
import { getPlatform } from '../lib/platforms';

function ImgWithFallback({ src, alt, className }) {
  const [err, setErr] = useState(false);
  if (err || !src) {
    return (
      <div className={`${className} img-fallback`} aria-label={alt}>
        <svg width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" opacity="0.3">
          <rect x="3" y="3" width="18" height="18" rx="2" />
          <circle cx="8.5" cy="8.5" r="1.5" />
          <polyline points="21,15 16,10 5,21" />
        </svg>
      </div>
    );
  }
  return (
    <img
      src={src}
      alt={alt}
      className={className}
      onError={() => setErr(true)}
      loading="lazy"
    />
  );
}

function AddButton({ sku, isInCart, qty, onAdd, onQtyChange }) {
  if (!sku.inStock) {
    return <span className="sku-unavailable">Unavailable</span>;
  }

  if (isInCart) {
    return (
      <div className="qty-control">
        <button
          className="qty-btn minus"
          onClick={(e) => { e.stopPropagation(); onQtyChange(qty - 1); }}
          aria-label="Decrease quantity"
        >
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
            <line x1="5" y1="12" x2="19" y2="12" />
          </svg>
        </button>
        <span className="qty-num">{qty}</span>
        <button
          className="qty-btn plus"
          onClick={(e) => { e.stopPropagation(); onQtyChange(qty + 1); }}
          aria-label="Increase quantity"
        >
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
            <line x1="12" y1="5" x2="12" y2="19" /><line x1="5" y1="12" x2="19" y2="12" />
          </svg>
        </button>
      </div>
    );
  }

  return (
    <button
      className="add-btn"
      onClick={(e) => { e.stopPropagation(); onAdd(); }}
      aria-label={`Add to cart from ${sku.platform}`}
    >
      <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.5" strokeLinecap="round">
        <line x1="12" y1="5" x2="12" y2="19" /><line x1="5" y1="12" x2="19" y2="12" />
      </svg>
      Add
    </button>
  );
}

export function GroupCard({ group, cart }) {
  const { addItem, updateQty, isInCart, getQty } = cart;
  const lowestPrice = group.bestPrice;
  const imageUrl = group.skus[0]?.imageUrl ?? '';

  // Whether all SKUs in this group share the same pack size
  const uniqueSizes = new Set(
    group.skus.map((s) => s.displayQuantity ?? s.quantityInBaseUnit ?? 'unknown')
  );
  const mixedSizes = uniqueSizes.size > 1;

  // Show a per-row size tag if:
  //  - group has mixed sizes (different packs in same card), OR
  //  - this specific row's size differs from the group header label
  const rowShowsSize = (sku) => {
    if (!sku.displayQuantity) return false;
    if (mixedSizes) return true;
    return sku.displayQuantity !== group.displayQuantity;
  };

  const discount = (sku) => {
    if (!sku.mrp || sku.mrp <= sku.price) return null;
    return Math.round(((sku.mrp - sku.price) / sku.mrp) * 100);
  };

  return (
    <div className="group-card">
      {/* {group.platformCount >= 2 && (
        <div className="multi-badge">
          {group.platformCount} platforms
        </div>
      )} */}

      {/* Card header */}
      <div className="card-header">
        <ImgWithFallback
          src={imageUrl}
          alt={group.canonicalName}
          className="card-img"
        />
        <div className="card-info">
          <h3 className="card-title">{group.canonicalName}</h3>
          {group.displayQuantity && !mixedSizes && (
            <span className="card-qty-tag">{group.displayQuantity}</span>
          )}
          {mixedSizes && (
            <span className="card-qty-tag mixed">Multiple sizes</span>
          )}
          <div className="card-best-price">
            <span className="best-label">From</span>
            <span className="best-amount">₹{lowestPrice}</span>
            {!mixedSizes && group.bestPricePerUnitLabel && (
              <span className="best-unit">{group.bestPricePerUnitLabel}</span>
            )}
          </div>
        </div>
      </div>

      {/* Platform rows */}
      <div className="sku-list">
        {group.skus.map((sku, idx) => {
          const platform = getPlatform(sku.platform);
          const isBest = sku.price === lowestPrice && group.skus.length > 1;
          const disc = discount(sku);
          const inCart = isInCart(sku.platform, sku.platformId);
          const qty = getQty(sku.platform, sku.platformId);

          return (
            <div
              key={`${sku.platform}-${sku.platformId}-${idx}`}
              className={`sku-row ${isBest ? 'sku-best' : ''}`}
              style={{ '--platform-color': platform.color, '--platform-rgb': platform.colorRgb }}
            >
              {/* Platform + pack size (when mixed) */}
              <div className="sku-left">
                <div className="sku-platform-col">
                  <span
                    className="platform-badge"
                    style={{
                      background: platform.bg,
                      border: `1px solid ${platform.border}`,
                      color: platform.color,
                    }}
                  >
                    {platform.shortName}
                  </span>
                  {/* Show individual SKU pack size when it adds info beyond the group header */}
                  {rowShowsSize(sku) && (
                    <span className="sku-size-tag">{sku.displayQuantity}</span>
                  )}
                </div>
                {isBest && (
                  <span className="best-tag">BEST</span>
                )}
              </div>

              {/* Pricing */}
              <div className="sku-pricing">
                <span className="sku-price">₹{sku.price}</span>
                {sku.mrp && sku.mrp > sku.price && (
                  <span className="sku-mrp">₹{sku.mrp}</span>
                )}
                {disc !== null && (
                  <span className="sku-disc">{disc}% off</span>
                )}
                {sku.pricePerUnitLabel && (
                  <span className="sku-per-unit">{sku.pricePerUnitLabel}</span>
                )}
              </div>

              {/* Add to cart */}
              <AddButton
                sku={sku}
                isInCart={inCart}
                qty={qty}
                onAdd={() => addItem(sku)}
                onQtyChange={(newQty) => updateQty(sku.platform, sku.platformId, newQty)}
              />
            </div>
          );
        })}
      </div>
    </div>
  );
}
