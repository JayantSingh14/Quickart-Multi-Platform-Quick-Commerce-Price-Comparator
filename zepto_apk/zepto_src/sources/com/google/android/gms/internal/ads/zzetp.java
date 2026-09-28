package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzetp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30304a;

    /* renamed from: b, reason: collision with root package name */
    public final zzczy f30305b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30306c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30307d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f30308e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdab f30309f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f30310g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f30311h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f30312i;

    public zzetp(zzclp zzclpVar, zzczy zzczyVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzdab zzdabVar, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6) {
        this.f30304a = zzclpVar;
        this.f30305b = zzczyVar;
        this.f30306c = zzijfVar;
        this.f30307d = zzijfVar2;
        this.f30308e = zzijfVar3;
        this.f30309f = zzdabVar;
        this.f30310g = zzijfVar4;
        this.f30311h = zzijfVar5;
        this.f30312i = zzijfVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f30304a.a();
        String str = ((zzcxa) this.f30305b.f27531a.zzb()).f27336b.f25900e;
        zzijo.a(str);
        return new zzetn(contextA, str, (String) this.f30306c.zzb(), (zzcxa) this.f30307d.zzb(), (zzfjs) this.f30308e.zzb(), this.f30309f.a(), (zzdwy) this.f30310g.zzb(), (zzcxo) this.f30311h.zzb(), ((Long) this.f30312i.zzb()).longValue());
    }
}
