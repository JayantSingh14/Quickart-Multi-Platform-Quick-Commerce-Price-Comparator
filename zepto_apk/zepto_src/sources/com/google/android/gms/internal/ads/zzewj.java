package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzezj f30475a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30476b;

    public zzewj(zzezj zzezjVar, zzijf zzijfVar) {
        this.f30475a = zzezjVar;
        this.f30476b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzezj zzezjVar = this.f30475a;
        zzcbw zzcbwVar = (zzcbw) zzezjVar.f30669a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzezh(zzcbwVar, zzgywVar, zzezjVar.f30670b.a()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.kd)).intValue(), (ScheduledExecutorService) this.f30476b.zzb());
    }
}
