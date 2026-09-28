package com.swmansion.rnscreens;

import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ScreenWindowTraits$windowInsetsListener$1 implements OnApplyWindowInsetsListener {
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatT = ViewCompat.t(v, insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatT, "onApplyWindowInsets(...)");
        if (Build.VERSION.SDK_INT < 30) {
            WindowInsetsCompat windowInsetsCompatP = windowInsetsCompatT.p(windowInsetsCompatT.h(), 0, windowInsetsCompatT.i(), windowInsetsCompatT.g());
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatP, "replaceSystemWindowInsets(...)");
            return windowInsetsCompatP;
        }
        Insets insetsD = windowInsetsCompatT.d(1);
        Intrinsics.checkNotNullExpressionValue(insetsD, "getInsets(...)");
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
        builder.b(1, Insets.c(insetsD.f2808a, 0, insetsD.f2810c, insetsD.f2811d));
        WindowInsetsCompat windowInsetsCompatA = builder.a();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatA, "build(...)");
        return windowInsetsCompatA;
    }
}
