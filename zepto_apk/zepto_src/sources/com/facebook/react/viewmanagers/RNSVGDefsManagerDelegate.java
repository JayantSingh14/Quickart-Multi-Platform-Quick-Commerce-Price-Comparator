package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;

/* loaded from: classes.dex */
public class RNSVGDefsManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGDefsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        BaseViewManager baseViewManager;
        str.getClass();
        baseViewManager = this.f19368a;
        switch (str) {
            case "opacity":
                baseViewManager.setOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case "matrix":
                ((RNSVGDefsManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case "markerEnd":
                ((RNSVGDefsManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case "markerMid":
                ((RNSVGDefsManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case "pointerEvents":
                ((RNSVGDefsManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case "mask":
                ((RNSVGDefsManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case "name":
                ((RNSVGDefsManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case "markerStart":
                ((RNSVGDefsManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case "clipPath":
                ((RNSVGDefsManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case "clipRule":
                ((RNSVGDefsManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "display":
                ((RNSVGDefsManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case "responsible":
                ((RNSVGDefsManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
