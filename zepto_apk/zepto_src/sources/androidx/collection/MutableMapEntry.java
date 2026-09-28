package androidx.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
/* loaded from: classes3.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1489a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1490b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1491c;

    public MutableMapEntry(int i2, Object[] keys, Object[] values) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f1489a = keys;
        this.f1490b = values;
        this.f1491c = i2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1489a[this.f1491c];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1490b[this.f1491c];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object[] objArr = this.f1490b;
        int i2 = this.f1491c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }
}
