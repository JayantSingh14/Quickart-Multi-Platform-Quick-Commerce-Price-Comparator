package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class AbstractMap$keys$1$iterator$1 implements Iterator<Object>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f53595a;

    public AbstractMap$keys$1$iterator$1(Iterator it) {
        this.f53595a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53595a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f53595a.next()).getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
