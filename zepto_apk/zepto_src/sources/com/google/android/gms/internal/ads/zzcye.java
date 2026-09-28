package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcye implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27401a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27402b;

    public zzcye(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27401a = zzijfVar;
        this.f27402b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27401a.zzb(), (Executor) this.f27402b.zzb());
    }
}
