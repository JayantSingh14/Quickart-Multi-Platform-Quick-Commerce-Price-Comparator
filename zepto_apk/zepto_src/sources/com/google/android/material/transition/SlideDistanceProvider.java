package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {

    /* renamed from: com.google.android.material.transition.SlideDistanceProvider$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            throw null;
        }
    }

    /* renamed from: com.google.android.material.transition.SlideDistanceProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            throw null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface GravityFlag {
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator a(View view) {
        view.getContext();
        view.getTranslationX();
        view.getTranslationY();
        throw new IllegalArgumentException("Invalid slide direction: 0");
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator b(View view) {
        view.getContext();
        view.getTranslationX();
        view.getTranslationY();
        throw new IllegalArgumentException("Invalid slide direction: 0");
    }
}
