package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SerializationUtilsKt {
    public static final WritableMap a(EdgeInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("top", PixelUtil.a(insets.f47154a));
        writableMapCreateMap.putDouble("right", PixelUtil.a(insets.f47155b));
        writableMapCreateMap.putDouble("bottom", PixelUtil.a(insets.f47156c));
        writableMapCreateMap.putDouble("left", PixelUtil.a(insets.f47157d));
        return writableMapCreateMap;
    }
}
