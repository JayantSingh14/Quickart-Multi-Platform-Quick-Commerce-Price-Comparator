package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.activity.k;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int[] r = {R.attr.state_checkable};
    public static final int[] s = {R.attr.state_checked};
    public static final int t = com.google.android.material.R.style.Widget_MaterialComponents_Button;

    /* renamed from: d, reason: collision with root package name */
    public final MaterialButtonHelper f40073d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f40074e;

    /* renamed from: f, reason: collision with root package name */
    public OnPressedChangeListener f40075f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f40076g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f40077h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f40078i;

    /* renamed from: j, reason: collision with root package name */
    public String f40079j;

    /* renamed from: k, reason: collision with root package name */
    public int f40080k;

    /* renamed from: l, reason: collision with root package name */
    public int f40081l;

    /* renamed from: m, reason: collision with root package name */
    public int f40082m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40083a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f40084b;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f40084b = propertyMapper.mapInt("iconPadding", com.google.android.material.R.attr.iconPadding);
            this.f40083a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            MaterialButton materialButton = (MaterialButton) obj;
            if (!this.f40083a) {
                throw k.e();
            }
            propertyReader.readInt(this.f40084b, materialButton.getIconPadding());
        }
    }

    public interface OnCheckedChangeListener {
        void a();
    }

    public interface OnPressedChangeListener {
        void a();
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public boolean f40085c;

        /* renamed from: com.google.android.material.button.MaterialButton$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f40085c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f40085c ? 1 : 0);
        }
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < lineCount; i2++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i2));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        return (materialButtonHelper == null || materialButtonHelper.o) ? false : true;
    }

    public final void b() {
        int i2 = this.q;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        if (z) {
            setCompoundDrawablesRelative(this.f40078i, null, null, null);
            return;
        }
        if (i2 == 3 || i2 == 4) {
            setCompoundDrawablesRelative(null, null, this.f40078i, null);
        } else if (i2 == 16 || i2 == 32) {
            setCompoundDrawablesRelative(null, this.f40078i, null, null);
        }
    }

    public final void c(boolean z) {
        Drawable drawable = this.f40078i;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f40078i = drawableMutate;
            drawableMutate.setTintList(this.f40077h);
            PorterDuff.Mode mode = this.f40076g;
            if (mode != null) {
                this.f40078i.setTintMode(mode);
            }
            int intrinsicWidth = this.f40080k;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f40078i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f40080k;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f40078i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f40078i;
            int i2 = this.f40081l;
            int i3 = this.f40082m;
            drawable2.setBounds(i2, i3, intrinsicWidth + i2, intrinsicHeight + i3);
            this.f40078i.setVisible(true, z);
        }
        if (z) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i4 = this.q;
        if (((i4 == 1 || i4 == 2) && drawable3 != this.f40078i) || (((i4 == 3 || i4 == 4) && drawable5 != this.f40078i) || ((i4 == 16 || i4 == 32) && drawable4 != this.f40078i))) {
            b();
        }
    }

    public final void d(int i2, int i3) {
        if (this.f40078i == null || getLayout() == null) {
            return;
        }
        int i4 = this.q;
        if (!(i4 == 1 || i4 == 2) && i4 != 3 && i4 != 4) {
            if (i4 == 16 || i4 == 32) {
                this.f40081l = 0;
                if (i4 == 16) {
                    this.f40082m = 0;
                    c(false);
                    return;
                }
                int intrinsicHeight = this.f40080k;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f40078i.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i3 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.n) - getPaddingBottom()) / 2);
                if (this.f40082m != iMax) {
                    this.f40082m = iMax;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f40082m = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.q;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f40081l = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.f40080k;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f40078i.getIntrinsicWidth();
        }
        int textLayoutWidth = i2 - getTextLayoutWidth();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int paddingEnd = (((textLayoutWidth - getPaddingEnd()) - intrinsicWidth) - this.n) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.q == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.f40081l != paddingEnd) {
            this.f40081l = paddingEnd;
            c(false);
        }
    }

    @NonNull
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f40079j)) {
            return this.f40079j;
        }
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        return ((materialButtonHelper == null || !materialButtonHelper.q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (a()) {
            return this.f40073d.f40092g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f40078i;
    }

    public int getIconGravity() {
        return this.q;
    }

    @Px
    public int getIconPadding() {
        return this.n;
    }

    @Px
    public int getIconSize() {
        return this.f40080k;
    }

    public ColorStateList getIconTint() {
        return this.f40077h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f40076g;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f40073d.f40091f;
    }

    @Dimension
    public int getInsetTop() {
        return this.f40073d.f40090e;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f40073d.f40097l;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (a()) {
            return this.f40073d.f40087b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f40073d.f40096k;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (a()) {
            return this.f40073d.f40093h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f40073d.f40095j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f40073d.f40094i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.o;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            MaterialShapeUtils.c(this, this.f40073d.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        if (materialButtonHelper != null && materialButtonHelper.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, r);
        }
        if (this.o) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, s);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.o);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        accessibilityNodeInfo.setCheckable(materialButtonHelper != null && materialButtonHelper.q);
        accessibilityNodeInfo.setChecked(this.o);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        setChecked(savedState.f40085c);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f40085c = this.o;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f40073d.r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f40078i != null) {
            if (this.f40078i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(@Nullable String str) {
        this.f40079j = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (!a()) {
            super.setBackgroundColor(i2);
            return;
        }
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        if (materialButtonHelper.b(false) != null) {
            materialButtonHelper.b(false).setTint(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        materialButtonHelper.o = true;
        ColorStateList colorStateList = materialButtonHelper.f40095j;
        MaterialButton materialButton = materialButtonHelper.f40086a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(materialButtonHelper.f40094i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.b(i2, getContext()) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (a()) {
            this.f40073d.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        if (materialButtonHelper == null || !materialButtonHelper.q || !isEnabled() || this.o == z) {
            return;
        }
        this.o = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.o;
            if (!materialButtonToggleGroup.f40105f) {
                materialButtonToggleGroup.b(getId(), z2);
            }
        }
        if (this.p) {
            return;
        }
        this.p = true;
        Iterator it = this.f40074e.iterator();
        while (it.hasNext()) {
            ((OnCheckedChangeListener) it.next()).a();
        }
        this.p = false;
    }

    public void setCornerRadius(@Px int i2) {
        if (a()) {
            MaterialButtonHelper materialButtonHelper = this.f40073d;
            if (materialButtonHelper.p && materialButtonHelper.f40092g == i2) {
                return;
            }
            materialButtonHelper.f40092g = i2;
            materialButtonHelper.p = true;
            ShapeAppearanceModel.Builder builderG = materialButtonHelper.f40087b.g();
            builderG.c(i2);
            materialButtonHelper.c(builderG.a());
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (a()) {
            this.f40073d.b(false).l(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f40078i != drawable) {
            this.f40078i = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.n != i2) {
            this.n = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(i2, getContext()) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f40080k != i2) {
            this.f40080k = i2;
            c(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f40077h != colorStateList) {
            this.f40077h = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f40076g != mode) {
            this.f40076g = mode;
            c(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(ContextCompat.b(i2, getContext()));
    }

    public void setInsetBottom(@Dimension int i2) {
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        materialButtonHelper.d(materialButtonHelper.f40090e, i2);
    }

    public void setInsetTop(@Dimension int i2) {
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        materialButtonHelper.d(i2, materialButtonHelper.f40091f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        this.f40075f = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.f40075f;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.a();
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (a()) {
            MaterialButtonHelper materialButtonHelper = this.f40073d;
            if (materialButtonHelper.f40097l != colorStateList) {
                materialButtonHelper.f40097l = colorStateList;
                MaterialButton materialButton = materialButtonHelper.f40086a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(RippleUtils.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (a()) {
            setRippleColor(ContextCompat.b(i2, getContext()));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f40073d.c(shapeAppearanceModel);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (a()) {
            MaterialButtonHelper materialButtonHelper = this.f40073d;
            materialButtonHelper.n = z;
            materialButtonHelper.f();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (a()) {
            MaterialButtonHelper materialButtonHelper = this.f40073d;
            if (materialButtonHelper.f40096k != colorStateList) {
                materialButtonHelper.f40096k = colorStateList;
                materialButtonHelper.f();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (a()) {
            setStrokeColor(ContextCompat.b(i2, getContext()));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (a()) {
            MaterialButtonHelper materialButtonHelper = this.f40073d;
            if (materialButtonHelper.f40093h != i2) {
                materialButtonHelper.f40093h = i2;
                materialButtonHelper.f();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        if (materialButtonHelper.f40095j != colorStateList) {
            materialButtonHelper.f40095j = colorStateList;
            if (materialButtonHelper.b(false) != null) {
                materialButtonHelper.b(false).setTintList(materialButtonHelper.f40095j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        MaterialButtonHelper materialButtonHelper = this.f40073d;
        if (materialButtonHelper.f40094i != mode) {
            materialButtonHelper.f40094i = mode;
            if (materialButtonHelper.b(false) == null || materialButtonHelper.f40094i == null) {
                return;
            }
            materialButtonHelper.b(false).setTintMode(materialButtonHelper.f40094i);
        }
    }

    @Override // android.view.View
    @RequiresApi
    public void setTextAlignment(int i2) {
        super.setTextAlignment(i2);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.f40073d.r = z;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = t;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40074e = new LinkedHashSet();
        this.o = false;
        this.p = false;
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i2, i3, new int[0]);
        this.n = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        int i4 = typedArrayD.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f40076g = ViewUtils.i(i4, mode);
        this.f40077h = MaterialResources.a(getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.f40078i = MaterialResources.d(getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialButton_icon);
        this.q = typedArrayD.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.f40080k = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, ShapeAppearanceModel.c(context2, attributeSet, i2, i3).a());
        this.f40073d = materialButtonHelper;
        materialButtonHelper.f40088c = typedArrayD.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetLeft, 0);
        materialButtonHelper.f40089d = typedArrayD.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetRight, 0);
        materialButtonHelper.f40090e = typedArrayD.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetTop, 0);
        materialButtonHelper.f40091f = typedArrayD.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArrayD.hasValue(com.google.android.material.R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_cornerRadius, -1);
            materialButtonHelper.f40092g = dimensionPixelSize;
            ShapeAppearanceModel.Builder builderG = materialButtonHelper.f40087b.g();
            builderG.c(dimensionPixelSize);
            materialButtonHelper.c(builderG.a());
            materialButtonHelper.p = true;
        }
        materialButtonHelper.f40093h = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_strokeWidth, 0);
        materialButtonHelper.f40094i = ViewUtils.i(typedArrayD.getInt(com.google.android.material.R.styleable.MaterialButton_backgroundTintMode, -1), mode);
        materialButtonHelper.f40095j = MaterialResources.a(getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialButton_backgroundTint);
        materialButtonHelper.f40096k = MaterialResources.a(getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialButton_strokeColor);
        materialButtonHelper.f40097l = MaterialResources.a(getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialButton_rippleColor);
        materialButtonHelper.q = typedArrayD.getBoolean(com.google.android.material.R.styleable.MaterialButton_android_checkable, false);
        materialButtonHelper.t = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_elevation, 0);
        materialButtonHelper.r = typedArrayD.getBoolean(com.google.android.material.R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(com.google.android.material.R.styleable.MaterialButton_android_background)) {
            materialButtonHelper.o = true;
            setSupportBackgroundTintList(materialButtonHelper.f40095j);
            setSupportBackgroundTintMode(materialButtonHelper.f40094i);
        } else {
            materialButtonHelper.e();
        }
        setPaddingRelative(paddingStart + materialButtonHelper.f40088c, paddingTop + materialButtonHelper.f40090e, paddingEnd + materialButtonHelper.f40089d, paddingBottom + materialButtonHelper.f40091f);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.n);
        c(this.f40078i != null);
    }
}
