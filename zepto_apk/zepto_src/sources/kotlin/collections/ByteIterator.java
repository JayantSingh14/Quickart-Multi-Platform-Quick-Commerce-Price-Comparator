package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public abstract class ByteIterator implements Iterator<Byte>, KMappedMarker {
    public abstract byte A();

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(A());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
