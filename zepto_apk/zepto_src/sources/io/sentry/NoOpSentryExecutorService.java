package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
final class NoOpSentryExecutorService implements ISentryExecutorService {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpSentryExecutorService f51711a = new NoOpSentryExecutorService();

    @Override // io.sentry.ISentryExecutorService
    public final Future a(long j2, Runnable runnable) {
        return new FutureTask(new c(1));
    }

    @Override // io.sentry.ISentryExecutorService
    public final void b(long j2) {
    }

    @Override // io.sentry.ISentryExecutorService
    public final boolean isClosed() {
        return false;
    }

    @Override // io.sentry.ISentryExecutorService
    public final Future submit(Runnable runnable) {
        return new FutureTask(new c(1));
    }
}
