package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public interface CloseableStaticBitmap extends CloseableBitmap {
    static CloseableStaticBitmap Q(CloseableReference closeableReference, QualityInfo qualityInfo, int i2, int i3) {
        int i4 = BaseCloseableStaticBitmap.f17948i;
        return new DefaultCloseableStaticBitmap(closeableReference, qualityInfo, i2, i3);
    }

    static CloseableStaticBitmap q0(Bitmap bitmap, SimpleBitmapReleaser simpleBitmapReleaser, ImmutableQualityInfo immutableQualityInfo) {
        int i2 = BaseCloseableStaticBitmap.f17948i;
        return new DefaultCloseableStaticBitmap(bitmap, simpleBitmapReleaser, immutableQualityInfo);
    }

    CloseableReference G();

    int H0();

    int X0();
}
