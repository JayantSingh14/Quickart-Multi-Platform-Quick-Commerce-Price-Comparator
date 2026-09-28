package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    @Override // com.google.common.collect.Multimap
    public Map asMap() {
        return t().asMap();
    }

    public Collection b(Object obj) {
        return t().b(obj);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        t().clear();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return t().containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public Collection d() {
        return t().d();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean equals(Object obj) {
        return obj == this || t().equals(obj);
    }

    public Collection get(Object obj) {
        return t().get(obj);
    }

    @Override // com.google.common.collect.Multimap
    public final int hashCode() {
        return t().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean isEmpty() {
        return t().isEmpty();
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        return t().keySet();
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        return t().put(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        return t().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public final boolean s(Object obj, Object obj2) {
        return t().s(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return t().size();
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Multimap t();

    @Override // com.google.common.collect.Multimap
    public Collection values() {
        return t().values();
    }
}
