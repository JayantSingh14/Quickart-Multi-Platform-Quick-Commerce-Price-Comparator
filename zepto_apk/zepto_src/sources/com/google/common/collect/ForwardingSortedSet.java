package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public abstract SortedSet t();

    @Override // java.util.SortedSet
    public Comparator comparator() {
        return t().comparator();
    }

    @Override // java.util.SortedSet
    public Object first() {
        return t().first();
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return t().headSet(obj);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return t().last();
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return t().subSet(obj, obj2);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return t().tailSet(obj);
    }
}
