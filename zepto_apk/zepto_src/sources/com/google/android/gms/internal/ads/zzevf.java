package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzevf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexk f30401a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30402b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30403c;

    public zzevf(zzexk zzexkVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30401a = zzexkVar;
        this.f30402b = zzijfVar;
        this.f30403c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzexi zzexiVarZzb = this.f30401a.zzb();
        Clock clock = (Clock) this.f30402b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzexiVarZzb, ((Long) zzbhz.f25111e.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30403c.zzb());
    }
}
