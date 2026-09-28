package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeut f30445a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30446b;

    public zzevw(zzeut zzeutVar, zzijf zzijfVar) {
        this.f30445a = zzeutVar;
        this.f30446b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f30445a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Bd)).intValue(), (ScheduledExecutorService) this.f30446b.zzb());
    }
}
