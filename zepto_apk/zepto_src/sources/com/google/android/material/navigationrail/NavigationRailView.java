package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: g, reason: collision with root package name */
    public final int f40755g;

    /* renamed from: h, reason: collision with root package name */
    public final View f40756h;

    /* renamed from: i, reason: collision with root package name */
    public final Boolean f40757i;

    /* renamed from: j, reason: collision with root package name */
    public final Boolean f40758j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f40759k;

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new NavigationRailMenuView(context);
    }

    @Nullable
    public View getHeaderView() {
        return this.f40756h;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        View view = this.f40756h;
        int i6 = 0;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        int i7 = this.f40755g;
        if (z2) {
            int bottom = this.f40756h.getBottom() + i7;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i6 = bottom - top;
            }
        } else if ((navigationRailMenuView.I.gravity & 112) == 48) {
            i6 = i7;
        }
        if (i6 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i6, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i6);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) != 1073741824 && suggestedMinimumWidth > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i2, i3);
        View view = this.f40756h;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        measureChild(getNavigationRailMenuView(), i2, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f40756h.getMeasuredHeight()) - this.f40755g, Integer.MIN_VALUE));
    }

    public void setItemMinimumHeight(@Px int i2) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i2);
    }

    public void setMenuGravity(int i2) {
        getNavigationRailMenuView().setMenuGravity(i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = R.style.Widget_MaterialComponents_NavigationRailView;
        super(context, attributeSet, i2, i3);
        this.f40757i = null;
        this.f40758j = null;
        this.f40759k = null;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        this.f40755g = dimensionPixelSize;
        Context context2 = getContext();
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(context2, attributeSet, R.styleable.NavigationRailView, i2, i3, new int[0]);
        int i4 = R.styleable.NavigationRailView_headerLayout;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        int resourceId = typedArray.getResourceId(i4, 0);
        if (resourceId != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view = this.f40756h;
            if (view != null) {
                removeView(view);
                this.f40756h = null;
            }
            this.f40756h = viewInflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = dimensionPixelSize;
            addView(viewInflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        if (typedArray.hasValue(R.styleable.NavigationRailView_itemMinHeight)) {
            setItemMinimumHeight(typedArray.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1));
        }
        if (typedArray.hasValue(R.styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.f40757i = Boolean.valueOf(typedArray.getBoolean(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (typedArray.hasValue(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.f40758j = Boolean.valueOf(typedArray.getBoolean(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        if (typedArray.hasValue(R.styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.f40759k = Boolean.valueOf(typedArray.getBoolean(R.styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fB = AnimationUtils.b(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f);
        float fC = AnimationUtils.c(fB, getItemPaddingTop(), dimensionPixelOffset);
        float fC2 = AnimationUtils.c(fB, getItemPaddingBottom(), dimensionPixelOffset2);
        setItemPaddingTop(Math.round(fC));
        setItemPaddingBottom(Math.round(fC2));
        tintTypedArrayE.g();
        ViewUtils.b(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                boolean fitsSystemWindows;
                boolean fitsSystemWindows2;
                boolean fitsSystemWindows3;
                Insets insetsD = windowInsetsCompat.d(519);
                NavigationRailView navigationRailView = NavigationRailView.this;
                Boolean bool = navigationRailView.f40757i;
                if (bool != null) {
                    fitsSystemWindows = bool.booleanValue();
                } else {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    fitsSystemWindows = navigationRailView.getFitsSystemWindows();
                }
                if (fitsSystemWindows) {
                    relativePadding.f40661b += insetsD.f2809b;
                }
                Boolean bool2 = navigationRailView.f40758j;
                if (bool2 != null) {
                    fitsSystemWindows2 = bool2.booleanValue();
                } else {
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    fitsSystemWindows2 = navigationRailView.getFitsSystemWindows();
                }
                if (fitsSystemWindows2) {
                    relativePadding.f40663d += insetsD.f2811d;
                }
                Boolean bool3 = navigationRailView.f40759k;
                if (bool3 != null) {
                    fitsSystemWindows3 = bool3.booleanValue();
                } else {
                    WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                    fitsSystemWindows3 = navigationRailView.getFitsSystemWindows();
                }
                if (fitsSystemWindows3) {
                    relativePadding.f40660a += ViewUtils.h(view2) ? insetsD.f2810c : insetsD.f2808a;
                }
                int i5 = relativePadding.f40660a;
                int i6 = relativePadding.f40661b;
                int i7 = relativePadding.f40662c;
                int i8 = relativePadding.f40663d;
                WeakHashMap weakHashMap4 = ViewCompat.f3080a;
                view2.setPaddingRelative(i5, i6, i7, i8);
                return windowInsetsCompat;
            }
        });
    }
}
