package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdvo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdwh f28638a;

    public zzdvo(zzdwh zzdwhVar) {
        this.f28638a = zzdwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzdwh zzdwhVar = this.f28638a;
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P5)).booleanValue() ? Collections.singleton(new zzdij(new zzdwg((zzbfj) zzdwhVar.f28660a.zzb(), zzdwhVar.f28661b.zzb()), zzgywVar)) : Collections.EMPTY_SET;
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
