package io.sentry;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface ITransactionProfiler {
    void a(SentryTracer sentryTracer);

    ProfilingTraceData b(SentryTracer sentryTracer, List list, SentryOptions sentryOptions);

    void close();

    boolean isRunning();

    void start();
}
