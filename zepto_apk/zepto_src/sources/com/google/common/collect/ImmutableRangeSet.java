package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;
import com.google.common.collect.SortedLists;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final ImmutableRangeSet f42704b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImmutableRangeSet f42705c;

    /* renamed from: a, reason: collision with root package name */
    public final transient ImmutableList f42706a;

    /* renamed from: com.google.common.collect.ImmutableRangeSet$1, reason: invalid class name */
    class AnonymousClass1 extends ImmutableList<Range<Comparable>> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f42707c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f42708d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Range f42709e;

        public AnonymousClass1(int i2, int i3, Range range) {
            this.f42707c = i2;
            this.f42708d = i3;
            this.f42709e = range;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public final Object get(int i2) {
            int i3 = this.f42707c;
            Preconditions.i(i2, i3);
            ImmutableRangeSet immutableRangeSet = ImmutableRangeSet.this;
            int i4 = this.f42708d;
            ImmutableList immutableList = immutableRangeSet.f42706a;
            return (i2 == 0 || i2 == i3 + (-1)) ? ((Range) immutableList.get(i2 + i4)).d(this.f42709e) : (Range) immutableList.get(i2 + i4);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42707c;
        }
    }

    public final class AsSet extends ImmutableSortedSet<C> {

        /* renamed from: g, reason: collision with root package name */
        public transient Integer f42711g;

        /* renamed from: com.google.common.collect.ImmutableRangeSet$AsSet$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Comparable> {

            /* renamed from: c, reason: collision with root package name */
            public final UnmodifiableListIterator f42712c;

            /* renamed from: d, reason: collision with root package name */
            public final UnmodifiableIterator f42713d;

            public AnonymousClass1() {
                AsSet.this.getClass();
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                UnmodifiableIterator unmodifiableIterator = this.f42713d;
                if (unmodifiableIterator.hasNext()) {
                    return (Comparable) unmodifiableIterator.next();
                }
                UnmodifiableListIterator unmodifiableListIterator = this.f42712c;
                if (!unmodifiableListIterator.hasNext()) {
                    this.f42456a = AbstractIterator.State.f42461c;
                    return null;
                }
                Range range = (Range) unmodifiableListIterator.next();
                AsSet.this.getClass();
                int i2 = ContiguousSet.f42590g;
                range.getClass();
                throw null;
            }
        }

        /* renamed from: com.google.common.collect.ImmutableRangeSet$AsSet$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<Comparable> {

            /* renamed from: c, reason: collision with root package name */
            public final UnmodifiableListIterator f42715c;

            /* renamed from: d, reason: collision with root package name */
            public final UnmodifiableIterator f42716d;

            public AnonymousClass2() {
                AsSet.this.getClass();
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                UnmodifiableIterator unmodifiableIterator = this.f42716d;
                if (unmodifiableIterator.hasNext()) {
                    return (Comparable) unmodifiableIterator.next();
                }
                UnmodifiableListIterator unmodifiableListIterator = this.f42715c;
                if (!unmodifiableListIterator.hasNext()) {
                    this.f42456a = AbstractIterator.State.f42461c;
                    return null;
                }
                Range range = (Range) unmodifiableListIterator.next();
                AsSet.this.getClass();
                int i2 = ContiguousSet.f42590g;
                range.getClass();
                throw null;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public final ImmutableSortedSet C(Object obj, boolean z) {
            K(Range.h((Comparable) obj, BoundType.a(z)));
            throw null;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public final ImmutableSortedSet G(Object obj, boolean z, Object obj2, boolean z2) {
            Comparable comparable = (Comparable) obj;
            Comparable comparable2 = (Comparable) obj2;
            if (!z && !z2) {
                Range range = Range.f42992c;
                if (comparable.compareTo(comparable2) == 0) {
                    return RegularImmutableSortedSet.f43045h;
                }
            }
            K(Range.g(comparable, BoundType.a(z), comparable2, BoundType.a(z2)));
            throw null;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public final ImmutableSortedSet J(Object obj, boolean z) {
            K(Range.b((Comparable) obj, BoundType.a(z)));
            throw null;
        }

        public final ImmutableSortedSet K(Range range) {
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

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public final Iterator descendingIterator() {
            return new AnonymousClass2();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public final Iterator iterator() {
            return new AnonymousClass1();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            return new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            Integer num = this.f42711g;
            if (num != null) {
                return num.intValue();
            }
            throw null;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public final ImmutableSortedSet v() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        /* renamed from: w */
        public final UnmodifiableIterator descendingIterator() {
            return new AnonymousClass2();
        }
    }

    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
    }

    public static class Builder<C extends Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f42718a = new ArrayList();
    }

    public final class ComplementRanges extends ImmutableList<Range<C>> {
        @Override // java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, 0);
            throw null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return 0;
        }
    }

    public static final class SerializedForm<C extends Comparable> implements Serializable {
    }

    static {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        f42704b = new ImmutableRangeSet(RegularImmutableList.f43010e);
        f42705c = new ImmutableRangeSet(ImmutableList.t(Range.f42992c));
    }

    public ImmutableRangeSet(ImmutableList immutableList) {
        this.f42706a = immutableList;
    }

    @Override // com.google.common.collect.RangeSet
    public final Set a() {
        ImmutableList immutableList = this.f42706a;
        if (immutableList.isEmpty()) {
            int i2 = ImmutableSet.f42719c;
            return RegularImmutableSet.f43033j;
        }
        Range range = Range.f42992c;
        return new RegularImmutableSortedSet(immutableList, Range.RangeLexOrdering.f42997a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Range b(Comparable comparable) {
        int iA;
        Range range = Range.f42992c;
        Range.LowerBoundFn lowerBoundFn = Range.LowerBoundFn.f42996a;
        Cut.BelowValue belowValueA = Cut.a(comparable);
        SortedLists.KeyPresentBehavior.AnonymousClass1 anonymousClass1 = SortedLists.KeyPresentBehavior.f43072a;
        SortedLists.KeyAbsentBehavior.AnonymousClass1 anonymousClass12 = SortedLists.KeyAbsentBehavior.f43069a;
        ImmutableList immutableList = this.f42706a;
        NaturalOrdering naturalOrdering = NaturalOrdering.f42971c;
        AbstractList abstractListD = Lists.d(lowerBoundFn, immutableList);
        if (!(abstractListD instanceof RandomAccess)) {
            abstractListD = new ArrayList(abstractListD);
        }
        int size = abstractListD.size() - 1;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                iA = anonymousClass12.a(i2);
                break;
            }
            int i3 = (i2 + size) >>> 1;
            int iCompare = naturalOrdering.compare(belowValueA, abstractListD.get(i3));
            if (iCompare >= 0) {
                if (iCompare <= 0) {
                    int i4 = i3 - i2;
                    anonymousClass1.a(belowValueA, abstractListD.subList(i2, size + 1), i4);
                    iA = i2 + i4;
                    break;
                }
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        if (iA == -1) {
            return null;
        }
        Range range2 = (Range) immutableList.get(iA);
        if (range2.a(comparable)) {
            return range2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Range c() {
        ImmutableList immutableList = this.f42706a;
        if (immutableList.isEmpty()) {
            throw new NoSuchElementException();
        }
        return new Range(((Range) immutableList.get(0)).f42993a, ((Range) immutableList.get(immutableList.size() - 1)).f42994b);
    }
}
