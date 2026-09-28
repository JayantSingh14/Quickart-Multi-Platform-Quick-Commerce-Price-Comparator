package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public int f16510g;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.f16510g = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void g(SimpleArrayMap simpleArrayMap) {
        this.f16510g = 0;
        super.g(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object h(int i2) {
        this.f16510g = 0;
        return super.h(i2);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.f16510g == 0) {
            this.f16510g = super.hashCode();
        }
        return this.f16510g;
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object i(int i2, Object obj) {
        this.f16510g = 0;
        return super.i(i2, obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f16510g = 0;
        return super.put(obj, obj2);
    }
}
