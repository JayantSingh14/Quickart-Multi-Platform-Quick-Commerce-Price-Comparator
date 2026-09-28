package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexk f30455a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30456b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30457c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30458d;

    public zzewb(zzexk zzexkVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f30455a = zzexkVar;
        this.f30456b = zzijfVar;
        this.f30457c = zzijfVar2;
        this.f30458d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzexi zzexiVarZzb = this.f30455a.zzb();
        zzeul zzeulVar = (zzeul) this.f30456b.zzb();
        List list = (List) this.f30457c.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30458d.zzb();
        if (list.contains("60")) {
            return new zzeyj(zzeulVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Wd)).intValue(), scheduledExecutorService);
        }
        return new zzeyj(zzexiVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Wd)).intValue(), scheduledExecutorService);
    }
}
