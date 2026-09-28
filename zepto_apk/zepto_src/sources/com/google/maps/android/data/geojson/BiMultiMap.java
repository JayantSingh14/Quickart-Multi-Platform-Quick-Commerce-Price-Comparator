package com.google.maps.android.data.geojson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class BiMultiMap<K> extends HashMap<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f45551a = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        super.clear();
        this.f45551a.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public final Object clone() {
        BiMultiMap biMultiMap = new BiMultiMap();
        biMultiMap.putAll((Map) super.clone());
        return biMultiMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        boolean z = obj2 instanceof Collection;
        HashMap map = this.f45551a;
        if (!z) {
            map.put(obj2, obj);
            return super.put(obj, obj2);
        }
        Collection collection = (Collection) obj2;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.put(it.next(), obj);
        }
        return super.put(obj, collection);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Object objRemove = super.remove(obj);
        boolean z = objRemove instanceof Collection;
        HashMap map = this.f45551a;
        if (!z) {
            map.remove(objRemove);
            return objRemove;
        }
        Iterator it = ((Collection) objRemove).iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return objRemove;
    }
}
