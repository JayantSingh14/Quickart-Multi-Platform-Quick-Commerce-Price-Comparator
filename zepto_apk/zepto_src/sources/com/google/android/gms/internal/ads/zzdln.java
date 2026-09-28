package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbfp;

/* loaded from: classes4.dex */
public final class zzdln implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdkn f27894a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f27895b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27896c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdkb f27897d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijg f27898e;

    public zzdln(zzdkn zzdknVar, zzclp zzclpVar, zzijf zzijfVar, zzdkb zzdkbVar, zzijg zzijgVar) {
        this.f27894a = zzdknVar;
        this.f27895b = zzclpVar;
        this.f27896c = zzijfVar;
        this.f27897d = zzdkbVar;
        this.f27898e = zzijgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdkn zzdknVar = this.f27894a;
        zzcbt zzcbtVar = new zzcbt(zzdknVar.f27856a.a(), zzdknVar.f27857b.a().f31219g);
        Context contextA = this.f27895b.a();
        zzcbw zzcbwVar = (zzcbw) this.f27896c.zzb();
        zzcir zzcirVar = this.f27897d.f27840a.f27834b;
        return new zzdlm(zzcbtVar, contextA, zzcbwVar, zzcirVar == null ? null : zzcirVar.k(), (zzbfp.zza.EnumC0023zza) this.f27898e.zzb());
    }
}
