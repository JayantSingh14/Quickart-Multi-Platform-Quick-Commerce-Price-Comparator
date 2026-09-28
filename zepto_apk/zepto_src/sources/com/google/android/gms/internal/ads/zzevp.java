package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzesy f30426a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30427b;

    public zzevp(zzesy zzesyVar, zzijf zzijfVar) {
        this.f30426a = zzesyVar;
        this.f30427b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzesy zzesyVar = this.f30426a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzesw(zzesyVar.f30259a.a(), zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Id)).intValue(), (ScheduledExecutorService) this.f30427b.zzb());
    }
}
