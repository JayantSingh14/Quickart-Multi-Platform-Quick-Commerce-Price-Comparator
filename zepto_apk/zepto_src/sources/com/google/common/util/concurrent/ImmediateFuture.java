package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
class ImmediateFuture<V> implements ListenableFuture<V> {

    /* renamed from: b, reason: collision with root package name */
    public static final ListenableFuture f43453b = new ImmediateFuture(null);

    /* renamed from: c, reason: collision with root package name */
    public static final LazyLogger f43454c = new LazyLogger(ImmediateFuture.class);

    /* renamed from: a, reason: collision with root package name */
    public final Object f43455a;

    public static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        static {
            if (AbstractFuture.f43388d) {
                return;
            }
            new ImmediateCancelledFuture().cancel(false);
        }
    }

    public static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
    }

    public ImmediateFuture(Object obj) {
        this.f43455a = obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f43455a;
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
        Preconditions.j(runnable, "Runnable was null.");
        Preconditions.j(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            f43454c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=SUCCESS, result=[");
        return android.support.v4.media.b.q(sb, this.f43455a, "]]");
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.f43455a;
    }
}
