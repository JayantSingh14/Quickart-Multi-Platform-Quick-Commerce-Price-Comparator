package com.google.android.material.ripple;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

@RestrictTo
/* loaded from: classes4.dex */
public class RippleUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f40890a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f40891b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f40892c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f40893d = {R.attr.state_selected};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f40894e = {R.attr.state_enabled, R.attr.state_pressed};

    @RequiresApi
    public static class RippleUtilsLollipop {
        @DoNotInline
        private static Drawable a(@NonNull Context context, @Px int i2) {
            ColorStateList colorStateListB;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) gradientDrawable, i2, i2, i2, i2);
            int i3 = com.google.android.material.R.attr.colorControlHighlight;
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(0);
            TypedValue typedValueA = MaterialAttributes.a(i3, context);
            if (typedValueA != null) {
                int i4 = typedValueA.resourceId;
                colorStateListB = i4 != 0 ? ContextCompat.b(i4, context) : ColorStateList.valueOf(typedValueA.data);
            } else {
                colorStateListB = null;
            }
            if (colorStateListB != null) {
                colorStateListValueOf = colorStateListB;
            }
            return new RippleDrawable(colorStateListValueOf, null, insetDrawable);
        }
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f40891b;
        return new ColorStateList(new int[][]{f40893d, iArr, StateSet.NOTHING}, new int[]{b(colorStateList, f40892c), b(colorStateList, iArr), b(colorStateList, f40890a)});
    }

    public static int b(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return ColorUtils.k(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f40894e, 0)) != 0) {
            Log.w("RippleUtils", "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean d(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
