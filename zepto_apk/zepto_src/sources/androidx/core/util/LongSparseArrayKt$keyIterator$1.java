package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: classes3.dex */
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2982a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LongSparseArray<Object> f2983b;

    @Override // kotlin.collections.LongIterator
    public final long a() {
        LongSparseArray<Object> longSparseArray = this.f2983b;
        int i2 = this.f2982a;
        this.f2982a = i2 + 1;
        return longSparseArray.keyAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2982a < this.f2983b.size();
    }
}
