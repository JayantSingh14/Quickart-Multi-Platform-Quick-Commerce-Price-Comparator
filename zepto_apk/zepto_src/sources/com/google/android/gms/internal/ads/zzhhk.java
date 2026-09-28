package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhhk {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f33802a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f33803b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f33804c;

    public zzhhk(long[] jArr, long[] jArr2, long[] jArr3) {
        this.f33802a = jArr;
        this.f33803b = jArr2;
        this.f33804c = jArr3;
    }

    public static void a(zzhhj zzhhjVar, zzhhk zzhhkVar) {
        long[] jArr = zzhhkVar.f33802a;
        zzhhk zzhhkVar2 = zzhhjVar.f33800a;
        long[] jArr2 = zzhhkVar2.f33802a;
        long[] jArr3 = zzhhjVar.f33801b;
        zzhht.e(jArr, jArr2, jArr3);
        long[] jArr4 = zzhhkVar.f33803b;
        long[] jArr5 = zzhhkVar2.f33803b;
        long[] jArr6 = zzhhkVar2.f33804c;
        zzhht.e(jArr4, jArr5, jArr6);
        zzhht.e(zzhhkVar.f33804c, jArr6, jArr3);
    }

    public final byte[] b() {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        long[] jArr13 = new long[10];
        long[] jArr14 = this.f33804c;
        zzhht.f(jArr4, jArr14);
        zzhht.f(jArr13, jArr4);
        zzhht.f(jArr12, jArr13);
        zzhht.e(jArr5, jArr12, jArr14);
        zzhht.e(jArr6, jArr5, jArr4);
        zzhht.f(jArr12, jArr6);
        zzhht.e(jArr7, jArr12, jArr5);
        zzhht.f(jArr12, jArr7);
        zzhht.f(jArr13, jArr12);
        zzhht.f(jArr12, jArr13);
        zzhht.f(jArr13, jArr12);
        zzhht.f(jArr12, jArr13);
        zzhht.e(jArr8, jArr12, jArr7);
        zzhht.f(jArr12, jArr8);
        zzhht.f(jArr13, jArr12);
        for (int i2 = 2; i2 < 10; i2 += 2) {
            zzhht.f(jArr12, jArr13);
            zzhht.f(jArr13, jArr12);
        }
        zzhht.e(jArr9, jArr13, jArr8);
        zzhht.f(jArr12, jArr9);
        zzhht.f(jArr13, jArr12);
        for (int i3 = 2; i3 < 20; i3 += 2) {
            zzhht.f(jArr12, jArr13);
            zzhht.f(jArr13, jArr12);
        }
        zzhht.e(jArr12, jArr13, jArr9);
        zzhht.f(jArr13, jArr12);
        zzhht.f(jArr12, jArr13);
        for (int i4 = 2; i4 < 10; i4 += 2) {
            zzhht.f(jArr13, jArr12);
            zzhht.f(jArr12, jArr13);
        }
        zzhht.e(jArr10, jArr12, jArr8);
        zzhht.f(jArr12, jArr10);
        zzhht.f(jArr13, jArr12);
        for (int i5 = 2; i5 < 50; i5 += 2) {
            zzhht.f(jArr12, jArr13);
            zzhht.f(jArr13, jArr12);
        }
        zzhht.e(jArr11, jArr13, jArr10);
        zzhht.f(jArr13, jArr11);
        zzhht.f(jArr12, jArr13);
        for (int i6 = 2; i6 < 100; i6 += 2) {
            zzhht.f(jArr13, jArr12);
            zzhht.f(jArr12, jArr13);
        }
        zzhht.e(jArr13, jArr12, jArr11);
        zzhht.f(jArr12, jArr13);
        zzhht.f(jArr13, jArr12);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            zzhht.f(jArr12, jArr13);
            zzhht.f(jArr13, jArr12);
        }
        zzhht.e(jArr12, jArr13, jArr10);
        zzhht.f(jArr13, jArr12);
        zzhht.f(jArr12, jArr13);
        zzhht.f(jArr13, jArr12);
        zzhht.f(jArr12, jArr13);
        zzhht.f(jArr13, jArr12);
        zzhht.e(jArr, jArr13, jArr6);
        zzhht.e(jArr2, this.f33802a, jArr);
        zzhht.e(jArr3, this.f33803b, jArr);
        byte[] bArrH = zzhht.h(jArr3);
        bArrH[31] = (byte) (((zzhht.h(jArr2)[0] & 1) << 7) ^ bArrH[31]);
        return bArrH;
    }

    public zzhhk() {
        this(new long[10], new long[10], new long[10]);
    }

    public zzhhk(zzhhj zzhhjVar) {
        this();
        a(zzhhjVar, this);
    }

    public zzhhk(zzhhk zzhhkVar) {
        this.f33802a = Arrays.copyOf(zzhhkVar.f33802a, 10);
        this.f33803b = Arrays.copyOf(zzhhkVar.f33803b, 10);
        this.f33804c = Arrays.copyOf(zzhhkVar.f33804c, 10);
    }
}
