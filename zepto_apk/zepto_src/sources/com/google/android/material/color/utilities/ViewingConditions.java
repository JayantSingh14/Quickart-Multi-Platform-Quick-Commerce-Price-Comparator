package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class ViewingConditions {
    static {
        double[] dArr = ColorUtils.f40261a;
        double dA = (ColorUtils.a(50.0d) * 63.66197723675813d) / 100.0d;
        double dMax = Math.max(0.1d, 50.0d);
        double[][] dArr2 = Cam16.f40260a;
        double d2 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d3 = dArr3[0] * d2;
        double d4 = dArr[1];
        double d5 = (dArr3[1] * d4) + d3;
        double d6 = dArr[2];
        double d7 = (dArr3[2] * d6) + d5;
        double[] dArr4 = dArr2[1];
        double d8 = (dArr4[2] * d6) + (dArr4[1] * d4) + (dArr4[0] * d2);
        double[] dArr5 = dArr2[2];
        double d9 = (d6 * dArr5[2]) + (d4 * dArr5[1]) + (d2 * dArr5[0]);
        double dExp = (1.0d - (Math.exp(((-dA) - 42.0d) / 92.0d) * 0.2777777777777778d)) * 1.0d;
        if (dExp < 0.0d) {
            dExp = 0.0d;
        } else if (dExp > 1.0d) {
            dExp = 1.0d;
        }
        double[] dArr6 = {(((100.0d / d7) * dExp) + 1.0d) - dExp, (((100.0d / d8) * dExp) + 1.0d) - dExp, (((100.0d / d9) * dExp) + 1.0d) - dExp};
        double d10 = 5.0d * dA;
        double d11 = 1.0d / (d10 + 1.0d);
        double d12 = d11 * d11 * d11 * d11;
        double d13 = 1.0d - d12;
        double dCbrt = (Math.cbrt(d10) * 0.1d * d13 * d13) + (d12 * dA);
        double dA2 = ColorUtils.a(dMax) / dArr[1];
        Math.sqrt(dA2);
        Math.pow(dA2, 0.2d);
        Math.pow(((dArr6[0] * dCbrt) * d7) / 100.0d, 0.42d);
        Math.pow(((dArr6[1] * dCbrt) * d8) / 100.0d, 0.42d);
        Math.pow(((dArr6[2] * dCbrt) * d9) / 100.0d, 0.42d);
        Math.pow(dCbrt, 0.25d);
    }

    public ViewingConditions(double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, double d8, double d9, double d10) {
    }
}
