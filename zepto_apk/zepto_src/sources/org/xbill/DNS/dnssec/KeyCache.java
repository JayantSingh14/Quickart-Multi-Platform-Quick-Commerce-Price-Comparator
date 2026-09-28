package org.xbill.DNS.dnssec;

import j$.time.Clock;
import j$.time.Instant;
import j$.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.xbill.DNS.Name;

/* loaded from: classes5.dex */
final class KeyCache {
    private static final int DEFAULT_MAX_CACHE_SIZE = 1000;
    private static final int DEFAULT_MAX_TTL = 900;
    public static final String MAX_CACHE_SIZE_CONFIG = "dnsjava.dnssec.keycache.max_size";
    public static final String MAX_TTL_CONFIG = "dnsjava.dnssec.keycache.max_ttl";
    private final Map<String, CacheEntry> cache;
    private final Clock clock;
    private int maxCacheSize;
    private long maxTtl;

    public class CacheEntry {
        private final Instant expiration;
        private final KeyEntry keyEntry;

        public CacheEntry(KeyEntry keyEntry, long j2) {
            long ttl = keyEntry.getTTL();
            this.expiration = KeyCache.this.clock.instant().c(ttl <= j2 ? ttl : j2, ChronoUnit.SECONDS);
            this.keyEntry = keyEntry;
        }
    }

    public KeyCache() {
        this(Clock.systemUTC());
    }

    private String key(Name name, int i2) {
        return "K" + i2 + "/" + name;
    }

    private KeyEntry lookupEntry(String str) {
        CacheEntry cacheEntry = this.cache.get(str);
        if (cacheEntry == null) {
            return null;
        }
        if (!cacheEntry.expiration.isBefore(this.clock.instant())) {
            return cacheEntry.keyEntry;
        }
        this.cache.remove(str);
        return null;
    }

    public KeyEntry find(Name name, int i2) {
        while (name.labels() > 0) {
            KeyEntry keyEntryLookupEntry = lookupEntry(key(name, i2));
            if (keyEntryLookupEntry != null) {
                return keyEntryLookupEntry;
            }
            name = new Name(name, 1);
        }
        return null;
    }

    public void init(Properties properties) {
        if (properties == null) {
            return;
        }
        String property = properties.getProperty(MAX_TTL_CONFIG);
        if (property != null) {
            this.maxTtl = Long.parseLong(property);
        }
        String property2 = properties.getProperty(MAX_CACHE_SIZE_CONFIG);
        if (property2 != null) {
            this.maxCacheSize = Integer.parseInt(property2);
        }
    }

    public void store(KeyEntry keyEntry) {
        if ((keyEntry.isGood() || keyEntry.isNull()) && keyEntry.getType() == 48) {
            this.cache.put(key(keyEntry.getName(), keyEntry.getDClass()), new CacheEntry(keyEntry, this.maxTtl));
        }
    }

    public KeyCache(Clock clock) {
        this.maxTtl = 900L;
        this.maxCacheSize = DEFAULT_MAX_CACHE_SIZE;
        this.clock = clock;
        this.cache = Collections.synchronizedMap(new LinkedHashMap<String, CacheEntry>() { // from class: org.xbill.DNS.dnssec.KeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, CacheEntry> entry) {
                return size() >= KeyCache.this.maxCacheSize;
            }
        });
    }
}
