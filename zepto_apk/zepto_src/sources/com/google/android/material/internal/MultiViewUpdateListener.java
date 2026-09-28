package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class MultiViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final Listener f40581a;

    /* renamed from: b, reason: collision with root package name */
    public final View[] f40582b;

    public interface Listener {
        void a(ValueAnimator valueAnimator, View view);
    }

    public MultiViewUpdateListener(Listener listener, View... viewArr) {
        this.f40581a = listener;
        this.f40582b = viewArr;
    }

    public static MultiViewUpdateListener a(View... viewArr) {
        return new MultiViewUpdateListener(new a(1), viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (View view : this.f40582b) {
            this.f40581a.a(valueAnimator, view);
        }
    }
}
