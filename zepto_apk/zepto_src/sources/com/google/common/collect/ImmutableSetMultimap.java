package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public final transient ImmutableSet f42721g;

    /* renamed from: h, reason: collision with root package name */
    public transient ImmutableSet f42722h;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
    }

    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public final transient ImmutableSetMultimap f42723d;

        public EntrySet(ImmutableSetMultimap immutableSetMultimap) {
            this.f42723d = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f42723d.s(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public final Iterator iterator() {
            return this.f42723d.k();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            return this.f42723d.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f42723d.f42687f;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static final class SetFieldSettersHolder {
        static {
            Serialization.a(ImmutableSetMultimap.class, "emptySet");
        }
    }

    public ImmutableSetMultimap() {
        super(RegularImmutableMap.f43013g, 0);
        int i2 = ImmutableSet.f42719c;
        this.f42721g = RegularImmutableSet.f43033j;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final Collection b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection d() {
        ImmutableSet immutableSet = this.f42722h;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f42722h = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public final Collection l(Object obj) {
        return (ImmutableSet) MoreObjects.a((ImmutableSet) this.f42686e.get(obj), this.f42721g);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: j */
    public final ImmutableCollection d() {
        ImmutableSet immutableSet = this.f42722h;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f42722h = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public final ImmutableCollection l(Object obj) {
        return (ImmutableSet) MoreObjects.a((ImmutableSet) this.f42686e.get(obj), this.f42721g);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public final ImmutableCollection m() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final Set b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Set d() {
        ImmutableSet immutableSet = this.f42722h;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f42722h = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public final Set l(Object obj) {
        return (ImmutableSet) MoreObjects.a((ImmutableSet) this.f42686e.get(obj), this.f42721g);
    }
}
