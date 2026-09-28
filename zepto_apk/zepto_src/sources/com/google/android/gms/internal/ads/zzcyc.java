package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcyc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27397a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27398b;

    public zzcyc(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27397a = zzijfVar;
        this.f27398b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27397a.zzb(), (Executor) this.f27398b.zzb());
    }
}
