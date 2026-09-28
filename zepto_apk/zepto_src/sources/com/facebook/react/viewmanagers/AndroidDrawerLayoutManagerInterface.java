package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes.dex */
public interface AndroidDrawerLayoutManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void closeDrawer(View view);

    void openDrawer(View view);

    void setDrawerBackgroundColor(View view, Integer num);

    void setDrawerLockMode(View view, String str);

    void setDrawerPosition(View view, String str);

    void setDrawerWidth(View view, Float f2);

    void setKeyboardDismissMode(View view, String str);

    void setStatusBarBackgroundColor(View view, Integer num);
}
