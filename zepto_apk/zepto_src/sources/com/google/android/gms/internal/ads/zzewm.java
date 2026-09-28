package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30483a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30484b;

    public zzewm(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30483a = zzijfVar;
        this.f30484b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj((zzeul) this.f30483a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hd)).intValue(), (ScheduledExecutorService) this.f30484b.zzb());
    }
}
