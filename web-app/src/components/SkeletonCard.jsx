import React from 'react';

export function SkeletonCard() {
  return (
    <div className="group-card glass skeleton-wrapper" style={{ animation: 'none' }}>
      <div className="card-header">
        <div className="skeleton skeleton-image" />
        <div className="card-info" style={{ width: '100%', gap: 8 }}>
          <div className="skeleton skeleton-title" />
          <div className="skeleton skeleton-text" style={{ width: '35%' }} />
          <div className="skeleton skeleton-text" style={{ width: '50%', marginTop: 4 }} />
        </div>
      </div>
      <div className="sku-list">
        <div className="skeleton skeleton-row" />
        <div className="skeleton skeleton-row" style={{ opacity: 0.65 }} />
        <div className="skeleton skeleton-row" style={{ opacity: 0.35 }} />
      </div>
    </div>
  );
}
