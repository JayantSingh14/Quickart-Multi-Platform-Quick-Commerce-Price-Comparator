package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    public abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        @Override // com.google.common.collect.Maps.EntrySet
        public final Map g() {
            return null;
        }
    }

    public class StandardKeySet extends Maps.KeySet<K, V> {
    }

    public class StandardValues extends Maps.Values<K, V> {
    }

    public void clear() {
        t().clear();
    }

    public boolean containsKey(Object obj) {
        return t().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return t().containsValue(obj);
    }

    public Set entrySet() {
        return t().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || t().equals(obj);
    }

    public Object get(Object obj) {
        return t().get(obj);
    }

    public int hashCode() {
        return t().hashCode();
    }

    public boolean isEmpty() {
        return t().isEmpty();
    }

    public Set keySet() {
        return t().keySet();
    }

    public Object put(Object obj, Object obj2) {
        return t().put(obj, obj2);
    }

    public void putAll(Map map) {
        t().putAll(map);
    }

    public Object remove(Object obj) {
        return t().remove(obj);
    }

    public int size() {
        return t().size();
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Map t();

    public Collection values() {
        return t().values();
    }

    public final boolean y(Object obj) {
        return Iterators.d(new Maps.AnonymousClass2(entrySet().iterator()), obj);
    }
}
