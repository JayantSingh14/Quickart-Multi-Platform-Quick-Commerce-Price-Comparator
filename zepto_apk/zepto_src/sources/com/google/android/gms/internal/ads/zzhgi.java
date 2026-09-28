package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhgi {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        long jB = b(0, bArr) & 67108863;
        int i2 = 3;
        long jB2 = (b(3, bArr) >> 2) & 67108611;
        long jB3 = (b(6, bArr) >> 4) & 67092735;
        long jB4 = (b(9, bArr) >> 6) & 66076671;
        long jB5 = (b(12, bArr) >> 8) & 1048575;
        byte[] bArr3 = new byte[17];
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        int i3 = 0;
        while (true) {
            int length = bArr2.length;
            if (i3 >= length) {
                long j7 = j2 + (j3 >> 26);
                long j8 = j7 & 67108863;
                long j9 = j4 + (j7 >> 26);
                long j10 = j9 & 67108863;
                long j11 = j5 + (j9 >> 26);
                long j12 = j11 & 67108863;
                long j13 = ((j11 >> 26) * 5) + j6;
                long j14 = j13 >> 26;
                long j15 = j13 & 67108863;
                long j16 = j15 + 5;
                long j17 = (j3 & 67108863) + j14;
                long j18 = j17 + (j16 >> 26);
                long j19 = j8 + (j18 >> 26);
                long j20 = j10 + (j19 >> 26);
                long j21 = (j12 + (j20 >> 26)) - 67108864;
                long j22 = j21 >> 63;
                long j23 = ~j22;
                long j24 = (j17 & j22) | (j18 & 67108863 & j23);
                long j25 = (j8 & j22) | (j19 & 67108863 & j23);
                long j26 = (j10 & j22) | (j20 & 67108863 & j23);
                long j27 = (j12 & j22) | (j21 & j23);
                long jB6 = b(16, bArr) + (((j15 & j22) | (j16 & 67108863 & j23) | (j24 << 26)) & 4294967295L);
                long jB7 = b(20, bArr) + (((j24 >> 6) | (j25 << 20)) & 4294967295L);
                long jB8 = b(24, bArr);
                long jB9 = b(28, bArr) + (((j26 >> 18) | (j27 << 8)) & 4294967295L);
                byte[] bArr4 = new byte[16];
                c(bArr4, 0, jB6 & 4294967295L);
                long j28 = jB7 + (jB6 >> 32);
                c(bArr4, 4, j28 & 4294967295L);
                long j29 = jB8 + (((j25 >> 12) | (j26 << 14)) & 4294967295L) + (j28 >> 32);
                c(bArr4, 8, j29 & 4294967295L);
                c(bArr4, 12, (jB9 + (j29 >> 32)) & 4294967295L);
                return bArr4;
            }
            int iMin = Math.min(16, length - i3);
            System.arraycopy(bArr2, i3, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long j30 = jB5 * 5;
            long j31 = jB4 * 5;
            long j32 = jB3 * 5;
            long jB10 = j6 + (b(0, bArr3) & 67108863);
            long jB11 = j3 + ((b(i2, bArr3) >> 2) & 67108863);
            long jB12 = j2 + ((b(6, bArr3) >> 4) & 67108863);
            long jB13 = j4 + ((b(9, bArr3) >> 6) & 67108863);
            long j33 = jB2;
            long jB14 = j5 + (((b(12, bArr3) >> 8) & 67108863) | (bArr3[16] << 24));
            long j34 = jB11 * jB;
            long j35 = jB11 * j33;
            long j36 = jB12 * jB;
            long j37 = jB11 * jB3;
            long j38 = jB12 * j33;
            long j39 = jB13 * jB;
            long j40 = jB11 * jB4;
            long j41 = jB12 * jB3;
            long j42 = jB13 * j33;
            long j43 = jB14 * jB;
            long j44 = (jB2 * 5 * jB14) + (jB13 * j32) + (jB12 * j31) + (jB11 * j30) + (jB10 * jB);
            long j45 = j44 & 67108863;
            long j46 = jB13 * j31;
            long j47 = j32 * jB14;
            long j48 = j47 + j46 + (jB12 * j30) + (jB10 * j33) + j34 + (j44 >> 26);
            long j49 = j31 * jB14;
            long j50 = j49 + (jB13 * j30) + (jB10 * jB3) + j35 + j36 + (j48 >> 26);
            long j51 = (jB14 * j30) + (jB10 * jB4) + j37 + j38 + j39 + (j50 >> 26);
            long j52 = (jB10 * jB5) + j40 + j41 + j42 + j43 + (j51 >> 26);
            long j53 = ((j52 >> 26) * 5) + j45;
            j3 = (j48 & 67108863) + (j53 >> 26);
            i3 += 16;
            j2 = j50 & 67108863;
            j4 = j51 & 67108863;
            j5 = j52 & 67108863;
            j6 = j53 & 67108863;
            jB2 = j33;
            i2 = 3;
        }
    }

    public static long b(int i2, byte[] bArr) {
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return (((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16)) & 4294967295L;
    }

    public static void c(byte[] bArr, int i2, long j2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i2 + i3] = (byte) (255 & j2);
            j2 >>= 8;
        }
    }
}
