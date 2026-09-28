package com.facebook.react.bridge;

import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStripAny;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes.dex */
final class DynamicNative extends HybridClassBase implements Dynamic {
    private final native ReadableType getTypeNative();

    private final native boolean isNullNative();

    @Override // com.facebook.react.bridge.Dynamic
    @NotNull
    public native ReadableArray asArray();

    @Override // com.facebook.react.bridge.Dynamic
    public native boolean asBoolean();

    @Override // com.facebook.react.bridge.Dynamic
    public native double asDouble();

    @Override // com.facebook.react.bridge.Dynamic
    public int asInt() {
        return (int) asDouble();
    }

    @Override // com.facebook.react.bridge.Dynamic
    @NotNull
    public native ReadableMap asMap();

    @Override // com.facebook.react.bridge.Dynamic
    @NotNull
    public native String asString();

    @Override // com.facebook.react.bridge.Dynamic
    @NotNull
    public ReadableType getType() {
        return getTypeNative();
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean isNull() {
        return isNullNative();
    }

    @Override // com.facebook.react.bridge.Dynamic
    public void recycle() {
    }
}
