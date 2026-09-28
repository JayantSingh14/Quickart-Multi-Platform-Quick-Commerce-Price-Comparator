package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public abstract class DoubleIterator implements Iterator<Double>, KMappedMarker {
    public abstract double a();

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Double next() {
        return Double.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
