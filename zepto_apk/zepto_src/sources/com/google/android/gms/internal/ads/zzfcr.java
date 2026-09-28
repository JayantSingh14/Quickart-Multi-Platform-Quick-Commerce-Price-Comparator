package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfcr implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30857a;

    public zzfcr(zzgyw zzgywVar) {
        this.f30857a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return this.f30857a.submit(zzfcq.f30856a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 51;
    }
}
