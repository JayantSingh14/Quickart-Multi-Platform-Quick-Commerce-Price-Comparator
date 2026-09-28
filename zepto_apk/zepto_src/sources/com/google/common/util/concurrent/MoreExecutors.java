package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class MoreExecutors {

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$2, reason: invalid class name */
    class AnonymousClass2 implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$3, reason: invalid class name */
    class AnonymousClass3 extends WrappingExecutorService {
        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public final Callable a(Callable callable) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public final void b(Runnable runnable) {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$4, reason: invalid class name */
    class AnonymousClass4 extends WrappingScheduledExecutorService {
        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public final Callable a(Callable callable) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public final void b(Runnable runnable) {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$5, reason: invalid class name */
    class AnonymousClass5 implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            try {
                runnable.run();
            } catch (RejectedExecutionException unused) {
                throw null;
            }
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    @J2ktIncompatible
    public static class Application {

        /* renamed from: com.google.common.util.concurrent.MoreExecutors$Application$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static final class DirectExecutorService extends AbstractListeningExecutorService {
        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
            timeUnit.toNanos(j2);
            throw null;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw null;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            throw null;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            throw null;
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            throw null;
        }

        @Override // java.util.concurrent.ExecutorService
        public final List shutdownNow() {
            throw null;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static class ListeningDecorator extends AbstractListeningExecutorService {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f43464a;

        public ListeningDecorator(ExecutorService executorService) {
            executorService.getClass();
            this.f43464a = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
            return this.f43464a.awaitTermination(j2, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f43464a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f43464a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f43464a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f43464a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List shutdownNow() {
            return this.f43464a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f43464a + "]";
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {

        /* renamed from: b, reason: collision with root package name */
        public final ScheduledExecutorService f43465b;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {

            /* renamed from: b, reason: collision with root package name */
            public final ScheduledFuture f43466b;

            public ListenableScheduledTask(AbstractFuture abstractFuture, ScheduledFuture scheduledFuture) {
                super(abstractFuture);
                this.f43466b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public final boolean cancel(boolean z) {
                boolean zCancel = super.cancel(z);
                if (zCancel) {
                    this.f43466b.cancel(z);
                }
                return zCancel;
            }

            @Override // java.lang.Comparable
            public final int compareTo(Delayed delayed) {
                return this.f43466b.compareTo(delayed);
            }

            @Override // java.util.concurrent.Delayed
            public final long getDelay(TimeUnit timeUnit) {
                return this.f43466b.getDelay(timeUnit);
            }
        }

        @GwtIncompatible
        @J2ktIncompatible
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {

            /* renamed from: h, reason: collision with root package name */
            public final Runnable f43467h;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                runnable.getClass();
                this.f43467h = runnable;
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            public final String l() {
                return "task=[" + this.f43467h + "]";
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f43467h.run();
                } catch (Throwable th) {
                    o(th);
                    throw th;
                }
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f43465b = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public final ListenableScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(callable);
            return new ListenableScheduledTask(trustedListenableFutureTask, this.f43465b.schedule(trustedListenableFutureTask, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public final ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f43465b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j2, j3, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public final ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f43465b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j2, j3, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public final ListenableScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(Executors.callable(runnable, null));
            return new ListenableScheduledTask(trustedListenableFutureTask, this.f43465b.schedule(trustedListenableFutureTask, j2, timeUnit));
        }
    }

    public static Executor a() {
        return DirectExecutor.f43436a;
    }

    public static ListeningExecutorService b(ExecutorService executorService) {
        return executorService instanceof ListeningExecutorService ? (ListeningExecutorService) executorService : executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }
}
