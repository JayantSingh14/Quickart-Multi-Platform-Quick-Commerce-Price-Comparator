import styles from './SuggestionChips.module.css';

const ACTION_ICONS = {
  search:   '🔍',
  followup: '→',
};

export default function SuggestionChips({ chips, onChipClick }) {
  if (!chips?.length) return null;

  const handleClick = (chip) => {
    if (chip.action === 'search' && chip.query) {
      onChipClick(`Find ${chip.query}`);
    } else {
      onChipClick(chip.label);
    }
  };

  return (
    <div className={`${styles.row} animate-fade`}>
      {chips.map((chip, i) => (
        <button
          key={i}
          className={`${styles.chip} ${chip.action === 'search' ? styles.chipSearch : styles.chipFollowup}`}
          onClick={() => handleClick(chip)}
        >
          <span className={styles.icon}>
            {ACTION_ICONS[chip.action] ?? '→'}
          </span>
          <span className={styles.label}>{chip.label}</span>
        </button>
      ))}
    </div>
  );
}
