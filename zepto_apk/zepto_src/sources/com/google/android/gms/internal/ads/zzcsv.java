package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzcsv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27070a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27071b;

    /* renamed from: c, reason: collision with root package name */
    public final zzejz f27072c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeoc f27073d;

    public zzcsv(zzijf zzijfVar, zzijf zzijfVar2, zzejz zzejzVar, zzeoc zzeocVar) {
        this.f27070a = zzijfVar;
        this.f27071b = zzijfVar2;
        this.f27072c = zzejzVar;
        this.f27073d = zzeocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f27070a.zzb();
        zzgyw zzgywVar = (zzgyw) this.f27071b.zzb();
        zzejz zzejzVar = this.f27072c;
        return new zzeoi(zzfmuVar, zzgywVar, this.f27073d.zzb(), new zzejy((Context) zzejzVar.f29517a.zzb(), (zzcsq) zzejzVar.f29518b.f34899a));
    }
}
