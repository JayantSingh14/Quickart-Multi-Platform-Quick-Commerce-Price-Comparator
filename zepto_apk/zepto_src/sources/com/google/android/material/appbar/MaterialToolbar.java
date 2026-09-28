package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class MaterialToolbar extends Toolbar {
    public static final int L0 = R.style.Widget_MaterialComponents_Toolbar;
    public static final ImageView.ScaleType[] M0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer G0;
    public boolean H0;
    public boolean I0;
    public ImageView.ScaleType J0;
    public Boolean K0;

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.J0;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.G0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void n(int i2) {
        Menu menu = getMenu();
        boolean z = menu instanceof MenuBuilder;
        if (z) {
            ((MenuBuilder) menu).B();
        }
        super.n(i2);
        if (z) {
            ((MenuBuilder) menu).A();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = 0;
        ImageView imageView2 = null;
        if (this.H0 || this.I0) {
            ArrayList arrayListC = ToolbarUtils.c(this, getTitle());
            boolean zIsEmpty = arrayListC.isEmpty();
            Comparator comparator = ToolbarUtils.f40651a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListC, comparator);
            ArrayList arrayListC2 = ToolbarUtils.c(this, getSubtitle());
            TextView textView2 = arrayListC2.isEmpty() ? null : (TextView) Collections.max(arrayListC2, comparator);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i7 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i8 = 0; i8 < getChildCount(); i8++) {
                    View childAt = getChildAt(i8);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i7 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i7 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.H0 && textView != null) {
                    z(textView, pair);
                }
                if (this.I0 && textView2 != null) {
                    z(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i6 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i6);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i6++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.K0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.J0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.b(this, f2);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.K0;
        if (bool == null || bool.booleanValue() != z) {
            this.K0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.J0 != scaleType) {
            this.J0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.G0 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.G0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.G0 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.H0 != z) {
            this.H0 = z;
            requestLayout();
        }
    }

    public final void z(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i2 += iMax;
            i3 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i2, textView.getTop(), i3, textView.getBottom());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = L0;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.MaterialToolbar, i2, i3, new int[0]);
        if (typedArrayD.hasValue(R.styleable.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayD.getColor(R.styleable.MaterialToolbar_navigationIconTint, -1));
        }
        this.H0 = typedArrayD.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.I0 = typedArrayD.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        int i4 = typedArrayD.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
        if (i4 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = M0;
            if (i4 < scaleTypeArr.length) {
                this.J0 = scaleTypeArr[i4];
            }
        }
        if (typedArrayD.hasValue(R.styleable.MaterialToolbar_logoAdjustViewBounds)) {
            this.K0 = Boolean.valueOf(typedArrayD.getBoolean(R.styleable.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : DrawableUtils.d(background);
        if (colorStateListValueOf != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.m(colorStateListValueOf);
            materialShapeDrawable.k(context2);
            materialShapeDrawable.l(ViewCompat.j(this));
            setBackground(materialShapeDrawable);
        }
    }
}
