package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.UptimeClock;
import com.google.android.datatransport.runtime.time.WallTimeClock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20884a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f20885b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider f20886c;

    /* renamed from: d, reason: collision with root package name */
    public final SchedulingModule_WorkSchedulerFactory f20887d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f20888e;

    /* renamed from: f, reason: collision with root package name */
    public final Provider f20889f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeModule_EventClockFactory f20890g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeModule_UptimeClockFactory f20891h;

    /* renamed from: i, reason: collision with root package name */
    public final Provider f20892i;

    public Uploader_Factory(InstanceFactory instanceFactory, Provider provider, Provider provider2, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider3, Provider provider4, TimeModule_EventClockFactory timeModule_EventClockFactory, TimeModule_UptimeClockFactory timeModule_UptimeClockFactory, Provider provider5) {
        this.f20884a = instanceFactory;
        this.f20885b = provider;
        this.f20886c = provider2;
        this.f20887d = schedulingModule_WorkSchedulerFactory;
        this.f20888e = provider3;
        this.f20889f = provider4;
        this.f20890g = timeModule_EventClockFactory;
        this.f20891h = timeModule_UptimeClockFactory;
        this.f20892i = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Context context = (Context) this.f20884a.f20800a;
        BackendRegistry backendRegistry = (BackendRegistry) this.f20885b.get();
        EventStore eventStore = (EventStore) this.f20886c.get();
        WorkScheduler workScheduler = (WorkScheduler) this.f20887d.get();
        Executor executor = (Executor) this.f20888e.get();
        SynchronizationGuard synchronizationGuard = (SynchronizationGuard) this.f20889f.get();
        this.f20890g.getClass();
        WallTimeClock wallTimeClock = new WallTimeClock();
        this.f20891h.getClass();
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, wallTimeClock, new UptimeClock(), (ClientHealthMetricsStore) this.f20892i.get());
    }
}
