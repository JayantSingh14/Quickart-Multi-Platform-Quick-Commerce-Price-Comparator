package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

@RequiresApi
/* loaded from: classes4.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    public StateListAnimator O;

    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public final boolean isStateful() {
            return true;
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final MaterialShapeDrawable e() {
        ShapeAppearanceModel shapeAppearanceModel = this.f40487a;
        shapeAppearanceModel.getClass();
        return new AlwaysStatefulMaterialShapeDrawable(shapeAppearanceModel);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final float f() {
        return this.w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void g(Rect rect) {
        if (FloatingActionButton.this.f40477k) {
            super.g(rect);
            return;
        }
        if (this.f40492f) {
            FloatingActionButton floatingActionButton = this.w;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i2 = this.f40497k;
            if (sizeDimension < i2) {
                int sizeDimension2 = (i2 - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void h(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable layerDrawable;
        MaterialShapeDrawable materialShapeDrawableE = e();
        this.f40488b = materialShapeDrawableE;
        materialShapeDrawableE.setTintList(colorStateList);
        if (mode != null) {
            this.f40488b.setTintMode(mode);
        }
        MaterialShapeDrawable materialShapeDrawable = this.f40488b;
        FloatingActionButton floatingActionButton = this.w;
        materialShapeDrawable.k(floatingActionButton.getContext());
        if (i2 > 0) {
            Context context = floatingActionButton.getContext();
            ShapeAppearanceModel shapeAppearanceModel = this.f40487a;
            shapeAppearanceModel.getClass();
            BorderDrawable borderDrawable = new BorderDrawable(shapeAppearanceModel);
            int color = context.getColor(R.color.design_fab_stroke_top_outer_color);
            int color2 = context.getColor(R.color.design_fab_stroke_top_inner_color);
            int color3 = context.getColor(R.color.design_fab_stroke_end_inner_color);
            int color4 = context.getColor(R.color.design_fab_stroke_end_outer_color);
            borderDrawable.f40445i = color;
            borderDrawable.f40446j = color2;
            borderDrawable.f40447k = color3;
            borderDrawable.f40448l = color4;
            float f2 = i2;
            if (borderDrawable.f40444h != f2) {
                borderDrawable.f40444h = f2;
                borderDrawable.f40438b.setStrokeWidth(f2 * 1.3333f);
                borderDrawable.n = true;
                borderDrawable.invalidateSelf();
            }
            if (colorStateList != null) {
                borderDrawable.f40449m = colorStateList.getColorForState(borderDrawable.getState(), borderDrawable.f40449m);
            }
            borderDrawable.p = colorStateList;
            borderDrawable.n = true;
            borderDrawable.invalidateSelf();
            this.f40490d = borderDrawable;
            BorderDrawable borderDrawable2 = this.f40490d;
            borderDrawable2.getClass();
            MaterialShapeDrawable materialShapeDrawable2 = this.f40488b;
            materialShapeDrawable2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{borderDrawable2, materialShapeDrawable2});
        } else {
            this.f40490d = null;
            layerDrawable = this.f40488b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.c(colorStateList2), layerDrawable, null);
        this.f40489c = rippleDrawable;
        this.f40491e = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void i() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void j() {
        r();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void k(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void l(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.w;
        if (floatingActionButton.getStateListAnimator() == this.O) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.I, s(f2, f4));
            stateListAnimator.addState(FloatingActionButtonImpl.J, s(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.K, s(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.L, s(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f2).setDuration(0L));
            if (i2 <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.D);
            stateListAnimator.addState(FloatingActionButtonImpl.M, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.N, s(0.0f, 0.0f));
            this.O = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            r();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void n(ColorStateList colorStateList) {
        Drawable drawable = this.f40489c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.c(colorStateList));
        } else {
            super.n(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final boolean p() {
        if (FloatingActionButton.this.f40477k) {
            return true;
        }
        return this.f40492f && this.w.getSizeDimension() < this.f40497k;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void q() {
    }

    public final AnimatorSet s(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f2};
        FloatingActionButton floatingActionButton = this.w;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        return animatorSet;
    }
}
