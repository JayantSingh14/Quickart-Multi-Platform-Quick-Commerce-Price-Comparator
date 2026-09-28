package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcym implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27411a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27412b;

    public zzcym(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27411a = zzijfVar;
        this.f27412b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdij((zzdfb) this.f27411a.zzb(), (Executor) this.f27412b.zzb());
    }
}
