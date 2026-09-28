package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzgst extends zzgsu implements Map {
    @Override // com.google.android.gms.internal.ads.zzgsu
    public /* bridge */ /* synthetic */ Object b() {
        throw null;
    }

    @Override // java.util.Map
    public final void clear() {
        d().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return d().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return d().containsValue(obj);
    }

    public abstract Map d();

    @Override // java.util.Map
    public Set entrySet() {
        return d().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || d().equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return d().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return d().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return d().isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return d().keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return d().put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        d().putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return d().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return d().size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return d().values();
    }
}
