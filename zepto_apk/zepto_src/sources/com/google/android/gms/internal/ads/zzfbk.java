package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfbk implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30811a;

    public zzfbk(zzgyw zzgywVar) {
        this.f30811a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return this.f30811a.submit(new zzfbj());
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 45;
    }
}
