package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.WallTimeClock;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeModule_EventClockFactory f20851a;

    public SchedulingConfigModule_ConfigFactory(TimeModule_EventClockFactory timeModule_EventClockFactory) {
        this.f20851a = timeModule_EventClockFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.f20851a.getClass();
        return SchedulerConfig.b(new WallTimeClock());
    }
}
