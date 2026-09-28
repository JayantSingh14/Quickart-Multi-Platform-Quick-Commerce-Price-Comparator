package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzewt implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30497a;

    public zzewt(zzgyw zzgywVar) {
        this.f30497a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return this.f30497a.submit(zzews.f30496a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 20;
    }
}
