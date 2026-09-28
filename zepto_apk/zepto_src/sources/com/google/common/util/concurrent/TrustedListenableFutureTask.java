package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {

    /* renamed from: h, reason: collision with root package name */
    public volatile TrustedFutureInterruptibleTask f43475h;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void a(Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void b(Object obj) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean c() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final Object d() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final String e() {
            throw null;
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {

        /* renamed from: c, reason: collision with root package name */
        public final Callable f43476c;

        public TrustedFutureInterruptibleTask(Callable callable) {
            callable.getClass();
            this.f43476c = callable;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void a(Throwable th) {
            TrustedListenableFutureTask.this.o(th);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void b(Object obj) {
            TrustedListenableFutureTask.this.n(obj);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean c() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final Object d() {
            return this.f43476c.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final String e() {
            return this.f43476c.toString();
        }
    }

    public TrustedListenableFutureTask(Callable callable) {
        this.f43475h = new TrustedFutureInterruptibleTask(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void c() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask;
        Object obj = this.f43392a;
        if ((obj instanceof AbstractFuture.Cancellation) && ((AbstractFuture.Cancellation) obj).f43397a && (trustedFutureInterruptibleTask = this.f43475h) != null) {
            Runnable runnable = InterruptibleTask.f43457b;
            Runnable runnable2 = InterruptibleTask.f43456a;
            Runnable runnable3 = (Runnable) trustedFutureInterruptibleTask.get();
            if (runnable3 instanceof Thread) {
                InterruptibleTask.Blocker blocker = new InterruptibleTask.Blocker(trustedFutureInterruptibleTask);
                InterruptibleTask.Blocker.a(blocker, Thread.currentThread());
                if (trustedFutureInterruptibleTask.compareAndSet(runnable3, blocker)) {
                    try {
                        ((Thread) runnable3).interrupt();
                    } finally {
                        if (((Runnable) trustedFutureInterruptibleTask.getAndSet(runnable2)) == runnable) {
                            LockSupport.unpark((Thread) runnable3);
                        }
                    }
                }
            }
        }
        this.f43475h = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String l() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.f43475h;
        if (trustedFutureInterruptibleTask == null) {
            return super.l();
        }
        return "task=[" + trustedFutureInterruptibleTask + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.f43475h;
        if (trustedFutureInterruptibleTask != null) {
            trustedFutureInterruptibleTask.run();
        }
        this.f43475h = null;
    }
}
