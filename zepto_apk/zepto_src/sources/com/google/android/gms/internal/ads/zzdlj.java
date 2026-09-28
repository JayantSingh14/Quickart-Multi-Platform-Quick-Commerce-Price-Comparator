package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzdlj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f27881a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdku f27882b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27883c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcmg f27884d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27885e;

    public zzdlj(zzclp zzclpVar, zzdku zzdkuVar, zzcwb zzcwbVar, zzcmg zzcmgVar, zzijf zzijfVar) {
        this.f27881a = zzclpVar;
        this.f27882b = zzdkuVar;
        this.f27883c = zzcwbVar;
        this.f27884d = zzcmgVar;
        this.f27885e = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f27881a.a();
        zzdjw zzdjwVar = this.f27882b.f27863a;
        return new zzdli(contextA, zzdjwVar.f27834b, this.f27883c.a(), this.f27884d.a(), (zzeiz) this.f27885e.zzb());
    }
}
