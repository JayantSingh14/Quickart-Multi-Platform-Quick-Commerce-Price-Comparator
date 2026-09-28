package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* renamed from: h, reason: collision with root package name */
    public static final RegularImmutableSortedSet f43045h;

    /* renamed from: g, reason: collision with root package name */
    public final transient ImmutableList f43046g;

    static {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        f43045h = new RegularImmutableSortedSet(RegularImmutableList.f43010e, NaturalOrdering.f42971c);
    }

    public RegularImmutableSortedSet(ImmutableList immutableList, Comparator comparator) {
        super(comparator);
        this.f43046g = immutableList;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet C(Object obj, boolean z) {
        return K(0, L(obj, z));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet G(Object obj, boolean z, Object obj2, boolean z2) {
        return J(obj, z).C(obj2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet J(Object obj, boolean z) {
        return K(M(obj, z), this.f43046g.size());
    }

    public final RegularImmutableSortedSet K(int i2, int i3) {
        ImmutableList immutableList = this.f43046g;
        if (i2 == 0 && i3 == immutableList.size()) {
            return this;
        }
        Comparator comparator = this.f42738d;
        return i2 < i3 ? new RegularImmutableSortedSet(immutableList.subList(i2, i3), comparator) : ImmutableSortedSet.z(comparator);
    }

    public final int L(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.f43046g, obj, this.f42738d);
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    public final int M(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.f43046g, obj, this.f42738d);
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList b() {
        return this.f43046g;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int iM = M(obj, true);
        ImmutableList immutableList = this.f43046g;
        if (iM == immutableList.size()) {
            return null;
        }
        return immutableList.get(iM);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.f43046g, obj, this.f42738d) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        Comparator comparator = this.f42738d;
        if (!SortedIterables.a(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator it = iterator();
        Iterator<E> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        E next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iCompare = comparator.compare(next2, next);
                if (iCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iCompare > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        return this.f43046g.d(i2, objArr);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (this.f43046g.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        Comparator comparator = this.f42738d;
        if (!SortedIterables.a(comparator, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            UnmodifiableIterator it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || comparator.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] f() {
        return this.f43046g.f();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f43046g.get(0);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object floor(Object obj) {
        int iL = L(obj, true) - 1;
        if (iL == -1) {
            return null;
        }
        return this.f43046g.get(iL);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int g() {
        return this.f43046g.g();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object higher(Object obj) {
        int iM = M(obj, false);
        ImmutableList immutableList = this.f43046g;
        if (iM == immutableList.size()) {
            return null;
        }
        return immutableList.get(iM);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int i() {
        return this.f43046g.i();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return this.f43046g.j();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return this.f43046g.listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f43046g.get(r0.size() - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object lower(Object obj) {
        int iL = L(obj, false) - 1;
        if (iL == -1) {
            return null;
        }
        return this.f43046g.get(iL);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f43046g.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public final ImmutableSortedSet v() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f42738d);
        return isEmpty() ? ImmutableSortedSet.z(comparatorReverseOrder) : new RegularImmutableSortedSet(this.f43046g.w(), comparatorReverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: w */
    public final UnmodifiableIterator descendingIterator() {
        return this.f43046g.w().listIterator(0);
    }
}
