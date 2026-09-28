package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: e, reason: collision with root package name */
    public final transient ImmutableSortedMultiset f42598e;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset immutableSortedMultiset) {
        this.f42598e = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return this.f42598e.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return this.f42598e.j();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return this.f42598e.firstEntry();
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        return this.f42598e.o1(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public final Multiset.Entry p(int i2) {
        return (Multiset.Entry) this.f42598e.entrySet().b().w().get(i2);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset
    /* renamed from: q */
    public final ImmutableSortedMultiset t0() {
        return this.f42598e;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedSet e() {
        return this.f42598e.e().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedMultiset l1(Object obj, BoundType boundType) {
        return this.f42598e.s1(obj, boundType).t0();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f42598e.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedMultiset s1(Object obj, BoundType boundType) {
        return this.f42598e.l1(obj, boundType).t0();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final SortedMultiset t0() {
        return this.f42598e;
    }
}
