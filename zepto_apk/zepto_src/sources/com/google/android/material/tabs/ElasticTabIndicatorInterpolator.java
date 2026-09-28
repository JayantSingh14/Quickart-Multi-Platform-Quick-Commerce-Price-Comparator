package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes4.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public final void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        float fCos;
        float fCos2;
        RectF rectFA = TabIndicatorInterpolator.a(tabLayout, view);
        RectF rectFA2 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            double d2 = (f2 * 3.141592653589793d) / 2.0d;
            fCos2 = (float) (1.0d - Math.cos(d2));
            fCos = (float) Math.sin(d2);
        } else {
            double d3 = (f2 * 3.141592653589793d) / 2.0d;
            float fSin = (float) Math.sin(d3);
            fCos = (float) (1.0d - Math.cos(d3));
            fCos2 = fSin;
        }
        drawable.setBounds(AnimationUtils.c(fCos2, (int) rectFA.left, (int) rectFA2.left), drawable.getBounds().top, AnimationUtils.c(fCos, (int) rectFA.right, (int) rectFA2.right), drawable.getBounds().bottom);
    }
}
