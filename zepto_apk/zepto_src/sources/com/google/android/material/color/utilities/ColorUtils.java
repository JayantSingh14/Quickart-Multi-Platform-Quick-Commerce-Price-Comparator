package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class ColorUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final double[] f40261a = {95.047d, 100.0d, 108.883d};

    public static double a(double d2) {
        double d3 = (d2 + 16.0d) / 116.0d;
        double d4 = d3 * d3 * d3;
        if (d4 <= 0.008856451679035631d) {
            d4 = ((d3 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        return d4 * 100.0d;
    }
}
