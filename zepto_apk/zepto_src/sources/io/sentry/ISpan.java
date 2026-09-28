package io.sentry;

import io.sentry.MeasurementUnit;

/* loaded from: classes3.dex */
public interface ISpan {
    boolean b();

    void c();

    void d(String str);

    void f(String str, Long l2, MeasurementUnit.Duration duration);

    TraceContext g();

    String getDescription();

    SpanStatus getStatus();

    boolean h(SentryDate sentryDate);

    void i(Number number, String str);

    void j(SpanStatus spanStatus);

    ISpan k(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter);

    void l(Object obj, String str);

    SpanContext o();

    SentryDate p();

    void q(SpanStatus spanStatus, SentryDate sentryDate);

    SentryDate r();
}
