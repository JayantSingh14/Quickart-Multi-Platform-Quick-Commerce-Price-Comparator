package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.sentry.Integration;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class CurrentActivityIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Application f52114a;

    public CurrentActivityIntegration(Application application) {
        this.f52114a = application;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f52114a.unregisterActivityLifecycleCallbacks(this);
        CurrentActivityHolder.f52112b.f52113a = null;
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f52114a.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if (weakReference == null || weakReference.get() != activity) {
            currentActivityHolder.f52113a = new WeakReference(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if ((weakReference != null ? (Activity) weakReference.get() : null) == activity) {
            currentActivityHolder.f52113a = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if ((weakReference != null ? (Activity) weakReference.get() : null) == activity) {
            currentActivityHolder.f52113a = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if (weakReference == null || weakReference.get() != activity) {
            currentActivityHolder.f52113a = new WeakReference(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if (weakReference == null || weakReference.get() != activity) {
            currentActivityHolder.f52113a = new WeakReference(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        WeakReference weakReference = currentActivityHolder.f52113a;
        if ((weakReference != null ? (Activity) weakReference.get() : null) == activity) {
            currentActivityHolder.f52113a = null;
        }
    }
}
