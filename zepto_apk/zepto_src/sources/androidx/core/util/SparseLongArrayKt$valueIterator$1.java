package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseLongArrayKt$valueIterator$1 extends LongIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3011a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseLongArray f3012b;

    @Override // kotlin.collections.LongIterator
    public final long a() {
        SparseLongArray sparseLongArray = this.f3012b;
        int i2 = this.f3011a;
        this.f3011a = i2 + 1;
        return sparseLongArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3011a < this.f3012b.size();
    }
}
