package com.facebook.react.bridge;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public final class ReadableNativeMap$entryIterator$1$1 implements Iterator<Map.Entry<? extends String, ? extends Object>>, KMappedMarker {
    final /* synthetic */ String[] $iteratorKeys;
    final /* synthetic */ Object[] $iteratorValues;
    private int currentIndex;

    public ReadableNativeMap$entryIterator$1$1(String[] strArr, Object[] objArr) {
        this.$iteratorKeys = strArr;
        this.$iteratorValues = objArr;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex < this.$iteratorKeys.length;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCurrentIndex(int i2) {
        this.currentIndex = i2;
    }

    @Override // java.util.Iterator
    public Map.Entry<? extends String, ? extends Object> next() {
        int i2 = this.currentIndex;
        this.currentIndex = i2 + 1;
        return new ReadableNativeMap$entryIterator$1$1$next$1(this.$iteratorKeys, i2, this.$iteratorValues);
    }
}
