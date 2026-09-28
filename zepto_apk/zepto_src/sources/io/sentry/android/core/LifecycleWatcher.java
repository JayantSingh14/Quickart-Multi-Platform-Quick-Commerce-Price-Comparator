package io.sentry.android.core;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.modules.appstate.AppStateModule;
import io.sentry.Breadcrumb;
import io.sentry.HubAdapter;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.transport.CurrentDateProvider;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
final class LifecycleWatcher implements DefaultLifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f52144a;

    /* renamed from: b, reason: collision with root package name */
    public final long f52145b;

    /* renamed from: c, reason: collision with root package name */
    public TimerTask f52146c;

    /* renamed from: d, reason: collision with root package name */
    public final Timer f52147d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f52148e;

    /* renamed from: f, reason: collision with root package name */
    public final HubAdapter f52149f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f52150g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f52151h;

    /* renamed from: i, reason: collision with root package name */
    public final CurrentDateProvider f52152i;

    public LifecycleWatcher(long j2, boolean z, boolean z2) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        CurrentDateProvider currentDateProvider = CurrentDateProvider.f53091a;
        this.f52144a = new AtomicLong(0L);
        this.f52147d = new Timer(true);
        this.f52148e = new Object();
        this.f52145b = j2;
        this.f52150g = z;
        this.f52151h = z2;
        this.f52149f = hubAdapter;
        this.f52152i = currentDateProvider;
    }

    public final void b(String str) {
        if (this.f52151h) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.f51558d = "navigation";
            breadcrumb.b(str, "state");
            breadcrumb.f51560f = "app.lifecycle";
            breadcrumb.f51562h = SentryLevel.INFO;
            this.f52149f.a(breadcrumb);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.f52148e) {
            try {
                TimerTask timerTask = this.f52146c;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.f52146c = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f52152i.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        l lVar = new l(this, 0);
        HubAdapter hubAdapter = this.f52149f;
        hubAdapter.getClass();
        Sentry.c(lVar);
        AtomicLong atomicLong = this.f52144a;
        long j2 = atomicLong.get();
        if (j2 == 0 || j2 + this.f52145b <= jCurrentTimeMillis) {
            if (this.f52150g) {
                hubAdapter.p();
            }
            hubAdapter.y().getReplayController().start();
        }
        hubAdapter.y().getReplayController().resume();
        atomicLong.set(jCurrentTimeMillis);
        b("foreground");
        AppState appState = AppState.f52099b;
        synchronized (appState) {
            appState.f52100a = Boolean.FALSE;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        this.f52152i.getClass();
        this.f52144a.set(System.currentTimeMillis());
        this.f52149f.y().getReplayController().pause();
        synchronized (this.f52148e) {
            try {
                synchronized (this.f52148e) {
                    try {
                        TimerTask timerTask = this.f52146c;
                        if (timerTask != null) {
                            timerTask.cancel();
                            this.f52146c = null;
                        }
                    } finally {
                    }
                }
                if (this.f52147d != null) {
                    TimerTask timerTask2 = new TimerTask() { // from class: io.sentry.android.core.LifecycleWatcher.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public final void run() {
                            LifecycleWatcher lifecycleWatcher = LifecycleWatcher.this;
                            HubAdapter hubAdapter = lifecycleWatcher.f52149f;
                            if (lifecycleWatcher.f52150g) {
                                hubAdapter.l();
                            }
                            hubAdapter.y().getReplayController().stop();
                        }
                    };
                    this.f52146c = timerTask2;
                    this.f52147d.schedule(timerTask2, this.f52145b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AppState appState = AppState.f52099b;
        synchronized (appState) {
            appState.f52100a = Boolean.TRUE;
        }
        b(AppStateModule.APP_STATE_BACKGROUND);
    }
}
