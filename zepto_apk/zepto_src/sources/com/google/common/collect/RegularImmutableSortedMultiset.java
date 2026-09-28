package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: i, reason: collision with root package name */
    public static final long[] f43039i = {0};

    /* renamed from: j, reason: collision with root package name */
    public static final ImmutableSortedMultiset f43040j = new RegularImmutableSortedMultiset(NaturalOrdering.f42971c);

    /* renamed from: e, reason: collision with root package name */
    public final transient RegularImmutableSortedSet f43041e;

    /* renamed from: f, reason: collision with root package name */
    public final transient long[] f43042f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f43043g;

    /* renamed from: h, reason: collision with root package name */
    public final transient int f43044h;

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet regularImmutableSortedSet, long[] jArr, int i2, int i3) {
        this.f43041e = regularImmutableSortedSet;
        this.f43042f = jArr;
        this.f43043g = i2;
        this.f43044h = i3;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final NavigableSet e() {
        return this.f43041e;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return p(0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        if (this.f43043g <= 0) {
            if (this.f43044h >= this.f43042f.length - 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return p(this.f43044h - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset
    /* renamed from: n */
    public final ImmutableSet e() {
        return this.f43041e;
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        RegularImmutableSortedSet regularImmutableSortedSet = this.f43041e;
        regularImmutableSortedSet.getClass();
        int i2 = -1;
        if (obj != null) {
            try {
                int iBinarySearch = Collections.binarySearch(regularImmutableSortedSet.f43046g, obj, regularImmutableSortedSet.f42738d);
                if (iBinarySearch >= 0) {
                    i2 = iBinarySearch;
                }
            } catch (ClassCastException unused) {
            }
        }
        if (i2 < 0) {
            return 0;
        }
        int i3 = this.f43043g + i2;
        long[] jArr = this.f43042f;
        return (int) (jArr[i3 + 1] - jArr[i3]);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public final Multiset.Entry p(int i2) {
        E e2 = this.f43041e.f43046g.get(i2);
        int i3 = this.f43043g + i2;
        long[] jArr = this.f43042f;
        return new Multisets.ImmutableEntry(e2, (int) (jArr[i3 + 1] - jArr[i3]));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset
    /* renamed from: r */
    public final ImmutableSortedSet e() {
        return this.f43041e;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: s */
    public final ImmutableSortedMultiset l1(Object obj, BoundType boundType) {
        return u(0, this.f43041e.L(obj, boundType == BoundType.f42529b));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i2 = this.f43044h;
        int i3 = this.f43043g;
        long[] jArr = this.f43042f;
        return Ints.f(jArr[i2 + i3] - jArr[i3]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: t */
    public final ImmutableSortedMultiset s1(Object obj, BoundType boundType) {
        return u(this.f43041e.M(obj, boundType == BoundType.f42529b), this.f43044h);
    }

    public final ImmutableSortedMultiset u(int i2, int i3) {
        int i4 = this.f43044h;
        Preconditions.l(i2, i3, i4);
        RegularImmutableSortedSet regularImmutableSortedSet = this.f43041e;
        if (i2 == i3) {
            Comparator comparator = regularImmutableSortedSet.f42738d;
            return NaturalOrdering.f42971c.equals(comparator) ? f43040j : new RegularImmutableSortedMultiset(comparator);
        }
        if (i2 == 0 && i3 == i4) {
            return this;
        }
        return new RegularImmutableSortedMultiset(regularImmutableSortedSet.K(i2, i3), this.f43042f, this.f43043g + i2, i3 - i2);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final Set e() {
        return this.f43041e;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final SortedSet e() {
        return this.f43041e;
    }

    public RegularImmutableSortedMultiset(Comparator comparator) {
        this.f43041e = ImmutableSortedSet.z(comparator);
        this.f43042f = f43039i;
        this.f43043g = 0;
        this.f43044h = 0;
    }
}
