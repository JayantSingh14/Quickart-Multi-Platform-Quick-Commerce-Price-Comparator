package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
class zzgro extends zzgrj implements SortedSet {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgut f33116c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgro(zzgut zzgutVar, SortedMap sortedMap) {
        super(zzgutVar, sortedMap);
        Objects.requireNonNull(zzgutVar);
        this.f33116c = zzgutVar;
    }

    public SortedMap b() {
        return (SortedMap) this.f33223a;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return b().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return b().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzgro(this.f33116c, b().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return b().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzgro(this.f33116c, b().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzgro(this.f33116c, b().tailMap(obj));
    }
}
