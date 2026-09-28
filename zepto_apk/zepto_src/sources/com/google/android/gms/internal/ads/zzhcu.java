package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhcu extends zzhbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzhcz f33560a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxe f33561b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhxc f33562c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f33563d;

    public zzhcu(zzhcz zzhczVar, zzhxe zzhxeVar, zzhxc zzhxcVar, Integer num) {
        this.f33560a = zzhczVar;
        this.f33561b = zzhxeVar;
        this.f33562c = zzhxcVar;
        this.f33563d = num;
    }

    public static zzhcu d(zzhcy zzhcyVar, zzhxe zzhxeVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarB;
        zzhcy zzhcyVar2 = zzhcy.f33571d;
        if (zzhcyVar != zzhcyVar2 && num == null) {
            String str = zzhcyVar.f33572a;
            throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(str.length() + 62), "For given Variant ", str, " the value of idRequirement must be non-null"));
        }
        if (zzhcyVar == zzhcyVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        zzhxc zzhxcVar = zzhxeVar.f34463a;
        if (zzhxcVar.f34461a.length != 32) {
            int length = zzhxcVar.f34461a.length;
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 74), length, "ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzhcz zzhczVar = new zzhcz(zzhcyVar);
        zzhcy zzhcyVar3 = zzhczVar.f33573a;
        if (zzhcyVar3 == zzhcyVar2) {
            zzhxcVarB = zzhjf.f33886a;
        } else if (zzhcyVar3 == zzhcy.f33570c) {
            zzhxcVarB = zzhjf.a(num.intValue());
        } else {
            if (zzhcyVar3 != zzhcy.f33569b) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzhcyVar3.f33572a));
            }
            zzhxcVarB = zzhjf.b(num.intValue());
        }
        return new zzhcu(zzhczVar, zzhxeVar, zzhxcVarB, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f33560a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33563d;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzhxc c() {
        return this.f33562c;
    }
}
