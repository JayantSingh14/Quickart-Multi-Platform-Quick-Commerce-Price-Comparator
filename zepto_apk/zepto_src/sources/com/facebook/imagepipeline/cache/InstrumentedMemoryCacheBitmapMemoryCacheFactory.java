package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class InstrumentedMemoryCacheBitmapMemoryCacheFactory {
    public static InstrumentedMemoryCache a(CountingMemoryCache countingMemoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.getClass();
        return new InstrumentedMemoryCache(countingMemoryCache, new MemoryCacheTracker<CacheKey>() { // from class: com.facebook.imagepipeline.cache.InstrumentedMemoryCacheBitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public final void a(Object obj) {
                imageCacheStatsTracker.getClass();
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public final void b(Object obj) {
                imageCacheStatsTracker.getClass();
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public final void c(Object obj) {
                imageCacheStatsTracker.getClass();
            }
        });
    }
}
