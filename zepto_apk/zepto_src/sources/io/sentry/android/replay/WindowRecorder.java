package io.sentry.android.replay;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.view.View;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.MainLooperHandler;
import io.sentry.android.replay.util.ViewsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WindowRecorder implements Recorder, OnRootViewsChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52499a;

    /* renamed from: b, reason: collision with root package name */
    public final ReplayIntegration f52500b;

    /* renamed from: c, reason: collision with root package name */
    public final MainLooperHandler f52501c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f52502d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f52503e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f52504f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f52505g;

    /* renamed from: h, reason: collision with root package name */
    public ScreenshotRecorder f52506h;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledFuture f52507i;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f52508j;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class RecorderExecutorServiceThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f52509a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            StringBuilder sb = new StringBuilder("SentryWindowRecorder-");
            int i2 = this.f52509a;
            this.f52509a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(r, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public WindowRecorder(SentryOptions options, ReplayIntegration replayIntegration, MainLooperHandler mainLooperHandler, ScheduledExecutorService replayExecutor) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(mainLooperHandler, "mainLooperHandler");
        Intrinsics.checkNotNullParameter(replayExecutor, "replayExecutor");
        this.f52499a = options;
        this.f52500b = replayIntegration;
        this.f52501c = mainLooperHandler;
        this.f52502d = replayExecutor;
        this.f52503e = new AtomicBoolean(false);
        this.f52504f = new ArrayList();
        this.f52505g = new Object();
        this.f52508j = LazyKt.b(WindowRecorder$capturer$2.f52510c);
    }

    @Override // io.sentry.android.replay.OnRootViewsChangedListener
    public final void a(final View root, boolean z) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.f52505g) {
            try {
                if (z) {
                    this.f52504f.add(new WeakReference(root));
                    ScreenshotRecorder screenshotRecorder = this.f52506h;
                    if (screenshotRecorder != null) {
                        screenshotRecorder.a(root);
                        Unit unit = Unit.f53572a;
                    }
                } else {
                    ScreenshotRecorder screenshotRecorder2 = this.f52506h;
                    if (screenshotRecorder2 != null) {
                        screenshotRecorder2.b(root);
                    }
                    CollectionsKt.N(this.f52504f, new Function1<WeakReference<View>, Boolean>() { // from class: io.sentry.android.replay.WindowRecorder$onRootViewsChanged$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            WeakReference it = (WeakReference) obj;
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(Intrinsics.b(it.get(), root));
                        }
                    });
                    WeakReference weakReference = (WeakReference) CollectionsKt.G(this.f52504f);
                    View view = weakReference != null ? (View) weakReference.get() : null;
                    if (view == null || Intrinsics.b(root, view)) {
                        Unit unit2 = Unit.f53572a;
                    } else {
                        ScreenshotRecorder screenshotRecorder3 = this.f52506h;
                        if (screenshotRecorder3 != null) {
                            screenshotRecorder3.a(view);
                            Unit unit3 = Unit.f53572a;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        stop();
        ScheduledExecutorService capturer = (ScheduledExecutorService) this.f52508j.getValue();
        Intrinsics.checkNotNullExpressionValue(capturer, "capturer");
        ExecutorsKt.a(capturer, this.f52499a);
    }

    @Override // io.sentry.android.replay.Recorder
    public final void i0(ScreenshotRecorderConfig recorderConfig) {
        ScheduledFuture<?> scheduledFutureScheduleAtFixedRate;
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        if (this.f52503e.getAndSet(true)) {
            return;
        }
        ReplayIntegration replayIntegration = this.f52500b;
        SentryOptions options = this.f52499a;
        this.f52506h = new ScreenshotRecorder(recorderConfig, options, this.f52501c, this.f52502d, replayIntegration);
        ScheduledExecutorService capturer = (ScheduledExecutorService) this.f52508j.getValue();
        Intrinsics.checkNotNullExpressionValue(capturer, "capturer");
        long j2 = 1000 / recorderConfig.f52489e;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        c task = new c(this, 2);
        Intrinsics.checkNotNullParameter(capturer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter("WindowRecorder.capture", "taskName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            scheduledFutureScheduleAtFixedRate = capturer.scheduleAtFixedRate(new in.juspay.hypernfc.b(22, task, options), 100L, j2, unit);
        } catch (Throwable th) {
            options.getLogger().b(SentryLevel.ERROR, "Failed to submit task WindowRecorder.capture to executor", th);
            scheduledFutureScheduleAtFixedRate = null;
        }
        this.f52507i = scheduledFutureScheduleAtFixedRate;
    }

    @Override // io.sentry.android.replay.Recorder
    public final void pause() {
        ScreenshotRecorder screenshotRecorder = this.f52506h;
        if (screenshotRecorder != null) {
            screenshotRecorder.f52477m.set(false);
            WeakReference weakReference = screenshotRecorder.f52470f;
            screenshotRecorder.b(weakReference != null ? (View) weakReference.get() : null);
        }
    }

    @Override // io.sentry.android.replay.Recorder
    public final void resume() {
        View view;
        ScreenshotRecorder screenshotRecorder = this.f52506h;
        if (screenshotRecorder != null) {
            WeakReference weakReference = screenshotRecorder.f52470f;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                ViewsKt.a(view, screenshotRecorder);
            }
            screenshotRecorder.f52477m.set(true);
        }
    }

    @Override // io.sentry.android.replay.Recorder
    public final void stop() {
        synchronized (this.f52505g) {
            try {
                for (WeakReference weakReference : this.f52504f) {
                    ScreenshotRecorder screenshotRecorder = this.f52506h;
                    if (screenshotRecorder != null) {
                        screenshotRecorder.b((View) weakReference.get());
                    }
                }
                this.f52504f.clear();
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        ScreenshotRecorder screenshotRecorder2 = this.f52506h;
        if (screenshotRecorder2 != null) {
            WeakReference weakReference2 = screenshotRecorder2.f52470f;
            screenshotRecorder2.b(weakReference2 != null ? (View) weakReference2.get() : null);
            WeakReference weakReference3 = screenshotRecorder2.f52470f;
            if (weakReference3 != null) {
                weakReference3.clear();
            }
            Bitmap bitmap = screenshotRecorder2.f52473i;
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            screenshotRecorder2.f52477m.set(false);
        }
        this.f52506h = null;
        ScheduledFuture scheduledFuture = this.f52507i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f52507i = null;
        this.f52503e.set(false);
    }
}
