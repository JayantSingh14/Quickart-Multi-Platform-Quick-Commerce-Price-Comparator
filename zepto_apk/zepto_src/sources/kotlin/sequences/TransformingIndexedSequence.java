package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {

    @Metadata
    /* renamed from: kotlin.sequences.TransformingIndexedSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53942a;

        public AnonymousClass1() {
            TransformingIndexedSequence.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            TransformingIndexedSequence.this.getClass();
            int i2 = this.f53942a;
            this.f53942a = i2 + 1;
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
        new AnonymousClass1();
        throw null;
    }
}
