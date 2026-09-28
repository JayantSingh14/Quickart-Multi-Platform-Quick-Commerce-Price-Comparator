package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
/* loaded from: classes.dex */
final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f50482a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50483b;

    public Entry(Object obj, Object obj2) {
        this.f50482a = obj;
        this.f50483b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Map.Entry)) {
            Map.Entry entry = (Map.Entry) obj;
            if (Intrinsics.b(entry.getKey(), this.f50482a) && Intrinsics.b(entry.getValue(), this.f50483b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f50482a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f50483b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f50482a;
        Intrinsics.c(obj);
        int iHashCode = obj.hashCode() + 527;
        Object obj2 = this.f50483b;
        Intrinsics.c(obj2);
        return obj2.hashCode() + iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f50483b = obj;
        return obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f50482a);
        sb.append('=');
        sb.append(this.f50483b);
        return sb.toString();
    }
}
