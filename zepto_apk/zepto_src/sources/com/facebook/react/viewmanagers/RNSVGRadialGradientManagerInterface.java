package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes.dex */
public interface RNSVGRadialGradientManagerInterface<T extends View> {
    void setClipPath(View view, String str);

    void setClipRule(View view, int i2);

    void setCx(View view, Dynamic dynamic);

    void setCy(View view, Dynamic dynamic);

    void setDisplay(View view, String str);

    void setFx(View view, Dynamic dynamic);

    void setFy(View view, Dynamic dynamic);

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

    void setRx(View view, Dynamic dynamic);

    void setRy(View view, Dynamic dynamic);
}
