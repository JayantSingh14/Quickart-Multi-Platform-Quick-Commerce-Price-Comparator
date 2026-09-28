package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgdf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32308a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32309b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32310c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f32311d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32312e;

    public zzgdf(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32308a = zzijhVar;
        this.f32309b = zzijfVar;
        this.f32310c = zzijfVar2;
        this.f32311d = zzijhVar2;
        this.f32312e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgde((zzgad) this.f32308a.f34899a, (zzgda) this.f32309b.zzb(), (zzgcu) this.f32310c.zzb(), (ExecutorService) this.f32311d.f34899a, (zzgnc) this.f32312e.zzb());
    }
}
