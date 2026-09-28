package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSet<E> implements NavigableSet<E>, SortedIterable<E> {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f42737f = 0;

    /* renamed from: d, reason: collision with root package name */
    public final transient Comparator f42738d;

    /* renamed from: e, reason: collision with root package name */
    public transient ImmutableSortedSet f42739e;

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        /* renamed from: b */
        public final ImmutableCollection.ArrayBasedBuilder c(Object obj) {
            super.c(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public final ImmutableCollection.Builder c(Object obj) {
            super.c(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* renamed from: h */
        public final ImmutableSet.Builder c(Object obj) {
            super.c(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        public final ImmutableSet.Builder i(Object[] objArr) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        public final ImmutableSet.Builder j(Iterable iterable) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        public final ImmutableSet k() {
            RegularImmutableSortedSet regularImmutableSortedSet;
            Object[] objArrCopyOf = this.f42657a;
            int i2 = this.f42658b;
            if (i2 == 0) {
                regularImmutableSortedSet = ImmutableSortedSet.z(null);
            } else {
                int i3 = ImmutableSortedSet.f42737f;
                ObjectArrays.a(i2, objArrCopyOf);
                Arrays.sort(objArrCopyOf, 0, i2, null);
                if (1 < i2) {
                    Object obj = objArrCopyOf[1];
                    Object obj2 = objArrCopyOf[0];
                    throw null;
                }
                Arrays.fill(objArrCopyOf, 1, i2, (Object) null);
                if (1 < objArrCopyOf.length / 2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, 1);
                }
                regularImmutableSortedSet = new RegularImmutableSortedSet(ImmutableList.m(1, objArrCopyOf), null);
            }
            this.f42658b = regularImmutableSortedSet.f43046g.size();
            this.f42659c = true;
            return regularImmutableSortedSet;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        public final ImmutableSet.Builder l(ImmutableSet.Builder builder) {
            super.l(builder);
            return this;
        }
    }

    @J2ktIncompatible
    public static class SerializedForm<E> implements Serializable {
    }

    public ImmutableSortedSet(Comparator comparator) {
        this.f42738d = comparator;
    }

    public static RegularImmutableSortedSet z(Comparator comparator) {
        return NaturalOrdering.f42971c.equals(comparator) ? RegularImmutableSortedSet.f43045h : new RegularImmutableSortedSet(RegularImmutableList.f43010e, comparator);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet headSet(Object obj, boolean z) {
        obj.getClass();
        return C(obj, z);
    }

    public abstract ImmutableSortedSet C(Object obj, boolean z);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        Preconditions.f(this.f42738d.compare(obj, obj2) <= 0);
        return G(obj, z, obj2, z2);
    }

    public abstract ImmutableSortedSet G(Object obj, boolean z, Object obj2, boolean z2);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return J(obj, z);
    }

    public abstract ImmutableSortedSet J(Object obj, boolean z);

    public Object ceiling(Object obj) {
        return Iterators.i(tailSet(obj, true).iterator(), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return this.f42738d;
    }

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        return Iterators.i(headSet(obj, true).descendingIterator(), null);
    }

    public Object higher(Object obj) {
        return Iterators.i(tailSet(obj, false).iterator(), null);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        return Iterators.i(headSet(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedSet v();

    @Override // java.util.NavigableSet
    /* renamed from: w */
    public abstract UnmodifiableIterator descendingIterator();

    @Override // java.util.NavigableSet
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet descendingSet() {
        ImmutableSortedSet immutableSortedSet = this.f42739e;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet immutableSortedSetV = v();
        this.f42739e = immutableSortedSetV;
        immutableSortedSetV.f42739e = this;
        return immutableSortedSetV;
    }
}
