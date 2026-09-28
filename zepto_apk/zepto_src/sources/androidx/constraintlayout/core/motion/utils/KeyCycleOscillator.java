package androidx.constraintlayout.core.motion.utils;

import android.support.v4.media.b;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class KeyCycleOscillator {

    /* renamed from: a, reason: collision with root package name */
    public CycleOscillator f1818a;

    /* renamed from: b, reason: collision with root package name */
    public String f1819b;

    /* renamed from: c, reason: collision with root package name */
    public int f1820c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f1821d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f1822e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1823f = new ArrayList();

    /* renamed from: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<WavePoint> {
        @Override // java.util.Comparator
        public final int compare(WavePoint wavePoint, WavePoint wavePoint2) {
            return Integer.compare(wavePoint.f1833a, wavePoint2.f1833a);
        }
    }

    public static class CoreSpline extends KeyCycleOscillator {
    }

    public static class CycleOscillator {

        /* renamed from: a, reason: collision with root package name */
        public Oscillator f1824a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f1825b;

        /* renamed from: c, reason: collision with root package name */
        public double[] f1826c;

        /* renamed from: d, reason: collision with root package name */
        public float[] f1827d;

        /* renamed from: e, reason: collision with root package name */
        public float[] f1828e;

        /* renamed from: f, reason: collision with root package name */
        public float[] f1829f;

        /* renamed from: g, reason: collision with root package name */
        public CurveFit f1830g;

        /* renamed from: h, reason: collision with root package name */
        public double[] f1831h;

        /* renamed from: i, reason: collision with root package name */
        public double[] f1832i;
    }

    public static class PathRotateSet extends KeyCycleOscillator {
    }

    public static class WavePoint {

        /* renamed from: a, reason: collision with root package name */
        public final int f1833a;

        /* renamed from: b, reason: collision with root package name */
        public final float f1834b;

        /* renamed from: c, reason: collision with root package name */
        public final float f1835c;

        /* renamed from: d, reason: collision with root package name */
        public final float f1836d;

        /* renamed from: e, reason: collision with root package name */
        public final float f1837e;

        public WavePoint(float f2, float f3, float f4, float f5, int i2) {
            this.f1833a = i2;
            this.f1834b = f5;
            this.f1835c = f3;
            this.f1836d = f2;
            this.f1837e = f4;
        }
    }

    public final float a(float f2) {
        CycleOscillator cycleOscillator = this.f1818a;
        CurveFit curveFit = cycleOscillator.f1830g;
        if (curveFit != null) {
            curveFit.d(cycleOscillator.f1831h, f2);
        } else {
            double[] dArr = cycleOscillator.f1831h;
            dArr[0] = cycleOscillator.f1828e[0];
            dArr[1] = cycleOscillator.f1829f[0];
            dArr[2] = cycleOscillator.f1825b[0];
        }
        double[] dArr2 = cycleOscillator.f1831h;
        return (float) ((cycleOscillator.f1824a.c(f2, dArr2[1]) * cycleOscillator.f1831h[2]) + dArr2[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final float b(float f2) {
        char c2;
        char c3;
        double d2;
        double dE;
        double d3;
        double dSignum;
        CycleOscillator cycleOscillator = this.f1818a;
        CurveFit curveFit = cycleOscillator.f1830g;
        if (curveFit != null) {
            double d4 = f2;
            curveFit.f(cycleOscillator.f1832i, d4);
            cycleOscillator.f1830g.d(cycleOscillator.f1831h, d4);
        } else {
            double[] dArr = cycleOscillator.f1832i;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d5 = f2;
        double d6 = cycleOscillator.f1831h[1];
        Oscillator oscillator = cycleOscillator.f1824a;
        double dC = oscillator.c(d5, d6);
        double d7 = cycleOscillator.f1831h[1];
        double d8 = cycleOscillator.f1832i[1];
        double dB = oscillator.b(d5) + d7;
        if (d5 <= 0.0d) {
            c2 = 2;
            c3 = 0;
            d2 = 0.0d;
        } else if (d5 >= 1.0d) {
            c2 = 2;
            c3 = 0;
            d2 = 1.0d;
        } else {
            int iBinarySearch = Arrays.binarySearch(oscillator.f1848b, d5);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 1;
            }
            float[] fArr = oscillator.f1847a;
            float f3 = fArr[iBinarySearch];
            int i2 = iBinarySearch - 1;
            float f4 = fArr[i2];
            c2 = 2;
            float f5 = f3 - f4;
            c3 = 0;
            double d9 = f5;
            double[] dArr2 = oscillator.f1848b;
            double d10 = dArr2[iBinarySearch];
            double d11 = dArr2[i2];
            double d12 = d9 / (d10 - d11);
            d2 = (f4 - (d12 * d11)) + (d5 * d12);
        }
        double dSin = d2 + d8;
        double d13 = 2.0d;
        switch (oscillator.f1851e) {
            case 1:
                dE = 0.0d;
                break;
            case 2:
                d3 = dSin * 4.0d;
                dSignum = Math.signum((((dB * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                dE = dSignum * d3;
                break;
            case 3:
                dE = dSin * d13;
                break;
            case 4:
                dSin = -dSin;
                dE = dSin * d13;
                break;
            case 5:
                d13 = (-6.283185307179586d) * dSin;
                dSin = Math.sin(6.283185307179586d * dB);
                dE = dSin * d13;
                break;
            case 6:
                dE = ((((dB * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dSin * 4.0d;
                break;
            case 7:
                dE = oscillator.f1850d.e(dB % 1.0d);
                break;
            default:
                d3 = dSin * 6.283185307179586d;
                dSignum = Math.cos(6.283185307179586d * dB);
                dE = dSignum * d3;
                break;
        }
        double[] dArr3 = cycleOscillator.f1832i;
        return (float) ((dE * cycleOscillator.f1831h[c2]) + (dC * dArr3[c2]) + dArr3[c3]);
    }

    public final void d(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5) {
        this.f1823f.add(new WavePoint(f2, f3, f4, f5, i2));
        if (i4 != -1) {
            this.f1822e = i4;
        }
        this.f1820c = i3;
        this.f1821d = str;
    }

    public final void e(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5, ConstraintAttribute constraintAttribute) {
        this.f1823f.add(new WavePoint(f2, f3, f4, f5, i2));
        if (i4 != -1) {
            this.f1822e = i4;
        }
        this.f1820c = i3;
        c(constraintAttribute);
        this.f1821d = str;
    }

    public final void f() {
        int i2;
        int i3;
        int i4;
        int i5;
        double d2;
        int i6;
        ArrayList arrayList = this.f1823f;
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Collections.sort(arrayList, new AnonymousClass1());
        double[] dArr = new double[size];
        Class cls = Double.TYPE;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, size, 3);
        int i7 = this.f1820c;
        String str = this.f1821d;
        CycleOscillator cycleOscillator = new CycleOscillator();
        Oscillator oscillator = new Oscillator();
        cycleOscillator.f1824a = oscillator;
        oscillator.f1851e = i7;
        if (str != null) {
            double[] dArr3 = new double[str.length() / 2];
            i4 = 3;
            int iIndexOf = str.indexOf(40) + 1;
            i5 = 0;
            i3 = 1;
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            int i8 = 0;
            d2 = 1.0d;
            while (iIndexOf2 != -1) {
                dArr3[i8] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
                iIndexOf = iIndexOf2 + 1;
                iIndexOf2 = str.indexOf(44, iIndexOf);
                i8++;
            }
            dArr3[i8] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
            double[] dArrCopyOf = Arrays.copyOf(dArr3, i8 + 1);
            int length = (dArrCopyOf.length * 3) - 2;
            int length2 = dArrCopyOf.length - 1;
            double d3 = 1.0d / length2;
            double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, 1);
            double[] dArr5 = new double[length];
            i2 = 2;
            int i9 = 0;
            while (i9 < dArrCopyOf.length) {
                double d4 = dArrCopyOf[i9];
                int i10 = i9 + length2;
                dArr4[i10][0] = d4;
                double d5 = d3;
                double d6 = i9 * d5;
                dArr5[i10] = d6;
                if (i9 > 0) {
                    int i11 = (length2 * 2) + i9;
                    dArr4[i11][0] = d4 + 1.0d;
                    dArr5[i11] = d6 + 1.0d;
                    int i12 = i9 - 1;
                    dArr4[i12][0] = (d4 - 1.0d) - d5;
                    dArr5[i12] = (d6 - 1.0d) - d5;
                }
                i9++;
                d3 = d5;
            }
            oscillator.f1850d = new MonotonicCurveFit(dArr5, dArr4);
        } else {
            i2 = 2;
            i3 = 1;
            i4 = 3;
            i5 = 0;
            d2 = 1.0d;
        }
        cycleOscillator.f1825b = new float[size];
        cycleOscillator.f1826c = new double[size];
        cycleOscillator.f1827d = new float[size];
        cycleOscillator.f1828e = new float[size];
        cycleOscillator.f1829f = new float[size];
        float[] fArr = new float[size];
        this.f1818a = cycleOscillator;
        Iterator it = arrayList.iterator();
        int i13 = i5;
        while (it.hasNext()) {
            WavePoint wavePoint = (WavePoint) it.next();
            float f2 = wavePoint.f1836d;
            dArr[i13] = f2 * 0.01d;
            double[] dArr6 = dArr2[i13];
            float f3 = wavePoint.f1834b;
            dArr6[i5] = f3;
            float f4 = wavePoint.f1835c;
            dArr6[i3] = f4;
            float f5 = wavePoint.f1837e;
            dArr6[i2] = f5;
            CycleOscillator cycleOscillator2 = this.f1818a;
            cycleOscillator2.f1826c[i13] = wavePoint.f1833a / 100.0d;
            cycleOscillator2.f1827d[i13] = f2;
            cycleOscillator2.f1828e[i13] = f4;
            cycleOscillator2.f1829f[i13] = f5;
            cycleOscillator2.f1825b[i13] = f3;
            i13++;
        }
        CycleOscillator cycleOscillator3 = this.f1818a;
        double[] dArr7 = cycleOscillator3.f1826c;
        int length3 = dArr7.length;
        int i14 = i2;
        int[] iArr = new int[i14];
        iArr[i3] = i4;
        iArr[i5] = length3;
        double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        float[] fArr2 = cycleOscillator3.f1825b;
        cycleOscillator3.f1831h = new double[fArr2.length + i14];
        cycleOscillator3.f1832i = new double[fArr2.length + i14];
        double d7 = dArr7[i5];
        double d8 = 0.0d;
        float[] fArr3 = cycleOscillator3.f1827d;
        Oscillator oscillator2 = cycleOscillator3.f1824a;
        if (d7 > 0.0d) {
            oscillator2.a(0.0d, fArr3[i5]);
        }
        int length4 = dArr7.length - 1;
        if (dArr7[length4] < d2) {
            oscillator2.a(d2, fArr3[length4]);
        }
        for (int i15 = i5; i15 < dArr8.length; i15++) {
            double[] dArr9 = dArr8[i15];
            dArr9[i5] = cycleOscillator3.f1828e[i15];
            dArr9[i3] = cycleOscillator3.f1829f[i15];
            dArr9[2] = fArr2[i15];
            oscillator2.a(dArr7[i15], fArr3[i15]);
        }
        double d9 = 0.0d;
        int i16 = i5;
        while (true) {
            if (i16 >= oscillator2.f1847a.length) {
                break;
            }
            d9 += r12[i16];
            i16++;
        }
        double d10 = 0.0d;
        int i17 = i3;
        while (true) {
            float[] fArr4 = oscillator2.f1847a;
            if (i17 >= fArr4.length) {
                break;
            }
            int i18 = i17 - 1;
            float f6 = (fArr4[i18] + fArr4[i17]) / 2.0f;
            double d11 = d8;
            double[] dArr10 = oscillator2.f1848b;
            d10 = ((dArr10[i17] - dArr10[i18]) * f6) + d10;
            i17++;
            d8 = d11;
        }
        double d12 = d8;
        int i19 = i5;
        while (true) {
            float[] fArr5 = oscillator2.f1847a;
            if (i19 >= fArr5.length) {
                break;
            }
            fArr5[i19] = fArr5[i19] * ((float) (d9 / d10));
            i19++;
        }
        oscillator2.f1849c[i5] = d12;
        int i20 = i3;
        while (true) {
            float[] fArr6 = oscillator2.f1847a;
            if (i20 >= fArr6.length) {
                break;
            }
            int i21 = i20 - 1;
            float f7 = (fArr6[i21] + fArr6[i20]) / 2.0f;
            double[] dArr11 = oscillator2.f1848b;
            double d13 = dArr11[i20] - dArr11[i21];
            double[] dArr12 = oscillator2.f1849c;
            double d14 = dArr12[i21];
            int i22 = i20;
            dArr12[i22] = (d13 * f7) + d14;
            i20 = i22 + 1;
        }
        if (dArr7.length > i3) {
            i6 = i5;
            cycleOscillator3.f1830g = CurveFit.a(i6, dArr7, dArr8);
        } else {
            i6 = i5;
            cycleOscillator3.f1830g = null;
        }
        CurveFit.a(i6, dArr, dArr2);
    }

    public final String toString() {
        String string = this.f1819b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator it = this.f1823f.iterator();
        while (it.hasNext()) {
            WavePoint wavePoint = (WavePoint) it.next();
            StringBuilder sbX = b.x(string, "[");
            sbX.append(wavePoint.f1833a);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(wavePoint.f1834b));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }

    public void c(ConstraintAttribute constraintAttribute) {
    }
}
