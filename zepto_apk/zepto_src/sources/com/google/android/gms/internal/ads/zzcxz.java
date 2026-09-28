package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcxz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27391a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27392b;

    public zzcxz(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27391a = zzijfVar;
        this.f27392b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27391a.zzb(), (Executor) this.f27392b.zzb());
    }
}
