package com.swmansion.reanimated;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.drawable.CSSBackgroundDrawable;
import com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.swmansion.reanimated.ReactNativeUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class BorderRadiiDrawableUtils {
    public static ReactNativeUtils.BorderRadii getBorderRadii(View view) {
        return new ReactNativeUtils.BorderRadii(getRadiusForCorner(view, BorderRadiusProp.f19836a, 0.0f), getRadiusForCorner(view, BorderRadiusProp.f19837b, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.f19838c, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.f19840e, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.f19839d, Float.NaN));
    }

    private static float getRadiusForCorner(View view, BorderRadiusProp corner, float f2) {
        BorderRadiusStyle borderRadiusStyle;
        BorderRadiusStyle borderRadiusStyle2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        LengthPercentage lengthPercentageB = null;
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            Drawable background = view.getBackground();
            CompositeBackgroundDrawable compositeBackgroundDrawable = background instanceof CompositeBackgroundDrawable ? (CompositeBackgroundDrawable) background : null;
            if (compositeBackgroundDrawable != null && (borderRadiusStyle2 = compositeBackgroundDrawable.f19677k) != null) {
                lengthPercentageB = borderRadiusStyle2.b(corner);
            }
        } else {
            Drawable background2 = view.getBackground();
            CompositeBackgroundDrawable compositeBackgroundDrawable2 = background2 instanceof CompositeBackgroundDrawable ? (CompositeBackgroundDrawable) background2 : null;
            CSSBackgroundDrawable cSSBackgroundDrawable = compositeBackgroundDrawable2 != null ? compositeBackgroundDrawable2.f19669c : null;
            if (cSSBackgroundDrawable != null && (borderRadiusStyle = cSSBackgroundDrawable.y) != null) {
                lengthPercentageB = borderRadiusStyle.b(corner);
            }
        }
        if (lengthPercentageB == null) {
            return f2;
        }
        Rect bounds = view.getBackground().getBounds();
        return lengthPercentageB.a(bounds.width(), bounds.height()).a().f19879a;
    }
}
