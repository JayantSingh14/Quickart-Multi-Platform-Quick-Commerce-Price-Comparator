package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFilterManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFilterManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFilterManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "primitiveUnits":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setPrimitiveUnits(view, (String) obj);
                break;
            case "height":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "filterUnits":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setFilterUnits(view, (String) obj);
                break;
            case "x":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "name":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setName(view, obj == null ? null : (String) obj);
                break;
            case "width":
                ((RNSVGFilterManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
