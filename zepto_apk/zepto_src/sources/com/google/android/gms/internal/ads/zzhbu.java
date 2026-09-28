package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhbu {

    /* renamed from: a, reason: collision with root package name */
    public zzhcb f33489a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33490b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33491c = null;

    public final zzhbv a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarB;
        zzhcb zzhcbVar = this.f33489a;
        if (zzhcbVar == null || (zzhxeVar = this.f33490b) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhcbVar.f33510a != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhcbVar.a() && this.f33491c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33489a.a() && this.f33491c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhca zzhcaVar = this.f33489a.f33512c;
        if (zzhcaVar == zzhca.f33508d) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzhcaVar == zzhca.f33507c) {
            zzhxcVarB = zzhjf.a(this.f33491c.intValue());
        } else {
            if (zzhcaVar != zzhca.f33506b) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.f33489a.f33512c)));
            }
            zzhxcVarB = zzhjf.b(this.f33491c.intValue());
        }
        return new zzhbv(this.f33489a, this.f33490b, zzhxcVarB, this.f33491c);
    }
}
