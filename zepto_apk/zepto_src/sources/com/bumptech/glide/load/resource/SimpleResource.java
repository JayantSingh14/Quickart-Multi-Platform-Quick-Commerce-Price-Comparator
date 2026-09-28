package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class SimpleResource<T> implements Resource<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f16245a;

    public SimpleResource(Object obj) {
        Preconditions.c(obj, "Argument must not be null");
        this.f16245a = obj;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return this.f16245a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f16245a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
    }
}
