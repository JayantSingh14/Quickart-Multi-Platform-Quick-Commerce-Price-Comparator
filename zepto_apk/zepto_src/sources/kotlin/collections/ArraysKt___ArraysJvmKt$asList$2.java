package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {
    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Short)) {
            return false;
        }
        ArraysKt.i(null, ((Number) obj).shortValue());
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i2) {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Short)) {
            return -1;
        }
        ArraysKt.y(null, ((Number) obj).shortValue());
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Short)) {
            return -1;
        }
        ((Number) obj).shortValue();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }
}
