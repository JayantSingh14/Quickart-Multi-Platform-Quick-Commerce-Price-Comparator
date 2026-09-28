package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfbi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfcd f30808a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30809b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30810c;

    public zzfbi(zzfcd zzfcdVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30808a = zzfcdVar;
        this.f30809b = zzijfVar;
        this.f30810c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzijo.a(this.f30808a.f30834a.f30832a.f25723d);
        new zzbem();
        zzcda zzcdaVar = (zzcda) this.f30809b.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30810c.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfbg(zzcdaVar, scheduledExecutorService, zzgywVar);
    }
}
