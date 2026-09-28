package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class TakeWhileSequence<T> implements Sequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 f53936a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f53937b;

    @Metadata
    /* renamed from: kotlin.sequences.TakeWhileSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f53938a;

        /* renamed from: b, reason: collision with root package name */
        public int f53939b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Object f53940c;

        public AnonymousClass1() {
            this.f53938a = TakeWhileSequence.this.f53936a.f53607a.iterator();
        }

        public final void a() {
            Iterator it = this.f53938a;
            if (it.hasNext()) {
                Object next = it.next();
                if (((Boolean) TakeWhileSequence.this.f53937b.invoke(next)).booleanValue()) {
                    this.f53939b = 1;
                    this.f53940c = next;
                    return;
                }
            }
            this.f53939b = 0;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f53939b == -1) {
                a();
            }
            return this.f53939b == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f53939b == -1) {
                a();
            }
            if (this.f53939b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f53940c;
            this.f53940c = null;
            this.f53939b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TakeWhileSequence(CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.f53936a = sequence;
        this.f53937b = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
