package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.util.TreeSet;

@UnstableApi
/* loaded from: classes3.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* renamed from: a, reason: collision with root package name */
    public final long f6021a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeSet f6022b = new TreeSet(new a(0));

    /* renamed from: c, reason: collision with root package name */
    public long f6023c;

    public LeastRecentlyUsedCacheEvictor(long j2) {
        this.f6021a = j2;
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void a(CacheSpan cacheSpan) {
        this.f6022b.remove(cacheSpan);
        this.f6023c -= cacheSpan.f5985c;
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void b(SimpleCache simpleCache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        a(cacheSpan);
        c(simpleCache, cacheSpan2);
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public final void c(SimpleCache simpleCache, CacheSpan cacheSpan) {
        this.f6022b.add(cacheSpan);
        this.f6023c += cacheSpan.f5985c;
        while (this.f6023c > this.f6021a) {
            TreeSet treeSet = this.f6022b;
            if (treeSet.isEmpty()) {
                return;
            }
            CacheSpan cacheSpan2 = (CacheSpan) treeSet.first();
            synchronized (simpleCache) {
                simpleCache.k(cacheSpan2);
            }
        }
    }
}
