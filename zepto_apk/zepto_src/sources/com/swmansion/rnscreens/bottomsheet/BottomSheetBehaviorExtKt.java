package com.swmansion.rnscreens.bottomsheet;

import android.content.res.Resources;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class BottomSheetBehaviorExtKt {
    public static void a(BottomSheetBehavior bottomSheetBehavior, Integer num) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.J = true;
        bottomSheetBehavior.P(true);
        bottomSheetBehavior.f(3);
        if (num != null) {
            bottomSheetBehavior.f40018l = num.intValue();
        }
    }

    public static final void b(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Float f2, Integer num3) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.J = false;
        bottomSheetBehavior.P(false);
        if (num != null) {
            bottomSheetBehavior.f(num.intValue());
        }
        if (num2 != null) {
            bottomSheetBehavior.S(num2.intValue());
        }
        if (f2 != null) {
            bottomSheetBehavior.Q(f2.floatValue());
        }
        if (num3 != null) {
            bottomSheetBehavior.O(num3.intValue());
        }
    }

    public static /* synthetic */ void c(BottomSheetBehavior bottomSheetBehavior, Integer num, Float f2, Integer num2, int i2) throws Resources.NotFoundException {
        Integer num3 = (i2 & 1) != 0 ? null : 3;
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            f2 = null;
        }
        if ((i2 & 8) != 0) {
            num2 = null;
        }
        b(bottomSheetBehavior, num3, num, f2, num2);
    }

    public static final void d(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.J = false;
        bottomSheetBehavior.P(true);
        if (num != null) {
            bottomSheetBehavior.f(num.intValue());
        }
        if (num2 != null) {
            bottomSheetBehavior.S(num2.intValue());
        }
        if (num3 != null) {
            bottomSheetBehavior.f40018l = num3.intValue();
        }
    }
}
