package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgjm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32732a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32733b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32734c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32735d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijh f32736e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f32737f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f32738g;

    public zzgjm(zzijh zzijhVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar2, zzijf zzijfVar4, zzijf zzijfVar5) {
        this.f32732a = zzijhVar;
        this.f32733b = zzijfVar;
        this.f32734c = zzijfVar2;
        this.f32735d = zzijfVar3;
        this.f32736e = zzijhVar2;
        this.f32737f = zzijfVar4;
        this.f32738g = zzijfVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgjl((Context) this.f32732a.f34899a, zzijf.b(this.f32733b), (zzgjv) this.f32734c.zzb(), (zzgnc) this.f32735d.zzb(), (ExecutorService) this.f32736e.f34899a, (zzgic) this.f32737f.zzb(), (zzfuf) this.f32738g.zzb());
    }
}
