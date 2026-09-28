package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41379a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f41380b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i2) {
        this.f41379a = i2;
        this.f41380b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f41379a) {
            case 0:
                ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.f41380b;
                clearTextEndIconDelegate.getClass();
                clearTextEndIconDelegate.f41307d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                ClearTextEndIconDelegate clearTextEndIconDelegate2 = (ClearTextEndIconDelegate) this.f41380b;
                clearTextEndIconDelegate2.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = clearTextEndIconDelegate2.f41307d;
                checkableImageButton.setScaleX(fFloatValue);
                checkableImageButton.setScaleY(fFloatValue);
                break;
            default:
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.f41380b;
                dropdownMenuEndIconDelegate.getClass();
                dropdownMenuEndIconDelegate.f41307d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
