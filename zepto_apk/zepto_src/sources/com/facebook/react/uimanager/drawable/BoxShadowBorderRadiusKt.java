package com.facebook.react.uimanager.drawable;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class BoxShadowBorderRadiusKt {
    public static final float a(float f2, float f3) {
        float fPow;
        if (f2 < Math.abs(f3)) {
            fPow = 1 + ((float) Math.pow((f2 / Math.abs(f3)) - r0, 3));
        } else {
            fPow = 1.0f;
        }
        float f4 = (f3 * fPow) + f2;
        if (f4 < 0.0f) {
            return 0.0f;
        }
        return f4;
    }
}
