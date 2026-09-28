package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzesu f30424a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30425b;

    public zzevo(zzesu zzesuVar, zzijf zzijfVar) {
        this.f30424a = zzesuVar;
        this.f30425b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f30424a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ad)).intValue(), (ScheduledExecutorService) this.f30425b.zzb());
    }
}
