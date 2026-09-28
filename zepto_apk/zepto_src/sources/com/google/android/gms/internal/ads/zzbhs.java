package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzbhs implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f25094a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f25095b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f25096c;

    public zzbhs(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f25094a = zzclpVar;
        this.f25095b = zzijfVar;
        this.f25096c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        this.f25094a.a();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f25095b.zzb();
        new zzbht();
        return new zzbhr(scheduledExecutorService);
    }
}
