package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhml extends zzhmo {

    /* renamed from: a, reason: collision with root package name */
    public final zzhmm f34034a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxe f34035b;

    public zzhml(zzhmm zzhmmVar, zzhxe zzhxeVar) {
        this.f34034a = zzhmmVar;
        this.f34035b = zzhxeVar;
    }

    public static zzhml c(zzhmm zzhmmVar, zzhxe zzhxeVar) throws GeneralSecurityException {
        if (zzhmmVar.f34036a == zzhxeVar.f34463a.f34461a.length) {
            return new zzhml(zzhmmVar, zzhxeVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.ads.zzhmo, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f34034a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return null;
    }
}
