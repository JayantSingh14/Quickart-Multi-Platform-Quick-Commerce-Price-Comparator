package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: classes3.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator<Object>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f1530a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f1531b = SequencesKt.l(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this, null));

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1531b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f1531b.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f1530a != -1) {
            throw null;
        }
    }
}
