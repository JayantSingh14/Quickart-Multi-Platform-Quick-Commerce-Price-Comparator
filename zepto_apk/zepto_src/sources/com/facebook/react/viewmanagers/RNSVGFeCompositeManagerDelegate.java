package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeCompositeManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeCompositeManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "height":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setResult(view, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "k1":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setK1(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case "k2":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setK2(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case "k3":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setK3(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case "k4":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setK4(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case "in1":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setIn1(view, obj != null ? (String) obj : null);
                break;
            case "in2":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setIn2(view, obj != null ? (String) obj : null);
                break;
            case "width":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            case "operator1":
                ((RNSVGFeCompositeManagerInterface) onLayoutChangeListener).setOperator1(view, (String) obj);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
