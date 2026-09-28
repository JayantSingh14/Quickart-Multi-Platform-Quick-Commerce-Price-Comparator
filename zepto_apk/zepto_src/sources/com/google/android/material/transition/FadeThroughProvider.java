package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes4.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {

    /* renamed from: com.google.android.material.transition.FadeThroughProvider$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41498a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41499b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f41500c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f41501d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f41502e;

        public AnonymousClass1(View view, float f2, float f3, float f4, float f5) {
            this.f41498a = view;
            this.f41499b = f2;
            this.f41500c = f3;
            this.f41501d = f4;
            this.f41502e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f41498a.setAlpha(TransitionUtils.d(this.f41499b, this.f41500c, this.f41501d, this.f41502e, ((Float) valueAnimator.getAnimatedValue()).floatValue(), false));
        }
    }

    /* renamed from: com.google.android.material.transition.FadeThroughProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41503a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41504b;

        public AnonymousClass2(View view, float f2) {
            this.f41503a = view;
            this.f41504b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f41503a.setAlpha(this.f41504b);
        }
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator a(View view) {
        float alpha = view.getAlpha() != 0.0f ? view.getAlpha() : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, alpha, 0.0f, 0.0f, 0.35f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator b(View view) {
        float alpha = view.getAlpha() != 0.0f ? view.getAlpha() : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, 0.0f, alpha, 0.35f, 1.0f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }
}
