package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SortedMultisets {

    public static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {

        /* renamed from: a, reason: collision with root package name */
        public final SortedMultiset f43077a;

        public ElementSet(SortedMultiset sortedMultiset) {
            this.f43077a = sortedMultiset;
        }

        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return this.f43077a.comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            Multiset.Entry entryFirstEntry = this.f43077a.firstEntry();
            if (entryFirstEntry != null) {
                return entryFirstEntry.a();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public final Multiset g() {
            return this.f43077a;
        }

        @Override // java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            return this.f43077a.l1(obj, BoundType.f42528a).e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new Multisets.AnonymousClass5(this.f43077a.entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public final Object last() {
            Multiset.Entry entryLastEntry = this.f43077a.lastEntry();
            if (entryLastEntry != null) {
                return entryLastEntry.a();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return this.f43077a.k0(obj, BoundType.f42529b, obj2, BoundType.f42528a).e();
        }

        @Override // java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            return this.f43077a.s1(obj, BoundType.f42529b).e();
        }
    }

    @GwtIncompatible
    public static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return SortedMultisets.a(this.f43077a.s1(obj, BoundType.f42529b).firstEntry());
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return ((ElementSet) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return new NavigableElementSet(this.f43077a.t0());
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return SortedMultisets.a(this.f43077a.l1(obj, BoundType.f42529b).lastEntry());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return new NavigableElementSet(this.f43077a.l1(obj, BoundType.a(z)));
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return SortedMultisets.a(this.f43077a.s1(obj, BoundType.f42528a).firstEntry());
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return SortedMultisets.a(this.f43077a.l1(obj, BoundType.f42528a).lastEntry());
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            return SortedMultisets.a(this.f43077a.pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            return SortedMultisets.a(this.f43077a.pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableElementSet(this.f43077a.k0(obj, BoundType.a(z), obj2, BoundType.a(z2)));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return new NavigableElementSet(this.f43077a.s1(obj, BoundType.a(z)));
        }
    }

    public static Object a(Multiset.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.a();
    }
}
