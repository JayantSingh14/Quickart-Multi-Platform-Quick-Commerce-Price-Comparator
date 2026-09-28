package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {

    public final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.e(this);
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            throw null;
        }
    }

    public final class Complement extends TreeRangeSet<C> {
    }

    public static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        public final NavigableMap f43155a = new RangesByUpperBound();

        /* renamed from: b, reason: collision with root package name */
        public final Range f43156b;

        public ComplementRangesByLowerBound(Range range) {
            this.f43156b = range;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            Collection collectionValues;
            Cut cut = Cut.BelowAll.f42594b;
            Range range = this.f43156b;
            Cut cut2 = range.f42993a;
            boolean z = cut2 != cut;
            Map map = this.f43155a;
            if (z) {
                collectionValues = ((RangesByUpperBound) map).tailMap((Cut) cut2.e(), range.f42993a.l() == BoundType.f42529b).values();
            } else {
                collectionValues = ((AbstractMap) map).values();
            }
            PeekingIterator peekingIteratorJ = Iterators.j(collectionValues.iterator());
            if (!range.a(cut) || (peekingIteratorJ.hasNext() && ((Range) ((Iterators.PeekingImpl) peekingIteratorJ).a()).f42993a == cut)) {
                if (!peekingIteratorJ.hasNext()) {
                    return Iterators.ArrayItr.f42756d;
                }
                cut = ((Range) peekingIteratorJ.next()).f42994b;
            }
            return new AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>>(cut, peekingIteratorJ) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.1

                /* renamed from: c, reason: collision with root package name */
                public Cut f43157c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ PeekingIterator f43158d;

                {
                    this.f43158d = peekingIteratorJ;
                    this.f43157c = cut;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    Range range2;
                    if (!ComplementRangesByLowerBound.this.f43156b.f42994b.h(this.f43157c)) {
                        Cut cut3 = this.f43157c;
                        Cut.AboveAll aboveAll = Cut.AboveAll.f42593b;
                        if (cut3 != aboveAll) {
                            PeekingIterator peekingIterator = this.f43158d;
                            if (peekingIterator.hasNext()) {
                                Range range3 = (Range) peekingIterator.next();
                                range2 = new Range(this.f43157c, range3.f42993a);
                                this.f43157c = range3.f42994b;
                            } else {
                                range2 = new Range(this.f43157c, aboveAll);
                                this.f43157c = aboveAll;
                            }
                            return new ImmutableEntry(range2.f42993a, range2);
                        }
                    }
                    this.f42456a = AbstractIterator.State.f42461c;
                    return null;
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractNavigableMap
        public final Iterator b() {
            Range range = this.f43156b;
            boolean zC = range.c();
            Cut.AboveAll aboveAll = Cut.AboveAll.f42593b;
            Cut cut = range.f42994b;
            PeekingIterator peekingIteratorJ = Iterators.j(((RangesByUpperBound) this.f43155a).headMap(zC ? (Cut) cut.e() : aboveAll, range.c() && cut.n() == BoundType.f42529b).descendingMap().values().iterator());
            if (!peekingIteratorJ.hasNext()) {
                if (range.a(Cut.BelowAll.f42594b)) {
                    throw null;
                }
                return Iterators.ArrayItr.f42756d;
            }
            Iterators.PeekingImpl peekingImpl = (Iterators.PeekingImpl) peekingIteratorJ;
            if (((Range) peekingImpl.a()).f42994b == aboveAll) {
                return new AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>>((Cut) MoreObjects.a(((Range) peekingIteratorJ.next()).f42993a, aboveAll), peekingIteratorJ) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.2

                    /* renamed from: c, reason: collision with root package name */
                    public Cut f43160c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ PeekingIterator f43161d;

                    {
                        this.f43161d = peekingIteratorJ;
                        this.f43160c = cut;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.common.collect.AbstractIterator
                    public final Object a() {
                        Cut cut2 = this.f43160c;
                        Cut.BelowAll belowAll = Cut.BelowAll.f42594b;
                        AbstractIterator.State state = AbstractIterator.State.f42461c;
                        if (cut2 == belowAll) {
                            this.f42456a = state;
                            return null;
                        }
                        PeekingIterator peekingIterator = this.f43161d;
                        boolean zHasNext = peekingIterator.hasNext();
                        ComplementRangesByLowerBound complementRangesByLowerBound = ComplementRangesByLowerBound.this;
                        if (zHasNext) {
                            Range range2 = (Range) peekingIterator.next();
                            Cut cut3 = range2.f42994b;
                            Range range3 = new Range(cut3, this.f43160c);
                            this.f43160c = range2.f42993a;
                            if (complementRangesByLowerBound.f43156b.f42993a.h(cut3)) {
                                return new ImmutableEntry(cut3, range3);
                            }
                        } else if (complementRangesByLowerBound.f43156b.f42993a.h(belowAll)) {
                            Range range4 = new Range(belowAll, this.f43160c);
                            this.f43160c = belowAll;
                            return new ImmutableEntry(belowAll, range4);
                        }
                        this.f42456a = state;
                        return null;
                    }
                };
            }
            Cut cut2 = ((Range) peekingImpl.a()).f42994b;
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Range get(Object obj) {
            if (!(obj instanceof Cut)) {
                return null;
            }
            try {
                Cut cut = (Cut) obj;
                Map.Entry entryFirstEntry = d(Range.b(cut, BoundType.a(true))).firstEntry();
                if (entryFirstEntry == null || !((Cut) entryFirstEntry.getKey()).equals(cut)) {
                    return null;
                }
                return (Range) entryFirstEntry.getValue();
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return NaturalOrdering.f42971c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        public final NavigableMap d(Range range) {
            Range range2 = this.f43156b;
            return !range2.e(range) ? ImmutableSortedMap.f42724g : new ComplementRangesByLowerBound(range.d(range2));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return d(Range.h((Cut) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return Iterators.m(a());
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return d(Range.g((Cut) obj, BoundType.a(z), (Cut) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return d(Range.b((Cut) obj, BoundType.a(z)));
        }
    }

    public final class SubRangeSet extends TreeRangeSet<C> {
    }

    public static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        public final Range f43164a;

        /* renamed from: com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        /* renamed from: com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        public SubRangeSetRangesByLowerBound(Range range) {
            this.f43164a = range;
            throw null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public final Iterator b() {
            throw null;
        }

        public final Range c(Object obj) {
            if (obj instanceof Cut) {
                try {
                    if (this.f43164a.a((Cut) obj)) {
                        throw null;
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return NaturalOrdering.f42971c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            c(obj);
            return false;
        }

        public final NavigableMap d(Range range) {
            Range range2 = this.f43164a;
            if (!range.e(range2)) {
                return ImmutableSortedMap.f42724g;
            }
            new SubRangeSetRangesByLowerBound(range2.d(range));
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            c(obj);
            return null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return d(Range.h((Cut) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            throw null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return d(Range.g((Cut) obj, BoundType.a(z), (Cut) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return d(Range.b((Cut) obj, BoundType.a(z)));
        }
    }

    @Override // com.google.common.collect.RangeSet
    public final Set a() {
        throw null;
    }

    @VisibleForTesting
    public static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        public final Range f43163a;

        /* renamed from: com.google.common.collect.TreeRangeSet$RangesByUpperBound$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        /* renamed from: com.google.common.collect.TreeRangeSet$RangesByUpperBound$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<Map.Entry<Cut<Comparable<?>>, Range<Comparable<?>>>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        public RangesByUpperBound() {
            this.f43163a = Range.f42992c;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            Cut.BelowAll belowAll = Cut.BelowAll.f42594b;
            Cut cut = this.f43163a.f42993a;
            if (!(cut != belowAll)) {
                throw null;
            }
            throw null;
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public final Iterator b() {
            Range range = this.f43163a;
            if (!range.c()) {
                throw null;
            }
            throw null;
        }

        public final Range c(Object obj) {
            if (obj instanceof Cut) {
                try {
                    if (this.f43163a.a((Cut) obj)) {
                        throw null;
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return NaturalOrdering.f42971c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            c(obj);
            return false;
        }

        public final NavigableMap d(Range range) {
            Range range2 = this.f43163a;
            return range.e(range2) ? new RangesByUpperBound(range.d(range2)) : ImmutableSortedMap.f42724g;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            c(obj);
            return null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return d(Range.h((Cut) obj, BoundType.a(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            if (this.f43163a.equals(Range.f42992c)) {
                throw null;
            }
            a();
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            if (this.f43163a.equals(Range.f42992c)) {
                throw null;
            }
            a();
            throw null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return d(Range.g((Cut) obj, BoundType.a(z), (Cut) obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return d(Range.b((Cut) obj, BoundType.a(z)));
        }

        public RangesByUpperBound(Range range) {
            this.f43163a = range;
        }
    }
}
