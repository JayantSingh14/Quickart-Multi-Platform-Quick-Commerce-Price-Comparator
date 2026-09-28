package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdpy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdta f28214a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28215b;

    public zzdpy(zzdta zzdtaVar, zzijf zzijfVar) {
        this.f28214a = zzdtaVar;
        this.f28215b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzdij(new zzdsz(this.f28214a.f28510a.a()), (Executor) this.f28215b.zzb());
    }
}
