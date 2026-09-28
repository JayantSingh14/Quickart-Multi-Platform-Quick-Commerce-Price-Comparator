package androidx.core.util;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2997a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseArray<Object> f2998b;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        SparseArray<Object> sparseArray = this.f2998b;
        int i2 = this.f2997a;
        this.f2997a = i2 + 1;
        return sparseArray.keyAt(i2);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2997a < this.f2998b.size();
    }
}
