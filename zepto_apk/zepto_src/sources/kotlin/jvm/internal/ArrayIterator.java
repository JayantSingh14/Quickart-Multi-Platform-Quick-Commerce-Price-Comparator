package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f53777a;

    /* renamed from: b, reason: collision with root package name */
    public int f53778b;

    public ArrayIterator(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f53777a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53778b < this.f53777a.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.f53777a;
            int i2 = this.f53778b;
            this.f53778b = i2 + 1;
            return objArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53778b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
