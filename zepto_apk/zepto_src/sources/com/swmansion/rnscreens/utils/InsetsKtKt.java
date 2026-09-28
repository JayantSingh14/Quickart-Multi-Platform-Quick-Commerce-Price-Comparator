package com.swmansion.rnscreens.utils;

import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.swmansion.rnscreens.CustomToolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class InsetsKtKt {
    public static final Insets a(CustomToolbar customToolbar, int i2, WindowInsets windowInsets, boolean z) {
        Intrinsics.checkNotNullParameter(customToolbar, "<this>");
        if (windowInsets == null) {
            Insets NONE = Insets.f2807e;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            return NONE;
        }
        WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(customToolbar, windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatR, "toWindowInsetsCompat(...)");
        if (z) {
            Insets insetsE = windowInsetsCompatR.e(i2);
            Intrinsics.c(insetsE);
            return insetsE;
        }
        Insets insetsD = windowInsetsCompatR.d(i2);
        Intrinsics.c(insetsD);
        return insetsD;
    }
}
