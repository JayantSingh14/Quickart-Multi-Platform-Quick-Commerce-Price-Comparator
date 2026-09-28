package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhcl {

    /* renamed from: a, reason: collision with root package name */
    public zzhct f33538a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33539b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33540c = null;

    public final zzhcm a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarB;
        zzhct zzhctVar = this.f33538a;
        if (zzhctVar == null || (zzhxeVar = this.f33539b) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhctVar.f33558a != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhctVar.a() && this.f33540c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33538a.a() && this.f33540c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhcs zzhcsVar = this.f33538a.f33559b;
        if (zzhcsVar == zzhcs.f33556d) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzhcsVar == zzhcs.f33555c) {
            zzhxcVarB = zzhjf.a(this.f33540c.intValue());
        } else {
            if (zzhcsVar != zzhcs.f33554b) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.f33538a.f33559b)));
            }
            zzhxcVarB = zzhjf.b(this.f33540c.intValue());
        }
        return new zzhcm(this.f33538a, this.f33539b, zzhxcVarB, this.f33540c);
    }
}
