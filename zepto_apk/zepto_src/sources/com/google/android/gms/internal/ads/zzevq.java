package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzetg f30428a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30429b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30430c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30431d;

    public zzevq(zzetg zzetgVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30428a = zzetgVar;
        this.f30429b = zzijfVar;
        this.f30430c = zzijfVar2;
        this.f30431d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzete zzeteVarZzb = this.f30428a.zzb();
        zzeul zzeulVar = (zzeul) this.f30429b.zzb();
        List list = (List) this.f30430c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30431d.zzb();
        if (list.contains("10")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.md)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzeteVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.md)).intValue(), scheduledExecutorService);
    }
}
