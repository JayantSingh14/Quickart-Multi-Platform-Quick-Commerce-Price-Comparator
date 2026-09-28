package com.google.android.material.carousel;

/* loaded from: classes4.dex */
final class CarouselStrategyHelper {
    public static float a(int i2, float f2, float f3) {
        return (Math.max(0, i2 - 1) * f3) + f2;
    }

    public static float b(int i2, float f2, float f3) {
        return i2 > 0 ? (f3 / 2.0f) + f2 : f2;
    }

    public static int c(int[] iArr) {
        int i2 = Integer.MIN_VALUE;
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    public static float d(float f2, float f3, float f4, int i2) {
        return i2 > 0 ? (f4 / 2.0f) + f3 : f2;
    }
}
