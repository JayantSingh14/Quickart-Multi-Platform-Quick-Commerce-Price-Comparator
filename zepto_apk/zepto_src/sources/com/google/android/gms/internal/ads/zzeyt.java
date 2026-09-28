package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzeyt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30605a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdab f30606b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcmg f30607c;

    public zzeyt(zzclp zzclpVar, zzdab zzdabVar, zzcmg zzcmgVar) {
        this.f30605a = zzclpVar;
        this.f30606b = zzdabVar;
        this.f30607c = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzeyr zzb() {
        Context contextA = this.f30605a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyr(contextA, zzgywVar, this.f30606b.a(), this.f30607c.a());
    }
}
