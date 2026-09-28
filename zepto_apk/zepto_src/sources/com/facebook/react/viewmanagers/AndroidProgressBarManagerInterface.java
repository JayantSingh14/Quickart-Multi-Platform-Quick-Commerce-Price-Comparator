package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes.dex */
public interface AndroidProgressBarManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAnimating(View view, boolean z);

    void setColor(View view, Integer num);

    void setIndeterminate(View view, boolean z);

    void setProgress(View view, double d2);

    void setStyleAttr(View view, String str);

    void setTestID(View view, String str);

    void setTypeAttr(View view, String str);
}
