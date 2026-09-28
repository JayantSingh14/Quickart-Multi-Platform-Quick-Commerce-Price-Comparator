package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.SentryLevel;
import io.sentry.transport.ReusableCountLatch;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class QueuedThreadPoolExecutor extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    public final int f53102a;

    /* renamed from: b, reason: collision with root package name */
    public SentryDate f53103b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f53104c;

    /* renamed from: d, reason: collision with root package name */
    public final SentryDateProvider f53105d;

    /* renamed from: e, reason: collision with root package name */
    public final ReusableCountLatch f53106e;

    /* loaded from: classes3.dex */
    public static final class CancelledFuture<T> implements Future<T> {
        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j2, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    public QueuedThreadPoolExecutor(int i2, ThreadFactory threadFactory, a aVar, ILogger iLogger, SentryDateProvider sentryDateProvider) {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, aVar);
        this.f53103b = null;
        this.f53106e = new ReusableCountLatch();
        this.f53102a = i2;
        this.f53104c = iLogger;
        this.f53105d = sentryDateProvider;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        ReusableCountLatch reusableCountLatch = this.f53106e;
        try {
            super.afterExecute(runnable, th);
        } finally {
            reusableCountLatch.getClass();
            int i2 = ReusableCountLatch.Sync.f53115a;
            reusableCountLatch.f53114a.releaseShared(1);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        ReusableCountLatch reusableCountLatch = this.f53106e;
        if (ReusableCountLatch.Sync.a(reusableCountLatch.f53114a) < this.f53102a) {
            ReusableCountLatch.Sync.b(reusableCountLatch.f53114a);
            return super.submit(runnable);
        }
        this.f53103b = this.f53105d.now();
        this.f53104c.c(SentryLevel.WARNING, "Submit cancelled", new Object[0]);
        return new CancelledFuture();
    }
}
