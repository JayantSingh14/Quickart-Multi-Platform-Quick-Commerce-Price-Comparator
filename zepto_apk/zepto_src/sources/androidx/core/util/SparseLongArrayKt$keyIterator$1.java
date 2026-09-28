package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseLongArrayKt$keyIterator$1 extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3009a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseLongArray f3010b;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        SparseLongArray sparseLongArray = this.f3010b;
        int i2 = this.f3009a;
        this.f3009a = i2 + 1;
        return sparseLongArray.keyAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3009a < this.f3010b.size();
    }
}
