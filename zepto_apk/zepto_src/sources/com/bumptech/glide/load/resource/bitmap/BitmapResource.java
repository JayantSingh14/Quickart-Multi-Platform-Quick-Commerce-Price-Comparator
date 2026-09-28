package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f16255a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapPool f16256b;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        Preconditions.c(bitmap, "Bitmap must not be null");
        this.f16255a = bitmap;
        Preconditions.c(bitmapPool, "BitmapPool must not be null");
        this.f16256b = bitmapPool;
    }

    public static BitmapResource b(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f16255a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return Util.c(this.f16255a);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public final void initialize() {
        this.f16255a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
        this.f16256b.b(this.f16255a);
    }
}
