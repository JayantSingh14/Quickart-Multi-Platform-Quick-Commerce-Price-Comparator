package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgdb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32295a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32296b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32297c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f32298d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32299e;

    public zzgdb(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar) {
        this.f32295a = zzijfVar;
        this.f32296b = zzijfVar2;
        this.f32297c = zzijfVar3;
        this.f32298d = zzijhVar;
        this.f32299e = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgda(zzijf.b(this.f32295a), zzijf.b(this.f32296b), zzijf.b(this.f32297c), (ExecutorService) this.f32298d.f34899a, (zzgnc) this.f32299e.zzb());
    }
}
