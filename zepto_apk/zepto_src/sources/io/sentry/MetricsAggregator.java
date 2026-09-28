package io.sentry;

import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryOptions;
import io.sentry.metrics.EncodedMetrics;
import io.sentry.metrics.Metric;
import io.sentry.metrics.MetricType;
import io.sentry.metrics.MetricsHelper;
import io.sentry.protocol.SentryId;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class MetricsAggregator implements IMetricsAggregator, Runnable, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final ILogger f51683a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryClient f51684b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryDateProvider f51685c;

    /* renamed from: d, reason: collision with root package name */
    public final SentryOptions.BeforeEmitMetricCallback f51686d;

    /* renamed from: e, reason: collision with root package name */
    public volatile ISentryExecutorService f51687e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f51688f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentSkipListMap f51689g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f51690h;

    /* renamed from: i, reason: collision with root package name */
    public final int f51691i;

    /* renamed from: io.sentry.MetricsAggregator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51692a;

        static {
            int[] iArr = new int[MetricType.values().length];
            f51692a = iArr;
            try {
                iArr[MetricType.Counter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51692a[MetricType.Gauge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51692a[MetricType.Distribution.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f51692a[MetricType.Set.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Charset.forName("UTF-8");
    }

    public MetricsAggregator(SentryOptions sentryOptions, SentryClient sentryClient) {
        ILogger logger = sentryOptions.getLogger();
        SentryDateProvider dateProvider = sentryOptions.getDateProvider();
        SentryOptions.BeforeEmitMetricCallback beforeEmitMetricCallback = sentryOptions.getBeforeEmitMetricCallback();
        NoOpSentryExecutorService noOpSentryExecutorService = NoOpSentryExecutorService.f51711a;
        this.f51688f = false;
        this.f51689g = new ConcurrentSkipListMap();
        this.f51690h = new AtomicInteger();
        this.f51684b = sentryClient;
        this.f51683a = logger;
        this.f51685c = dateProvider;
        this.f51691i = 100000;
        this.f51686d = beforeEmitMetricCallback;
        this.f51687e = noOpSentryExecutorService;
    }

    public final void a(boolean z) {
        Set<Long> setKeySet;
        if (!z) {
            if (this.f51690h.get() + this.f51689g.size() >= this.f51691i) {
                this.f51683a.c(SentryLevel.INFO, "Metrics: total weight exceeded, flushing all buckets", new Object[0]);
                z = true;
            }
        }
        ConcurrentSkipListMap concurrentSkipListMap = this.f51689g;
        if (z) {
            setKeySet = concurrentSkipListMap.keySet();
        } else {
            long millis = (TimeUnit.NANOSECONDS.toMillis(this.f51685c.now().d()) - 10000) - MetricsHelper.f52784c;
            long j2 = ((millis / 1000) / 10) * 10;
            if (millis < 0) {
                j2--;
            }
            setKeySet = concurrentSkipListMap.headMap((Object) Long.valueOf(j2), true).keySet();
        }
        if (setKeySet.isEmpty()) {
            this.f51683a.c(SentryLevel.DEBUG, "Metrics: nothing to flush", new Object[0]);
            return;
        }
        this.f51683a.c(SentryLevel.DEBUG, "Metrics: flushing " + setKeySet.size() + " buckets", new Object[0]);
        HashMap map = new HashMap();
        int size = 0;
        for (Long l2 : setKeySet) {
            l2.getClass();
            Map map2 = (Map) this.f51689g.remove(l2);
            if (map2 != null) {
                synchronized (map2) {
                    Iterator it = map2.values().iterator();
                    int iA = 0;
                    while (it.hasNext()) {
                        iA += ((Metric) it.next()).a();
                    }
                    this.f51690h.addAndGet(-iA);
                    size += map2.size();
                    map.put(l2, map2);
                }
            }
        }
        if (size == 0) {
            this.f51683a.c(SentryLevel.DEBUG, "Metrics: only empty buckets found", new Object[0]);
            return;
        }
        this.f51683a.c(SentryLevel.DEBUG, "Metrics: capturing metrics", new Object[0]);
        SentryClient sentryClient = this.f51684b;
        EncodedMetrics encodedMetrics = new EncodedMetrics(map);
        sentryClient.getClass();
        Charset charset = SentryEnvelopeItem.f51819d;
        SentryEnvelopeItem.CachedItem cachedItem = new SentryEnvelopeItem.CachedItem(new d(encodedMetrics, 1));
        if (sentryClient.d(new SentryEnvelope(new SentryEnvelopeHeader(new SentryId(), sentryClient.f51804a.getSdkVersion(), null), Collections.singleton(new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Statsd, new m(cachedItem, 10), "application/octet-stream", (String) null, (String) null), new m(cachedItem, 11)))), null) != null) {
            return;
        }
        SentryId sentryId = SentryId.f52907b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            this.f51688f = true;
            this.f51687e.b(0L);
        }
        a(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a(false);
        synchronized (this) {
            try {
                if (!this.f51688f && !this.f51689g.isEmpty()) {
                    ((NoOpSentryExecutorService) this.f51687e).a(5000L, this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
