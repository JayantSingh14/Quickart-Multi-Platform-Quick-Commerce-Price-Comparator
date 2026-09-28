package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;

/* loaded from: classes.dex */
public class AndroidProgressBarManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & AndroidProgressBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "progress":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setProgress(view, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case "testID":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setTestID(view, obj == null ? "" : (String) obj);
                break;
            case "typeAttr":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setTypeAttr(view, obj != null ? (String) obj : null);
                break;
            case "color":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "indeterminate":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setIndeterminate(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "animating":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setAnimating(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "styleAttr":
                ((AndroidProgressBarManagerInterface) onLayoutChangeListener).setStyleAttr(view, obj != null ? (String) obj : null);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
