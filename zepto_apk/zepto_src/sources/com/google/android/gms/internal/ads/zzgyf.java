package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzgyf extends zzgye {

    /* renamed from: h, reason: collision with root package name */
    public final ListenableFuture f33371h;

    public zzgyf(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.f33371h = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f33371h.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, java.util.concurrent.Future
    public final Object get() {
        return this.f33371h.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f33371h.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, java.util.concurrent.Future
    public final boolean isDone() {
        return this.f33371h.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        this.f33371h.q(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String toString() {
        return this.f33371h.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgxf, java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        return this.f33371h.get(j2, timeUnit);
    }
}
