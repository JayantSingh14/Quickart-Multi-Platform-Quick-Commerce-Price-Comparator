package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhrv extends zzhtu {

    /* renamed from: a, reason: collision with root package name */
    public final zzhro f34137a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxc f34138b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhxc f34139c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f34140d;

    public zzhrv(zzhro zzhroVar, zzhxc zzhxcVar, zzhxc zzhxcVar2, Integer num) {
        this.f34137a = zzhroVar;
        this.f34138b = zzhxcVar;
        this.f34139c = zzhxcVar2;
        this.f34140d = num;
    }

    public static zzhrv d(zzhrn zzhrnVar, zzhxc zzhxcVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarA;
        zzhro zzhroVar = new zzhro(zzhrnVar);
        zzhrn zzhrnVar2 = zzhrn.f34122e;
        if (!zzhrnVar.equals(zzhrnVar2) && num == null) {
            String str = zzhrnVar.f34123a;
            throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(str.length() + 62), "For given Variant ", str, " the value of idRequirement must be non-null"));
        }
        if (zzhrnVar.equals(zzhrnVar2) && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        byte[] bArr = zzhxcVar.f34461a;
        if (bArr.length != 32) {
            int length = bArr.length;
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 65), length, "Ed25519 key must be constructed with key of length 32 bytes, not "));
        }
        zzhrn zzhrnVar3 = zzhroVar.f34124a;
        if (zzhrnVar3 == zzhrnVar2) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhrnVar3 == zzhrn.f34120c || zzhrnVar3 == zzhrn.f34121d) {
            zzhxcVarA = zzhjf.a(num.intValue());
        } else {
            if (zzhrnVar3 != zzhrn.f34119b) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzhrnVar3.f34123a));
            }
            zzhxcVarA = zzhjf.b(num.intValue());
        }
        return new zzhrv(zzhroVar, zzhxcVar, zzhxcVarA, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhtu, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f34137a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f34140d;
    }

    @Override // com.google.android.gms.internal.ads.zzhtu
    public final zzhxc c() {
        return this.f34139c;
    }
}
