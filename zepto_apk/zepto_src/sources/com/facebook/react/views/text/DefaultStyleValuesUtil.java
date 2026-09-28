package com.facebook.react.views.text;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DefaultStyleValuesUtil {
    public static ColorStateList a(int i2, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        return typedArrayObtainStyledAttributes.getColorStateList(0);
    }

    public static final ColorStateList b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(R.attr.textColor, context);
    }

    public static final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateListA = a(R.attr.textColorHighlight, context);
        if (colorStateListA != null) {
            return colorStateListA.getDefaultColor();
        }
        return 0;
    }

    public static final ColorStateList d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(R.attr.textColorHint, context);
    }
}
