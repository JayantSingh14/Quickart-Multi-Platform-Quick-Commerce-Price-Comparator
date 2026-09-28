package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class NativeBlurFilter {
    static {
        NativeLoader.b("native-filters");
    }

    public static void a(Bitmap bitmap, int i2, int i3) {
        if (!(i2 > 0)) {
            throw new IllegalArgumentException();
        }
        if (!(i3 > 0)) {
            throw new IllegalArgumentException();
        }
        nativeIterativeBoxBlur(bitmap, i2, i3);
    }

    @DoNotStrip
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
