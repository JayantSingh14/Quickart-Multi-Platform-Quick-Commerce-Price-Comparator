package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeyt f30473a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30474b;

    public zzewi(zzeyt zzeytVar, zzijf zzijfVar) {
        this.f30473a = zzeytVar;
        this.f30474b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f30473a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ld)).intValue(), (ScheduledExecutorService) this.f30474b.zzb());
    }
}
