package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes3.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f3061a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f3062b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f3063c;

    public OneShotPreDrawListener(View view, Runnable runnable) {
        this.f3061a = view;
        this.f3062b = view.getViewTreeObserver();
        this.f3063c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f3062b.isAlive()) {
            this.f3062b.removeOnPreDrawListener(this);
        } else {
            this.f3061a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3061a.removeOnAttachStateChangeListener(this);
        this.f3063c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f3062b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        if (this.f3062b.isAlive()) {
            this.f3062b.removeOnPreDrawListener(this);
        } else {
            this.f3061a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3061a.removeOnAttachStateChangeListener(this);
    }
}
