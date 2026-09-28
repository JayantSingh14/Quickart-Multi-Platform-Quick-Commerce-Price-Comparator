package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;

/* loaded from: classes.dex */
public class RNGestureHandlerButtonManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNGestureHandlerButtonManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        BaseViewManager baseViewManager;
        str.getClass();
        baseViewManager = this.f19368a;
        switch (str) {
            case "rippleRadius":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setRippleRadius(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "rippleColor":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setRippleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "borderColor":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setBorderColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "borderStyle":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setBorderStyle(view, obj == null ? "solid" : (String) obj);
                break;
            case "borderWidth":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setBorderWidth(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "touchSoundDisabled":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setTouchSoundDisabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "exclusive":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setExclusive(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "borderless":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setBorderless(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "foreground":
                ((RNGestureHandlerButtonManagerInterface) baseViewManager).setForeground(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
