package com.google.android.material.bottomnavigation;

import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

@RestrictTo
/* loaded from: classes4.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    @Override // com.google.android.material.navigation.NavigationBarItemView
    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @LayoutRes
    public int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }
}
