package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: classes3.dex */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1 implements Iterator<Object>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f1510a = SequencesKt.l(new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(2, null));

    /* renamed from: b, reason: collision with root package name */
    public int f1511b = -1;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1510a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f1511b = ((Number) this.f1510a.next()).intValue();
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f1511b >= 0) {
            throw null;
        }
    }
}
