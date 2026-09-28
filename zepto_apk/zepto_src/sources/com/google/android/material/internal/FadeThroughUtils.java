package com.google.android.material.internal;

/* loaded from: classes4.dex */
final class FadeThroughUtils {
    public static void a(float[] fArr, float f2) {
        if (f2 <= 0.5f) {
            fArr[0] = 1.0f - (f2 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f2 * 2.0f) - 1.0f;
        }
    }
}
