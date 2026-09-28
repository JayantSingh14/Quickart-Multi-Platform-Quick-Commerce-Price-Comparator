package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface IViewGroupManager<T extends View> extends IViewManagerWithChildren {
    void addView(View view, View view2, int i2);

    View getChildAt(View view, int i2);

    int getChildCount(View view);

    default void removeAllViews(View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        int childCount = getChildCount(parent);
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            } else {
                removeViewAt(parent, childCount);
            }
        }
    }

    void removeViewAt(View view, int i2);
}
