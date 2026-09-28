package kotlin.collections;

import com.brentvatne.react.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Companion f53591c = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public volatile AbstractMap$keys$1 f53592a;

    /* renamed from: b, reason: collision with root package name */
    public volatile AnonymousClass1 f53593b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public abstract Set a();

    public final Map.Entry b(Object obj) {
        Object next;
        Iterator it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.b(((Map.Entry) next).getKey(), obj)) {
                break;
            }
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Set setA = a();
        if (setA != null && setA.isEmpty()) {
            return false;
        }
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return a();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if (setEntrySet != null && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                V v = get(key);
                if (Intrinsics.b(value, v) && (v != null || containsKey(key))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        Map.Entry entryB = b(obj);
        if (entryB != null) {
            return entryB.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.AbstractMap$keys$1] */
    @Override // java.util.Map
    public final Set keySet() {
        if (this.f53592a == null) {
            this.f53592a = new AbstractSet<Object>() { // from class: kotlin.collections.AbstractMap$keys$1
                @Override // kotlin.collections.AbstractCollection
                public final int b() {
                    return this.f53594b.size();
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final boolean contains(Object obj) {
                    return this.f53594b.containsKey(obj);
                }

                @Override // kotlin.collections.AbstractSet, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    return new AbstractMap$keys$1$iterator$1(this.f53594b.a().iterator());
                }
            };
        }
        AbstractMap$keys$1 abstractMap$keys$1 = this.f53592a;
        Intrinsics.c(abstractMap$keys$1);
        return abstractMap$keys$1;
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

    @Override // java.util.Map
    public final int size() {
        return a().size();
    }

    public final String toString() {
        return CollectionsKt.E(a(), ", ", "{", "}", new c(this, 8), 24);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.AbstractMap$values$1] */
    @Override // java.util.Map
    public final Collection values() {
        if (this.f53593b == null) {
            this.f53593b = new AbstractCollection<Object>() { // from class: kotlin.collections.AbstractMap.values.1
                @Override // kotlin.collections.AbstractCollection
                public final int b() {
                    return AbstractMap.this.size();
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final boolean contains(Object obj) {
                    return AbstractMap.this.containsValue(obj);
                }

                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator iterator() {
                    return new AbstractMap$values$1$iterator$1(AbstractMap.this.a().iterator());
                }
            };
        }
        AnonymousClass1 anonymousClass1 = this.f53593b;
        Intrinsics.c(anonymousClass1);
        return anonymousClass1;
    }
}
