package com.google.firebase.crashlytics.internal.send;

import android.os.SystemClock;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.ForcedSender;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class ReportQueue {

    /* renamed from: a, reason: collision with root package name */
    public final double f44399a;

    /* renamed from: b, reason: collision with root package name */
    public final double f44400b;

    /* renamed from: c, reason: collision with root package name */
    public final long f44401c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44402d;

    /* renamed from: e, reason: collision with root package name */
    public final int f44403e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayBlockingQueue f44404f;

    /* renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f44405g;

    /* renamed from: h, reason: collision with root package name */
    public final Transport f44406h;

    /* renamed from: i, reason: collision with root package name */
    public final OnDemandCounter f44407i;

    /* renamed from: j, reason: collision with root package name */
    public int f44408j;

    /* renamed from: k, reason: collision with root package name */
    public long f44409k;

    /* loaded from: classes4.dex */
    public final class ReportRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CrashlyticsReportWithSessionId f44410a;

        /* renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource f44411b;

        public ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource taskCompletionSource) {
            this.f44410a = crashlyticsReportWithSessionId;
            this.f44411b = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public final void run() throws InterruptedException {
            ReportQueue reportQueue = ReportQueue.this;
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = this.f44410a;
            reportQueue.b(crashlyticsReportWithSessionId, this.f44411b);
            reportQueue.f44407i.f43834b.set(0);
            double dMin = Math.min(3600000.0d, Math.pow(reportQueue.f44400b, reportQueue.a()) * (60000.0d / reportQueue.f44399a));
            Logger.f43705a.b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dMin / 1000.0d)) + " s for report: " + crashlyticsReportWithSessionId.d(), null);
            try {
                Thread.sleep((long) dMin);
            } catch (InterruptedException unused) {
            }
        }
    }

    public ReportQueue(Transport transport, Settings settings, OnDemandCounter onDemandCounter) {
        double d2 = settings.f44424d;
        this.f44399a = d2;
        this.f44400b = settings.f44425e;
        this.f44401c = settings.f44426f * 1000;
        this.f44406h = transport;
        this.f44407i = onDemandCounter;
        this.f44402d = SystemClock.elapsedRealtime();
        int i2 = (int) d2;
        this.f44403e = i2;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i2);
        this.f44404f = arrayBlockingQueue;
        this.f44405g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f44408j = 0;
        this.f44409k = 0L;
    }

    public final int a() {
        if (this.f44409k == 0) {
            this.f44409k = System.currentTimeMillis();
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f44409k) / this.f44401c);
        int iMin = this.f44404f.size() == this.f44403e ? Math.min(100, this.f44408j + iCurrentTimeMillis) : Math.max(0, this.f44408j - iCurrentTimeMillis);
        if (this.f44408j != iMin) {
            this.f44408j = iMin;
            this.f44409k = System.currentTimeMillis();
        }
        return iMin;
    }

    public final void b(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource taskCompletionSource) {
        Logger.f43705a.b("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.d(), null);
        final boolean z = SystemClock.elapsedRealtime() - this.f44402d < 2000;
        this.f44406h.a(Event.h(crashlyticsReportWithSessionId.b()), new TransportScheduleCallback() { // from class: com.google.firebase.crashlytics.internal.send.a
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void f(Exception exc) throws Throwable {
                final ReportQueue reportQueue = this.f44413a;
                reportQueue.getClass();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (exc != null) {
                    taskCompletionSource2.c(exc);
                    return;
                }
                if (z) {
                    boolean z2 = true;
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReportQueue reportQueue2 = reportQueue;
                            reportQueue2.getClass();
                            try {
                                ForcedSender.a(reportQueue2.f44406h);
                            } catch (Exception unused) {
                            }
                            countDownLatch.countDown();
                        }
                    }).start();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    ExecutorService executorService = Utils.f43842a;
                    boolean z3 = false;
                    try {
                        long nanos = timeUnit.toNanos(2L);
                        long jNanoTime = System.nanoTime() + nanos;
                        while (true) {
                            try {
                                try {
                                    countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                                    break;
                                } catch (InterruptedException unused) {
                                    nanos = jNanoTime - System.nanoTime();
                                    z3 = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (z2) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        }
                        if (z3) {
                            Thread.currentThread().interrupt();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z3;
                    }
                }
                taskCompletionSource2.d(crashlyticsReportWithSessionId);
            }
        });
    }
}
