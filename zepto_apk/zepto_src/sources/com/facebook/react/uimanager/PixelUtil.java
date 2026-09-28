package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class PixelUtil {
    public static final float a(float f2) {
        if (Float.isNaN(f2)) {
            return Float.NaN;
        }
        return f2 / DisplayMetricsHolder.d().density;
    }

    public static final float b(float f2) {
        if (Float.isNaN(f2)) {
            return Float.NaN;
        }
        return TypedValue.applyDimension(1, f2, DisplayMetricsHolder.d());
    }

    public static final float c(float f2, float f3) {
        if (Float.isNaN(f2)) {
            return Float.NaN;
        }
        DisplayMetrics displayMetricsD = DisplayMetricsHolder.d();
        float fApplyDimension = TypedValue.applyDimension(2, f2, displayMetricsD);
        return f3 >= 1.0f ? Math.min(fApplyDimension, f2 * displayMetricsD.density * f3) : fApplyDimension;
    }
}
