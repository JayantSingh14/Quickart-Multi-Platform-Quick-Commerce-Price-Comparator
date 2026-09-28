package okhttp3.internal.cache;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, KMutableIterator {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }

    @Override // java.util.Iterator
    public final DiskLruCache.Snapshot next() {
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new IllegalStateException("remove() before next()");
    }
}
