package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeColorMatrixManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeColorMatrixManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "height":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setResult(view, obj != null ? (String) obj : null);
                break;
            case "values":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setValues(view, (ReadableArray) obj);
                break;
            case "x":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setIn1(view, obj != null ? (String) obj : null);
                break;
            case "type":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setType(view, (String) obj);
                break;
            case "width":
                ((RNSVGFeColorMatrixManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
