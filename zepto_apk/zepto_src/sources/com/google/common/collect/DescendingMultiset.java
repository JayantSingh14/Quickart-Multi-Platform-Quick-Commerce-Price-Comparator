package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultisets;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    public transient Ordering f42600a;

    /* renamed from: b, reason: collision with root package name */
    public transient NavigableSet f42601b;

    /* renamed from: c, reason: collision with root package name */
    public transient Set f42602c;

    @Override // com.google.common.collect.ForwardingMultiset
    /* renamed from: B */
    public final Multiset t() {
        return E();
    }

    public abstract Iterator C();

    public abstract SortedMultiset E();

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        Ordering ordering = this.f42600a;
        if (ordering != null) {
            return ordering;
        }
        Ordering orderingG = Ordering.b(E().comparator()).g();
        this.f42600a = orderingG;
        return orderingG;
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final Set entrySet() {
        Set set = this.f42602c;
        if (set != null) {
            return set;
        }
        Multisets.EntrySet<Object> entrySet = new Multisets.EntrySet<Object>() { // from class: com.google.common.collect.DescendingMultiset.1EntrySetImpl
            @Override // com.google.common.collect.Multisets.EntrySet
            public final Multiset g() {
                return DescendingMultiset.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return DescendingMultiset.this.C();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return DescendingMultiset.this.E().entrySet().size();
            }
        };
        this.f42602c = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return E().lastEntry();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return E().k0(obj2, boundType2, obj, boundType).t0();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset l1(Object obj, BoundType boundType) {
        return ((TreeMultiset) E()).s1(obj, boundType).t0();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return E().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollFirstEntry() {
        return E().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollLastEntry() {
        return E().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset s1(Object obj, BoundType boundType) {
        return ((TreeMultiset) E()).l1(obj, boundType).t0();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object t() {
        return E();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset t0() {
        return E();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return y();
    }

    @Override // com.google.common.collect.ForwardingObject
    public final String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
    /* renamed from: u */
    public final Collection t() {
        return E();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return ObjectArrays.c(this, objArr);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final NavigableSet e() {
        NavigableSet navigableSet = this.f42601b;
        if (navigableSet != null) {
            return navigableSet;
        }
        SortedMultisets.NavigableElementSet navigableElementSet = new SortedMultisets.NavigableElementSet(this);
        this.f42601b = navigableElementSet;
        return navigableElementSet;
    }
}
