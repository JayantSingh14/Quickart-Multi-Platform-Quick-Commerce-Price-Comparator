package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    public WritableNativeArray() {
        initHybrid();
    }

    private final native void initHybrid();

    private final native void pushNativeArray(ReadableNativeArray readableNativeArray);

    private final native void pushNativeMap(ReadableNativeMap readableNativeMap);

    @Override // com.facebook.react.bridge.WritableArray
    public void pushArray(@Nullable ReadableArray readableArray) {
        if (readableArray != null && !(readableArray instanceof ReadableNativeArray)) {
            throw new IllegalStateException("Illegal type provided");
        }
        pushNativeArray((ReadableNativeArray) readableArray);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushBoolean(boolean z);

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushDouble(double d2);

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushInt(int i2);

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushLong(long j2);

    @Override // com.facebook.react.bridge.WritableArray
    public void pushMap(@Nullable ReadableMap readableMap) {
        if (readableMap != null && !(readableMap instanceof ReadableNativeMap)) {
            throw new IllegalStateException("Illegal type provided");
        }
        pushNativeMap((ReadableNativeMap) readableMap);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushNull();

    @Override // com.facebook.react.bridge.WritableArray
    public native void pushString(@Nullable String str);
}
