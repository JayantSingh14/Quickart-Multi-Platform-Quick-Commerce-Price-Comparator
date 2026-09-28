package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableMultiset<E> implements SortedMultiset<E> {

    /* renamed from: d, reason: collision with root package name */
    public transient ImmutableSortedMultiset f42732d;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {

        /* renamed from: c, reason: collision with root package name */
        public Object[] f42733c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f42734d;

        /* renamed from: e, reason: collision with root package name */
        public int f42735e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f42736f;

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public final ImmutableCollection.Builder b(Object obj) {
            e(1, obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* renamed from: c */
        public final ImmutableMultiset.Builder b(Object obj) {
            e(1, obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public final /* bridge */ /* synthetic */ ImmutableMultiset.Builder d(int i2, Object obj) {
            e(i2, obj);
            return this;
        }

        public final void e(int i2, Object obj) {
            obj.getClass();
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                return;
            }
            int i3 = this.f42735e;
            Object[] objArr = this.f42733c;
            if (i3 == objArr.length) {
                if (i3 != 0) {
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, i3);
                    Arrays.sort(objArrCopyOf, null);
                    if (1 < objArrCopyOf.length) {
                        Object obj2 = objArrCopyOf[0];
                        Object obj3 = objArrCopyOf[1];
                        throw null;
                    }
                    Arrays.fill(objArrCopyOf, 1, this.f42735e, (Object) null);
                    int i4 = this.f42735e;
                    if (4 > i4 * 3) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, Ints.f(i4 + (i4 / 2) + 1));
                    }
                    int[] iArr = new int[objArrCopyOf.length];
                    for (int i5 = 0; i5 < this.f42735e; i5++) {
                        int iBinarySearch = Arrays.binarySearch(objArrCopyOf, 0, 1, this.f42733c[i5], null);
                        int i6 = this.f42734d[i5];
                        if (i6 >= 0) {
                            iArr[iBinarySearch] = iArr[iBinarySearch] + i6;
                        } else {
                            iArr[iBinarySearch] = ~i6;
                        }
                    }
                    this.f42733c = objArrCopyOf;
                    this.f42734d = iArr;
                    this.f42735e = 1;
                }
            } else if (this.f42736f) {
                this.f42733c = Arrays.copyOf(objArr, objArr.length);
            }
            this.f42736f = false;
            Object[] objArr2 = this.f42733c;
            int i7 = this.f42735e;
            objArr2[i7] = obj;
            this.f42734d[i7] = i2;
            this.f42735e = i7 + 1;
        }
    }

    @J2ktIncompatible
    public static final class SerializedForm<E> implements Serializable {
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return e().f42738d;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        Preconditions.d(obj, obj2, "Expected lowerBound <= upperBound but %s > %s", e().f42738d.compare(obj, obj2) <= 0);
        return s1(obj, boundType).l1(obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMultiset t0() {
        ImmutableSortedMultiset descendingImmutableSortedMultiset = this.f42732d;
        if (descendingImmutableSortedMultiset == null) {
            if (isEmpty()) {
                Ordering orderingG = Ordering.b(e().f42738d).g();
                descendingImmutableSortedMultiset = NaturalOrdering.f42971c.equals(orderingG) ? RegularImmutableSortedMultiset.f43040j : new RegularImmutableSortedMultiset(orderingG);
            } else {
                descendingImmutableSortedMultiset = new DescendingImmutableSortedMultiset(this);
            }
            this.f42732d = descendingImmutableSortedMultiset;
        }
        return descendingImmutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* renamed from: r */
    public abstract ImmutableSortedSet e();

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: s */
    public abstract ImmutableSortedMultiset l1(Object obj, BoundType boundType);

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: t */
    public abstract ImmutableSortedMultiset s1(Object obj, BoundType boundType);
}
