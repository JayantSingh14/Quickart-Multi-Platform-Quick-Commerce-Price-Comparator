package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxf;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class zzcdt implements ListenableFuture {

    /* renamed from: a, reason: collision with root package name */
    public final zzgzf f25992a = new zzgzf();

    public void a(String str) {
        b(str);
    }

    public final boolean b(Object obj) {
        boolean zC = this.f25992a.c(obj);
        if (!zC) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("SettableFuture", new IllegalStateException("Provided SettableFuture with multiple values."));
        }
        return zC;
    }

    public final void c(Throwable th) {
        if (this.f25992a.d(th)) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.C.f21684h.e("SettableFuture", new IllegalStateException("Provided SettableFuture with multiple values."));
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.f25992a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f25992a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f25992a.f33324a instanceof zzgxf.zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f25992a.isDone();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        this.f25992a.q(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        return this.f25992a.get(j2, timeUnit);
    }
}
