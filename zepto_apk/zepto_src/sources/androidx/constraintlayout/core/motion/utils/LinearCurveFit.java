package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class LinearCurveFit extends CurveFit {

    /* renamed from: a, reason: collision with root package name */
    public double[] f1838a;

    /* renamed from: b, reason: collision with root package name */
    public double[][] f1839b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1840c;

    /* renamed from: d, reason: collision with root package name */
    public double[] f1841d;

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double b(double d2) {
        double[] dArr = this.f1838a;
        int length = dArr.length;
        boolean z = this.f1840c;
        double[][] dArr2 = this.f1839b;
        if (z) {
            double d3 = dArr[0];
            if (d2 <= d3) {
                return (e(d3) * (d2 - d3)) + dArr2[0][0];
            }
            int i2 = length - 1;
            double d4 = dArr[i2];
            if (d2 >= d4) {
                return (e(d4) * (d2 - d4)) + dArr2[i2][0];
            }
        } else {
            if (d2 <= dArr[0]) {
                return dArr2[0][0];
            }
            int i3 = length - 1;
            if (d2 >= dArr[i3]) {
                return dArr2[i3][0];
            }
        }
        int i4 = 0;
        while (i4 < length - 1) {
            double d5 = dArr[i4];
            if (d2 == d5) {
                return dArr2[i4][0];
            }
            int i5 = i4 + 1;
            double d6 = dArr[i5];
            if (d2 < d6) {
                double d7 = (d2 - d5) / (d6 - d5);
                return (dArr2[i5][0] * d7) + ((1.0d - d7) * dArr2[i4][0]);
            }
            i4 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void c(double d2, float[] fArr) {
        double[] dArr = this.f1838a;
        int length = dArr.length;
        double[][] dArr2 = this.f1839b;
        int i2 = 0;
        int length2 = dArr2[0].length;
        if (this.f1840c) {
            double d3 = dArr[0];
            double[] dArr3 = this.f1841d;
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
                double d7 = (d2 - d6) / (d5 - d6);
                while (i2 < length2) {
                    fArr[i2] = (float) ((dArr2[i9][i2] * d7) + ((1.0d - d7) * dArr2[i7][i2]));
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void d(double[] dArr, double d2) {
        double[] dArr2 = this.f1838a;
        int length = dArr2.length;
        double[][] dArr3 = this.f1839b;
        int i2 = 0;
        int length2 = dArr3[0].length;
        if (this.f1840c) {
            double d3 = dArr2[0];
            double[] dArr4 = this.f1841d;
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
                double d7 = (d2 - d6) / (d5 - d6);
                while (i2 < length2) {
                    dArr[i2] = (dArr3[i9][i2] * d7) + ((1.0d - d7) * dArr3[i7][i2]);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v6 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double e(double r9) {
        /*
            r8 = this;
            double[] r0 = r8.f1838a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r9 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 < 0) goto L15
            goto La
        L15:
            r3 = r2
        L16:
            int r4 = r1 + (-1)
            if (r3 >= r4) goto L34
            int r4 = r3 + 1
            r5 = r0[r4]
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 > 0) goto L32
            r9 = r0[r3]
            double r5 = r5 - r9
            double[][] r9 = r8.f1839b
            r10 = r9[r3]
            r0 = r10[r2]
            r9 = r9[r4]
            r2 = r9[r2]
            double r2 = r2 - r0
            double r2 = r2 / r5
            return r2
        L32:
            r3 = r4
            goto L16
        L34:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.e(double):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r5
      0x000f: PHI (r5v6 double) = (r5v0 double), (r5v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(double[] r12, double r13) {
        /*
            r11 = this;
            double[] r0 = r11.f1838a
            int r1 = r0.length
            double[][] r2 = r11.f1839b
            r3 = 0
            r4 = r2[r3]
            int r4 = r4.length
            r5 = r0[r3]
            int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r7 > 0) goto L11
        Lf:
            r13 = r5
            goto L1a
        L11:
            int r5 = r1 + (-1)
            r5 = r0[r5]
            int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r7 < 0) goto L1a
            goto Lf
        L1a:
            r5 = r3
        L1b:
            int r6 = r1 + (-1)
            if (r5 >= r6) goto L3d
            int r6 = r5 + 1
            r7 = r0[r6]
            int r9 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r9 > 0) goto L3b
            r13 = r0[r5]
            double r7 = r7 - r13
        L2a:
            if (r3 >= r4) goto L3d
            r13 = r2[r5]
            r0 = r13[r3]
            r13 = r2[r6]
            r9 = r13[r3]
            double r9 = r9 - r0
            double r9 = r9 / r7
            r12[r3] = r9
            int r3 = r3 + 1
            goto L2a
        L3b:
            r5 = r6
            goto L1b
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.f(double[], double):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] g() {
        return this.f1838a;
    }
}
