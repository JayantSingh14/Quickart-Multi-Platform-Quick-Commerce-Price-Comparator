package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzdto implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28526a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28527b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeni f28528c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeoc f28529d;

    public zzdto(zzijf zzijfVar, zzijf zzijfVar2, zzeni zzeniVar, zzeoc zzeocVar) {
        this.f28526a = zzijfVar;
        this.f28527b = zzijfVar2;
        this.f28528c = zzeniVar;
        this.f28529d = zzeocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f28526a.zzb();
        zzgyw zzgywVar = (zzgyw) this.f28527b.zzb();
        zzeni zzeniVar = this.f28528c;
        return new zzeoi(zzfmuVar, zzgywVar, this.f28529d.zzb(), new zzenh((Context) zzeniVar.f29865a.zzb(), (zzdtj) zzeniVar.f29866b.f34899a));
    }
}
