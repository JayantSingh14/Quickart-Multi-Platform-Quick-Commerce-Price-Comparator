package com.facebook.yoga;

/* loaded from: classes.dex */
public class YogaMeasureOutput {
    public static long a(float f2, float f3) {
        return Float.floatToRawIntBits(f3) | (Float.floatToRawIntBits(f2) << 32);
    }
}
