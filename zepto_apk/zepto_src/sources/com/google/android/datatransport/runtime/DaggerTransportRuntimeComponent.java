package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes.dex */
final class DaggerTransportRuntimeComponent {

    public static final class Builder implements TransportRuntimeComponent.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f20733a;

        public final TransportRuntimeComponentImpl a() {
            Context context = this.f20733a;
            if (context == null) {
                throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
            }
            TransportRuntimeComponentImpl transportRuntimeComponentImpl = new TransportRuntimeComponentImpl();
            transportRuntimeComponentImpl.f20734a = DoubleCheck.a(ExecutionModule_ExecutorFactory.InstanceHolder.f20747a);
            InstanceFactory instanceFactory = new InstanceFactory(context);
            transportRuntimeComponentImpl.f20735b = instanceFactory;
            transportRuntimeComponentImpl.f20736c = DoubleCheck.a(new MetadataBackendRegistry_Factory(transportRuntimeComponentImpl.f20735b, new CreationContextFactory_Factory(instanceFactory, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a())));
            transportRuntimeComponentImpl.f20737d = new SchemaManager_Factory(transportRuntimeComponentImpl.f20735b, EventStoreModule_DbNameFactory.a(), EventStoreModule_SchemaVersionFactory.a());
            transportRuntimeComponentImpl.f20738e = DoubleCheck.a(new EventStoreModule_PackageNameFactory(transportRuntimeComponentImpl.f20735b));
            transportRuntimeComponentImpl.f20739f = DoubleCheck.a(new SQLiteEventStore_Factory(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), EventStoreModule_StoreConfigFactory.a(), transportRuntimeComponentImpl.f20737d, transportRuntimeComponentImpl.f20738e));
            SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(transportRuntimeComponentImpl.f20735b, transportRuntimeComponentImpl.f20739f, new SchedulingConfigModule_ConfigFactory(TimeModule_EventClockFactory.a()), TimeModule_UptimeClockFactory.a());
            transportRuntimeComponentImpl.f20740g = schedulingModule_WorkSchedulerFactory;
            Provider provider = transportRuntimeComponentImpl.f20734a;
            Provider provider2 = transportRuntimeComponentImpl.f20736c;
            Provider provider3 = transportRuntimeComponentImpl.f20739f;
            transportRuntimeComponentImpl.f20741h = new DefaultScheduler_Factory(provider, provider2, schedulingModule_WorkSchedulerFactory, provider3, provider3);
            InstanceFactory instanceFactory2 = transportRuntimeComponentImpl.f20735b;
            TimeModule_EventClockFactory timeModule_EventClockFactoryA = TimeModule_EventClockFactory.a();
            TimeModule_UptimeClockFactory timeModule_UptimeClockFactoryA = TimeModule_UptimeClockFactory.a();
            Provider provider4 = transportRuntimeComponentImpl.f20739f;
            transportRuntimeComponentImpl.f20742i = new Uploader_Factory(instanceFactory2, provider2, provider3, schedulingModule_WorkSchedulerFactory, provider, provider3, timeModule_EventClockFactoryA, timeModule_UptimeClockFactoryA, provider4);
            transportRuntimeComponentImpl.f20743j = new WorkInitializer_Factory(transportRuntimeComponentImpl.f20734a, provider4, transportRuntimeComponentImpl.f20740g, provider4);
            transportRuntimeComponentImpl.f20744k = DoubleCheck.a(new TransportRuntime_Factory(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), transportRuntimeComponentImpl.f20741h, transportRuntimeComponentImpl.f20742i, transportRuntimeComponentImpl.f20743j));
            return transportRuntimeComponentImpl;
        }
    }

    public static final class TransportRuntimeComponentImpl extends TransportRuntimeComponent {

        /* renamed from: a, reason: collision with root package name */
        public Provider f20734a;

        /* renamed from: b, reason: collision with root package name */
        public InstanceFactory f20735b;

        /* renamed from: c, reason: collision with root package name */
        public Provider f20736c;

        /* renamed from: d, reason: collision with root package name */
        public SchemaManager_Factory f20737d;

        /* renamed from: e, reason: collision with root package name */
        public Provider f20738e;

        /* renamed from: f, reason: collision with root package name */
        public Provider f20739f;

        /* renamed from: g, reason: collision with root package name */
        public SchedulingModule_WorkSchedulerFactory f20740g;

        /* renamed from: h, reason: collision with root package name */
        public DefaultScheduler_Factory f20741h;

        /* renamed from: i, reason: collision with root package name */
        public Uploader_Factory f20742i;

        /* renamed from: j, reason: collision with root package name */
        public WorkInitializer_Factory f20743j;

        /* renamed from: k, reason: collision with root package name */
        public Provider f20744k;

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        public final EventStore a() {
            return (EventStore) this.f20739f.get();
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        public final TransportRuntime b() {
            return (TransportRuntime) this.f20744k.get();
        }
    }
}
