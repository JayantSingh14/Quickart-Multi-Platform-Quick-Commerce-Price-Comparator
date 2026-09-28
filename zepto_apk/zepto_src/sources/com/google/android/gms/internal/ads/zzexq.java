package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzexq implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30542a;

    public zzexq(zzgyw zzgywVar) {
        this.f30542a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return this.f30542a.submit(zzexp.f30541a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 24;
    }
}
