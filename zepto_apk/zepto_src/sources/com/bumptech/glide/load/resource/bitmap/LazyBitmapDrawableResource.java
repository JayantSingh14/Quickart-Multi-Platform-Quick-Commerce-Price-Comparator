package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f16305a;

    /* renamed from: b, reason: collision with root package name */
    public final Resource f16306b;

    public LazyBitmapDrawableResource(Resources resources, Resource resource) {
        Preconditions.c(resources, "Argument must not be null");
        this.f16305a = resources;
        Preconditions.c(resource, "Argument must not be null");
        this.f16306b = resource;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return new BitmapDrawable(this.f16305a, (Bitmap) this.f16306b.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f16306b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public final void initialize() {
        Resource resource = this.f16306b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
        this.f16306b.recycle();
    }
}
