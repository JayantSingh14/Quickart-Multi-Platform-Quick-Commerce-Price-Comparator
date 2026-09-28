package com.facebook.react.devsupport;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        View view = (View) obj;
        WindowInsetsCompat windowInsets = (WindowInsetsCompat) obj2;
        int i2 = LogBoxDialog.f18855b;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insetsD = windowInsets.d(647);
        Intrinsics.checkNotNullExpressionValue(insetsD, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(insetsD.f2808a, insetsD.f2809b, insetsD.f2810c, insetsD.f2811d);
        return WindowInsetsCompat.f3149b;
    }
}
