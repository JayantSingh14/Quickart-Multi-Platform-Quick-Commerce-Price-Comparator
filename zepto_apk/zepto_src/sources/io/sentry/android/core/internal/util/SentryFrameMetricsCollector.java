package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Window;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.Objects;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryFrameMetricsCollector implements Application.ActivityLifecycleCallbacks {
    public static final long n = TimeUnit.SECONDS.toNanos(1);
    public static final long o = TimeUnit.MILLISECONDS.toNanos(700);
    public static final /* synthetic */ int p = 0;

    /* renamed from: a, reason: collision with root package name */
    public final BuildInfoProvider f52327a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f52328b;

    /* renamed from: c, reason: collision with root package name */
    public final AndroidLogger f52329c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f52330d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference f52331e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f52332f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f52333g;

    /* renamed from: h, reason: collision with root package name */
    public final WindowFrameMetricsManager f52334h;

    /* renamed from: i, reason: collision with root package name */
    public final d f52335i;

    /* renamed from: j, reason: collision with root package name */
    public Choreographer f52336j;

    /* renamed from: k, reason: collision with root package name */
    public final Field f52337k;

    /* renamed from: l, reason: collision with root package name */
    public long f52338l;

    /* renamed from: m, reason: collision with root package name */
    public long f52339m;

    /* renamed from: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements WindowFrameMetricsManager {
    }

    /* renamed from: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$2, reason: invalid class name */
    class AnonymousClass2 implements WindowFrameMetricsManager {
    }

    @ApiStatus.Internal
    /* loaded from: classes3.dex */
    public interface FrameMetricsCollectorListener {
        void e(long j2, long j3, long j4, long j5, boolean z, boolean z2, float f2);
    }

    @ApiStatus.Internal
    public interface WindowFrameMetricsManager {
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [io.sentry.android.core.internal.util.d] */
    public SentryFrameMetricsCollector(Context context, final AndroidLogger androidLogger, final BuildInfoProvider buildInfoProvider) throws NoSuchFieldException, SecurityException {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.f52328b = new CopyOnWriteArraySet();
        this.f52332f = new ConcurrentHashMap();
        this.f52333g = false;
        this.f52338l = 0L;
        this.f52339m = 0L;
        Context applicationContext = context.getApplicationContext();
        context = applicationContext != null ? applicationContext : context;
        Objects.b(androidLogger, "Logger is required");
        this.f52329c = androidLogger;
        Objects.b(buildInfoProvider, "BuildInfoProvider is required");
        this.f52327a = buildInfoProvider;
        this.f52334h = anonymousClass2;
        if (context instanceof Application) {
            this.f52333g = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.sentry.android.core.internal.util.c
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    int i2 = SentryFrameMetricsCollector.p;
                    androidLogger.b(SentryLevel.ERROR, "Error during frames measurements.", th);
                }
            });
            handlerThread.start();
            this.f52330d = new Handler(handlerThread.getLooper());
            ((Application) context).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new androidx.media3.common.util.c(5, this, androidLogger));
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.f52337k = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                androidLogger.b(SentryLevel.ERROR, "Unable to get the frame timestamp from the choreographer: ", e2);
            }
            this.f52335i = new Window.OnFrameMetricsAvailableListener() { // from class: io.sentry.android.core.internal.util.d
                /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
                @Override // android.view.Window.OnFrameMetricsAvailableListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void onFrameMetricsAvailable(android.view.Window r20, android.view.FrameMetrics r21, int r22) {
                    /*
                        Method dump skipped, instructions count: 231
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.d.onFrameMetricsAvailable(android.view.Window, android.view.FrameMetrics, int):void");
                }
            };
        }
    }

    public final void a(String str) {
        if (this.f52333g) {
            ConcurrentHashMap concurrentHashMap = this.f52332f;
            if (str != null) {
                concurrentHashMap.remove(str);
            }
            WeakReference weakReference = this.f52331e;
            Window window = weakReference != null ? (Window) weakReference.get() : null;
            if (window == null || !concurrentHashMap.isEmpty()) {
                return;
            }
            b(window);
        }
    }

    public final void b(Window window) {
        CopyOnWriteArraySet copyOnWriteArraySet = this.f52328b;
        if (copyOnWriteArraySet.contains(window)) {
            this.f52327a.getClass();
            try {
                WindowFrameMetricsManager windowFrameMetricsManager = this.f52334h;
                d dVar = this.f52335i;
                windowFrameMetricsManager.getClass();
                window.removeOnFrameMetricsAvailableListener(dVar);
            } catch (Exception e2) {
                this.f52329c.b(SentryLevel.ERROR, "Failed to remove frameMetricsAvailableListener", e2);
            }
            copyOnWriteArraySet.remove(window);
        }
    }

    public final void c() {
        WeakReference weakReference = this.f52331e;
        Window window = weakReference != null ? (Window) weakReference.get() : null;
        if (window == null || !this.f52333g) {
            return;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = this.f52328b;
        if (copyOnWriteArraySet.contains(window) || this.f52332f.isEmpty()) {
            return;
        }
        this.f52327a.getClass();
        Handler handler = this.f52330d;
        if (handler != null) {
            copyOnWriteArraySet.add(window);
            d dVar = this.f52335i;
            this.f52334h.getClass();
            window.addOnFrameMetricsAvailableListener(dVar, handler);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Window window = activity.getWindow();
        WeakReference weakReference = this.f52331e;
        if (weakReference == null || weakReference.get() != window) {
            this.f52331e = new WeakReference(window);
            c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        b(activity.getWindow());
        WeakReference weakReference = this.f52331e;
        if (weakReference == null || weakReference.get() != activity.getWindow()) {
            return;
        }
        this.f52331e = null;
    }
}
