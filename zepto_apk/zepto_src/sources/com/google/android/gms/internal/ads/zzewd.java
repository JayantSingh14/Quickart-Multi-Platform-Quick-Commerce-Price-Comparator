package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30461a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30462b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30463c;

    public zzewd(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30461a = zzijfVar;
        this.f30462b = zzijfVar2;
        this.f30463c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzexq zzexqVar = new zzexq(zzgywVar);
        zzeul zzeulVar = (zzeul) this.f30461a.zzb();
        List list = (List) this.f30462b.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30463c.zzb();
        if (list.contains("24")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.od)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzexqVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.od)).intValue(), scheduledExecutorService);
    }
}
