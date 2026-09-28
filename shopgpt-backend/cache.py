import time
from typing import Dict, Any, Tuple, Optional

# In-memory store: {(platform, cache_key): (timestamp, data)}
_CACHE: Dict[Tuple[str, str], Tuple[float, Any]] = {}

CACHE_TTL_SECONDS = 300  # 5 minutes

def get_cached_data(platform: str, cache_key: str) -> Optional[Any]:
    """Retrieve data from cache if it exists and hasn't expired."""
    key = (platform, cache_key)
    if key in _CACHE:
        timestamp, data = _CACHE[key]
        if time.time() - timestamp < CACHE_TTL_SECONDS:
            return data
        else:
            del _CACHE[key]
    return None

def set_cached_data(platform: str, cache_key: str, data: Any):
    """Save data to cache with the current timestamp."""
    key = (platform, cache_key)
    _CACHE[key] = (time.time(), data)
    
def clear_cache():
    """Clear all cached data."""
    _CACHE.clear()
