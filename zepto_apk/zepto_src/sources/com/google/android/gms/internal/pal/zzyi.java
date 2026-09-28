package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzyi {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f38147a = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f38148b = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f38149c = {67108863, 33554431};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f38150d = {26, 25};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        b(jArr4, jArr2, jArr3);
        d(jArr4);
        c(jArr4);
        System.arraycopy(jArr4, 0, jArr, 0, 10);
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j2 = jArr2[0];
        long j3 = jArr3[1] * j2;
        long j4 = jArr2[1];
        long j5 = jArr3[0];
        jArr[1] = (j4 * j5) + j3;
        long j6 = jArr2[1];
        long j7 = jArr3[1];
        jArr[2] = (jArr2[2] * j5) + (jArr3[2] * j2) + ((j6 + j6) * j7);
        long j8 = jArr3[2];
        long j9 = jArr2[2];
        jArr[3] = (jArr2[3] * j5) + (jArr3[3] * j2) + (j9 * j7) + (j6 * j8);
        long j10 = jArr3[3];
        long j11 = jArr2[3];
        long j12 = (j11 * j7) + (j6 * j10);
        jArr[4] = (jArr2[4] * j5) + (jArr3[4] * j2) + j12 + j12 + (j9 * j8);
        long j13 = jArr3[4];
        long j14 = (j6 * j13) + (j11 * j8) + (j9 * j10);
        long j15 = jArr2[4];
        jArr[5] = (jArr2[5] * j5) + (jArr3[5] * j2) + (j15 * j7) + j14;
        long j16 = jArr3[5];
        long j17 = jArr2[5];
        long j18 = (j17 * j7) + (j6 * j16) + (j11 * j10);
        jArr[6] = (jArr2[6] * j5) + (jArr3[6] * j2) + (j15 * j8) + (j9 * j13) + j18 + j18;
        long j19 = (j17 * j8) + (j9 * j16) + (j15 * j10) + (j11 * j13);
        long j20 = jArr3[6];
        long j21 = (j6 * j20) + j19;
        long j22 = jArr2[6];
        jArr[7] = (jArr2[7] * j5) + (jArr3[7] * j2) + (j22 * j7) + j21;
        long j23 = jArr3[7];
        long j24 = (j6 * j23) + (j17 * j10) + (j11 * j16);
        long j25 = jArr2[7];
        long j26 = (j25 * j7) + j24;
        jArr[8] = (jArr2[8] * j5) + (jArr3[8] * j2) + (j22 * j8) + (j9 * j20) + j26 + j26 + (j15 * j13);
        long j27 = (j25 * j8) + (j9 * j23) + (j22 * j10) + (j11 * j20) + (j17 * j13) + (j15 * j16);
        long j28 = jArr3[8];
        long j29 = (j6 * j28) + j27;
        long j30 = jArr2[8];
        jArr[9] = (jArr2[9] * j5) + (j2 * jArr3[9]) + (j30 * j7) + j29;
        long j31 = (j25 * j10) + (j11 * j23) + (j17 * j16);
        long j32 = jArr3[9];
        long j33 = jArr2[9];
        long j34 = (j7 * j33) + (j6 * j32) + j31;
        long j35 = j22 * j13;
        jArr[10] = (j30 * j8) + (j9 * j28) + j35 + (j15 * j20) + j34 + j34;
        long j36 = j9 * j32;
        long j37 = j8 * j33;
        jArr[11] = j37 + j36 + (j30 * j10) + (j11 * j28) + (j25 * j13) + (j15 * j23) + (j22 * j16) + (j17 * j20);
        long j38 = j11 * j32;
        long j39 = j10 * j33;
        long j40 = j39 + j38 + (j25 * j16) + (j17 * j23);
        long j41 = j30 * j13;
        jArr[12] = j41 + (j15 * j28) + j40 + j40 + (j22 * j20);
        long j42 = j15 * j32;
        long j43 = j13 * j33;
        jArr[13] = j43 + j42 + (j30 * j16) + (j17 * j28) + (j25 * j20) + (j22 * j23);
        long j44 = j16 * j33;
        long j45 = j44 + (j17 * j32) + (j25 * j23);
        long j46 = j30 * j20;
        jArr[14] = j46 + (j22 * j28) + j45 + j45;
        long j47 = j22 * j32;
        long j48 = j20 * j33;
        jArr[15] = j48 + j47 + (j30 * j23) + (j25 * j28);
        long j49 = (j23 * j33) + (j25 * j32);
        jArr[16] = j49 + j49 + (j30 * j28);
        jArr[17] = (j28 * j33) + (j30 * j32);
        jArr[18] = (j33 + j33) * j32;
    }

    public static void c(long[] jArr) {
        jArr[10] = 0;
        int i2 = 0;
        while (i2 < 10) {
            long j2 = jArr[i2];
            long j3 = j2 / 67108864;
            jArr[i2] = j2 - (j3 << 26);
            int i3 = i2 + 1;
            long j4 = jArr[i3] + j3;
            jArr[i3] = j4;
            long j5 = j4 / 33554432;
            jArr[i3] = j4 - (j5 << 25);
            i2 += 2;
            jArr[i2] = jArr[i2] + j5;
        }
        long j6 = jArr[0];
        long j7 = jArr[10];
        long j8 = j6 + (j7 << 4);
        jArr[0] = j8;
        long j9 = j7 + j7 + j8;
        jArr[0] = j9;
        long j10 = j9 + j7;
        jArr[0] = j10;
        jArr[10] = 0;
        long j11 = j10 / 67108864;
        jArr[0] = j10 - (j11 << 26);
        jArr[1] = jArr[1] + j11;
    }

    public static void d(long[] jArr) {
        long j2 = jArr[8];
        long j3 = jArr[18];
        long j4 = j2 + (j3 << 4);
        jArr[8] = j4;
        long j5 = j3 + j3 + j4;
        jArr[8] = j5;
        jArr[8] = j5 + j3;
        long j6 = jArr[7];
        long j7 = jArr[17];
        long j8 = j6 + (j7 << 4);
        jArr[7] = j8;
        long j9 = j7 + j7 + j8;
        jArr[7] = j9;
        jArr[7] = j9 + j7;
        long j10 = jArr[6];
        long j11 = jArr[16];
        long j12 = j10 + (j11 << 4);
        jArr[6] = j12;
        long j13 = j11 + j11 + j12;
        jArr[6] = j13;
        jArr[6] = j13 + j11;
        long j14 = jArr[5];
        long j15 = jArr[15];
        long j16 = j14 + (j15 << 4);
        jArr[5] = j16;
        long j17 = j15 + j15 + j16;
        jArr[5] = j17;
        jArr[5] = j17 + j15;
        long j18 = jArr[4];
        long j19 = jArr[14];
        long j20 = j18 + (j19 << 4);
        jArr[4] = j20;
        long j21 = j19 + j19 + j20;
        jArr[4] = j21;
        jArr[4] = j21 + j19;
        long j22 = jArr[3];
        long j23 = jArr[13];
        long j24 = j22 + (j23 << 4);
        jArr[3] = j24;
        long j25 = j23 + j23 + j24;
        jArr[3] = j25;
        jArr[3] = j25 + j23;
        long j26 = jArr[2];
        long j27 = jArr[12];
        long j28 = j26 + (j27 << 4);
        jArr[2] = j28;
        long j29 = j27 + j27 + j28;
        jArr[2] = j29;
        jArr[2] = j29 + j27;
        long j30 = jArr[1];
        long j31 = jArr[11];
        long j32 = j30 + (j31 << 4);
        jArr[1] = j32;
        long j33 = j31 + j31 + j32;
        jArr[1] = j33;
        jArr[1] = j33 + j31;
        long j34 = jArr[0];
        long j35 = jArr[10];
        long j36 = j34 + (j35 << 4);
        jArr[0] = j36;
        long j37 = j35 + j35 + j36;
        jArr[0] = j37;
        jArr[0] = j37 + j35;
    }

    public static void e(long[] jArr, long[] jArr2) {
        long j2 = jArr2[0];
        long j3 = j2 * j2;
        long j4 = j2 + j2;
        long j5 = jArr2[1];
        long j6 = j4 * j5;
        long j7 = jArr2[2];
        long j8 = (j2 * j7) + (j5 * j5);
        long j9 = jArr2[3];
        long j10 = (j2 * j9) + (j5 * j7);
        long j11 = jArr2[4];
        long j12 = (j4 * j11) + (j5 * 4 * j9) + (j7 * j7);
        long j13 = jArr2[5];
        long j14 = (j2 * j13) + (j5 * j11) + (j7 * j9);
        long j15 = jArr2[6];
        long j16 = ((j5 + j5) * j13) + (j2 * j15) + (j7 * j11) + (j9 * j9);
        long j17 = jArr2[7];
        long j18 = (j2 * j17) + (j5 * j15) + (j7 * j13) + (j9 * j11);
        long j19 = jArr2[8];
        long j20 = (j9 * j13) + (j5 * j17);
        long j21 = j20 + j20 + (j2 * j19) + (j7 * j15);
        long j22 = j21 + j21 + (j11 * j11);
        long j23 = jArr2[9];
        long j24 = (j2 * j23) + (j5 * j19) + (j7 * j17) + (j9 * j15) + (j11 * j13);
        long j25 = (j5 * j23) + (j9 * j17);
        long j26 = j25 + j25 + (j7 * j19) + (j11 * j15) + (j13 * j13);
        long j27 = (j7 * j23) + (j9 * j19) + (j11 * j17) + (j13 * j15);
        long j28 = (j9 * j23) + (j13 * j17);
        long j29 = j28 + j28 + (j11 * j19);
        long j30 = j29 + j29 + (j15 * j15);
        long j31 = (j11 * j23) + (j13 * j19) + (j15 * j17);
        long j32 = ((j13 + j13) * j23) + (j15 * j19) + (j17 * j17);
        long j33 = (j15 * j23) + (j17 * j19);
        long[] jArr3 = {j3, j6, j8 + j8, j10 + j10, j12, j14 + j14, j16 + j16, j18 + j18, j22, j24 + j24, j26 + j26, j27 + j27, j30, j31 + j31, j32 + j32, j33 + j33, (j17 * 4 * j23) + (j19 * j19), (j19 + j19) * j23, (j23 + j23) * j23};
        d(jArr3);
        c(jArr3);
        System.arraycopy(jArr3, 0, jArr, 0, 10);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] - jArr3[i2];
        }
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] + jArr3[i2];
        }
    }

    public static byte[] h(long[] jArr) {
        int[] iArr;
        int i2;
        int[] iArr2;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            iArr = f38150d;
            if (i4 >= 2) {
                break;
            }
            int i5 = 0;
            while (i5 < 9) {
                long j2 = jArrCopyOf[i5];
                int i6 = -((int) (((j2 >> 31) & j2) >> iArr[i5 & 1]));
                jArrCopyOf[i5] = j2 + (i6 << r11);
                i5++;
                jArrCopyOf[i5] = jArrCopyOf[i5] - i6;
            }
            long j3 = jArrCopyOf[9];
            int i7 = -((int) (((j3 >> 31) & j3) >> 25));
            jArrCopyOf[9] = j3 + (i7 << 25);
            jArrCopyOf[0] = jArrCopyOf[0] - (i7 * 19);
            i4++;
        }
        long j4 = jArrCopyOf[0];
        jArrCopyOf[0] = j4 + (r3 << 26);
        jArrCopyOf[1] = jArrCopyOf[1] - (-((int) (((j4 >> 31) & j4) >> 26)));
        int i8 = 0;
        while (true) {
            iArr2 = f38149c;
            if (i8 >= 2) {
                break;
            }
            int i9 = i3;
            while (i9 < 9) {
                long j5 = jArrCopyOf[i9];
                int i10 = iArr[i9 & 1];
                jArrCopyOf[i9] = iArr2[r14] & j5;
                i9++;
                jArrCopyOf[i9] = jArrCopyOf[i9] + ((int) (j5 >> i10));
                i3 = i3;
                i8 = i8;
            }
            i8++;
        }
        int i11 = i3;
        jArrCopyOf[9] = 33554431 & jArrCopyOf[9];
        jArrCopyOf[i11] = jArrCopyOf[i11] + (((int) (r2 >> 25)) * 19);
        int i12 = ~((((int) r11) - 67108845) >> 31);
        for (int i13 = 1; i13 < 10; i13++) {
            int i14 = ~(((int) jArrCopyOf[i13]) ^ iArr2[i13 & 1]);
            int i15 = i14 & (i14 << 16);
            int i16 = i15 & (i15 << 8);
            int i17 = i16 & (i16 << 4);
            int i18 = i17 & (i17 << 2);
            i12 &= (i18 & (i18 + i18)) >> 31;
        }
        jArrCopyOf[i11] = jArrCopyOf[i11] - (67108845 & i12);
        long j6 = 33554431 & i12;
        jArrCopyOf[1] = jArrCopyOf[1] - j6;
        for (i2 = 2; i2 < 10; i2 += 2) {
            jArrCopyOf[i2] = jArrCopyOf[i2] - (67108863 & i12);
            int i19 = i2 + 1;
            jArrCopyOf[i19] = jArrCopyOf[i19] - j6;
        }
        for (int i20 = i11; i20 < 10; i20++) {
            jArrCopyOf[i20] = jArrCopyOf[i20] << f38148b[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = i11; i21 < 10; i21++) {
            int i22 = f38147a[i21];
            byte b2 = bArr[i22];
            long j7 = jArrCopyOf[i21];
            bArr[i22] = (byte) (b2 | (j7 & 255));
            bArr[i22 + 1] = (byte) (bArr[r5] | ((j7 >> 8) & 255));
            bArr[i22 + 2] = (byte) (bArr[r5] | ((j7 >> 16) & 255));
            bArr[i22 + 3] = (byte) (((j7 >> 24) & 255) | bArr[r4]);
        }
        return bArr;
    }
}
