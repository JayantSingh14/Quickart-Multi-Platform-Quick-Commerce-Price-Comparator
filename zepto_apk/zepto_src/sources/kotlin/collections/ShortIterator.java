package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public abstract class ShortIterator implements Iterator<Short>, KMappedMarker {
    public abstract short a();

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
