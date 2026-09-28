package com.facebook.react.bridge;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
/* loaded from: classes.dex */
public final class ReadableNativeMap$entryIterator$1$1$next$1 implements Map.Entry<String, Object>, KMutableMap.Entry {
    final /* synthetic */ int $index;
    final /* synthetic */ String[] $iteratorKeys;
    final /* synthetic */ Object[] $iteratorValues;

    public ReadableNativeMap$entryIterator$1$1$next$1(String[] strArr, int i2, Object[] objArr) {
        this.$iteratorKeys = strArr;
        this.$index = i2;
        this.$iteratorValues = objArr;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.$iteratorValues[this.$index];
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        throw new UnsupportedOperationException("Can't set a value while iterating over a ReadableNativeMap");
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.$iteratorKeys[this.$index];
    }
}
