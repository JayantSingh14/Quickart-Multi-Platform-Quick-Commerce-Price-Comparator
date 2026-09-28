package io.sentry;

import java.util.List;

/* loaded from: classes.dex */
public final class NoOpTransactionProfiler implements ITransactionProfiler {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpTransactionProfiler f51716a = new NoOpTransactionProfiler();

    @Override // io.sentry.ITransactionProfiler
    public final ProfilingTraceData b(SentryTracer sentryTracer, List list, SentryOptions sentryOptions) {
        return null;
    }

    @Override // io.sentry.ITransactionProfiler
    public final void close() {
    }

    @Override // io.sentry.ITransactionProfiler
    public final boolean isRunning() {
        return false;
    }

    @Override // io.sentry.ITransactionProfiler
    public final void start() {
    }

    @Override // io.sentry.ITransactionProfiler
    public final void a(SentryTracer sentryTracer) {
    }
}
