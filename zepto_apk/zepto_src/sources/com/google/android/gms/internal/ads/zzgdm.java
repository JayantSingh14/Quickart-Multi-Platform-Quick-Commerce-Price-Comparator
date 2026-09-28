package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgdm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32322a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32323b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32324c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32325d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32326e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijp f32327f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijh f32328g;

    public zzgdm(zzijh zzijhVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijp zzijpVar, zzijh zzijhVar2) {
        this.f32322a = zzijhVar;
        this.f32323b = zzijfVar;
        this.f32324c = zzijfVar2;
        this.f32325d = zzijfVar3;
        this.f32326e = zzijfVar4;
        this.f32327f = zzijpVar;
        this.f32328g = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgdj((ExecutorService) this.f32322a.f34899a, zzijf.b(this.f32323b), zzijf.b(this.f32324c), (zzglx) this.f32325d.zzb(), zzijf.b(this.f32326e), this.f32327f, (zzgad) this.f32328g.f34899a);
    }
}
