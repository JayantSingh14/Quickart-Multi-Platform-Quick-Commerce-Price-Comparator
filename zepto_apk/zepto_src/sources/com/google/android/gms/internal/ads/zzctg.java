package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzctg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcxr f27102a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27103b;

    /* renamed from: c, reason: collision with root package name */
    public final zzctm f27104c;

    /* renamed from: d, reason: collision with root package name */
    public final zzctl f27105d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcua f27106e;

    /* renamed from: f, reason: collision with root package name */
    public final zzctn f27107f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdlt f27108g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f27109h;

    /* renamed from: i, reason: collision with root package name */
    public final zzije f27110i;

    /* renamed from: j, reason: collision with root package name */
    public final zzijf f27111j;

    public zzctg(zzcxr zzcxrVar, zzijf zzijfVar, zzctm zzctmVar, zzctl zzctlVar, zzcua zzcuaVar, zzctn zzctnVar, zzdlt zzdltVar, zzijf zzijfVar2, zzije zzijeVar, zzijf zzijfVar3) {
        this.f27102a = zzcxrVar;
        this.f27103b = zzijfVar;
        this.f27104c = zzctmVar;
        this.f27105d = zzctlVar;
        this.f27106e = zzcuaVar;
        this.f27107f = zzctnVar;
        this.f27108g = zzdltVar;
        this.f27109h = zzijfVar2;
        this.f27110i = zzijeVar;
        this.f27111j = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzctf zzb() {
        zzcvj zzcvjVarZzb = this.f27102a.zzb();
        Context context = (Context) this.f27103b.zzb();
        zzfhs zzfhsVar = this.f27104c.f27124a.f27119c;
        zzijo.a(zzfhsVar);
        View view = this.f27105d.f27123a.f27118b;
        zzijo.a(view);
        zzctj zzctjVar = this.f27106e.f27154a;
        zzcvi zzcviVar = this.f27107f.f27125a.f27117a;
        zzdnw zzdnwVar = this.f27108g.f27913a.f27909a;
        zzijo.a(zzdnwVar);
        return new zzctf(zzcvjVarZzb, context, zzfhsVar, view, zzctjVar.f27120d, zzcviVar, zzdnwVar, (zzdit) this.f27109h.zzb(), zzijf.b(this.f27110i), (Executor) this.f27111j.zzb());
    }
}
