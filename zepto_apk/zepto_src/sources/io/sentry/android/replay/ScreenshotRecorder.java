package io.sentry.android.replay;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewTreeObserver;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.util.MainLooperHandler;
import io.sentry.android.replay.util.ViewsKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@TargetApi(26)
/* loaded from: classes3.dex */
public final class ScreenshotRecorder implements ViewTreeObserver.OnDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenshotRecorderConfig f52465a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryOptions f52466b;

    /* renamed from: c, reason: collision with root package name */
    public final MainLooperHandler f52467c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f52468d;

    /* renamed from: e, reason: collision with root package name */
    public final ReplayIntegration f52469e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f52470f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f52471g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f52472h;

    /* renamed from: i, reason: collision with root package name */
    public final Bitmap f52473i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f52474j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f52475k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f52476l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f52477m;
    public final AtomicBoolean n;

    @Metadata
    public static final class RecorderExecutorServiceThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f52478a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            StringBuilder sb = new StringBuilder("SentryReplayRecorder-");
            int i2 = this.f52478a;
            this.f52478a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(r, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public ScreenshotRecorder(ScreenshotRecorderConfig config, SentryOptions options, MainLooperHandler mainLooperHandler, ScheduledExecutorService recorder, ReplayIntegration replayIntegration) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(mainLooperHandler, "mainLooperHandler");
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        this.f52465a = config;
        this.f52466b = options;
        this.f52467c = mainLooperHandler;
        this.f52468d = recorder;
        this.f52469e = replayIntegration;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53530c;
        this.f52471g = LazyKt.a(lazyThreadSafetyMode, ScreenshotRecorder$maskingPaint$2.f52481c);
        this.f52472h = LazyKt.a(lazyThreadSafetyMode, ScreenshotRecorder$singlePixelBitmap$2.f52483c);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(config.f52485a, config.f52486b, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n        co…ap.Config.ARGB_8888\n    )");
        this.f52473i = bitmapCreateBitmap;
        this.f52474j = LazyKt.a(lazyThreadSafetyMode, new Function0<Canvas>() { // from class: io.sentry.android.replay.ScreenshotRecorder$singlePixelBitmapCanvas$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new Canvas((Bitmap) this.f52484c.f52472h.getValue());
            }
        });
        this.f52475k = LazyKt.a(lazyThreadSafetyMode, new Function0<Matrix>() { // from class: io.sentry.android.replay.ScreenshotRecorder$prescaledMatrix$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Matrix matrix = new Matrix();
                ScreenshotRecorderConfig screenshotRecorderConfig = this.f52482c.f52465a;
                matrix.preScale(screenshotRecorderConfig.f52487c, screenshotRecorderConfig.f52488d);
                return matrix;
            }
        });
        this.f52476l = new AtomicBoolean(false);
        this.f52477m = new AtomicBoolean(true);
        this.n = new AtomicBoolean(false);
    }

    public final void a(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        WeakReference weakReference = this.f52470f;
        b(weakReference != null ? (View) weakReference.get() : null);
        WeakReference weakReference2 = this.f52470f;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.f52470f = new WeakReference(root);
        ViewsKt.a(root, this);
        this.f52476l.set(true);
    }

    public final void b(View view) {
        if (view != null) {
            Intrinsics.checkNotNullParameter(this, "listener");
            if (view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
                return;
            }
            try {
                view.getViewTreeObserver().removeOnDrawListener(this);
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        WeakReference weakReference = this.f52470f;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
            this.f52466b.getLogger().c(SentryLevel.DEBUG, "Root view is invalid, not capturing screenshot", new Object[0]);
        } else {
            this.f52476l.set(true);
        }
    }
}
