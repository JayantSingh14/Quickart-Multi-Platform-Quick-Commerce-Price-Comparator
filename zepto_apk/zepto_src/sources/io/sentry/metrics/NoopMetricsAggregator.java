package io.sentry.metrics;

import io.sentry.IMetricsAggregator;
import io.sentry.metrics.MetricsApi;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NoopMetricsAggregator implements IMetricsAggregator, MetricsApi.IMetricsInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final NoopMetricsAggregator f52786a = new NoopMetricsAggregator();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
