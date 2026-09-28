package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
class EngineResource<Z> implements Resource<Z> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15993a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15994b;

    /* renamed from: c, reason: collision with root package name */
    public final Resource f15995c;

    /* renamed from: d, reason: collision with root package name */
    public final Engine f15996d;

    /* renamed from: e, reason: collision with root package name */
    public final Key f15997e;

    /* renamed from: f, reason: collision with root package name */
    public int f15998f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15999g;

    public interface ResourceListener {
    }

    public EngineResource(Resource resource, boolean z, boolean z2, Key key, Engine engine) {
        Preconditions.c(resource, "Argument must not be null");
        this.f15995c = resource;
        this.f15993a = z;
        this.f15994b = z2;
        this.f15997e = key;
        Preconditions.c(engine, "Argument must not be null");
        this.f15996d = engine;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return this.f15995c.a();
    }

    public final synchronized void b() {
        if (this.f15999g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f15998f++;
    }

    public final void c() {
        boolean z;
        synchronized (this) {
            int i2 = this.f15998f;
            if (i2 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i3 = i2 - 1;
            this.f15998f = i3;
            if (i3 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f15996d.e(this.f15997e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f15995c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f15995c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final synchronized void recycle() {
        if (this.f15998f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f15999g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f15999g = true;
        if (this.f15994b) {
            this.f15995c.recycle();
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f15993a + ", listener=" + this.f15996d + ", key=" + this.f15997e + ", acquired=" + this.f15998f + ", isRecycled=" + this.f15999g + ", resource=" + this.f15995c + '}';
    }
}
