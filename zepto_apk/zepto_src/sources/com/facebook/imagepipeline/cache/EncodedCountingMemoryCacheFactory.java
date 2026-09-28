package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class EncodedCountingMemoryCacheFactory {

    /* renamed from: com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements ValueDescriptor<PooledByteBuffer> {
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public final int a(Object obj) {
            return ((PooledByteBuffer) obj).size();
        }
    }

    public static LruCountingMemoryCache a(Supplier supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new AnonymousClass1(), cacheTrimStrategy, supplier, null);
        memoryTrimmableRegistry.getClass();
        return lruCountingMemoryCache;
    }
}
