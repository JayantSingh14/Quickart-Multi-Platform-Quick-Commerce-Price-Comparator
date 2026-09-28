package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class FactoryPools {

    /* renamed from: a, reason: collision with root package name */
    public static final Resetter f16531a = new AnonymousClass1();

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$1, reason: invalid class name */
    public class AnonymousClass1 implements Resetter<Object> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public final void a(Object obj) {
        }
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$2, reason: invalid class name */
    class AnonymousClass2 implements Factory<List<Object>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public final Object create() {
            return new ArrayList();
        }
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$3, reason: invalid class name */
    class AnonymousClass3 implements Resetter<List<Object>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public final void a(Object obj) {
            ((List) obj).clear();
        }
    }

    public interface Factory<T> {
        Object create();
    }

    public static final class FactoryPool<T> implements Pools.Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Factory f16532a;

        /* renamed from: b, reason: collision with root package name */
        public final Resetter f16533b;

        /* renamed from: c, reason: collision with root package name */
        public final Pools.SynchronizedPool f16534c;

        public FactoryPool(Pools.SynchronizedPool synchronizedPool, Factory factory, Resetter resetter) {
            this.f16534c = synchronizedPool;
            this.f16532a = factory;
            this.f16533b = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public final boolean a(Object obj) {
            if (obj instanceof Poolable) {
                ((StateVerifier.DefaultStateVerifier) ((Poolable) obj).b()).f16535a = true;
            }
            this.f16533b.a(obj);
            return this.f16534c.a(obj);
        }

        @Override // androidx.core.util.Pools.Pool
        public final Object b() {
            Object objB = this.f16534c.b();
            if (objB == null) {
                objB = this.f16532a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objB.getClass());
                }
            }
            if (objB instanceof Poolable) {
                ((StateVerifier.DefaultStateVerifier) ((Poolable) objB).b()).f16535a = false;
            }
            return objB;
        }
    }

    public interface Poolable {
        StateVerifier b();
    }

    public interface Resetter<T> {
        void a(Object obj);
    }

    public static Pools.Pool a(int i2, Factory factory) {
        return new FactoryPool(new Pools.SynchronizedPool(i2), factory, f16531a);
    }

    public static Pools.Pool b() {
        return new FactoryPool(new Pools.SynchronizedPool(20), new AnonymousClass2(), new AnonymousClass3());
    }
}
