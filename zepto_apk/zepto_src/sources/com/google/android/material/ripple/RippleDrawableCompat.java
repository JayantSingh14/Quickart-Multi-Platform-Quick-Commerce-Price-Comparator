package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo
/* loaded from: classes4.dex */
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {

    /* renamed from: a, reason: collision with root package name */
    public RippleDrawableCompatState f40887a;

    public static final class RippleDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public MaterialShapeDrawable f40888a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f40889b;

        public RippleDrawableCompatState(RippleDrawableCompatState rippleDrawableCompatState) {
            this.f40888a = (MaterialShapeDrawable) rippleDrawableCompatState.f40888a.f40974a.newDrawable();
            this.f40889b = rippleDrawableCompatState.f40889b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this));
        }
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        RippleDrawableCompatState rippleDrawableCompatState = new RippleDrawableCompatState();
        rippleDrawableCompatState.f40888a = materialShapeDrawable;
        rippleDrawableCompatState.f40889b = false;
        this(rippleDrawableCompatState);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        RippleDrawableCompatState rippleDrawableCompatState = this.f40887a;
        if (rippleDrawableCompatState.f40889b) {
            rippleDrawableCompatState.f40888a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f40887a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        this.f40887a.f40888a.getClass();
        return -3;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40887a.f40888a.f40974a.f40989a;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f40887a = new RippleDrawableCompatState(this.f40887a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f40887a.f40888a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f40887a.f40888a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zD = RippleUtils.d(iArr);
        RippleDrawableCompatState rippleDrawableCompatState = this.f40887a;
        if (rippleDrawableCompatState.f40889b == zD) {
            return zOnStateChange;
        }
        rippleDrawableCompatState.f40889b = zD;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f40887a.f40888a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f40887a.f40888a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f40887a.f40888a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        this.f40887a.f40888a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f40887a.f40888a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f40887a.f40888a.setTintMode(mode);
    }

    public RippleDrawableCompat(RippleDrawableCompatState rippleDrawableCompatState) {
        this.f40887a = rippleDrawableCompatState;
    }
}
