package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class NativeRoundingFilter {
    static {
        NativeLoader.b("native-filters");
    }

    public static void a(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        nativeAddRoundedCornersFilter(bitmap, i2, i3, i4, i5);
    }

    @DoNotStrip
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i2, int i3, int i4, int i5);

    @DoNotStrip
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z);

    @DoNotStrip
    public static void toCircle(Bitmap bitmap, boolean z) {
        bitmap.getClass();
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z);
    }

    @DoNotStrip
    public static void toCircleFast(Bitmap bitmap, boolean z) {
        bitmap.getClass();
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z);
    }
}
