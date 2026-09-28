package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzety implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzfik f30333a;

    public zzety(zzfik zzfikVar) {
        this.f30333a = zzfikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzetz(this.f30333a.q));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 58;
    }
}
