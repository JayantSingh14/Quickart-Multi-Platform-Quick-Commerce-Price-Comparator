package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcxy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27389a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27390b;

    public zzcxy(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27389a = zzijfVar;
        this.f27390b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27389a.zzb(), (Executor) this.f27390b.zzb());
    }
}
