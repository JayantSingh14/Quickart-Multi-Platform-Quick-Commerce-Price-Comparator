package io.ktor.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f50438a = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.f50438a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f50438a.containsKey(new CaseInsensitiveString(key));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f50438a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new DelegatingMutableSet(this.f50438a.entrySet(), CaseInsensitiveMap$entries$1.f50439c, CaseInsensitiveMap$entries$2.f50440c);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CaseInsensitiveMap)) {
            return false;
        }
        return Intrinsics.b(((CaseInsensitiveMap) obj).f50438a, this.f50438a);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f50438a.get(TextKt.a(key));
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f50438a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f50438a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return new DelegatingMutableSet(this.f50438a.keySet(), CaseInsensitiveMap$keys$1.f50441c, CaseInsensitiveMap$keys$2.f50442c);
    }

    @Override // java.util.Map
    public final Object put(String str, Object value) {
        String key = str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.f50438a.put(TextKt.a(key), value);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry entry : from.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f50438a.put(TextKt.a(key), value);
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f50438a.remove(TextKt.a(key));
    }

    @Override // java.util.Map
    public final int size() {
        return this.f50438a.size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f50438a.values();
    }
}
