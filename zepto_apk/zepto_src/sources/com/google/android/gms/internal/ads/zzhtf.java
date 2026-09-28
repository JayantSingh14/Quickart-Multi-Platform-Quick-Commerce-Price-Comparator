package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhtf {

    /* renamed from: g, reason: collision with root package name */
    public static final BigInteger f34228g;

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f34229h;

    /* renamed from: a, reason: collision with root package name */
    public Integer f34230a = null;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f34231b = zzhti.f34245g;

    /* renamed from: c, reason: collision with root package name */
    public zzhtg f34232c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhtg f34233d = null;

    /* renamed from: e, reason: collision with root package name */
    public Integer f34234e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzhth f34235f = zzhth.f34243e;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        f34228g = bigIntegerValueOf;
        f34229h = bigIntegerValueOf.pow(256);
    }

    public final void a(int i2) {
        this.f34230a = Integer.valueOf(i2);
    }

    public final void b(int i2) throws GeneralSecurityException {
        if (i2 < 0) {
            throw new GeneralSecurityException(String.format("Invalid salt length in bytes %d; salt length must be positive", Integer.valueOf(i2)));
        }
        this.f34234e = Integer.valueOf(i2);
    }

    public final zzhti c() throws GeneralSecurityException {
        Integer num = this.f34230a;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.f34231b == null) {
            throw new GeneralSecurityException("publicExponent is not set");
        }
        if (this.f34232c == null) {
            throw new GeneralSecurityException("signature hash type is not set");
        }
        if (this.f34233d == null) {
            throw new GeneralSecurityException("mgf1 hash type is not set");
        }
        if (this.f34235f == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (this.f34234e == null) {
            throw new GeneralSecurityException("salt length is not set");
        }
        if (num.intValue() < 2048) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least %d bits", this.f34230a, 2048));
        }
        if (this.f34232c != this.f34233d) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        }
        BigInteger bigInteger = this.f34231b;
        int iCompareTo = bigInteger.compareTo(zzhti.f34245g);
        if (iCompareTo != 0) {
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(f34228g).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(f34229h) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }
        return new zzhti(this.f34230a.intValue(), this.f34231b, this.f34235f, this.f34232c, this.f34233d, this.f34234e.intValue());
    }
}
