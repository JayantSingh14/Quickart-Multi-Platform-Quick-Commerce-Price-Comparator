package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzgbm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32225a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32226b;

    public zzgbm(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f32225a = zzijfVar;
        this.f32226b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Executor executor = (Executor) this.f32225a.zzb();
        return new zzgbl(executor);
    }
}
