package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfan f30485a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30486b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30487c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30488d;

    public zzewn(zzfan zzfanVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30485a = zzfanVar;
        this.f30486b = zzijfVar;
        this.f30487c = zzijfVar2;
        this.f30488d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfam zzfamVarZzb = this.f30485a.zzb();
        zzeul zzeulVar = (zzeul) this.f30486b.zzb();
        List list = (List) this.f30487c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30488d.zzb();
        if (list.contains("39")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.gd)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzfamVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.gd)).intValue(), scheduledExecutorService);
    }
}
