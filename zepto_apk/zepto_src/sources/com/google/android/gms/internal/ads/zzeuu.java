package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzeuu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeue f30369a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30370b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30371c;

    public zzeuu(zzeue zzeueVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30369a = zzeueVar;
        this.f30370b = zzijfVar;
        this.f30371c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzeue zzeueVar = this.f30369a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzeuc zzeucVar = new zzeuc(zzeueVar.f30341a.a(), zzgywVar);
        Clock clock = (Clock) this.f30370b.zzb();
        zzijo.a(zzgywVar);
        return new zzeul(zzeucVar, ((Long) zzbhz.f25109c.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30371c.zzb());
    }
}
