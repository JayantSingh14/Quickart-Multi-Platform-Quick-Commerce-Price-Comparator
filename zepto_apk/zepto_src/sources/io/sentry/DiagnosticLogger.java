package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class DiagnosticLogger implements ILogger {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51597a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f51598b;

    public DiagnosticLogger(SentryOptions sentryOptions, ILogger iLogger) {
        this.f51597a = sentryOptions;
        this.f51598b = iLogger;
    }

    @Override // io.sentry.ILogger
    public final void a(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        ILogger iLogger = this.f51598b;
        if (iLogger == null || !d(sentryLevel)) {
            return;
        }
        iLogger.a(sentryLevel, th, str, objArr);
    }

    @Override // io.sentry.ILogger
    public final void b(SentryLevel sentryLevel, String str, Throwable th) {
        ILogger iLogger = this.f51598b;
        if (iLogger == null || !d(sentryLevel)) {
            return;
        }
        iLogger.b(sentryLevel, str, th);
    }

    @Override // io.sentry.ILogger
    public final void c(SentryLevel sentryLevel, String str, Object... objArr) {
        ILogger iLogger = this.f51598b;
        if (iLogger == null || !d(sentryLevel)) {
            return;
        }
        iLogger.c(sentryLevel, str, objArr);
    }

    @Override // io.sentry.ILogger
    public final boolean d(SentryLevel sentryLevel) {
        SentryOptions sentryOptions = this.f51597a;
        return sentryLevel != null && sentryOptions.isDebug() && sentryLevel.ordinal() >= sentryOptions.getDiagnosticLevel().ordinal();
    }
}
