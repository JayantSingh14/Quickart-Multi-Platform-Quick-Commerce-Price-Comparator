package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzghu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32614a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32615b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32616c;

    public zzghu(zzijf zzijfVar, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32614a = zzijhVar;
        this.f32615b = zzijhVar2;
        this.f32616c = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzghr((Context) this.f32614a.f34899a, (ExecutorService) this.f32615b.f34899a, (zzgcf) this.f32616c.zzb());
    }
}
