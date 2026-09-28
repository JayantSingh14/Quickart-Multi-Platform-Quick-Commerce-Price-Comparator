package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;

/* loaded from: classes.dex */
public interface RNSVGFilterManagerInterface<T extends View> {
    void setFilterUnits(View view, String str);

    void setHeight(View view, Dynamic dynamic);

    void setName(View view, String str);

    void setPrimitiveUnits(View view, String str);

    void setWidth(View view, Dynamic dynamic);

    void setX(View view, Dynamic dynamic);

    void setY(View view, Dynamic dynamic);
}
