package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

/* loaded from: classes.dex */
public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        BaseViewManager baseViewManager;
        str.getClass();
        baseViewManager = this.f19368a;
        switch (str) {
            case "presentationStyle":
                ((ModalHostViewManagerInterface) baseViewManager).setPresentationStyle(view, (String) obj);
                break;
            case "supportedOrientations":
                ((ModalHostViewManagerInterface) baseViewManager).setSupportedOrientations(view, (ReadableArray) obj);
                break;
            case "transparent":
                ((ModalHostViewManagerInterface) baseViewManager).setTransparent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "identifier":
                ((ModalHostViewManagerInterface) baseViewManager).setIdentifier(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "statusBarTranslucent":
                ((ModalHostViewManagerInterface) baseViewManager).setStatusBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "animated":
                ((ModalHostViewManagerInterface) baseViewManager).setAnimated(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "visible":
                ((ModalHostViewManagerInterface) baseViewManager).setVisible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "navigationBarTranslucent":
                ((ModalHostViewManagerInterface) baseViewManager).setNavigationBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "hardwareAccelerated":
                ((ModalHostViewManagerInterface) baseViewManager).setHardwareAccelerated(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "animationType":
                ((ModalHostViewManagerInterface) baseViewManager).setAnimationType(view, (String) obj);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
