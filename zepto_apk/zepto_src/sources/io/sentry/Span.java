package io.sentry;

import io.sentry.MeasurementUnit;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class Span implements ISpan {

    /* renamed from: a, reason: collision with root package name */
    public final SentryDate f51909a;

    /* renamed from: b, reason: collision with root package name */
    public SentryDate f51910b;

    /* renamed from: c, reason: collision with root package name */
    public final SpanContext f51911c;

    /* renamed from: d, reason: collision with root package name */
    public final SentryTracer f51912d;

    /* renamed from: e, reason: collision with root package name */
    public final Hub f51913e;

    /* renamed from: h, reason: collision with root package name */
    public final SpanOptions f51916h;

    /* renamed from: i, reason: collision with root package name */
    public SpanFinishedCallback f51917i;

    /* renamed from: f, reason: collision with root package name */
    public boolean f51914f = false;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f51915g = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f51918j = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f51919k = new ConcurrentHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final LazyEvaluator f51920l = new LazyEvaluator(new j());

    public Span(SentryId sentryId, SpanId spanId, SentryTracer sentryTracer, String str, Hub hub, SentryDate sentryDate, SpanOptions spanOptions, q qVar) {
        this.f51911c = new SpanContext(sentryId, new SpanId(), str, spanId, sentryTracer.f51876b.f51911c.f51924d);
        this.f51912d = sentryTracer;
        Objects.b(hub, "hub is required");
        this.f51913e = hub;
        this.f51916h = spanOptions;
        this.f51917i = qVar;
        if (sentryDate != null) {
            this.f51909a = sentryDate;
        } else {
            this.f51909a = hub.y().getDateProvider().now();
        }
    }

    public final Boolean A() {
        TracesSamplingDecision tracesSamplingDecision = this.f51911c.f51924d;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.d();
    }

    @Override // io.sentry.ISpan
    public final boolean b() {
        return this.f51914f;
    }

    @Override // io.sentry.ISpan
    public final void c() {
        j(this.f51911c.f51927g);
    }

    @Override // io.sentry.ISpan
    public final void d(String str) {
        this.f51911c.f51926f = str;
    }

    @Override // io.sentry.ISpan
    public final void f(String str, Long l2, MeasurementUnit.Duration duration) {
        if (this.f51914f) {
            this.f51913e.y().getLogger().c(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.f51919k.put(str, new MeasurementValue(l2, duration.apiName()));
        SentryTracer sentryTracer = this.f51912d;
        Span span = sentryTracer.f51876b;
        if (span == this || span.f51919k.containsKey(str)) {
            return;
        }
        sentryTracer.f(str, l2, duration);
    }

    @Override // io.sentry.ISpan
    public final String getDescription() {
        return this.f51911c.f51926f;
    }

    @Override // io.sentry.ISpan
    public final SpanStatus getStatus() {
        return this.f51911c.f51927g;
    }

    @Override // io.sentry.ISpan
    public final boolean h(SentryDate sentryDate) {
        if (this.f51910b == null) {
            return false;
        }
        this.f51910b = sentryDate;
        return true;
    }

    @Override // io.sentry.ISpan
    public final void i(Number number, String str) {
        if (this.f51914f) {
            this.f51913e.y().getLogger().c(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.f51919k.put(str, new MeasurementValue(number, null));
        SentryTracer sentryTracer = this.f51912d;
        Span span = sentryTracer.f51876b;
        if (span == this || span.f51919k.containsKey(str)) {
            return;
        }
        sentryTracer.i(number, str);
    }

    @Override // io.sentry.ISpan
    public final void j(SpanStatus spanStatus) {
        q(spanStatus, this.f51913e.y().getDateProvider().now());
    }

    @Override // io.sentry.ISpan
    public final void l(Object obj, String str) {
        this.f51918j.put(str, obj);
    }

    @Override // io.sentry.ISpan
    public final SpanContext o() {
        return this.f51911c;
    }

    @Override // io.sentry.ISpan
    public final SentryDate p() {
        return this.f51910b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.sentry.ISpan
    public final void q(SpanStatus spanStatus, SentryDate sentryDate) {
        SentryDate sentryDate2;
        SentryDate sentryDate3;
        if (this.f51914f || !this.f51915g.compareAndSet(false, true)) {
            return;
        }
        SpanContext spanContext = this.f51911c;
        spanContext.f51927g = spanStatus;
        if (sentryDate == null) {
            sentryDate = this.f51913e.y().getDateProvider().now();
        }
        this.f51910b = sentryDate;
        SpanOptions spanOptions = this.f51916h;
        spanOptions.getClass();
        if (spanOptions.f51933a) {
            SentryTracer sentryTracer = this.f51912d;
            SpanId spanId = sentryTracer.f51876b.f51911c.f51922b;
            SpanId spanId2 = spanContext.f51922b;
            boolean zEquals = spanId.equals(spanId2);
            CopyOnWriteArrayList<Span> copyOnWriteArrayList = sentryTracer.f51877c;
            if (!zEquals) {
                ArrayList arrayList = new ArrayList();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    Span span = (Span) it.next();
                    SpanId spanId3 = span.f51911c.f51923c;
                    if (spanId3 != null && spanId3.equals(spanId2)) {
                        arrayList.add(span);
                    }
                }
                copyOnWriteArrayList = arrayList;
            }
            SentryDate sentryDate4 = null;
            SentryDate sentryDate5 = null;
            for (Span span2 : copyOnWriteArrayList) {
                if (sentryDate4 == null || span2.f51909a.b(sentryDate4) < 0) {
                    sentryDate4 = span2.f51909a;
                }
                if (sentryDate5 == null || ((sentryDate3 = span2.f51910b) != null && sentryDate3.b(sentryDate5) > 0)) {
                    sentryDate5 = span2.f51910b;
                }
            }
            if (spanOptions.f51933a && sentryDate5 != null && ((sentryDate2 = this.f51910b) == null || sentryDate2.b(sentryDate5) > 0)) {
                h(sentryDate5);
            }
        }
        SpanFinishedCallback spanFinishedCallback = this.f51917i;
        if (spanFinishedCallback != null) {
            spanFinishedCallback.a(this);
        }
        this.f51914f = true;
    }

    @Override // io.sentry.ISpan
    public final SentryDate r() {
        return this.f51909a;
    }

    public final Map s() {
        return this.f51918j;
    }

    public final LocalMetricsAggregator t() {
        return (LocalMetricsAggregator) this.f51920l.a();
    }

    public final Map u() {
        return this.f51919k;
    }

    public final String v() {
        return this.f51911c.f51925e;
    }

    public final SpanId w() {
        return this.f51911c.f51923c;
    }

    public final SpanId x() {
        return this.f51911c.f51922b;
    }

    public final Map y() {
        return this.f51911c.f51928h;
    }

    public final SentryId z() {
        return this.f51911c.f51921a;
    }

    public Span(TransactionContext transactionContext, SentryTracer sentryTracer, Hub hub, SentryDate sentryDate, TransactionOptions transactionOptions) {
        this.f51911c = transactionContext;
        Objects.b(sentryTracer, "sentryTracer is required");
        this.f51912d = sentryTracer;
        this.f51913e = hub;
        this.f51917i = null;
        if (sentryDate != null) {
            this.f51909a = sentryDate;
        } else {
            this.f51909a = hub.y().getDateProvider().now();
        }
        this.f51916h = transactionOptions;
    }
}
