package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzemn extends zzemg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29777a;

    /* renamed from: b, reason: collision with root package name */
    public final zzczs f29778b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdgk f29779c;

    /* renamed from: d, reason: collision with root package name */
    public final zzemr f29780d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfid f29781e;

    /* renamed from: f, reason: collision with root package name */
    public final zzejl f29782f;

    public zzemn(zzclg zzclgVar, zzczs zzczsVar, zzdgk zzdgkVar, zzfid zzfidVar, zzemr zzemrVar, zzejl zzejlVar) {
        this.f29777a = zzclgVar;
        this.f29778b = zzczsVar;
        this.f29779c = zzdgkVar;
        this.f29781e = zzfidVar;
        this.f29780d = zzemrVar;
        this.f29782f = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemg
    public final zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar) {
        zzfid zzfidVar;
        zzczs zzczsVar = this.f29778b;
        zzczsVar.f27512b = zzfikVar;
        zzczsVar.f27513c = bundle;
        zzczsVar.f27515e = new zzczl(zzficVar, zzfhrVar, this.f29780d);
        zzbgb zzbgbVar = zzbgk.j4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && (zzfidVar = this.f29781e) != null) {
            zzczsVar.f27514d = zzfidVar;
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.k4)).booleanValue()) {
            zzczsVar.f27516f = this.f29782f;
        }
        zzdti zzdtiVarS = this.f29777a.s();
        ((zzcny) zzdtiVarS).f26767e = new zzczt(zzczsVar);
        zzcny zzcnyVar = (zzcny) zzdtiVarS;
        zzcnyVar.f26766d = this.f29779c;
        zzcwo zzcwoVarZza = ((zzcnz) zzcnyVar.zzh()).zza();
        return zzcwoVarZza.c(zzcwoVarZza.b());
    }
}
