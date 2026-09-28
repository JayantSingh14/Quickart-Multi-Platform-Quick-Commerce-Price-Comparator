package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: j, reason: collision with root package name */
    public static final int f39950j = R.attr.motionDurationLong2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f39951k = R.attr.motionDurationMedium4;

    /* renamed from: l, reason: collision with root package name */
    public static final int f39952l = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f39953a;

    /* renamed from: b, reason: collision with root package name */
    public int f39954b;

    /* renamed from: c, reason: collision with root package name */
    public int f39955c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f39956d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f39957e;

    /* renamed from: f, reason: collision with root package name */
    public int f39958f;

    /* renamed from: g, reason: collision with root package name */
    public int f39959g;

    /* renamed from: h, reason: collision with root package name */
    public int f39960h;

    /* renamed from: i, reason: collision with root package name */
    public ViewPropertyAnimator f39961i;

    public interface OnScrollStateChangedListener {
        void a();
    }

    @RestrictTo
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f39953a = new LinkedHashSet();
        this.f39958f = 0;
        this.f39959g = 2;
        this.f39960h = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
        this.f39958f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f39954b = MotionUtils.c(view.getContext(), f39950j, 225);
        this.f39955c = MotionUtils.c(view.getContext(), f39951k, 175);
        Context context = view.getContext();
        LinearOutSlowInInterpolator linearOutSlowInInterpolator = AnimationUtils.f39819d;
        int i3 = f39952l;
        this.f39956d = MotionUtils.d(context, i3, linearOutSlowInInterpolator);
        this.f39957e = MotionUtils.d(view.getContext(), i3, AnimationUtils.f39818c);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void r(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f39953a;
        if (i2 > 0) {
            if (this.f39959g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f39961i;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f39959g = 1;
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((OnScrollStateChangedListener) it.next()).a();
            }
            this.f39961i = view.animate().translationY(this.f39958f + this.f39960h).setInterpolator(this.f39957e).setDuration(this.f39955c).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    HideBottomViewOnScrollBehavior.this.f39961i = null;
                }
            });
            return;
        }
        if (i2 >= 0 || this.f39959g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f39961i;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f39959g = 2;
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            ((OnScrollStateChangedListener) it2.next()).a();
        }
        this.f39961i = view.animate().translationY(0).setInterpolator(this.f39956d).setDuration(this.f39954b).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.f39961i = null;
            }
        });
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39953a = new LinkedHashSet();
        this.f39958f = 0;
        this.f39959g = 2;
        this.f39960h = 0;
    }
}
