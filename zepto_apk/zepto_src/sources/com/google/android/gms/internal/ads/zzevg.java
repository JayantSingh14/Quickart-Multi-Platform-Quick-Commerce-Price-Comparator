package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzevg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30404a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30405b;

    public zzevg(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30404a = zzijfVar;
        this.f30405b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzexq zzexqVar = new zzexq(zzgywVar);
        Clock clock = (Clock) this.f30404a.zzb();
        zzijo.a(zzgywVar);
        return new zzeul(zzexqVar, ((Long) zzbhz.f25112f.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30405b.zzb());
    }
}
