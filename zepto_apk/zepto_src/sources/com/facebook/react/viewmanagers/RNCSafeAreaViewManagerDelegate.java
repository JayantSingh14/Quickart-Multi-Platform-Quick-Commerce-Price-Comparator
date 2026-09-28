package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCSafeAreaViewManagerInterface;

/* loaded from: classes3.dex */
public class RNCSafeAreaViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCSafeAreaViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        View.OnLayoutChangeListener onLayoutChangeListener = this.f19368a;
        if (str.equals("mode")) {
            ((RNCSafeAreaViewManagerInterface) onLayoutChangeListener).b();
        } else if (!str.equals("edges")) {
            super.a(view, str, obj);
        } else {
            ((RNCSafeAreaViewManagerInterface) onLayoutChangeListener).a();
        }
    }
}
