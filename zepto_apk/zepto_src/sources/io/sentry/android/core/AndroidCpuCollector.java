package io.sentry.android.core;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.CpuCollectionData;
import io.sentry.ILogger;
import io.sentry.IPerformanceSnapshotCollector;
import io.sentry.PerformanceCollectionData;
import io.sentry.SentryLevel;
import io.sentry.util.FileUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidCpuCollector implements IPerformanceSnapshotCollector {

    /* renamed from: g, reason: collision with root package name */
    public final ILogger f52023g;

    /* renamed from: h, reason: collision with root package name */
    public final BuildInfoProvider f52024h;

    /* renamed from: a, reason: collision with root package name */
    public long f52017a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f52018b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f52019c = 1;

    /* renamed from: d, reason: collision with root package name */
    public long f52020d = 1;

    /* renamed from: e, reason: collision with root package name */
    public double f52021e = 1.0E9d / 1;

    /* renamed from: f, reason: collision with root package name */
    public final File f52022f = new File("/proc/self/stat");

    /* renamed from: i, reason: collision with root package name */
    public boolean f52025i = false;

    /* renamed from: j, reason: collision with root package name */
    public final Pattern f52026j = Pattern.compile("[\n\t\r ]");

    public AndroidCpuCollector(ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        Objects.b(iLogger, "Logger is required.");
        this.f52023g = iLogger;
        this.f52024h = buildInfoProvider;
    }

    @Override // io.sentry.IPerformanceSnapshotCollector
    public final void c() {
        this.f52024h.getClass();
        this.f52025i = true;
        this.f52019c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.f52020d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.f52021e = 1.0E9d / this.f52019c;
        this.f52018b = e();
    }

    @Override // io.sentry.IPerformanceSnapshotCollector
    public final void d(PerformanceCollectionData performanceCollectionData) throws NumberFormatException {
        this.f52024h.getClass();
        if (this.f52025i) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j2 = jElapsedRealtimeNanos - this.f52017a;
            this.f52017a = jElapsedRealtimeNanos;
            long jE = e();
            long j3 = jE - this.f52018b;
            this.f52018b = jE;
            performanceCollectionData.a(new CpuCollectionData(((j3 / j2) / this.f52020d) * 100.0d, System.currentTimeMillis()));
        }
    }

    public final long e() throws NumberFormatException {
        String strC;
        ILogger iLogger = this.f52023g;
        try {
            strC = FileUtils.c(this.f52022f);
        } catch (IOException e2) {
            this.f52025i = false;
            iLogger.b(SentryLevel.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e2);
            strC = null;
        }
        if (strC != null) {
            String[] strArrSplit = this.f52026j.split(strC.trim());
            try {
                long j2 = Long.parseLong(strArrSplit[13]);
                long j3 = Long.parseLong(strArrSplit[14]);
                return (long) ((j2 + j3 + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16])) * this.f52021e);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e3) {
                iLogger.b(SentryLevel.ERROR, "Error parsing /proc/self/stat file.", e3);
            }
        }
        return 0L;
    }
}
