package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeun implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30357a;

    public zzeun(zzgyw zzgywVar) {
        this.f30357a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return this.f30357a.submit(new zzeum());
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 55;
    }
}
