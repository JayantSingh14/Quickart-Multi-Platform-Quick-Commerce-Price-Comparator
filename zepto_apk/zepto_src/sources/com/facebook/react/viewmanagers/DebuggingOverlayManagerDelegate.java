package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface;

/* loaded from: classes3.dex */
public class DebuggingOverlayManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & DebuggingOverlayManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void b(View view, String str, ReadableArray readableArray) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "clearElementsHighlights":
                ((DebuggingOverlayManagerInterface) onLayoutChangeListener).clearElementsHighlights(view);
                break;
            case "highlightTraceUpdates":
                ((DebuggingOverlayManagerInterface) onLayoutChangeListener).highlightTraceUpdates(view, readableArray.getArray(0));
                break;
            case "highlightElements":
                ((DebuggingOverlayManagerInterface) onLayoutChangeListener).highlightElements(view, readableArray.getArray(0));
                break;
        }
    }
}
