package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class JavaMemoryCollector implements IPerformanceSnapshotCollector {

    /* renamed from: a, reason: collision with root package name */
    public final Runtime f51660a = Runtime.getRuntime();

    @Override // io.sentry.IPerformanceSnapshotCollector
    public final void c() {
    }

    @Override // io.sentry.IPerformanceSnapshotCollector
    public final void d(PerformanceCollectionData performanceCollectionData) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Runtime runtime = this.f51660a;
        performanceCollectionData.f51723a = new MemoryCollectionData(jCurrentTimeMillis, runtime.totalMemory() - runtime.freeMemory(), -1L);
    }
}
