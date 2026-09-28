package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class LongSparseArrayKt$valueIterator$1 implements Iterator<Object>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f2984a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LongSparseArray<Object> f2985b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2984a < this.f2985b.size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        LongSparseArray<Object> longSparseArray = this.f2985b;
        int i2 = this.f2984a;
        this.f2984a = i2 + 1;
        return longSparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
