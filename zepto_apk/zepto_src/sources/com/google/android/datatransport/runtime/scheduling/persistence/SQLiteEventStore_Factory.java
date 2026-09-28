package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.UptimeClock;
import com.google.android.datatransport.runtime.time.WallTimeClock;
import javax.inject.Provider;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeModule_EventClockFactory f20945a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModule_UptimeClockFactory f20946b;

    /* renamed from: c, reason: collision with root package name */
    public final EventStoreModule_StoreConfigFactory f20947c;

    /* renamed from: d, reason: collision with root package name */
    public final SchemaManager_Factory f20948d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f20949e;

    public SQLiteEventStore_Factory(TimeModule_EventClockFactory timeModule_EventClockFactory, TimeModule_UptimeClockFactory timeModule_UptimeClockFactory, EventStoreModule_StoreConfigFactory eventStoreModule_StoreConfigFactory, SchemaManager_Factory schemaManager_Factory, Provider provider) {
        this.f20945a = timeModule_EventClockFactory;
        this.f20946b = timeModule_UptimeClockFactory;
        this.f20947c = eventStoreModule_StoreConfigFactory;
        this.f20948d = schemaManager_Factory;
        this.f20949e = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.f20945a.getClass();
        WallTimeClock wallTimeClock = new WallTimeClock();
        this.f20946b.getClass();
        return new SQLiteEventStore(wallTimeClock, new UptimeClock(), (EventStoreConfig) this.f20947c.get(), (SchemaManager) this.f20948d.get(), this.f20949e);
    }
}
