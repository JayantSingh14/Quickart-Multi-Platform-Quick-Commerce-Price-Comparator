package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection n(Collection collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection q(Object obj, Collection collection) {
        return new AbstractMapBasedMultimap.WrappedSet(obj, (Set) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public abstract Set h();

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Set m() {
        return Collections.EMPTY_SET;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set b(Object obj) {
        return (Set) super.b(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set d() {
        return (Set) super.d();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }
}
