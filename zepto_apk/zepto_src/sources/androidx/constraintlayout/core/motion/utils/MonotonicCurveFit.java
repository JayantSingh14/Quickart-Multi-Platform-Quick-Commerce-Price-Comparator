package androidx.constraintlayout.core.motion.utils;

import android.support.v4.media.b;
import java.lang.reflect.Array;

/* loaded from: classes3.dex */
public class MonotonicCurveFit extends CurveFit {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f1842a;

    /* renamed from: b, reason: collision with root package name */
    public final double[][] f1843b;

    /* renamed from: c, reason: collision with root package name */
    public final double[][] f1844c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1845d = true;

    /* renamed from: e, reason: collision with root package name */
    public final double[] f1846e;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f1846e = new double[length2];
        int i2 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i2, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 1;
                double d2 = dArr[i5] - dArr[i4];
                double[] dArr5 = dArr3[i4];
                double d3 = (dArr2[i5][i3] - dArr2[i4][i3]) / d2;
                dArr5[i3] = d3;
                if (i4 == 0) {
                    dArr4[i4][i3] = d3;
                } else {
                    dArr4[i4][i3] = (dArr3[i4 - 1][i3] + d3) * 0.5d;
                }
                i4 = i5;
            }
            dArr4[i2][i3] = dArr3[length - 2][i3];
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < length2; i7++) {
                double d4 = dArr3[i6][i7];
                if (d4 == 0.0d) {
                    dArr4[i6][i7] = 0.0d;
                    dArr4[i6 + 1][i7] = 0.0d;
                } else {
                    double d5 = dArr4[i6][i7] / d4;
                    int i8 = i6 + 1;
                    double d6 = dArr4[i8][i7] / d4;
                    double dHypot = Math.hypot(d5, d6);
                    if (dHypot > 9.0d) {
                        double d7 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i6];
                        double[] dArr7 = dArr3[i6];
                        dArr6[i7] = d5 * d7 * dArr7[i7];
                        dArr4[i8][i7] = d7 * d6 * dArr7[i7];
                    }
                }
            }
        }
        this.f1842a = dArr;
        this.f1843b = dArr2;
        this.f1844c = dArr4;
    }

    public static double h(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d3 * 6.0d;
        double d10 = d2 * 3.0d;
        return (d2 * d6) + ((b.a(d10, d6, d8, b.a(d10, d7, d8, b.a(d8, 6.0d, d4, (d9 * d5) + (((-6.0d) * d8) * d5)) - (d9 * d4))) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3));
    }

    public static double i(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d8 * d3;
        double d10 = d8 * 3.0d;
        double dA = (b.a(d9, 2.0d, d4, (d10 * d5) + (((-2.0d) * d9) * d5)) - (d10 * d4)) + d4;
        double d11 = d2 * d7;
        double d12 = (d11 * d9) + dA;
        double d13 = d2 * d6;
        return (d13 * d3) + ((((d9 * d13) + d12) - (d11 * d8)) - (((d2 * 2.0d) * d6) * d8));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double b(double d2) {
        double d3;
        double d4;
        double dE;
        double[] dArr = this.f1842a;
        int length = dArr.length;
        boolean z = this.f1845d;
        double[][] dArr2 = this.f1843b;
        if (z) {
            double d5 = dArr[0];
            if (d2 <= d5) {
                d3 = dArr2[0][0];
                d4 = d2 - d5;
                dE = e(d5);
            } else {
                int i2 = length - 1;
                double d6 = dArr[i2];
                if (d2 >= d6) {
                    d3 = dArr2[i2][0];
                    d4 = d2 - d6;
                    dE = e(d6);
                }
            }
            return (dE * d4) + d3;
        }
        if (d2 <= dArr[0]) {
            return dArr2[0][0];
        }
        int i3 = length - 1;
        if (d2 >= dArr[i3]) {
            return dArr2[i3][0];
        }
        int i4 = 0;
        while (i4 < length - 1) {
            double d7 = dArr[i4];
            if (d2 == d7) {
                return dArr2[i4][0];
            }
            int i5 = i4 + 1;
            double d8 = dArr[i5];
            if (d2 < d8) {
                double d9 = d8 - d7;
                double d10 = (d2 - d7) / d9;
                double d11 = dArr2[i4][0];
                double d12 = dArr2[i5][0];
                double[][] dArr3 = this.f1844c;
                return i(d9, d10, d11, d12, dArr3[i4][0], dArr3[i5][0]);
            }
            i4 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void c(double d2, float[] fArr) {
        double[] dArr = this.f1842a;
        int length = dArr.length;
        double[][] dArr2 = this.f1843b;
        int i2 = 0;
        int length2 = dArr2[0].length;
        if (this.f1845d) {
            double d3 = dArr[0];
            double[] dArr3 = this.f1846e;
            if (d2 <= d3) {
                f(dArr3, d3);
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) (((d2 - dArr[0]) * dArr3[i3]) + dArr2[0][i3]);
                }
                return;
            }
            int i4 = length - 1;
            double d4 = dArr[i4];
            if (d2 >= d4) {
                f(dArr3, d4);
                while (i2 < length2) {
                    fArr[i2] = (float) (((d2 - dArr[i4]) * dArr3[i2]) + dArr2[i4][i2]);
                    i2++;
                }
                return;
            }
        } else {
            if (d2 <= dArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) dArr2[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d2 >= dArr[i6]) {
                while (i2 < length2) {
                    fArr[i2] = (float) dArr2[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == dArr[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) dArr2[i7][i8];
                }
            }
            int i9 = i7 + 1;
            double d5 = dArr[i9];
            if (d2 < d5) {
                double d6 = dArr[i7];
                double d7 = d5 - d6;
                double d8 = (d2 - d6) / d7;
                while (i2 < length2) {
                    double d9 = dArr2[i7][i2];
                    double d10 = dArr2[i9][i2];
                    double[][] dArr4 = this.f1844c;
                    fArr[i2] = (float) i(d7, d8, d9, d10, dArr4[i7][i2], dArr4[i9][i2]);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void d(double[] dArr, double d2) {
        double[] dArr2 = this.f1842a;
        int length = dArr2.length;
        double[][] dArr3 = this.f1843b;
        int i2 = 0;
        int length2 = dArr3[0].length;
        if (this.f1845d) {
            double d3 = dArr2[0];
            double[] dArr4 = this.f1846e;
            if (d2 <= d3) {
                f(dArr4, d3);
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = ((d2 - dArr2[0]) * dArr4[i3]) + dArr3[0][i3];
                }
                return;
            }
            int i4 = length - 1;
            double d4 = dArr2[i4];
            if (d2 >= d4) {
                f(dArr4, d4);
                while (i2 < length2) {
                    dArr[i2] = ((d2 - dArr2[i4]) * dArr4[i2]) + dArr3[i4][i2];
                    i2++;
                }
                return;
            }
        } else {
            if (d2 <= dArr2[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = dArr3[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d2 >= dArr2[i6]) {
                while (i2 < length2) {
                    dArr[i2] = dArr3[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == dArr2[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = dArr3[i7][i8];
                }
            }
            int i9 = i7 + 1;
            double d5 = dArr2[i9];
            if (d2 < d5) {
                double d6 = dArr2[i7];
                double d7 = d5 - d6;
                double d8 = (d2 - d6) / d7;
                while (i2 < length2) {
                    double d9 = dArr3[i7][i2];
                    double d10 = dArr3[i9][i2];
                    double[][] dArr5 = this.f1844c;
                    dArr[i2] = i(d7, d8, d9, d10, dArr5[i7][i2], dArr5[i9][i2]);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double e(double d2) {
        double[] dArr = this.f1842a;
        int length = dArr.length;
        double d3 = dArr[0];
        if (d2 >= d3) {
            d3 = dArr[length - 1];
            if (d2 < d3) {
                d3 = d2;
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            int i3 = i2 + 1;
            double d4 = dArr[i3];
            if (d3 <= d4) {
                double d5 = dArr[i2];
                double d6 = d4 - d5;
                double[][] dArr2 = this.f1843b;
                double d7 = dArr2[i2][0];
                double d8 = dArr2[i3][0];
                double[][] dArr3 = this.f1844c;
                return h(d6, (d3 - d5) / d6, d7, d8, dArr3[i2][0], dArr3[i3][0]) / d6;
            }
            i2 = i3;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void f(double[] dArr, double d2) {
        double[] dArr2 = this.f1842a;
        int length = dArr2.length;
        double[][] dArr3 = this.f1843b;
        int length2 = dArr3[0].length;
        double d3 = dArr2[0];
        if (d2 > d3) {
            d3 = dArr2[length - 1];
            if (d2 < d3) {
                d3 = d2;
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            int i3 = i2 + 1;
            double d4 = dArr2[i3];
            if (d3 <= d4) {
                double d5 = dArr2[i2];
                double d6 = d4 - d5;
                double d7 = (d3 - d5) / d6;
                for (int i4 = 0; i4 < length2; i4++) {
                    double d8 = dArr3[i2][i4];
                    double d9 = dArr3[i3][i4];
                    double[][] dArr4 = this.f1844c;
                    dArr[i4] = h(d6, d7, d8, d9, dArr4[i2][i4], dArr4[i3][i4]) / d6;
                }
                return;
            }
            i2 = i3;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] g() {
        return this.f1842a;
    }
}
