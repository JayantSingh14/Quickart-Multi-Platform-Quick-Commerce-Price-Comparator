package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

/* loaded from: classes.dex */
public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "enabled":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "colors":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setColors(view, (ReadableArray) obj);
                break;
            case "progressBackgroundColor":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setProgressBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "progressViewOffset":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setProgressViewOffset(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "refreshing":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setRefreshing(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "size":
                ((AndroidSwipeRefreshLayoutManagerInterface) onLayoutChangeListener).setSize(view, (String) obj);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void b(View view, String str, ReadableArray readableArray) {
        str.getClass();
        if (str.equals("setNativeRefreshing")) {
            ((AndroidSwipeRefreshLayoutManagerInterface) this.f19368a).setNativeRefreshing(view, readableArray.getBoolean(0));
        }
    }
}
