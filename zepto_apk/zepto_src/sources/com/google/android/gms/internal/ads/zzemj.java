package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public final class zzemj extends zzemg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29745a;

    /* renamed from: b, reason: collision with root package name */
    public final zzczs f29746b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeow f29747c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdgk f29748d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdlq f29749e;

    /* renamed from: f, reason: collision with root package name */
    public final zzddl f29750f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f29751g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdfq f29752h;

    /* renamed from: i, reason: collision with root package name */
    public final zzemr f29753i;

    /* renamed from: j, reason: collision with root package name */
    public final zzejl f29754j;

    public zzemj(zzclg zzclgVar, zzczs zzczsVar, zzeow zzeowVar, zzdgk zzdgkVar, zzdlq zzdlqVar, zzddl zzddlVar, FrameLayout frameLayout, zzdfq zzdfqVar, zzemr zzemrVar, zzejl zzejlVar) {
        this.f29745a = zzclgVar;
        this.f29746b = zzczsVar;
        this.f29747c = zzeowVar;
        this.f29748d = zzdgkVar;
        this.f29749e = zzdlqVar;
        this.f29750f = zzddlVar;
        this.f29751g = frameLayout;
        this.f29752h = zzdfqVar;
        this.f29753i = zzemrVar;
        this.f29754j = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemg
    public final zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar) {
        zzczs zzczsVar = this.f29746b;
        zzczsVar.f27512b = zzfikVar;
        zzczsVar.f27513c = bundle;
        zzczsVar.f27515e = new zzczl(zzficVar, zzfhrVar, this.f29753i);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k4)).booleanValue()) {
            zzczsVar.f27516f = this.f29754j;
        }
        zzcug zzcugVarL = this.f29745a.l();
        ((zzcnc) zzcugVarL).f26641e = new zzczt(zzczsVar);
        zzcnc zzcncVar = (zzcnc) zzcugVarL;
        zzcncVar.f26640d = this.f29748d;
        zzcncVar.f26642f = this.f29747c;
        zzcncVar.f26646j = this.f29749e;
        zzcncVar.f26643g = new zzcvc(this.f29750f, this.f29752h);
        zzcncVar.f26645i = new zzcsz(this.f29751g);
        zzcwo zzcwoVarB = zzcncVar.zzh().b();
        return zzcwoVarB.c(zzcwoVarB.b());
    }
}
