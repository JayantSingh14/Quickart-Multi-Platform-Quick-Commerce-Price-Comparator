package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class CountingLruBitmapMemoryCacheFactory implements BitmapMemoryCacheFactory {

    /* renamed from: com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements ValueDescriptor<CloseableImage> {
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public final int a(Object obj) {
            return ((CloseableImage) obj).B0();
        }
    }

    public final LruCountingMemoryCache a(Supplier supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy, CountingMemoryCache.EntryStateObserver entryStateObserver) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new AnonymousClass1(), cacheTrimStrategy, supplier, entryStateObserver);
        memoryTrimmableRegistry.getClass();
        return lruCountingMemoryCache;
    }
}
