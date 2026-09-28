package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgip implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32664a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32665b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32666c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32667d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijh f32668e;

    public zzgip(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar) {
        this.f32664a = zzijfVar;
        this.f32665b = zzijfVar2;
        this.f32666c = zzijfVar3;
        this.f32667d = zzijfVar4;
        this.f32668e = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgio((zzfvy) this.f32664a.zzb(), (zzgjw) this.f32665b.zzb(), (zzgls) this.f32666c.zzb(), (zzgnc) this.f32667d.zzb(), (ExecutorService) this.f32668e.f34899a);
    }
}
