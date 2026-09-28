package com.facebook.react.devsupport;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements OnApplyWindowInsetsListener {
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
        int i2 = RedBoxDialogSurfaceDelegate.AnonymousClass1.f18891b;
        Insets insetsD = windowInsetsCompat.d(647);
        ((FrameLayout.LayoutParams) view.getLayoutParams()).setMargins(insetsD.f2808a, insetsD.f2809b, insetsD.f2810c, insetsD.f2811d);
        return WindowInsetsCompat.f3149b;
    }
}
