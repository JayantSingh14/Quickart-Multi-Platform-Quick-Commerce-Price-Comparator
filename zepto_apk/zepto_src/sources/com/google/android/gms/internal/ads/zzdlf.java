package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzdlf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27871a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27872b;

    /* renamed from: c, reason: collision with root package name */
    public final zzelk f27873c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeoc f27874d;

    public zzdlf(zzijf zzijfVar, zzijf zzijfVar2, zzelk zzelkVar, zzeoc zzeocVar) {
        this.f27871a = zzijfVar;
        this.f27872b = zzijfVar2;
        this.f27873c = zzelkVar;
        this.f27874d = zzeocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f27871a.zzb();
        zzgyw zzgywVar = (zzgyw) this.f27872b.zzb();
        zzelk zzelkVar = this.f27873c;
        return new zzeoi(zzfmuVar, zzgywVar, this.f27874d.zzb(), new zzelj((Context) zzelkVar.f29645a.zzb(), (zzdkz) zzelkVar.f29646b.f34899a));
    }
}
