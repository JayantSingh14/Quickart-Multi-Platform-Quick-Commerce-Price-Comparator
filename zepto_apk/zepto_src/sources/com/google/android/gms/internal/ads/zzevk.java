package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzevk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfan f30414a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30415b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30416c;

    public zzevk(zzfan zzfanVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30414a = zzfanVar;
        this.f30415b = zzijfVar;
        this.f30416c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfam zzfamVarZzb = this.f30414a.zzb();
        Clock clock = (Clock) this.f30415b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzfamVarZzb, ((Long) zzbhz.f25114h.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30416c.zzb());
    }
}
