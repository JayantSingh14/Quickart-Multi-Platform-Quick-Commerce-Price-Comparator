package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    public static final class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final TimeModule_UptimeClockFactory f20975a = new TimeModule_UptimeClockFactory();
    }

    public static TimeModule_UptimeClockFactory a() {
        return InstanceHolder.f20975a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new UptimeClock();
    }
}
