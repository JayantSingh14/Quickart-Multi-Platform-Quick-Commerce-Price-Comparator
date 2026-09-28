package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcuc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeua f27157a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27158b;

    public zzcuc(zzeua zzeuaVar, zzijf zzijfVar) {
        this.f27157a = zzeuaVar;
        this.f27158b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(new zzety(this.f27157a.f30335a.a()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Hd)).intValue(), (ScheduledExecutorService) this.f27158b.zzb());
    }
}
