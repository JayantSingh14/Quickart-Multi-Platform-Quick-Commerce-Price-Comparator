package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
final class zzgrk extends zzgrn implements NavigableMap {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzgut f33112h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrk(zzgut zzgutVar, NavigableMap navigableMap) {
        super(zzgutVar, navigableMap);
        Objects.requireNonNull(zzgutVar);
        this.f33112h = zzgutVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, com.google.android.gms.internal.ads.zzguj
    public final Set b() {
        return new zzgrl(this.f33112h, (NavigableMap) ((SortedMap) this.f33102d));
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry entryCeilingEntry = ((NavigableMap) ((SortedMap) this.f33102d)).ceilingEntry(obj);
        if (entryCeilingEntry == null) {
            return null;
        }
        return c(entryCeilingEntry);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33102d)).ceilingKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgrn
    /* renamed from: d */
    public final SortedSet b() {
        return new zzgrl(this.f33112h, (NavigableMap) ((SortedMap) this.f33102d));
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return new zzgrk(this.f33112h, ((NavigableMap) ((SortedMap) this.f33102d)).descendingMap());
    }

    @Override // com.google.android.gms.internal.ads.zzgrn
    /* renamed from: e */
    public final /* synthetic */ SortedSet keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // com.google.android.gms.internal.ads.zzgrn
    public final /* synthetic */ SortedMap f() {
        return (NavigableMap) ((SortedMap) this.f33102d);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        Map.Entry entryFirstEntry = ((NavigableMap) ((SortedMap) this.f33102d)).firstEntry();
        if (entryFirstEntry == null) {
            return null;
        }
        return c(entryFirstEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        Map.Entry entryFloorEntry = ((NavigableMap) ((SortedMap) this.f33102d)).floorEntry(obj);
        if (entryFloorEntry == null) {
            return null;
        }
        return c(entryFloorEntry);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33102d)).floorKey(obj);
    }

    public final AbstractMap.SimpleImmutableEntry g(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        Collection collectionF = this.f33112h.f();
        collectionF.addAll((Collection) entry.getValue());
        it.remove();
        return new AbstractMap.SimpleImmutableEntry(entry.getKey(), Collections.unmodifiableList((List) collectionF));
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, java.util.SortedMap, java.util.NavigableMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        Map.Entry entryHigherEntry = ((NavigableMap) ((SortedMap) this.f33102d)).higherEntry(obj);
        if (entryHigherEntry == null) {
            return null;
        }
        return c(entryHigherEntry);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33102d)).higherKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, com.google.android.gms.internal.ads.zzgrg, com.google.android.gms.internal.ads.zzguj, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Set keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        Map.Entry entryLastEntry = ((NavigableMap) ((SortedMap) this.f33102d)).lastEntry();
        if (entryLastEntry == null) {
            return null;
        }
        return c(entryLastEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry entryLowerEntry = ((NavigableMap) ((SortedMap) this.f33102d)).lowerEntry(obj);
        if (entryLowerEntry == null) {
            return null;
        }
        return c(entryLowerEntry);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33102d)).lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return g(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return g(((zzguj) descendingMap()).entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, java.util.SortedMap, java.util.NavigableMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, java.util.SortedMap, java.util.NavigableMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return new zzgrk(this.f33112h, ((NavigableMap) ((SortedMap) this.f33102d)).headMap(obj, z));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new zzgrk(this.f33112h, ((NavigableMap) ((SortedMap) this.f33102d)).subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return new zzgrk(this.f33112h, ((NavigableMap) ((SortedMap) this.f33102d)).tailMap(obj, z));
    }
}
