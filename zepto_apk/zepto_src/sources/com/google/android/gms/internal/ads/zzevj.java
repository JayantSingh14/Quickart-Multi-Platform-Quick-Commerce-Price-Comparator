package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzevj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzezn f30411a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30412b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30413c;

    public zzevj(zzezn zzeznVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30411a = zzeznVar;
        this.f30412b = zzijfVar;
        this.f30413c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzezl zzezlVarZzb = this.f30411a.zzb();
        Clock clock = (Clock) this.f30412b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzezlVarZzb, ((Long) zzbhz.f25113g.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30413c.zzb());
    }
}
