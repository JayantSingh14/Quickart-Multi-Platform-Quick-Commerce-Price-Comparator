package com.google.common.cache;

import androidx.media3.datasource.b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class CacheLoader<K, V> {

    /* renamed from: com.google.common.cache.CacheLoader$1, reason: invalid class name */
    class AnonymousClass1 extends CacheLoader<Object, Object> {
        @Override // com.google.common.cache.CacheLoader
        public final Object a(Object obj) {
            throw null;
        }

        @Override // com.google.common.cache.CacheLoader
        public final ListenableFuture b(Object obj, Object obj2) {
            new ListenableFutureTask(new b(5, obj, obj2));
            throw null;
        }
    }

    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        @Override // com.google.common.cache.CacheLoader
        public final Object a(Object obj) {
            obj.getClass();
            throw null;
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
    }

    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        @Override // com.google.common.cache.CacheLoader
        public final Object a(Object obj) {
            obj.getClass();
            throw null;
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    public abstract Object a(Object obj);

    public ListenableFuture b(Object obj, Object obj2) {
        obj.getClass();
        return Futures.d(a(obj));
    }
}
