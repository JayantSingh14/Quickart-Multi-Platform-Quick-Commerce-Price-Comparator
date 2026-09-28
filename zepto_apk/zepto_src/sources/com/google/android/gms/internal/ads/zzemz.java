package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzemz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f29834a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29835b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f29836c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29837d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29838e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29839f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f29840g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f29841h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f29842i;

    /* renamed from: j, reason: collision with root package name */
    public final zzijf f29843j;

    /* renamed from: k, reason: collision with root package name */
    public final zzemd f29844k;

    /* renamed from: l, reason: collision with root package name */
    public final zzijf f29845l;

    public zzemz(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6, zzijf zzijfVar7, zzijf zzijfVar8, zzijf zzijfVar9, zzemd zzemdVar, zzijf zzijfVar10) {
        this.f29834a = zzclpVar;
        this.f29835b = zzijfVar;
        this.f29836c = zzijfVar2;
        this.f29837d = zzijfVar3;
        this.f29838e = zzijfVar4;
        this.f29839f = zzijfVar5;
        this.f29840g = zzijfVar6;
        this.f29841h = zzijfVar7;
        this.f29842i = zzijfVar8;
        this.f29843j = zzijfVar9;
        this.f29844k = zzemdVar;
        this.f29845l = zzijfVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzemy zzb() {
        Context contextA = this.f29834a.a();
        zzfmu zzfmuVar = (zzfmu) this.f29835b.zzb();
        zzemr zzemrVar = (zzemr) this.f29836c.zzb();
        zzdam zzdamVar = (zzdam) this.f29837d.zzb();
        zzfpe zzfpeVar = (zzfpe) this.f29838e.zzb();
        zzfpi zzfpiVar = (zzfpi) this.f29839f.zzb();
        zzcvn zzcvnVar = (zzcvn) this.f29840g.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzemy(contextA, zzfmuVar, zzemrVar, zzdamVar, zzfpeVar, zzfpiVar, zzcvnVar, zzgywVar, (ScheduledExecutorService) this.f29841h.zzb(), (zzejl) this.f29842i.zzb(), (zzfno) this.f29843j.zzb(), this.f29844k.zzb(), (zzdwy) this.f29845l.zzb());
    }
}
