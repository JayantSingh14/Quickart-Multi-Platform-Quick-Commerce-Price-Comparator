package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f20897a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f20898b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulingModule_WorkSchedulerFactory f20899c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f20900d;

    public WorkInitializer_Factory(Provider provider, Provider provider2, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider3) {
        this.f20897a = provider;
        this.f20898b = provider2;
        this.f20899c = schedulingModule_WorkSchedulerFactory;
        this.f20900d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new WorkInitializer((Executor) this.f20897a.get(), (EventStore) this.f20898b.get(), (WorkScheduler) this.f20899c.get(), (SynchronizationGuard) this.f20900d.get());
    }
}
