package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhcc {

    /* renamed from: a, reason: collision with root package name */
    public zzhck f33513a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33514b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33515c = null;

    public final zzhcd a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarB;
        zzhck zzhckVar = this.f33513a;
        if (zzhckVar == null || (zzhxeVar = this.f33514b) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhckVar.f33536a != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhckVar.a() && this.f33515c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33513a.a() && this.f33515c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhcj zzhcjVar = this.f33513a.f33537b;
        if (zzhcjVar == zzhcj.f33534d) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzhcjVar == zzhcj.f33533c) {
            zzhxcVarB = zzhjf.a(this.f33515c.intValue());
        } else {
            if (zzhcjVar != zzhcj.f33532b) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.f33513a.f33537b)));
            }
            zzhxcVarB = zzhjf.b(this.f33515c.intValue());
        }
        return new zzhcd(this.f33513a, this.f33514b, zzhxcVarB, this.f33515c);
    }
}
