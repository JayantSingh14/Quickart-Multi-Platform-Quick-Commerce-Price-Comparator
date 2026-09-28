package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface IPerformanceContinuousCollector extends IPerformanceCollector {
    void a(ISpan iSpan);

    void b(ISpan iSpan);

    void clear();
}
