package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30449a;

    public zzevy(zzijf zzijfVar) {
        this.f30449a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzewt(zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.rd)).intValue(), (ScheduledExecutorService) this.f30449a.zzb());
    }
}
