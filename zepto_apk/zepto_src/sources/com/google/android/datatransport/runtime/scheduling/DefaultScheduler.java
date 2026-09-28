package com.google.android.datatransport.runtime.scheduling;

import androidx.media3.exoplayer.source.h;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class DefaultScheduler implements Scheduler {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f20840f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final WorkScheduler f20841a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f20842b;

    /* renamed from: c, reason: collision with root package name */
    public final BackendRegistry f20843c;

    /* renamed from: d, reason: collision with root package name */
    public final EventStore f20844d;

    /* renamed from: e, reason: collision with root package name */
    public final SynchronizationGuard f20845e;

    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f20842b = executor;
        this.f20843c = backendRegistry;
        this.f20841a = workScheduler;
        this.f20844d = eventStore;
        this.f20845e = synchronizationGuard;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public final void a(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f20842b.execute(new h(this, transportContext, transportScheduleCallback, eventInternal, 5));
    }
}
