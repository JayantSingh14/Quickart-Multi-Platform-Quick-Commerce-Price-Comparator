package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes3.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    @Override // com.bumptech.glide.load.Transformation
    public final Resource a(Context context, Resource resource, int i2, int i3) {
        throw null;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        throw null;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof BitmapDrawableTransformation)) {
            return false;
        }
        ((BitmapDrawableTransformation) obj).getClass();
        throw null;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        throw null;
    }
}
