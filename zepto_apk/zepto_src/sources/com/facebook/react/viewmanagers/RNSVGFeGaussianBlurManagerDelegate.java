package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface;

/* loaded from: classes.dex */
public class RNSVGFeGaussianBlurManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeGaussianBlurManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "height":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setResult(view, obj != null ? (String) obj : null);
                break;
            case "x":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setY(view, new DynamicFromObject(obj));
                break;
            case "in1":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setIn1(view, obj != null ? (String) obj : null);
                break;
            case "width":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setWidth(view, new DynamicFromObject(obj));
                break;
            case "edgeMode":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setEdgeMode(view, (String) obj);
                break;
            case "stdDeviationX":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setStdDeviationX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case "stdDeviationY":
                ((RNSVGFeGaussianBlurManagerInterface) onLayoutChangeListener).setStdDeviationY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
