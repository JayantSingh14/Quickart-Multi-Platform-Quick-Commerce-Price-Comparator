package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.AnrIntegration;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.util.HintUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ANRWatchDog extends Thread {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f51981l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f51982a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.media3.exoplayer.analytics.d f51983b;

    /* renamed from: c, reason: collision with root package name */
    public final MainLooperHandler f51984c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.common.net.a f51985d;

    /* renamed from: e, reason: collision with root package name */
    public final long f51986e;

    /* renamed from: f, reason: collision with root package name */
    public final long f51987f;

    /* renamed from: g, reason: collision with root package name */
    public final ILogger f51988g;

    /* renamed from: h, reason: collision with root package name */
    public volatile long f51989h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f51990i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f51991j;

    /* renamed from: k, reason: collision with root package name */
    public final a f51992k;

    public interface ANRListener {
    }

    public ANRWatchDog(long j2, boolean z, androidx.media3.exoplayer.analytics.d dVar, ILogger iLogger, Context context) {
        com.google.common.net.a aVar = new com.google.common.net.a(6);
        MainLooperHandler mainLooperHandler = new MainLooperHandler();
        super("|ANR-WatchDog|");
        this.f51989h = 0L;
        this.f51990i = new AtomicBoolean(false);
        this.f51985d = aVar;
        this.f51987f = j2;
        this.f51986e = 500L;
        this.f51982a = z;
        this.f51983b = dVar;
        this.f51988g = iLogger;
        this.f51984c = mainLooperHandler;
        this.f51991j = context;
        this.f51992k = new a(this, aVar);
        if (j2 < 1000) {
            throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", 1000L));
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        this.f51992k.run();
        while (!isInterrupted()) {
            this.f51984c.f52154a.post(this.f51992k);
            try {
                Thread.sleep(this.f51986e);
                this.f51985d.getClass();
                if (SystemClock.uptimeMillis() - this.f51989h > this.f51987f) {
                    if (this.f51982a || !(Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.f51991j.getSystemService("activity");
                        if (activityManager != null) {
                            try {
                                processesInErrorState = activityManager.getProcessesInErrorState();
                            } catch (Throwable th) {
                                this.f51988g.b(SentryLevel.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
                                processesInErrorState = null;
                            }
                            if (processesInErrorState != null) {
                                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                                while (it.hasNext()) {
                                    if (it.next().condition == 2) {
                                    }
                                }
                            }
                        }
                        if (this.f51990i.compareAndSet(false, true)) {
                            ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(android.support.v4.media.b.p(new StringBuilder("Application Not Responding for at least "), this.f51987f, " ms."), this.f51984c.f52154a.getLooper().getThread());
                            androidx.media3.exoplayer.analytics.d dVar = this.f51983b;
                            ((AnrIntegration) dVar.f6451b).getClass();
                            SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) dVar.f6452c;
                            sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
                            boolean zEquals = Boolean.TRUE.equals(AppState.f52099b.f52100a);
                            String strC = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
                            if (zEquals) {
                                strC = android.support.v4.media.b.C("Background ", strC);
                            }
                            ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(strC, applicationNotResponding.f52101a);
                            Mechanism mechanism = new Mechanism();
                            mechanism.f52848a = "ANR";
                            SentryEvent sentryEvent = new SentryEvent(new ExceptionMechanismException(mechanism, applicationNotResponding2, applicationNotResponding2.f52101a, true));
                            sentryEvent.u = SentryLevel.ERROR;
                            HubAdapter.f51658a.A(sentryEvent, HintUtils.a(new AnrIntegration.AnrHint(zEquals)));
                        }
                    } else {
                        this.f51988g.c(SentryLevel.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.f51990i.set(true);
                    }
                }
            } catch (InterruptedException e2) {
                try {
                    Thread.currentThread().interrupt();
                    this.f51988g.c(SentryLevel.WARNING, "Interrupted: %s", e2.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.f51988g.c(SentryLevel.WARNING, "Failed to interrupt due to SecurityException: %s", e2.getMessage());
                    return;
                }
            }
        }
    }
}
