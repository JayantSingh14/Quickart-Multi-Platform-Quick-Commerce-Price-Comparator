package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
final class JsonIteratorArrayWrapped<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public boolean f56043a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f56044b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f56044b) {
            return false;
        }
        throw null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f56043a) {
            throw null;
        }
        this.f56043a = false;
        WriteMode writeMode = WriteMode.f56108c;
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
