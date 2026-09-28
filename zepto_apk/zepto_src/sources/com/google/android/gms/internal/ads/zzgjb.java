package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgjb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32713a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32714b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32715c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32716d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijh f32717e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijh f32718f;

    public zzgjb(zzgjd zzgjdVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32713a = zzijfVar;
        this.f32714b = zzijfVar2;
        this.f32715c = zzijfVar3;
        this.f32716d = zzijfVar4;
        this.f32717e = zzijhVar;
        this.f32718f = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgja((zzgls) this.f32713a.zzb(), (zzgle) this.f32714b.zzb(), (zzglx) this.f32715c.zzb(), (zzgnc) this.f32716d.zzb(), (zzgad) this.f32717e.f34899a, (ExecutorService) this.f32718f.f34899a);
    }
}
