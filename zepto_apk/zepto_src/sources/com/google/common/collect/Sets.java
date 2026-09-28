package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Collections2;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Sets {

    /* renamed from: com.google.common.collect.Sets$4, reason: invalid class name */
    class AnonymousClass4 extends SetView<Object> {

        /* renamed from: com.google.common.collect.Sets$4$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Object> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // com.google.common.collect.Sets.SetView
        /* renamed from: b */
        public final UnmodifiableIterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            throw null;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Sets$5, reason: invalid class name */
    class AnonymousClass5 extends AbstractSet<Set<Object>> {

        /* renamed from: com.google.common.collect.Sets$5$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Set<Object>> {

            /* renamed from: com.google.common.collect.Sets$5$1$1, reason: invalid class name and collision with other inner class name */
            class C00391 extends AbstractSet<Object> {

                /* renamed from: com.google.common.collect.Sets$5$1$1$1, reason: invalid class name and collision with other inner class name */
                class C00401 extends AbstractIterator<Object> {
                    @Override // com.google.common.collect.AbstractIterator
                    public final Object a() {
                        throw null;
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final boolean contains(Object obj) {
                    throw null;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    return new C00401();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final int size() {
                    throw null;
                }
            }

            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if ((obj instanceof Set) && ((Set) obj).size() == 0) {
                throw null;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            throw null;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            throw null;
        }
    }

    public static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {

        /* renamed from: com.google.common.collect.Sets$CartesianSet$1, reason: invalid class name */
        class AnonymousClass1 extends ImmutableList<List<Object>> {
            @Override // java.util.List
            public final Object get(int i2) {
                throw null;
            }

            @Override // com.google.common.collect.ImmutableCollection
            public final boolean j() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                throw null;
            }
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            ((List) obj).size();
            throw null;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            if (obj instanceof CartesianSet) {
                ((CartesianSet) obj).getClass();
                throw null;
            }
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            size();
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return null;
        }
    }

    @GwtIncompatible
    public static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final /* bridge */ /* synthetic */ Set t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet
        /* renamed from: C */
        public final /* bridge */ /* synthetic */ SortedSet t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet
        /* renamed from: E */
        public final NavigableSet t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object ceiling(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final Comparator comparator() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Iterator descendingIterator() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final Object first() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object floor(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            headSet(obj, false);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object higher(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final Object last() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object lower(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object pollFirst() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final Object pollLast() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            subSet(obj, true, obj2, false);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            tailSet(obj, true);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            return ObjectArrays.c(this, objArr);
        }

        @Override // com.google.common.collect.ForwardingObject
        public final String toString() {
            return z();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final /* bridge */ /* synthetic */ Collection t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return y();
        }
    }

    @GwtIncompatible
    public static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return Iterators.g(((NavigableSet) this.f42536a).tailSet(obj, true).iterator(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return Iterators.f(((NavigableSet) this.f42536a).descendingIterator(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return Sets.c(((NavigableSet) this.f42536a).descendingSet(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return Iterators.g(((NavigableSet) this.f42536a).headSet(obj, true).descendingIterator(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return Sets.c(((NavigableSet) this.f42536a).headSet(obj, z), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return Iterators.g(((NavigableSet) this.f42536a).tailSet(obj, false).iterator(), this.f42537b);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public final Object last() {
            Iterator<E> itDescendingIterator = ((NavigableSet) this.f42536a).descendingIterator();
            itDescendingIterator.getClass();
            Predicate predicate = this.f42537b;
            predicate.getClass();
            while (itDescendingIterator.hasNext()) {
                E next = itDescendingIterator.next();
                if (predicate.apply(next)) {
                    return next;
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return Iterators.g(((NavigableSet) this.f42536a).headSet(obj, false).descendingIterator(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            return Iterables.e((NavigableSet) this.f42536a, this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            return Iterables.e(((NavigableSet) this.f42536a).descendingSet(), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return Sets.c(((NavigableSet) this.f42536a).subSet(obj, z, obj2, z2), this.f42537b);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return Sets.c(((NavigableSet) this.f42536a).tailSet(obj, z), this.f42537b);
        }
    }

    public static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.e(this);
        }
    }

    public static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return ((SortedSet) this.f42536a).comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            Iterator<E> it = this.f42536a.iterator();
            it.getClass();
            Predicate predicate = this.f42537b;
            predicate.getClass();
            while (it.hasNext()) {
                E next = it.next();
                if (predicate.apply(next)) {
                    return next;
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            return new FilteredSortedSet(((SortedSet) this.f42536a).headSet(obj), this.f42537b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f42536a;
            while (true) {
                Object objLast = sortedSetHeadSet.last();
                if (this.f42537b.apply(objLast)) {
                    return objLast;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
            }
        }

        @Override // java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return new FilteredSortedSet(((SortedSet) this.f42536a).subSet(obj, obj2), this.f42537b);
        }

        @Override // java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            return new FilteredSortedSet(((SortedSet) this.f42536a).tailSet(obj), this.f42537b);
        }
    }

    public static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return Sets.g(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            collection.getClass();
            return super.retainAll(collection);
        }
    }

    public static final class PowerSet<E> extends AbstractSet<Set<E>> {

        /* renamed from: com.google.common.collect.Sets$PowerSet$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIndexedListIterator<Set<Object>> {
            @Override // com.google.common.collect.AbstractIndexedListIterator
            public final Object a(int i2) {
                throw null;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (obj instanceof Set) {
                throw null;
            }
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            if (obj instanceof PowerSet) {
                throw null;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            throw null;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return "powerSet(null)";
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public abstract UnmodifiableIterator iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class SubSet<E> extends AbstractSet<E> {

        /* renamed from: com.google.common.collect.Sets$SubSet$1, reason: invalid class name */
        class AnonymousClass1 extends UnmodifiableIterator<Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f43064a;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f43064a != 0;
            }

            @Override // java.util.Iterator
            public final Object next() {
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f43064a);
                if (iNumberOfTrailingZeros == 32) {
                    throw new NoSuchElementException();
                }
                this.f43064a = (~(1 << iNumberOfTrailingZeros)) & this.f43064a;
                throw null;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return Integer.bitCount(0);
        }
    }

    public static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final NavigableSet f43065a;

        /* renamed from: b, reason: collision with root package name */
        public final SortedSet f43066b;

        /* renamed from: c, reason: collision with root package name */
        public transient UnmodifiableNavigableSet f43067c;

        public UnmodifiableNavigableSet(NavigableSet navigableSet) {
            navigableSet.getClass();
            this.f43065a = navigableSet;
            this.f43066b = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final Set t() {
            return this.f43066b;
        }

        @Override // com.google.common.collect.ForwardingSortedSet
        /* renamed from: C */
        public final SortedSet t() {
            return this.f43066b;
        }

        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return this.f43065a.ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return Iterators.o(this.f43065a.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            UnmodifiableNavigableSet unmodifiableNavigableSet = this.f43067c;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet unmodifiableNavigableSet2 = new UnmodifiableNavigableSet(this.f43065a.descendingSet());
            this.f43067c = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.f43067c = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return this.f43065a.floor(obj);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return Sets.j(this.f43065a.headSet(obj, z));
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return this.f43065a.higher(obj);
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return this.f43065a.lower(obj);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return Sets.j(this.f43065a.subSet(obj, z, obj2, z2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return this.f43066b;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return Sets.j(this.f43065a.tailSet(obj, z));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return this.f43066b;
        }
    }

    public static SetView a(final Set set, final Set set2) {
        Preconditions.j(set, "set1");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.3

            /* renamed from: com.google.common.collect.Sets$3$1, reason: invalid class name */
            class AnonymousClass1 extends AbstractIterator<Object> {

                /* renamed from: c, reason: collision with root package name */
                public final Iterator f43062c;

                public AnonymousClass1() {
                    this.f43062c = set.iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    Object next;
                    do {
                        Iterator it = this.f43062c;
                        if (!it.hasNext()) {
                            this.f42456a = AbstractIterator.State.f42461c;
                            return null;
                        }
                        next = it.next();
                    } while (((SingletonImmutableSet) set2).f43068d.equals(next));
                    return next;
                }
            }

            @Override // com.google.common.collect.Sets.SetView
            /* renamed from: b */
            public final UnmodifiableIterator iterator() {
                return new AnonymousClass1();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean isEmpty() {
                return set2.containsAll(set);
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new AnonymousClass1();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                Iterator it = set.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (!set2.contains(it.next())) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    public static boolean b(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NavigableSet c(NavigableSet navigableSet, Predicate predicate) {
        if (navigableSet instanceof FilteredSet) {
            FilteredSet filteredSet = (FilteredSet) navigableSet;
            return new FilteredNavigableSet((NavigableSet) filteredSet.f42536a, Predicates.c(filteredSet.f42537b, predicate));
        }
        navigableSet.getClass();
        predicate.getClass();
        return new FilteredNavigableSet(navigableSet, predicate);
    }

    public static Set d(Set set, Predicate predicate) {
        if (!(set instanceof SortedSet)) {
            if (set instanceof FilteredSet) {
                FilteredSet filteredSet = (FilteredSet) set;
                return new FilteredSet((Set) filteredSet.f42536a, Predicates.c(filteredSet.f42537b, predicate));
            }
            set.getClass();
            predicate.getClass();
            return new FilteredSet(set, predicate);
        }
        Collection collection = (SortedSet) set;
        if (collection instanceof FilteredSet) {
            FilteredSet filteredSet2 = (FilteredSet) collection;
            return new FilteredSortedSet((SortedSet) filteredSet2.f42536a, Predicates.c(filteredSet2.f42537b, predicate));
        }
        collection.getClass();
        predicate.getClass();
        return new FilteredSortedSet(collection, predicate);
    }

    public static int e(Set set) {
        Iterator it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static SetView f(final ImmutableSet immutableSet, final ImmutableSet immutableSet2) {
        Preconditions.j(immutableSet, "set1");
        Preconditions.j(immutableSet2, "set2");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.2

            /* renamed from: com.google.common.collect.Sets$2$1, reason: invalid class name */
            class AnonymousClass1 extends AbstractIterator<Object> {

                /* renamed from: c, reason: collision with root package name */
                public final Iterator f43058c;

                public AnonymousClass1() {
                    this.f43058c = immutableSet.iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    Object next;
                    do {
                        Iterator it = this.f43058c;
                        if (!it.hasNext()) {
                            this.f42456a = AbstractIterator.State.f42461c;
                            return null;
                        }
                        next = it.next();
                    } while (!immutableSet2.contains(next));
                    return next;
                }
            }

            @Override // com.google.common.collect.Sets.SetView
            /* renamed from: b */
            public final UnmodifiableIterator iterator() {
                return new AnonymousClass1();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                return immutableSet.contains(obj) && immutableSet2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean containsAll(Collection collection) {
                return immutableSet.containsAll(collection) && immutableSet2.containsAll(collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean isEmpty() {
                return Collections.disjoint(immutableSet2, immutableSet);
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new AnonymousClass1();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                Iterator<E> it = immutableSet.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (immutableSet2.contains(it.next())) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    public static boolean g(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? h(set, collection.iterator()) : Iterators.l(collection, set.iterator());
    }

    public static boolean h(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static SetView i(final Set set, final Set set2) {
        Preconditions.j(set, "set1");
        Preconditions.j(set2, "set2");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.1

            /* renamed from: com.google.common.collect.Sets$1$1, reason: invalid class name and collision with other inner class name */
            class C00381 extends AbstractIterator<Object> {

                /* renamed from: c, reason: collision with root package name */
                public final Iterator f43053c;

                /* renamed from: d, reason: collision with root package name */
                public final Iterator f43054d;

                public C00381() {
                    this.f43053c = set.iterator();
                    this.f43054d = set2.iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    Object next;
                    Iterator it = this.f43053c;
                    if (it.hasNext()) {
                        return it.next();
                    }
                    do {
                        Iterator it2 = this.f43054d;
                        if (!it2.hasNext()) {
                            this.f42456a = AbstractIterator.State.f42461c;
                            return null;
                        }
                        next = it2.next();
                    } while (set.contains(next));
                    return next;
                }
            }

            @Override // com.google.common.collect.Sets.SetView
            /* renamed from: b */
            public final UnmodifiableIterator iterator() {
                return new C00381();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new C00381();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                Set set3 = set;
                int size = set3.size();
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    if (!set3.contains(it.next())) {
                        size++;
                    }
                }
                return size;
            }
        };
    }

    public static NavigableSet j(NavigableSet navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
