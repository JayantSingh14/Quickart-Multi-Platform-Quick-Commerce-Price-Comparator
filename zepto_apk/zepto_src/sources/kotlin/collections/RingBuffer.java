package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        return 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i2) {
        AbstractList.f53584a.getClass();
        AbstractList.Companion.b(i2, 0);
        int i3 = i2 % 0;
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AbstractIterator<Object>() { // from class: kotlin.collections.RingBuffer.iterator.1

            /* renamed from: c, reason: collision with root package name */
            public int f53623c;

            /* renamed from: d, reason: collision with root package name */
            public int f53624d;

            {
                RingBuffer.this.getClass();
                this.f53623c = 0;
                this.f53624d = 0;
            }

            @Override // kotlin.collections.AbstractIterator
            public final void a() {
                if (this.f53623c != 0) {
                    throw null;
                }
                this.f53582a = 2;
            }
        };
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[b()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < 0) {
            array = Arrays.copyOf(array, 0);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        }
        CollectionsKt.a0(0, array);
        return array;
    }
}
