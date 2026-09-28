package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final RegionIterator f2819a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f2820b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2821c;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2821c;
    }

    @Override // java.util.Iterator
    public final Rect next() {
        if (!this.f2821c) {
            throw new IndexOutOfBoundsException();
        }
        Rect rect = new Rect(this.f2820b);
        this.f2821c = this.f2819a.next(this.f2820b);
        return rect;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
