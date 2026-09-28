package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzdlp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijk f27904a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijk f27905b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijk f27906c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27907d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdlt f27908e;

    public zzdlp(zzijk zzijkVar, zzijk zzijkVar2, zzijk zzijkVar3, zzijf zzijfVar, zzdlt zzdltVar) {
        this.f27904a = zzijkVar;
        this.f27905b = zzijkVar2;
        this.f27906c = zzijkVar3;
        this.f27907d = zzijfVar;
        this.f27908e = zzdltVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Map mapZzb = this.f27904a.zzb();
        Map mapZzb2 = this.f27905b.zzb();
        Map mapZzb3 = this.f27906c.zzb();
        zzdnw zzdnwVar = this.f27908e.f27913a.f27909a;
        zzijo.a(zzdnwVar);
        return new zzdlo(mapZzb, mapZzb2, mapZzb3, this.f27907d, zzdnwVar);
    }
}
