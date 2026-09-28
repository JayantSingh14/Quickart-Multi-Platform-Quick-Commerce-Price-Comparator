package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes4.dex */
public abstract class zzgtg<K, V> implements Map<K, V>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzgtn f33190a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzgtn f33191b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzgsz f33192c;

    public static zzgtg a(Map map) {
        if ((map instanceof zzgtg) && !(map instanceof SortedMap)) {
            zzgtg zzgtgVar = (zzgtg) map;
            zzgtgVar.getClass();
            return zzgtgVar;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        zzgtf zzgtfVar = new zzgtf(setEntrySet != null ? setEntrySet.size() : 4);
        zzgtfVar.b(setEntrySet);
        return zzgtfVar.d(true);
    }

    public abstract zzgtn b();

    public abstract zzgtn c();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        zzgsz zzgszVarD = this.f33192c;
        if (zzgszVarD == null) {
            zzgszVarD = d();
            this.f33192c = zzgszVarD;
        }
        return zzgszVarD.contains(obj);
    }

    public abstract zzgsz d();

    @Override // java.util.Map
    public final Set entrySet() {
        zzgtn zzgtnVar = this.f33190a;
        if (zzgtnVar != null) {
            return zzgtnVar;
        }
        zzgtn zzgtnVarB = b();
        this.f33190a = zzgtnVarB;
        return zzgtnVarB;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return zzguk.a(obj, this);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        zzgtn zzgtnVarB = this.f33190a;
        if (zzgtnVarB == null) {
            zzgtnVarB = b();
            this.f33190a = zzgtnVarB;
        }
        return zzgvn.c(zzgtnVarB);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        zzgtn zzgtnVar = this.f33191b;
        if (zzgtnVar != null) {
            return zzgtnVar;
        }
        zzgtn zzgtnVarC = c();
        this.f33191b = zzgtnVarC;
        return zzgtnVarC;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzgrz.b(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        zzgsz zzgszVar = this.f33192c;
        if (zzgszVar != null) {
            return zzgszVar;
        }
        zzgsz zzgszVarD = d();
        this.f33192c = zzgszVarD;
        return zzgszVarD;
    }
}
