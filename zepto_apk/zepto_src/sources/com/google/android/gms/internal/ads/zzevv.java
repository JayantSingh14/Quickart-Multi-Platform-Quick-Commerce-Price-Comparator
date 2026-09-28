package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30444a;

    public zzevv(zzijf zzijfVar) {
        this.f30444a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Object zzgvoVar;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzeun zzeunVar = new zzeun(zzgywVar);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30444a.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.M4)).booleanValue()) {
            zzeyj zzeyjVar = new zzeyj(zzeunVar, ((Integer) r3.f21153c.a(zzbgk.N4)).intValue(), scheduledExecutorService);
            int i2 = zzgtn.f33203c;
            zzgvoVar = new zzgvo(zzeyjVar);
        } else {
            int i3 = zzgtn.f33203c;
            zzgvoVar = zzgve.f33249j;
        }
        zzijo.a(zzgvoVar);
        return zzgvoVar;
    }
}
