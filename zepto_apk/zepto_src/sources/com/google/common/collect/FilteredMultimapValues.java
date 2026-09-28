package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractMultimap f42615a;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredMultimapValues(FilteredMultimap filteredMultimap) {
        this.f42615a = (AbstractMultimap) filteredMultimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f42615a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f42615a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new Maps.AnonymousClass2(this.f42615a.d().iterator());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMultimap, com.google.common.collect.FilteredMultimap] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        ?? r0 = this.f42615a;
        Predicate predicateP = r0.p();
        Iterator it = r0.i().d().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (predicateP.apply(entry) && Objects.a(entry.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMultimap, com.google.common.collect.FilteredMultimap] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        ?? r0 = this.f42615a;
        return Iterables.f(r0.i().d(), Predicates.c(r0.p(), Predicates.d(Predicates.f(collection), Maps.EntryFunction.f42906b)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMultimap, com.google.common.collect.FilteredMultimap] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        ?? r0 = this.f42615a;
        return Iterables.f(r0.i().d(), Predicates.c(r0.p(), Predicates.d(Predicates.h(Predicates.f(collection)), Maps.EntryFunction.f42906b)));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f42615a.size();
    }
}
