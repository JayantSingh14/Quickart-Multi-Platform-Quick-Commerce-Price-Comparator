package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;

@RequiresApi
/* loaded from: classes4.dex */
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {

    /* renamed from: d, reason: collision with root package name */
    public static final int f41641d = R.attr.motionDurationLong1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f41642e = R.attr.motionEasingEmphasizedInterpolator;

    public MaterialFadeThrough() {
        FadeThroughProvider fadeThroughProvider = new FadeThroughProvider();
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.f41649b = false;
        scaleProvider.f41648a = 0.92f;
        super(fadeThroughProvider, scaleProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int d(boolean z) {
        return f41641d;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int e(boolean z) {
        return f41642e;
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
