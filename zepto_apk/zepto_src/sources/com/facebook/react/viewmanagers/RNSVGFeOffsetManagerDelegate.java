package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeOffsetManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeOffsetManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "height":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setResult(view, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "dx":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setDx(view, new DynamicFromObject(obj));
                break;
            case "dy":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setDy(view, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setIn1(view, obj != null ? (String) obj : null);
                break;
            case "width":
                ((RNSVGFeOffsetManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
