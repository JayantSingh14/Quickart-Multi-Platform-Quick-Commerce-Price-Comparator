package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import java.util.Map;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f43853a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f43854b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f43855c;

    public /* synthetic */ f(CrashlyticsCore crashlyticsCore, Throwable th, Map map) {
        this.f43853a = crashlyticsCore;
        this.f43854b = th;
        this.f43855c = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CrashlyticsController crashlyticsController = this.f43853a.f43784h;
        Thread threadCurrentThread = Thread.currentThread();
        crashlyticsController.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = crashlyticsController.n;
        if (crashlyticsUncaughtExceptionHandler == null || !crashlyticsUncaughtExceptionHandler.f43803e.get()) {
            long j2 = jCurrentTimeMillis / 1000;
            String strF = crashlyticsController.f();
            Logger logger = Logger.f43705a;
            if (strF == null) {
                logger.f("Tried to write a non-fatal exception while no session was open.", null);
                return;
            }
            EventMetadata eventMetadata = new EventMetadata(strF, j2, this.f43855c);
            SessionReportingCoordinator sessionReportingCoordinator = crashlyticsController.f43764m;
            sessionReportingCoordinator.getClass();
            logger.e("Persisting non-fatal event for session " + strF);
            sessionReportingCoordinator.e(this.f43854b, threadCurrentThread, "error", eventMetadata, false);
        }
    }
}
