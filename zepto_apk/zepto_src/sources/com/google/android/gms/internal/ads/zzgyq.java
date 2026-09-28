package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zzgyq implements ListenableFuture {

    /* renamed from: b, reason: collision with root package name */
    public static final ListenableFuture f33377b = new zzgyq(null);

    /* renamed from: c, reason: collision with root package name */
    public static final zzgyu f33378c = new zzgyu(zzgyq.class);

    /* renamed from: a, reason: collision with root package name */
    public final Object f33379a;

    public zzgyq(Object obj) {
        this.f33379a = obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f33379a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        zzgqa.h(runnable, "Runnable was null.");
        zzgqa.h(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            Logger loggerA = f33378c.a();
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            loggerA.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", android.support.v4.media.a.n(new StringBuilder(strValueOf.length() + 57 + strValueOf2.length()), "RuntimeException while executing runnable ", strValueOf, " with executor ", strValueOf2), (Throwable) e2);
        }
    }

    public final String toString() {
        String string = super.toString();
        String strValueOf = String.valueOf(this.f33379a);
        return android.support.v4.media.a.n(new StringBuilder(String.valueOf(string).length() + 25 + strValueOf.length() + 2), string, "[status=SUCCESS, result=[", strValueOf, "]]");
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.f33379a;
    }
}
