package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

@GwtCompatible
@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient ImmutableSet f42671a;

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableSet f42672b;

    /* renamed from: c, reason: collision with root package name */
    public transient ImmutableCollection f42673c;

    @DoNotMock
    public static class Builder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f42675a;

        /* renamed from: b, reason: collision with root package name */
        public int f42676b;

        /* renamed from: c, reason: collision with root package name */
        public DuplicateKey f42677c;

        /* loaded from: classes4.dex */
        public static final class DuplicateKey {

            /* renamed from: a, reason: collision with root package name */
            public final Object f42678a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f42679b;

            /* renamed from: c, reason: collision with root package name */
            public final Object f42680c;

            public DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.f42678a = obj;
                this.f42679b = obj2;
                this.f42680c = obj3;
            }

            public final IllegalArgumentException a() {
                StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
                Object obj = this.f42678a;
                sb.append(obj);
                sb.append("=");
                sb.append(this.f42679b);
                sb.append(" and ");
                sb.append(obj);
                sb.append("=");
                sb.append(this.f42680c);
                return new IllegalArgumentException(sb.toString());
            }
        }

        public Builder() {
            this(4);
        }

        public final ImmutableMap a(boolean z) {
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (z && (duplicateKey2 = this.f42677c) != null) {
                throw duplicateKey2.a();
            }
            RegularImmutableMap regularImmutableMapO = RegularImmutableMap.o(this.f42676b, this.f42675a, this);
            if (!z || (duplicateKey = this.f42677c) == null) {
                return regularImmutableMapO;
            }
            throw duplicateKey.a();
        }

        public ImmutableMap b() {
            return a(true);
        }

        public Builder c(Object obj, Object obj2) {
            int i2 = (this.f42676b + 1) * 2;
            Object[] objArr = this.f42675a;
            if (i2 > objArr.length) {
                this.f42675a = Arrays.copyOf(objArr, ImmutableCollection.Builder.a(objArr.length, i2));
            }
            CollectPreconditions.a(obj, obj2);
            Object[] objArr2 = this.f42675a;
            int i3 = this.f42676b;
            int i4 = i3 * 2;
            objArr2[i4] = obj;
            objArr2[i4 + 1] = obj2;
            this.f42676b = i3 + 1;
            return this;
        }

        public Builder d(Iterable iterable) {
            if (iterable instanceof Collection) {
                int size = (((Collection) iterable).size() + this.f42676b) * 2;
                Object[] objArr = this.f42675a;
                if (size > objArr.length) {
                    this.f42675a = Arrays.copyOf(objArr, ImmutableCollection.Builder.a(objArr.length, size));
                }
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                c(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder e(Map map) {
            return d(((ImmutableMap) map).entrySet());
        }

        public Builder(int i2) {
            this.f42675a = new Object[i2 * 2];
            this.f42676b = 0;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public final ImmutableSet b() {
            return new ImmutableMapEntrySet<Object, Object>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public final Iterator iterator() {
                    return IteratorBasedImmutableMap.this.o();
                }

                @Override // com.google.common.collect.ImmutableCollection
                /* renamed from: k */
                public final UnmodifiableIterator iterator() {
                    return IteratorBasedImmutableMap.this.o();
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public final ImmutableMap v() {
                    return IteratorBasedImmutableMap.this;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet c() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public final ImmutableCollection d() {
            return new ImmutableMapValues(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final /* bridge */ /* synthetic */ Set entrySet() {
            return entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        public abstract UnmodifiableIterator o();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public final /* bridge */ /* synthetic */ Collection values() {
            return values();
        }
    }

    /* loaded from: classes4.dex */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1, reason: invalid class name */
        class AnonymousClass1 extends UnmodifiableIterator<Map.Entry<Object, ImmutableSet<Object>>> {

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1$1, reason: invalid class name and collision with other inner class name */
            class C00331 extends AbstractMapEntry<Object, ImmutableSet<Object>> {
                @Override // java.util.Map.Entry
                public final Object getKey() {
                    throw null;
                }

                @Override // java.util.Map.Entry
                public final Object getValue() {
                    throw null;
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                throw null;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw null;
            }
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public final ImmutableSet c() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final boolean containsKey(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap
        public final boolean f() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap
        public final boolean g() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final Object get(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final int hashCode() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public final UnmodifiableIterator o() {
            throw null;
        }

        @Override // java.util.Map
        public final int size() {
            throw null;
        }
    }

    @J2ktIncompatible
    /* loaded from: classes4.dex */
    public static class SerializedForm<K, V> implements Serializable {
    }

    public static ImmutableMap a(Map map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap immutableMap = (ImmutableMap) map;
            if (!immutableMap.g()) {
                return immutableMap;
            }
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        Builder builder = new Builder(setEntrySet != null ? setEntrySet.size() : 4);
        builder.d(setEntrySet);
        return builder.a(true);
    }

    public static ImmutableMap j() {
        return RegularImmutableMap.f43013g;
    }

    public static ImmutableMap k(Object obj, Object obj2) {
        CollectPreconditions.a(obj, obj2);
        return RegularImmutableMap.o(1, new Object[]{obj, obj2}, null);
    }

    public static ImmutableMap l(String str, String str2, String str3, String str4) {
        CollectPreconditions.a("Purpose1", str);
        CollectPreconditions.a("Purpose3", str2);
        CollectPreconditions.a("Purpose4", str3);
        CollectPreconditions.a("Purpose7", str4);
        return RegularImmutableMap.o(4, new Object[]{"Purpose1", str, "Purpose3", str2, "Purpose4", str3, "Purpose7", str4}, null);
    }

    public static ImmutableMap m(String str, String str2, String str3, String str4, String str5) {
        return RegularImmutableMap.o(5, new Object[]{"AuthorizePurpose1", str, "AuthorizePurpose3", str2, "AuthorizePurpose4", str3, "AuthorizePurpose7", str4, "PurposeDiagnostics", str5}, null);
    }

    public abstract ImmutableSet b();

    public abstract ImmutableSet c();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableCollection d();

    @Override // java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.f42671a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet immutableSetB = b();
        this.f42671a = immutableSetB;
        return immutableSetB;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.d(obj, this);
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public UnmodifiableIterator h() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.ImmutableMap.1
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return ((Map.Entry) it.next()).getKey();
            }
        };
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.e(entrySet());
    }

    @Override // java.util.Map
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ImmutableSet keySet() {
        ImmutableSet immutableSet = this.f42672b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet immutableSetC = c();
        this.f42672b = immutableSetC;
        return immutableSetC;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection values() {
        ImmutableCollection immutableCollection = this.f42673c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection immutableCollectionD = d();
        this.f42673c = immutableCollectionD;
        return immutableCollectionD;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return Maps.i(this);
    }
}
