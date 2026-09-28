package io.sentry.metrics;

import java.util.Collections;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class CounterMetric extends Metric {
    @Override // io.sentry.metrics.Metric
    public final int a() {
        return 1;
    }

    @Override // io.sentry.metrics.Metric
    public final Iterable b() {
        return Collections.singletonList(Double.valueOf(0.0d));
    }
}
