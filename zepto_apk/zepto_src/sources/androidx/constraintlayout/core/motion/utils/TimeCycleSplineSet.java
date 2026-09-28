package androidx.constraintlayout.core.motion.utils;

import android.support.v4.media.b;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public abstract class TimeCycleSplineSet {

    /* renamed from: a, reason: collision with root package name */
    public CurveFit f1884a;

    /* renamed from: e, reason: collision with root package name */
    public int f1888e;

    /* renamed from: f, reason: collision with root package name */
    public String f1889f;

    /* renamed from: i, reason: collision with root package name */
    public long f1892i;

    /* renamed from: b, reason: collision with root package name */
    public int f1885b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f1886c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    public final float[][] f1887d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    public float[] f1890g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    public boolean f1891h = false;

    /* renamed from: j, reason: collision with root package name */
    public float f1893j = Float.NaN;

    public static class CustomSet extends TimeCycleSplineSet {
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
    }

    public static class Sort {
    }

    public final float a(float f2) {
        float fAbs;
        switch (this.f1885b) {
            case 1:
                return Math.signum(f2 * 6.2831855f);
            case 2:
                fAbs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f2 * 6.2831855f);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f2 * 6.2831855f);
        }
        return 1.0f - fAbs;
    }

    public void b(float f2, float f3, float f4, int i2, int i3) {
        int i4 = this.f1888e;
        this.f1886c[i4] = i2;
        float[] fArr = this.f1887d[i4];
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        this.f1885b = Math.max(this.f1885b, i3);
        this.f1888e++;
    }

    public void c(int i2) {
        float[][] fArr;
        int i3 = this.f1888e;
        if (i3 == 0) {
            System.err.println("Error no points added to " + this.f1889f);
            return;
        }
        int[] iArr = this.f1886c;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i3 - 1;
        iArr2[1] = 0;
        int i4 = 2;
        while (true) {
            fArr = this.f1887d;
            if (i4 <= 0) {
                break;
            }
            int i5 = i4 - 1;
            int i6 = iArr2[i5];
            int i7 = i4 - 2;
            int i8 = iArr2[i7];
            if (i6 < i8) {
                int i9 = iArr[i8];
                int i10 = i6;
                int i11 = i10;
                while (i10 < i8) {
                    int i12 = iArr[i10];
                    if (i12 <= i9) {
                        int i13 = iArr[i11];
                        iArr[i11] = i12;
                        iArr[i10] = i13;
                        float[] fArr2 = fArr[i11];
                        fArr[i11] = fArr[i10];
                        fArr[i10] = fArr2;
                        i11++;
                    }
                    i10++;
                }
                int i14 = iArr[i11];
                iArr[i11] = iArr[i8];
                iArr[i8] = i14;
                float[] fArr3 = fArr[i11];
                fArr[i11] = fArr[i8];
                fArr[i8] = fArr3;
                iArr2[i7] = i11 - 1;
                iArr2[i5] = i6;
                int i15 = i4 + 1;
                iArr2[i4] = i8;
                i4 += 2;
                iArr2[i15] = i11 + 1;
            } else {
                i4 = i7;
            }
        }
        int i16 = 0;
        for (int i17 = 1; i17 < iArr.length; i17++) {
            if (iArr[i17] != iArr[i17 - 1]) {
                i16++;
            }
        }
        if (i16 == 0) {
            i16 = 1;
        }
        double[] dArr = new double[i16];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, 3);
        int i18 = 0;
        for (int i19 = 0; i19 < this.f1888e; i19++) {
            if (i19 <= 0 || iArr[i19] != iArr[i19 - 1]) {
                dArr[i18] = iArr[i19] * 0.01d;
                double[] dArr3 = dArr2[i18];
                float[] fArr4 = fArr[i19];
                dArr3[0] = fArr4[0];
                dArr3[1] = fArr4[1];
                dArr3[2] = fArr4[2];
                i18++;
            }
        }
        this.f1884a = CurveFit.a(i2, dArr, dArr2);
    }

    public final String toString() {
        String string = this.f1889f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f1888e; i2++) {
            StringBuilder sbX = b.x(string, "[");
            sbX.append(this.f1886c[i2]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.f1887d[i2]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}
