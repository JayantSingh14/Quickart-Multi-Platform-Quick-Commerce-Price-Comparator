package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class IndexingSequence<T> implements Sequence<IndexedValue<? extends T>> {

    @Metadata
    /* renamed from: kotlin.sequences.IndexingSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<IndexedValue<Object>>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53918a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final IndexedValue<Object> next() {
            int i2 = this.f53918a;
            this.f53918a = i2 + 1;
            if (i2 >= 0) {
                throw null;
            }
            CollectionsKt.b0();
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        throw null;
    }
}
