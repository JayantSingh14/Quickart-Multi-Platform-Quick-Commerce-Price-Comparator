package io.sentry.android.core;

import io.sentry.IPerformanceContinuousCollector;
import io.sentry.ISpan;
import io.sentry.NoOpSpan;
import io.sentry.NoOpTransaction;
import io.sentry.SentryDate;
import io.sentry.SentryNanotimeDate;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import java.util.Date;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public class SpanFrameMetricsCollector implements IPerformanceContinuousCollector, SentryFrameMetricsCollector.FrameMetricsCollectorListener {

    /* renamed from: h, reason: collision with root package name */
    public static final long f52205h = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: i, reason: collision with root package name */
    public static final SentryNanotimeDate f52206i = new SentryNanotimeDate(new Date(0), 0);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f52207a;

    /* renamed from: c, reason: collision with root package name */
    public final SentryFrameMetricsCollector f52209c;

    /* renamed from: d, reason: collision with root package name */
    public volatile String f52210d;

    /* renamed from: b, reason: collision with root package name */
    public final Object f52208b = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final TreeSet f52211e = new TreeSet(new androidx.media3.datasource.cache.a(5));

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentSkipListSet f52212f = new ConcurrentSkipListSet();

    /* renamed from: g, reason: collision with root package name */
    public long f52213g = 16666666;

    public static class Frame implements Comparable<Frame> {

        /* renamed from: a, reason: collision with root package name */
        public final long f52214a;

        /* renamed from: b, reason: collision with root package name */
        public final long f52215b;

        /* renamed from: c, reason: collision with root package name */
        public final long f52216c;

        /* renamed from: d, reason: collision with root package name */
        public final long f52217d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52218e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f52219f;

        /* renamed from: g, reason: collision with root package name */
        public final long f52220g;

        public Frame(long j2) {
            this(j2, j2, 0L, 0L, false, false, 0L);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Frame frame) {
            return Long.compare(this.f52215b, frame.f52215b);
        }

        public Frame(long j2, long j3, long j4, long j5, boolean z, boolean z2, long j6) {
            this.f52214a = j2;
            this.f52215b = j3;
            this.f52216c = j4;
            this.f52217d = j5;
            this.f52218e = z;
            this.f52219f = z2;
            this.f52220g = j6;
        }
    }

    public SpanFrameMetricsCollector(SentryAndroidOptions sentryAndroidOptions, SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this.f52209c = sentryFrameMetricsCollector;
        this.f52207a = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    public static long f(SentryDate sentryDate) {
        if (sentryDate instanceof SentryNanotimeDate) {
            return sentryDate.b(f52206i);
        }
        return System.nanoTime() - ((System.currentTimeMillis() * 1000000) - sentryDate.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a9 A[Catch: all -> 0x0032, TryCatch #2 {all -> 0x0032, blocks: (B:22:0x0027, B:24:0x002f, B:28:0x0035, B:30:0x003b, B:32:0x003e, B:34:0x0052, B:36:0x0055, B:38:0x0068, B:39:0x0077, B:41:0x007d, B:46:0x008f, B:48:0x0095, B:66:0x0100, B:51:0x00b0, B:57:0x00c0, B:61:0x00f2, B:65:0x00fd, B:55:0x00ba, B:67:0x0108, B:69:0x0116, B:71:0x011a, B:73:0x0122, B:79:0x012f, B:84:0x013e, B:88:0x0149, B:90:0x015a, B:92:0x0165, B:93:0x016f, B:94:0x0171, B:96:0x01a9, B:97:0x01d1), top: B:118:0x0027 }] */
    @Override // io.sentry.IPerformanceContinuousCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(io.sentry.ISpan r25) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.SpanFrameMetricsCollector.a(io.sentry.ISpan):void");
    }

    @Override // io.sentry.IPerformanceContinuousCollector
    public final void b(ISpan iSpan) {
        String str;
        if (!this.f52207a || (iSpan instanceof NoOpSpan) || (iSpan instanceof NoOpTransaction)) {
            return;
        }
        synchronized (this.f52208b) {
            try {
                this.f52211e.add(iSpan);
                if (this.f52210d == null) {
                    SentryFrameMetricsCollector sentryFrameMetricsCollector = this.f52209c;
                    if (sentryFrameMetricsCollector.f52333g) {
                        String string = UUID.randomUUID().toString();
                        sentryFrameMetricsCollector.f52332f.put(string, this);
                        sentryFrameMetricsCollector.c();
                        str = string;
                    } else {
                        str = null;
                    }
                    this.f52210d = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.IPerformanceContinuousCollector
    public final void clear() {
        synchronized (this.f52208b) {
            try {
                if (this.f52210d != null) {
                    this.f52209c.a(this.f52210d);
                    this.f52210d = null;
                }
                this.f52212f.clear();
                this.f52211e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.android.core.internal.util.SentryFrameMetricsCollector.FrameMetricsCollectorListener
    public final void e(long j2, long j3, long j4, long j5, boolean z, boolean z2, float f2) {
        ConcurrentSkipListSet concurrentSkipListSet = this.f52212f;
        if (concurrentSkipListSet.size() > 3600) {
            return;
        }
        long j6 = (long) (f52205h / f2);
        this.f52213g = j6;
        if (z || z2) {
            concurrentSkipListSet.add(new Frame(j2, j3, j4, j5, z, z2, j6));
        }
    }
}
