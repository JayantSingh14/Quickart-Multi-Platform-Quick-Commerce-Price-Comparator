package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30440a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30441b;

    public zzevt(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30440a = zzijfVar;
        this.f30441b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj((zzeul) this.f30440a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ud)).intValue(), (ScheduledExecutorService) this.f30441b.zzb());
    }
}
