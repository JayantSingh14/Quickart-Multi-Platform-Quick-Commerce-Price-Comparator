package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeml extends zzemg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29765a;

    /* renamed from: b, reason: collision with root package name */
    public final zzczs f29766b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeow f29767c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdgk f29768d;

    /* renamed from: e, reason: collision with root package name */
    public final zzemr f29769e;

    /* renamed from: f, reason: collision with root package name */
    public final zzejl f29770f;

    public zzeml(zzclg zzclgVar, zzczs zzczsVar, zzeow zzeowVar, zzdgk zzdgkVar, zzemr zzemrVar, zzejl zzejlVar) {
        this.f29765a = zzclgVar;
        this.f29766b = zzczsVar;
        this.f29767c = zzeowVar;
        this.f29768d = zzdgkVar;
        this.f29769e = zzemrVar;
        this.f29770f = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemg
    public final zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar) {
        zzczs zzczsVar = this.f29766b;
        zzczsVar.f27512b = zzfikVar;
        zzczsVar.f27513c = bundle;
        zzczsVar.f27515e = new zzczl(zzficVar, zzfhrVar, this.f29769e);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k4)).booleanValue()) {
            zzczsVar.f27516f = this.f29770f;
        }
        zzdky zzdkyVarP = this.f29765a.p();
        ((zzcnn) zzdkyVarP).f26721e = new zzczt(zzczsVar);
        zzcnn zzcnnVar = (zzcnn) zzdkyVarP;
        zzcnnVar.f26720d = this.f29768d;
        zzcnnVar.f26722f = this.f29767c;
        zzcwo zzcwoVarB = zzcnnVar.zzh().b();
        return zzcwoVarB.c(zzcwoVarB.b());
    }
}
