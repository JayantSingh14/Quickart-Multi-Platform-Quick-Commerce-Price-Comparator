package com.facebook.react.views.text;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

/* loaded from: classes.dex */
public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    public String y = null;

    @ReactProp(name = "text")
    public void setText(@Nullable String str) {
        this.y = str;
        c0();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f19457b;
        Assertions.c(str);
        sb.append(str);
        sb.append(" [text: ");
        return b.r(sb, this.y, "]");
    }
}
