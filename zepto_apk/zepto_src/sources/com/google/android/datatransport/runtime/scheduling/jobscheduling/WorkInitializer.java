package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class WorkInitializer {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f20893a;

    /* renamed from: b, reason: collision with root package name */
    public final EventStore f20894b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkScheduler f20895c;

    /* renamed from: d, reason: collision with root package name */
    public final SynchronizationGuard f20896d;

    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f20893a = executor;
        this.f20894b = eventStore;
        this.f20895c = workScheduler;
        this.f20896d = synchronizationGuard;
    }
}
