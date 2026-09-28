package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
public class CircleCrop extends BitmapTransformation {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f16261b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(Key.f15811a);

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f16261b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public final Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        Paint paint = TransformationUtils.f16322a;
        int iMin = Math.min(i2, i3);
        float f2 = iMin;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f2 / width, f2 / height);
        float f4 = width * fMax;
        float f5 = fMax * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap bitmapC = TransformationUtils.c(bitmap, bitmapPool);
        Bitmap bitmapE = bitmapPool.e(iMin, iMin, TransformationUtils.d(bitmap));
        bitmapE.setHasAlpha(true);
        Lock lock = TransformationUtils.f16325d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapE);
            canvas.drawCircle(f3, f3, f3, TransformationUtils.f16323b);
            canvas.drawBitmap(bitmapC, (Rect) null, rectF, TransformationUtils.f16324c);
            canvas.setBitmap(null);
            lock.unlock();
            if (!bitmapC.equals(bitmap)) {
                bitmapPool.b(bitmapC);
            }
            return bitmapE;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return 1101716364;
    }
}
