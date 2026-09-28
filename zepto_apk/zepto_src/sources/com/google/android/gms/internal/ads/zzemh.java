package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzemh extends zzemg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29735a;

    /* renamed from: b, reason: collision with root package name */
    public final zzczs f29736b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdgk f29737c;

    /* renamed from: d, reason: collision with root package name */
    public final zzemr f29738d;

    /* renamed from: e, reason: collision with root package name */
    public final zzejl f29739e;

    public zzemh(zzclg zzclgVar, zzczs zzczsVar, zzdgk zzdgkVar, zzemr zzemrVar, zzejl zzejlVar) {
        this.f29735a = zzclgVar;
        this.f29736b = zzczsVar;
        this.f29737c = zzdgkVar;
        this.f29738d = zzemrVar;
        this.f29739e = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemg
    public final zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar) {
        zzczs zzczsVar = this.f29736b;
        zzczsVar.f27512b = zzfikVar;
        zzczsVar.f27513c = bundle;
        zzczsVar.f27515e = new zzczl(zzficVar, zzfhrVar, this.f29738d);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k4)).booleanValue()) {
            zzczsVar.f27516f = this.f29739e;
        }
        zzcsp zzcspVarN = this.f29735a.n();
        ((zzcmx) zzcspVarN).f26606e = new zzczt(zzczsVar);
        zzcmx zzcmxVar = (zzcmx) zzcspVarN;
        zzcmxVar.f26605d = this.f29737c;
        zzcwo zzcwoVarZza = ((zzcmy) zzcmxVar.zzh()).zza();
        return zzcwoVarZza.c(zzcwoVarZza.b());
    }
}
