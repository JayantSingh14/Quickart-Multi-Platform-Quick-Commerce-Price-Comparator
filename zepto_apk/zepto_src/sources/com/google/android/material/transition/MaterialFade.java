package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes4.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    public static final int K = R.attr.motionDurationMedium4;
    public static final int L = R.attr.motionDurationShort3;
    public static final int M = R.attr.motionEasingEmphasizedDecelerateInterpolator;
    public static final int Q = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    public MaterialFade() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.f41491a = 0.3f;
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.f41546b = false;
        scaleProvider.f41545a = 0.8f;
        super(fadeProvider, scaleProvider);
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
    public final TimeInterpolator W() {
        return AnimationUtils.f39816a;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int X(boolean z) {
        return z ? K : L;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int Y(boolean z) {
        return z ? M : Q;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Transition
    public final /* bridge */ /* synthetic */ boolean v() {
        return true;
    }
}
