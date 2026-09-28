package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class Oscillator {

    /* renamed from: a, reason: collision with root package name */
    public float[] f1847a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    public double[] f1848b = new double[0];

    /* renamed from: c, reason: collision with root package name */
    public double[] f1849c;

    /* renamed from: d, reason: collision with root package name */
    public MonotonicCurveFit f1850d;

    /* renamed from: e, reason: collision with root package name */
    public int f1851e;

    public final void a(double d2, float f2) {
        int length = this.f1847a.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.f1848b, d2);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f1848b = Arrays.copyOf(this.f1848b, length);
        this.f1847a = Arrays.copyOf(this.f1847a, length);
        this.f1849c = new double[length];
        double[] dArr = this.f1848b;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.f1848b[iBinarySearch] = d2;
        this.f1847a[iBinarySearch] = f2;
    }

    public final double b(double d2) {
        if (d2 <= 0.0d) {
            return 0.0d;
        }
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f1848b, d2);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f1847a;
        float f2 = fArr[iBinarySearch];
        int i2 = iBinarySearch - 1;
        float f3 = fArr[i2];
        double d3 = f2 - f3;
        double[] dArr = this.f1848b;
        double d4 = dArr[iBinarySearch];
        double d5 = dArr[i2];
        double d6 = d3 / (d4 - d5);
        return ((((d2 * d2) - (d5 * d5)) * d6) / 2.0d) + ((d2 - d5) * (f3 - (d6 * d5))) + this.f1849c[i2];
    }

    public final double c(double d2, double d3) {
        double dAbs;
        double dB = b(d2) + d3;
        switch (this.f1851e) {
            case 1:
                return Math.signum(0.5d - (dB % 1.0d));
            case 2:
                dAbs = Math.abs((((dB * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((dB * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((dB * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d3 + dB) * 6.283185307179586d);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((dB * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.f1850d.b(dB % 1.0d);
            default:
                return Math.sin(6.283185307179586d * dB);
        }
        return 1.0d - dAbs;
    }

    public final String toString() {
        return "pos =" + Arrays.toString(this.f1848b) + " period=" + Arrays.toString(this.f1847a);
    }
}
