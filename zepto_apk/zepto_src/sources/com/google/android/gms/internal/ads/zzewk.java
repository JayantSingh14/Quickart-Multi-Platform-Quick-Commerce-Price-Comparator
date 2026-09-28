package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzezn f30477a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30478b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30479c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30480d;

    public zzewk(zzezn zzeznVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30477a = zzeznVar;
        this.f30478b = zzijfVar;
        this.f30479c = zzijfVar2;
        this.f30480d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzezl zzezlVarZzb = this.f30477a.zzb();
        zzeul zzeulVar = (zzeul) this.f30478b.zzb();
        List list = (List) this.f30479c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30480d.zzb();
        if (list.contains("35")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.jd)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzezlVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.jd)).intValue(), scheduledExecutorService);
    }
}
