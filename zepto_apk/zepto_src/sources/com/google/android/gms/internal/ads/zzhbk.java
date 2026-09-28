package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhbk {

    /* renamed from: a, reason: collision with root package name */
    public zzhbt f33450a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33451b = null;

    /* renamed from: c, reason: collision with root package name */
    public zzhxe f33452c = null;

    /* renamed from: d, reason: collision with root package name */
    public Integer f33453d = null;

    public final zzhbl a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarB;
        zzhbt zzhbtVar = this.f33450a;
        if (zzhbtVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzhxe zzhxeVar2 = this.f33451b;
        if (zzhxeVar2 == null || (zzhxeVar = this.f33452c) == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzhbtVar.f33483a != zzhxeVar2.f34463a.f34461a.length) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzhbtVar.f33484b != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (zzhbtVar.a() && this.f33453d == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33450a.a() && this.f33453d != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhbs zzhbsVar = this.f33450a.f33487e;
        if (zzhbsVar == zzhbs.f33481d) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzhbsVar == zzhbs.f33480c) {
            zzhxcVarB = zzhjf.a(this.f33453d.intValue());
        } else {
            if (zzhbsVar != zzhbs.f33479b) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.f33450a.f33487e)));
            }
            zzhxcVarB = zzhjf.b(this.f33453d.intValue());
        }
        return new zzhbl(this.f33450a, this.f33451b, this.f33452c, zzhxcVarB, this.f33453d);
    }
}
