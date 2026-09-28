package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MatrixMathHelper {

    @Metadata
    public static class MatrixDecompositionContext {

        /* renamed from: a, reason: collision with root package name */
        public final double[] f19398a = new double[4];

        /* renamed from: b, reason: collision with root package name */
        public final double[] f19399b = new double[3];

        /* renamed from: c, reason: collision with root package name */
        public final double[] f19400c = new double[3];

        /* renamed from: d, reason: collision with root package name */
        public final double[] f19401d = new double[3];

        /* renamed from: e, reason: collision with root package name */
        public final double[] f19402e = new double[3];

        @Metadata
        public static final class Companion {
            public static final void a(double[] dArr) {
                int length = dArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    dArr[i2] = 0.0d;
                }
            }
        }

        public final void a() {
            Companion.a(this.f19398a);
            Companion.a(this.f19399b);
            Companion.a(this.f19400c);
            Companion.a(this.f19401d);
            Companion.a(this.f19402e);
        }
    }

    public static final void a(double[] m2, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(m2, "m");
        m2[12] = d2;
        m2[13] = d3;
        m2[14] = d4;
    }

    public static final void b(double[] transformMatrix, MatrixDecompositionContext ctx) {
        Intrinsics.checkNotNullParameter(transformMatrix, "transformMatrix");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Assertions.a(transformMatrix.length == 16);
        double[] result = ctx.f19398a;
        if (d(transformMatrix[15])) {
            return;
        }
        double[][] dArr = new double[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            dArr[i2] = new double[4];
        }
        double[] m2 = new double[16];
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = (i3 * 4) + i4;
                double d2 = transformMatrix[i5] / transformMatrix[15];
                dArr[i3][i4] = d2;
                if (i4 == 3) {
                    d2 = 0.0d;
                }
                m2[i5] = d2;
            }
        }
        m2[15] = 1.0d;
        if (d(c(m2))) {
            return;
        }
        if (d(dArr[0][3]) && d(dArr[1][3]) && d(dArr[2][3])) {
            result[2] = 0.0d;
            result[1] = 0.0d;
            result[0] = 0.0d;
            result[3] = 1.0d;
        } else {
            double[] v = {dArr[0][3], dArr[1][3], dArr[2][3], dArr[3][3]};
            Intrinsics.checkNotNullParameter(m2, "matrix");
            double dC = c(m2);
            if (!d(dC)) {
                double d3 = m2[0];
                double d4 = m2[1];
                double d5 = m2[2];
                double d6 = m2[3];
                double d7 = m2[4];
                double d8 = m2[5];
                double d9 = m2[6];
                double d10 = m2[7];
                double d11 = m2[8];
                double d12 = m2[9];
                double d13 = m2[10];
                double d14 = m2[11];
                double d15 = m2[12];
                double d16 = m2[13];
                double d17 = m2[14];
                double d18 = m2[15];
                double d19 = d9 * d14;
                double d20 = d10 * d13;
                double d21 = d10 * d12;
                double d22 = d8 * d14;
                double d23 = d9 * d12;
                double d24 = d8 * d13;
                double d25 = ((d24 * d18) + ((((d21 * d17) + ((d19 * d16) - (d20 * d16))) - (d22 * d17)) - (d23 * d18))) / dC;
                double d26 = d6 * d13;
                double d27 = d5 * d14;
                double d28 = d6 * d12;
                double d29 = d4 * d14;
                double d30 = d5 * d12;
                double d31 = (d30 * d18) + (d29 * d17) + (((d26 * d16) - (d27 * d16)) - (d28 * d17));
                double d32 = d4 * d13;
                double d33 = d5 * d10;
                double d34 = d6 * d9;
                double d35 = d6 * d8;
                double d36 = d4 * d10;
                double d37 = d5 * d8;
                double d38 = d4 * d9;
                double d39 = ((d38 * d18) + ((((d35 * d17) + ((d33 * d16) - (d34 * d16))) - (d36 * d17)) - (d37 * d18))) / dC;
                double d40 = (((d37 * d14) + ((d36 * d13) + (((d34 * d12) - (d33 * d12)) - (d35 * d13)))) - (d38 * d14)) / dC;
                double d41 = (d20 * d15) - (d19 * d15);
                double d42 = d10 * d11;
                double d43 = d7 * d14;
                double d44 = (d43 * d17) + (d41 - (d42 * d17));
                double d45 = d9 * d11;
                double d46 = (d45 * d18) + d44;
                double d47 = d7 * d13;
                double d48 = (d27 * d15) - (d26 * d15);
                double d49 = d6 * d11;
                double d50 = (d49 * d17) + d48;
                double d51 = d3 * d14;
                double d52 = d5 * d11;
                double d53 = d3 * d13;
                double d54 = ((d53 * d18) + ((d50 - (d51 * d17)) - (d52 * d18))) / dC;
                double d55 = d6 * d7;
                double d56 = d10 * d3;
                double d57 = d5 * d7;
                double d58 = d9 * d3;
                double d59 = (((d57 * d18) + ((d56 * d17) + (((d34 * d15) - (d33 * d15)) - (d55 * d17)))) - (d58 * d18)) / dC;
                double d60 = ((d58 * d14) + ((((d55 * d13) + ((d33 * d11) - (d34 * d11))) - (d56 * d13)) - (d57 * d14))) / dC;
                double d61 = ((d42 * d16) + ((d22 * d15) - (d21 * d15))) - (d43 * d16);
                double d62 = d8 * d11;
                double d63 = d7 * d12;
                double d64 = ((d63 * d18) + (d61 - (d62 * d18))) / dC;
                double d65 = d4 * d11;
                double d66 = (d65 * d18) + (d51 * d16) + (((d28 * d15) - (d29 * d15)) - (d49 * d16));
                double d67 = d3 * d12;
                double d68 = d4 * d7;
                double d69 = d3 * d8;
                m2 = new double[]{d25, (d31 - (d32 * d18)) / dC, d39, d40, (d46 - (d47 * d18)) / dC, d54, d59, d60, d64, (d66 - (d67 * d18)) / dC, ((d18 * d69) + ((((d55 * d16) + ((d36 * d15) - (d35 * d15))) - (d56 * d16)) - (d68 * d18))) / dC, (((d68 * d14) + ((d56 * d12) + (((d35 * d11) - (d36 * d11)) - (d55 * d12)))) - (d14 * d69)) / dC, (((d62 * d17) + ((d47 * d16) + (((d23 * d15) - (d24 * d15)) - (d45 * d16)))) - (d63 * d17)) / dC, ((d67 * d17) + ((((d52 * d16) + ((d32 * d15) - (d30 * d15))) - (d53 * d16)) - (d65 * d17))) / dC, (((d68 * d17) + ((d16 * d58) + (((d37 * d15) - (d15 * d38)) - (d57 * d16)))) - (d17 * d69)) / dC, ((d69 * d13) + ((((d57 * d12) + ((d38 * d11) - (d37 * d11))) - (d58 * d12)) - (d68 * d13))) / dC};
            }
            Intrinsics.checkNotNullParameter(m2, "m");
            double[] m3 = {m2[0], m2[4], m2[8], m2[12], m2[1], m2[5], m2[9], m2[13], m2[2], m2[6], m2[10], m2[14], m2[3], m2[7], m2[11], m2[15]};
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(m3, "m");
            Intrinsics.checkNotNullParameter(result, "result");
            double d70 = v[0];
            double d71 = v[1];
            double d72 = v[2];
            double d73 = v[3];
            result[0] = (m3[12] * d73) + (m3[8] * d72) + (m3[4] * d71) + (m3[0] * d70);
            result[1] = (m3[13] * d73) + (m3[9] * d72) + (m3[5] * d71) + (m3[1] * d70);
            result[2] = (m3[14] * d73) + (m3[10] * d72) + (m3[6] * d71) + (m3[2] * d70);
            result[3] = (d73 * m3[15]) + (d72 * m3[11]) + (d71 * m3[7]) + (d70 * m3[3]);
        }
        for (int i6 = 0; i6 < 3; i6++) {
            ctx.f19401d[i6] = dArr[3][i6];
        }
        double[][] dArr2 = new double[3][];
        for (int i7 = 0; i7 < 3; i7++) {
            dArr2[i7] = new double[3];
        }
        for (int i8 = 0; i8 < 3; i8++) {
            double[] dArr3 = dArr2[i8];
            double[] dArr4 = dArr[i8];
            dArr3[0] = dArr4[0];
            dArr3[1] = dArr4[1];
            dArr3[2] = dArr4[2];
        }
        double dI = i(dArr2[0]);
        double[] dArr5 = ctx.f19399b;
        dArr5[0] = dI;
        double[] dArrJ = j(dArr2[0], dI);
        dArr2[0] = dArrJ;
        double dH = h(dArrJ, dArr2[1]);
        double[] dArr6 = ctx.f19400c;
        dArr6[0] = dH;
        double[] dArrG = g(dArr2[1], dArr2[0], -dH);
        dArr2[1] = dArrG;
        double dI2 = i(dArrG);
        dArr5[1] = dI2;
        dArr2[1] = j(dArr2[1], dI2);
        dArr6[0] = dArr6[0] / dArr5[1];
        double dH2 = h(dArr2[0], dArr2[2]);
        dArr6[1] = dH2;
        double[] dArrG2 = g(dArr2[2], dArr2[0], -dH2);
        dArr2[2] = dArrG2;
        double dH3 = h(dArr2[1], dArrG2);
        dArr6[2] = dH3;
        double[] dArrG3 = g(dArr2[2], dArr2[1], -dH3);
        dArr2[2] = dArrG3;
        double dI3 = i(dArrG3);
        dArr5[2] = dI3;
        double[] b2 = j(dArr2[2], dI3);
        dArr2[2] = b2;
        double d74 = dArr6[1];
        double d75 = dArr5[2];
        dArr6[1] = d74 / d75;
        dArr6[2] = dArr6[2] / d75;
        double[] a2 = dArr2[1];
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        double d76 = a2[1];
        double d77 = b2[2];
        double d78 = a2[2];
        double d79 = b2[1];
        double d80 = b2[0];
        double d81 = a2[0];
        if (h(dArr2[0], new double[]{(d76 * d77) - (d78 * d79), (d78 * d80) - (d77 * d81), (d81 * d79) - (d76 * d80)}) < 0.0d) {
            for (int i9 = 0; i9 < 3; i9++) {
                dArr5[i9] = dArr5[i9] * (-1.0d);
                double[] dArr7 = dArr2[i9];
                dArr7[0] = dArr7[0] * (-1.0d);
                dArr7[1] = dArr7[1] * (-1.0d);
                dArr7[2] = dArr7[2] * (-1.0d);
            }
        }
        double[] dArr8 = dArr2[2];
        double[] dArr9 = ctx.f19402e;
        dArr9[0] = Math.round((-Math.atan2(dArr8[1], dArr8[2])) * 57.29577951308232d * 1000.0d) * 0.001d;
        double[] dArr10 = dArr2[2];
        double d82 = -dArr10[0];
        double d83 = dArr10[1];
        double d84 = dArr10[2];
        dArr9[1] = Math.round((-Math.atan2(d82, Math.sqrt((d84 * d84) + (d83 * d83)))) * 57.29577951308232d * 1000.0d) * 0.001d;
        dArr9[2] = Math.round((-Math.atan2(dArr2[1][0], dArr2[0][0])) * 57.29577951308232d * 1000.0d) * 0.001d;
    }

    public static final double c(double[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        double d2 = matrix[0];
        double d3 = matrix[1];
        double d4 = matrix[2];
        double d5 = matrix[3];
        double d6 = matrix[4];
        double d7 = matrix[5];
        double d8 = matrix[6];
        double d9 = matrix[7];
        double d10 = matrix[8];
        double d11 = matrix[9];
        double d12 = matrix[10];
        double d13 = matrix[11];
        double d14 = matrix[12];
        double d15 = matrix[13];
        double d16 = matrix[14];
        double d17 = matrix[15];
        double d18 = d5 * d8;
        double d19 = d4 * d9;
        double d20 = d5 * d7;
        double d21 = d3 * d9;
        double dA = android.support.v4.media.b.a(d21, d12, d14, (((d18 * d11) * d14) - ((d19 * d11) * d14)) - ((d20 * d12) * d14));
        double d22 = d4 * d7;
        double d23 = d3 * d8;
        double dA2 = android.support.v4.media.b.a(d19, d10, d15, (android.support.v4.media.b.a(d22, d13, d14, dA) - ((d23 * d13) * d14)) - ((d18 * d10) * d15));
        double d24 = d5 * d6;
        double d25 = d9 * d2;
        double d26 = d4 * d6;
        double d27 = d8 * d2;
        double d28 = d3 * d6;
        double d29 = d2 * d7;
        return android.support.v4.media.b.a(d29, d12, d17, (android.support.v4.media.b.a(d26, d11, d17, android.support.v4.media.b.a(d23, d10, d17, (android.support.v4.media.b.a(d28, d13, d16, android.support.v4.media.b.a(d25, d11, d16, (android.support.v4.media.b.a(d20, d10, d16, android.support.v4.media.b.a(d27, d13, d15, (android.support.v4.media.b.a(d24, d12, d15, dA2) - ((d25 * d12) * d15)) - ((d26 * d13) * d15))) - ((d21 * d10) * d16)) - ((d24 * d11) * d16))) - ((d29 * d13) * d16)) - ((d22 * d10) * d17))) - ((d27 * d11) * d17)) - ((d28 * d12) * d17));
    }

    public static boolean d(double d2) {
        return !Double.isNaN(d2) && Math.abs(d2) < 1.0E-5d;
    }

    public static final void e(double[] out, double[] a2, double[] b2) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        double d2 = a2[0];
        double d3 = a2[1];
        double d4 = a2[2];
        double d5 = a2[3];
        double d6 = a2[4];
        double d7 = a2[5];
        double d8 = a2[6];
        double d9 = a2[7];
        double d10 = a2[8];
        double d11 = a2[9];
        double d12 = a2[10];
        double d13 = a2[11];
        double d14 = a2[12];
        double d15 = a2[13];
        double d16 = a2[14];
        double d17 = a2[15];
        double d18 = b2[0];
        double d19 = b2[1];
        double d20 = b2[2];
        double d21 = b2[3];
        out[0] = (d21 * d14) + (d20 * d10) + (d19 * d6) + (d18 * d2);
        out[1] = (d21 * d15) + (d20 * d11) + (d19 * d7) + (d18 * d3);
        out[2] = (d21 * d16) + (d20 * d12) + (d19 * d8) + (d18 * d4);
        double d22 = d20 * d13;
        double d23 = d21 * d17;
        out[3] = d23 + d22 + (d19 * d9) + (d18 * d5);
        double d24 = b2[4];
        double d25 = b2[5];
        double d26 = b2[6];
        double d27 = b2[7];
        out[4] = (d27 * d14) + (d26 * d10) + (d25 * d6) + (d24 * d2);
        out[5] = (d27 * d15) + (d26 * d11) + (d25 * d7) + (d24 * d3);
        out[6] = (d27 * d16) + (d26 * d12) + (d25 * d8) + (d24 * d4);
        double d28 = d26 * d13;
        double d29 = d27 * d17;
        out[7] = d29 + d28 + (d25 * d9) + (d24 * d5);
        double d30 = b2[8];
        double d31 = b2[9];
        double d32 = b2[10];
        double d33 = b2[11];
        out[8] = (d33 * d14) + (d32 * d10) + (d31 * d6) + (d30 * d2);
        out[9] = (d33 * d15) + (d32 * d11) + (d31 * d7) + (d30 * d3);
        out[10] = (d33 * d16) + (d32 * d12) + (d31 * d8) + (d30 * d4);
        double d34 = d32 * d13;
        double d35 = d33 * d17;
        out[11] = d35 + d34 + (d31 * d9) + (d30 * d5);
        double d36 = b2[12];
        double d37 = b2[13];
        double d38 = b2[14];
        double d39 = b2[15];
        double d40 = d10 * d38;
        double d41 = d14 * d39;
        out[12] = d41 + d40 + (d6 * d37) + (d2 * d36);
        double d42 = d11 * d38;
        double d43 = d15 * d39;
        out[13] = d43 + d42 + (d7 * d37) + (d3 * d36);
        double d44 = d12 * d38;
        double d45 = d16 * d39;
        out[14] = d45 + d44 + (d8 * d37) + (d4 * d36);
        double d46 = d38 * d13;
        double d47 = d39 * d17;
        out[15] = d47 + d46 + (d37 * d9) + (d36 * d5);
    }

    public static final void f(double[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix[14] = 0.0d;
        matrix[13] = 0.0d;
        matrix[12] = 0.0d;
        matrix[11] = 0.0d;
        matrix[9] = 0.0d;
        matrix[8] = 0.0d;
        matrix[7] = 0.0d;
        matrix[6] = 0.0d;
        matrix[4] = 0.0d;
        matrix[3] = 0.0d;
        matrix[2] = 0.0d;
        matrix[1] = 0.0d;
        matrix[15] = 1.0d;
        matrix[10] = 1.0d;
        matrix[5] = 1.0d;
        matrix[0] = 1.0d;
    }

    public static final double[] g(double[] a2, double[] b2, double d2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return new double[]{(b2[0] * d2) + (a2[0] * 1.0d), (b2[1] * d2) + (a2[1] * 1.0d), (d2 * b2[2]) + (1.0d * a2[2])};
    }

    public static final double h(double[] a2, double[] b2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return (a2[2] * b2[2]) + (a2[1] * b2[1]) + (a2[0] * b2[0]);
    }

    public static final double i(double[] a2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        double d2 = a2[0];
        double d3 = a2[1];
        double d4 = (d3 * d3) + (d2 * d2);
        double d5 = a2[2];
        return Math.sqrt((d5 * d5) + d4);
    }

    public static final double[] j(double[] vector, double d2) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        double d3 = 1;
        if (d(d2)) {
            d2 = i(vector);
        }
        double d4 = d3 / d2;
        return new double[]{vector[0] * d4, vector[1] * d4, vector[2] * d4};
    }
}
