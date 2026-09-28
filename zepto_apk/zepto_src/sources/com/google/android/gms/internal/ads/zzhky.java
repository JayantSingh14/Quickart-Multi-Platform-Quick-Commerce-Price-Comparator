package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhky {

    /* renamed from: a, reason: collision with root package name */
    public zzhli f33959a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhxe f33960b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33961c = null;

    public final zzhkz a() throws GeneralSecurityException {
        zzhxe zzhxeVar;
        zzhxc zzhxcVarA;
        zzhli zzhliVar = this.f33959a;
        if (zzhliVar == null || (zzhxeVar = this.f33960b) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhliVar.f33992a != zzhxeVar.f34463a.f34461a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhliVar.a() && this.f33961c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f33959a.a() && this.f33961c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhlh zzhlhVar = this.f33959a.f33994c;
        if (zzhlhVar == zzhlh.f33990e) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhlhVar == zzhlh.f33989d || zzhlhVar == zzhlh.f33988c) {
            zzhxcVarA = zzhjf.a(this.f33961c.intValue());
        } else {
            if (zzhlhVar != zzhlh.f33987b) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.f33959a.f33994c)));
            }
            zzhxcVarA = zzhjf.b(this.f33961c.intValue());
        }
        return new zzhkz(this.f33959a, this.f33960b, zzhxcVarA, this.f33961c);
    }
}
