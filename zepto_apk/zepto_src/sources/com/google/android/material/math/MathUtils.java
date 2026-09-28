package com.google.android.material.math;

/* loaded from: classes4.dex */
public final class MathUtils {
    public static float a(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot(f4 - f2, f5 - f3);
    }

    public static float b(float f2, float f3, float f4, float f5) {
        float fA = a(f2, f3, 0.0f, 0.0f);
        float fA2 = a(f2, f3, f4, 0.0f);
        float fA3 = a(f2, f3, f4, f5);
        float fA4 = a(f2, f3, 0.0f, f5);
        return (fA <= fA2 || fA <= fA3 || fA <= fA4) ? (fA2 <= fA3 || fA2 <= fA4) ? fA3 > fA4 ? fA3 : fA4 : fA2 : fA;
    }

    public static float c(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }
}
