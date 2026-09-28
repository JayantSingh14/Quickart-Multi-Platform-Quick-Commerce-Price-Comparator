package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f53615a;

    /* renamed from: b, reason: collision with root package name */
    public int f53616b;

    public IndexingIterator(Iterator iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.f53615a = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53615a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f53616b;
        this.f53616b = i2 + 1;
        if (i2 >= 0) {
            return new IndexedValue(i2, this.f53615a.next());
        }
        CollectionsKt.b0();
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
