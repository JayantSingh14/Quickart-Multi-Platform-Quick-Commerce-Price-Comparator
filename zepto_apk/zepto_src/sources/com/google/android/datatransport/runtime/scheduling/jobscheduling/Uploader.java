package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class Uploader {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20875a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendRegistry f20876b;

    /* renamed from: c, reason: collision with root package name */
    public final EventStore f20877c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkScheduler f20878d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f20879e;

    /* renamed from: f, reason: collision with root package name */
    public final SynchronizationGuard f20880f;

    /* renamed from: g, reason: collision with root package name */
    public final Clock f20881g;

    /* renamed from: h, reason: collision with root package name */
    public final Clock f20882h;

    /* renamed from: i, reason: collision with root package name */
    public final ClientHealthMetricsStore f20883i;

    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f20875a = context;
        this.f20876b = backendRegistry;
        this.f20877c = eventStore;
        this.f20878d = workScheduler;
        this.f20879e = executor;
        this.f20880f = synchronizationGuard;
        this.f20881g = clock;
        this.f20882h = clock2;
        this.f20883i = clientHealthMetricsStore;
    }

    public final void a(final TransportContext transportContext, int i2) {
        BackendResponse backendResponseB;
        TransportBackend transportBackendB = this.f20876b.b(transportContext.b());
        BackendResponse.e(0L);
        final long jMax = 0;
        while (true) {
            final int i3 = 0;
            SynchronizationGuard.CriticalSection criticalSection = new SynchronizationGuard.CriticalSection(this) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Uploader f20910b;

                {
                    this.f20910b = this;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object d() {
                    switch (i3) {
                        case 0:
                            return Boolean.valueOf(this.f20910b.f20877c.A0(transportContext));
                        default:
                            return this.f20910b.f20877c.P0(transportContext);
                    }
                }
            };
            SynchronizationGuard synchronizationGuard = this.f20880f;
            if (!((Boolean) synchronizationGuard.b(criticalSection)).booleanValue()) {
                final TransportContext transportContext2 = transportContext;
                synchronizationGuard.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        Uploader uploader = this.f20916a;
                        uploader.f20877c.u1(uploader.f20881g.a() + jMax, transportContext2);
                        return null;
                    }
                });
                return;
            }
            final int i4 = 1;
            final Iterable iterable = (Iterable) synchronizationGuard.b(new SynchronizationGuard.CriticalSection(this) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Uploader f20910b;

                {
                    this.f20910b = this;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object d() {
                    switch (i4) {
                        case 0:
                            return Boolean.valueOf(this.f20910b.f20877c.A0(transportContext));
                        default:
                            return this.f20910b.f20877c.P0(transportContext);
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            if (transportBackendB == null) {
                Logging.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseB = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).b());
                }
                if (transportContext.c() != null) {
                    ClientHealthMetricsStore clientHealthMetricsStore = this.f20883i;
                    Objects.requireNonNull(clientHealthMetricsStore);
                    ClientMetrics clientMetrics = (ClientMetrics) synchronizationGuard.b(new l(clientHealthMetricsStore, 7));
                    EventInternal.Builder builderA = EventInternal.a();
                    builderA.f(this.f20881g.a());
                    builderA.l(this.f20882h.a());
                    builderA.k("GDT_CLIENT_METRICS");
                    builderA.e(new EncodedPayload(new Encoding("proto"), clientMetrics.b()));
                    arrayList.add(transportBackendB.a(builderA.b()));
                }
                BackendRequest.Builder builderA2 = BackendRequest.a();
                builderA2.b(arrayList);
                builderA2.c(transportContext.c());
                backendResponseB = transportBackendB.b(builderA2.a());
            }
            if (backendResponseB.c() == BackendResponse.Status.f20780b) {
                final TransportContext transportContext3 = transportContext;
                synchronizationGuard.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        Uploader uploader = this.f20912a;
                        EventStore eventStore = uploader.f20877c;
                        eventStore.C0(iterable);
                        eventStore.u1(uploader.f20881g.a() + jMax, transportContext3);
                        return null;
                    }
                });
                this.f20878d.b(transportContext3, i2 + 1, true);
                return;
            }
            TransportContext transportContext4 = transportContext;
            synchronizationGuard.b(new androidx.media3.exoplayer.analytics.d(12, this, iterable));
            if (backendResponseB.c() == BackendResponse.Status.f20779a) {
                jMax = Math.max(jMax, backendResponseB.b());
                if (transportContext4.c() != null) {
                    synchronizationGuard.b(new l(this, 9));
                }
            } else if (backendResponseB.c() == BackendResponse.Status.f20782d) {
                HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strL = ((PersistedEvent) it2.next()).b().l();
                    if (map.containsKey(strL)) {
                        map.put(strL, Integer.valueOf(((Integer) map.get(strL)).intValue() + 1));
                    } else {
                        map.put(strL, 1);
                    }
                }
                synchronizationGuard.b(new androidx.media3.exoplayer.analytics.d(13, this, map));
            }
            transportContext = transportContext4;
        }
    }
}
