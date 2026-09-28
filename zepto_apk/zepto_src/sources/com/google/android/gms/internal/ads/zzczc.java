package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzczc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27452a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcwb f27453b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27454c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcwc f27455d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27456e;

    public zzczc(zzijf zzijfVar, zzcwb zzcwbVar, zzijf zzijfVar2, zzcwc zzcwcVar, zzijf zzijfVar3) {
        this.f27452a = zzijfVar;
        this.f27453b = zzcwbVar;
        this.f27454c = zzijfVar2;
        this.f27455d = zzcwcVar;
        this.f27456e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdbc zzdbcVar = (zzdbc) this.f27452a.zzb();
        zzfhr zzfhrVarA = this.f27453b.a();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f27454c.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzczb(zzdbcVar, zzfhrVarA, scheduledExecutorService, zzgywVar, this.f27455d.f27273a.f27271c, (zzddd) this.f27456e.zzb());
    }
}
