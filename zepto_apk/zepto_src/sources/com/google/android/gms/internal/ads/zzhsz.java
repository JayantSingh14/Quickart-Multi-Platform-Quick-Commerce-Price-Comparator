package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhsz {

    /* renamed from: a, reason: collision with root package name */
    public zzhsw f34210a = null;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f34211b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f34212c = null;

    public final zzhta a() throws GeneralSecurityException {
        zzhxc zzhxcVarA;
        if (this.f34210a == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        BigInteger bigInteger = this.f34211b;
        if (bigInteger == null) {
            throw new GeneralSecurityException("Cannot build without modulus");
        }
        int iBitLength = bigInteger.bitLength();
        zzhsw zzhswVar = this.f34210a;
        int i2 = zzhswVar.f34192a;
        if (iBitLength != i2) {
            throw new GeneralSecurityException(androidx.fragment.app.e.n(iBitLength, i2, "Got modulus size ", ", but parameters requires modulus size ", new StringBuilder(String.valueOf(iBitLength).length() + 56 + String.valueOf(i2).length())));
        }
        if (zzhswVar.a() && this.f34212c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f34210a.a() && this.f34212c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhsv zzhsvVar = this.f34210a.f34194c;
        if (zzhsvVar == zzhsv.f34189e) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhsvVar == zzhsv.f34188d || zzhsvVar == zzhsv.f34187c) {
            zzhxcVarA = zzhjf.a(this.f34212c.intValue());
        } else {
            if (zzhsvVar != zzhsv.f34186b) {
                throw new IllegalStateException("Unknown RsaSsaPkcs1Parameters.Variant: ".concat(String.valueOf(this.f34210a.f34194c)));
            }
            zzhxcVarA = zzhjf.b(this.f34212c.intValue());
        }
        return new zzhta(this.f34210a, this.f34211b, zzhxcVarA, this.f34212c);
    }
}
