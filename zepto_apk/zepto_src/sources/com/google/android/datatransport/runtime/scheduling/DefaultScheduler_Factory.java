package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f20846a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f20847b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulingModule_WorkSchedulerFactory f20848c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f20849d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f20850e;

    public DefaultScheduler_Factory(Provider provider, Provider provider2, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider3, Provider provider4) {
        this.f20846a = provider;
        this.f20847b = provider2;
        this.f20848c = schedulingModule_WorkSchedulerFactory;
        this.f20849d = provider3;
        this.f20850e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new DefaultScheduler((Executor) this.f20846a.get(), (BackendRegistry) this.f20847b.get(), (WorkScheduler) this.f20848c.get(), (EventStore) this.f20849d.get(), (SynchronizationGuard) this.f20850e.get());
    }
}
