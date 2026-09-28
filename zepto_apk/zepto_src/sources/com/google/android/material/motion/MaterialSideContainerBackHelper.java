package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f40688g;

    /* renamed from: h, reason: collision with root package name */
    public final float f40689h;

    /* renamed from: i, reason: collision with root package name */
    public final float f40690i;

    public MaterialSideContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f40688g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f40689h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f40690i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void b() {
        if (a() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f40667b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i2), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f40670e);
        animatorSet.start();
    }

    public final void c(BackEventCompat backEventCompat, final int i2, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i3;
        final boolean z = backEventCompat.f121d == 0;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        View view = this.f40667b;
        boolean z2 = (Gravity.getAbsoluteGravity(i2, view.getLayoutDirection()) & 3) == 3;
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i3 = z2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
        } else {
            i3 = 0;
        }
        float f2 = scaleX + i3;
        Property property = View.TRANSLATION_X;
        if (z2) {
            f2 = -f2;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f2);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(AnimationUtils.c(backEventCompat.f120c, this.f40668c, this.f40669d));
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialSideContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper materialSideContainerBackHelper = MaterialSideContainerBackHelper.this;
                materialSideContainerBackHelper.f40667b.setTranslationX(0.0f);
                materialSideContainerBackHelper.d(0.0f, i2, z);
            }
        });
        objectAnimatorOfFloat.addListener(animatorListenerAdapter);
        objectAnimatorOfFloat.start();
    }

    public final void d(float f2, int i2, boolean z) {
        float interpolation = this.f40666a.getInterpolation(f2);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        View view = this.f40667b;
        boolean z2 = (Gravity.getAbsoluteGravity(i2, view.getLayoutDirection()) & 3) == 3;
        boolean z3 = z == z2;
        int width = view.getWidth();
        int height = view.getHeight();
        float f3 = width;
        if (f3 > 0.0f) {
            float f4 = height;
            if (f4 <= 0.0f) {
                return;
            }
            float f5 = this.f40688g / f3;
            float f6 = this.f40689h / f3;
            float f7 = this.f40690i / f4;
            if (z2) {
                f3 = 0.0f;
            }
            view.setPivotX(f3);
            if (!z3) {
                f6 = -f5;
            }
            float fA = AnimationUtils.a(0.0f, f6, interpolation);
            float f8 = fA + 1.0f;
            view.setScaleX(f8);
            float fA2 = 1.0f - AnimationUtils.a(0.0f, f7, interpolation);
            view.setScaleY(fA2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    childAt.setPivotX(z2 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f9 = z3 ? 1.0f - fA : 1.0f;
                    float f10 = fA2 != 0.0f ? (f8 / fA2) * f9 : 1.0f;
                    childAt.setScaleX(f9);
                    childAt.setScaleY(f10);
                }
            }
        }
    }
}
