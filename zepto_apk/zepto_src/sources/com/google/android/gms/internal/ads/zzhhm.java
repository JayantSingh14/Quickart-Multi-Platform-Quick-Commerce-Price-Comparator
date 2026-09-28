package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzhhm {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhhh f33807a = new zzhhh(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: b, reason: collision with root package name */
    public static final zzhhj f33808b = new zzhhj(new zzhhk(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f33809c = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    public static byte[] a(byte[] bArr) {
        int i2;
        byte[] bArr2 = new byte[64];
        int i3 = 0;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = i3 + i3;
            bArr2[i4] = (byte) (bArr[i3] & 15);
            bArr2[i4 + 1] = (byte) ((bArr[i3] & 255) >> 4);
            i3++;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < 63) {
            byte b2 = (byte) (bArr2[i5] + i6);
            bArr2[i5] = b2;
            int i7 = (b2 + 8) >> 4;
            bArr2[i5] = (byte) (b2 - (i7 << 4));
            i5++;
            i6 = i7;
        }
        bArr2[63] = (byte) (bArr2[63] + i6);
        zzhhj zzhhjVar = new zzhhj();
        zzhhl zzhhlVar = new zzhhl();
        for (i2 = 1; i2 < 64; i2 += 2) {
            zzhhh zzhhhVar = new zzhhh();
            h(zzhhhVar, i2 / 2, bArr2[i2]);
            zzhhl.a(zzhhlVar, zzhhjVar);
            d(zzhhjVar, zzhhlVar, zzhhhVar);
        }
        zzhhk zzhhkVar = new zzhhk();
        zzhhk.a(zzhhjVar, zzhhkVar);
        f(zzhhjVar, zzhhkVar);
        zzhhk.a(zzhhjVar, zzhhkVar);
        f(zzhhjVar, zzhhkVar);
        zzhhk.a(zzhhjVar, zzhhkVar);
        f(zzhhjVar, zzhhkVar);
        zzhhk.a(zzhhjVar, zzhhkVar);
        f(zzhhjVar, zzhhkVar);
        for (int i8 = 0; i8 < 64; i8 += 2) {
            zzhhh zzhhhVar2 = new zzhhh();
            h(zzhhhVar2, i8 / 2, bArr2[i8]);
            zzhhl.a(zzhhlVar, zzhhjVar);
            d(zzhhjVar, zzhhlVar, zzhhhVar2);
        }
        zzhhk zzhhkVar2 = new zzhhk(zzhhjVar);
        long[] jArr = new long[10];
        zzhht.f(jArr, zzhhkVar2.f33802a);
        long[] jArr2 = new long[10];
        zzhht.f(jArr2, zzhhkVar2.f33803b);
        long[] jArr3 = new long[10];
        zzhht.f(jArr3, zzhhkVar2.f33804c);
        long[] jArr4 = new long[10];
        zzhht.f(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhht.b(jArr5, jArr2, jArr);
        zzhht.e(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhht.e(jArr6, jArr, jArr2);
        zzhht.e(jArr6, jArr6, zzhho.f33812a);
        zzhht.a(jArr6, jArr6, jArr4);
        zzhht.c(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhht.h(jArr5), zzhht.h(jArr6))) {
            return zzhhkVar2.b();
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] b(byte[] bArr) {
        MessageDigest messageDigest = (MessageDigest) zzhwc.f34417e.f34420a.a(MessageDigestAlgorithms.SHA_512);
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i2 = bArrDigest[31] & 127;
        bArrDigest[31] = (byte) i2;
        bArrDigest[31] = (byte) (i2 | 64);
        return bArrDigest;
    }

    public static /* synthetic */ boolean c(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhht.d(jArr2);
        byte[] bArrH = zzhht.h(jArr2);
        for (int i2 = 0; i2 < 32; i2++) {
            if (bArrH[i2] != 0) {
                return true;
            }
        }
        return false;
    }

    public static void d(zzhhj zzhhjVar, zzhhl zzhhlVar, zzhhh zzhhhVar) {
        long[] jArr = new long[10];
        zzhhk zzhhkVar = zzhhjVar.f33800a;
        long[] jArr2 = zzhhkVar.f33802a;
        zzhhk zzhhkVar2 = zzhhlVar.f33805a;
        long[] jArr3 = zzhhkVar2.f33803b;
        long[] jArr4 = zzhhkVar2.f33802a;
        zzhht.a(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhhkVar.f33803b;
        zzhht.b(jArr5, jArr3, jArr4);
        zzhht.e(jArr5, jArr5, zzhhhVar.f33797b);
        long[] jArr6 = zzhhhVar.f33796a;
        long[] jArr7 = zzhhkVar.f33804c;
        zzhht.e(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhhjVar.f33801b;
        zzhht.e(jArr8, zzhhlVar.f33806b, zzhhhVar.f33798c);
        zzhhhVar.a(jArr2, zzhhkVar2.f33804c);
        zzhht.a(jArr, jArr2, jArr2);
        zzhht.b(jArr2, jArr7, jArr5);
        zzhht.a(jArr5, jArr7, jArr5);
        zzhht.a(jArr7, jArr, jArr8);
        zzhht.b(jArr8, jArr, jArr8);
    }

    public static void e(zzhhj zzhhjVar, zzhhl zzhhlVar, zzhhh zzhhhVar) {
        long[] jArr = new long[10];
        zzhhk zzhhkVar = zzhhjVar.f33800a;
        long[] jArr2 = zzhhkVar.f33802a;
        zzhhk zzhhkVar2 = zzhhlVar.f33805a;
        long[] jArr3 = zzhhkVar2.f33803b;
        long[] jArr4 = zzhhkVar2.f33802a;
        zzhht.a(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhhkVar.f33803b;
        zzhht.b(jArr5, jArr3, jArr4);
        zzhht.e(jArr5, jArr5, zzhhhVar.f33796a);
        long[] jArr6 = zzhhhVar.f33797b;
        long[] jArr7 = zzhhkVar.f33804c;
        zzhht.e(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhhjVar.f33801b;
        zzhht.e(jArr8, zzhhlVar.f33806b, zzhhhVar.f33798c);
        zzhhhVar.a(jArr2, zzhhkVar2.f33804c);
        zzhht.a(jArr, jArr2, jArr2);
        zzhht.b(jArr2, jArr7, jArr5);
        zzhht.a(jArr5, jArr7, jArr5);
        zzhht.b(jArr7, jArr, jArr8);
        zzhht.a(jArr8, jArr, jArr8);
    }

    public static void f(zzhhj zzhhjVar, zzhhk zzhhkVar) {
        zzhhk zzhhkVar2 = zzhhjVar.f33800a;
        long[] jArr = zzhhkVar2.f33802a;
        long[] jArr2 = new long[10];
        long[] jArr3 = zzhhkVar.f33802a;
        zzhht.f(jArr, jArr3);
        long[] jArr4 = zzhhkVar2.f33804c;
        long[] jArr5 = zzhhkVar.f33803b;
        zzhht.f(jArr4, jArr5);
        long[] jArr6 = zzhhjVar.f33801b;
        zzhht.f(jArr6, zzhhkVar.f33804c);
        zzhht.a(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhhkVar2.f33803b;
        zzhht.a(jArr7, jArr3, jArr5);
        zzhht.f(jArr2, jArr7);
        zzhht.a(jArr7, jArr4, jArr);
        zzhht.b(jArr4, jArr4, jArr);
        zzhht.b(jArr, jArr2, jArr7);
        zzhht.b(jArr6, jArr6, jArr4);
    }

    public static int g(int i2, int i3) {
        int i4 = (~(i2 ^ i3)) & 255;
        int i5 = i4 & (i4 << 4);
        int i6 = i5 & (i5 << 2);
        return (i6 & (i6 + i6)) >> 7;
    }

    public static void h(zzhhh zzhhhVar, int i2, byte b2) {
        zzhhh[][] zzhhhVarArr = zzhho.f33815d;
        int i3 = (b2 & 255) >> 7;
        int i4 = (-i3) & b2;
        int i5 = b2 - (i4 + i4);
        zzhhhVar.b(zzhhhVarArr[i2][0], g(i5, 1));
        zzhhhVar.b(zzhhhVarArr[i2][1], g(i5, 2));
        zzhhhVar.b(zzhhhVarArr[i2][2], g(i5, 3));
        zzhhhVar.b(zzhhhVarArr[i2][3], g(i5, 4));
        zzhhhVar.b(zzhhhVarArr[i2][4], g(i5, 5));
        zzhhhVar.b(zzhhhVarArr[i2][5], g(i5, 6));
        zzhhhVar.b(zzhhhVarArr[i2][6], g(i5, 7));
        zzhhhVar.b(zzhhhVarArr[i2][7], g(i5, 8));
        long[] jArrCopyOf = Arrays.copyOf(zzhhhVar.f33797b, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(zzhhhVar.f33796a, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(zzhhhVar.f33798c, 10);
        for (int i6 = 0; i6 < jArrCopyOf3.length; i6++) {
            jArrCopyOf3[i6] = -jArrCopyOf3[i6];
        }
        zzhhhVar.b(new zzhhh(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i3);
    }

    public static byte[] i(byte[] bArr) {
        int i2;
        byte[] bArr2 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = (byte) (1 & ((bArr[i3 >> 3] & 255) >> (i3 & 7)));
        }
        for (int i4 = 0; i4 < 256; i4++) {
            if (bArr2[i4] != 0) {
                for (int i5 = 1; i5 <= 6 && (i2 = i4 + i5) < 256; i5++) {
                    byte b2 = bArr2[i2];
                    if (b2 != 0) {
                        byte b3 = bArr2[i4];
                        int i6 = b2 << i5;
                        int i7 = b3 + i6;
                        if (i7 <= 15) {
                            bArr2[i4] = (byte) i7;
                            bArr2[i2] = 0;
                        } else {
                            int i8 = b3 - i6;
                            if (i8 >= -15) {
                                bArr2[i4] = (byte) i8;
                                while (true) {
                                    if (i2 >= 256) {
                                        break;
                                    }
                                    if (bArr2[i2] == 0) {
                                        bArr2[i2] = 1;
                                        break;
                                    }
                                    bArr2[i2] = 0;
                                    i2++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static long j(byte[] bArr, int i2) {
        return ((bArr[i2 + 2] & 255) << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
    }

    public static long k(int i2, byte[] bArr) {
        return ((bArr[i2 + 3] & 255) << 24) | j(bArr, i2);
    }
}
