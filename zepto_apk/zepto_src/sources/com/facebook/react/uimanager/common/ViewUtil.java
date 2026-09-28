package com.facebook.react.uimanager.common;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ViewUtil {
    public static final int a(int i2) {
        return i2 % 2 == 0 ? 2 : 1;
    }

    public static final int b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return a(view.getId());
    }
}
