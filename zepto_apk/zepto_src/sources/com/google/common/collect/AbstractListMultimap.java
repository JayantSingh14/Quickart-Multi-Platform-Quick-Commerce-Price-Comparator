package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection m() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection n(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection q(Object obj, Collection collection) {
        List list = (List) collection;
        return list instanceof RandomAccess ? new AbstractMapBasedMultimap.RandomAccessWrappedList(obj, list, null) : new AbstractMapBasedMultimap.WrappedList(obj, list, null);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public abstract List h();

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List b(Object obj) {
        return (List) super.b(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List get(Object obj) {
        return (List) super.get(obj);
    }
}
