package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    public final VisibilityAnimatorProvider H;
    public final ScaleProvider I;
    public final ArrayList J = new ArrayList();

    public MaterialVisibility(VisibilityAnimatorProvider visibilityAnimatorProvider, ScaleProvider scaleProvider) {
        this.H = visibilityAnimatorProvider;
        this.I = scaleProvider;
    }

    public static void U(ArrayList arrayList, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator animatorB = z ? visibilityAnimatorProvider.b(view) : visibilityAnimatorProvider.a(view);
        if (animatorB != null) {
            arrayList.add(animatorB);
        }
    }

    @Override // androidx.transition.Visibility
    public Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return V(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return V(viewGroup, view, false);
    }

    public final AnimatorSet V(ViewGroup viewGroup, View view, boolean z) {
        int iC;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        U(arrayList, this.H, viewGroup, view, z);
        U(arrayList, this.I, viewGroup, view, z);
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            U(arrayList, (VisibilityAnimatorProvider) it.next(), viewGroup, view, z);
        }
        Context context = viewGroup.getContext();
        int iX = X(z);
        RectF rectF = TransitionUtils.f41550a;
        if (iX != 0 && this.f12117c == -1 && (iC = MotionUtils.c(context, iX, -1)) != -1) {
            G(iC);
        }
        int iY = Y(z);
        TimeInterpolator timeInterpolatorW = W();
        if (iY != 0 && this.f12118d == null) {
            I(MotionUtils.d(context, iY, timeInterpolatorW));
        }
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    public TimeInterpolator W() {
        return AnimationUtils.f39817b;
    }

    public int X(boolean z) {
        return 0;
    }

    public int Y(boolean z) {
        return 0;
    }

    @Override // androidx.transition.Transition
    public boolean v() {
        return true;
    }
}
