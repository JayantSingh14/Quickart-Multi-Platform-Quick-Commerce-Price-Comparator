package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    public static final int K = R.attr.motionDurationLong1;
    public static final int L = R.attr.motionEasingEmphasizedInterpolator;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Axis {
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return V(viewGroup, view, true);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public final Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return V(viewGroup, view, false);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int X(boolean z) {
        return K;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int Y(boolean z) {
        return L;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Transition
    public final /* bridge */ /* synthetic */ boolean v() {
        return true;
    }
}
