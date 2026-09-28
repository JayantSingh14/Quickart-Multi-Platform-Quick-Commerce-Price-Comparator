package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.animation.BaseInterpolator;
import androidx.transition.Transition;

/* loaded from: classes3.dex */
class TranslationAnimationCreator {
    public static ObjectAnimator a(View view, TransitionValues transitionValues, int i2, int i3, float f2, float f3, float f4, float f5, BaseInterpolator baseInterpolator, Visibility visibility) {
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.f12164b.getTag(R.id.transition_position)) != null) {
            f2 = (r5[0] - i2) + translationX;
            f6 = (r5[1] - i3) + translationY;
        } else {
            f6 = f3;
        }
        view.setTranslationX(f2);
        view.setTranslationY(f6);
        if (f2 == f4 && f6 == f5) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f2, f4), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f5));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.f12164b, translationX, translationY);
        visibility.a(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.addListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(baseInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f12170a;

        /* renamed from: b, reason: collision with root package name */
        public final View f12171b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f12172c;

        /* renamed from: d, reason: collision with root package name */
        public float f12173d;

        /* renamed from: e, reason: collision with root package name */
        public float f12174e;

        /* renamed from: f, reason: collision with root package name */
        public final float f12175f;

        /* renamed from: g, reason: collision with root package name */
        public final float f12176g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f12177h;

        public TransitionPositionListener(View view, View view2, float f2, float f3) {
            this.f12171b = view;
            this.f12170a = view2;
            this.f12175f = f2;
            this.f12176g = f3;
            int[] iArr = (int[]) view2.getTag(R.id.transition_position);
            this.f12172c = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transition_position, null);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
            if (this.f12172c == null) {
                this.f12172c = new int[2];
            }
            int[] iArr = this.f12172c;
            View view = this.f12171b;
            view.getLocationOnScreen(iArr);
            this.f12170a.setTag(R.id.transition_position, this.f12172c);
            this.f12173d = view.getTranslationX();
            this.f12174e = view.getTranslationY();
            view.setTranslationX(this.f12175f);
            view.setTranslationY(this.f12176g);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void e(Transition transition) {
            if (this.f12177h) {
                return;
            }
            this.f12170a.setTag(R.id.transition_position, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
            float f2 = this.f12173d;
            View view = this.f12171b;
            view.setTranslationX(f2);
            view.setTranslationY(this.f12174e);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
            e(transition);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
            this.f12177h = true;
            float f2 = this.f12175f;
            View view = this.f12171b;
            view.setTranslationX(f2);
            view.setTranslationY(this.f12176g);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f12177h = true;
            float f2 = this.f12175f;
            View view = this.f12171b;
            view.setTranslationX(f2);
            view.setTranslationY(this.f12176g);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            float f2 = this.f12175f;
            View view = this.f12171b;
            view.setTranslationX(f2);
            view.setTranslationY(this.f12176g);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }
    }
}
