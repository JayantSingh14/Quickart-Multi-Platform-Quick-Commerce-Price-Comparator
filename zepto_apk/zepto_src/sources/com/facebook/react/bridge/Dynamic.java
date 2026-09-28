package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface Dynamic {
    @NotNull
    ReadableArray asArray();

    boolean asBoolean();

    double asDouble();

    int asInt();

    @NotNull
    ReadableMap asMap();

    @NotNull
    String asString();

    @NotNull
    ReadableType getType();

    boolean isNull();

    void recycle();
}
