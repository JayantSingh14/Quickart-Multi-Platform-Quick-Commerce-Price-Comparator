package okhttp3;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Cache$urls$1 implements Iterator<String>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public boolean f56170a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        this.f56170a = false;
        throw null;
    }

    @Override // java.util.Iterator
    public final String next() {
        this.f56170a = false;
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f56170a) {
            throw new IllegalStateException("remove() before next()");
        }
        throw null;
    }
}
