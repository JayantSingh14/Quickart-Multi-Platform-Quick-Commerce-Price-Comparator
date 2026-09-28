package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class GranularRoundedCorners extends BitmapTransformation {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f16290b = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(Key.f15811a);

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f16290b);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(0.0f).putFloat(0.0f).putFloat(0.0f).putFloat(0.0f).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public final Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.e(bitmapPool, bitmap, new TransformationUtils.AnonymousClass2());
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof GranularRoundedCorners)) {
            return false;
        }
        ((GranularRoundedCorners) obj).getClass();
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Util.e(0.0f, Util.e(0.0f, Util.e(0.0f, Util.f(-2013597734, Util.e(0.0f, 17)))));
    }
}
