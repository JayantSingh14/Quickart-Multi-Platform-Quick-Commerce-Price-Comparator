package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes4.dex */
public class Slider extends BaseSlider<Slider, OnChangeListener, OnSliderTouchListener> {

    public interface OnChangeListener extends BaseOnChangeListener<Slider> {
        @Override // com.google.android.material.slider.BaseOnChangeListener
        /* bridge */ /* synthetic */ default void a(Object obj, float f2, boolean z) {
            c();
        }

        void c();
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<Slider> {
        @Override // com.google.android.material.slider.BaseOnSliderTouchListener
        /* bridge */ /* synthetic */ default void a(Object obj) {
            e();
        }

        @Override // com.google.android.material.slider.BaseOnSliderTouchListener
        /* bridge */ /* synthetic */ default void b(Object obj) {
            d();
        }

        void d();

        void e();
    }

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.G0;
    }

    public int getFocusedThumbIndex() {
        return this.H0;
    }

    @Px
    public int getHaloRadius() {
        return this.G;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.Q0;
    }

    public int getLabelBehavior() {
        return this.B;
    }

    public float getStepSize() {
        return this.I0;
    }

    public float getThumbElevation() {
        return this.Y0.f40974a.f41001m;
    }

    @Px
    public int getThumbHeight() {
        return this.F;
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Px
    public int getThumbRadius() {
        return this.E / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.Y0.f40974a.f40992d;
    }

    public float getThumbStrokeWidth() {
        return this.Y0.f40974a.f40998j;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.Y0.f40974a.f40991c;
    }

    public int getThumbTrackGapSize() {
        return this.H;
    }

    @Px
    public int getThumbWidth() {
        return this.E;
    }

    @Px
    public int getTickActiveRadius() {
        return this.L0;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.R0;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.M0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.S0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.S0.equals(this.R0)) {
            return this.R0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.T0;
    }

    @Px
    public int getTrackHeight() {
        return this.C;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.U0;
    }

    public int getTrackInsideCornerSize() {
        return this.L;
    }

    @Px
    public int getTrackSidePadding() {
        return this.D;
    }

    public int getTrackStopIndicatorSize() {
        return this.K;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.U0.equals(this.T0)) {
            return this.T0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Px
    public int getTrackWidth() {
        return this.N0;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.D0;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.E0;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public final boolean r() {
        if (getActiveThumbIndex() != -1) {
            return true;
        }
        setActiveThumbIndex(0);
        return true;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i2) {
        super.setFocusedThumbIndex(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(@IntRange @Px int i2) {
        super.setHaloRadius(i2);
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int i2) {
        super.setLabelBehavior(i2);
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.B0 = labelFormatter;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f2) {
        super.setStepSize(f2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f2) {
        super.setThumbElevation(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbHeight(@IntRange @Px int i2) {
        super.setThumbHeight(i2);
    }

    public void setThumbHeightResource(@DimenRes int i2) {
        setThumbHeight(getResources().getDimensionPixelSize(i2));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(@IntRange @Px int i2) {
        super.setThumbRadius(i2);
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(ContextCompat.b(i2, getContext()));
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f2) {
        super.setThumbStrokeWidth(f2);
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.Y0;
        if (colorStateList.equals(materialShapeDrawable.f40974a.f40991c)) {
            return;
        }
        materialShapeDrawable.m(colorStateList);
        invalidate();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTrackGapSize(@Px int i2) {
        super.setThumbTrackGapSize(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbWidth(@IntRange @Px int i2) {
        super.setThumbWidth(i2);
    }

    public void setThumbWidthResource(@DimenRes int i2) {
        setThumbWidth(getResources().getDimensionPixelSize(i2));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveRadius(@IntRange @Px int i2) {
        super.setTickActiveRadius(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveRadius(@IntRange @Px int i2) {
        super.setTickInactiveRadius(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.K0 != z) {
            this.K0 = z;
            postInvalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(@IntRange @Px int i2) {
        super.setTrackHeight(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInsideCornerSize(@Px int i2) {
        super.setTrackInsideCornerSize(i2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackStopIndicatorSize(@Px int i2) {
        super.setTrackStopIndicatorSize(i2);
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f2) {
        setValues(Float.valueOf(f2));
    }

    public void setValueFrom(float f2) {
        this.D0 = f2;
        this.P0 = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.E0 = f2;
        this.P0 = true;
        postInvalidate();
    }

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.value});
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setValue(typedArrayObtainStyledAttributes.getFloat(0, 0.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setCustomThumbDrawable(@DrawableRes int i2) {
        setCustomThumbDrawable(getResources().getDrawable(i2));
    }
}
