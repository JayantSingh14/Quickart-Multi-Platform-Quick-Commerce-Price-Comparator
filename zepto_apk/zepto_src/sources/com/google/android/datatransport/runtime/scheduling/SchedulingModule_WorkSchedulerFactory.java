package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.UptimeClock;
import javax.inject.Provider;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20852a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f20853b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulingConfigModule_ConfigFactory f20854c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeModule_UptimeClockFactory f20855d;

    public SchedulingModule_WorkSchedulerFactory(InstanceFactory instanceFactory, Provider provider, SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactory, TimeModule_UptimeClockFactory timeModule_UptimeClockFactory) {
        this.f20852a = instanceFactory;
        this.f20853b = provider;
        this.f20854c = schedulingConfigModule_ConfigFactory;
        this.f20855d = timeModule_UptimeClockFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Context context = (Context) this.f20852a.f20800a;
        EventStore eventStore = (EventStore) this.f20853b.get();
        SchedulerConfig schedulerConfig = (SchedulerConfig) this.f20854c.get();
        this.f20855d.getClass();
        new UptimeClock();
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
