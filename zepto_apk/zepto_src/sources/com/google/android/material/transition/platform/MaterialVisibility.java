package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;

@RequiresApi
/* loaded from: classes4.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {

    /* renamed from: a, reason: collision with root package name */
    public final VisibilityAnimatorProvider f41645a;

    /* renamed from: b, reason: collision with root package name */
    public final ScaleProvider f41646b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f41647c = new ArrayList();

    public MaterialVisibility(VisibilityAnimatorProvider visibilityAnimatorProvider, ScaleProvider scaleProvider) {
        this.f41645a = visibilityAnimatorProvider;
        this.f41646b = scaleProvider;
    }

    public static void a(ArrayList arrayList, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator animatorB = z ? visibilityAnimatorProvider.b(view) : visibilityAnimatorProvider.a(view);
        if (animatorB != null) {
            arrayList.add(animatorB);
        }
    }

    public final AnimatorSet b(ViewGroup viewGroup, View view, boolean z) {
        int iC;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.f41645a, viewGroup, view, z);
        a(arrayList, this.f41646b, viewGroup, view, z);
        Iterator it = this.f41647c.iterator();
        while (it.hasNext()) {
            a(arrayList, (VisibilityAnimatorProvider) it.next(), viewGroup, view, z);
        }
        Context context = viewGroup.getContext();
        int iD = d(z);
        RectF rectF = TransitionUtils.f41653a;
        if (iD != 0 && getDuration() == -1 && (iC = MotionUtils.c(context, iD, -1)) != -1) {
            setDuration(iC);
        }
        int iE = e(z);
        TimeInterpolator timeInterpolatorC = c();
        if (iE != 0 && getInterpolator() == null) {
            setInterpolator(MotionUtils.d(context, iE, timeInterpolatorC));
        }
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    public TimeInterpolator c() {
        return AnimationUtils.f39817b;
    }

    public int d(boolean z) {
        return 0;
    }

    public int e(boolean z) {
        return 0;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }
}
