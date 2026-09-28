package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevs implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzetx f30436a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30437b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30438c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30439d;

    public zzevs(zzetx zzetxVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30436a = zzetxVar;
        this.f30437b = zzijfVar;
        this.f30438c = zzijfVar2;
        this.f30439d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzetv zzetvVarZzb = this.f30436a.zzb();
        zzeul zzeulVar = (zzeul) this.f30437b.zzb();
        List list = (List) this.f30438c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30439d.zzb();
        if (list.contains("13")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vd)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzetvVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vd)).intValue(), scheduledExecutorService);
    }
}
