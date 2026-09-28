package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzeuw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfaj f30375a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30376b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30377c;

    public zzeuw(zzfaj zzfajVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30375a = zzfajVar;
        this.f30376b = zzijfVar;
        this.f30377c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfaj zzfajVar = this.f30375a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzfai zzfaiVar = new zzfai(zzgywVar, zzfajVar.f30748a.a(), (zzebp) zzfajVar.f30749b.zzb());
        Clock clock = (Clock) this.f30376b.zzb();
        zzijo.a(zzgywVar);
        return new zzeul(zzfaiVar, ((Long) zzbhz.f25110d.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30377c.zzb());
    }
}
