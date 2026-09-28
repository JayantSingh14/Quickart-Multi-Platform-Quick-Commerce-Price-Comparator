package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzcup implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27172a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27173b;

    /* renamed from: c, reason: collision with root package name */
    public final zzekq f27174c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeoc f27175d;

    public zzcup(zzijf zzijfVar, zzijf zzijfVar2, zzekq zzekqVar, zzeoc zzeocVar) {
        this.f27172a = zzijfVar;
        this.f27173b = zzijfVar2;
        this.f27174c = zzekqVar;
        this.f27175d = zzeocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f27172a.zzb();
        zzgyw zzgywVar = (zzgyw) this.f27173b.zzb();
        zzekq zzekqVar = this.f27174c;
        return new zzeoi(zzfmuVar, zzgywVar, this.f27175d.zzb(), new zzekp((Context) zzekqVar.f29563a.zzb(), (zzcuh) zzekqVar.f29564b.f34899a));
    }
}
