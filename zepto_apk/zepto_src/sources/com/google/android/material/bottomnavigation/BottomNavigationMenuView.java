package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public boolean L;
    public final ArrayList M;

    public BottomNavigationMenuView(Context context) {
        super(context);
        this.M = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.H = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.I = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.J = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.K = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView e(Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (getLayoutDirection() == 1) {
                    int i9 = i6 - measuredWidth;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i7);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i7);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = menu.m().size();
        int childCount = getChildCount();
        ArrayList arrayList = this.M;
        arrayList.clear();
        int size3 = View.MeasureSpec.getSize(i3);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        boolean zF = NavigationBarMenuView.f(getLabelVisibilityMode(), size2);
        int i6 = this.J;
        if (zF && this.L) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int iMax = this.K;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.I * i7), Math.min(iMax, i6));
            int i8 = size - iMin;
            int iMin2 = Math.min(i8 / (i7 != 0 ? i7 : 1), this.H);
            int i9 = i8 - (i7 * iMin2);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    i5 = i10 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i9 > 0) {
                        i5++;
                        i9--;
                    }
                } else {
                    i5 = 0;
                }
                arrayList.add(Integer.valueOf(i5));
                i10++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), i6);
            int i11 = size - (size2 * iMin3);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (getChildAt(i12).getVisibility() == 8) {
                    i4 = 0;
                } else if (i11 > 0) {
                    i4 = iMin3 + 1;
                    i11--;
                } else {
                    i4 = iMin3;
                }
                arrayList.add(Integer.valueOf(i4));
            }
        }
        int measuredWidth = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i13)).intValue(), 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth = childAt2.getMeasuredWidth() + measuredWidth;
            }
        }
        setMeasuredDimension(measuredWidth, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.L = z;
    }
}
