package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.AndroidHorizontalScrollContentViewManagerInterface;

/* loaded from: classes3.dex */
public class AndroidHorizontalScrollContentViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & AndroidHorizontalScrollContentViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("removeClippedSubviews")) {
            ((AndroidHorizontalScrollContentViewManagerInterface) this.f19368a).setRemoveClippedSubviews(view, obj == null ? false : ((Boolean) obj).booleanValue());
        } else {
            super.a(view, str, obj);
        }
    }
}
