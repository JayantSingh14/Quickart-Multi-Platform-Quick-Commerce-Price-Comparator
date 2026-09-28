package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class UnimplementedNativeViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & UnimplementedNativeViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
            ((UnimplementedNativeViewManagerInterface) this.f19368a).setName(view, obj == null ? "" : (String) obj);
        } else {
            super.a(view, str, obj);
        }
    }
}
