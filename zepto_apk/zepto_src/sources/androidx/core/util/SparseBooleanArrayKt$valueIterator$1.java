package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3003a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseBooleanArray f3004b;

    @Override // kotlin.collections.BooleanIterator
    public final boolean a() {
        SparseBooleanArray sparseBooleanArray = this.f3004b;
        int i2 = this.f3003a;
        this.f3003a = i2 + 1;
        return sparseBooleanArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3003a < this.f3004b.size();
    }
}
