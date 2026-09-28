package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class SparseArrayKt$valueIterator$1 implements Iterator<Object>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f2999a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseArray<Object> f3000b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2999a < this.f3000b.size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        SparseArray<Object> sparseArray = this.f3000b;
        int i2 = this.f2999a;
        this.f2999a = i2 + 1;
        return sparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
