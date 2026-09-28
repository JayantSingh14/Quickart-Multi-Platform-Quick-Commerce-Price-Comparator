package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes.dex */
public interface ModalHostViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAnimated(View view, boolean z);

    void setAnimationType(View view, String str);

    void setHardwareAccelerated(View view, boolean z);

    void setIdentifier(View view, int i2);

    void setNavigationBarTranslucent(View view, boolean z);

    void setPresentationStyle(View view, String str);

    void setStatusBarTranslucent(View view, boolean z);

    void setSupportedOrientations(View view, ReadableArray readableArray);

    void setTransparent(View view, boolean z);

    void setVisible(View view, boolean z);
}
