package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes.dex */
public interface AndroidSwipeRefreshLayoutManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setColors(View view, ReadableArray readableArray);

    void setEnabled(View view, boolean z);

    void setNativeRefreshing(View view, boolean z);

    void setProgressBackgroundColor(View view, Integer num);

    void setProgressViewOffset(View view, float f2);

    void setRefreshing(View view, boolean z);

    void setSize(View view, String str);
}
