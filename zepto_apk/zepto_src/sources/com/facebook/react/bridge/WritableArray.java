package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface WritableArray extends ReadableArray {
    void pushArray(@Nullable ReadableArray readableArray);

    void pushBoolean(boolean z);

    void pushDouble(double d2);

    void pushInt(int i2);

    void pushLong(long j2);

    void pushMap(@Nullable ReadableMap readableMap);

    void pushNull();

    void pushString(@Nullable String str);
}
