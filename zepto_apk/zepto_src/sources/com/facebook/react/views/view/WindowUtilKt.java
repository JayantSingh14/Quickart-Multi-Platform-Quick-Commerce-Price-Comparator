package com.facebook.react.views.view;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WindowUtilKt {
    public static final void a(Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (z) {
            window.getDecorView().setOnApplyWindowInsetsListener(new b());
        } else {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
        }
        ViewCompat.x(window.getDecorView());
    }

    public static final void b(Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        WindowCompat.b(window, !z);
        if (z) {
            boolean z2 = (window.getContext().getResources().getConfiguration().uiMode & 48) == 32;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(true);
            }
            window.setStatusBarColor(0);
            window.setNavigationBarColor(i2 < 29 ? (i2 < 27 || z2) ? Color.argb(128, 27, 27, 27) : Color.argb(230, 255, 255, 255) : 0);
            new WindowInsetsControllerCompat(window, window.getDecorView()).d(!z2);
            if (i2 >= 28) {
                window.getAttributes().layoutInDisplayCutoutMode = i2 >= 30 ? 3 : 1;
            }
        }
    }
}
