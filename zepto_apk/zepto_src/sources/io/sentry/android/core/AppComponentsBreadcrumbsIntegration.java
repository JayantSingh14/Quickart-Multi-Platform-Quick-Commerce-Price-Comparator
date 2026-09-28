package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import io.sentry.Breadcrumb;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class AppComponentsBreadcrumbsIntegration implements Integration, Closeable, ComponentCallbacks2, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52093a;

    /* renamed from: b, reason: collision with root package name */
    public HubAdapter f52094b;

    /* renamed from: c, reason: collision with root package name */
    public SentryAndroidOptions f52095c;

    public AppComponentsBreadcrumbsIntegration(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f52093a = applicationContext != null ? applicationContext : context;
    }

    public final void a(Integer num, long j2) {
        if (this.f52094b != null) {
            Breadcrumb breadcrumb = new Breadcrumb(j2);
            if (num != null) {
                if (num.intValue() < 40) {
                    return;
                } else {
                    breadcrumb.b(num, "level");
                }
            }
            breadcrumb.f51558d = "system";
            breadcrumb.f51560f = "device.event";
            breadcrumb.f51557c = "Low memory";
            breadcrumb.b("LOW_MEMORY", "action");
            breadcrumb.f51562h = SentryLevel.WARNING;
            this.f52094b.a(breadcrumb);
        }
    }

    public final void b(Runnable runnable) {
        SentryAndroidOptions sentryAndroidOptions = this.f52095c;
        if (sentryAndroidOptions != null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(runnable);
            } catch (Throwable th) {
                this.f52095c.getLogger().a(SentryLevel.ERROR, th, "Failed to submit app components breadcrumb task", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f52093a.unregisterComponentCallbacks(this);
        } catch (Throwable th) {
            SentryAndroidOptions sentryAndroidOptions = this.f52095c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().a(SentryLevel.DEBUG, th, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.f52095c;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().c(SentryLevel.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f52094b = HubAdapter.f51658a;
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52095c = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f52095c.isEnableAppComponentBreadcrumbs()));
        if (this.f52095c.isEnableAppComponentBreadcrumbs()) {
            try {
                this.f52093a.registerComponentCallbacks(this);
                sentryOptions.getLogger().c(sentryLevel, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                IntegrationUtils.a("AppComponentsBreadcrumbs");
            } catch (Throwable th) {
                this.f52095c.setEnableAppComponentBreadcrumbs(false);
                sentryOptions.getLogger().a(SentryLevel.INFO, th, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        b(new androidx.media3.exoplayer.video.h(this, System.currentTimeMillis(), configuration, 2));
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        b(new androidx.media3.exoplayer.audio.f(this, 2, System.currentTimeMillis()));
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(final int i2) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        b(new Runnable() { // from class: io.sentry.android.core.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f52254a.a(Integer.valueOf(i2), jCurrentTimeMillis);
            }
        });
    }
}
