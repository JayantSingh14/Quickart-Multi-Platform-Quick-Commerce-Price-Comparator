package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes.dex */
public interface RNSVGFeMergeManagerInterface<T extends View> {
    void setHeight(View view, Dynamic dynamic);

    void setNodes(View view, ReadableArray readableArray);

    void setResult(View view, String str);

    void setWidth(View view, Dynamic dynamic);

    void setX(View view, Dynamic dynamic);

    void setY(View view, Dynamic dynamic);
}
