package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient Object[] f42626a;

    /* renamed from: b, reason: collision with root package name */
    public transient Object[] f42627b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f42628c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f42629d;

    /* renamed from: e, reason: collision with root package name */
    public transient int[] f42630e;

    /* renamed from: f, reason: collision with root package name */
    public transient int[] f42631f;

    /* renamed from: g, reason: collision with root package name */
    public transient int[] f42632g;

    /* renamed from: h, reason: collision with root package name */
    public transient int[] f42633h;

    /* renamed from: i, reason: collision with root package name */
    public transient int f42634i;

    /* renamed from: j, reason: collision with root package name */
    public transient int f42635j;

    /* renamed from: k, reason: collision with root package name */
    public transient int[] f42636k;

    /* renamed from: l, reason: collision with root package name */
    public transient int[] f42637l;

    /* renamed from: m, reason: collision with root package name */
    public transient Set f42638m;
    public transient Set n;
    public transient Set o;
    public transient BiMap p;

    public final class EntryForKey extends AbstractMapEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42639a;

        /* renamed from: b, reason: collision with root package name */
        public int f42640b;

        public EntryForKey(int i2) {
            this.f42639a = HashBiMap.this.f42626a[i2];
            this.f42640b = i2;
        }

        public final void a() {
            int i2 = this.f42640b;
            HashBiMap hashBiMap = HashBiMap.this;
            Object obj = this.f42639a;
            if (i2 == -1 || i2 > hashBiMap.f42628c || !Objects.a(hashBiMap.f42626a[i2], obj)) {
                this.f42640b = hashBiMap.f(Hashing.c(obj), obj);
            }
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42639a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            a();
            int i2 = this.f42640b;
            if (i2 == -1) {
                return null;
            }
            return HashBiMap.this.f42627b[i2];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            a();
            int i2 = this.f42640b;
            HashBiMap hashBiMap = HashBiMap.this;
            if (i2 == -1) {
                hashBiMap.k(this.f42639a, obj, false);
                return null;
            }
            Object obj2 = hashBiMap.f42627b[i2];
            if (Objects.a(obj2, obj)) {
                return obj;
            }
            hashBiMap.q(this.f42640b, obj, false);
            return obj2;
        }
    }

    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {

        /* renamed from: a, reason: collision with root package name */
        public final HashBiMap f42642a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f42643b;

        /* renamed from: c, reason: collision with root package name */
        public int f42644c;

        public EntryForValue(HashBiMap hashBiMap, int i2) {
            this.f42642a = hashBiMap;
            this.f42643b = hashBiMap.f42627b[i2];
            this.f42644c = i2;
        }

        public final void a() {
            int i2 = this.f42644c;
            Object obj = this.f42643b;
            HashBiMap hashBiMap = this.f42642a;
            if (i2 == -1 || i2 > hashBiMap.f42628c || !Objects.a(obj, hashBiMap.f42627b[i2])) {
                hashBiMap.getClass();
                this.f42644c = hashBiMap.g(Hashing.c(obj), obj);
            }
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42643b;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            a();
            int i2 = this.f42644c;
            if (i2 == -1) {
                return null;
            }
            return this.f42642a.f42626a[i2];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            a();
            int i2 = this.f42644c;
            HashBiMap hashBiMap = this.f42642a;
            if (i2 == -1) {
                hashBiMap.l(this.f42643b, obj, false);
                return null;
            }
            Object obj2 = hashBiMap.f42626a[i2];
            if (Objects.a(obj2, obj)) {
                return obj;
            }
            hashBiMap.p(this.f42644c, obj, false);
            return obj2;
        }
    }

    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        public EntrySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public final Object b(int i2) {
            return new EntryForKey(i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            HashBiMap hashBiMap = HashBiMap.this;
            int iF = hashBiMap.f(Hashing.c(key), key);
            return iF != -1 && Objects.a(value, hashBiMap.f42627b[iF]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iC = Hashing.c(key);
            HashBiMap hashBiMap = HashBiMap.this;
            int iF = hashBiMap.f(iC, key);
            if (iF == -1 || !Objects.a(value, hashBiMap.f42627b[iF])) {
                return false;
            }
            hashBiMap.n(iF, iC);
            return true;
        }
    }

    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final HashBiMap f42646a;

        /* renamed from: b, reason: collision with root package name */
        public transient Set f42647b;

        public Inverse(HashBiMap hashBiMap) {
            this.f42646a = hashBiMap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f42646a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return this.f42646a.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object obj) {
            return this.f42646a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set entrySet() {
            Set set = this.f42647b;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.f42646a);
            this.f42647b = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            HashBiMap hashBiMap = this.f42646a;
            hashBiMap.getClass();
            int iG = hashBiMap.g(Hashing.c(obj), obj);
            if (iG == -1) {
                return null;
            }
            return hashBiMap.f42626a[iG];
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return this.f42646a.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            return this.f42646a.l(obj, obj2, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            HashBiMap hashBiMap = this.f42646a;
            hashBiMap.getClass();
            int iC = Hashing.c(obj);
            int iG = hashBiMap.g(iC, obj);
            if (iG == -1) {
                return null;
            }
            Object obj2 = hashBiMap.f42626a[iG];
            hashBiMap.o(iG, iC);
            return obj2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f42646a.f42628c;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public final Collection values() {
            return this.f42646a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public final Set values() {
            return this.f42646a.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        @Override // com.google.common.collect.HashBiMap.View
        public final Object b(int i2) {
            return new EntryForValue(this.f42650a, i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            HashBiMap hashBiMap = this.f42650a;
            hashBiMap.getClass();
            int iG = hashBiMap.g(Hashing.c(key), key);
            return iG != -1 && Objects.a(hashBiMap.f42626a[iG], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iC = Hashing.c(key);
            HashBiMap hashBiMap = this.f42650a;
            int iG = hashBiMap.g(iC, key);
            if (iG == -1 || !Objects.a(hashBiMap.f42626a[iG], value)) {
                return false;
            }
            hashBiMap.o(iG, iC);
            return true;
        }
    }

    public final class KeySet extends View<K, V, K> {
        public KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public final Object b(int i2) {
            return HashBiMap.this.f42626a[i2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            int iC = Hashing.c(obj);
            HashBiMap hashBiMap = HashBiMap.this;
            int iF = hashBiMap.f(iC, obj);
            if (iF == -1) {
                return false;
            }
            hashBiMap.n(iF, iC);
            return true;
        }
    }

    public final class ValueSet extends View<K, V, V> {
        public ValueSet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public final Object b(int i2) {
            return HashBiMap.this.f42627b[i2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            int iC = Hashing.c(obj);
            HashBiMap hashBiMap = HashBiMap.this;
            int iG = hashBiMap.g(iC, obj);
            if (iG == -1) {
                return false;
            }
            hashBiMap.o(iG, iC);
            return true;
        }
    }

    public static abstract class View<K, V, T> extends AbstractSet<T> {

        /* renamed from: a, reason: collision with root package name */
        public final HashBiMap f42650a;

        public View(HashBiMap hashBiMap) {
            this.f42650a = hashBiMap;
        }

        public abstract Object b(int i2);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f42650a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new Iterator<Object>() { // from class: com.google.common.collect.HashBiMap.View.1

                /* renamed from: a, reason: collision with root package name */
                public int f42651a;

                /* renamed from: b, reason: collision with root package name */
                public int f42652b;

                /* renamed from: c, reason: collision with root package name */
                public int f42653c;

                /* renamed from: d, reason: collision with root package name */
                public int f42654d;

                {
                    HashBiMap hashBiMap = View.this.f42650a;
                    this.f42651a = hashBiMap.f42634i;
                    this.f42652b = -1;
                    this.f42653c = hashBiMap.f42629d;
                    this.f42654d = hashBiMap.f42628c;
                }

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    if (View.this.f42650a.f42629d == this.f42653c) {
                        return this.f42651a != -2 && this.f42654d > 0;
                    }
                    throw new ConcurrentModificationException();
                }

                @Override // java.util.Iterator
                public final Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int i2 = this.f42651a;
                    View view = View.this;
                    Object objB = view.b(i2);
                    int i3 = this.f42651a;
                    this.f42652b = i3;
                    this.f42651a = view.f42650a.f42637l[i3];
                    this.f42654d--;
                    return objB;
                }

                @Override // java.util.Iterator
                public final void remove() {
                    View view = View.this;
                    if (view.f42650a.f42629d != this.f42653c) {
                        throw new ConcurrentModificationException();
                    }
                    CollectPreconditions.d(this.f42652b != -1);
                    int i2 = this.f42652b;
                    HashBiMap hashBiMap = view.f42650a;
                    hashBiMap.n(i2, Hashing.c(hashBiMap.f42626a[i2]));
                    if (this.f42651a == hashBiMap.f42628c) {
                        this.f42651a = this.f42652b;
                    }
                    this.f42652b = -1;
                    this.f42653c = hashBiMap.f42629d;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f42650a.f42628c;
        }
    }

    public HashBiMap() {
        CollectPreconditions.b(16, "expectedSize");
        int iA = Hashing.a(16, 1.0d);
        this.f42628c = 0;
        this.f42626a = new Object[16];
        this.f42627b = new Object[16];
        this.f42630e = b(iA);
        this.f42631f = b(iA);
        this.f42632g = b(16);
        this.f42633h = b(16);
        this.f42634i = -2;
        this.f42635j = -2;
        this.f42636k = b(16);
        this.f42637l = b(16);
    }

    public static int[] b(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final int a(int i2) {
        return i2 & (this.f42630e.length - 1);
    }

    public final void c(int i2, int i3) {
        Preconditions.f(i2 != -1);
        int iA = a(i3);
        int[] iArr = this.f42630e;
        int i4 = iArr[iA];
        if (i4 == i2) {
            int[] iArr2 = this.f42632g;
            iArr[iA] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i5 = this.f42632g[i4];
        while (true) {
            int i6 = i4;
            i4 = i5;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.f42626a[i2]);
            }
            if (i4 == i2) {
                int[] iArr3 = this.f42632g;
                iArr3[i6] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            }
            i5 = this.f42632g[i4];
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.f42626a, 0, this.f42628c, (Object) null);
        Arrays.fill(this.f42627b, 0, this.f42628c, (Object) null);
        Arrays.fill(this.f42630e, -1);
        Arrays.fill(this.f42631f, -1);
        Arrays.fill(this.f42632g, 0, this.f42628c, -1);
        Arrays.fill(this.f42633h, 0, this.f42628c, -1);
        Arrays.fill(this.f42636k, 0, this.f42628c, -1);
        Arrays.fill(this.f42637l, 0, this.f42628c, -1);
        this.f42628c = 0;
        this.f42634i = -2;
        this.f42635j = -2;
        this.f42629d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return f(Hashing.c(obj), obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return g(Hashing.c(obj), obj) != -1;
    }

    public final void d(int i2, int i3) {
        Preconditions.f(i2 != -1);
        int iA = a(i3);
        int[] iArr = this.f42631f;
        int i4 = iArr[iA];
        if (i4 == i2) {
            int[] iArr2 = this.f42633h;
            iArr[iA] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i5 = this.f42633h[i4];
        while (true) {
            int i6 = i4;
            i4 = i5;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.f42627b[i2]);
            }
            if (i4 == i2) {
                int[] iArr3 = this.f42633h;
                iArr3[i6] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            }
            i5 = this.f42633h[i4];
        }
    }

    public final void e(int i2) {
        int[] iArr = this.f42632g;
        if (iArr.length < i2) {
            int iA = ImmutableCollection.Builder.a(iArr.length, i2);
            this.f42626a = Arrays.copyOf(this.f42626a, iA);
            this.f42627b = Arrays.copyOf(this.f42627b, iA);
            int[] iArr2 = this.f42632g;
            int length = iArr2.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr2, iA);
            Arrays.fill(iArrCopyOf, length, iA, -1);
            this.f42632g = iArrCopyOf;
            int[] iArr3 = this.f42633h;
            int length2 = iArr3.length;
            int[] iArrCopyOf2 = Arrays.copyOf(iArr3, iA);
            Arrays.fill(iArrCopyOf2, length2, iA, -1);
            this.f42633h = iArrCopyOf2;
            int[] iArr4 = this.f42636k;
            int length3 = iArr4.length;
            int[] iArrCopyOf3 = Arrays.copyOf(iArr4, iA);
            Arrays.fill(iArrCopyOf3, length3, iA, -1);
            this.f42636k = iArrCopyOf3;
            int[] iArr5 = this.f42637l;
            int length4 = iArr5.length;
            int[] iArrCopyOf4 = Arrays.copyOf(iArr5, iA);
            Arrays.fill(iArrCopyOf4, length4, iA, -1);
            this.f42637l = iArrCopyOf4;
        }
        if (this.f42630e.length < i2) {
            int iA2 = Hashing.a(i2, 1.0d);
            this.f42630e = b(iA2);
            this.f42631f = b(iA2);
            for (int i3 = 0; i3 < this.f42628c; i3++) {
                int iA3 = a(Hashing.c(this.f42626a[i3]));
                int[] iArr6 = this.f42632g;
                int[] iArr7 = this.f42630e;
                iArr6[i3] = iArr7[iA3];
                iArr7[iA3] = i3;
                int iA4 = a(Hashing.c(this.f42627b[i3]));
                int[] iArr8 = this.f42633h;
                int[] iArr9 = this.f42631f;
                iArr8[i3] = iArr9[iA4];
                iArr9[iA4] = i3;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.o;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.o = entrySet;
        return entrySet;
    }

    public final int f(int i2, Object obj) {
        int[] iArr = this.f42630e;
        int[] iArr2 = this.f42632g;
        Object[] objArr = this.f42626a;
        for (int i3 = iArr[a(i2)]; i3 != -1; i3 = iArr2[i3]) {
            if (Objects.a(objArr[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    public final int g(int i2, Object obj) {
        int[] iArr = this.f42631f;
        int[] iArr2 = this.f42633h;
        Object[] objArr = this.f42627b;
        for (int i3 = iArr[a(i2)]; i3 != -1; i3 = iArr2[i3]) {
            if (Objects.a(objArr[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        int iF = f(Hashing.c(obj), obj);
        if (iF == -1) {
            return null;
        }
        return this.f42627b[iF];
    }

    public final void h(int i2, int i3) {
        Preconditions.f(i2 != -1);
        int iA = a(i3);
        int[] iArr = this.f42632g;
        int[] iArr2 = this.f42630e;
        iArr[i2] = iArr2[iA];
        iArr2[iA] = i2;
    }

    public final void i(int i2, int i3) {
        Preconditions.f(i2 != -1);
        int iA = a(i3);
        int[] iArr = this.f42633h;
        int[] iArr2 = this.f42631f;
        iArr[i2] = iArr2[iA];
        iArr2[iA] = i2;
    }

    public final BiMap j() {
        BiMap biMap = this.p;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.p = inverse;
        return inverse;
    }

    public final Object k(Object obj, Object obj2, boolean z) {
        int iC = Hashing.c(obj);
        int iF = f(iC, obj);
        if (iF != -1) {
            Object obj3 = this.f42627b[iF];
            if (Objects.a(obj3, obj2)) {
                return obj2;
            }
            q(iF, obj2, z);
            return obj3;
        }
        int iC2 = Hashing.c(obj2);
        int iG = g(iC2, obj2);
        if (!z) {
            Preconditions.h(iG == -1, "Value already present: %s", obj2);
        } else if (iG != -1) {
            o(iG, iC2);
        }
        e(this.f42628c + 1);
        Object[] objArr = this.f42626a;
        int i2 = this.f42628c;
        objArr[i2] = obj;
        this.f42627b[i2] = obj2;
        h(i2, iC);
        i(this.f42628c, iC2);
        r(this.f42635j, this.f42628c);
        r(this.f42628c, -2);
        this.f42628c++;
        this.f42629d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f42638m;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f42638m = keySet;
        return keySet;
    }

    public final Object l(Object obj, Object obj2, boolean z) {
        int iC = Hashing.c(obj);
        int iG = g(iC, obj);
        if (iG != -1) {
            Object obj3 = this.f42626a[iG];
            if (Objects.a(obj3, obj2)) {
                return obj2;
            }
            p(iG, obj2, z);
            return obj3;
        }
        int i2 = this.f42635j;
        int iC2 = Hashing.c(obj2);
        int iF = f(iC2, obj2);
        if (!z) {
            Preconditions.h(iF == -1, "Key already present: %s", obj2);
        } else if (iF != -1) {
            i2 = this.f42636k[iF];
            n(iF, iC2);
        }
        e(this.f42628c + 1);
        Object[] objArr = this.f42626a;
        int i3 = this.f42628c;
        objArr[i3] = obj2;
        this.f42627b[i3] = obj;
        h(i3, iC2);
        i(this.f42628c, iC);
        int i4 = i2 == -2 ? this.f42634i : this.f42637l[i2];
        r(i2, this.f42628c);
        r(this.f42628c, i4);
        this.f42628c++;
        this.f42629d++;
        return null;
    }

    public final void m(int i2, int i3, int i4) {
        int i5;
        int i6;
        Preconditions.f(i2 != -1);
        c(i2, i3);
        d(i2, i4);
        r(this.f42636k[i2], this.f42637l[i2]);
        int i7 = this.f42628c - 1;
        if (i7 != i2) {
            int i8 = this.f42636k[i7];
            int i9 = this.f42637l[i7];
            r(i8, i2);
            r(i2, i9);
            Object[] objArr = this.f42626a;
            Object obj = objArr[i7];
            Object[] objArr2 = this.f42627b;
            Object obj2 = objArr2[i7];
            objArr[i2] = obj;
            objArr2[i2] = obj2;
            int iA = a(Hashing.c(obj));
            int[] iArr = this.f42630e;
            int i10 = iArr[iA];
            if (i10 == i7) {
                iArr[iA] = i2;
            } else {
                int i11 = this.f42632g[i10];
                while (true) {
                    i5 = i10;
                    i10 = i11;
                    if (i10 == i7) {
                        break;
                    } else {
                        i11 = this.f42632g[i10];
                    }
                }
                this.f42632g[i5] = i2;
            }
            int[] iArr2 = this.f42632g;
            iArr2[i2] = iArr2[i7];
            iArr2[i7] = -1;
            int iA2 = a(Hashing.c(obj2));
            int[] iArr3 = this.f42631f;
            int i12 = iArr3[iA2];
            if (i12 == i7) {
                iArr3[iA2] = i2;
            } else {
                int i13 = this.f42633h[i12];
                while (true) {
                    i6 = i12;
                    i12 = i13;
                    if (i12 == i7) {
                        break;
                    } else {
                        i13 = this.f42633h[i12];
                    }
                }
                this.f42633h[i6] = i2;
            }
            int[] iArr4 = this.f42633h;
            iArr4[i2] = iArr4[i7];
            iArr4[i7] = -1;
        }
        Object[] objArr3 = this.f42626a;
        int i14 = this.f42628c;
        objArr3[i14 - 1] = null;
        this.f42627b[i14 - 1] = null;
        this.f42628c = i14 - 1;
        this.f42629d++;
    }

    public final void n(int i2, int i3) {
        m(i2, i3, Hashing.c(this.f42627b[i2]));
    }

    public final void o(int i2, int i3) {
        m(i2, Hashing.c(this.f42626a[i2]), i3);
    }

    public final void p(int i2, Object obj, boolean z) {
        int i3;
        Preconditions.f(i2 != -1);
        int iC = Hashing.c(obj);
        int iF = f(iC, obj);
        int i4 = this.f42635j;
        if (iF == -1) {
            i3 = -2;
        } else {
            if (!z) {
                throw new IllegalArgumentException(android.support.v4.media.b.j(obj, "Key already present in map: "));
            }
            i4 = this.f42636k[iF];
            i3 = this.f42637l[iF];
            n(iF, iC);
            if (i2 == this.f42628c) {
                i2 = iF;
            }
        }
        if (i4 == i2) {
            i4 = this.f42636k[i2];
        } else if (i4 == this.f42628c) {
            i4 = iF;
        }
        if (i3 == i2) {
            iF = this.f42637l[i2];
        } else if (i3 != this.f42628c) {
            iF = i3;
        }
        r(this.f42636k[i2], this.f42637l[i2]);
        c(i2, Hashing.c(this.f42626a[i2]));
        this.f42626a[i2] = obj;
        h(i2, Hashing.c(obj));
        r(i4, i2);
        r(i2, iF);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return k(obj, obj2, false);
    }

    public final void q(int i2, Object obj, boolean z) {
        Preconditions.f(i2 != -1);
        int iC = Hashing.c(obj);
        int iG = g(iC, obj);
        if (iG != -1) {
            if (!z) {
                throw new IllegalArgumentException(android.support.v4.media.b.j(obj, "Value already present in map: "));
            }
            o(iG, iC);
            if (i2 == this.f42628c) {
                i2 = iG;
            }
        }
        d(i2, Hashing.c(this.f42627b[i2]));
        this.f42627b[i2] = obj;
        i(i2, iC);
    }

    public final void r(int i2, int i3) {
        if (i2 == -2) {
            this.f42634i = i3;
        } else {
            this.f42637l[i2] = i3;
        }
        if (i3 == -2) {
            this.f42635j = i2;
        } else {
            this.f42636k[i3] = i2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        int iC = Hashing.c(obj);
        int iF = f(iC, obj);
        if (iF == -1) {
            return null;
        }
        Object obj2 = this.f42627b[iF];
        n(iF, iC);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f42628c;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public final Set values() {
        Set set = this.n;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.n = valueSet;
        return valueSet;
    }
}
