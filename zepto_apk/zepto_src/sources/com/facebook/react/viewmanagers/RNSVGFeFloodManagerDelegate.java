package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeFloodManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeFloodManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "floodColor":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setFloodColor(view, new DynamicFromObject(obj));
                break;
            case "height":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "floodOpacity":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setFloodOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case "result":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setResult(view, obj == null ? null : (String) obj);
                break;
            case "x":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "width":
                ((RNSVGFeFloodManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
