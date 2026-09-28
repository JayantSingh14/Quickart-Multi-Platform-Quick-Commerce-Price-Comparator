package io.ktor.util.collections;

import io.ktor.http.Url;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
/* loaded from: classes3.dex */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f50527a;

    public ConcurrentMap() {
        this(0);
    }

    public final Object a(Url url, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return this.f50527a.computeIfAbsent(url, new a(new Function1<Object, Object>(block) { // from class: io.ktor.util.collections.ConcurrentMap$computeIfAbsent$1

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Lambda f50528c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.f50528c = (Lambda) block;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f50528c.invoke();
            }
        }, 0));
    }

    @Override // java.util.Map
    public final void clear() {
        this.f50527a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f50527a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f50527a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        Set setEntrySet = this.f50527a.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "delegate.entries");
        return setEntrySet;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return Intrinsics.b(obj, this.f50527a);
        }
        return false;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f50527a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f50527a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f50527a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        Set setKeySet = this.f50527a.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "delegate.keys");
        return setKeySet;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f50527a.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.f50527a.putAll(from);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f50527a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f50527a.size();
    }

    public final String toString() {
        return "ConcurrentMapJvm by " + this.f50527a;
    }

    @Override // java.util.Map
    public final Collection values() {
        Collection collectionValues = this.f50527a.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "delegate.values");
        return collectionValues;
    }

    public ConcurrentMap(int i2) {
        this.f50527a = new ConcurrentHashMap(32);
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        return this.f50527a.remove(obj, obj2);
    }
}
