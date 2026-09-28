package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzcts implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27130a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f27131b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27132c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdab f27133d;

    public zzcts(zzctj zzctjVar, zzijf zzijfVar, zzcmg zzcmgVar, zzcwb zzcwbVar, zzdab zzdabVar) {
        this.f27130a = zzijfVar;
        this.f27131b = zzcmgVar;
        this.f27132c = zzcwbVar;
        this.f27133d = zzdabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzdij(new zzcti((Context) this.f27130a.zzb(), this.f27131b.a(), this.f27132c.a(), this.f27133d.a()), zzcdo.f25988g);
    }
}
