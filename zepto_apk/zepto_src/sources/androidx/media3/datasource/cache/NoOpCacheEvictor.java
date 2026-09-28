package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class NoOpCacheEvictor implements CacheEvictor {
    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void a(CacheSpan cacheSpan) {
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void c(SimpleCache simpleCache, CacheSpan cacheSpan) {
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void b(SimpleCache simpleCache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }
}
