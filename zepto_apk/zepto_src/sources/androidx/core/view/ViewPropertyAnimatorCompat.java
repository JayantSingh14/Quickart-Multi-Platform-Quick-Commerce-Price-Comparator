package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f3117a;

    @RequiresApi
    public static class Api21Impl {
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.f3117a = new WeakReference(view);
    }

    public final void a(float f2) {
        View view = (View) this.f3117a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
    }

    public final void b() {
        View view = (View) this.f3117a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j2) {
        View view = (View) this.f3117a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    public final void d(final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        final View view = (View) this.f3117a.get();
        if (view != null) {
            if (viewPropertyAnimatorListener != null) {
                view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator animator) {
                        viewPropertyAnimatorListener.onAnimationCancel(view);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        viewPropertyAnimatorListener.onAnimationEnd(view);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator) {
                        viewPropertyAnimatorListener.onAnimationStart(view);
                    }
                });
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f2) {
        View view = (View) this.f3117a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
    }
}
