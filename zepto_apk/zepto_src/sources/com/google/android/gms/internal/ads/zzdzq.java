package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzdzq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28859a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f28860b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclq f28861c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f28862d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f28863e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f28864f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcmg f28865g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdhr f28866h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f28867i;

    public zzdzq(zzijf zzijfVar, zzclp zzclpVar, zzclq zzclqVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzcmg zzcmgVar, zzdhr zzdhrVar, zzijf zzijfVar5) {
        this.f28859a = zzijfVar;
        this.f28860b = zzclpVar;
        this.f28861c = zzclqVar;
        this.f28862d = zzijfVar2;
        this.f28863e = zzijfVar3;
        this.f28864f = zzijfVar4;
        this.f28865g = zzcmgVar;
        this.f28866h = zzdhrVar;
        this.f28867i = zzijfVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Executor executor = (Executor) this.f28859a.zzb();
        Context contextA = this.f28860b.a();
        WeakReference weakReference = this.f28861c.f26521a.f26512d;
        zzijo.a(weakReference);
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdzp(executor, contextA, weakReference, zzgywVar, (zzduu) this.f28862d.zzb(), (ScheduledExecutorService) this.f28863e.zzb(), (zzdxp) this.f28864f.zzb(), this.f28865g.a(), new zzdhq(this.f28866h.f27773a.zzb()), (zzfnr) this.f28867i.zzb());
    }
}
