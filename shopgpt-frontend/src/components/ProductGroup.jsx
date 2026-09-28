import styles from './ProductGroup.module.css';

const PLATFORM_STYLE = {
  zepto:     { label: 'Zepto',     color: '#d72863' },
  blinkit:   { label: 'Blinkit',   color: '#c9a227' },
  instamart: { label: 'Instamart', color: '#fc8019' },
  swiggy:    { label: 'Swiggy',    color: '#fc8019' },
  flipkart:  { label: 'Flipkart',  color: '#2874f0' },
};

function hexToRgb(hex) {
  // Handles 3 and 6-digit hex
  const h = hex.replace('#', '');
  const full = h.length === 3 ? h.split('').map(c => c + c).join('') : h;
  const n = parseInt(full, 16);
  return `${(n >> 16) & 255}, ${(n >> 8) & 255}, ${n & 255}`;
}

function calcPerUnit(price, weightValue, weightUnit) {
  if (!weightValue || !weightUnit) return null;
  if (weightUnit === 'g'  && weightValue >= 50)  return `₹${(price / weightValue * 100).toFixed(1)}/100g`;
  if (weightUnit === 'ml' && weightValue >= 50)  return `₹${(price / weightValue * 100).toFixed(1)}/100ml`;
  return null;
}

export default function ProductGroup({ group, rank, etaMap = {} }) {
  const { groupName, normalizedWeight, weightValue, weightUnit, matches } = group;

  // Representative image: cheapest match that has one
  const imageUrl = matches.find(m => m.imageUrl)?.imageUrl ?? null;
  const bestPrice = matches[0]?.price;
  const perUnit   = calcPerUnit(bestPrice, weightValue, weightUnit);

  return (
    <div className={`${styles.card} ${rank === 0 ? styles.topRank : ''}`}>
      {/* Rank badge */}
      {rank === 0 && <span className={styles.bestBadge}>Best match</span>}

      <div className={styles.inner}>
        {/* Product image */}
        <div className={styles.imgWrap}>
          {imageUrl ? (
            <img src={imageUrl} alt={groupName} className={styles.img} />
          ) : (
            <div className={styles.imgPlaceholder}>
              <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5">
                <rect x="3" y="3" width="18" height="18" rx="2"/><circle cx="8.5" cy="8.5" r="1.5"/>
                <polyline points="21 15 16 10 5 21"/>
              </svg>
            </div>
          )}
        </div>

        {/* Info */}
        <div className={styles.info}>
          <div className={styles.titleRow}>
            <span className={styles.name}>{groupName}</span>
            {normalizedWeight && (
              <span className={styles.weightBadge}>{normalizedWeight}</span>
            )}
          </div>

          <div className={styles.pricesRow}>
            {matches.map((match, i) => {
              const meta = PLATFORM_STYLE[match.platform] ?? { label: match.platform, color: '#9ca3af' };
              const isBest = i === 0;
              const etaLabel = etaMap[match.platform] ?? null;
              const isUnavailable = etaLabel === 'Unavailable';
              return (
                <div
                  key={`${match.platform}-${match.id}`}
                  className={`${styles.platformPill} ${isBest ? styles.bestPill : ''} ${isUnavailable ? styles.unavailablePill : ''}`}
                  style={isBest && !isUnavailable ? {
                    background: `rgba(${hexToRgb(meta.color)}, 0.1)`,
                    borderColor: `rgba(${hexToRgb(meta.color)}, 0.3)`,
                  } : {}}
                  title={isUnavailable ? `${meta.label} not serviceable in your area` : undefined}
                >
                  <span
                    className={styles.platformName}
                    style={{ color: isUnavailable ? '#6b7280' : (isBest ? meta.color : '#6b7280') }}
                  >
                    {meta.label}
                  </span>
                  <span className={`${styles.price} ${isBest && !isUnavailable ? styles.bestPrice : ''} ${isUnavailable ? styles.unavailablePrice : ''}`}>
                    ₹{match.price}
                  </span>
                  {isBest && !isUnavailable && <span className={styles.bestStar}>★</span>}
                  {etaLabel && (
                    <span className={`${styles.etaLabel} ${isUnavailable ? styles.etaUnavailable : ''}`}>
                      {etaLabel}
                    </span>
                  )}
                </div>
              );
            })}

            {perUnit && (
              <span className={styles.perUnit}>{perUnit}</span>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
