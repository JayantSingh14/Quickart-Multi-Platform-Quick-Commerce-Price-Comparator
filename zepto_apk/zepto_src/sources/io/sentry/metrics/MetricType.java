package io.sentry.metrics;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public enum MetricType {
    Counter("c"),
    Gauge("g"),
    Distribution("d"),
    Set("s");


    @NotNull
    final String statsdCode;

    MetricType(@NotNull String str) {
        this.statsdCode = str;
    }
}
