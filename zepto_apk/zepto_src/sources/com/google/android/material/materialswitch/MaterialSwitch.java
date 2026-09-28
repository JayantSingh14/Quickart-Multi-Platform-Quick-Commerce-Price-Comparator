package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class MaterialSwitch extends SwitchCompat {
    public static final int S0 = R.style.Widget_Material3_CompoundButton_MaterialSwitch;
    public static final int[] T0 = {R.attr.state_with_icon};
    public Drawable F0;
    public Drawable G0;
    public int H0;
    public Drawable I0;
    public Drawable J0;
    public ColorStateList K0;
    public ColorStateList L0;
    public PorterDuff.Mode M0;
    public ColorStateList N0;
    public ColorStateList O0;
    public PorterDuff.Mode P0;
    public int[] Q0;
    public int[] R0;

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSwitchStyle);
    }

    public static void g(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f2) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        drawable.setTint(ColorUtils.d(f2, colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0)));
    }

    public final void e() {
        this.F0 = DrawableUtils.b(this.F0, this.K0, getThumbTintMode());
        this.G0 = DrawableUtils.b(this.G0, this.L0, this.M0);
        h();
        Drawable drawable = this.F0;
        Drawable drawable2 = this.G0;
        int i2 = this.H0;
        super.setThumbDrawable(DrawableUtils.a(drawable, drawable2, i2, i2));
        refreshDrawableState();
    }

    public final void f() {
        this.I0 = DrawableUtils.b(this.I0, this.N0, getTrackTintMode());
        this.J0 = DrawableUtils.b(this.J0, this.O0, this.P0);
        h();
        Drawable layerDrawable = this.I0;
        if (layerDrawable != null && this.J0 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.I0, this.J0});
        } else if (layerDrawable == null) {
            layerDrawable = this.J0;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getThumbDrawable() {
        return this.F0;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.G0;
    }

    @Px
    public int getThumbIconSize() {
        return this.H0;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.L0;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.M0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getThumbTintList() {
        return this.K0;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.J0;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.O0;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.P0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getTrackDrawable() {
        return this.I0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getTrackTintList() {
        return this.N0;
    }

    public final void h() {
        if (this.K0 == null && this.L0 == null && this.N0 == null && this.O0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.K0;
        if (colorStateList != null) {
            g(this.F0, colorStateList, this.Q0, this.R0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.L0;
        if (colorStateList2 != null) {
            g(this.G0, colorStateList2, this.Q0, this.R0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.N0;
        if (colorStateList3 != null) {
            g(this.I0, colorStateList3, this.Q0, this.R0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.O0;
        if (colorStateList4 != null) {
            g(this.J0, colorStateList4, this.Q0, this.R0, thumbPosition);
        }
    }

    @Override // android.view.View
    public final void invalidate() {
        h();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.G0 != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T0);
        }
        int[] iArr = new int[iArrOnCreateDrawableState.length];
        int i3 = 0;
        for (int i4 : iArrOnCreateDrawableState) {
            if (i4 != 16842912) {
                iArr[i3] = i4;
                i3++;
            }
        }
        this.Q0 = iArr;
        this.R0 = DrawableUtils.c(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@Nullable Drawable drawable) {
        this.F0 = drawable;
        e();
    }

    public void setThumbIconDrawable(@Nullable Drawable drawable) {
        this.G0 = drawable;
        e();
    }

    public void setThumbIconResource(@DrawableRes int i2) {
        setThumbIconDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setThumbIconSize(@Px int i2) {
        if (this.H0 != i2) {
            this.H0 = i2;
            e();
        }
    }

    public void setThumbIconTintList(@Nullable ColorStateList colorStateList) {
        this.L0 = colorStateList;
        e();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode mode) {
        this.M0 = mode;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.K0 = colorStateList;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        e();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable drawable) {
        this.J0 = drawable;
        f();
    }

    public void setTrackDecorationResource(@DrawableRes int i2) {
        setTrackDecorationDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList colorStateList) {
        this.O0 = colorStateList;
        f();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode mode) {
        this.P0 = mode;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@Nullable Drawable drawable) {
        this.I0 = drawable;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.N0 = colorStateList;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        f();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = S0;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.H0 = -1;
        Context context2 = getContext();
        this.F0 = super.getThumbDrawable();
        this.K0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.I0 = super.getTrackDrawable();
        this.N0 = super.getTrackTintList();
        super.setTrackTintList(null);
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(context2, attributeSet, R.styleable.MaterialSwitch, i2, i3, new int[0]);
        this.G0 = tintTypedArrayE.b(R.styleable.MaterialSwitch_thumbIcon);
        int i4 = R.styleable.MaterialSwitch_thumbIconSize;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        this.H0 = typedArray.getDimensionPixelSize(i4, -1);
        this.L0 = tintTypedArrayE.a(R.styleable.MaterialSwitch_thumbIconTint);
        int i5 = typedArray.getInt(R.styleable.MaterialSwitch_thumbIconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.M0 = ViewUtils.i(i5, mode);
        this.J0 = tintTypedArrayE.b(R.styleable.MaterialSwitch_trackDecoration);
        this.O0 = tintTypedArrayE.a(R.styleable.MaterialSwitch_trackDecorationTint);
        this.P0 = ViewUtils.i(typedArray.getInt(R.styleable.MaterialSwitch_trackDecorationTintMode, -1), mode);
        tintTypedArrayE.g();
        setEnforceSwitchWidth(false);
        e();
        f();
    }
}
