package com.google.android.gms.internal.pal;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzyt {
    public static byte[] a(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        int i2 = 32;
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        int i3 = 0;
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        int i4 = bArrCopyOf[31] & 127;
        bArrCopyOf[31] = (byte) i4;
        bArrCopyOf[31] = (byte) (i4 | 64);
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr2, 32);
        bArrCopyOf2[31] = (byte) (bArrCopyOf2[31] & 127);
        for (int i5 = 0; i5 < 7; i5++) {
            byte[][] bArr3 = zzxq.f38125a;
            if (zzxo.b(bArr3[i5], bArrCopyOf2)) {
                throw new InvalidKeyException("Banned public key: ".concat(zzyj.a(bArr3[i5])));
            }
        }
        int i6 = 10;
        long[] jArr2 = new long[10];
        for (int i7 = 0; i7 < 10; i7++) {
            int i8 = zzyi.f38147a[i7];
            jArr2[i7] = ((((bArrCopyOf2[i8 + 3] & 255) << 24) | (((bArrCopyOf2[i8] & 255) | ((bArrCopyOf2[i8 + 1] & 255) << 8)) | ((bArrCopyOf2[i8 + 2] & 255) << 16))) >> zzyi.f38148b[i7]) & zzyi.f38149c[i7 & 1];
        }
        long[] jArr3 = new long[19];
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        jArr5[0] = 1;
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        long[] jArr8 = new long[19];
        jArr8[0] = 1;
        long[] jArr9 = new long[19];
        long[] jArr10 = new long[19];
        jArr10[0] = 1;
        System.arraycopy(jArr2, 0, jArr3, 0, 10);
        while (i3 < i2) {
            int i9 = bArrCopyOf[31 - i3] & 255;
            int i10 = 0;
            while (i10 < 8) {
                int i11 = (i9 >> (7 - i10)) & 1;
                zzxq.a(i11, jArr5, jArr3);
                zzxq.a(i11, jArr6, jArr4);
                byte[] bArr4 = bArrCopyOf;
                long[] jArrCopyOf = Arrays.copyOf(jArr5, 10);
                int i12 = i9;
                long[] jArr11 = new long[19];
                int i13 = i3;
                long[] jArr12 = new long[19];
                int i14 = i10;
                long[] jArr13 = new long[19];
                long[] jArr14 = jArr;
                long[] jArr15 = new long[19];
                long[] jArr16 = new long[19];
                long[] jArr17 = jArr10;
                long[] jArr18 = new long[19];
                long[] jArr19 = new long[19];
                zzyi.g(jArr5, jArr5, jArr6);
                zzyi.f(jArr6, jArrCopyOf, jArr6);
                long[] jArrCopyOf2 = Arrays.copyOf(jArr3, 10);
                zzyi.g(jArr3, jArr3, jArr4);
                zzyi.f(jArr4, jArrCopyOf2, jArr4);
                zzyi.b(jArr15, jArr3, jArr6);
                zzyi.b(jArr16, jArr5, jArr4);
                zzyi.d(jArr15);
                zzyi.c(jArr15);
                zzyi.d(jArr16);
                zzyi.c(jArr16);
                long[] jArr20 = jArr3;
                System.arraycopy(jArr15, 0, jArrCopyOf2, 0, 10);
                zzyi.g(jArr15, jArr15, jArr16);
                zzyi.f(jArr16, jArrCopyOf2, jArr16);
                zzyi.e(jArr19, jArr15);
                zzyi.e(jArr18, jArr16);
                zzyi.b(jArr16, jArr18, jArr2);
                zzyi.d(jArr16);
                zzyi.c(jArr16);
                System.arraycopy(jArr19, 0, jArr7, 0, 10);
                System.arraycopy(jArr16, 0, jArr8, 0, 10);
                zzyi.e(jArr12, jArr5);
                zzyi.e(jArr13, jArr6);
                zzyi.b(jArr9, jArr12, jArr13);
                zzyi.d(jArr9);
                zzyi.c(jArr9);
                zzyi.f(jArr13, jArr12, jArr13);
                Arrays.fill(jArr11, 10, 18, 0L);
                int i15 = 0;
                for (int i16 = 10; i15 < i16; i16 = 10) {
                    jArr11[i15] = jArr13[i15] * 121665;
                    i15++;
                }
                zzyi.c(jArr11);
                zzyi.g(jArr11, jArr11, jArr12);
                zzyi.b(jArr17, jArr13, jArr11);
                zzyi.d(jArr17);
                zzyi.c(jArr17);
                zzxq.a(i11, jArr9, jArr7);
                zzxq.a(i11, jArr17, jArr8);
                i10 = i14 + 1;
                long[] jArr21 = jArr5;
                jArr5 = jArr9;
                jArr9 = jArr21;
                long[] jArr22 = jArr6;
                jArr6 = jArr17;
                jArr10 = jArr22;
                long[] jArr23 = jArr8;
                jArr8 = jArr4;
                jArr4 = jArr23;
                i9 = i12;
                jArr3 = jArr7;
                bArrCopyOf = bArr4;
                i3 = i13;
                jArr = jArr14;
                jArr7 = jArr20;
            }
            i3++;
            i2 = 32;
            i6 = 10;
        }
        long[] jArr24 = jArr;
        int i17 = i6;
        long[] jArr25 = new long[i17];
        long[] jArr26 = new long[i17];
        long[] jArr27 = new long[i17];
        long[] jArr28 = new long[i17];
        long[] jArr29 = new long[i17];
        long[] jArr30 = new long[i17];
        long[] jArr31 = new long[i17];
        long[] jArr32 = new long[i17];
        long[] jArr33 = new long[i17];
        long[] jArr34 = new long[i17];
        long[] jArr35 = jArr3;
        long[] jArr36 = new long[i17];
        zzyi.e(jArr26, jArr6);
        zzyi.e(jArr36, jArr26);
        zzyi.e(jArr34, jArr36);
        zzyi.a(jArr27, jArr34, jArr6);
        zzyi.a(jArr28, jArr27, jArr26);
        zzyi.e(jArr34, jArr28);
        zzyi.a(jArr29, jArr34, jArr27);
        zzyi.e(jArr34, jArr29);
        zzyi.e(jArr36, jArr34);
        zzyi.e(jArr34, jArr36);
        zzyi.e(jArr36, jArr34);
        zzyi.e(jArr34, jArr36);
        zzyi.a(jArr30, jArr34, jArr29);
        zzyi.e(jArr34, jArr30);
        zzyi.e(jArr36, jArr34);
        for (int i18 = 2; i18 < 10; i18 += 2) {
            zzyi.e(jArr34, jArr36);
            zzyi.e(jArr36, jArr34);
        }
        zzyi.a(jArr31, jArr36, jArr30);
        zzyi.e(jArr34, jArr31);
        zzyi.e(jArr36, jArr34);
        for (int i19 = 2; i19 < 20; i19 += 2) {
            zzyi.e(jArr34, jArr36);
            zzyi.e(jArr36, jArr34);
        }
        zzyi.a(jArr34, jArr36, jArr31);
        zzyi.e(jArr36, jArr34);
        zzyi.e(jArr34, jArr36);
        for (int i20 = 2; i20 < 10; i20 += 2) {
            zzyi.e(jArr36, jArr34);
            zzyi.e(jArr34, jArr36);
        }
        zzyi.a(jArr32, jArr34, jArr30);
        zzyi.e(jArr34, jArr32);
        zzyi.e(jArr36, jArr34);
        for (int i21 = 2; i21 < 50; i21 += 2) {
            zzyi.e(jArr34, jArr36);
            zzyi.e(jArr36, jArr34);
        }
        zzyi.a(jArr33, jArr36, jArr32);
        zzyi.e(jArr36, jArr33);
        zzyi.e(jArr34, jArr36);
        for (int i22 = 2; i22 < 100; i22 += 2) {
            zzyi.e(jArr36, jArr34);
            zzyi.e(jArr34, jArr36);
        }
        zzyi.a(jArr36, jArr34, jArr33);
        zzyi.e(jArr34, jArr36);
        zzyi.e(jArr36, jArr34);
        for (int i23 = 2; i23 < 50; i23 += 2) {
            zzyi.e(jArr34, jArr36);
            zzyi.e(jArr36, jArr34);
        }
        zzyi.a(jArr34, jArr36, jArr32);
        zzyi.e(jArr36, jArr34);
        zzyi.e(jArr34, jArr36);
        zzyi.e(jArr36, jArr34);
        zzyi.e(jArr34, jArr36);
        zzyi.e(jArr36, jArr34);
        zzyi.a(jArr25, jArr36, jArr28);
        zzyi.a(jArr24, jArr5, jArr25);
        long[] jArr37 = new long[10];
        long[] jArr38 = new long[10];
        long[] jArr39 = new long[11];
        long[] jArr40 = new long[11];
        long[] jArr41 = new long[11];
        zzyi.a(jArr37, jArr2, jArr24);
        zzyi.g(jArr38, jArr2, jArr24);
        long[] jArr42 = new long[10];
        jArr42[0] = 486662;
        zzyi.g(jArr40, jArr38, jArr42);
        zzyi.a(jArr40, jArr40, jArr4);
        zzyi.g(jArr40, jArr40, jArr35);
        zzyi.a(jArr40, jArr40, jArr37);
        zzyi.a(jArr40, jArr40, jArr35);
        for (int i24 = 0; i24 < 10; i24++) {
            jArr39[i24] = jArr40[i24] * 4;
        }
        zzyi.c(jArr39);
        zzyi.a(jArr40, jArr37, jArr4);
        zzyi.f(jArr40, jArr40, jArr4);
        zzyi.a(jArr41, jArr38, jArr35);
        zzyi.g(jArr40, jArr40, jArr41);
        zzyi.e(jArr40, jArr40);
        if (zzxo.b(zzyi.h(jArr39), zzyi.h(jArr40))) {
            return zzyi.h(jArr24);
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzyj.a(bArr2)));
    }

    public static byte[] b() {
        byte[] bArrA = zzyq.a(32);
        bArrA[0] = (byte) (bArrA[0] | 7);
        int i2 = bArrA[31] & 63;
        bArrA[31] = (byte) i2;
        bArrA[31] = (byte) (i2 | 128);
        return bArrA;
    }

    public static byte[] c(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return a(bArr, bArr2);
    }
}
