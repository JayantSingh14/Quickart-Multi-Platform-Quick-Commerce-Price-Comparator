package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzeva implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzetx f30396a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30397b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30398c;

    public zzeva(zzetx zzetxVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30396a = zzetxVar;
        this.f30397b = zzijfVar;
        this.f30398c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzetv zzetvVarZzb = this.f30396a.zzb();
        Clock clock = (Clock) this.f30397b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzetvVarZzb, ((Long) zzbhz.f25108b.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30398c.zzb());
    }
}
