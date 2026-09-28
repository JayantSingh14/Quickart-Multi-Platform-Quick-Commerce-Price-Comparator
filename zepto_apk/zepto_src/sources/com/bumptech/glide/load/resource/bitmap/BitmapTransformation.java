package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.b;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    @Override // com.bumptech.glide.load.Transformation
    public final Resource a(Context context, Resource resource, int i2, int i3) {
        if (!Util.h(i2, i3)) {
            throw new IllegalArgumentException(b.e(i2, i3, "Cannot apply transformation on width: ", " or height: ", " less than or equal to zero and not Target.SIZE_ORIGINAL"));
        }
        BitmapPool bitmapPool = Glide.b(context).f15648a;
        Bitmap bitmap = (Bitmap) resource.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(bitmapPool, bitmap, i2, i3);
        return bitmap.equals(bitmapC) ? resource : BitmapResource.b(bitmapC, bitmapPool);
    }

    public abstract Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3);
}
