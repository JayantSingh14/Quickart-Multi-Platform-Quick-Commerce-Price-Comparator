package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
class zzgrn extends zzgrg implements SortedMap {

    /* renamed from: f, reason: collision with root package name */
    public SortedSet f33114f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzgut f33115g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrn(zzgut zzgutVar, SortedMap sortedMap) {
        super(zzgutVar, sortedMap);
        Objects.requireNonNull(zzgutVar);
        this.f33115g = zzgutVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return f().comparator();
    }

    @Override // com.google.android.gms.internal.ads.zzguj
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SortedSet b() {
        return new zzgro(this.f33115g, f());
    }

    @Override // com.google.android.gms.internal.ads.zzgrg, com.google.android.gms.internal.ads.zzguj, java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f33114f;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetB = b();
        this.f33114f = sortedSetB;
        return sortedSetB;
    }

    public SortedMap f() {
        return (SortedMap) this.f33102d;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return f().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzgrn(this.f33115g, f().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return f().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzgrn(this.f33115g, f().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzgrn(this.f33115g, f().tailMap(obj));
    }
}
