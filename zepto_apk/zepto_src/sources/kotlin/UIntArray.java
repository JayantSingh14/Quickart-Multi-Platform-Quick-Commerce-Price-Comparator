package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@SinceKotlin
@Metadata
@ExperimentalUnsignedTypes
@JvmInline
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f53558a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f53559a;

        /* renamed from: b, reason: collision with root package name */
        public int f53560b;

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f53559a = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53560b < this.f53559a.length;
        }

        @Override // java.util.Iterator
        public final UInt next() {
            int i2 = this.f53560b;
            int[] iArr = this.f53559a;
            if (i2 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f53560b));
            }
            this.f53560b = i2 + 1;
            return new UInt(iArr[i2]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return ArraysKt.f(this.f53558a, ((UInt) obj).f53557a);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof UInt) {
                if (ArraysKt.f(this.f53558a, ((UInt) obj).f53557a)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof UIntArray) {
            return Intrinsics.b(this.f53558a, ((UIntArray) obj).f53558a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f53558a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f53558a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator(this.f53558a);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f53558a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.f53558a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
