package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public final class FilteringSequence<T> implements Sequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Sequence f53904a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f53905b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f53906c;

    @Metadata
    /* renamed from: kotlin.sequences.FilteringSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f53907a;

        /* renamed from: b, reason: collision with root package name */
        public int f53908b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Object f53909c;

        public AnonymousClass1() {
            this.f53907a = FilteringSequence.this.f53904a.iterator();
        }

        public final void a() {
            Object next;
            FilteringSequence filteringSequence;
            do {
                Iterator it = this.f53907a;
                if (!it.hasNext()) {
                    this.f53908b = 0;
                    return;
                } else {
                    next = it.next();
                    filteringSequence = FilteringSequence.this;
                }
            } while (((Boolean) filteringSequence.f53906c.invoke(next)).booleanValue() != filteringSequence.f53905b);
            this.f53909c = next;
            this.f53908b = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f53908b == -1) {
                a();
            }
            return this.f53908b == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f53908b == -1) {
                a();
            }
            if (this.f53908b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f53909c;
            this.f53909c = null;
            this.f53908b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public FilteringSequence(Sequence sequence, boolean z, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.f53904a = sequence;
        this.f53905b = z;
        this.f53906c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
