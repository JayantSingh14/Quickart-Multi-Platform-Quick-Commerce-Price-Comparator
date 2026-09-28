package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo
/* loaded from: classes.dex */
public class ThemeUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f1172a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1173b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f1174c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1175d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f1176e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f1177f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f1178g = new int[1];

    public static void a(Context context, View view) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(int i2, Context context) {
        ColorStateList colorStateListD = d(i2, context);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f1173b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = f1172a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f2 = typedValue.getFloat();
        return ColorUtils.k(c(i2, context), Math.round(Color.alpha(r4) * f2));
    }

    public static int c(int i2, Context context) {
        int[] iArr = f1178g;
        iArr[0] = i2;
        TintTypedArray tintTypedArrayE = TintTypedArray.e(context, null, iArr);
        try {
            return tintTypedArrayE.f1185b.getColor(0, 0);
        } finally {
            tintTypedArrayE.g();
        }
    }

    public static ColorStateList d(int i2, Context context) {
        int[] iArr = f1178g;
        iArr[0] = i2;
        TintTypedArray tintTypedArrayE = TintTypedArray.e(context, null, iArr);
        try {
            return tintTypedArrayE.a(0);
        } finally {
            tintTypedArrayE.g();
        }
    }
}
