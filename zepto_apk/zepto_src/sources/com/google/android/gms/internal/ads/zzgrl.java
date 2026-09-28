package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
final class zzgrl extends zzgro implements NavigableSet {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgut f33113d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrl(zzgut zzgutVar, NavigableMap navigableMap) {
        super(zzgutVar, navigableMap);
        Objects.requireNonNull(zzgutVar);
        this.f33113d = zzgutVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgro
    public final /* synthetic */ SortedMap b() {
        return (NavigableMap) ((SortedMap) this.f33223a);
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33223a)).ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((zzgrj) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new zzgrl(this.f33113d, ((NavigableMap) ((SortedMap) this.f33223a)).descendingMap());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33223a)).floorKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgro, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33223a)).higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return ((NavigableMap) ((SortedMap) this.f33223a)).lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        zzgri zzgriVar = (zzgri) iterator();
        if (!zzgriVar.hasNext()) {
            return null;
        }
        Object next = zzgriVar.next();
        zzgriVar.remove();
        return next;
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        Iterator itDescendingIterator = descendingIterator();
        if (!itDescendingIterator.hasNext()) {
            return null;
        }
        Object next = itDescendingIterator.next();
        itDescendingIterator.remove();
        return next;
    }

    @Override // com.google.android.gms.internal.ads.zzgro, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgro, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return new zzgrl(this.f33113d, ((NavigableMap) ((SortedMap) this.f33223a)).headMap(obj, z));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new zzgrl(this.f33113d, ((NavigableMap) ((SortedMap) this.f33223a)).subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return new zzgrl(this.f33113d, ((NavigableMap) ((SortedMap) this.f33223a)).tailMap(obj, z));
    }
}
