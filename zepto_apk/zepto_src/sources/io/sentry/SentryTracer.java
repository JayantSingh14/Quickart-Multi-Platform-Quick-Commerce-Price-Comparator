package io.sentry;

import io.sentry.MeasurementUnit;
import io.sentry.SentryTracer;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.User;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class SentryTracer implements ITransaction {

    /* renamed from: b, reason: collision with root package name */
    public final Span f51876b;

    /* renamed from: d, reason: collision with root package name */
    public final Hub f51878d;

    /* renamed from: e, reason: collision with root package name */
    public final String f51879e;

    /* renamed from: g, reason: collision with root package name */
    public volatile TimerTask f51881g;

    /* renamed from: h, reason: collision with root package name */
    public volatile TimerTask f51882h;

    /* renamed from: i, reason: collision with root package name */
    public volatile Timer f51883i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f51884j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f51885k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f51886l;

    /* renamed from: m, reason: collision with root package name */
    public final Baggage f51887m;
    public final TransactionNameSource n;
    public final Instrumenter o;
    public final Contexts p;
    public final TransactionPerformanceCollector q;
    public final TransactionOptions r;

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51875a = new SentryId();

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f51877c = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public FinishStatus f51880f = FinishStatus.f51890c;

    public static final class FinishStatus {

        /* renamed from: c, reason: collision with root package name */
        public static final FinishStatus f51890c = new FinishStatus(false, null);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f51891a;

        /* renamed from: b, reason: collision with root package name */
        public final SpanStatus f51892b;

        public FinishStatus(boolean z, SpanStatus spanStatus) {
            this.f51891a = z;
            this.f51892b = spanStatus;
        }
    }

    public SentryTracer(TransactionContext transactionContext, Hub hub, TransactionOptions transactionOptions, TransactionPerformanceCollector transactionPerformanceCollector) {
        this.f51883i = null;
        Object obj = new Object();
        this.f51884j = obj;
        this.f51885k = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f51886l = atomicBoolean;
        this.p = new Contexts();
        this.f51876b = new Span(transactionContext, this, hub, transactionOptions.f51965b, transactionOptions);
        this.f51879e = transactionContext.f51962k;
        this.o = transactionContext.o;
        this.f51878d = hub;
        this.q = transactionPerformanceCollector;
        this.n = transactionContext.f51963l;
        this.r = transactionOptions;
        Baggage baggage = transactionContext.n;
        if (baggage != null) {
            this.f51887m = baggage;
        } else {
            this.f51887m = new Baggage(hub.y().getLogger());
        }
        if (transactionPerformanceCollector != null) {
            transactionPerformanceCollector.c(this);
        }
        if (transactionOptions.f51968e == null && transactionOptions.f51969f == null) {
            return;
        }
        boolean z = true;
        this.f51883i = new Timer(true);
        Long l2 = transactionOptions.f51969f;
        if (l2 != null) {
            synchronized (obj) {
                try {
                    if (this.f51883i != null) {
                        s();
                        atomicBoolean.set(true);
                        this.f51882h = new TimerTask() { // from class: io.sentry.SentryTracer.2
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                SentryTracer sentryTracer = SentryTracer.this;
                                SpanStatus status = sentryTracer.getStatus();
                                if (status == null) {
                                    status = SpanStatus.DEADLINE_EXCEEDED;
                                }
                                sentryTracer.a(status, sentryTracer.r.f51968e != null, null);
                                sentryTracer.f51886l.set(false);
                            }
                        };
                        this.f51883i.schedule(this.f51882h, l2.longValue());
                    }
                } catch (Throwable th) {
                    this.f51878d.y().getLogger().b(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                    SpanStatus status = getStatus();
                    if (status == null) {
                        status = SpanStatus.DEADLINE_EXCEEDED;
                    }
                    if (this.r.f51968e == null) {
                        z = false;
                    }
                    a(status, z, null);
                    this.f51886l.set(false);
                } finally {
                }
            }
        }
        n();
    }

    public final boolean A() {
        ArrayList arrayList = new ArrayList(this.f51877c);
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Span span = (Span) it.next();
            if (!span.f51914f && span.f51910b == null) {
                return false;
            }
        }
        return true;
    }

    @Override // io.sentry.ITransaction
    public final void a(SpanStatus spanStatus, boolean z, Hint hint) {
        if (this.f51876b.f51914f) {
            return;
        }
        SentryDate sentryDateNow = this.f51878d.y().getDateProvider().now();
        CopyOnWriteArrayList copyOnWriteArrayList = this.f51877c;
        ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            Span span = (Span) listIterator.previous();
            span.f51917i = null;
            span.q(spanStatus, sentryDateNow);
        }
        u(spanStatus, sentryDateNow, z, hint);
    }

    @Override // io.sentry.ISpan
    public final boolean b() {
        return this.f51876b.f51914f;
    }

    @Override // io.sentry.ISpan
    public final void c() {
        q(getStatus(), null);
    }

    @Override // io.sentry.ISpan
    public final void d(String str) {
        Span span = this.f51876b;
        if (span.f51914f) {
            this.f51878d.y().getLogger().c(SentryLevel.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
        } else {
            span.f51911c.f51926f = str;
        }
    }

    @Override // io.sentry.ITransaction
    public final SentryId e() {
        return this.f51875a;
    }

    @Override // io.sentry.ISpan
    public final void f(String str, Long l2, MeasurementUnit.Duration duration) {
        this.f51876b.f(str, l2, duration);
    }

    @Override // io.sentry.ISpan
    public final TraceContext g() throws Throwable {
        SentryTracer sentryTracer;
        if (!this.f51878d.y().isTraceSampling()) {
            return null;
        }
        synchronized (this) {
            try {
                try {
                    if (this.f51887m.f51552b) {
                        AtomicReference atomicReference = new AtomicReference();
                        AtomicReference atomicReference2 = new AtomicReference();
                        this.f51878d.w(new androidx.media3.exoplayer.analytics.d(16, atomicReference, atomicReference2));
                        sentryTracer = this;
                        this.f51887m.f(sentryTracer, (User) atomicReference.get(), (SentryId) atomicReference2.get(), this.f51878d.y(), this.f51876b.f51911c.f51924d);
                        sentryTracer.f51887m.f51552b = false;
                    } else {
                        sentryTracer = this;
                    }
                    return sentryTracer.f51887m.g();
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // io.sentry.ISpan
    public final String getDescription() {
        return this.f51876b.f51911c.f51926f;
    }

    @Override // io.sentry.ITransaction
    public final String getName() {
        return this.f51879e;
    }

    @Override // io.sentry.ISpan
    public final SpanStatus getStatus() {
        return this.f51876b.f51911c.f51927g;
    }

    @Override // io.sentry.ISpan
    public final boolean h(SentryDate sentryDate) {
        return this.f51876b.h(sentryDate);
    }

    @Override // io.sentry.ISpan
    public final void i(Number number, String str) {
        this.f51876b.i(number, str);
    }

    @Override // io.sentry.ISpan
    public final void j(SpanStatus spanStatus) {
        q(spanStatus, null);
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [io.sentry.q] */
    @Override // io.sentry.ISpan
    public final ISpan k(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        SpanOptions spanOptions = new SpanOptions();
        Span span = this.f51876b;
        boolean z = span.f51914f;
        NoOpSpan noOpSpan = NoOpSpan.f51713a;
        if (!z && this.o.equals(instrumenter)) {
            int size = this.f51877c.size();
            Hub hub = this.f51878d;
            if (size >= hub.y().getMaxSpans()) {
                hub.y().getLogger().c(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
                return noOpSpan;
            }
            if (!span.f51914f) {
                SpanId spanId = span.f51911c.f51922b;
                final SentryTracer sentryTracer = span.f51912d;
                Span span2 = sentryTracer.f51876b;
                if (!span2.f51914f && sentryTracer.o.equals(instrumenter)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = sentryTracer.f51877c;
                    int size2 = copyOnWriteArrayList.size();
                    Hub hub2 = sentryTracer.f51878d;
                    if (size2 >= hub2.y().getMaxSpans()) {
                        hub2.y().getLogger().c(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
                        return noOpSpan;
                    }
                    Objects.b(spanId, "parentSpanId is required");
                    sentryTracer.t();
                    Span span3 = new Span(span2.f51911c.f51921a, spanId, sentryTracer, str, sentryTracer.f51878d, sentryDate, spanOptions, new SpanFinishedCallback() { // from class: io.sentry.q
                        @Override // io.sentry.SpanFinishedCallback
                        public final void a(Span span4) {
                            SentryTracer sentryTracer2 = this.f52983a;
                            TransactionPerformanceCollector transactionPerformanceCollector = sentryTracer2.q;
                            if (transactionPerformanceCollector != null) {
                                transactionPerformanceCollector.a(span4);
                            }
                            SentryTracer.FinishStatus finishStatus = sentryTracer2.f51880f;
                            TransactionOptions transactionOptions = sentryTracer2.r;
                            if (transactionOptions.f51968e == null) {
                                if (finishStatus.f51891a) {
                                    sentryTracer2.q(finishStatus.f51892b, null);
                                }
                            } else if (!transactionOptions.f51967d || sentryTracer2.A()) {
                                sentryTracer2.n();
                            }
                        }
                    });
                    span3.f51911c.f51926f = str2;
                    span3.l(String.valueOf(Thread.currentThread().getId()), "thread.id");
                    span3.l(hub2.y().getMainThreadChecker().a() ? "main" : Thread.currentThread().getName(), "thread.name");
                    copyOnWriteArrayList.add(span3);
                    TransactionPerformanceCollector transactionPerformanceCollector = sentryTracer.q;
                    if (transactionPerformanceCollector != null) {
                        transactionPerformanceCollector.b(span3);
                    }
                    return span3;
                }
            }
        }
        return noOpSpan;
    }

    @Override // io.sentry.ISpan
    public final void l(Object obj, String str) {
        Span span = this.f51876b;
        if (span.f51914f) {
            this.f51878d.y().getLogger().c(SentryLevel.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
        } else {
            span.l(obj, str);
        }
    }

    @Override // io.sentry.ITransaction
    public final Span m() {
        ArrayList arrayList = new ArrayList(this.f51877c);
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((Span) arrayList.get(size)).f51914f) {
                return (Span) arrayList.get(size);
            }
        }
        return null;
    }

    @Override // io.sentry.ITransaction
    public final void n() {
        Long l2;
        synchronized (this.f51884j) {
            try {
                if (this.f51883i != null && (l2 = this.r.f51968e) != null) {
                    t();
                    this.f51885k.set(true);
                    this.f51881g = new TimerTask() { // from class: io.sentry.SentryTracer.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public final void run() {
                            SentryTracer sentryTracer = SentryTracer.this;
                            SpanStatus status = sentryTracer.getStatus();
                            if (status == null) {
                                status = SpanStatus.OK;
                            }
                            sentryTracer.q(status, null);
                            sentryTracer.f51885k.set(false);
                        }
                    };
                    try {
                        this.f51883i.schedule(this.f51881g, l2.longValue());
                    } catch (Throwable th) {
                        this.f51878d.y().getLogger().b(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                        SpanStatus status = getStatus();
                        if (status == null) {
                            status = SpanStatus.OK;
                        }
                        q(status, null);
                        this.f51885k.set(false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.sentry.ISpan
    public final SpanContext o() {
        return this.f51876b.f51911c;
    }

    @Override // io.sentry.ISpan
    public final SentryDate p() {
        return this.f51876b.f51910b;
    }

    @Override // io.sentry.ISpan
    public final void q(SpanStatus spanStatus, SentryDate sentryDate) {
        u(spanStatus, sentryDate, true, null);
    }

    @Override // io.sentry.ISpan
    public final SentryDate r() {
        return this.f51876b.f51909a;
    }

    public final void s() {
        synchronized (this.f51884j) {
            try {
                if (this.f51882h != null) {
                    this.f51882h.cancel();
                    this.f51886l.set(false);
                    this.f51882h = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t() {
        synchronized (this.f51884j) {
            try {
                if (this.f51881g != null) {
                    this.f51881g.cancel();
                    this.f51885k.set(false);
                    this.f51881g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(io.sentry.SpanStatus r5, io.sentry.SentryDate r6, boolean r7, io.sentry.Hint r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryTracer.u(io.sentry.SpanStatus, io.sentry.SentryDate, boolean, io.sentry.Hint):void");
    }

    public final List v() {
        return this.f51877c;
    }

    public final Contexts w() {
        return this.p;
    }

    public final Map x() {
        return this.f51876b.f51918j;
    }

    public final LocalMetricsAggregator y() {
        return this.f51876b.t();
    }

    public final TransactionNameSource z() {
        return this.n;
    }
}
