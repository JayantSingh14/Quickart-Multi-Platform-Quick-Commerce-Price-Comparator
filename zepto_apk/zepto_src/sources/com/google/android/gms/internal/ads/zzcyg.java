package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcyg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27404a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27405b;

    public zzcyg(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27404a = zzijfVar;
        this.f27405b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27404a.zzb(), (Executor) this.f27405b.zzb());
    }
}
