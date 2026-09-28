package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzext implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhq f30544a;

    public zzext(zzfhq zzfhqVar) {
        this.f30544a = zzfhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzexu(this.f30544a));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 25;
    }
}
