package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* loaded from: classes4.dex */
public final class zzhrf {

    /* renamed from: a, reason: collision with root package name */
    public zzhri f34099a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxd f34100b = null;

    public final zzhrg a() throws GeneralSecurityException {
        ECPoint eCPoint;
        zzhri zzhriVar = this.f34099a;
        if (zzhriVar == null) {
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
        zzhxd zzhxdVar = this.f34100b;
        if (zzhxdVar == null) {
            throw new GeneralSecurityException("Cannot build without a private value");
        }
        zzhra zzhraVar = zzhriVar.f34106a.f34096b;
        BigInteger order = zzhraVar.f34082b.getOrder();
        BigInteger bigInteger = zzhxdVar.f34462a;
        if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        ECParameterSpec eCParameterSpec = zzhhq.f33824a;
        ECParameterSpec eCParameterSpec2 = zzhraVar.f34082b;
        if (!zzhhq.b(eCParameterSpec2, eCParameterSpec) && !zzhhq.b(eCParameterSpec2, zzhhq.f33825b) && !zzhhq.b(eCParameterSpec2, zzhhq.f33826c)) {
            throw new GeneralSecurityException("spec must be NIST P256, P384 or P521");
        }
        if (bigInteger.signum() != 1) {
            throw new GeneralSecurityException("k must be positive");
        }
        if (bigInteger.compareTo(eCParameterSpec2.getOrder()) >= 0) {
            throw new GeneralSecurityException("k must be smaller than the order of the generator");
        }
        EllipticCurve curve = eCParameterSpec2.getCurve();
        ECPoint generator = eCParameterSpec2.getGenerator();
        zzhhq.a(generator, curve);
        BigInteger a2 = eCParameterSpec2.getCurve().getA();
        BigInteger bigIntegerC = zzhhq.c(curve);
        zzhhp zzhhpVarD = zzhhq.d(ECPoint.POINT_INFINITY, bigIntegerC);
        zzhhp zzhhpVarD2 = zzhhq.d(generator, bigIntegerC);
        for (int iBitLength = bigInteger.bitLength(); iBitLength >= 0; iBitLength--) {
            if (bigInteger.testBit(iBitLength)) {
                zzhhpVarD = zzhhq.f(zzhhpVarD, zzhhpVarD2, a2, bigIntegerC);
                zzhhpVarD2 = zzhhq.e(zzhhpVarD2, a2, bigIntegerC);
            } else {
                zzhhpVarD2 = zzhhq.f(zzhhpVarD, zzhhpVarD2, a2, bigIntegerC);
                zzhhpVarD = zzhhq.e(zzhhpVarD, a2, bigIntegerC);
            }
        }
        if (zzhhpVarD.f33823c.equals(BigInteger.ZERO)) {
            eCPoint = ECPoint.POINT_INFINITY;
        } else {
            BigInteger bigIntegerModInverse = zzhhpVarD.f33823c.modInverse(bigIntegerC);
            BigInteger bigIntegerMod = bigIntegerModInverse.multiply(bigIntegerModInverse).mod(bigIntegerC);
            eCPoint = new ECPoint(zzhhpVarD.f33821a.multiply(bigIntegerMod).mod(bigIntegerC), zzhhpVarD.f33822b.multiply(bigIntegerMod).mod(bigIntegerC).multiply(bigIntegerModInverse).mod(bigIntegerC));
        }
        zzhhq.a(eCPoint, curve);
        if (eCPoint.equals(zzhriVar.f34107b)) {
            return new zzhrg(this.f34099a, this.f34100b);
        }
        throw new GeneralSecurityException("Invalid private value");
    }
}
