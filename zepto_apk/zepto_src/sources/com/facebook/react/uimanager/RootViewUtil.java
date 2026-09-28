package com.facebook.react.uimanager;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.facebook.infer.annotation.Assertions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RootViewUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static final RootView a(View reactView) {
        Intrinsics.checkNotNullParameter(reactView, "reactView");
        View view = reactView;
        while (!(view instanceof RootView)) {
            Object parent = view.getParent();
            if (parent == null) {
                return null;
            }
            Assertions.a(parent instanceof View);
            view = (View) parent;
        }
        return (RootView) view;
    }

    public static final Point b(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int[] iArr = new int[2];
        v.getLocationInWindow(iArr);
        Rect rect = new Rect();
        v.getWindowVisibleDisplayFrame(rect);
        iArr[0] = iArr[0] - rect.left;
        iArr[1] = iArr[1] - rect.top;
        return new Point(iArr[0], iArr[1]);
    }
}
