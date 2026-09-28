package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* loaded from: classes4.dex */
public final class zzexz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdab f30555a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30556b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclj f30557c;

    public zzexz(zzdab zzdabVar, zzijf zzijfVar, zzclj zzcljVar) {
        this.f30555a = zzdabVar;
        this.f30556b = zzijfVar;
        this.f30557c = zzcljVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzexx(zzgywVar, this.f30555a.a(), (PackageInfo) this.f30556b.zzb(), this.f30557c.zzb());
    }
}
