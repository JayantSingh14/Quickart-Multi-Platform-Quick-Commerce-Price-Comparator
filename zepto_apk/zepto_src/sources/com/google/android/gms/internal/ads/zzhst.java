package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhst {

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f34176e;

    /* renamed from: f, reason: collision with root package name */
    public static final BigInteger f34177f;

    /* renamed from: a, reason: collision with root package name */
    public Integer f34178a = null;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f34179b = zzhsw.f34191e;

    /* renamed from: c, reason: collision with root package name */
    public zzhsu f34180c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhsv f34181d = zzhsv.f34189e;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        f34176e = bigIntegerValueOf;
        f34177f = bigIntegerValueOf.pow(256);
    }

    public final void a(int i2) {
        this.f34178a = Integer.valueOf(i2);
    }

    public final zzhsw b() throws GeneralSecurityException {
        Integer num = this.f34178a;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.f34179b == null) {
            throw new GeneralSecurityException("publicExponent is not set");
        }
        if (this.f34180c == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.f34181d == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 2048) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 2048 bits", this.f34178a));
        }
        BigInteger bigInteger = this.f34179b;
        int iCompareTo = bigInteger.compareTo(zzhsw.f34191e);
        if (iCompareTo != 0) {
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(f34176e).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(f34177f) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }
        return new zzhsw(this.f34178a.intValue(), this.f34179b, this.f34181d, this.f34180c);
    }
}
