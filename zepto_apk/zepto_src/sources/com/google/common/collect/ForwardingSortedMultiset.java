package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.NavigableSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    public abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        @Override // com.google.common.collect.DescendingMultiset
        public final SortedMultiset E() {
            return null;
        }
    }

    public class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public abstract SortedMultiset t();

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return t().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return t().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return t().k0(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset l1(Object obj, BoundType boundType) {
        return t().l1(obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return t().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollFirstEntry() {
        return t().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollLastEntry() {
        return t().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset s1(Object obj, BoundType boundType) {
        return t().s1(obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset t0() {
        return t().t0();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final NavigableSet e() {
        return t().e();
    }
}
