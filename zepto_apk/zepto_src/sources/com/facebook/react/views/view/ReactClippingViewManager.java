package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public abstract class ReactClippingViewManager<T extends ReactViewGroup> extends ViewGroupManager<T> {
    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(@NotNull T view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        UiThreadUtil.assertOnUiThread();
        view.setRemoveClippedSubviews(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull T parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            parent.removeAllViewsWithSubviewClippingEnabled();
        } else {
            parent.removeAllViews();
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull T parent, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            parent.addViewWithSubviewClippingEnabled(child, i2);
        } else {
            parent.addView(child, i2);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    @Nullable
    public View getChildAt(@NotNull T parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getRemoveClippedSubviews()) {
            return parent.getChildAtWithSubviewClippingEnabled(i2);
        }
        return parent.getChildAt(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull T parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getRemoveClippedSubviews()) {
            return parent.getAllChildrenCount();
        }
        return parent.getChildCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull T parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        if (parent.getRemoveClippedSubviews()) {
            View childAt = getChildAt((ReactClippingViewManager<T>) parent, i2);
            if (childAt != null) {
                parent.removeViewWithSubviewClippingEnabled(childAt);
                return;
            }
            return;
        }
        parent.removeViewAt(i2);
    }
}
