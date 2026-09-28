package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {

    @NotNull
    public static final Companion n = new Companion(null);
    public static final MapBuilder o;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f53645a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f53646b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f53647c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f53648d;

    /* renamed from: e, reason: collision with root package name */
    public int f53649e;

    /* renamed from: f, reason: collision with root package name */
    public int f53650f;

    /* renamed from: g, reason: collision with root package name */
    public int f53651g;

    /* renamed from: h, reason: collision with root package name */
    public int f53652h;

    /* renamed from: i, reason: collision with root package name */
    public int f53653i;

    /* renamed from: j, reason: collision with root package name */
    public MapBuilderKeys f53654j;

    /* renamed from: k, reason: collision with root package name */
    public MapBuilderValues f53655k;

    /* renamed from: l, reason: collision with root package name */
    public MapBuilderEntries f53656l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f53657m;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        @Override // java.util.Iterator
        public final Object next() {
            a();
            int i2 = this.f53662b;
            MapBuilder mapBuilder = this.f53661a;
            if (i2 >= mapBuilder.f53650f) {
                throw new NoSuchElementException();
            }
            this.f53662b = i2 + 1;
            this.f53663c = i2;
            EntryRef entryRef = new EntryRef(mapBuilder, i2);
            b();
            return entryRef;
        }
    }

    @Metadata
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final MapBuilder f53658a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53659b;

        /* renamed from: c, reason: collision with root package name */
        public final int f53660c;

        public EntryRef(MapBuilder map, int i2) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.f53658a = map;
            this.f53659b = i2;
            this.f53660c = map.f53652h;
        }

        public final void a() {
            if (this.f53658a.f53652h != this.f53660c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Intrinsics.b(entry.getKey(), getKey()) && Intrinsics.b(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            a();
            return this.f53658a.f53645a[this.f53659b];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            a();
            Object[] objArr = this.f53658a.f53646b;
            Intrinsics.c(objArr);
            return objArr[this.f53659b];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            a();
            MapBuilder mapBuilder = this.f53658a;
            mapBuilder.c();
            Object[] objArr = mapBuilder.f53646b;
            if (objArr == null) {
                int length = mapBuilder.f53645a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                mapBuilder.f53646b = objArr;
            }
            int i2 = this.f53659b;
            Object obj2 = objArr[i2];
            objArr[i2] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class Itr<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final MapBuilder f53661a;

        /* renamed from: b, reason: collision with root package name */
        public int f53662b;

        /* renamed from: c, reason: collision with root package name */
        public int f53663c;

        /* renamed from: d, reason: collision with root package name */
        public int f53664d;

        public Itr(MapBuilder map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.f53661a = map;
            this.f53663c = -1;
            this.f53664d = map.f53652h;
            b();
        }

        public final void a() {
            if (this.f53661a.f53652h != this.f53664d) {
                throw new ConcurrentModificationException();
            }
        }

        public final void b() {
            while (true) {
                int i2 = this.f53662b;
                MapBuilder mapBuilder = this.f53661a;
                if (i2 >= mapBuilder.f53650f || mapBuilder.f53647c[i2] >= 0) {
                    return;
                } else {
                    this.f53662b = i2 + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.f53662b < this.f53661a.f53650f;
        }

        public final void remove() {
            a();
            if (this.f53663c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            MapBuilder mapBuilder = this.f53661a;
            mapBuilder.c();
            mapBuilder.l(this.f53663c);
            this.f53663c = -1;
            this.f53664d = mapBuilder.f53652h;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public final Object next() {
            a();
            int i2 = this.f53662b;
            MapBuilder mapBuilder = this.f53661a;
            if (i2 >= mapBuilder.f53650f) {
                throw new NoSuchElementException();
            }
            this.f53662b = i2 + 1;
            this.f53663c = i2;
            Object obj = mapBuilder.f53645a[i2];
            b();
            return obj;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        @Override // java.util.Iterator
        public final Object next() {
            a();
            int i2 = this.f53662b;
            MapBuilder mapBuilder = this.f53661a;
            if (i2 >= mapBuilder.f53650f) {
                throw new NoSuchElementException();
            }
            this.f53662b = i2 + 1;
            this.f53663c = i2;
            Object[] objArr = mapBuilder.f53646b;
            Intrinsics.c(objArr);
            Object obj = objArr[this.f53663c];
            b();
            return obj;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.f53657m = true;
        o = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int iJ = j(obj);
            int i2 = this.f53649e * 2;
            int length = this.f53648d.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.f53648d;
                int i4 = iArr[iJ];
                if (i4 <= 0) {
                    int i5 = this.f53650f;
                    Object[] objArr = this.f53645a;
                    if (i5 < objArr.length) {
                        int i6 = i5 + 1;
                        this.f53650f = i6;
                        objArr[i5] = obj;
                        this.f53647c[i5] = iJ;
                        iArr[iJ] = i6;
                        this.f53653i++;
                        this.f53652h++;
                        if (i3 > this.f53649e) {
                            this.f53649e = i3;
                        }
                        return i5;
                    }
                    g(1);
                } else {
                    if (Intrinsics.b(this.f53645a[i4 - 1], obj)) {
                        return -i4;
                    }
                    i3++;
                    if (i3 > i2) {
                        k(this.f53648d.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.f53648d.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final MapBuilder b() {
        c();
        this.f53657m = true;
        if (this.f53653i > 0) {
            return this;
        }
        MapBuilder mapBuilder = o;
        Intrinsics.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void c() {
        if (this.f53657m) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i2 = this.f53650f - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f53647c;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.f53648d[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        ListBuilderKt.c(this.f53645a, 0, this.f53650f);
        Object[] objArr = this.f53646b;
        if (objArr != null) {
            ListBuilderKt.c(objArr, 0, this.f53650f);
        }
        this.f53653i = 0;
        this.f53650f = 0;
        this.f53652h++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z) {
        int i2;
        Object[] objArr = this.f53646b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.f53650f;
            if (i3 >= i2) {
                break;
            }
            int[] iArr = this.f53647c;
            int i5 = iArr[i3];
            if (i5 >= 0) {
                Object[] objArr2 = this.f53645a;
                objArr2[i4] = objArr2[i3];
                if (objArr != null) {
                    objArr[i4] = objArr[i3];
                }
                if (z) {
                    iArr[i4] = i5;
                    this.f53648d[i5] = i4 + 1;
                }
                i4++;
            }
            i3++;
        }
        ListBuilderKt.c(this.f53645a, i4, i2);
        if (objArr != null) {
            ListBuilderKt.c(objArr, i4, this.f53650f);
        }
        this.f53650f = i4;
    }

    public final boolean e(Collection m2) {
        Intrinsics.checkNotNullParameter(m2, "m");
        for (Object obj : m2) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        MapBuilderEntries mapBuilderEntries = this.f53656l;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries mapBuilderEntries2 = new MapBuilderEntries(this);
        this.f53656l = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f53653i == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.f53646b;
        Intrinsics.c(objArr);
        return Intrinsics.b(objArr[iH], entry.getValue());
    }

    public final void g(int i2) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f53645a;
        int length = objArr.length;
        int i3 = this.f53650f;
        int i4 = length - i3;
        int i5 = i3 - this.f53653i;
        if (i4 < i2 && i4 + i5 >= i2 && i5 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i6 = i3 + i2;
        if (i6 < 0) {
            throw new OutOfMemoryError();
        }
        if (i6 > objArr.length) {
            AbstractList.Companion companion = AbstractList.f53584a;
            int length2 = objArr.length;
            companion.getClass();
            int iE = AbstractList.Companion.e(length2, i6);
            Object[] objArr2 = this.f53645a;
            Intrinsics.checkNotNullParameter(objArr2, "<this>");
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, iE);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
            this.f53645a = objArrCopyOf2;
            Object[] objArr3 = this.f53646b;
            if (objArr3 != null) {
                Intrinsics.checkNotNullParameter(objArr3, "<this>");
                objArrCopyOf = Arrays.copyOf(objArr3, iE);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f53646b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f53647c, iE);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f53647c = iArrCopyOf;
            n.getClass();
            int iHighestOneBit = Integer.highestOneBit((iE >= 1 ? iE : 1) * 3);
            if (iHighestOneBit > this.f53648d.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f53646b;
        Intrinsics.c(objArr);
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i2 = this.f53649e;
        while (true) {
            int i3 = this.f53648d[iJ];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (Intrinsics.b(this.f53645a[i4], obj)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.f53648d.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        Intrinsics.checkNotNullParameter(this, "map");
        EntriesItr entriesItr = new EntriesItr(this);
        int i2 = 0;
        while (entriesItr.hasNext()) {
            int i3 = entriesItr.f53662b;
            MapBuilder mapBuilder = entriesItr.f53661a;
            if (i3 >= mapBuilder.f53650f) {
                throw new NoSuchElementException();
            }
            entriesItr.f53662b = i3 + 1;
            entriesItr.f53663c = i3;
            Object obj = mapBuilder.f53645a[i3];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = mapBuilder.f53646b;
            Intrinsics.c(objArr);
            Object obj2 = objArr[entriesItr.f53663c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            entriesItr.b();
            i2 += iHashCode ^ iHashCode2;
        }
        return i2;
    }

    public final int i(Object obj) {
        int i2 = this.f53650f;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f53647c[i2] >= 0) {
                Object[] objArr = this.f53646b;
                Intrinsics.c(objArr);
                if (Intrinsics.b(objArr[i2], obj)) {
                    return i2;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f53653i == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f53651g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        r3[r0] = r6;
        r5.f53647c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.f53652h
            int r0 = r0 + 1
            r5.f53652h = r0
            int r0 = r5.f53650f
            int r1 = r5.f53653i
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f53648d = r0
            kotlin.collections.builders.MapBuilder$Companion r0 = kotlin.collections.builders.MapBuilder.n
            r0.getClass()
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f53651g = r6
        L21:
            int r6 = r5.f53650f
            if (r2 >= r6) goto L55
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f53645a
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.f53649e
        L31:
            int[] r3 = r5.f53648d
            r4 = r3[r0]
            if (r4 != 0) goto L3f
            r3[r0] = r6
            int[] r1 = r5.f53647c
            r1[r2] = r0
            r2 = r6
            goto L21
        L3f:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L4d
            int r4 = r0 + (-1)
            if (r0 != 0) goto L4b
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L31
        L4b:
            r0 = r4
            goto L31
        L4d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        MapBuilderKeys mapBuilderKeys = this.f53654j;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this);
        this.f53654j = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0027->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f53645a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r2 = 0
            r0[r12] = r2
            java.lang.Object[] r0 = r11.f53646b
            if (r0 == 0) goto L13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0[r12] = r2
        L13:
            int[] r0 = r11.f53647c
            r0 = r0[r12]
            int r1 = r11.f53649e
            int r1 = r1 * 2
            int[] r2 = r11.f53648d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L23
            r1 = r2
        L23:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L27:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L31
            int[] r0 = r11.f53648d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L32
        L31:
            r0 = r5
        L32:
            int r4 = r4 + 1
            int r5 = r11.f53649e
            r6 = -1
            if (r4 <= r5) goto L3e
            int[] r0 = r11.f53648d
            r0[r1] = r2
            goto L6f
        L3e:
            int[] r5 = r11.f53648d
            r7 = r5[r0]
            if (r7 != 0) goto L47
            r5[r1] = r2
            goto L6f
        L47:
            if (r7 >= 0) goto L4e
            r5[r1] = r6
        L4b:
            r1 = r0
            r4 = r2
            goto L68
        L4e:
            java.lang.Object[] r5 = r11.f53645a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f53648d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L68
            r9[r1] = r7
            int[] r4 = r11.f53647c
            r4[r8] = r1
            goto L4b
        L68:
            int r3 = r3 + r6
            if (r3 >= 0) goto L27
            int[] r0 = r11.f53648d
            r0[r1] = r6
        L6f:
            int[] r0 = r11.f53647c
            r0[r12] = r6
            int r12 = r11.f53653i
            int r12 = r12 + r6
            r11.f53653i = r12
            int r12 = r11.f53652h
            int r12 = r12 + 1
            r11.f53652h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f53646b;
        if (objArr == null) {
            int length = this.f53645a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f53646b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i2 = (-iA) - 1;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        c();
        Set<Map.Entry<K, V>> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry<K, V> entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f53646b;
            if (objArr == null) {
                int length = this.f53645a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f53646b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i2 = (-iA) - 1;
                if (!Intrinsics.b(entry.getValue(), objArr[i2])) {
                    objArr[i2] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f53646b;
        Intrinsics.c(objArr);
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f53653i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f53653i * 3) + 2);
        sb.append("{");
        Intrinsics.checkNotNullParameter(this, "map");
        EntriesItr entriesItr = new EntriesItr(this);
        int i2 = 0;
        while (entriesItr.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Intrinsics.checkNotNullParameter(sb, "sb");
            int i3 = entriesItr.f53662b;
            MapBuilder mapBuilder = entriesItr.f53661a;
            if (i3 >= mapBuilder.f53650f) {
                throw new NoSuchElementException();
            }
            entriesItr.f53662b = i3 + 1;
            entriesItr.f53663c = i3;
            Object obj = mapBuilder.f53645a[i3];
            if (obj == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = mapBuilder.f53646b;
            Intrinsics.c(objArr);
            Object obj2 = objArr[entriesItr.f53663c];
            if (obj2 == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            entriesItr.b();
            i2++;
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        MapBuilderValues mapBuilderValues = this.f53655k;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues mapBuilderValues2 = new MapBuilderValues(this);
        this.f53655k = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public MapBuilder(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i2];
        int[] iArr = new int[i2];
        n.getClass();
        int iHighestOneBit = Integer.highestOneBit((i2 < 1 ? 1 : i2) * 3);
        this.f53645a = objArr;
        this.f53646b = null;
        this.f53647c = iArr;
        this.f53648d = new int[iHighestOneBit];
        this.f53649e = 2;
        this.f53650f = 0;
        this.f53651g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
