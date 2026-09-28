package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* loaded from: classes3.dex */
final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: e, reason: collision with root package name */
    public static final Pools.Pool f16012e = FactoryPools.a(20, new AnonymousClass1());

    /* renamed from: a, reason: collision with root package name */
    public final StateVerifier f16013a = StateVerifier.a();

    /* renamed from: b, reason: collision with root package name */
    public Resource f16014b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16015c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16016d;

    /* renamed from: com.bumptech.glide.load.engine.LockedResource$1, reason: invalid class name */
    public class AnonymousClass1 implements FactoryPools.Factory<LockedResource<?>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public final Object create() {
            return new LockedResource();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return this.f16014b.a();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier b() {
        return this.f16013a;
    }

    public final synchronized void c() {
        this.f16013a.b();
        if (!this.f16015c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f16015c = false;
        if (this.f16016d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f16014b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f16014b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final synchronized void recycle() {
        this.f16013a.b();
        this.f16016d = true;
        if (!this.f16015c) {
            this.f16014b.recycle();
            this.f16014b = null;
            f16012e.a(this);
        }
    }
}
