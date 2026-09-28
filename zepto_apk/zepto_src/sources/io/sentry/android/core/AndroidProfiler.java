package io.sentry.android.core;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.CpuCollectionData;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.ISentryExecutorService;
import io.sentry.MemoryCollectionData;
import io.sentry.PerformanceCollectionData;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.util.Objects;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public class AndroidProfiler {

    /* renamed from: b, reason: collision with root package name */
    public final File f52031b;

    /* renamed from: c, reason: collision with root package name */
    public final int f52032c;

    /* renamed from: f, reason: collision with root package name */
    public String f52035f;

    /* renamed from: g, reason: collision with root package name */
    public final SentryFrameMetricsCollector f52036g;

    /* renamed from: l, reason: collision with root package name */
    public final BuildInfoProvider f52041l;

    /* renamed from: m, reason: collision with root package name */
    public final ISentryExecutorService f52042m;
    public final ILogger n;

    /* renamed from: a, reason: collision with root package name */
    public long f52030a = 0;

    /* renamed from: d, reason: collision with root package name */
    public Future f52033d = null;

    /* renamed from: e, reason: collision with root package name */
    public File f52034e = null;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayDeque f52037h = new ArrayDeque();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayDeque f52038i = new ArrayDeque();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayDeque f52039j = new ArrayDeque();

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f52040k = new HashMap();
    public boolean o = false;

    public static class ProfileEndData {

        /* renamed from: a, reason: collision with root package name */
        public final long f52045a;

        /* renamed from: b, reason: collision with root package name */
        public final long f52046b;

        /* renamed from: c, reason: collision with root package name */
        public final File f52047c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f52048d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52049e;

        public ProfileEndData(long j2, long j3, boolean z, File file, HashMap map) {
            this.f52045a = j2;
            this.f52047c = file;
            this.f52046b = j3;
            this.f52048d = map;
            this.f52049e = z;
        }
    }

    public static class ProfileStartData {

        /* renamed from: a, reason: collision with root package name */
        public final long f52050a;

        /* renamed from: b, reason: collision with root package name */
        public final long f52051b;

        /* renamed from: c, reason: collision with root package name */
        public final Date f52052c;

        public ProfileStartData(long j2, long j3, Date date) {
            this.f52050a = j2;
            this.f52051b = j3;
            this.f52052c = date;
        }
    }

    public AndroidProfiler(String str, int i2, SentryFrameMetricsCollector sentryFrameMetricsCollector, ISentryExecutorService iSentryExecutorService, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        Objects.b(str, "TracesFilesDirPath is required");
        this.f52031b = new File(str);
        this.f52032c = i2;
        Objects.b(iLogger, "Logger is required");
        this.n = iLogger;
        Objects.b(iSentryExecutorService, "ExecutorService is required.");
        this.f52042m = iSentryExecutorService;
        Objects.b(sentryFrameMetricsCollector, "SentryFrameMetricsCollector is required");
        this.f52036g = sentryFrameMetricsCollector;
        Objects.b(buildInfoProvider, "The BuildInfoProvider is required.");
        this.f52041l = buildInfoProvider;
    }

    public final synchronized void a() {
        try {
            Future future = this.f52033d;
            if (future != null) {
                future.cancel(true);
                this.f52033d = null;
            }
            if (this.o) {
                b(null, true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:10:0x0018, B:12:0x0020, B:17:0x002e, B:19:0x0041, B:22:0x004e, B:24:0x0056, B:25:0x0066, B:27:0x006e, B:28:0x007e, B:30:0x0086, B:31:0x0096, B:33:0x009d, B:34:0x00a3, B:39:0x00b1, B:40:0x00b3, B:11:0x001d, B:15:0x0024), top: B:45:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:10:0x0018, B:12:0x0020, B:17:0x002e, B:19:0x0041, B:22:0x004e, B:24:0x0056, B:25:0x0066, B:27:0x006e, B:28:0x007e, B:30:0x0086, B:31:0x0096, B:33:0x009d, B:34:0x00a3, B:39:0x00b1, B:40:0x00b3, B:11:0x001d, B:15:0x0024), top: B:45:0x0001, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized io.sentry.android.core.AndroidProfiler.ProfileEndData b(java.util.List r13, boolean r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.o     // Catch: java.lang.Throwable -> L14
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L18
            io.sentry.ILogger r13 = r12.n     // Catch: java.lang.Throwable -> L14
            io.sentry.SentryLevel r14 = io.sentry.SentryLevel.WARNING     // Catch: java.lang.Throwable -> L14
            java.lang.String r0 = "Profiler not running"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L14
            r13.c(r14, r0, r2)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r12)
            return r1
        L14:
            r0 = move-exception
            r13 = r0
            goto Lb4
        L18:
            io.sentry.android.core.BuildInfoProvider r0 = r12.f52041l     // Catch: java.lang.Throwable -> L14
            r0.getClass()     // Catch: java.lang.Throwable -> L14
            android.os.Debug.stopMethodTracing()     // Catch: java.lang.Throwable -> L23
        L20:
            r12.o = r2     // Catch: java.lang.Throwable -> L14
            goto L2e
        L23:
            r0 = move-exception
            io.sentry.ILogger r3 = r12.n     // Catch: java.lang.Throwable -> Laf
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR     // Catch: java.lang.Throwable -> Laf
            java.lang.String r5 = "Error while stopping profiling: "
            r3.b(r4, r5, r0)     // Catch: java.lang.Throwable -> Laf
            goto L20
        L2e:
            io.sentry.android.core.internal.util.SentryFrameMetricsCollector r0 = r12.f52036g     // Catch: java.lang.Throwable -> L14
            java.lang.String r3 = r12.f52035f     // Catch: java.lang.Throwable -> L14
            r0.a(r3)     // Catch: java.lang.Throwable -> L14
            long r5 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L14
            long r7 = android.os.Process.getElapsedCpuTime()     // Catch: java.lang.Throwable -> L14
            java.io.File r0 = r12.f52034e     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L4e
            io.sentry.ILogger r13 = r12.n     // Catch: java.lang.Throwable -> L14
            io.sentry.SentryLevel r14 = io.sentry.SentryLevel.ERROR     // Catch: java.lang.Throwable -> L14
            java.lang.String r0 = "Trace file does not exists"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L14
            r13.c(r14, r0, r2)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r12)
            return r1
        L4e:
            java.util.ArrayDeque r0 = r12.f52038i     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L66
            java.util.HashMap r0 = r12.f52040k     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = "slow_frame_renders"
            io.sentry.profilemeasurements.ProfileMeasurement r3 = new io.sentry.profilemeasurements.ProfileMeasurement     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "nanosecond"
            java.util.ArrayDeque r9 = r12.f52038i     // Catch: java.lang.Throwable -> L14
            r3.<init>(r4, r9)     // Catch: java.lang.Throwable -> L14
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L14
        L66:
            java.util.ArrayDeque r0 = r12.f52039j     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L7e
            java.util.HashMap r0 = r12.f52040k     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = "frozen_frame_renders"
            io.sentry.profilemeasurements.ProfileMeasurement r3 = new io.sentry.profilemeasurements.ProfileMeasurement     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "nanosecond"
            java.util.ArrayDeque r9 = r12.f52039j     // Catch: java.lang.Throwable -> L14
            r3.<init>(r4, r9)     // Catch: java.lang.Throwable -> L14
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L14
        L7e:
            java.util.ArrayDeque r0 = r12.f52037h     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L96
            java.util.HashMap r0 = r12.f52040k     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = "screen_frame_rates"
            io.sentry.profilemeasurements.ProfileMeasurement r3 = new io.sentry.profilemeasurements.ProfileMeasurement     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "hz"
            java.util.ArrayDeque r9 = r12.f52037h     // Catch: java.lang.Throwable -> L14
            r3.<init>(r4, r9)     // Catch: java.lang.Throwable -> L14
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L14
        L96:
            r12.c(r13)     // Catch: java.lang.Throwable -> L14
            java.util.concurrent.Future r13 = r12.f52033d     // Catch: java.lang.Throwable -> L14
            if (r13 == 0) goto La3
            r0 = 1
            r13.cancel(r0)     // Catch: java.lang.Throwable -> L14
            r12.f52033d = r1     // Catch: java.lang.Throwable -> L14
        La3:
            io.sentry.android.core.AndroidProfiler$ProfileEndData r4 = new io.sentry.android.core.AndroidProfiler$ProfileEndData     // Catch: java.lang.Throwable -> L14
            java.io.File r10 = r12.f52034e     // Catch: java.lang.Throwable -> L14
            java.util.HashMap r11 = r12.f52040k     // Catch: java.lang.Throwable -> L14
            r9 = r14
            r4.<init>(r5, r7, r9, r10, r11)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r12)
            return r4
        Laf:
            r0 = move-exception
            r13 = r0
            r12.o = r2     // Catch: java.lang.Throwable -> L14
            throw r13     // Catch: java.lang.Throwable -> L14
        Lb4:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L14
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidProfiler.b(java.util.List, boolean):io.sentry.android.core.AndroidProfiler$ProfileEndData");
    }

    public final void c(List list) {
        this.f52041l.getClass();
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.f52030a) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            synchronized (list) {
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        PerformanceCollectionData performanceCollectionData = (PerformanceCollectionData) it.next();
                        CpuCollectionData cpuCollectionData = performanceCollectionData.f51724b;
                        MemoryCollectionData memoryCollectionData = performanceCollectionData.f51723a;
                        if (cpuCollectionData != null) {
                            arrayDeque3.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(cpuCollectionData.f51582a) + jElapsedRealtimeNanos), Double.valueOf(cpuCollectionData.f51583b)));
                        }
                        if (memoryCollectionData != null && memoryCollectionData.f51681b > -1) {
                            arrayDeque.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(memoryCollectionData.f51680a) + jElapsedRealtimeNanos), Long.valueOf(memoryCollectionData.f51681b)));
                        }
                        if (memoryCollectionData != null && memoryCollectionData.f51682c > -1) {
                            arrayDeque2.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(memoryCollectionData.f51680a) + jElapsedRealtimeNanos), Long.valueOf(memoryCollectionData.f51682c)));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.f52040k.put("cpu_usage", new ProfileMeasurement("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.f52040k.put("memory_footprint", new ProfileMeasurement("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.f52040k.put("memory_native_footprint", new ProfileMeasurement("byte", arrayDeque2));
        }
    }

    public final synchronized ProfileStartData d() {
        String string;
        int i2 = this.f52032c;
        if (i2 == 0) {
            this.n.c(SentryLevel.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i2));
            return null;
        }
        if (this.o) {
            this.n.c(SentryLevel.WARNING, "Profiling has already started...", new Object[0]);
            return null;
        }
        this.f52041l.getClass();
        this.f52034e = new File(this.f52031b, UUID.randomUUID() + ".trace");
        this.f52040k.clear();
        this.f52037h.clear();
        this.f52038i.clear();
        this.f52039j.clear();
        SentryFrameMetricsCollector sentryFrameMetricsCollector = this.f52036g;
        SentryFrameMetricsCollector.FrameMetricsCollectorListener frameMetricsCollectorListener = new SentryFrameMetricsCollector.FrameMetricsCollectorListener() { // from class: io.sentry.android.core.AndroidProfiler.1

            /* renamed from: a, reason: collision with root package name */
            public float f52043a = 0.0f;

            @Override // io.sentry.android.core.internal.util.SentryFrameMetricsCollector.FrameMetricsCollectorListener
            public final void e(long j2, long j3, long j4, long j5, boolean z, boolean z2, float f2) {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() + (j3 - System.nanoTime());
                AndroidProfiler androidProfiler = AndroidProfiler.this;
                long j6 = jElapsedRealtimeNanos - androidProfiler.f52030a;
                if (j6 < 0) {
                    return;
                }
                if (z2) {
                    androidProfiler.f52039j.addLast(new ProfileMeasurementValue(Long.valueOf(j6), Long.valueOf(j4)));
                } else if (z) {
                    androidProfiler.f52038i.addLast(new ProfileMeasurementValue(Long.valueOf(j6), Long.valueOf(j4)));
                }
                if (f2 != this.f52043a) {
                    this.f52043a = f2;
                    androidProfiler.f52037h.addLast(new ProfileMeasurementValue(Long.valueOf(j6), Float.valueOf(f2)));
                }
            }
        };
        if (sentryFrameMetricsCollector.f52333g) {
            string = UUID.randomUUID().toString();
            sentryFrameMetricsCollector.f52332f.put(string, frameMetricsCollectorListener);
            sentryFrameMetricsCollector.c();
        } else {
            string = null;
        }
        this.f52035f = string;
        try {
            this.f52033d = this.f52042m.a(30000L, new a(this, 3));
        } catch (RejectedExecutionException e2) {
            this.n.b(SentryLevel.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e2);
        }
        this.f52030a = SystemClock.elapsedRealtimeNanos();
        Date dateA = DateUtils.a();
        long elapsedCpuTime = Process.getElapsedCpuTime();
        try {
            Debug.startMethodTracingSampling(this.f52034e.getPath(), 3000000, this.f52032c);
            this.o = true;
            return new ProfileStartData(this.f52030a, elapsedCpuTime, dateA);
        } catch (Throwable th) {
            b(null, false);
            this.n.b(SentryLevel.ERROR, "Unable to start a profile: ", th);
            this.o = false;
            return null;
        }
    }
}
