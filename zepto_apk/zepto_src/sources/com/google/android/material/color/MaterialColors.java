package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes4.dex */
public class MaterialColors {
    public static int a(int i2, int i3) {
        return ColorUtils.k(i2, (Color.alpha(i2) * i3) / 255);
    }

    public static int b(int i2, View view) {
        Context context = view.getContext();
        TypedValue typedValueC = MaterialAttributes.c(view.getContext(), i2, view.getClass().getCanonicalName());
        int i3 = typedValueC.resourceId;
        return i3 != 0 ? context.getColor(i3) : typedValueC.data;
    }

    public static int c(Context context, int i2, int i3) {
        Integer numValueOf;
        TypedValue typedValueA = MaterialAttributes.a(i2, context);
        if (typedValueA != null) {
            int i4 = typedValueA.resourceId;
            numValueOf = Integer.valueOf(i4 != 0 ? context.getColor(i4) : typedValueA.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i3;
    }

    public static int d(Context context, int i2, String str) {
        TypedValue typedValueC = MaterialAttributes.c(context, i2, str);
        int i3 = typedValueC.resourceId;
        return i3 != 0 ? context.getColor(i3) : typedValueC.data;
    }

    public static ColorStateList e(int i2, Context context) {
        TypedValue typedValueA = MaterialAttributes.a(i2, context);
        if (typedValueA == null) {
            return null;
        }
        int i3 = typedValueA.resourceId;
        if (i3 != 0) {
            return ResourcesCompat.b(context.getResources(), i3, context.getTheme());
        }
        int i4 = typedValueA.data;
        if (i4 != 0) {
            return ColorStateList.valueOf(i4);
        }
        return null;
    }

    public static boolean f(int i2) {
        return i2 != 0 && ColorUtils.f(i2) > 0.5d;
    }

    public static int g(float f2, int i2, int i3) {
        return ColorUtils.h(ColorUtils.k(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }
}
