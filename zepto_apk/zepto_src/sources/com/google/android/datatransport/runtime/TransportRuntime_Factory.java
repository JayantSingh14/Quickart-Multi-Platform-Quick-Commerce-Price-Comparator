package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.UptimeClock;
import com.google.android.datatransport.runtime.time.WallTimeClock;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeModule_EventClockFactory f20764a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModule_UptimeClockFactory f20765b;

    /* renamed from: c, reason: collision with root package name */
    public final DefaultScheduler_Factory f20766c;

    /* renamed from: d, reason: collision with root package name */
    public final Uploader_Factory f20767d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkInitializer_Factory f20768e;

    public TransportRuntime_Factory(TimeModule_EventClockFactory timeModule_EventClockFactory, TimeModule_UptimeClockFactory timeModule_UptimeClockFactory, DefaultScheduler_Factory defaultScheduler_Factory, Uploader_Factory uploader_Factory, WorkInitializer_Factory workInitializer_Factory) {
        this.f20764a = timeModule_EventClockFactory;
        this.f20765b = timeModule_UptimeClockFactory;
        this.f20766c = defaultScheduler_Factory;
        this.f20767d = uploader_Factory;
        this.f20768e = workInitializer_Factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.f20764a.getClass();
        WallTimeClock wallTimeClock = new WallTimeClock();
        this.f20765b.getClass();
        return new TransportRuntime(wallTimeClock, new UptimeClock(), (Scheduler) this.f20766c.get(), (Uploader) this.f20767d.get(), (WorkInitializer) this.f20768e.get());
    }
}
