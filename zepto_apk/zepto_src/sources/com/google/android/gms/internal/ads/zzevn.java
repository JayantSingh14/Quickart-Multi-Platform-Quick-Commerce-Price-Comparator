package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzesk f30422a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30423b;

    public zzevn(zzesk zzeskVar, zzijf zzijfVar) {
        this.f30422a = zzeskVar;
        this.f30423b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f30422a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.yd)).intValue(), (ScheduledExecutorService) this.f30423b.zzb());
    }
}
