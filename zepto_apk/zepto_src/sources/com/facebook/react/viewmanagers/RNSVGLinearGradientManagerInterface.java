package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes.dex */
public interface RNSVGLinearGradientManagerInterface<T extends View> {
    void setClipPath(View view, String str);

    void setClipRule(View view, int i2);

    void setDisplay(View view, String str);

    void setGradient(View view, ReadableArray readableArray);

    void setGradientTransform(View view, ReadableArray readableArray);

    void setGradientUnits(View view, int i2);

    void setMarkerEnd(View view, String str);

    void setMarkerMid(View view, String str);

    void setMarkerStart(View view, String str);

    void setMask(View view, String str);

    void setMatrix(View view, ReadableArray readableArray);

    void setName(View view, String str);

    void setPointerEvents(View view, String str);

    void setResponsible(View view, boolean z);

    void setX1(View view, Dynamic dynamic);

    void setX2(View view, Dynamic dynamic);

    void setY1(View view, Dynamic dynamic);

    void setY2(View view, Dynamic dynamic);
}
