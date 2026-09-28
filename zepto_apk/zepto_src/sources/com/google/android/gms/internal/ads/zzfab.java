package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfab implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30721a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f30722b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30723c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30724d;

    public zzfab(zzclp zzclpVar, zzijs zzijsVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30721a = zzclpVar;
        this.f30722b = zzijsVar;
        this.f30723c = zzijfVar;
        this.f30724d = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzfaa zzb() {
        Context contextA = this.f30721a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfaa(contextA, zzgywVar, this.f30722b.zzb(), (zzfno) this.f30723c.zzb(), (zzdxe) this.f30724d.zzb());
    }
}
