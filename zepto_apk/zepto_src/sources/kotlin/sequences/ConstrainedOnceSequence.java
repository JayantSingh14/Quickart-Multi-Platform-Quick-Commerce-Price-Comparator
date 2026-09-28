package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f53892a;

    public ConstrainedOnceSequence(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f53892a = new AtomicReference(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Sequence sequence = (Sequence) this.f53892a.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
