package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f42999h = 0;

    /* renamed from: com.google.common.collect.RegularContiguousSet$3, reason: invalid class name */
    class AnonymousClass3 extends ImmutableAsList<Comparable> {
        @Override // com.google.common.collect.ImmutableAsList
        public final ImmutableCollection A() {
            return null;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, size());
            throw null;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static final class SerializedForm<C extends Comparable> implements Serializable {
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet C(Comparable comparable, boolean z) {
        return Q(Range.h(comparable, BoundType.a(z)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public final Range L() {
        throw null;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet G(Comparable comparable, boolean z, Comparable comparable2, boolean z2) {
        return (comparable.compareTo(comparable2) != 0 || z || z2) ? Q(Range.g(comparable, BoundType.a(z), comparable2, BoundType.a(z2))) : new EmptyContiguousSet(NaturalOrdering.f42971c);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet J(Comparable comparable, boolean z) {
        return Q(Range.b(comparable, BoundType.a(z)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final Comparable first() {
        throw null;
    }

    public final ContiguousSet Q(Range range) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final Comparable last() {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            throw null;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return Collections2.a(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegularContiguousSet)) {
            return super.equals(obj);
        }
        ((RegularContiguousSet) obj).getClass();
        throw null;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return Sets.e(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return new AbstractSequentialIterator<Comparable>(first()) { // from class: com.google.common.collect.RegularContiguousSet.1

            /* renamed from: b, reason: collision with root package name */
            public final Comparable f43000b;

            {
                this.f43000b = RegularContiguousSet.this.last();
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public final Object a(Object obj) {
                Comparable comparable = (Comparable) obj;
                int i2 = RegularContiguousSet.f42999h;
                Comparable comparable2 = this.f43000b;
                if (comparable2 != null) {
                    Range range = Range.f42992c;
                    if (comparable.compareTo(comparable2) == 0) {
                        return null;
                    }
                }
                RegularContiguousSet.this.getClass();
                throw null;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList q() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        first();
        last();
        throw null;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final UnmodifiableIterator descendingIterator() {
        return new AbstractSequentialIterator<Comparable>(last()) { // from class: com.google.common.collect.RegularContiguousSet.2

            /* renamed from: b, reason: collision with root package name */
            public final Comparable f43002b;

            {
                this.f43002b = RegularContiguousSet.this.first();
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public final Object a(Object obj) {
                Comparable comparable = (Comparable) obj;
                int i2 = RegularContiguousSet.f42999h;
                Comparable comparable2 = this.f43002b;
                if (comparable2 != null) {
                    Range range = Range.f42992c;
                    if (comparable.compareTo(comparable2) == 0) {
                        return null;
                    }
                }
                RegularContiguousSet.this.getClass();
                throw null;
            }
        };
    }
}
