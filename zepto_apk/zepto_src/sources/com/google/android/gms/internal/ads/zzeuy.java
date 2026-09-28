package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzeuy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzetg f30381a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30382b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30383c;

    public zzeuy(zzetg zzetgVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30381a = zzetgVar;
        this.f30382b = zzijfVar;
        this.f30383c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzete zzeteVarZzb = this.f30381a.zzb();
        Clock clock = (Clock) this.f30382b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzeteVarZzb, ((Long) zzbhz.f25107a.c()).longValue(), clock, zzgywVar, (zzdxe) this.f30383c.zzb());
    }
}
