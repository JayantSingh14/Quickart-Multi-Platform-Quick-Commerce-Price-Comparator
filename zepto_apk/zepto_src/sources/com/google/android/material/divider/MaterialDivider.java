package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    public static final int f40404f = R.style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialShapeDrawable f40405a;

    /* renamed from: b, reason: collision with root package name */
    public int f40406b;

    /* renamed from: c, reason: collision with root package name */
    public int f40407c;

    /* renamed from: d, reason: collision with root package name */
    public int f40408d;

    /* renamed from: e, reason: collision with root package name */
    public int f40409e;

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    public int getDividerColor() {
        return this.f40407c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f40409e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f40408d;
    }

    public int getDividerThickness() {
        return this.f40406b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i2;
        super.onDraw(canvas);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        boolean z = getLayoutDirection() == 1;
        int i3 = z ? this.f40409e : this.f40408d;
        if (z) {
            width = getWidth();
            i2 = this.f40408d;
        } else {
            width = getWidth();
            i2 = this.f40409e;
        }
        int i4 = width - i2;
        MaterialShapeDrawable materialShapeDrawable = this.f40405a;
        materialShapeDrawable.setBounds(i3, 0, i4, getBottom() - getTop());
        materialShapeDrawable.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i4 = this.f40406b;
            if (i4 > 0 && measuredHeight != i4) {
                measuredHeight = i4;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i2) {
        if (this.f40407c != i2) {
            this.f40407c = i2;
            this.f40405a.m(ColorStateList.valueOf(i2));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i2) {
        setDividerColor(getContext().getColor(i2));
    }

    public void setDividerInsetEnd(@Px int i2) {
        this.f40409e = i2;
    }

    public void setDividerInsetEndResource(@DimenRes int i2) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerInsetStart(@Px int i2) {
        this.f40408d = i2;
    }

    public void setDividerInsetStartResource(@DimenRes int i2) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerThickness(@Px int i2) {
        if (this.f40406b != i2) {
            this.f40406b = i2;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i2) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f40404f;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        this.f40405a = new MaterialShapeDrawable();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.MaterialDivider, i2, i3, new int[0]);
        this.f40406b = typedArrayD.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f40408d = typedArrayD.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f40409e = typedArrayD.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(MaterialResources.a(context2, typedArrayD, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayD.recycle();
    }
}
