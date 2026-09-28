package androidx.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1487a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1488b;

    public MapEntry(Object obj, Object obj2) {
        this.f1487a = obj;
        this.f1488b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1487a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1488b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
