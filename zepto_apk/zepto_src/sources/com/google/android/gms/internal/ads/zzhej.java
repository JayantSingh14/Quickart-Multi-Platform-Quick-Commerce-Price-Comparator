package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhej extends zzhbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzheo f33657a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxe f33658b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhxc f33659c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f33660d;

    public zzhej(zzheo zzheoVar, zzhxe zzhxeVar, zzhxc zzhxcVar, Integer num) {
        this.f33657a = zzheoVar;
        this.f33658b = zzhxeVar;
        this.f33659c = zzhxcVar;
        this.f33660d = num;
    }

    public static zzhej d(zzheo zzheoVar, zzhxe zzhxeVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarB;
        zzhen zzhenVar = zzhen.f33666c;
        zzhen zzhenVar2 = zzheoVar.f33668a;
        if (zzhenVar2 != zzhenVar && num == null) {
            String str = zzhenVar2.f33667a;
            throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(str.length() + 62), "For given Variant ", str, " the value of idRequirement must be non-null"));
        }
        if (zzhenVar2 == zzhenVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        zzhxc zzhxcVar = zzhxeVar.f34463a;
        if (zzhxcVar.f34461a.length != 32) {
            int length = zzhxcVar.f34461a.length;
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 68), length, "XAesGcmKey key must be constructed with key of length 32 bytes, not "));
        }
        if (zzhenVar2 == zzhenVar) {
            zzhxcVarB = zzhjf.f33886a;
        } else {
            if (zzhenVar2 != zzhen.f33665b) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzhenVar2.f33667a));
            }
            zzhxcVarB = zzhjf.b(num.intValue());
        }
        return new zzhej(zzheoVar, zzhxeVar, zzhxcVarB, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f33657a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33660d;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzhxc c() {
        return this.f33659c;
    }
}
