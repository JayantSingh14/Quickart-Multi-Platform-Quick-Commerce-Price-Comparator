package io.sentry;

/* loaded from: classes.dex */
public final class NoOpLogger implements ILogger {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpLogger f51707a = new NoOpLogger();

    @Override // io.sentry.ILogger
    public final void a(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
    }

    @Override // io.sentry.ILogger
    public final void b(SentryLevel sentryLevel, String str, Throwable th) {
    }

    @Override // io.sentry.ILogger
    public final void c(SentryLevel sentryLevel, String str, Object... objArr) {
    }

    @Override // io.sentry.ILogger
    public final boolean d(SentryLevel sentryLevel) {
        return false;
    }
}
