package io.sentry;

import io.sentry.MeasurementUnit;
import io.sentry.protocol.SentryId;

/* loaded from: classes3.dex */
public final class NoOpSpan implements ISpan {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpSpan f51713a = new NoOpSpan();

    @Override // io.sentry.ISpan
    public final boolean b() {
        return false;
    }

    @Override // io.sentry.ISpan
    public final void c() {
    }

    @Override // io.sentry.ISpan
    public final void d(String str) {
    }

    @Override // io.sentry.ISpan
    public final String getDescription() {
        return null;
    }

    @Override // io.sentry.ISpan
    public final SpanStatus getStatus() {
        return null;
    }

    @Override // io.sentry.ISpan
    public final boolean h(SentryDate sentryDate) {
        return false;
    }

    @Override // io.sentry.ISpan
    public final void j(SpanStatus spanStatus) {
    }

    @Override // io.sentry.ISpan
    public final SpanContext o() {
        return new SpanContext(SentryId.f52907b, SpanId.f51931b, "op", null, null);
    }

    @Override // io.sentry.ISpan
    public final SentryDate p() {
        return new SentryNanotimeDate();
    }

    @Override // io.sentry.ISpan
    public final void q(SpanStatus spanStatus, SentryDate sentryDate) {
    }

    @Override // io.sentry.ISpan
    public final SentryDate r() {
        return new SentryNanotimeDate();
    }

    @Override // io.sentry.ISpan
    public final void i(Number number, String str) {
    }

    @Override // io.sentry.ISpan
    public final void l(Object obj, String str) {
    }

    @Override // io.sentry.ISpan
    public final void f(String str, Long l2, MeasurementUnit.Duration duration) {
    }
}
