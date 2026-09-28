package com.airbnb.lottie.utils;

import android.support.v4.media.a;

/* loaded from: classes3.dex */
public class GammaEvaluator {
    public static float a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f2, int i2, int i3) {
        if (i2 == i3 || f2 <= 0.0f) {
            return i2;
        }
        if (f2 >= 1.0f) {
            return i3;
        }
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float f4 = ((i3 >> 24) & 255) / 255.0f;
        float fA = a(((i2 >> 16) & 255) / 255.0f);
        float fA2 = a(((i2 >> 8) & 255) / 255.0f);
        float fA3 = a((i2 & 255) / 255.0f);
        float fA4 = a(((i3 >> 16) & 255) / 255.0f);
        float fA5 = a(((i3 >> 8) & 255) / 255.0f);
        float fA6 = a((i3 & 255) / 255.0f);
        float fA7 = a.a(f4, f3, f2, f3);
        float fA8 = a.a(fA4, fA, f2, fA);
        float fA9 = a.a(fA5, fA2, f2, fA2);
        float fA10 = a.a(fA6, fA3, f2, fA3);
        float fB = b(fA8) * 255.0f;
        float fB2 = b(fA9) * 255.0f;
        return Math.round(b(fA10) * 255.0f) | (Math.round(fB) << 16) | (Math.round(fA7 * 255.0f) << 24) | (Math.round(fB2) << 8);
    }
}
