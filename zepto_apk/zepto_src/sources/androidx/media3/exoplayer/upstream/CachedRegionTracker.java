package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheSpan;
import androidx.media3.datasource.cache.SimpleCache;

@UnstableApi
/* loaded from: classes3.dex */
public final class CachedRegionTracker implements Cache.Listener {

    public static class Region implements Comparable<Region> {
        @Override // java.lang.Comparable
        public final int compareTo(Region region) {
            throw null;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final synchronized void a(CacheSpan cacheSpan) {
        long j2 = cacheSpan.f5984b;
        throw null;
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final synchronized void c(SimpleCache simpleCache, CacheSpan cacheSpan) {
        throw null;
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void b(SimpleCache simpleCache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }
}
