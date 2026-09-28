package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzezf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30651a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijp f30652b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30653c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30654d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdab f30655e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f30656f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f30657g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f30658h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f30659i;

    public zzezf(zzijf zzijfVar, zzijp zzijpVar, zzijf zzijfVar2, zzijf zzijfVar3, zzdab zzdabVar, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6, zzijf zzijfVar7) {
        this.f30651a = zzijfVar;
        this.f30652b = zzijpVar;
        this.f30653c = zzijfVar2;
        this.f30654d = zzijfVar3;
        this.f30655e = zzdabVar;
        this.f30656f = zzijfVar4;
        this.f30657g = zzijfVar5;
        this.f30658h = zzijfVar6;
        this.f30659i = zzijfVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzezd(zzgywVar, (ScheduledExecutorService) this.f30651a.zzb(), (String) this.f30652b.zzb(), (zzepk) this.f30653c.zzb(), (Context) this.f30654d.zzb(), this.f30655e.a(), (zzepf) this.f30656f.zzb(), (zzduu) this.f30657g.zzb(), (zzdzr) this.f30658h.zzb(), ((Integer) this.f30659i.zzb()).intValue());
    }
}
