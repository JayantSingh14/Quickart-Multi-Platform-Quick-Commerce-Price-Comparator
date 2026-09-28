package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.OnRootViewsChangedListener;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.ReplayLifecycle;
import io.sentry.android.replay.ReplayState;
import io.sentry.android.replay.WindowsKt;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.util.FixedWindowCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@StabilityInferred(parameters = 0)
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class GestureRecorder implements OnRootViewsChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52615a;

    /* renamed from: b, reason: collision with root package name */
    public final ReplayIntegration f52616b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f52617c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f52618d;

    @Metadata
    public static final class SentryReplayGestureRecorder extends FixedWindowCallback {

        /* renamed from: b, reason: collision with root package name */
        public final SentryOptions f52619b;

        /* renamed from: c, reason: collision with root package name */
        public final ReplayIntegration f52620c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SentryReplayGestureRecorder(SentryOptions options, ReplayIntegration replayIntegration, Window.Callback callback) {
            super(callback);
            Intrinsics.checkNotNullParameter(options, "options");
            this.f52619b = options;
            this.f52620c = replayIntegration;
        }

        @Override // io.sentry.android.replay.util.FixedWindowCallback, android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            CaptureStrategy captureStrategy;
            if (motionEvent != null) {
                MotionEvent event = MotionEvent.obtainNoHistory(motionEvent);
                Intrinsics.checkNotNullExpressionValue(event, "obtainNoHistory(event)");
                try {
                    ReplayIntegration replayIntegration = this.f52620c;
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (replayIntegration.f52444j.get()) {
                        ReplayLifecycle replayLifecycle = replayIntegration.o;
                        if ((replayLifecycle.f52456a == ReplayState.STARTED || replayLifecycle.f52456a == ReplayState.RESUMED) && (captureStrategy = replayIntegration.f52446l) != null) {
                            captureStrategy.a(event);
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public GestureRecorder(SentryOptions options, ReplayIntegration touchRecorderCallback) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(touchRecorderCallback, "touchRecorderCallback");
        this.f52615a = options;
        this.f52616b = touchRecorderCallback;
        this.f52617c = new ArrayList();
        this.f52618d = new Object();
    }

    @Override // io.sentry.android.replay.OnRootViewsChangedListener
    public final void a(final View root, boolean z) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.f52618d) {
            try {
                if (z) {
                    this.f52617c.add(new WeakReference(root));
                    Window windowA = WindowsKt.a(root);
                    SentryOptions sentryOptions = this.f52615a;
                    if (windowA == null) {
                        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Window is invalid, not tracking gestures", new Object[0]);
                    } else {
                        Window.Callback callback = windowA.getCallback();
                        if (!(callback instanceof SentryReplayGestureRecorder)) {
                            windowA.setCallback(new SentryReplayGestureRecorder(sentryOptions, this.f52616b, callback));
                        }
                    }
                    Unit unit = Unit.f53572a;
                } else {
                    c(root);
                    CollectionsKt.N(this.f52617c, new Function1<WeakReference<View>, Boolean>() { // from class: io.sentry.android.replay.gestures.GestureRecorder$onRootViewsChanged$1$1
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
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f52618d) {
            try {
                Iterator it = this.f52617c.iterator();
                while (it.hasNext()) {
                    View view = (View) ((WeakReference) it.next()).get();
                    if (view != null) {
                        Intrinsics.checkNotNullExpressionValue(view, "get()");
                        c(view);
                    }
                }
                this.f52617c.clear();
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(View view) throws IllegalAccessException, IllegalArgumentException {
        Window windowA = WindowsKt.a(view);
        if (windowA == null) {
            this.f52615a.getLogger().c(SentryLevel.DEBUG, "Window was null in stopGestureTracking", new Object[0]);
            return;
        }
        Window.Callback callback = windowA.getCallback();
        if (callback instanceof SentryReplayGestureRecorder) {
            windowA.setCallback(((SentryReplayGestureRecorder) callback).f52629a);
        }
    }
}
