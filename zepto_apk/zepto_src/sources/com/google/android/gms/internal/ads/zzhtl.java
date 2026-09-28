package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhtl {

    /* renamed from: a, reason: collision with root package name */
    public zzhti f34266a = null;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f34267b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f34268c = null;

    public final zzhtm a() throws GeneralSecurityException {
        zzhxc zzhxcVarA;
        if (this.f34266a == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        BigInteger bigInteger = this.f34267b;
        if (bigInteger == null) {
            throw new GeneralSecurityException("Cannot build without modulus");
        }
        int iBitLength = bigInteger.bitLength();
        zzhti zzhtiVar = this.f34266a;
        int i2 = zzhtiVar.f34246a;
        if (iBitLength != i2) {
            throw new GeneralSecurityException(androidx.fragment.app.e.n(iBitLength, i2, "Got modulus size ", ", but parameters requires modulus size ", new StringBuilder(String.valueOf(iBitLength).length() + 56 + String.valueOf(i2).length())));
        }
        if (zzhtiVar.a() && this.f34268c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f34266a.a() && this.f34268c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhth zzhthVar = this.f34266a.f34248c;
        if (zzhthVar == zzhth.f34243e) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhthVar == zzhth.f34242d || zzhthVar == zzhth.f34241c) {
            zzhxcVarA = zzhjf.a(this.f34268c.intValue());
        } else {
            if (zzhthVar != zzhth.f34240b) {
                throw new IllegalStateException("Unknown RsaSsaPssParameters.Variant: ".concat(String.valueOf(this.f34266a.f34248c)));
            }
            zzhxcVarA = zzhjf.b(this.f34268c.intValue());
        }
        return new zzhtm(this.f34266a, this.f34267b, zzhxcVarA, this.f34268c);
    }
}
