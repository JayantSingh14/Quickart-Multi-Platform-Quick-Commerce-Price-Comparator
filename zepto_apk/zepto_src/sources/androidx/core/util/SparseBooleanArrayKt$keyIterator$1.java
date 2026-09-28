package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseBooleanArrayKt$keyIterator$1 extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseBooleanArray f3002b;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        SparseBooleanArray sparseBooleanArray = this.f3002b;
        int i2 = this.f3001a;
        this.f3001a = i2 + 1;
        return sparseBooleanArray.keyAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3001a < this.f3002b.size();
    }
}
