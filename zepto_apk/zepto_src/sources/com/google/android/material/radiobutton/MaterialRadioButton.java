package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g, reason: collision with root package name */
    public static final int f40861g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f40862h = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f40863e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40864f;

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f40863e == null) {
            int iB = MaterialColors.b(R.attr.colorControlActivated, this);
            int iB2 = MaterialColors.b(R.attr.colorOnSurface, this);
            int iB3 = MaterialColors.b(R.attr.colorSurface, this);
            this.f40863e = new ColorStateList(f40862h, new int[]{MaterialColors.g(1.0f, iB3, iB), MaterialColors.g(0.54f, iB3, iB2), MaterialColors.g(0.38f, iB3, iB2), MaterialColors.g(0.38f, iB3, iB2)});
        }
        return this.f40863e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f40864f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f40864f = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f40861g;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.MaterialRadioButton, i2, i3, new int[0]);
        if (typedArrayD.hasValue(R.styleable.MaterialRadioButton_buttonTint)) {
            setButtonTintList(MaterialResources.a(context2, typedArrayD, R.styleable.MaterialRadioButton_buttonTint));
        }
        this.f40864f = typedArrayD.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayD.recycle();
    }
}
