package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdni implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcxr f28008a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28009b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdoe f28010c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijg f28011d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdom f28012e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijp f28013f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdlt f28014g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f28015h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f28016i;

    /* renamed from: j, reason: collision with root package name */
    public final zzijf f28017j;

    /* renamed from: k, reason: collision with root package name */
    public final zzijf f28018k;

    /* renamed from: l, reason: collision with root package name */
    public final zzijf f28019l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdoc f28020m;
    public final zzijf n;
    public final zzcmg o;
    public final zzclp p;
    public final zzijf q;
    public final zzijf r;
    public final zzijf s;

    public zzdni(zzcxr zzcxrVar, zzijf zzijfVar, zzdoe zzdoeVar, zzijg zzijgVar, zzdom zzdomVar, zzijp zzijpVar, zzdlt zzdltVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6, zzdoc zzdocVar, zzijf zzijfVar7, zzcmg zzcmgVar, zzclp zzclpVar, zzijf zzijfVar8, zzijf zzijfVar9, zzijf zzijfVar10) {
        this.f28008a = zzcxrVar;
        this.f28009b = zzijfVar;
        this.f28010c = zzdoeVar;
        this.f28011d = zzijgVar;
        this.f28012e = zzdomVar;
        this.f28013f = zzijpVar;
        this.f28014g = zzdltVar;
        this.f28015h = zzijfVar2;
        this.f28016i = zzijfVar3;
        this.f28017j = zzijfVar4;
        this.f28018k = zzijfVar5;
        this.f28019l = zzijfVar6;
        this.f28020m = zzdocVar;
        this.n = zzijfVar7;
        this.o = zzcmgVar;
        this.p = zzclpVar;
        this.q = zzijfVar8;
        this.r = zzijfVar9;
        this.s = zzijfVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzcvj zzcvjVarZzb = this.f28008a.zzb();
        Executor executor = (Executor) this.f28009b.zzb();
        zzdnm zzdnmVarA = this.f28010c.a();
        zzdnu zzdnuVar = (zzdnu) this.f28011d.zzb();
        zzdol zzdolVarZzb = this.f28012e.zzb();
        zzdnr zzdnrVar = (zzdnr) this.f28013f.zzb();
        zzdnw zzdnwVar = this.f28014g.f27913a.f27909a;
        zzijo.a(zzdnwVar);
        zzija zzijaVarB = zzijf.b(this.f28015h);
        zzija zzijaVarB2 = zzijf.b(this.f28016i);
        zzija zzijaVarB3 = zzijf.b(this.f28017j);
        zzija zzijaVarB4 = zzijf.b(this.f28018k);
        zzija zzijaVarB5 = zzijf.b(this.f28019l);
        zzdoc zzdocVar = this.f28020m;
        zzcbt zzcbtVar = new zzcbt(zzdocVar.f28071a.a(), zzdocVar.f28072b.a().f31219g);
        zzayq zzayqVar = (zzayq) this.n.zzb();
        VersionInfoParcel versionInfoParcelA = this.o.a();
        Context contextA = this.p.a();
        zzdnj zzdnjVar = (zzdnj) this.q.zzb();
        zzeqs zzeqsVar = (zzeqs) this.r.zzb();
        return new zzdnh(zzcvjVarZzb, executor, zzdnmVarA, zzdnuVar, zzdolVarZzb, zzdnrVar, zzdnwVar, zzijaVarB, zzijaVarB2, zzijaVarB3, zzijaVarB4, zzijaVarB5, zzcbtVar, zzayqVar, versionInfoParcelA, contextA, zzdnjVar, zzeqsVar);
    }
}
