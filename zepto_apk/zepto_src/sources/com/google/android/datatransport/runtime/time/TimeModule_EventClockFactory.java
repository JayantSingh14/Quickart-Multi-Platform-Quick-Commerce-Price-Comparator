package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class TimeModule_EventClockFactory implements Factory<Clock> {

    public static final class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final TimeModule_EventClockFactory f20974a = new TimeModule_EventClockFactory();
    }

    public static TimeModule_EventClockFactory a() {
        return InstanceHolder.f20974a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new WallTimeClock();
    }
}
