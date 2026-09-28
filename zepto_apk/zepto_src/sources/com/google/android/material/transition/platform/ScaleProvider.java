package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a, reason: collision with root package name */
    public float f41648a = 0.8f;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41649b = true;

    public static ObjectAnimator c(final View view, float f2, float f3) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f2, scaleX * f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f2 * scaleY, f3 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                float f4 = scaleX;
                View view2 = view;
                view2.setScaleX(f4);
                view2.setScaleY(scaleY);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator a(View view) {
        if (this.f41649b) {
            return c(view, 1.0f, 1.1f);
        }
        return null;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public final Animator b(View view) {
        return c(view, this.f41648a, 1.0f);
    }
}
