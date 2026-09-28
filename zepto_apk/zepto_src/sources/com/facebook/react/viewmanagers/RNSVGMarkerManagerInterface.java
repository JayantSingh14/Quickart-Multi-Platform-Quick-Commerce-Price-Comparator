package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes.dex */
public interface RNSVGMarkerManagerInterface<T extends View> {
    void setAlign(View view, String str);

    void setClipPath(View view, String str);

    void setClipRule(View view, int i2);

    void setColor(View view, Integer num);

    void setDisplay(View view, String str);

    void setFill(View view, Dynamic dynamic);

    void setFillOpacity(View view, float f2);

    void setFillRule(View view, int i2);

    void setFilter(View view, String str);

    void setFont(View view, Dynamic dynamic);

    void setFontSize(View view, Dynamic dynamic);

    void setFontWeight(View view, Dynamic dynamic);

    void setMarkerEnd(View view, String str);

    void setMarkerHeight(View view, Dynamic dynamic);

    void setMarkerMid(View view, String str);

    void setMarkerStart(View view, String str);

    void setMarkerUnits(View view, String str);

    void setMarkerWidth(View view, Dynamic dynamic);

    void setMask(View view, String str);

    void setMatrix(View view, ReadableArray readableArray);

    void setMeetOrSlice(View view, int i2);

    void setMinX(View view, float f2);

    void setMinY(View view, float f2);

    void setName(View view, String str);

    void setOrient(View view, String str);

    void setPointerEvents(View view, String str);

    void setPropList(View view, ReadableArray readableArray);

    void setRefX(View view, Dynamic dynamic);

    void setRefY(View view, Dynamic dynamic);

    void setResponsible(View view, boolean z);

    void setStroke(View view, Dynamic dynamic);

    void setStrokeDasharray(View view, Dynamic dynamic);

    void setStrokeDashoffset(View view, float f2);

    void setStrokeLinecap(View view, int i2);

    void setStrokeLinejoin(View view, int i2);

    void setStrokeMiterlimit(View view, float f2);

    void setStrokeOpacity(View view, float f2);

    void setStrokeWidth(View view, Dynamic dynamic);

    void setVbHeight(View view, float f2);

    void setVbWidth(View view, float f2);

    void setVectorEffect(View view, int i2);
}
