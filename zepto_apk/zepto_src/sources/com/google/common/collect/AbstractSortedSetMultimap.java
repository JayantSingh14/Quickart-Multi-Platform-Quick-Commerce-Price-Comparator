package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public final Collection m() {
        SortedSet sortedSetH = h();
        return sortedSetH instanceof NavigableSet ? Sets.j((NavigableSet) sortedSetH) : Collections.unmodifiableSortedSet(sortedSetH);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public final Collection n(Collection collection) {
        return collection instanceof NavigableSet ? Sets.j((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public final Collection q(Object obj, Collection collection) {
        return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(obj, (NavigableSet) collection, null) : new AbstractMapBasedMultimap.WrappedSortedSet(obj, (SortedSet) collection, null);
    }

    @Override // com.google.common.collect.AbstractSetMultimap
    /* renamed from: t */
    public final Set m() {
        SortedSet sortedSetH = h();
        return sortedSetH instanceof NavigableSet ? Sets.j((NavigableSet) sortedSetH) : Collections.unmodifiableSortedSet(sortedSetH);
    }

    @Override // com.google.common.collect.AbstractSetMultimap
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract SortedSet h();

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet b(Object obj) {
        return (SortedSet) super.b(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public SortedSet l(Object obj) {
        return (SortedSet) super.l(obj);
    }
}
