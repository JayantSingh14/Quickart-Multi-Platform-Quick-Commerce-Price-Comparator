package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhdp extends zzhbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzhdt f33604a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxc f33605b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f33606c;

    public zzhdp(zzhdt zzhdtVar, zzhxc zzhxcVar, Integer num) {
        this.f33604a = zzhdtVar;
        this.f33605b = zzhxcVar;
        this.f33606c = num;
    }

    public static zzhdp d(zzhdt zzhdtVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarB;
        zzhds zzhdsVar = zzhds.f33619c;
        zzhds zzhdsVar2 = zzhdtVar.f33621a;
        if (zzhdsVar2 == zzhdsVar) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzhxcVarB = zzhjf.f33886a;
        } else {
            if (zzhdsVar2 != zzhds.f33618b) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(zzhdsVar2)));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzhxcVarB = zzhjf.b(num.intValue());
        }
        return new zzhdp(zzhdtVar, zzhxcVarB, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f33604a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33606c;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzhxc c() {
        return this.f33605b;
    }
}
