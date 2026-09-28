package com.facebook.react.bridge;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface ReadableArray {
    @Nullable
    ReadableArray getArray(int i2);

    boolean getBoolean(int i2);

    double getDouble(int i2);

    @NotNull
    Dynamic getDynamic(int i2);

    int getInt(int i2);

    long getLong(int i2);

    @Nullable
    ReadableMap getMap(int i2);

    @Nullable
    String getString(int i2);

    @NotNull
    ReadableType getType(int i2);

    boolean isNull(int i2);

    int size();

    @NotNull
    ArrayList<Object> toArrayList();
}
