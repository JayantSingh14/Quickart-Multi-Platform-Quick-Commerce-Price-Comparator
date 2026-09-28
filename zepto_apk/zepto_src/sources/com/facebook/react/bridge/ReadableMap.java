package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface ReadableMap {
    @Nullable
    ReadableArray getArray(@NotNull String str);

    boolean getBoolean(@NotNull String str);

    double getDouble(@NotNull String str);

    @NotNull
    Dynamic getDynamic(@NotNull String str);

    @NotNull
    Iterator<Map.Entry<String, Object>> getEntryIterator();

    int getInt(@NotNull String str);

    long getLong(@NotNull String str);

    @Nullable
    ReadableMap getMap(@NotNull String str);

    @Nullable
    String getString(@NotNull String str);

    @NotNull
    ReadableType getType(@NotNull String str);

    boolean hasKey(@NotNull String str);

    boolean isNull(@NotNull String str);

    @NotNull
    ReadableMapKeySetIterator keySetIterator();

    @NotNull
    HashMap<String, Object> toHashMap();
}
