package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class DropWhileSequence<T> implements Sequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Sequence f53897a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f53898b;

    @Metadata
    /* renamed from: kotlin.sequences.DropWhileSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f53899a;

        /* renamed from: b, reason: collision with root package name */
        public int f53900b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Object f53901c;

        public AnonymousClass1() {
            this.f53899a = DropWhileSequence.this.f53897a.iterator();
        }

        public final void a() {
            Object next;
            do {
                Iterator it = this.f53899a;
                if (!it.hasNext()) {
                    this.f53900b = 0;
                    return;
                }
                next = it.next();
            } while (((Boolean) DropWhileSequence.this.f53898b.invoke(next)).booleanValue());
            this.f53901c = next;
            this.f53900b = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f53900b == -1) {
                a();
            }
            return this.f53900b == 1 || this.f53899a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f53900b == -1) {
                a();
            }
            if (this.f53900b != 1) {
                return this.f53899a.next();
            }
            Object obj = this.f53901c;
            this.f53901c = null;
            this.f53900b = 0;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DropWhileSequence(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.f53897a = sequence;
        this.f53898b = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
