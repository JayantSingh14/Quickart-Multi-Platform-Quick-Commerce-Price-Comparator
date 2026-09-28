package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.gestures.SentryGestureListener;
import io.sentry.internal.gestures.UiElement;
import java.util.Collections;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryWindowCallback extends WindowCallbackAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f52275b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryGestureListener f52276c;

    /* renamed from: d, reason: collision with root package name */
    public final GestureDetectorCompat f52277d;

    /* renamed from: e, reason: collision with root package name */
    public final SentryOptions f52278e;

    /* renamed from: f, reason: collision with root package name */
    public final AnonymousClass1 f52279f;

    /* renamed from: io.sentry.android.core.internal.gestures.SentryWindowCallback$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements MotionEventObtainer {
    }

    /* loaded from: classes3.dex */
    public interface MotionEventObtainer {
        static MotionEvent a(MotionEvent motionEvent) {
            return MotionEvent.obtain(motionEvent);
        }
    }

    public SentryWindowCallback(Window.Callback callback, Activity activity, SentryGestureListener sentryGestureListener, SentryOptions sentryOptions) {
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(activity, sentryGestureListener);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        super(callback);
        this.f52275b = callback;
        this.f52276c = sentryGestureListener;
        this.f52278e = sentryOptions;
        this.f52277d = gestureDetectorCompat;
        this.f52279f = anonymousClass1;
    }

    public final void a(MotionEvent motionEvent) {
        this.f52277d.f3041a.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            SentryGestureListener sentryGestureListener = this.f52276c;
            View viewB = sentryGestureListener.b("onUp");
            SentryGestureListener.ScrollState scrollState = sentryGestureListener.f52269g;
            UiElement uiElement = scrollState.f52272b;
            if (viewB == null || uiElement == null) {
                return;
            }
            SentryGestureListener.GestureType gestureType = scrollState.f52271a;
            SentryGestureListener.GestureType gestureType2 = SentryGestureListener.GestureType.Unknown;
            if (gestureType == gestureType2) {
                sentryGestureListener.f52265c.getLogger().c(SentryLevel.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
                return;
            }
            float x = motionEvent.getX() - scrollState.f52273c;
            float y = motionEvent.getY() - scrollState.f52274d;
            sentryGestureListener.a(uiElement, scrollState.f52271a, Collections.singletonMap("direction", Math.abs(x) > Math.abs(y) ? x > 0.0f ? "right" : "left" : y > 0.0f ? "down" : "up"), motionEvent);
            sentryGestureListener.c(uiElement, scrollState.f52271a);
            scrollState.f52272b = null;
            scrollState.f52271a = gestureType2;
            scrollState.f52273c = 0.0f;
            scrollState.f52274d = 0.0f;
        }
    }

    @Override // io.sentry.android.core.internal.gestures.WindowCallbackAdapter, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        SentryOptions sentryOptions;
        if (motionEvent != null) {
            this.f52279f.getClass();
            try {
                a(MotionEventObtainer.a(motionEvent));
            } finally {
                if (sentryOptions != null) {
                    try {
                    } finally {
                    }
                }
            }
        }
        return this.f52281a.dispatchTouchEvent(motionEvent);
    }
}
