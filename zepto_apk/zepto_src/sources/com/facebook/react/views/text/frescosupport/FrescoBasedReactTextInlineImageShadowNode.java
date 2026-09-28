package com.facebook.react.views.text.frescosupport;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.internal.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import java.util.Locale;

/* loaded from: classes.dex */
class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode {
    public ReadableMap A;
    public final AbstractDraweeControllerBuilder B;
    public final Object C;
    public String E;
    public Uri z;
    public float D = Float.NaN;
    public float F = Float.NaN;
    public int G = 0;

    public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.B = abstractDraweeControllerBuilder;
        this.C = obj;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final boolean J() {
        return true;
    }

    @Override // com.facebook.react.views.text.internal.ReactTextInlineImageShadowNode
    public final TextInlineImageSpan n0() {
        ThemedReactContext themedReactContext = this.f19459d;
        Assertions.c(themedReactContext);
        return new FrescoBasedReactTextInlineImageSpan(themedReactContext.getResources(), (int) Math.ceil(this.F), (int) Math.ceil(this.D), this.G, this.z, this.A, this.B, this.C, this.E);
    }

    @ReactProp(name = "headers")
    public void setHeaders(ReadableMap readableMap) {
        this.A = readableMap;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public final void setHeight(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.F = (float) dynamic.asDouble();
        } else {
            FLog.q("ReactNative", "Inline images must not have percentage based height");
            this.F = Float.NaN;
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(@Nullable String str) {
        this.E = str;
    }

    @ReactProp(name = "src")
    public void setSource(@Nullable ReadableArray readableArray) {
        Uri uri;
        Uri uriBuild = null;
        String string = (readableArray == null || readableArray.size() == 0) ? null : readableArray.getMap(0).getString("uri");
        if (string != null) {
            try {
                uri = Uri.parse(string);
            } catch (Exception unused) {
            }
            if (uri.getScheme() == null) {
                uri = null;
            }
            if (uri == null) {
                ThemedReactContext themedReactContext = this.f19459d;
                Assertions.c(themedReactContext);
                if (!string.isEmpty()) {
                    uriBuild = new Uri.Builder().scheme("res").path(String.valueOf(themedReactContext.getResources().getIdentifier(string.toLowerCase(Locale.getDefault()).replace("-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX), "drawable", themedReactContext.getPackageName()))).build();
                }
            } else {
                uriBuild = uri;
            }
        }
        if (uriBuild != this.z) {
            c0();
        }
        this.z = uriBuild;
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(int i2) {
        this.G = i2;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public final void setWidth(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.D = (float) dynamic.asDouble();
        } else {
            FLog.q("ReactNative", "Inline images must not have percentage based width");
            this.D = Float.NaN;
        }
    }
}
