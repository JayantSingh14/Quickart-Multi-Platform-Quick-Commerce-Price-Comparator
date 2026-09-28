package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableMap<K, V> implements NavigableMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public static final ImmutableSortedMap f42724g;

    /* renamed from: d, reason: collision with root package name */
    public final transient RegularImmutableSortedSet f42725d;

    /* renamed from: e, reason: collision with root package name */
    public final transient ImmutableList f42726e;

    /* renamed from: f, reason: collision with root package name */
    public final transient ImmutableSortedMap f42727f;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public transient Object[] f42730d;

        /* renamed from: e, reason: collision with root package name */
        public transient Object[] f42731e;

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap b() {
            int i2 = this.f42676b;
            if (i2 == 0) {
                return ImmutableSortedMap.o(null);
            }
            if (i2 == 1) {
                Object obj = this.f42730d[0];
                Objects.requireNonNull(obj);
                Objects.requireNonNull(this.f42731e[0]);
                ImmutableList.t(obj);
                throw null;
            }
            Object[] objArrCopyOf = Arrays.copyOf(this.f42730d, i2);
            Arrays.sort(objArrCopyOf, null);
            int i3 = this.f42676b;
            Object[] objArr = new Object[i3];
            for (int i4 = 0; i4 < this.f42676b; i4++) {
                if (i4 > 0) {
                    Object obj2 = objArrCopyOf[i4 - 1];
                    Object obj3 = objArrCopyOf[i4];
                    throw null;
                }
                Object obj4 = this.f42730d[i4];
                Objects.requireNonNull(obj4);
                int iBinarySearch = Arrays.binarySearch(objArrCopyOf, obj4, null);
                Object obj5 = this.f42731e[i4];
                Objects.requireNonNull(obj5);
                objArr[iBinarySearch] = obj5;
            }
            return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.m(objArrCopyOf.length, objArrCopyOf), null), ImmutableList.m(i3, objArr), null);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder c(Object obj, Object obj2) {
            int i2 = this.f42676b + 1;
            Object[] objArr = this.f42730d;
            if (i2 > objArr.length) {
                int iA = ImmutableCollection.Builder.a(objArr.length, i2);
                this.f42730d = Arrays.copyOf(this.f42730d, iA);
                this.f42731e = Arrays.copyOf(this.f42731e, iA);
            }
            CollectPreconditions.a(obj, obj2);
            Object[] objArr2 = this.f42730d;
            int i3 = this.f42676b;
            objArr2[i3] = obj;
            this.f42731e[i3] = obj2;
            this.f42676b = i3 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder d(Iterable iterable) {
            super.d(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder e(Map map) {
            d(((ImmutableMap) map).entrySet());
            return this;
        }
    }

    @J2ktIncompatible
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
    }

    static {
        RegularImmutableSortedSet regularImmutableSortedSetZ = ImmutableSortedSet.z(NaturalOrdering.f42971c);
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        f42724g = new ImmutableSortedMap(regularImmutableSortedSetZ, RegularImmutableList.f43010e, null);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList, ImmutableSortedMap immutableSortedMap) {
        this.f42725d = regularImmutableSortedSet;
        this.f42726e = immutableList;
        this.f42727f = immutableSortedMap;
    }

    public static ImmutableSortedMap o(Comparator comparator) {
        return NaturalOrdering.f42971c.equals(comparator) ? f42724g : new ImmutableSortedMap(ImmutableSortedSet.z(comparator), RegularImmutableList.f43010e, null);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet b() {
        if (!isEmpty()) {
            return new ImmutableMapEntrySet<Object, Object>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                /* renamed from: k */
                public final UnmodifiableIterator iterator() {
                    return b().listIterator(0);
                }

                @Override // com.google.common.collect.ImmutableSet
                public final ImmutableList q() {
                    return new ImmutableList<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                        @Override // java.util.List
                        public final Object get(int i2) {
                            C1EntrySet c1EntrySet = C1EntrySet.this;
                            return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f42725d.f43046g.get(i2), ImmutableSortedMap.this.f42726e.get(i2));
                        }

                        @Override // com.google.common.collect.ImmutableCollection
                        public final boolean j() {
                            return true;
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                        public final int size() {
                            return ImmutableSortedMap.this.f42726e.size();
                        }
                    };
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public final ImmutableMap v() {
                    return ImmutableSortedMap.this;
                }
            };
        }
        int i2 = ImmutableSet.f42719c;
        return RegularImmutableSet.f43033j;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet c() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return Maps.f(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return this.f42725d.f42738d;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableCollection d() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return this.f42725d.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        ImmutableSortedMap immutableSortedMap = this.f42727f;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        boolean zIsEmpty = isEmpty();
        RegularImmutableSortedSet regularImmutableSortedSet = this.f42725d;
        return zIsEmpty ? o(Ordering.b(regularImmutableSortedSet.f42738d).g()) : new ImmutableSortedMap((RegularImmutableSortedSet) regularImmutableSortedSet.descendingSet(), this.f42726e.w(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) super.entrySet().b().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.f42725d.first();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return Maps.f(floorEntry(obj));
    }

    @Override // com.google.common.collect.ImmutableMap
    public final boolean g() {
        return this.f42725d.f43046g.j() || this.f42726e.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            com.google.common.collect.RegularImmutableSortedSet r0 = r3.f42725d
            r0.getClass()
            r1 = -1
            if (r4 != 0) goto La
        L8:
            r4 = r1
            goto L14
        La:
            com.google.common.collect.ImmutableList r2 = r0.f43046g     // Catch: java.lang.ClassCastException -> L8
            java.util.Comparator r0 = r0.f42738d     // Catch: java.lang.ClassCastException -> L8
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L8
            if (r4 < 0) goto L8
        L14:
            if (r4 != r1) goto L18
            r4 = 0
            return r4
        L18:
            com.google.common.collect.ImmutableList r0 = r3.f42726e
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return Maps.f(higherEntry(obj));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: i */
    public final ImmutableSet keySet() {
        return this.f42725d;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Set keySet() {
        return this.f42725d;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) super.entrySet().b().get(this.f42726e.size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.f42725d.last();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return Maps.f(lowerEntry(obj));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: n */
    public final ImmutableCollection values() {
        return this.f42726e;
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return this.f42725d;
    }

    public final ImmutableSortedMap p(int i2, int i3) {
        ImmutableList immutableList = this.f42726e;
        if (i2 == 0 && i3 == immutableList.size()) {
            return this;
        }
        RegularImmutableSortedSet regularImmutableSortedSet = this.f42725d;
        return i2 == i3 ? o(regularImmutableSortedSet.f42738d) : new ImmutableSortedMap(regularImmutableSortedSet.K(i2, i3), immutableList.subList(i2, i3), null);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedMap headMap(Object obj, boolean z) {
        obj.getClass();
        return p(0, this.f42725d.L(obj, z));
    }

    @Override // java.util.NavigableMap
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        Preconditions.d(obj, obj2, "expected fromKey <= toKey but %s > %s", this.f42725d.f42738d.compare(obj, obj2) <= 0);
        return headMap(obj2, z2).tailMap(obj, z);
    }

    @Override // java.util.NavigableMap
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedMap tailMap(Object obj, boolean z) {
        obj.getClass();
        return p(this.f42725d.M(obj, z), this.f42726e.size());
    }

    @Override // java.util.Map
    public final int size() {
        return this.f42726e.size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public final Collection values() {
        return this.f42726e;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
