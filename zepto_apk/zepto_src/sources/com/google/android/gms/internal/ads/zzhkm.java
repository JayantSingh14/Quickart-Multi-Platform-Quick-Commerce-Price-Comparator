package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhkm {

    /* renamed from: a, reason: collision with root package name */
    public zzhku f33933a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33934b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33935c = null;

    public final zzhkn a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarA;
        zzhku zzhkuVar = this.f33933a;
        if (zzhkuVar == null || (zzhxeVar = this.f33934b) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhkuVar.f33955a != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhkuVar.a() && this.f33935c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33933a.a() && this.f33935c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhkt zzhktVar = this.f33933a.f33957c;
        if (zzhktVar == zzhkt.f33953e) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhktVar == zzhkt.f33952d || zzhktVar == zzhkt.f33951c) {
            zzhxcVarA = zzhjf.a(this.f33935c.intValue());
        } else {
            if (zzhktVar != zzhkt.f33950b) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.f33933a.f33957c)));
            }
            zzhxcVarA = zzhjf.b(this.f33935c.intValue());
        }
        return new zzhkn(this.f33933a, this.f33934b, zzhxcVarA, this.f33935c);
    }
}
