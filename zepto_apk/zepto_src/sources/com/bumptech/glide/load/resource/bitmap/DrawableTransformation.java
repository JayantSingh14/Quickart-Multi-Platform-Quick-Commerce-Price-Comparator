package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    public final Transformation f16287b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16288c;

    public DrawableTransformation(Transformation transformation, boolean z) {
        this.f16287b = transformation;
        this.f16288c = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    public final Resource a(Context context, Resource resource, int i2, int i3) {
        BitmapPool bitmapPool = Glide.b(context).f15648a;
        Drawable drawable = (Drawable) resource.get();
        BitmapResource bitmapResourceA = DrawableToBitmapConverter.a(bitmapPool, drawable, i2, i3);
        if (bitmapResourceA != null) {
            Resource resourceA = this.f16287b.a(context, bitmapResourceA, i2, i3);
            if (!resourceA.equals(bitmapResourceA)) {
                return new LazyBitmapDrawableResource(context.getResources(), resourceA);
            }
            resourceA.recycle();
            return resource;
        }
        if (!this.f16288c) {
            return resource;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        this.f16287b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f16287b.equals(((DrawableTransformation) obj).f16287b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.f16287b.hashCode();
    }
}
