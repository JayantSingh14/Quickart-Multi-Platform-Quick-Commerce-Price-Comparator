package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface;

/* loaded from: classes3.dex */
public class ActivityIndicatorViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & ActivityIndicatorViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "size":
                ((ActivityIndicatorViewManagerInterface) onLayoutChangeListener).setSize(view, (String) obj);
                break;
            case "color":
                ((ActivityIndicatorViewManagerInterface) onLayoutChangeListener).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "hidesWhenStopped":
                ActivityIndicatorViewManagerInterface activityIndicatorViewManagerInterface = (ActivityIndicatorViewManagerInterface) onLayoutChangeListener;
                if (obj != null) {
                }
                activityIndicatorViewManagerInterface.a();
                break;
            case "animating":
                ((ActivityIndicatorViewManagerInterface) onLayoutChangeListener).setAnimating(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
