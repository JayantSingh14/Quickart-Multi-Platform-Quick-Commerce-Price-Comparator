package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeme extends zzemg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29723a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdlq f29724b;

    /* renamed from: c, reason: collision with root package name */
    public final zzczs f29725c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdgk f29726d;

    /* renamed from: e, reason: collision with root package name */
    public final zzemr f29727e;

    /* renamed from: f, reason: collision with root package name */
    public final zzejl f29728f;

    public zzeme(zzclg zzclgVar, zzdlq zzdlqVar, zzczs zzczsVar, zzdgk zzdgkVar, zzemr zzemrVar, zzejl zzejlVar) {
        this.f29723a = zzclgVar;
        this.f29724b = zzdlqVar;
        this.f29725c = zzczsVar;
        this.f29726d = zzdgkVar;
        this.f29727e = zzemrVar;
        this.f29728f = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemg
    public final zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar) {
        zzczs zzczsVar = this.f29725c;
        zzczsVar.f27512b = zzfikVar;
        zzczsVar.f27513c = bundle;
        zzczsVar.f27515e = new zzczl(zzficVar, zzfhrVar, this.f29727e);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k4)).booleanValue()) {
            zzczsVar.f27516f = this.f29728f;
        }
        zzdlu zzdluVarR = this.f29723a.r();
        ((zzcms) zzdluVarR).f26550e = new zzczt(zzczsVar);
        zzcms zzcmsVar = (zzcms) zzdluVarR;
        zzcmsVar.f26549d = this.f29726d;
        zzcmsVar.f26551f = this.f29724b;
        zzcmsVar.f26552g = new zzcsz(null);
        zzcwo zzcwoVarA = zzcmsVar.zzh().a();
        return zzcwoVarA.c(zzcwoVarA.b());
    }
}
