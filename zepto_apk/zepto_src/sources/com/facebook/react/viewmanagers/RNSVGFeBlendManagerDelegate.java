package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeBlendManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeBlendManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "height":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setResult(view, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setIn1(view, obj != null ? (String) obj : null);
                break;
            case "in2":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setIn2(view, obj != null ? (String) obj : null);
                break;
            case "mode":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setMode(view, (String) obj);
                break;
            case "width":
                ((RNSVGFeBlendManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
