package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return this.f16339a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        Drawable drawable = this.f16339a;
        return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
    }
}
