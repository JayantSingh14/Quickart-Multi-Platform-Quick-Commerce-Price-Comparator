package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo
/* loaded from: classes3.dex */
public class TypedArrayUtils {
    public static int a(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }

    public static boolean b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, boolean z) {
        return !h(xmlPullParser, str) ? z : typedArray.getBoolean(i2, z);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        if (!(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(1, typedValue);
        int i2 = typedValue.type;
        if (i2 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
        }
        if (i2 >= 28 && i2 <= 31) {
            return ColorStateList.valueOf(typedValue.data);
        }
        Resources resources = typedArray.getResources();
        int resourceId = typedArray.getResourceId(1, 0);
        ThreadLocal threadLocal = ColorStateListInflaterCompat.f2746a;
        try {
            return ColorStateListInflaterCompat.a(resources, resources.getXml(resourceId), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    public static ComplexColorCompat d(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2) {
        ComplexColorCompat complexColorCompatA;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return new ComplexColorCompat(null, null, typedValue.data);
            }
            try {
                complexColorCompatA = ComplexColorCompat.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
                complexColorCompatA = null;
            }
            if (complexColorCompatA != null) {
                return complexColorCompatA;
            }
        }
        return new ComplexColorCompat(null, null, 0);
    }

    public static float e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        return !h(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !h(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    public static String g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (h(xmlPullParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    public static boolean h(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray i(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
