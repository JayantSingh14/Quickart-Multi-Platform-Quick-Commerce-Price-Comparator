package com.facebook.imagepipeline.cache;

import androidx.media3.exoplayer.analytics.l;
import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final MemoryCache f17750a;

    /* renamed from: b, reason: collision with root package name */
    public final MemoryCacheTracker f17751b;

    public InstrumentedMemoryCache(MemoryCache memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.f17750a = memoryCache;
        this.f17751b = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final CloseableReference b(Object obj, CloseableReference closeableReference) {
        this.f17751b.c(obj);
        return this.f17750a.b(obj, closeableReference);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final int c(Predicate predicate) {
        return this.f17750a.c(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final boolean d(l lVar) {
        return this.f17750a.d(lVar);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final CloseableReference get(Object obj) {
        CloseableReference closeableReference = this.f17750a.get(obj);
        MemoryCacheTracker memoryCacheTracker = this.f17751b;
        if (closeableReference == null) {
            memoryCacheTracker.b(obj);
            return closeableReference;
        }
        memoryCacheTracker.a(obj);
        return closeableReference;
    }
}
