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
public final class UShortArray implements Collection<UShort>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final short[] f53569a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final short[] f53570a;

        /* renamed from: b, reason: collision with root package name */
        public int f53571b;

        public Iterator(short[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f53570a = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53571b < this.f53570a.length;
        }

        @Override // java.util.Iterator
        public final UShort next() {
            int i2 = this.f53571b;
            short[] sArr = this.f53570a;
            if (i2 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f53571b));
            }
            this.f53571b = i2 + 1;
            return new UShort(sArr[i2]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return ArraysKt.i(this.f53569a, ((UShort) obj).f53568a);
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
            if (obj instanceof UShort) {
                if (ArraysKt.i(this.f53569a, ((UShort) obj).f53568a)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof UShortArray) {
            return Intrinsics.b(this.f53569a, ((UShortArray) obj).f53569a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f53569a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f53569a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator(this.f53569a);
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
        return this.f53569a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "UShortArray(storage=" + Arrays.toString(this.f53569a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
