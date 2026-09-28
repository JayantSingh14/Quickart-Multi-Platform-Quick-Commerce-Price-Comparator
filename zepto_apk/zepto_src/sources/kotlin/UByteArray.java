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
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f53553a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f53554a;

        /* renamed from: b, reason: collision with root package name */
        public int f53555b;

        public Iterator(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f53554a = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53555b < this.f53554a.length;
        }

        @Override // java.util.Iterator
        public final UByte next() {
            int i2 = this.f53555b;
            byte[] bArr = this.f53554a;
            if (i2 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f53555b));
            }
            this.f53555b = i2 + 1;
            return new UByte(bArr[i2]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return ArraysKt.d(this.f53553a, ((UByte) obj).f53552a);
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
            if (obj instanceof UByte) {
                if (ArraysKt.d(this.f53553a, ((UByte) obj).f53552a)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof UByteArray) {
            return Intrinsics.b(this.f53553a, ((UByteArray) obj).f53553a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f53553a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f53553a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator(this.f53553a);
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
        return this.f53553a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "UByteArray(storage=" + Arrays.toString(this.f53553a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
