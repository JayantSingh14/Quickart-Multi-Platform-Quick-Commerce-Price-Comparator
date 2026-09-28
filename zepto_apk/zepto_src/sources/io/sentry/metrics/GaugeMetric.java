package io.sentry.metrics;

import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class GaugeMetric extends Metric {
    @Override // io.sentry.metrics.Metric
    public final int a() {
        return 5;
    }

    @Override // io.sentry.metrics.Metric
    public final Iterable b() {
        Double dValueOf = Double.valueOf(0.0d);
        return Arrays.asList(dValueOf, dValueOf, dValueOf, dValueOf, 0);
    }
}
