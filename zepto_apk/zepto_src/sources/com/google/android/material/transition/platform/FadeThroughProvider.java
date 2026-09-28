package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {

    /* renamed from: com.google.android.material.transition.platform.FadeThroughProvider$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41569a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41570b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f41571c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f41572d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f41573e;

        public AnonymousClass1(View view, float f2, float f3, float f4, float f5) {
            this.f41569a = view;
            this.f41570b = f2;
            this.f41571c = f3;
            this.f41572d = f4;
            this.f41573e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f41569a.setAlpha(TransitionUtils.d(this.f41570b, this.f41571c, this.f41572d, this.f41573e, ((Float) valueAnimator.getAnimatedValue()).floatValue(), false));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeThroughProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41574a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f41575b;

        public AnonymousClass2(View view, float f2) {
            this.f41574a = view;
            this.f41575b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f41574a.setAlpha(this.f41575b);
        }
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator a(View view) {
        float alpha = view.getAlpha() != 0.0f ? view.getAlpha() : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, alpha, 0.0f, 0.0f, 0.35f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator b(View view) {
        float alpha = view.getAlpha() != 0.0f ? view.getAlpha() : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, 0.0f, alpha, 0.35f, 1.0f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }
}
