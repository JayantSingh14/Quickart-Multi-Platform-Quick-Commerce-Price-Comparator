package io.sentry;

/* loaded from: classes3.dex */
public final class SentryLongDate extends SentryDate {

    /* renamed from: a, reason: collision with root package name */
    public final long f51845a;

    public SentryLongDate(long j2) {
        this.f51845a = j2;
    }

    @Override // io.sentry.SentryDate
    public final long d() {
        return this.f51845a;
    }
}
