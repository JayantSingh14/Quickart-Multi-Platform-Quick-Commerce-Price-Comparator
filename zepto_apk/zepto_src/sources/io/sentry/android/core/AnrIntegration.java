package io.sentry.android.core;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.TransactionEnd;
import io.sentry.util.IntegrationUtils;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class AnrIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: e, reason: collision with root package name */
    public static ANRWatchDog f52068e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f52069f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f52070a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f52071b = false;

    /* renamed from: c, reason: collision with root package name */
    public final Object f52072c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public SentryOptions f52073d;

    public static final class AnrHint implements AbnormalExit, TransactionEnd {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f52074a;

        public AnrHint(boolean z) {
            this.f52074a = z;
        }

        @Override // io.sentry.hints.AbnormalExit
        public final Long e() {
            return null;
        }

        @Override // io.sentry.hints.AbnormalExit
        public final boolean f() {
            return true;
        }

        @Override // io.sentry.hints.AbnormalExit
        public final String h() {
            return this.f52074a ? "anr_background" : "anr_foreground";
        }
    }

    public AnrIntegration(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f52070a = applicationContext != null ? applicationContext : context;
    }

    public final void a(SentryAndroidOptions sentryAndroidOptions) {
        synchronized (f52069f) {
            try {
                if (f52068e == null) {
                    ILogger logger = sentryAndroidOptions.getLogger();
                    SentryLevel sentryLevel = SentryLevel.DEBUG;
                    logger.c(sentryLevel, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                    ANRWatchDog aNRWatchDog = new ANRWatchDog(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new androidx.media3.exoplayer.analytics.d(20, this, sentryAndroidOptions), sentryAndroidOptions.getLogger(), this.f52070a);
                    f52068e = aNRWatchDog;
                    aNRWatchDog.start();
                    sentryAndroidOptions.getLogger().c(sentryLevel, "AnrIntegration installed.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f52072c) {
            this.f52071b = true;
        }
        synchronized (f52069f) {
            try {
                ANRWatchDog aNRWatchDog = f52068e;
                if (aNRWatchDog != null) {
                    aNRWatchDog.interrupt();
                    f52068e = null;
                    SentryOptions sentryOptions = this.f52073d;
                    if (sentryOptions != null) {
                        sentryOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration removed.", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f52073d = sentryOptions;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            IntegrationUtils.a("Anr");
            try {
                sentryAndroidOptions.getExecutorService().submit(new in.juspay.hypernfc.b(21, this, sentryAndroidOptions));
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.DEBUG, "Failed to start AnrIntegration on executor thread.", th);
            }
        }
    }
}
