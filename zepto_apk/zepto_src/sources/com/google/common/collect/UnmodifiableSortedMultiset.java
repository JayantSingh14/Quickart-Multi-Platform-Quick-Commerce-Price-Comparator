package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {

    /* renamed from: d, reason: collision with root package name */
    public transient UnmodifiableSortedMultiset f43166d;

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset
    /* renamed from: B */
    public final Multiset t() {
        return this.f42966a;
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public final Set C() {
        return Sets.j(this.f42966a.e());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return this.f42966a.comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return this.f42966a.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        SortedMultiset sortedMultisetK0 = this.f42966a.k0(obj, boundType, obj2, boundType2);
        sortedMultisetK0.getClass();
        return new UnmodifiableSortedMultiset(sortedMultisetK0);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset l1(Object obj, BoundType boundType) {
        SortedMultiset sortedMultisetL1 = this.f42966a.l1(obj, boundType);
        sortedMultisetL1.getClass();
        return new UnmodifiableSortedMultiset(sortedMultisetL1);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return this.f42966a.lastEntry();
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
    public final SortedMultiset s1(Object obj, BoundType boundType) {
        SortedMultiset sortedMultisetS1 = this.f42966a.s1(obj, boundType);
        sortedMultisetS1.getClass();
        return new UnmodifiableSortedMultiset(sortedMultisetS1);
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object t() {
        return this.f42966a;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset t0() {
        UnmodifiableSortedMultiset unmodifiableSortedMultiset = this.f43166d;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset(this.f42966a.t0());
        unmodifiableSortedMultiset2.f43166d = this;
        this.f43166d = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
    /* renamed from: u */
    public final Collection t() {
        return this.f42966a;
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final NavigableSet e() {
        return (NavigableSet) super.e();
    }
}
