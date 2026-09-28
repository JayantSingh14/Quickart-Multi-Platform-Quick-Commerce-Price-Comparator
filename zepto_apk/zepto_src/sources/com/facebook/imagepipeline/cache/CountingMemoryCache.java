package com.facebook.imagepipeline.cache;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f17740a;

        /* renamed from: b, reason: collision with root package name */
        public final CloseableReference f17741b;

        /* renamed from: c, reason: collision with root package name */
        public int f17742c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f17743d;

        /* renamed from: e, reason: collision with root package name */
        public final EntryStateObserver f17744e;

        public Entry(Object obj, CloseableReference closeableReference, EntryStateObserver entryStateObserver, int i2) {
            obj.getClass();
            this.f17740a = obj;
            CloseableReference closeableReferenceC = CloseableReference.c(closeableReference);
            closeableReferenceC.getClass();
            this.f17741b = closeableReferenceC;
            this.f17742c = 0;
            this.f17743d = false;
            this.f17744e = entryStateObserver;
        }

        public static Entry a(Object obj, CloseableReference closeableReference, EntryStateObserver entryStateObserver) {
            return new Entry(obj, closeableReference, entryStateObserver, -1);
        }
    }

    /* loaded from: classes3.dex */
    public interface EntryStateObserver<K> {
        void a();
    }
}
