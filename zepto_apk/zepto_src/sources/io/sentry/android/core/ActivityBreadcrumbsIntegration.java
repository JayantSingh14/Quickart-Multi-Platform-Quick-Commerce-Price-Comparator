package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class ActivityBreadcrumbsIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Application f51993a;

    /* renamed from: b, reason: collision with root package name */
    public HubAdapter f51994b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51995c;

    public ActivityBreadcrumbsIntegration(Application application) {
        this.f51993a = application;
    }

    public final void a(Activity activity, String str) {
        if (this.f51994b == null) {
            return;
        }
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.f51558d = "navigation";
        breadcrumb.b(str, "state");
        breadcrumb.b(activity.getClass().getSimpleName(), PaymentConstants.Event.SCREEN);
        breadcrumb.f51560f = "ui.lifecycle";
        breadcrumb.f51562h = SentryLevel.INFO;
        Hint hint = new Hint();
        hint.c(activity, "android:activity");
        this.f51994b.b(breadcrumb, hint);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f51995c) {
            this.f51993a.unregisterActivityLifecycleCallbacks(this);
            HubAdapter hubAdapter = this.f51994b;
            if (hubAdapter != null) {
                hubAdapter.y().getLogger().c(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f51994b = hubAdapter;
        this.f51995c = sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs();
        ILogger logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f51995c));
        if (this.f51995c) {
            this.f51993a.registerActivityLifecycleCallbacks(this);
            sentryOptions.getLogger().c(sentryLevel, "ActivityBreadcrumbIntegration installed.", new Object[0]);
            IntegrationUtils.a("ActivityBreadcrumbs");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, "created");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityDestroyed(Activity activity) {
        a(activity, "destroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityPaused(Activity activity) {
        a(activity, "paused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity activity) {
        a(activity, "resumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(activity, "saveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStarted(Activity activity) {
        a(activity, "started");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity activity) {
        a(activity, "stopped");
    }
}
