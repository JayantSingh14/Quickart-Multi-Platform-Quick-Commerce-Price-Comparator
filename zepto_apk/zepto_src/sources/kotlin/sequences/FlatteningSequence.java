package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class FlatteningSequence<T, R, E> implements Sequence<E> {

    @Metadata
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final State f53911a = new State();
    }

    @Metadata
    /* renamed from: kotlin.sequences.FlatteningSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53912a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i2 = this.f53912a;
            if (i2 == 1) {
                return true;
            }
            if (i2 == 2) {
                return false;
            }
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i2 = this.f53912a;
            if (i2 == 2) {
                throw new NoSuchElementException();
            }
            if (i2 == 0) {
                throw null;
            }
            this.f53912a = 0;
            Intrinsics.c(null);
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
