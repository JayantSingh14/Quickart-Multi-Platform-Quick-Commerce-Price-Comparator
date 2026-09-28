package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class PerformanceCollectionData {

    /* renamed from: a, reason: collision with root package name */
    public MemoryCollectionData f51723a = null;

    /* renamed from: b, reason: collision with root package name */
    public CpuCollectionData f51724b = null;

    public final void a(CpuCollectionData cpuCollectionData) {
        this.f51724b = cpuCollectionData;
    }

    public final void b(MemoryCollectionData memoryCollectionData) {
        this.f51723a = memoryCollectionData;
    }
}
