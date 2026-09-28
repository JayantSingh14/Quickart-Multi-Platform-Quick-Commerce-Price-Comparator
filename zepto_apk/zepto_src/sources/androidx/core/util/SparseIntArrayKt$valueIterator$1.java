package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseIntArrayKt$valueIterator$1 extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3007a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseIntArray f3008b;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        SparseIntArray sparseIntArray = this.f3008b;
        int i2 = this.f3007a;
        this.f3007a = i2 + 1;
        return sparseIntArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3007a < this.f3008b.size();
    }
}
