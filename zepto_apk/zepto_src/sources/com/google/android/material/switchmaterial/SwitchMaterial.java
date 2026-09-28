package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int J0 = R.style.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] K0 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public final ElevationOverlayProvider F0;
    public ColorStateList G0;
    public ColorStateList H0;
    public boolean I0;

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() throws Resources.NotFoundException {
        if (this.G0 == null) {
            int iB = MaterialColors.b(R.attr.colorSurface, this);
            int iB2 = MaterialColors.b(R.attr.colorControlActivated, this);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            ElevationOverlayProvider elevationOverlayProvider = this.F0;
            if (elevationOverlayProvider.f40420a) {
                float fJ = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    fJ += ViewCompat.j((View) parent);
                }
                dimension += fJ;
            }
            int iA = elevationOverlayProvider.a(dimension, iB);
            this.G0 = new ColorStateList(K0, new int[]{MaterialColors.g(1.0f, iB, iB2), iA, MaterialColors.g(0.38f, iB, iB2), iA});
        }
        return this.G0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.H0 == null) {
            int iB = MaterialColors.b(R.attr.colorSurface, this);
            int iB2 = MaterialColors.b(R.attr.colorControlActivated, this);
            int iB3 = MaterialColors.b(R.attr.colorOnSurface, this);
            this.H0 = new ColorStateList(K0, new int[]{MaterialColors.g(0.54f, iB, iB2), MaterialColors.g(0.32f, iB, iB3), MaterialColors.g(0.12f, iB, iB2), MaterialColors.g(0.12f, iB, iB3)});
        }
        return this.H0;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.I0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.I0 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = J0;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        this.F0 = new ElevationOverlayProvider(context2);
        int[] iArr = R.styleable.SwitchMaterial;
        ThemeEnforcement.a(context2, attributeSet, i2, i3);
        ThemeEnforcement.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.I0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
