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
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f53563a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f53564a;

        /* renamed from: b, reason: collision with root package name */
        public int f53565b;

        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f53564a = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53565b < this.f53564a.length;
        }

        @Override // java.util.Iterator
        public final ULong next() {
            int i2 = this.f53565b;
            long[] jArr = this.f53564a;
            if (i2 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f53565b));
            }
            this.f53565b = i2 + 1;
            return new ULong(jArr[i2]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return ArraysKt.g(this.f53563a, ((ULong) obj).f53562a);
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
            if (obj instanceof ULong) {
                if (ArraysKt.g(this.f53563a, ((ULong) obj).f53562a)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof ULongArray) {
            return Intrinsics.b(this.f53563a, ((ULongArray) obj).f53563a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f53563a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f53563a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator(this.f53563a);
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
        return this.f53563a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(this.f53563a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
