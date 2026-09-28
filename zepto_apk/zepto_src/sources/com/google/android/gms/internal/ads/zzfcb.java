package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfcb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30830a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f30831b;

    public zzfcb(zzclp zzclpVar, zzijf zzijfVar) {
        this.f30830a = zzijfVar;
        this.f30831b = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        new zzbxc();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30830a.zzb();
        this.f30831b.a();
        return new zzfbz(scheduledExecutorService);
    }
}
