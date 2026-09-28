package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
    Comparator comparator();

    @Override // com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset
    NavigableSet e();

    @Override // com.google.common.collect.Multiset
    Set entrySet();

    Multiset.Entry firstEntry();

    SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2);

    SortedMultiset l1(Object obj, BoundType boundType);

    Multiset.Entry lastEntry();

    Multiset.Entry pollFirstEntry();

    Multiset.Entry pollLastEntry();

    SortedMultiset s1(Object obj, BoundType boundType);

    SortedMultiset t0();
}
