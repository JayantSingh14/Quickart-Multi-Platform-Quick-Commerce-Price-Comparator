package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {
    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        throw null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        throw null;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        throw null;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        throw null;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        throw null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        throw null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        throw null;
    }

    @Override // java.util.Map
    public final Set keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.collections.MapWithDefault
    public final Object s0() {
        throw null;
    }

    @Override // java.util.Map
    public final int size() {
        throw null;
    }

    public final String toString() {
        throw null;
    }

    @Override // java.util.Map
    public final Collection values() {
        throw null;
    }
}
