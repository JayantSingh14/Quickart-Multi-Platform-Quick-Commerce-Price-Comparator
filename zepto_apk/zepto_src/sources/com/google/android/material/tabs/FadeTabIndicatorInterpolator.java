package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes4.dex */
class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public final void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        if (f2 >= 0.5f) {
            view = view2;
        }
        RectF rectFA = TabIndicatorInterpolator.a(tabLayout, view);
        float fB = f2 < 0.5f ? AnimationUtils.b(1.0f, 0.0f, 0.0f, 0.5f, f2) : AnimationUtils.b(0.0f, 1.0f, 0.5f, 1.0f, f2);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fB * 255.0f));
    }
}
