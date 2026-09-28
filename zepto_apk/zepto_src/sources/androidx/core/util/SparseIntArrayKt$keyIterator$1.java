package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseIntArrayKt$keyIterator$1 extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3005a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseIntArray f3006b;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        SparseIntArray sparseIntArray = this.f3006b;
        int i2 = this.f3005a;
        this.f3005a = i2 + 1;
        return sparseIntArray.keyAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3005a < this.f3006b.size();
    }
}
