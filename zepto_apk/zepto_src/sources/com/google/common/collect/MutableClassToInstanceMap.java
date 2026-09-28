package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    public static final class SerializedForm<B> implements Serializable {
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Set entrySet() {
        return new ForwardingSet<Map.Entry<Class<Object>, Object>>() { // from class: com.google.common.collect.MutableClassToInstanceMap.2

            /* renamed from: com.google.common.collect.MutableClassToInstanceMap$2$1, reason: invalid class name */
            class AnonymousClass1 extends TransformedIterator<Map.Entry<Class<Object>, Object>, Map.Entry<Class<Object>, Object>> {
                @Override // com.google.common.collect.TransformedIterator
                public final Object a(Object obj) {
                    final Map.Entry entry = (Map.Entry) obj;
                    return new ForwardingMapEntry<Class<Object>, Object>() { // from class: com.google.common.collect.MutableClassToInstanceMap.1
                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public final Object setValue(Object obj2) {
                            Class cls = (Class) getKey();
                            Map map = Primitives.f43322a;
                            cls.getClass();
                            Class cls2 = (Class) Primitives.f43322a.get(cls);
                            if (cls2 != null) {
                                cls = cls2;
                            }
                            cls.cast(obj2);
                            return super.setValue(obj2);
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public final Object t() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry
                        /* renamed from: u */
                        public final Map.Entry t() {
                            return entry;
                        }
                    };
                }
            }

            @Override // com.google.common.collect.ForwardingSet
            /* renamed from: B */
            public final Set t() {
                MutableClassToInstanceMap.this.getClass();
                throw null;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                t();
                throw null;
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public final /* bridge */ /* synthetic */ Object t() {
                t();
                throw null;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public final Object[] toArray() {
                return y();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            /* renamed from: u */
            public final /* bridge */ /* synthetic */ Collection t() {
                t();
                throw null;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public final Object[] toArray(Object[] objArr) {
                return ObjectArrays.c(this, objArr);
            }
        };
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Class cls = (Class) obj;
        Map map = Primitives.f43322a;
        cls.getClass();
        Class cls2 = (Class) Primitives.f43322a.get(cls);
        if (cls2 == null) {
            cls2 = cls;
        }
        cls2.cast(obj2);
        return super.put(cls, obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final void putAll(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Class cls = (Class) entry.getKey();
            Object value = entry.getValue();
            Map map2 = Primitives.f43322a;
            cls.getClass();
            Class cls2 = (Class) Primitives.f43322a.get(cls);
            if (cls2 != null) {
                cls = cls2;
            }
            cls.cast(value);
        }
        super.putAll(linkedHashMap);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final /* bridge */ /* synthetic */ Object t() {
        return null;
    }

    @Override // com.google.common.collect.ForwardingMap
    /* renamed from: u */
    public final Map t() {
        return null;
    }
}
