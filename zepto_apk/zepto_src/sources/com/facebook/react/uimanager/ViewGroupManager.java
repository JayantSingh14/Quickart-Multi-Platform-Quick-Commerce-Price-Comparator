package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.List;
import java.util.WeakHashMap;
import org.jetbrains.annotations.NotNull;

@Nullsafe
/* loaded from: classes.dex */
public abstract class ViewGroupManager<T extends ViewGroup> extends BaseViewManager<T, LayoutShadowNode> implements IViewGroupManager<T> {
    private static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap<>();

    public ViewGroupManager() {
        super(null);
    }

    @Nullable
    public static Integer getViewZIndex(@Nullable View view) {
        return mZIndexHash.get(view);
    }

    public static void setViewZIndex(View view, int i2) {
        mZIndexHash.put(view, Integer.valueOf(i2));
    }

    public void addViews(T t, List<View> list) {
        UiThreadUtil.assertOnUiThread();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            addView((ViewGroupManager<T>) t, list.get(i2), i2);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return false;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    public void removeView(T t, View view) {
        UiThreadUtil.assertOnUiThread();
        for (int i2 = 0; i2 < getChildCount((ViewGroupManager<T>) t); i2++) {
            if (getChildAt((ViewGroupManager<T>) t, i2) == view) {
                removeViewAt((ViewGroupManager<T>) t, i2);
                return;
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(T t, Object obj) {
    }

    public ViewGroupManager(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void addView(T t, View view, int i2) {
        t.addView(view, i2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    @Nullable
    public View getChildAt(T t, int i2) {
        return t.getChildAt(i2);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public int getChildCount(T t) {
        return t.getChildCount();
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeViewAt(T t, int i2) {
        UiThreadUtil.assertOnUiThread();
        t.removeViewAt(i2);
    }
}
