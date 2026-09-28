package io.sentry;

/* loaded from: classes.dex */
public interface ILogger {
    void a(SentryLevel sentryLevel, Throwable th, String str, Object... objArr);

    void b(SentryLevel sentryLevel, String str, Throwable th);

    void c(SentryLevel sentryLevel, String str, Object... objArr);

    boolean d(SentryLevel sentryLevel);
}
