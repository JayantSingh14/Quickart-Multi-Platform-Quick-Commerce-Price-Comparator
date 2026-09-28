package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface IPerformanceSnapshotCollector extends IPerformanceCollector {
    void c();

    void d(PerformanceCollectionData performanceCollectionData);
}
