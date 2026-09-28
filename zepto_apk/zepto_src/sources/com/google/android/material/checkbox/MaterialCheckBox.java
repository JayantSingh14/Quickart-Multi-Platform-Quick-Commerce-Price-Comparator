package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import in.juspay.hyper.constants.LogSubCategory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int[] A;
    public static final int[][] B;
    public static final int C;
    public static final int y = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[] z = {R.attr.state_indeterminate};

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f40199e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f40200f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f40201g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40202h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f40203i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40204j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f40205k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f40206l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f40207m;
    public boolean n;
    public ColorStateList o;
    public ColorStateList p;
    public PorterDuff.Mode q;
    public int r;
    public int[] s;
    public boolean t;
    public CharSequence u;
    public CompoundButton.OnCheckedChangeListener v;
    public final AnimatedVectorDrawableCompat w;
    public final Animatable2Compat.AnimationCallback x;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void a();
    }

    public interface OnErrorChangedListener {
        void a();
    }

    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f40209a;

        /* renamed from: com.google.android.material.checkbox.MaterialCheckBox$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel);
                savedState.f40209a = ((Integer) parcel.readValue(SavedState.class.getClassLoader())).intValue();
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" CheckedState=");
            int i2 = this.f40209a;
            return b.r(sb, i2 != 1 ? i2 != 2 ? "unchecked" : ReactProgressBarViewManager.PROP_INDETERMINATE : "checked", "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Integer.valueOf(this.f40209a));
        }
    }

    static {
        int i2 = R.attr.state_error;
        A = new int[]{i2};
        B = new int[][]{new int[]{android.R.attr.state_enabled, i2}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        C = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", LogSubCategory.LifeCycle.ANDROID);
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @NonNull
    private String getButtonStateDescription() {
        int i2 = this.r;
        return i2 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i2 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f40201g == null) {
            int iB = MaterialColors.b(R.attr.colorControlActivated, this);
            int iB2 = MaterialColors.b(R.attr.colorError, this);
            int iB3 = MaterialColors.b(R.attr.colorSurface, this);
            int iB4 = MaterialColors.b(R.attr.colorOnSurface, this);
            this.f40201g = new ColorStateList(B, new int[]{MaterialColors.g(1.0f, iB3, iB2), MaterialColors.g(1.0f, iB3, iB), MaterialColors.g(0.54f, iB3, iB4), MaterialColors.g(0.38f, iB3, iB4), MaterialColors.g(0.38f, iB3, iB4)});
        }
        return this.f40201g;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void b() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        this.f40206l = DrawableUtils.b(this.f40206l, this.o, getButtonTintMode());
        this.f40207m = DrawableUtils.b(this.f40207m, this.p, this.q);
        if (this.n) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.w;
            if (animatedVectorDrawableCompat != null) {
                Animatable2Compat.AnimationCallback animationCallback = this.x;
                animatedVectorDrawableCompat.c(animationCallback);
                animatedVectorDrawableCompat.b(animationCallback);
            }
            Drawable drawable = this.f40206l;
            if ((drawable instanceof AnimatedStateListDrawable) && animatedVectorDrawableCompat != null) {
                ((AnimatedStateListDrawable) drawable).addTransition(R.id.checked, R.id.unchecked, animatedVectorDrawableCompat, false);
                ((AnimatedStateListDrawable) this.f40206l).addTransition(R.id.indeterminate, R.id.unchecked, animatedVectorDrawableCompat, false);
            }
        }
        Drawable drawable2 = this.f40206l;
        if (drawable2 != null && (colorStateList2 = this.o) != null) {
            drawable2.setTintList(colorStateList2);
        }
        Drawable drawable3 = this.f40207m;
        if (drawable3 != null && (colorStateList = this.p) != null) {
            drawable3.setTintList(colorStateList);
        }
        super.setButtonDrawable(DrawableUtils.a(this.f40206l, this.f40207m, -1, -1));
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f40206l;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f40207m;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.p;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.q;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.o;
    }

    public int getCheckedState() {
        return this.r;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f40205k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f40202h && this.o == null && this.p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        if (this.f40204j) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        this.s = DrawableUtils.c(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f40203i || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (ViewUtils.h(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f40204j) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f40205k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f40209a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f40209a = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i2) {
        setButtonDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f40207m = drawable;
        b();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i2) {
        setButtonIconDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.p == colorStateList) {
            return;
        }
        this.p = colorStateList;
        b();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.q == mode) {
            return;
        }
        this.q = mode;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        b();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.f40203i = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i2) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.r != i2) {
            this.r = i2;
            super.setChecked(i2 == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.u == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.t) {
                return;
            }
            this.t = true;
            LinkedHashSet linkedHashSet = this.f40200f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((OnCheckedStateChangedListener) it.next()).a();
                }
            }
            if (this.r != 2 && (onCheckedChangeListener = this.v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.t = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f40205k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i2) {
        setErrorAccessibilityLabel(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.f40204j == z2) {
            return;
        }
        this.f40204j = z2;
        refreshDrawableState();
        Iterator it = this.f40199e.iterator();
        while (it.hasNext()) {
            ((OnErrorChangedListener) it.next()).a();
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.u = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f40202h = z2;
        if (z2) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = y;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40199e = new LinkedHashSet();
        this.f40200f = new LinkedHashSet();
        this.w = AnimatedVectorDrawableCompat.a(R.drawable.mtrl_checkbox_button_checked_unchecked, getContext());
        this.x = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.checkbox.MaterialCheckBox.1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public final void a(Drawable drawable) {
                ColorStateList colorStateList = MaterialCheckBox.this.o;
                if (colorStateList != null) {
                    drawable.setTintList(colorStateList);
                }
            }

            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public final void b(Drawable drawable) {
                MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
                ColorStateList colorStateList = materialCheckBox.o;
                if (colorStateList != null) {
                    drawable.setTint(colorStateList.getColorForState(materialCheckBox.s, colorStateList.getDefaultColor()));
                }
            }
        };
        Context context2 = getContext();
        this.f40206l = getButtonDrawable();
        this.o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(context2, attributeSet, R.styleable.MaterialCheckBox, i2, i3, new int[0]);
        this.f40207m = tintTypedArrayE.b(R.styleable.MaterialCheckBox_buttonIcon);
        Drawable drawable = this.f40206l;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        if (drawable != null && MaterialAttributes.b(context2, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(R.styleable.MaterialCheckBox_android_button, 0);
            int resourceId2 = typedArray.getResourceId(R.styleable.MaterialCheckBox_buttonCompat, 0);
            if (resourceId == C && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f40206l = AppCompatResources.b(R.drawable.mtrl_checkbox_button, context2);
                this.n = true;
                if (this.f40207m == null) {
                    this.f40207m = AppCompatResources.b(R.drawable.mtrl_checkbox_button_icon, context2);
                }
            }
        }
        this.p = MaterialResources.b(context2, tintTypedArrayE, R.styleable.MaterialCheckBox_buttonIconTint);
        this.q = ViewUtils.i(typedArray.getInt(R.styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f40202h = typedArray.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f40203i = typedArray.getBoolean(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f40204j = typedArray.getBoolean(R.styleable.MaterialCheckBox_errorShown, false);
        this.f40205k = typedArray.getText(R.styleable.MaterialCheckBox_errorAccessibilityLabel);
        if (typedArray.hasValue(R.styleable.MaterialCheckBox_checkedState)) {
            setCheckedState(typedArray.getInt(R.styleable.MaterialCheckBox_checkedState, 0));
        }
        tintTypedArrayE.g();
        b();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f40206l = drawable;
        this.n = false;
        b();
    }
}
