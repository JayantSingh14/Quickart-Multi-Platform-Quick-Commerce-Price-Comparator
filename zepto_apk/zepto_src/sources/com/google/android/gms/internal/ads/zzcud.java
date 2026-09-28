package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcud implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexh f27159a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27160b;

    public zzcud(zzexh zzexhVar, zzijf zzijfVar) {
        this.f27159a = zzexhVar;
        this.f27160b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f27159a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Dd)).intValue(), (ScheduledExecutorService) this.f27160b.zzb());
    }
}
