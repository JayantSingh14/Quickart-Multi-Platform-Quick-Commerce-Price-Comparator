package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeyh f30468a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30469b;

    public zzewg(zzeyh zzeyhVar, zzijf zzijfVar) {
        this.f30468a = zzeyhVar;
        this.f30469b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzeyh zzeyhVar = this.f30468a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzeyf(zzgywVar, (zzdyh) zzeyhVar.f30574a.zzb()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pd)).intValue(), (ScheduledExecutorService) this.f30469b.zzb());
    }
}
