package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f42543j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public transient Object f42544a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f42545b;

    /* renamed from: c, reason: collision with root package name */
    public transient Object[] f42546c;

    /* renamed from: d, reason: collision with root package name */
    public transient Object[] f42547d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f42548e;

    /* renamed from: f, reason: collision with root package name */
    public transient int f42549f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set f42550g;

    /* renamed from: h, reason: collision with root package name */
    public transient Set f42551h;

    /* renamed from: i, reason: collision with root package name */
    public transient Collection f42552i;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        public EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            if (mapG != null) {
                return mapG.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iL = compactHashMap.l(entry.getKey());
                if (iL != -1 && Objects.a(compactHashMap.t()[iL], entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            final CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            return mapG != null ? mapG.entrySet().iterator() : new CompactHashMap<Object, Object>.Itr<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.CompactHashMap.2
                @Override // com.google.common.collect.CompactHashMap.Itr
                public final Object a(int i2) {
                    return new MapEntry(i2);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            if (mapG != null) {
                return mapG.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (compactHashMap.p()) {
                return false;
            }
            int iJ = compactHashMap.j();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj2 = compactHashMap.f42544a;
            java.util.Objects.requireNonNull(obj2);
            int iD = CompactHashing.d(key, value, iJ, obj2, compactHashMap.r(), compactHashMap.s(), compactHashMap.t());
            if (iD == -1) {
                return false;
            }
            compactHashMap.o(iD, iJ);
            compactHashMap.f42549f--;
            compactHashMap.k();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return CompactHashMap.this.size();
        }
    }

    public abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f42557a;

        /* renamed from: b, reason: collision with root package name */
        public int f42558b;

        /* renamed from: c, reason: collision with root package name */
        public int f42559c = -1;

        public Itr() {
            this.f42557a = CompactHashMap.this.f42548e;
            this.f42558b = CompactHashMap.this.h();
        }

        public abstract Object a(int i2);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42558b >= 0;
        }

        @Override // java.util.Iterator
        public final Object next() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (compactHashMap.f42548e != this.f42557a) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i2 = this.f42558b;
            this.f42559c = i2;
            Object objA = a(i2);
            this.f42558b = compactHashMap.i(this.f42558b);
            return objA;
        }

        @Override // java.util.Iterator
        public final void remove() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (compactHashMap.f42548e != this.f42557a) {
                throw new ConcurrentModificationException();
            }
            CollectPreconditions.d(this.f42559c >= 0);
            this.f42557a += 32;
            compactHashMap.remove(compactHashMap.s()[this.f42559c]);
            this.f42558b = compactHashMap.b(this.f42558b, this.f42559c);
            this.f42559c = -1;
        }
    }

    public class KeySetView extends AbstractSet<K> {
        public KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            final CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            return mapG != null ? mapG.keySet().iterator() : new CompactHashMap<Object, Object>.Itr<Object>() { // from class: com.google.common.collect.CompactHashMap.1
                @Override // com.google.common.collect.CompactHashMap.Itr
                public final Object a(int i2) {
                    Object obj = CompactHashMap.f42543j;
                    return CompactHashMap.this.s()[i2];
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            return mapG != null ? mapG.keySet().remove(obj) : compactHashMap.q(obj) != CompactHashMap.f42543j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return CompactHashMap.this.size();
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42562a;

        /* renamed from: b, reason: collision with root package name */
        public int f42563b;

        public MapEntry(int i2) {
            Object obj = CompactHashMap.f42543j;
            this.f42562a = CompactHashMap.this.s()[i2];
            this.f42563b = i2;
        }

        public final void a() {
            int i2 = this.f42563b;
            Object obj = this.f42562a;
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (i2 != -1 && i2 < compactHashMap.size()) {
                if (Objects.a(obj, compactHashMap.s()[this.f42563b])) {
                    return;
                }
            }
            Object obj2 = CompactHashMap.f42543j;
            this.f42563b = compactHashMap.l(obj);
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42562a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            if (mapG != null) {
                return mapG.get(this.f42562a);
            }
            a();
            int i2 = this.f42563b;
            if (i2 == -1) {
                return null;
            }
            return compactHashMap.t()[i2];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            Object obj2 = this.f42562a;
            if (mapG != 0) {
                return mapG.put(obj2, obj);
            }
            a();
            int i2 = this.f42563b;
            if (i2 == -1) {
                compactHashMap.put(obj2, obj);
                return null;
            }
            Object obj3 = compactHashMap.t()[i2];
            compactHashMap.t()[this.f42563b] = obj;
            return obj3;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        public ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            final CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapG = compactHashMap.g();
            return mapG != null ? mapG.values().iterator() : new CompactHashMap<Object, Object>.Itr<Object>() { // from class: com.google.common.collect.CompactHashMap.3
                @Override // com.google.common.collect.CompactHashMap.Itr
                public final Object a(int i2) {
                    Object obj = CompactHashMap.f42543j;
                    return CompactHashMap.this.t()[i2];
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap(int i2) {
        m(i2);
    }

    public static CompactHashMap e() {
        CompactHashMap compactHashMap = new CompactHashMap();
        compactHashMap.m(3);
        return compactHashMap;
    }

    public void a(int i2) {
    }

    public int b(int i2, int i3) {
        return i2 - 1;
    }

    public int c() {
        Preconditions.m("Arrays already allocated", p());
        int i2 = this.f42548e;
        int iMax = Math.max(4, Hashing.a(i2 + 1, 1.0d));
        this.f42544a = CompactHashing.a(iMax);
        this.f42548e = CompactHashing.b(this.f42548e, 32 - Integer.numberOfLeadingZeros(iMax - 1), 31);
        this.f42545b = new int[i2];
        this.f42546c = new Object[i2];
        this.f42547d = new Object[i2];
        return i2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (p()) {
            return;
        }
        k();
        Map mapG = g();
        if (mapG != null) {
            this.f42548e = Ints.c(size(), 3);
            mapG.clear();
            this.f42544a = null;
            this.f42549f = 0;
            return;
        }
        Arrays.fill(s(), 0, this.f42549f, (Object) null);
        Arrays.fill(t(), 0, this.f42549f, (Object) null);
        Object obj = this.f42544a;
        java.util.Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(r(), 0, this.f42549f, 0);
        this.f42549f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapG = g();
        return mapG != null ? mapG.containsKey(obj) : l(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapG = g();
        if (mapG != null) {
            return mapG.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.f42549f; i2++) {
            if (Objects.a(obj, t()[i2])) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map d() {
        LinkedHashMap linkedHashMapF = f(j() + 1);
        int iH = h();
        while (iH >= 0) {
            linkedHashMapF.put(s()[iH], t()[iH]);
            iH = i(iH);
        }
        this.f42544a = linkedHashMapF;
        this.f42545b = null;
        this.f42546c = null;
        this.f42547d = null;
        k();
        return linkedHashMapF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f42551h;
        if (set != null) {
            return set;
        }
        EntrySetView entrySetView = new EntrySetView();
        this.f42551h = entrySetView;
        return entrySetView;
    }

    public LinkedHashMap f(int i2) {
        return new LinkedHashMap(i2, 1.0f);
    }

    public final Map g() {
        Object obj = this.f42544a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapG = g();
        if (mapG != null) {
            return mapG.get(obj);
        }
        int iL = l(obj);
        if (iL == -1) {
            return null;
        }
        a(iL);
        return t()[iL];
    }

    public int h() {
        return isEmpty() ? -1 : 0;
    }

    public int i(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f42549f) {
            return i3;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final int j() {
        return (1 << (this.f42548e & 31)) - 1;
    }

    public final void k() {
        this.f42548e += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f42550g;
        if (set != null) {
            return set;
        }
        KeySetView keySetView = new KeySetView();
        this.f42550g = keySetView;
        return keySetView;
    }

    public final int l(Object obj) {
        if (p()) {
            return -1;
        }
        int iC = Hashing.c(obj);
        int iJ = j();
        Object obj2 = this.f42544a;
        java.util.Objects.requireNonNull(obj2);
        int iE = CompactHashing.e(iC & iJ, obj2);
        if (iE == 0) {
            return -1;
        }
        int i2 = ~iJ;
        int i3 = iC & i2;
        do {
            int i4 = iE - 1;
            int i5 = r()[i4];
            if ((i5 & i2) == i3 && Objects.a(obj, s()[i4])) {
                return i4;
            }
            iE = i5 & iJ;
        } while (iE != 0);
        return -1;
    }

    public void m(int i2) {
        Preconditions.g(i2 >= 0, "Expected size must be >= 0");
        this.f42548e = Ints.c(i2, 1);
    }

    public void n(int i2, Object obj, Object obj2, int i3, int i4) {
        r()[i2] = CompactHashing.b(i3, 0, i4);
        s()[i2] = obj;
        t()[i2] = obj2;
    }

    public void o(int i2, int i3) {
        Object obj = this.f42544a;
        java.util.Objects.requireNonNull(obj);
        int[] iArrR = r();
        Object[] objArrS = s();
        Object[] objArrT = t();
        int size = size();
        int i4 = size - 1;
        if (i2 >= i4) {
            objArrS[i2] = null;
            objArrT[i2] = null;
            iArrR[i2] = 0;
            return;
        }
        Object obj2 = objArrS[i4];
        objArrS[i2] = obj2;
        objArrT[i2] = objArrT[i4];
        objArrS[i4] = null;
        objArrT[i4] = null;
        iArrR[i2] = iArrR[i4];
        iArrR[i4] = 0;
        int iC = Hashing.c(obj2) & i3;
        int iE = CompactHashing.e(iC, obj);
        if (iE == size) {
            CompactHashing.f(iC, i2 + 1, obj);
            return;
        }
        while (true) {
            int i5 = iE - 1;
            int i6 = iArrR[i5];
            int i7 = i6 & i3;
            if (i7 == size) {
                iArrR[i5] = CompactHashing.b(i6, i2 + 1, i3);
                return;
            }
            iE = i7;
        }
    }

    public final boolean p() {
        return this.f42544a == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object put(java.lang.Object r18, java.lang.Object r19) {
        /*
            r17 = this;
            r0 = r17
            r2 = r18
            r3 = r19
            boolean r1 = r0.p()
            if (r1 == 0) goto Lf
            r0.c()
        Lf:
            java.util.Map r1 = r0.g()
            if (r1 == 0) goto L1a
            java.lang.Object r1 = r1.put(r2, r3)
            return r1
        L1a:
            int[] r1 = r0.r()
            java.lang.Object[] r4 = r0.s()
            java.lang.Object[] r5 = r0.t()
            r6 = r1
            int r1 = r0.f42549f
            int r7 = r1 + 1
            r8 = r4
            int r4 = com.google.common.collect.Hashing.c(r2)
            int r9 = r0.j()
            r10 = r4 & r9
            java.lang.Object r11 = r0.f42544a
            java.util.Objects.requireNonNull(r11)
            int r11 = com.google.common.collect.CompactHashing.e(r10, r11)
            r12 = 1
            if (r11 != 0) goto L5b
            if (r7 <= r9) goto L50
            int r5 = com.google.common.collect.CompactHashing.c(r9)
            int r9 = r0.v(r9, r5, r4, r1)
            r5 = r9
            r16 = r12
            goto L9e
        L50:
            java.lang.Object r5 = r0.f42544a
            java.util.Objects.requireNonNull(r5)
            com.google.common.collect.CompactHashing.f(r10, r7, r5)
            r16 = r12
            goto L95
        L5b:
            int r10 = ~r9
            r13 = r4 & r10
            r14 = 0
        L5f:
            int r11 = r11 - r12
            r15 = r6[r11]
            r16 = r12
            r12 = r15 & r10
            if (r12 != r13) goto L78
            r12 = r8[r11]
            boolean r12 = com.google.common.base.Objects.a(r2, r12)
            if (r12 == 0) goto L78
            r1 = r5[r11]
            r5[r11] = r3
            r0.a(r11)
            return r1
        L78:
            r12 = r15 & r9
            int r14 = r14 + 1
            if (r12 != 0) goto Lc5
            r5 = 9
            if (r14 < r5) goto L8b
            java.util.Map r1 = r0.d()
            java.lang.Object r1 = r1.put(r2, r3)
            return r1
        L8b:
            if (r7 <= r9) goto L97
            int r5 = com.google.common.collect.CompactHashing.c(r9)
            int r9 = r0.v(r9, r5, r4, r1)
        L95:
            r5 = r9
            goto L9e
        L97:
            int r5 = com.google.common.collect.CompactHashing.b(r15, r7, r9)
            r6[r11] = r5
            goto L95
        L9e:
            int[] r6 = r0.r()
            int r6 = r6.length
            if (r7 <= r6) goto Lbb
            int r8 = r6 >>> 1
            r11 = r16
            int r8 = java.lang.Math.max(r11, r8)
            int r8 = r8 + r6
            r8 = r8 | r11
            r9 = 1073741823(0x3fffffff, float:1.9999999)
            int r8 = java.lang.Math.min(r9, r8)
            if (r8 == r6) goto Lbb
            r0.u(r8)
        Lbb:
            r0.n(r1, r2, r3, r4, r5)
            r0.f42549f = r7
            r0.k()
            r1 = 0
            return r1
        Lc5:
            r2 = r18
            r3 = r19
            r11 = r12
            r12 = r16
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final Object q(Object obj) {
        boolean zP = p();
        Object obj2 = f42543j;
        if (zP) {
            return obj2;
        }
        int iJ = j();
        Object obj3 = this.f42544a;
        java.util.Objects.requireNonNull(obj3);
        int iD = CompactHashing.d(obj, null, iJ, obj3, r(), s(), null);
        if (iD == -1) {
            return obj2;
        }
        Object obj4 = t()[iD];
        o(iD, iJ);
        this.f42549f--;
        k();
        return obj4;
    }

    public final int[] r() {
        int[] iArr = this.f42545b;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapG = g();
        if (mapG != null) {
            return mapG.remove(obj);
        }
        Object objQ = q(obj);
        if (objQ == f42543j) {
            return null;
        }
        return objQ;
    }

    public final Object[] s() {
        Object[] objArr = this.f42546c;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapG = g();
        return mapG != null ? mapG.size() : this.f42549f;
    }

    public final Object[] t() {
        Object[] objArr = this.f42547d;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    public void u(int i2) {
        this.f42545b = Arrays.copyOf(r(), i2);
        this.f42546c = Arrays.copyOf(s(), i2);
        this.f42547d = Arrays.copyOf(t(), i2);
    }

    public final int v(int i2, int i3, int i4, int i5) {
        Object objA = CompactHashing.a(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            CompactHashing.f(i4 & i6, i5 + 1, objA);
        }
        Object obj = this.f42544a;
        java.util.Objects.requireNonNull(obj);
        int[] iArrR = r();
        for (int i7 = 0; i7 <= i2; i7++) {
            int iE = CompactHashing.e(i7, obj);
            while (iE != 0) {
                int i8 = iE - 1;
                int i9 = iArrR[i8];
                int i10 = ((~i2) & i9) | i7;
                int i11 = i10 & i6;
                int iE2 = CompactHashing.e(i11, objA);
                CompactHashing.f(i11, iE, objA);
                iArrR[i8] = CompactHashing.b(i10, iE2, i6);
                iE = i9 & i2;
            }
        }
        this.f42544a = objA;
        this.f42548e = CompactHashing.b(this.f42548e, 32 - Integer.numberOfLeadingZeros(i6), 31);
        return i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f42552i;
        if (collection != null) {
            return collection;
        }
        ValuesView valuesView = new ValuesView();
        this.f42552i = valuesView;
        return valuesView;
    }
}
