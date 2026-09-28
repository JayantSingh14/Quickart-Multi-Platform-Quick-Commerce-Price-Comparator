package io.sentry.android.core;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.DateUtils;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.ISentryExecutorService;
import io.sentry.ITransactionProfiler;
import io.sentry.ProfilingTraceData;
import io.sentry.ProfilingTransactionData;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryTracer;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.util.Objects;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class AndroidTransactionProfiler implements ITransactionProfiler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52053a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f52054b;

    /* renamed from: c, reason: collision with root package name */
    public final String f52055c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f52056d;

    /* renamed from: e, reason: collision with root package name */
    public final int f52057e;

    /* renamed from: f, reason: collision with root package name */
    public final ISentryExecutorService f52058f;

    /* renamed from: g, reason: collision with root package name */
    public final BuildInfoProvider f52059g;

    /* renamed from: j, reason: collision with root package name */
    public final SentryFrameMetricsCollector f52062j;

    /* renamed from: k, reason: collision with root package name */
    public ProfilingTransactionData f52063k;

    /* renamed from: m, reason: collision with root package name */
    public long f52065m;
    public long n;
    public Date o;

    /* renamed from: h, reason: collision with root package name */
    public boolean f52060h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f52061i = 0;

    /* renamed from: l, reason: collision with root package name */
    public AndroidProfiler f52064l = null;

    public AndroidTransactionProfiler(Context context, BuildInfoProvider buildInfoProvider, SentryFrameMetricsCollector sentryFrameMetricsCollector, ILogger iLogger, String str, boolean z, int i2, ISentryExecutorService iSentryExecutorService) {
        Context applicationContext = context.getApplicationContext();
        this.f52053a = applicationContext != null ? applicationContext : context;
        Objects.b(iLogger, "ILogger is required");
        this.f52054b = iLogger;
        this.f52062j = sentryFrameMetricsCollector;
        Objects.b(buildInfoProvider, "The BuildInfoProvider is required.");
        this.f52059g = buildInfoProvider;
        this.f52055c = str;
        this.f52056d = z;
        this.f52057e = i2;
        Objects.b(iSentryExecutorService, "The ISentryExecutorService is required.");
        this.f52058f = iSentryExecutorService;
        this.o = DateUtils.a();
    }

    @Override // io.sentry.ITransactionProfiler
    public final synchronized void a(SentryTracer sentryTracer) {
        if (this.f52061i > 0 && this.f52063k == null) {
            this.f52063k = new ProfilingTransactionData(sentryTracer, Long.valueOf(this.f52065m), Long.valueOf(this.n));
        }
    }

    @Override // io.sentry.ITransactionProfiler
    public final synchronized ProfilingTraceData b(SentryTracer sentryTracer, List list, SentryOptions sentryOptions) throws Throwable {
        try {
            try {
                return d(sentryTracer.getName(), sentryTracer.e().toString(), sentryTracer.o().f51921a.toString(), false, list, sentryOptions);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final void c() {
        if (this.f52060h) {
            return;
        }
        this.f52060h = true;
        boolean z = this.f52056d;
        ILogger iLogger = this.f52054b;
        if (!z) {
            iLogger.c(SentryLevel.INFO, "Profiling is disabled in options.", new Object[0]);
            return;
        }
        String str = this.f52055c;
        if (str == null) {
            iLogger.c(SentryLevel.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int i2 = this.f52057e;
        if (i2 <= 0) {
            iLogger.c(SentryLevel.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i2));
        } else {
            this.f52064l = new AndroidProfiler(str, ((int) TimeUnit.SECONDS.toMicros(1L)) / i2, this.f52062j, this.f52058f, this.f52054b, this.f52059g);
        }
    }

    @Override // io.sentry.ITransactionProfiler
    public final void close() {
        AndroidTransactionProfiler androidTransactionProfiler;
        ProfilingTransactionData profilingTransactionData = this.f52063k;
        if (profilingTransactionData != null) {
            androidTransactionProfiler = this;
            androidTransactionProfiler.d(profilingTransactionData.f51742c, profilingTransactionData.f51740a, profilingTransactionData.f51741b, true, null, HubAdapter.f51658a.y());
        } else {
            androidTransactionProfiler = this;
            int i2 = androidTransactionProfiler.f52061i;
            if (i2 != 0) {
                androidTransactionProfiler.f52061i = i2 - 1;
            }
        }
        AndroidProfiler androidProfiler = androidTransactionProfiler.f52064l;
        if (androidProfiler != null) {
            androidProfiler.a();
        }
    }

    public final synchronized ProfilingTraceData d(String str, String str2, String str3, boolean z, List list, SentryOptions sentryOptions) {
        try {
            if (this.f52064l == null) {
                return null;
            }
            this.f52059g.getClass();
            ProfilingTransactionData profilingTransactionData = this.f52063k;
            if (profilingTransactionData != null && profilingTransactionData.f51740a.equals(str2)) {
                int i2 = this.f52061i;
                if (i2 > 0) {
                    this.f52061i = i2 - 1;
                }
                this.f52054b.c(SentryLevel.DEBUG, "Transaction %s (%s) finished.", str, str3);
                if (this.f52061i != 0) {
                    ProfilingTransactionData profilingTransactionData2 = this.f52063k;
                    if (profilingTransactionData2 != null) {
                        profilingTransactionData2.a(Long.valueOf(SystemClock.elapsedRealtimeNanos()), Long.valueOf(this.f52065m), Long.valueOf(Process.getElapsedCpuTime()), Long.valueOf(this.n));
                    }
                    return null;
                }
                boolean z2 = false;
                AndroidProfiler.ProfileEndData profileEndDataB = this.f52064l.b(list, false);
                if (profileEndDataB == null) {
                    return null;
                }
                long j2 = profileEndDataB.f52045a - this.f52065m;
                ArrayList arrayList = new ArrayList(1);
                ProfilingTransactionData profilingTransactionData3 = this.f52063k;
                if (profilingTransactionData3 != null) {
                    arrayList.add(profilingTransactionData3);
                }
                this.f52063k = null;
                this.f52061i = 0;
                Long l2 = sentryOptions instanceof SentryAndroidOptions ? DeviceInfoUtil.c(this.f52053a, (SentryAndroidOptions) sentryOptions).f52126g : null;
                String string = l2 != null ? Long.toString(l2.longValue()) : "0";
                String[] strArr = Build.SUPPORTED_ABIS;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ProfilingTransactionData) it.next()).a(Long.valueOf(profileEndDataB.f52045a), Long.valueOf(this.f52065m), Long.valueOf(profileEndDataB.f52046b), Long.valueOf(this.n));
                    z2 = z2;
                }
                boolean z3 = z2;
                File file = profileEndDataB.f52047c;
                Date date = this.o;
                String string2 = Long.toString(j2);
                this.f52059g.getClass();
                int i3 = Build.VERSION.SDK_INT;
                String str4 = (strArr == null || strArr.length <= 0) ? "" : strArr[z3 ? 1 : 0];
                in.juspay.airborne.ota.h hVar = new in.juspay.airborne.ota.h(2);
                this.f52059g.getClass();
                String str5 = Build.MANUFACTURER;
                this.f52059g.getClass();
                String str6 = Build.MODEL;
                this.f52059g.getClass();
                return new ProfilingTraceData(file, date, arrayList, str, str2, str3, string2, i3, str4, hVar, str5, str6, Build.VERSION.RELEASE, this.f52059g.a(), string, sentryOptions.getProguardUuid(), sentryOptions.getRelease(), sentryOptions.getEnvironment(), (profileEndDataB.f52049e || z) ? "timeout" : "normal", profileEndDataB.f52048d);
            }
            this.f52054b.c(SentryLevel.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", str, str3);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.sentry.ITransactionProfiler
    public final boolean isRunning() {
        return this.f52061i != 0;
    }

    @Override // io.sentry.ITransactionProfiler
    public final synchronized void start() {
        AndroidProfiler androidProfiler;
        AndroidProfiler.ProfileStartData profileStartDataD;
        try {
            this.f52059g.getClass();
            c();
            int i2 = this.f52061i + 1;
            this.f52061i = i2;
            if (i2 != 1 || (androidProfiler = this.f52064l) == null || (profileStartDataD = androidProfiler.d()) == null) {
                this.f52061i--;
                this.f52054b.c(SentryLevel.WARNING, "A profile is already running. This profile will be ignored.", new Object[0]);
            } else {
                this.f52065m = profileStartDataD.f52050a;
                this.n = profileStartDataD.f52051b;
                this.o = profileStartDataD.f52052c;
                this.f52054b.c(SentryLevel.DEBUG, "Profiler started.", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
