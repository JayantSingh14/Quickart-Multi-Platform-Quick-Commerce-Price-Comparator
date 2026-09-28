package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzflz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f31379a;

    public zzflz(zzijf zzijfVar) {
        this.f31379a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f31379a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfly(scheduledExecutorService, zzgywVar);
    }
}
