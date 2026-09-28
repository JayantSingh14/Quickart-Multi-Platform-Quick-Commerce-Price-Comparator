package io.sentry;

import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class DefaultTransactionPerformanceCollector implements TransactionPerformanceCollector {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f51589d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f51590e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f51591f;

    /* renamed from: g, reason: collision with root package name */
    public final SentryAndroidOptions f51592g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f51586a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public volatile Timer f51587b = null;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f51588c = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f51593h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public long f51594i = 0;

    public DefaultTransactionPerformanceCollector(SentryAndroidOptions sentryAndroidOptions) {
        boolean z = false;
        Objects.b(sentryAndroidOptions, "The options object is required.");
        this.f51592g = sentryAndroidOptions;
        this.f51589d = new ArrayList();
        this.f51590e = new ArrayList();
        for (IPerformanceCollector iPerformanceCollector : sentryAndroidOptions.getPerformanceCollectors()) {
            if (iPerformanceCollector instanceof IPerformanceSnapshotCollector) {
                this.f51589d.add((IPerformanceSnapshotCollector) iPerformanceCollector);
            }
            if (iPerformanceCollector instanceof IPerformanceContinuousCollector) {
                this.f51590e.add((IPerformanceContinuousCollector) iPerformanceCollector);
            }
        }
        if (this.f51589d.isEmpty() && this.f51590e.isEmpty()) {
            z = true;
        }
        this.f51591f = z;
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void a(Span span) {
        Iterator it = this.f51590e.iterator();
        while (it.hasNext()) {
            ((IPerformanceContinuousCollector) it.next()).a(span);
        }
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void b(Span span) {
        Iterator it = this.f51590e.iterator();
        while (it.hasNext()) {
            ((IPerformanceContinuousCollector) it.next()).b(span);
        }
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void c(SentryTracer sentryTracer) {
        if (this.f51591f) {
            this.f51592g.getLogger().c(SentryLevel.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        Iterator it = this.f51590e.iterator();
        while (it.hasNext()) {
            ((IPerformanceContinuousCollector) it.next()).b(sentryTracer);
        }
        if (!this.f51588c.containsKey(sentryTracer.e().toString())) {
            this.f51588c.put(sentryTracer.e().toString(), new ArrayList());
            try {
                this.f51592g.getExecutorService().a(30000L, new in.juspay.hypernfc.b(17, this, sentryTracer));
            } catch (RejectedExecutionException e2) {
                this.f51592g.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", e2);
            }
        }
        if (this.f51593h.getAndSet(true)) {
            return;
        }
        synchronized (this.f51586a) {
            try {
                if (this.f51587b == null) {
                    this.f51587b = new Timer(true);
                }
                this.f51587b.schedule(new TimerTask() { // from class: io.sentry.DefaultTransactionPerformanceCollector.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        Iterator it2 = DefaultTransactionPerformanceCollector.this.f51589d.iterator();
                        while (it2.hasNext()) {
                            ((IPerformanceSnapshotCollector) it2.next()).c();
                        }
                    }
                }, 0L);
                this.f51587b.scheduleAtFixedRate(new TimerTask() { // from class: io.sentry.DefaultTransactionPerformanceCollector.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        DefaultTransactionPerformanceCollector defaultTransactionPerformanceCollector = DefaultTransactionPerformanceCollector.this;
                        if (jCurrentTimeMillis - defaultTransactionPerformanceCollector.f51594i < 10) {
                            return;
                        }
                        defaultTransactionPerformanceCollector.f51594i = jCurrentTimeMillis;
                        PerformanceCollectionData performanceCollectionData = new PerformanceCollectionData();
                        Iterator it2 = defaultTransactionPerformanceCollector.f51589d.iterator();
                        while (it2.hasNext()) {
                            ((IPerformanceSnapshotCollector) it2.next()).d(performanceCollectionData);
                        }
                        Iterator it3 = defaultTransactionPerformanceCollector.f51588c.values().iterator();
                        while (it3.hasNext()) {
                            ((List) it3.next()).add(performanceCollectionData);
                        }
                    }
                }, 100L, 100L);
            } finally {
            }
        }
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final void close() {
        this.f51592g.getLogger().c(SentryLevel.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        this.f51588c.clear();
        Iterator it = this.f51590e.iterator();
        while (it.hasNext()) {
            ((IPerformanceContinuousCollector) it.next()).clear();
        }
        if (this.f51593h.getAndSet(false)) {
            synchronized (this.f51586a) {
                try {
                    if (this.f51587b != null) {
                        this.f51587b.cancel();
                        this.f51587b = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public final List d(ITransaction iTransaction) {
        this.f51592g.getLogger().c(SentryLevel.DEBUG, "stop collecting performance info for transactions %s (%s)", iTransaction.getName(), iTransaction.o().f51921a.toString());
        ConcurrentHashMap concurrentHashMap = this.f51588c;
        List list = (List) concurrentHashMap.remove(iTransaction.e().toString());
        Iterator it = this.f51590e.iterator();
        while (it.hasNext()) {
            ((IPerformanceContinuousCollector) it.next()).a(iTransaction);
        }
        if (concurrentHashMap.isEmpty()) {
            close();
        }
        return list;
    }
}
