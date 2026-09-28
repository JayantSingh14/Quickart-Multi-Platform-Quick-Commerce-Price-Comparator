package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes4.dex */
class zzgrg extends zzguj {

    /* renamed from: d, reason: collision with root package name */
    public final transient Map f33102d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgut f33103e;

    public zzgrg(zzgut zzgutVar, Map map) {
        Objects.requireNonNull(zzgutVar);
        this.f33103e = zzgutVar;
        this.f33102d = map;
    }

    @Override // com.google.android.gms.internal.ads.zzguj
    public final Set a() {
        return new zzgre(this);
    }

    public final AbstractMap.SimpleImmutableEntry c(Map.Entry entry) {
        Object key = entry.getKey();
        return new AbstractMap.SimpleImmutableEntry(key, this.f33103e.e(key, (Collection) entry.getValue()));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzgut zzgutVar = this.f33103e;
        if (this.f33102d == zzgutVar.f33127d) {
            zzgutVar.d();
            return;
        }
        zzgrf zzgrfVar = new zzgrf(this);
        while (zzgrfVar.hasNext()) {
            zzgrfVar.next();
            zzgrfVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f33102d;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f33102d.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f33102d;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        return this.f33103e.e(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f33102d.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzguj, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        zzgut zzgutVar = this.f33103e;
        Set set = zzgutVar.f33130a;
        if (set != null) {
            return set;
        }
        Map map = zzgutVar.f33127d;
        Set zzgrlVar = map instanceof NavigableMap ? new zzgrl(zzgutVar, (NavigableMap) map) : map instanceof SortedMap ? new zzgro(zzgutVar, (SortedMap) map) : new zzgrj(zzgutVar, map);
        zzgutVar.f33130a = zzgrlVar;
        return zzgrlVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f33102d.remove(obj);
        if (collection == null) {
            return null;
        }
        zzgut zzgutVar = this.f33103e;
        Collection collectionF = zzgutVar.f();
        collectionF.addAll(collection);
        zzgutVar.f33128e -= collection.size();
        collection.clear();
        return collectionF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f33102d.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f33102d.toString();
    }
}
