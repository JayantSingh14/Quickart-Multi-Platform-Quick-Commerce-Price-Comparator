package io.sentry;

import java.util.List;

/* loaded from: classes.dex */
public interface TransactionPerformanceCollector {
    void a(Span span);

    void b(Span span);

    void c(SentryTracer sentryTracer);

    void close();

    List d(ITransaction iTransaction);
}
