package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzett f30432a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30433b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30434c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30435d;

    public zzevr(zzett zzettVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30432a = zzettVar;
        this.f30433b = zzijfVar;
        this.f30434c = zzijfVar2;
        this.f30435d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzetr zzetrVarZzb = this.f30432a.zzb();
        zzeul zzeulVar = (zzeul) this.f30433b.zzb();
        List list = (List) this.f30434c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30435d.zzb();
        if (list.contains("54")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.wd)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzetrVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.wd)).intValue(), scheduledExecutorService);
    }
}
