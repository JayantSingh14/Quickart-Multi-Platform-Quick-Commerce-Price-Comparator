package com.google.android.gms.internal.ads;

import java.lang.reflect.Array;
import java.math.BigInteger;

/* loaded from: classes4.dex */
final class zzhho {

    /* renamed from: a, reason: collision with root package name */
    public static final long[] f33812a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f33813b;

    /* renamed from: c, reason: collision with root package name */
    public static final long[] f33814c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhhh[][] f33815d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzhhh[] f33816e;

    /* renamed from: f, reason: collision with root package name */
    public static final BigInteger f33817f;

    /* renamed from: g, reason: collision with root package name */
    public static final BigInteger f33818g;

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f33819h;

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f33817f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f33818g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f33819h = bigIntegerMod2;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerModPow = bigIntegerValueOf.modPow(bigIntegerSubtract.subtract(bigInteger).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        zzhhn zzhhnVar = new zzhhn();
        BigInteger bigIntegerMod3 = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        zzhhnVar.f33811b = bigIntegerMod3;
        BigInteger bigIntegerMultiply = bigIntegerMod3.pow(2).subtract(bigInteger).multiply(bigIntegerMod.multiply(bigIntegerMod3.pow(2)).add(bigInteger).modInverse(bigIntegerSubtract));
        BigInteger bigIntegerModPow2 = bigIntegerMultiply.modPow(bigIntegerSubtract.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigIntegerSubtract);
        if (!bigIntegerModPow2.pow(2).subtract(bigIntegerMultiply).mod(bigIntegerSubtract).equals(BigInteger.ZERO)) {
            bigIntegerModPow2 = bigIntegerModPow2.multiply(bigIntegerModPow).mod(bigIntegerSubtract);
        }
        if (bigIntegerModPow2.testBit(0)) {
            bigIntegerModPow2 = bigIntegerSubtract.subtract(bigIntegerModPow2);
        }
        zzhhnVar.f33810a = bigIntegerModPow2;
        f33812a = zzhht.g(b(bigIntegerMod));
        f33813b = zzhht.g(b(bigIntegerMod2));
        f33814c = zzhht.g(b(bigIntegerModPow));
        f33815d = (zzhhh[][]) Array.newInstance((Class<?>) zzhhh.class, 32, 8);
        zzhhn zzhhnVarA = zzhhnVar;
        for (int i2 = 0; i2 < 32; i2++) {
            zzhhn zzhhnVarA2 = zzhhnVarA;
            for (int i3 = 0; i3 < 8; i3++) {
                f33815d[i2][i3] = c(zzhhnVarA2);
                zzhhnVarA2 = a(zzhhnVarA2, zzhhnVarA);
            }
            for (int i4 = 0; i4 < 8; i4++) {
                zzhhnVarA = a(zzhhnVarA, zzhhnVarA);
            }
        }
        zzhhn zzhhnVarA3 = a(zzhhnVar, zzhhnVar);
        f33816e = new zzhhh[8];
        for (int i5 = 0; i5 < 8; i5++) {
            f33816e[i5] = c(zzhhnVar);
            zzhhnVar = a(zzhhnVar, zzhhnVarA3);
        }
    }

    public static zzhhn a(zzhhn zzhhnVar, zzhhn zzhhnVar2) {
        zzhhn zzhhnVar3 = new zzhhn();
        BigInteger bigIntegerMultiply = f33818g.multiply(zzhhnVar.f33810a.multiply(zzhhnVar2.f33810a).multiply(zzhhnVar.f33811b).multiply(zzhhnVar2.f33811b));
        BigInteger bigInteger = f33817f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = zzhhnVar.f33810a.multiply(zzhhnVar2.f33811b).add(zzhhnVar2.f33810a.multiply(zzhhnVar.f33811b));
        BigInteger bigInteger2 = BigInteger.ONE;
        zzhhnVar3.f33810a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        zzhhnVar3.f33811b = zzhhnVar.f33811b.multiply(zzhhnVar2.f33811b).add(zzhhnVar.f33810a.multiply(zzhhnVar2.f33810a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return zzhhnVar3;
    }

    public static byte[] b(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        System.arraycopy(byteArray, 0, bArr, 32 - length, length);
        for (int i2 = 0; i2 < 16; i2++) {
            byte b2 = bArr[i2];
            int i3 = 31 - i2;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }

    public static zzhhh c(zzhhn zzhhnVar) {
        BigInteger bigIntegerAdd = zzhhnVar.f33811b.add(zzhhnVar.f33810a);
        BigInteger bigInteger = f33817f;
        return new zzhhh(zzhht.g(b(bigIntegerAdd.mod(bigInteger))), zzhht.g(b(zzhhnVar.f33811b.subtract(zzhhnVar.f33810a).mod(bigInteger))), zzhht.g(b(f33819h.multiply(zzhhnVar.f33810a).multiply(zzhhnVar.f33811b).mod(bigInteger))));
    }
}
