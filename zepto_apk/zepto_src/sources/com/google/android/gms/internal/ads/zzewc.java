package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexo f30459a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30460b;

    public zzewc(zzexo zzexoVar, zzijf zzijfVar) {
        this.f30459a = zzexoVar;
        this.f30460b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzexo zzexoVar = this.f30459a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzexm(zzgywVar, (zzeak) zzexoVar.f30540a.zzb()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.qd)).intValue(), (ScheduledExecutorService) this.f30460b.zzb());
    }
}
