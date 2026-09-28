package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    public static class AddRejectingList<K, V> extends ForwardingList<V> {
        @Override // com.google.common.collect.ForwardingList
        public final List B() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            add(0, obj);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            addAll(0, collection);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public final void add(int i2, Object obj) {
            Preconditions.k(i2, 0);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public final boolean addAll(int i2, Collection collection) {
            collection.getClass();
            Preconditions.k(i2, 0);
            throw null;
        }
    }

    public static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        @Override // com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final Set t() {
            return Collections.EMPTY_SET;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            collection.getClass();
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return Collections.EMPTY_SET;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return Collections.EMPTY_SET;
        }
    }

    public class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        public Entries() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            FilteredKeyMultimap.this.getClass();
            ((Map.Entry) obj).getKey();
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            t();
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            FilteredKeyMultimap.this.getClass();
            throw null;
        }
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Map a() {
        throw null;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection b(Object obj) {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection c() {
        return new Entries();
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Set e() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection f() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection l(Object obj) {
        throw null;
    }

    public Multimap i() {
        return null;
    }

    @Override // com.google.common.collect.FilteredMultimap
    public final Predicate p() {
        Predicates.d(null, Maps.EntryFunction.f42905a);
        throw null;
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        Iterator<V> it = asMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }
}
