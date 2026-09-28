package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzexh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcta f30524a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30525b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijs f30526c;

    public zzexh(zzcta zzctaVar, zzijf zzijfVar, zzijs zzijsVar) {
        this.f30524a = zzctaVar;
        this.f30525b = zzijfVar;
        this.f30526c = zzijsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzexf zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzexf(zzgywVar, this.f30524a.f27095a.f27081a, (Context) this.f30525b.zzb(), this.f30526c.zzb());
    }
}
