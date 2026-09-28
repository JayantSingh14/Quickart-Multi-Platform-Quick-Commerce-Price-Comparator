package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.exoplayer.analytics.q;
import io.sentry.FullyDisplayedReporter;
import io.sentry.HubAdapter;
import io.sentry.IScope;
import io.sentry.ISpan;
import io.sentry.ITransaction;
import io.sentry.Instrumenter;
import io.sentry.Integration;
import io.sentry.MeasurementUnit;
import io.sentry.NoOpTransaction;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryDate;
import io.sentry.SentryLevel;
import io.sentry.SentryLongDate;
import io.sentry.SentryNanotimeDate;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import io.sentry.TracesSamplingDecision;
import io.sentry.TransactionContext;
import io.sentry.TransactionOptions;
import io.sentry.android.core.ActivityFramesTracker;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.android.core.performance.ActivityLifecycleTimeSpan;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ActivityLifecycleIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Application f52004a;

    /* renamed from: b, reason: collision with root package name */
    public final BuildInfoProvider f52005b;

    /* renamed from: c, reason: collision with root package name */
    public HubAdapter f52006c;

    /* renamed from: d, reason: collision with root package name */
    public SentryAndroidOptions f52007d;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f52010g;

    /* renamed from: j, reason: collision with root package name */
    public ISpan f52013j;
    public final ActivityFramesTracker r;

    /* renamed from: e, reason: collision with root package name */
    public boolean f52008e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f52009f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f52011h = false;

    /* renamed from: i, reason: collision with root package name */
    public FullyDisplayedReporter f52012i = null;

    /* renamed from: k, reason: collision with root package name */
    public final WeakHashMap f52014k = new WeakHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final WeakHashMap f52015l = new WeakHashMap();

    /* renamed from: m, reason: collision with root package name */
    public final WeakHashMap f52016m = new WeakHashMap();
    public SentryDate n = new SentryNanotimeDate(new Date(0), 0);
    public long o = 0;
    public Future p = null;
    public final WeakHashMap q = new WeakHashMap();

    public ActivityLifecycleIntegration(Application application, BuildInfoProvider buildInfoProvider, ActivityFramesTracker activityFramesTracker) {
        this.f52004a = application;
        this.f52005b = buildInfoProvider;
        this.r = activityFramesTracker;
        if (Build.VERSION.SDK_INT >= 29) {
            this.f52010g = true;
        }
    }

    public static void b(ISpan iSpan, ISpan iSpan2) {
        if (iSpan == null || iSpan.b()) {
            return;
        }
        String description = iSpan.getDescription();
        if (description == null || !description.endsWith(" - Deadline Exceeded")) {
            description = iSpan.getDescription() + " - Deadline Exceeded";
        }
        iSpan.d(description);
        SentryDate sentryDateP = iSpan2 != null ? iSpan2.p() : null;
        if (sentryDateP == null) {
            sentryDateP = iSpan.r();
        }
        c(iSpan, sentryDateP, SpanStatus.DEADLINE_EXCEEDED);
    }

    public static void c(ISpan iSpan, SentryDate sentryDate, SpanStatus spanStatus) {
        if (iSpan == null || iSpan.b()) {
            return;
        }
        if (spanStatus == null) {
            spanStatus = iSpan.getStatus() != null ? iSpan.getStatus() : SpanStatus.OK;
        }
        iSpan.q(spanStatus, sentryDate);
    }

    public final void a() {
        SentryLongDate sentryLongDate;
        long jA;
        TimeSpan timeSpanA = AppStartMetrics.b().a(this.f52007d);
        if (timeSpanA.d()) {
            if (timeSpanA.c()) {
                jA = timeSpanA.a() + timeSpanA.f52381b;
            } else {
                jA = 0;
            }
            sentryLongDate = new SentryLongDate(jA * 1000000);
        } else {
            sentryLongDate = null;
        }
        if (!this.f52008e || sentryLongDate == null) {
            return;
        }
        c(this.f52013j, sentryLongDate, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f52004a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f52007d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        ActivityFramesTracker activityFramesTracker = this.r;
        synchronized (activityFramesTracker) {
            try {
                if (activityFramesTracker.b()) {
                    activityFramesTracker.c(new a(activityFramesTracker, 2), "FrameMetricsAggregator.stop");
                    activityFramesTracker.f51996a.d();
                }
                activityFramesTracker.f51998c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(ITransaction iTransaction, ISpan iSpan, ISpan iSpan2) {
        if (iTransaction == null || iTransaction.b()) {
            return;
        }
        SpanStatus spanStatus = SpanStatus.DEADLINE_EXCEEDED;
        if (iSpan != null && !iSpan.b()) {
            iSpan.j(spanStatus);
        }
        b(iSpan2, iSpan);
        Future future = this.p;
        if (future != null) {
            future.cancel(false);
            this.p = null;
        }
        SpanStatus status = iTransaction.getStatus();
        if (status == null) {
            status = SpanStatus.OK;
        }
        iTransaction.j(status);
        if (this.f52006c != null) {
            Sentry.c(new androidx.media3.exoplayer.analytics.d(18, this, iTransaction));
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52007d = sentryAndroidOptions;
        this.f52006c = hubAdapter;
        this.f52008e = sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
        this.f52012i = this.f52007d.getFullyDisplayedReporter();
        this.f52009f = this.f52007d.isEnableTimeToFullDisplayTracing();
        this.f52004a.registerActivityLifecycleCallbacks(this);
        this.f52007d.getLogger().c(SentryLevel.DEBUG, "ActivityLifecycleIntegration installed.", new Object[0]);
        IntegrationUtils.a("ActivityLifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        FullyDisplayedReporter fullyDisplayedReporter;
        SentryAndroidOptions sentryAndroidOptions;
        try {
            if (!this.f52010g) {
                onActivityPreCreated(activity, bundle);
            }
            if (this.f52006c != null && (sentryAndroidOptions = this.f52007d) != null && sentryAndroidOptions.isEnableScreenTracking()) {
                String strA = ClassUtil.a(activity);
                HubAdapter hubAdapter = this.f52006c;
                l lVar = new l(strA, 1);
                hubAdapter.getClass();
                Sentry.c(lVar);
            }
            s(activity);
            ISpan iSpan = (ISpan) this.f52015l.get(activity);
            this.f52011h = true;
            if (this.f52008e && iSpan != null && (fullyDisplayedReporter = this.f52012i) != null) {
                fullyDisplayedReporter.f51634a.add(new l(iSpan, 2));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityDestroyed(Activity activity) {
        try {
            this.f52016m.remove(activity);
            if (this.f52008e) {
                ISpan iSpan = this.f52013j;
                SpanStatus spanStatus = SpanStatus.CANCELLED;
                if (iSpan != null && !iSpan.b()) {
                    iSpan.j(spanStatus);
                }
                ISpan iSpan2 = (ISpan) this.f52014k.get(activity);
                ISpan iSpan3 = (ISpan) this.f52015l.get(activity);
                SpanStatus spanStatus2 = SpanStatus.DEADLINE_EXCEEDED;
                if (iSpan2 != null && !iSpan2.b()) {
                    iSpan2.j(spanStatus2);
                }
                b(iSpan3, iSpan2);
                Future future = this.p;
                if (future != null) {
                    future.cancel(false);
                    this.p = null;
                }
                if (this.f52008e) {
                    e((ITransaction) this.q.get(activity), null, null);
                }
                this.f52013j = null;
                this.f52014k.remove(activity);
                this.f52015l.remove(activity);
            }
            this.q.remove(activity);
            if (this.q.isEmpty() && !activity.isChangingConfigurations()) {
                this.f52011h = false;
                this.f52016m.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityPaused(Activity activity) {
        if (!this.f52010g) {
            onActivityPrePaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity activity, Bundle bundle) {
        ISpan iSpan = this.f52013j;
        WeakHashMap weakHashMap = this.f52016m;
        if (iSpan == null) {
            weakHashMap.remove(activity);
            return;
        }
        ActivityLifecycleTimeSpan activityLifecycleTimeSpan = (ActivityLifecycleTimeSpan) weakHashMap.get(activity);
        if (activityLifecycleTimeSpan != null) {
            TimeSpan timeSpan = activityLifecycleTimeSpan.f52365a;
            timeSpan.g();
            timeSpan.f52380a = activity.getClass().getName().concat(".onCreate");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostStarted(Activity activity) {
        ActivityLifecycleTimeSpan activityLifecycleTimeSpan = (ActivityLifecycleTimeSpan) this.f52016m.remove(activity);
        if (this.f52013j == null || activityLifecycleTimeSpan == null) {
            return;
        }
        TimeSpan timeSpan = activityLifecycleTimeSpan.f52366b;
        timeSpan.g();
        timeSpan.f52380a = activity.getClass().getName().concat(".onStart");
        AppStartMetrics.b().f52373g.add(activityLifecycleTimeSpan);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        if (this.f52011h) {
            return;
        }
        HubAdapter hubAdapter = this.f52006c;
        this.n = hubAdapter != null ? hubAdapter.y().getDateProvider().now() : AndroidDateUtils.a();
        this.o = SystemClock.uptimeMillis();
        ActivityLifecycleTimeSpan activityLifecycleTimeSpan = new ActivityLifecycleTimeSpan();
        activityLifecycleTimeSpan.f52365a.e(this.o);
        this.f52016m.put(activity, activityLifecycleTimeSpan);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPrePaused(Activity activity) {
        this.f52011h = true;
        HubAdapter hubAdapter = this.f52006c;
        this.n = hubAdapter != null ? hubAdapter.y().getDateProvider().now() : AndroidDateUtils.a();
        this.o = SystemClock.uptimeMillis();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStarted(Activity activity) {
        ActivityLifecycleTimeSpan activityLifecycleTimeSpan;
        if (this.f52013j == null || (activityLifecycleTimeSpan = (ActivityLifecycleTimeSpan) this.f52016m.get(activity)) == null) {
            return;
        }
        activityLifecycleTimeSpan.f52366b.e(SystemClock.uptimeMillis());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity activity) {
        try {
            if (!this.f52010g) {
                onActivityPostStarted(activity);
            }
            if (this.f52008e) {
                ISpan iSpan = (ISpan) this.f52014k.get(activity);
                ISpan iSpan2 = (ISpan) this.f52015l.get(activity);
                if (activity.getWindow() != null) {
                    FirstDrawDoneListener.a(activity, new c(this, iSpan2, iSpan, 0), this.f52005b);
                } else {
                    new Handler(Looper.getMainLooper()).post(new c(this, iSpan2, iSpan, 1));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStarted(Activity activity) {
        try {
            if (!this.f52010g) {
                onActivityPostCreated(activity, null);
                onActivityPreStarted(activity);
            }
            if (this.f52008e) {
                ActivityFramesTracker activityFramesTracker = this.r;
                synchronized (activityFramesTracker) {
                    if (activityFramesTracker.b()) {
                        activityFramesTracker.c(new b(activityFramesTracker, activity, 0), "FrameMetricsAggregator.add");
                        ActivityFramesTracker.FrameCounts frameCountsA = activityFramesTracker.a();
                        if (frameCountsA != null) {
                            activityFramesTracker.f51999d.put(activity, frameCountsA);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void r(ISpan iSpan, ISpan iSpan2) {
        AppStartMetrics appStartMetricsB = AppStartMetrics.b();
        TimeSpan timeSpan = appStartMetricsB.f52369c;
        if (timeSpan.c() && timeSpan.f52383d == 0) {
            timeSpan.g();
        }
        TimeSpan timeSpan2 = appStartMetricsB.f52370d;
        if (timeSpan2.c() && timeSpan2.f52383d == 0) {
            timeSpan2.g();
        }
        a();
        SentryAndroidOptions sentryAndroidOptions = this.f52007d;
        if (sentryAndroidOptions == null || iSpan2 == null) {
            if (iSpan2 == null || iSpan2.b()) {
                return;
            }
            iSpan2.c();
            return;
        }
        SentryDate sentryDateNow = sentryAndroidOptions.getDateProvider().now();
        long millis = TimeUnit.NANOSECONDS.toMillis(sentryDateNow.b(iSpan2.r()));
        Long lValueOf = Long.valueOf(millis);
        MeasurementUnit.Duration duration = MeasurementUnit.Duration.MILLISECOND;
        iSpan2.f("time_to_initial_display", lValueOf, duration);
        if (iSpan != null && iSpan.b()) {
            iSpan.h(sentryDateNow);
            iSpan2.f("time_to_full_display", Long.valueOf(millis), duration);
        }
        c(iSpan2, sentryDateNow, null);
    }

    public final void s(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        SentryLongDate sentryLongDateB;
        Boolean boolValueOf;
        SentryDate sentryDate;
        WeakReference weakReference = new WeakReference(activity);
        if (this.f52006c != null) {
            WeakHashMap weakHashMap3 = this.q;
            if (weakHashMap3.containsKey(activity)) {
                return;
            }
            if (!this.f52008e) {
                weakHashMap3.put(activity, NoOpTransaction.f51714a);
                HubAdapter hubAdapter = this.f52006c;
                androidx.work.impl.model.a aVar = new androidx.work.impl.model.a(27);
                hubAdapter.getClass();
                Sentry.c(aVar);
                return;
            }
            Iterator it = weakHashMap3.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                weakHashMap = this.f52015l;
                weakHashMap2 = this.f52014k;
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                e((ITransaction) entry.getValue(), (ISpan) weakHashMap2.get(entry.getKey()), (ISpan) weakHashMap.get(entry.getKey()));
            }
            String simpleName = activity.getClass().getSimpleName();
            TimeSpan timeSpanA = AppStartMetrics.b().a(this.f52007d);
            TracesSamplingDecision tracesSamplingDecision = null;
            if (((Boolean) ContextUtils.f52104b.a()).booleanValue() && timeSpanA.c()) {
                sentryLongDateB = timeSpanA.b();
                boolValueOf = Boolean.valueOf(AppStartMetrics.b().f52367a == AppStartMetrics.AppStartType.COLD);
            } else {
                sentryLongDateB = null;
                boolValueOf = null;
            }
            TransactionOptions transactionOptions = new TransactionOptions();
            transactionOptions.d();
            if (this.f52007d.isEnableActivityLifecycleTracingAutoFinish()) {
                transactionOptions.e(this.f52007d.getIdleTimeout());
                transactionOptions.a();
            }
            transactionOptions.h();
            transactionOptions.g(new d(this, weakReference, simpleName));
            if (this.f52011h || sentryLongDateB == null || boolValueOf == null) {
                sentryDate = this.n;
            } else {
                TracesSamplingDecision tracesSamplingDecision2 = AppStartMetrics.b().f52375i;
                AppStartMetrics.b().f52375i = null;
                tracesSamplingDecision = tracesSamplingDecision2;
                sentryDate = sentryLongDateB;
            }
            transactionOptions.f(sentryDate);
            transactionOptions.c(tracesSamplingDecision != null);
            final ITransaction iTransactionB = this.f52006c.B(new TransactionContext(simpleName, TransactionNameSource.COMPONENT, "ui.load", tracesSamplingDecision), transactionOptions);
            if (iTransactionB != null) {
                iTransactionB.o().f51929i = "auto.ui.activity";
            }
            if (!this.f52011h && sentryLongDateB != null && boolValueOf != null) {
                ISpan iSpanK = iTransactionB.k(boolValueOf.booleanValue() ? "app.start.cold" : "app.start.warm", boolValueOf.booleanValue() ? "Cold Start" : "Warm Start", sentryLongDateB, Instrumenter.SENTRY);
                this.f52013j = iSpanK;
                iSpanK.o().f51929i = "auto.ui.activity";
                a();
            }
            String strConcat = simpleName.concat(" initial display");
            Instrumenter instrumenter = Instrumenter.SENTRY;
            ISpan iSpanK2 = iTransactionB.k("ui.load.initial_display", strConcat, sentryDate, instrumenter);
            weakHashMap2.put(activity, iSpanK2);
            iSpanK2.o().f51929i = "auto.ui.activity";
            if (this.f52009f && this.f52012i != null && this.f52007d != null) {
                ISpan iSpanK3 = iTransactionB.k("ui.load.full_display", simpleName.concat(" full display"), sentryDate, instrumenter);
                iSpanK3.o().f51929i = "auto.ui.activity";
                try {
                    weakHashMap.put(activity, iSpanK3);
                    this.p = this.f52007d.getExecutorService().a(25000L, new c(this, iSpanK3, iSpanK2, 2));
                } catch (RejectedExecutionException e2) {
                    this.f52007d.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", e2);
                }
            }
            HubAdapter hubAdapter2 = this.f52006c;
            ScopeCallback scopeCallback = new ScopeCallback() { // from class: io.sentry.android.core.e
                @Override // io.sentry.ScopeCallback
                public final void h(IScope iScope) {
                    ActivityLifecycleIntegration activityLifecycleIntegration = this.f52251a;
                    activityLifecycleIntegration.getClass();
                    iScope.F(new q(activityLifecycleIntegration, iScope, iTransactionB, 4));
                }
            };
            hubAdapter2.getClass();
            Sentry.c(scopeCallback);
            weakHashMap3.put(activity, iTransactionB);
        }
    }
}
