package com.google.android.material.internal;

import android.animation.ValueAnimator;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;

@RestrictTo
/* loaded from: classes4.dex */
public class FadeThroughUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final ActionMenuView f40574a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionMenuView f40575b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f40576c = new float[2];

    public FadeThroughUpdateListener(ActionMenuView actionMenuView, ActionMenuView actionMenuView2) {
        this.f40574a = actionMenuView;
        this.f40575b = actionMenuView2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float[] fArr = this.f40576c;
        FadeThroughUtils.a(fArr, fFloatValue);
        ActionMenuView actionMenuView = this.f40574a;
        if (actionMenuView != null) {
            actionMenuView.setAlpha(fArr[0]);
        }
        ActionMenuView actionMenuView2 = this.f40575b;
        if (actionMenuView2 != null) {
            actionMenuView2.setAlpha(fArr[1]);
        }
    }
}
