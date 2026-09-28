package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f40118m = {R.attr.state_checkable};
    public static final int[] n = {R.attr.state_checked};
    public static final int[] o = {com.google.android.material.R.attr.state_dragged};
    public static final int p = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    /* renamed from: h, reason: collision with root package name */
    public final MaterialCardViewHelper f40119h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f40120i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40121j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40122k;

    /* renamed from: l, reason: collision with root package name */
    public OnCheckedChangeListener f40123l;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void a();
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f40119h.f40126c.getBounds());
        return rectF;
    }

    public final void g() {
        MaterialCardViewHelper materialCardViewHelper;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (materialCardViewHelper = this.f40119h).o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i2 = bounds.bottom;
        materialCardViewHelper.o.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
        materialCardViewHelper.o.setBounds(bounds.left, bounds.top, bounds.right, i2);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f40119h.f40126c.f40974a.f40991c;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f40119h.f40127d.f40974a.f40991c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f40119h.f40133j;
    }

    public int getCheckedIconGravity() {
        return this.f40119h.f40130g;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f40119h.f40128e;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f40119h.f40129f;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f40119h.f40135l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f40119h.f40125b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f40119h.f40125b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f40119h.f40125b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f40119h.f40125b.top;
    }

    @FloatRange
    public float getProgress() {
        return this.f40119h.f40126c.f40974a.f40997i;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f40119h.f40126c.i();
    }

    public ColorStateList getRippleColor() {
        return this.f40119h.f40134k;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40119h.f40136m;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f40119h.n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f40119h.n;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f40119h.f40131h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f40121j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.k();
        MaterialShapeUtils.c(this, materialCardViewHelper.f40126c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (materialCardViewHelper != null && materialCardViewHelper.s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f40118m);
        }
        if (this.f40121j) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, n);
        }
        if (this.f40122k) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, o);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f40121j);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        accessibilityNodeInfo.setCheckable(materialCardViewHelper != null && materialCardViewHelper.s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f40121j);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f40119h.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f40120i) {
            MaterialCardViewHelper materialCardViewHelper = this.f40119h;
            if (!materialCardViewHelper.r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                materialCardViewHelper.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f40119h.f40126c.m(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.f40126c.l(materialCardViewHelper.f40124a.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f40119h.f40127d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.m(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f40119h.s = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f40121j != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f40119h.g(drawable);
    }

    public void setCheckedIconGravity(int i2) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (materialCardViewHelper.f40130g != i2) {
            materialCardViewHelper.f40130g = i2;
            MaterialCardView materialCardView = materialCardViewHelper.f40124a;
            materialCardViewHelper.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.f40119h.f40128e = i2;
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.f40119h.f40128e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.f40119h.g(AppCompatResources.b(i2, getContext()));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.f40119h.f40129f = i2;
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.f40119h.f40129f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.f40135l = colorStateList;
        Drawable drawable = materialCardViewHelper.f40133j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.k();
        }
    }

    public void setDragged(boolean z) {
        if (this.f40122k != z) {
            this.f40122k = z;
            refreshDrawableState();
            g();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f40119h.m();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.f40123l = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.m();
        materialCardViewHelper.l();
    }

    public void setProgress(@FloatRange float f2) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.f40126c.n(f2);
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f40127d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.n(f2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.q;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.n(f2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    @Override // androidx.cardview.widget.CardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setRadius(float r3) {
        /*
            r2 = this;
            super.setRadius(r3)
            com.google.android.material.card.MaterialCardViewHelper r0 = r2.f40119h
            com.google.android.material.shape.ShapeAppearanceModel r1 = r0.f40136m
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = r1.g()
            r1.c(r3)
            com.google.android.material.shape.ShapeAppearanceModel r3 = r1.a()
            r0.h(r3)
            android.graphics.drawable.Drawable r3 = r0.f40132i
            r3.invalidateSelf()
            boolean r3 = r0.i()
            if (r3 != 0) goto L38
            com.google.android.material.card.MaterialCardView r3 = r0.f40124a
            boolean r3 = r3.getPreventCornerOverlap()
            if (r3 == 0) goto L3b
            com.google.android.material.shape.MaterialShapeDrawable r3 = r0.f40126c
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r1 = r3.f40974a
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.f40989a
            android.graphics.RectF r3 = r3.g()
            boolean r3 = r1.f(r3)
            if (r3 != 0) goto L3b
        L38:
            r0.l()
        L3b:
            boolean r3 = r0.i()
            if (r3 == 0) goto L44
            r0.m()
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.setRadius(float):void");
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.f40134k = colorStateList;
        RippleDrawable rippleDrawable = materialCardViewHelper.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        ColorStateList colorStateListB = ContextCompat.b(i2, getContext());
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.f40134k = colorStateListB;
        RippleDrawable rippleDrawable = materialCardViewHelper.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListB);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.f(getBoundsAsRectF()));
        this.f40119h.h(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i2) {
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (i2 != materialCardViewHelper.f40131h) {
            materialCardViewHelper.f40131h = i2;
            MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f40127d;
            ColorStateList colorStateList = materialCardViewHelper.n;
            materialShapeDrawable.u(i2);
            materialShapeDrawable.t(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        materialCardViewHelper.m();
        materialCardViewHelper.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (materialCardViewHelper != null && materialCardViewHelper.s && isEnabled()) {
            this.f40121j = !this.f40121j;
            refreshDrawableState();
            g();
            materialCardViewHelper.f(this.f40121j, true);
            OnCheckedChangeListener onCheckedChangeListener = this.f40123l;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.a();
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        int i3 = p;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40121j = false;
        this.f40122k = false;
        this.f40120i = true;
        TypedArray typedArrayD = ThemeEnforcement.d(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i2, i3, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i2);
        this.f40119h = materialCardViewHelper;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f40126c;
        materialShapeDrawable.m(cardBackgroundColor);
        materialCardViewHelper.f40125b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        materialCardViewHelper.l();
        MaterialCardView materialCardView = materialCardViewHelper.f40124a;
        ColorStateList colorStateListA = MaterialResources.a(materialCardView.getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        materialCardViewHelper.n = colorStateListA;
        if (colorStateListA == null) {
            materialCardViewHelper.n = ColorStateList.valueOf(-1);
        }
        materialCardViewHelper.f40131h = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArrayD.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        materialCardViewHelper.s = z;
        materialCardView.setLongClickable(z);
        materialCardViewHelper.f40135l = MaterialResources.a(materialCardView.getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        materialCardViewHelper.g(MaterialResources.d(materialCardView.getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        materialCardViewHelper.f40129f = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0);
        materialCardViewHelper.f40128e = typedArrayD.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0);
        materialCardViewHelper.f40130g = typedArrayD.getInteger(com.google.android.material.R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListA2 = MaterialResources.a(materialCardView.getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        materialCardViewHelper.f40134k = colorStateListA2;
        if (colorStateListA2 == null) {
            materialCardViewHelper.f40134k = ColorStateList.valueOf(MaterialColors.b(com.google.android.material.R.attr.colorControlHighlight, materialCardView));
        }
        ColorStateList colorStateListA3 = MaterialResources.a(materialCardView.getContext(), typedArrayD, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor);
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.f40127d;
        materialShapeDrawable2.m(colorStateListA3 == null ? ColorStateList.valueOf(0) : colorStateListA3);
        RippleDrawable rippleDrawable = materialCardViewHelper.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(materialCardViewHelper.f40134k);
        }
        materialShapeDrawable.l(materialCardView.getCardElevation());
        float f2 = materialCardViewHelper.f40131h;
        ColorStateList colorStateList = materialCardViewHelper.n;
        materialShapeDrawable2.u(f2);
        materialShapeDrawable2.t(colorStateList);
        materialCardView.setBackgroundInternal(materialCardViewHelper.d(materialShapeDrawable));
        Drawable drawableC = materialCardViewHelper.j() ? materialCardViewHelper.c() : materialShapeDrawable2;
        materialCardViewHelper.f40132i = drawableC;
        materialCardView.setForeground(materialCardViewHelper.d(drawableC));
        typedArrayD.recycle();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.f40119h;
        if (materialCardViewHelper.n != colorStateList) {
            materialCardViewHelper.n = colorStateList;
            MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f40127d;
            materialShapeDrawable.u(materialCardViewHelper.f40131h);
            materialShapeDrawable.t(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.f40119h.f40126c.m(ColorStateList.valueOf(i2));
    }
}
