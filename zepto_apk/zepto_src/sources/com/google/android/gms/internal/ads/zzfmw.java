package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfmw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f31426a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfmx f31427b;

    public zzfmw(zzijf zzijfVar, zzfmx zzfmxVar) {
        this.f31426a = zzijfVar;
        this.f31427b = zzfmxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfmu(zzgywVar, (ScheduledExecutorService) this.f31426a.zzb(), new zzfmt(this.f31427b.f31428a.zzb()));
    }
}
