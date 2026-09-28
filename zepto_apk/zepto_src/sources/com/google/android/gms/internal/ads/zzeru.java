package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeru implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f30186a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30187b;

    /* renamed from: c, reason: collision with root package name */
    public final long f30188c;

    public zzeru(Clock clock, zzfik zzfikVar, long j2) {
        this.f30186a = clock;
        this.f30187b = zzfikVar;
        this.f30188c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzerv(this.f30187b, this.f30186a.currentTimeMillis(), this.f30188c));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 4;
    }
}
