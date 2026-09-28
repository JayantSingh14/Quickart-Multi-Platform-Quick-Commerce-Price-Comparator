package io.sentry;

import java.util.List;

/* loaded from: classes.dex */
public final class NoOpTransactionPerformanceCollector implements TransactionPerformanceCollector {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpTransactionPerformanceCollector f51715a = new NoOpTransactionPerformanceCollector();

    @Override // io.sentry.TransactionPerformanceCollector
    public final void close() {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final List d(ITransaction iTransaction) {
        return null;
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void a(Span span) {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void b(Span span) {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void c(SentryTracer sentryTracer) {
    }
}
