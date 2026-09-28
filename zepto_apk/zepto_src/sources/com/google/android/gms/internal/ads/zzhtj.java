package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhtj {

    /* renamed from: a, reason: collision with root package name */
    public zzhtm f34252a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxd f34253b = null;

    /* renamed from: c, reason: collision with root package name */
    public zzhxd f34254c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhxd f34255d = null;

    /* renamed from: e, reason: collision with root package name */
    public zzhxd f34256e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzhxd f34257f = null;

    /* renamed from: g, reason: collision with root package name */
    public zzhxd f34258g = null;

    public final zzhtk a() throws GeneralSecurityException {
        zzhxd zzhxdVar;
        zzhxd zzhxdVar2;
        zzhtm zzhtmVar = this.f34252a;
        if (zzhtmVar == null) {
            throw new GeneralSecurityException("Cannot build without a RSA SSA PKCS1 public key");
        }
        zzhxd zzhxdVar3 = this.f34254c;
        if (zzhxdVar3 == null || (zzhxdVar = this.f34255d) == null) {
            throw new GeneralSecurityException("Cannot build without prime factors");
        }
        zzhxd zzhxdVar4 = this.f34253b;
        if (zzhxdVar4 == null) {
            throw new GeneralSecurityException("Cannot build without private exponent");
        }
        zzhxd zzhxdVar5 = this.f34256e;
        if (zzhxdVar5 == null || (zzhxdVar2 = this.f34257f) == null) {
            throw new GeneralSecurityException("Cannot build without prime exponents");
        }
        zzhxd zzhxdVar6 = this.f34258g;
        if (zzhxdVar6 == null) {
            throw new GeneralSecurityException("Cannot build without CRT coefficient");
        }
        BigInteger bigInteger = zzhtmVar.f34269a.f34247b;
        BigInteger bigInteger2 = zzhxdVar3.f34462a;
        if (!bigInteger2.isProbablePrime(10)) {
            throw new GeneralSecurityException("p is not a prime");
        }
        BigInteger bigInteger3 = zzhxdVar.f34462a;
        if (!bigInteger3.isProbablePrime(10)) {
            throw new GeneralSecurityException("q is not a prime");
        }
        if (!bigInteger2.multiply(bigInteger3).equals(zzhtmVar.f34270b)) {
            throw new GeneralSecurityException("Prime p times prime q is not equal to the public key's modulus");
        }
        BigInteger bigInteger4 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger4);
        BigInteger bigIntegerSubtract2 = bigInteger3.subtract(bigInteger4);
        if (!bigInteger.multiply(zzhxdVar4.f34462a).mod(bigIntegerSubtract.divide(bigIntegerSubtract.gcd(bigIntegerSubtract2)).multiply(bigIntegerSubtract2)).equals(bigInteger4)) {
            throw new GeneralSecurityException("D is invalid.");
        }
        if (!bigInteger.multiply(zzhxdVar5.f34462a).mod(bigIntegerSubtract).equals(bigInteger4)) {
            throw new GeneralSecurityException("dP is invalid.");
        }
        if (!bigInteger.multiply(zzhxdVar2.f34462a).mod(bigIntegerSubtract2).equals(bigInteger4)) {
            throw new GeneralSecurityException("dQ is invalid.");
        }
        if (bigInteger3.multiply(zzhxdVar6.f34462a).mod(bigInteger2).equals(bigInteger4)) {
            return new zzhtk(this.f34252a, this.f34254c, this.f34255d, this.f34253b, this.f34256e, this.f34257f, this.f34258g);
        }
        throw new GeneralSecurityException("qInv is invalid.");
    }
}
