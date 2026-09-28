package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

@RequiresApi
/* loaded from: classes4.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {

    /* renamed from: d, reason: collision with root package name */
    public static final int f41637d = R.attr.motionDurationMedium4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f41638e = R.attr.motionDurationShort3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f41639f = R.attr.motionEasingEmphasizedDecelerateInterpolator;

    /* renamed from: g, reason: collision with root package name */
    public static final int f41640g = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    public MaterialFade() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.f41562a = 0.3f;
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.f41649b = false;
        scaleProvider.f41648a = 0.8f;
        super(fadeProvider, scaleProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final TimeInterpolator c() {
        return AnimationUtils.f39816a;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int d(boolean z) {
        return z ? f41637d : f41638e;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int e(boolean z) {
        return z ? f41639f : f41640g;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }
}
