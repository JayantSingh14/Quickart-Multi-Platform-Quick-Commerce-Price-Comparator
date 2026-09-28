package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class AppLifecycleIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public volatile LifecycleWatcher f52096a;

    /* renamed from: b, reason: collision with root package name */
    public SentryAndroidOptions f52097b;

    /* renamed from: c, reason: collision with root package name */
    public final MainLooperHandler f52098c = new MainLooperHandler();

    public final void a() {
        SentryAndroidOptions sentryAndroidOptions = this.f52097b;
        if (sentryAndroidOptions == null) {
            return;
        }
        this.f52096a = new LifecycleWatcher(sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.f52097b.isEnableAutoSessionTracking(), this.f52097b.isEnableAppLifecycleBreadcrumbs());
        try {
            ProcessLifecycleOwner.f4856i.f4862f.a(this.f52096a);
            this.f52097b.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
            IntegrationUtils.a("AppLifecycle");
        } catch (Throwable th) {
            this.f52096a = null;
            this.f52097b.getLogger().b(SentryLevel.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th);
        }
    }

    public final void b() {
        LifecycleWatcher lifecycleWatcher = this.f52096a;
        if (lifecycleWatcher != null) {
            ProcessLifecycleOwner.f4856i.f4862f.c(lifecycleWatcher);
            SentryAndroidOptions sentryAndroidOptions = this.f52097b;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.f52096a = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f52096a == null) {
            return;
        }
        if (AndroidMainThreadChecker.f52307a.a()) {
            b();
            return;
        }
        MainLooperHandler mainLooperHandler = this.f52098c;
        mainLooperHandler.f52154a.post(new a(this, 4));
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52097b = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "enableSessionTracking enabled: %s", Boolean.valueOf(this.f52097b.isEnableAutoSessionTracking()));
        this.f52097b.getLogger().c(sentryLevel, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.f52097b.isEnableAppLifecycleBreadcrumbs()));
        if (this.f52097b.isEnableAutoSessionTracking() || this.f52097b.isEnableAppLifecycleBreadcrumbs()) {
            try {
                ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.f4856i;
                if (AndroidMainThreadChecker.f52307a.a()) {
                    a();
                } else {
                    this.f52098c.f52154a.post(new Runnable() { // from class: io.sentry.android.core.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f52257a.a();
                        }
                    });
                }
            } catch (ClassNotFoundException e2) {
                sentryOptions.getLogger().b(SentryLevel.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", e2);
            } catch (IllegalStateException e3) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "AppLifecycleIntegration could not be installed", e3);
            }
        }
    }
}
