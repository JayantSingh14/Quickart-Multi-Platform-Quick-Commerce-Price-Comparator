package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes.dex */
public interface RNGestureHandlerButtonManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setBorderColor(View view, Integer num);

    void setBorderStyle(View view, String str);

    void setBorderWidth(View view, float f2);

    void setBorderless(View view, boolean z);

    void setEnabled(View view, boolean z);

    void setExclusive(View view, boolean z);

    void setForeground(View view, boolean z);

    void setRippleColor(View view, Integer num);

    void setRippleRadius(View view, int i2);

    void setTouchSoundDisabled(View view, boolean z);
}
