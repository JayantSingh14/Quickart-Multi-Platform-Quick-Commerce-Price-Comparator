package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {

    /* renamed from: d, reason: collision with root package name */
    public final ImmutableMap f42682d;

    @GwtIncompatible
    @J2ktIncompatible
    public static class KeySetSerializedForm<K> implements Serializable {
    }

    public ImmutableMapKeySet(ImmutableMap immutableMap) {
        this.f42682d = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f42682d.containsKey(obj);
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    public final Object get(int i2) {
        return ((Map.Entry) this.f42682d.entrySet().b().get(i2)).getKey();
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final Iterator iterator() {
        return this.f42682d.h();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return true;
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableCollection
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return this.f42682d.h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f42682d.size();
    }
}
