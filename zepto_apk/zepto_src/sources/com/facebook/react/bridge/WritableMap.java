package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface WritableMap extends ReadableMap {
    @NotNull
    WritableMap copy();

    void merge(@NotNull ReadableMap readableMap);

    void putArray(@NotNull String str, @Nullable ReadableArray readableArray);

    void putBoolean(@NotNull String str, boolean z);

    void putDouble(@NotNull String str, double d2);

    void putInt(@NotNull String str, int i2);

    void putLong(@NotNull String str, long j2);

    void putMap(@NotNull String str, @Nullable ReadableMap readableMap);

    void putNull(@NotNull String str);

    void putString(@NotNull String str, @Nullable String str2);
}
