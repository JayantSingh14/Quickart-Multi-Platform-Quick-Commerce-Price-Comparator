package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcub implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzert f27155a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27156b;

    public zzcub(zzert zzertVar, zzijf zzijfVar) {
        this.f27155a = zzertVar;
        this.f27156b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f27155a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Cd)).intValue(), (ScheduledExecutorService) this.f27156b.zzb());
    }
}
