package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;

/* loaded from: classes3.dex */
public class Fade extends Visibility {

    public static class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f12067a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12068b = false;

        public FadeAnimatorListener(View view) {
            this.f12067a = view;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
            View view = this.f12067a;
            view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? ViewUtils.f12184a.a(view) : 0.0f));
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
            this.f12067a.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ViewUtils.b(this.f12067a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            View view = this.f12067a;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.f12068b = true;
                view.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            boolean z2 = this.f12068b;
            View view = this.f12067a;
            if (z2) {
                view.setLayerType(0, null);
            }
            if (z) {
                return;
            }
            ViewUtils.b(view, 1.0f);
            ViewUtils.f12184a.getClass();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void c(Transition transition) {
        }
    }

    public Fade(int i2) {
        T(i2);
    }

    public static float V(TransitionValues transitionValues, float f2) {
        Float f3;
        return (transitionValues == null || (f3 = (Float) transitionValues.f12163a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.f12184a.getClass();
        return U(view, V(transitionValues, 0.0f), 1.0f);
    }

    @Override // androidx.transition.Visibility
    public final Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.f12184a.getClass();
        ObjectAnimator objectAnimatorU = U(view, V(transitionValues, 1.0f), 0.0f);
        if (objectAnimatorU == null) {
            ViewUtils.b(view, V(transitionValues2, 1.0f));
        }
        return objectAnimatorU;
    }

    public final ObjectAnimator U(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ViewUtils.b(view, f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) ViewUtils.f12185b, f3);
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        objectAnimatorOfFloat.addListener(fadeAnimatorListener);
        o().a(fadeAnimatorListener);
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        Visibility.P(transitionValues);
        Float fValueOf = (Float) transitionValues.f12164b.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (transitionValues.f12164b.getVisibility() == 0) {
                fValueOf = Float.valueOf(ViewUtils.f12184a.a(transitionValues.f12164b));
            } else {
                fValueOf = Float.valueOf(0.0f);
            }
        }
        transitionValues.f12163a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // androidx.transition.Transition
    public final boolean v() {
        return true;
    }

    public Fade() {
    }

    public Fade(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12109d);
        T(TypedArrayUtils.f(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.F));
        typedArrayObtainStyledAttributes.recycle();
    }
}
