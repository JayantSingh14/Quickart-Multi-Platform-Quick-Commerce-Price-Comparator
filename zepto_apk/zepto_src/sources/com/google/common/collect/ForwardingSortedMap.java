package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.SortedMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return t().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return t().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return t().headMap(obj);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return t().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return t().subMap(obj, obj2);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return t().tailMap(obj);
    }

    @Override // com.google.common.collect.ForwardingMap
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public abstract SortedMap t();
}
