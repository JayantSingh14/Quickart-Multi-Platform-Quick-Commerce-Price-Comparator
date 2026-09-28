package com.facebook.imagepipeline.cache;

import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.analytics.l;
import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public abstract class AbstractAdaptiveCountingMemoryCache<K, V> implements CountingMemoryCache<K, V> {

    /* renamed from: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache$1, reason: invalid class name */
    class AnonymousClass1 implements ValueDescriptor<CountingMemoryCache.Entry<Object, Object>> {
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public final int a(Object obj) {
            ((CountingMemoryCache.Entry) obj).f17741b.l();
            throw null;
        }
    }

    /* renamed from: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache$2, reason: invalid class name */
    class AnonymousClass2 implements ResourceReleaser<Object> {
        @Override // com.facebook.common.references.ResourceReleaser
        public final void a(Object obj) {
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ArrayListType {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ArrayListType[] f17719a = {new ArrayListType("LFU", 0), new ArrayListType("MFU", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        ArrayListType EF5;

        public static ArrayListType valueOf(String str) {
            return (ArrayListType) Enum.valueOf(ArrayListType.class, str);
        }

        public static ArrayListType[] values() {
            return (ArrayListType[]) f17719a.clone();
        }
    }

    @VisibleForTesting
    public class IntMapArrayList<E> {
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final CloseableReference b(Object obj, CloseableReference closeableReference) {
        obj.getClass();
        closeableReference.getClass();
        synchronized (this) {
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final int c(Predicate predicate) {
        synchronized (this) {
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final synchronized boolean d(l lVar) {
        throw null;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final CloseableReference get(Object obj) {
        obj.getClass();
        synchronized (this) {
            throw null;
        }
    }
}
