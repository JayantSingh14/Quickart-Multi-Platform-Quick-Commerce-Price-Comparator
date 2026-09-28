package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.HashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class TextScale extends Transition {
    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        View view = transitionValues.f12164b;
        if (view instanceof TextView) {
            transitionValues.f12163a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        View view = transitionValues.f12164b;
        if (view instanceof TextView) {
            transitionValues.f12163a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f12164b instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.f12164b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        HashMap map = transitionValues.f12163a;
        HashMap map2 = transitionValues2.f12163a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView2 = textView;
                textView2.setScaleX(fFloatValue3);
                textView2.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}
