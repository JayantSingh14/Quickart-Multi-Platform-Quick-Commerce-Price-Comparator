package io.sentry.android.core.performance;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import io.sentry.ITransactionProfiler;
import io.sentry.NoOpLogger;
import io.sentry.TracesSamplingDecision;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class AppStartMetrics extends ActivityLifecycleCallbacksAdapter {
    public static long n = SystemClock.uptimeMillis();
    public static volatile AppStartMetrics o;

    /* renamed from: a, reason: collision with root package name */
    public AppStartType f52367a = AppStartType.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public ITransactionProfiler f52374h = null;

    /* renamed from: i, reason: collision with root package name */
    public TracesSamplingDecision f52375i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f52376j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f52377k = true;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f52378l = new AtomicInteger();

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f52379m = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final TimeSpan f52369c = new TimeSpan();

    /* renamed from: d, reason: collision with root package name */
    public final TimeSpan f52370d = new TimeSpan();

    /* renamed from: e, reason: collision with root package name */
    public final TimeSpan f52371e = new TimeSpan();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f52372f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f52373g = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f52368b = ((Boolean) ContextUtils.f52104b.a()).booleanValue();

    public enum AppStartType {
        UNKNOWN,
        COLD,
        WARM
    }

    public static AppStartMetrics b() {
        if (o == null) {
            synchronized (AppStartMetrics.class) {
                try {
                    if (o == null) {
                        o = new AppStartMetrics();
                    }
                } finally {
                }
            }
        }
        return o;
    }

    public final TimeSpan a(SentryAndroidOptions sentryAndroidOptions) {
        if (this.f52367a != AppStartType.UNKNOWN && this.f52368b) {
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                TimeSpan timeSpan = this.f52369c;
                if (timeSpan.c() && timeSpan.a() <= TimeUnit.MINUTES.toMillis(1L)) {
                    return timeSpan;
                }
            }
            TimeSpan timeSpan2 = this.f52370d;
            if (timeSpan2.c() && timeSpan2.a() <= TimeUnit.MINUTES.toMillis(1L)) {
                return timeSpan2;
            }
        }
        return new TimeSpan();
    }

    public final synchronized void c() {
        if (!this.f52379m.getAndSet(true)) {
            AppStartMetrics appStartMetricsB = b();
            appStartMetricsB.f52370d.g();
            appStartMetricsB.f52369c.g();
        }
    }

    public final void d(Application application) {
        if (this.f52376j) {
            return;
        }
        boolean z = true;
        this.f52376j = true;
        if (!this.f52368b && !((Boolean) ContextUtils.f52104b.a()).booleanValue()) {
            z = false;
        }
        this.f52368b = z;
        application.registerActivityLifecycleCallbacks(o);
        new Handler(Looper.getMainLooper()).post(new a(this, 0));
    }

    @Override // io.sentry.android.core.performance.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f52378l.incrementAndGet() == 1 && !this.f52379m.get()) {
            TimeSpan timeSpan = this.f52369c;
            long j2 = jUptimeMillis - timeSpan.f52382c;
            if (!this.f52368b || j2 > TimeUnit.MINUTES.toMillis(1L)) {
                this.f52367a = AppStartType.WARM;
                this.f52377k = true;
                timeSpan.f52380a = null;
                timeSpan.f52382c = 0L;
                timeSpan.f52383d = 0L;
                timeSpan.f52381b = 0L;
                timeSpan.f52382c = SystemClock.uptimeMillis();
                timeSpan.f52381b = System.currentTimeMillis();
                System.nanoTime();
                timeSpan.e(jUptimeMillis);
                n = jUptimeMillis;
                this.f52372f.clear();
                TimeSpan timeSpan2 = this.f52371e;
                timeSpan2.f52380a = null;
                timeSpan2.f52382c = 0L;
                timeSpan2.f52383d = 0L;
                timeSpan2.f52381b = 0L;
            } else {
                this.f52367a = bundle == null ? AppStartType.COLD : AppStartType.WARM;
            }
        }
        this.f52368b = true;
    }

    @Override // io.sentry.android.core.performance.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f52378l.decrementAndGet() != 0 || activity.isChangingConfigurations()) {
            return;
        }
        this.f52368b = false;
        this.f52377k = true;
        this.f52379m.set(false);
    }

    @Override // io.sentry.android.core.performance.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f52379m.get()) {
            return;
        }
        if (activity.getWindow() != null) {
            FirstDrawDoneListener.a(activity, new a(this, 1), new BuildInfoProvider(NoOpLogger.f51707a));
        } else {
            new Handler(Looper.getMainLooper()).post(new a(this, 2));
        }
    }
}
