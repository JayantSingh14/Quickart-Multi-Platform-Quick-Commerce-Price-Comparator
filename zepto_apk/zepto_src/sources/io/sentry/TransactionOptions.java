package io.sentry;

/* loaded from: classes3.dex */
public final class TransactionOptions extends SpanOptions {

    /* renamed from: b, reason: collision with root package name */
    public SentryDate f51965b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51966c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f51967d = false;

    /* renamed from: e, reason: collision with root package name */
    public Long f51968e = null;

    /* renamed from: f, reason: collision with root package name */
    public Long f51969f = null;

    /* renamed from: g, reason: collision with root package name */
    public io.sentry.android.core.d f51970g = null;

    public final boolean b() {
        return this.f51966c;
    }

    public final void c(boolean z) {
        this.f51966c = z;
    }

    public final void d() {
        this.f51969f = 30000L;
    }

    public final void e(Long l2) {
        this.f51968e = l2;
    }

    public final void f(SentryDate sentryDate) {
        this.f51965b = sentryDate;
    }

    public final void g(io.sentry.android.core.d dVar) {
        this.f51970g = dVar;
    }

    public final void h() {
        this.f51967d = true;
    }
}
