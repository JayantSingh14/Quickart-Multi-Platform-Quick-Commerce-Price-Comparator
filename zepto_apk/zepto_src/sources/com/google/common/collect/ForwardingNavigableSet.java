package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    public class StandardDescendingSet extends Sets.DescendingSet<E> {
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public abstract NavigableSet t();

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        return t().ceiling(obj);
    }

    @Override // java.util.NavigableSet
    public Iterator descendingIterator() {
        return t().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet descendingSet() {
        return t().descendingSet();
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        return t().floor(obj);
    }

    @Override // java.util.NavigableSet
    public NavigableSet headSet(Object obj, boolean z) {
        return t().headSet(obj, z);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        return t().higher(obj);
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        return t().lower(obj);
    }

    @Override // java.util.NavigableSet
    public Object pollFirst() {
        return t().pollFirst();
    }

    @Override // java.util.NavigableSet
    public Object pollLast() {
        return t().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return t().subSet(obj, z, obj2, z2);
    }

    @Override // java.util.NavigableSet
    public NavigableSet tailSet(Object obj, boolean z) {
        return t().tailSet(obj, z);
    }
}
