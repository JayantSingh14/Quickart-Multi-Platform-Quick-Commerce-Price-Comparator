package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhep extends zzhbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzhev f33670a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxe f33671b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhxc f33672c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f33673d;

    public zzhep(zzhev zzhevVar, zzhxe zzhxeVar, zzhxc zzhxcVar, Integer num) {
        this.f33670a = zzhevVar;
        this.f33671b = zzhxeVar;
        this.f33672c = zzhxcVar;
        this.f33673d = num;
    }

    public static zzhep d(zzheu zzheuVar, zzhxe zzhxeVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarB;
        zzheu zzheuVar2 = zzheu.f33683d;
        if (zzheuVar != zzheuVar2 && num == null) {
            String str = zzheuVar.f33684a;
            throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(str.length() + 62), "For given Variant ", str, " the value of idRequirement must be non-null"));
        }
        if (zzheuVar == zzheuVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        zzhxc zzhxcVar = zzhxeVar.f34463a;
        if (zzhxcVar.f34461a.length != 32) {
            int length = zzhxcVar.f34461a.length;
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 75), length, "XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzhev zzhevVar = new zzhev(zzheuVar);
        zzheu zzheuVar3 = zzhevVar.f33685a;
        if (zzheuVar3 == zzheuVar2) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzheuVar3 == zzheu.f33682c) {
            zzhxcVarB = zzhjf.a(num.intValue());
        } else {
            if (zzheuVar3 != zzheu.f33681b) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzheuVar3.f33684a));
            }
            zzhxcVarB = zzhjf.b(num.intValue());
        }
        return new zzhep(zzhevVar, zzhxeVar, zzhxcVarB, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f33670a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33673d;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzhxc c() {
        return this.f33672c;
    }
}
