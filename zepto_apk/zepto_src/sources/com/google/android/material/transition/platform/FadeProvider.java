package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {

    /* renamed from: a, reason: collision with root package name */
    public float f41562a = 1.0f;

    /* renamed from: com.google.android.material.transition.platform.FadeProvider$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41563a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41564b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f41565c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f41566d;

        public AnonymousClass1(View view, float f2, float f3, float f4) {
            this.f41563a = view;
            this.f41564b = f2;
            this.f41565c = f3;
            this.f41566d = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f41563a.setAlpha(TransitionUtils.d(this.f41564b, this.f41565c, 0.0f, this.f41566d, fFloatValue, false));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41567a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41568b;

        public AnonymousClass2(View view, float f2) {
            this.f41567a = view;
            this.f41568b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f41567a.setAlpha(this.f41568b);
        }
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator a(View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, alpha, 0.0f, 1.0f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator b(View view) {
        float alpha = view.getAlpha() != 0.0f ? view.getAlpha() : 1.0f;
        float f2 = this.f41562a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, 0.0f, alpha, f2));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }
}
