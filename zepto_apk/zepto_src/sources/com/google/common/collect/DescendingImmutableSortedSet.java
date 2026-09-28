package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* renamed from: g, reason: collision with root package name */
    public final ImmutableSortedSet f42599g;

    public DescendingImmutableSortedSet(ImmutableSortedSet immutableSortedSet) {
        super(Ordering.b(immutableSortedSet.f42738d).g());
        this.f42599g = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet C(Object obj, boolean z) {
        return this.f42599g.tailSet(obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet G(Object obj, boolean z, Object obj2, boolean z2) {
        return this.f42599g.subSet(obj2, z2, obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet J(Object obj, boolean z) {
        return this.f42599g.headSet(obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return this.f42599g.floor(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f42599g.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Iterator descendingIterator() {
        return this.f42599g.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return this.f42599g;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object floor(Object obj) {
        return this.f42599g.ceiling(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object higher(Object obj) {
        return this.f42599g.lower(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final Iterator iterator() {
        return this.f42599g.descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return this.f42599g.j();
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return this.f42599g.descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object lower(Object obj) {
        return this.f42599g.higher(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f42599g.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet v() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: w */
    public final UnmodifiableIterator descendingIterator() {
        return this.f42599g.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: y */
    public final ImmutableSortedSet descendingSet() {
        return this.f42599g;
    }
}
