package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.UptimeClock;
import com.google.android.datatransport.runtime.time.WallTimeClock;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20787a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModule_EventClockFactory f20788b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeModule_UptimeClockFactory f20789c;

    public CreationContextFactory_Factory(InstanceFactory instanceFactory, TimeModule_EventClockFactory timeModule_EventClockFactory, TimeModule_UptimeClockFactory timeModule_UptimeClockFactory) {
        this.f20787a = instanceFactory;
        this.f20788b = timeModule_EventClockFactory;
        this.f20789c = timeModule_UptimeClockFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Context context = (Context) this.f20787a.f20800a;
        this.f20788b.getClass();
        WallTimeClock wallTimeClock = new WallTimeClock();
        this.f20789c.getClass();
        return new CreationContextFactory(context, wallTimeClock, new UptimeClock());
    }
}
