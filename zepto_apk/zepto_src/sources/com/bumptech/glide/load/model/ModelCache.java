package com.bumptech.glide.load.model;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public class ModelCache<A, B> {

    /* renamed from: a, reason: collision with root package name */
    public final LruCache f16164a;

    /* renamed from: com.bumptech.glide.load.model.ModelCache$1, reason: invalid class name */
    class AnonymousClass1 extends LruCache<ModelKey<Object>, Object> {
        @Override // com.bumptech.glide.util.LruCache
        public final void d(Object obj, Object obj2) {
            ModelKey modelKey = (ModelKey) obj;
            modelKey.getClass();
            ArrayDeque arrayDeque = ModelKey.f16165b;
            synchronized (arrayDeque) {
                arrayDeque.offer(modelKey);
            }
        }
    }

    @VisibleForTesting
    public static final class ModelKey<A> {

        /* renamed from: b, reason: collision with root package name */
        public static final ArrayDeque f16165b;

        /* renamed from: a, reason: collision with root package name */
        public Object f16166a;

        static {
            char[] cArr = Util.f16528a;
            f16165b = new ArrayDeque(0);
        }

        public static ModelKey a(Object obj) {
            ModelKey modelKey;
            ArrayDeque arrayDeque = f16165b;
            synchronized (arrayDeque) {
                modelKey = (ModelKey) arrayDeque.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey();
            }
            modelKey.f16166a = obj;
            return modelKey;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            modelKey.getClass();
            return this.f16166a.equals(modelKey.f16166a);
        }

        public final int hashCode() {
            return this.f16166a.hashCode();
        }
    }

    public ModelCache() {
        this(250L);
    }

    public final Object a(Object obj) {
        ModelKey modelKeyA = ModelKey.a(obj);
        Object objB = this.f16164a.b(modelKeyA);
        ArrayDeque arrayDeque = ModelKey.f16165b;
        synchronized (arrayDeque) {
            arrayDeque.offer(modelKeyA);
        }
        return objB;
    }

    public final void b(Object obj, Object obj2) {
        this.f16164a.e(ModelKey.a(obj), obj2);
    }

    public ModelCache(long j2) {
        this.f16164a = new AnonymousClass1(j2);
    }
}
