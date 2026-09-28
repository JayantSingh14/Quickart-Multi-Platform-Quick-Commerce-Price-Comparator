package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Sequence f53933a;

    @Metadata
    /* renamed from: kotlin.sequences.TakeSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53934a;

        /* renamed from: b, reason: collision with root package name */
        public final Iterator f53935b;

        public AnonymousClass1(TakeSequence takeSequence) {
            takeSequence.getClass();
            this.f53934a = 16;
            this.f53935b = takeSequence.f53933a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53934a > 0 && this.f53935b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i2 = this.f53934a;
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            this.f53934a = i2 - 1;
            return this.f53935b.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TakeSequence(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f53933a = sequence;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int i2) {
        return i2 >= 16 ? EmptySequence.f53903a : new SubSequence(this.f53933a, i2, 16);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take() {
        return this;
    }
}
