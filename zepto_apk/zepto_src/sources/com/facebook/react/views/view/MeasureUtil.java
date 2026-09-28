package com.facebook.react.views.view;

import android.view.View;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MeasureUtil {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[YogaMeasureMode.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final int a(float f2, YogaMeasureMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int iOrdinal = mode.ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec((int) f2, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824);
    }
}
