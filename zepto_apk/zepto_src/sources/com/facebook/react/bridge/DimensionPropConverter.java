package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;

/* loaded from: classes3.dex */
public class DimensionPropConverter {
    @Nullable
    public static YogaValue getDimension(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        boolean z = obj instanceof Double;
        YogaUnit yogaUnit = YogaUnit.POINT;
        if (z) {
            return new YogaValue(((Double) obj).floatValue(), yogaUnit);
        }
        if (!(obj instanceof String)) {
            throw new JSApplicationCausedNativeException("DimensionValue: the value must be a number or string.");
        }
        String str = (String) obj;
        return "undefined".equals(str) ? YogaValue.f20423c : "auto".equals(str) ? YogaValue.f20424d : str.endsWith("%") ? new YogaValue(Float.parseFloat(str.substring(0, str.length() - 1)), YogaUnit.PERCENT) : new YogaValue(Float.parseFloat(str), yogaUnit);
    }
}
