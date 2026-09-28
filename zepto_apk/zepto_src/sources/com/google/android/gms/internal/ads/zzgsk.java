package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzgsk extends AbstractMap implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f33155j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public transient Object f33156a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f33157b;

    /* renamed from: c, reason: collision with root package name */
    public transient Object[] f33158c;

    /* renamed from: d, reason: collision with root package name */
    public transient Object[] f33159d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f33160e = Math.min(Math.max(3, 1), 1073741823);

    /* renamed from: f, reason: collision with root package name */
    public transient int f33161f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set f33162g;

    /* renamed from: h, reason: collision with root package name */
    public transient Set f33163h;

    /* renamed from: i, reason: collision with root package name */
    public transient Collection f33164i;

    public zzgsk() {
    }

    public final int[] a() {
        int[] iArr = this.f33157b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] b() {
        Object[] objArr = this.f33158c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] c() {
        Object[] objArr = this.f33159d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (d()) {
            return;
        }
        this.f33160e += 32;
        Map mapE = e();
        if (mapE != null) {
            this.f33160e = Math.min(Math.max(size(), 3), 1073741823);
            mapE.clear();
            this.f33156a = null;
            this.f33161f = 0;
            return;
        }
        Arrays.fill(b(), 0, this.f33161f, (Object) null);
        Arrays.fill(c(), 0, this.f33161f, (Object) null);
        Object obj = this.f33156a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(a(), 0, this.f33161f, 0);
        this.f33161f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapE = e();
        return mapE != null ? mapE.containsKey(obj) : i(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapE = e();
        if (mapE != null) {
            return mapE.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.f33161f; i2++) {
            if (Objects.equals(obj, c()[i2])) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        return this.f33156a == null;
    }

    public final Map e() {
        Object obj = this.f33156a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f33163h;
        if (set != null) {
            return set;
        }
        zzgsf zzgsfVar = new zzgsf(this);
        this.f33163h = zzgsfVar;
        return zzgsfVar;
    }

    public final void f(int i2, int i3) {
        Object obj = this.f33156a;
        Objects.requireNonNull(obj);
        int[] iArrA = a();
        Object[] objArrB = b();
        Object[] objArrC = c();
        int size = size();
        int i4 = size - 1;
        if (i2 >= i4) {
            objArrB[i2] = null;
            objArrC[i2] = null;
            iArrA[i2] = 0;
            return;
        }
        int i5 = i2 + 1;
        Object obj2 = objArrB[i4];
        objArrB[i2] = obj2;
        objArrC[i2] = objArrC[i4];
        objArrB[i4] = null;
        objArrC[i4] = null;
        iArrA[i2] = iArrA[i4];
        iArrA[i4] = 0;
        int iB = zzgsw.b(obj2) & i3;
        int iB2 = zzgsl.b(iB, obj);
        if (iB2 == size) {
            zzgsl.c(iB, i5, obj);
            return;
        }
        while (true) {
            int i6 = iB2 - 1;
            int i7 = iArrA[i6];
            int i8 = i7 & i3;
            if (i8 == size) {
                iArrA[i6] = (i7 & (~i3)) | (i3 & i5);
                return;
            }
            iB2 = i8;
        }
    }

    public final int g() {
        return (1 << (this.f33160e & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapE = e();
        if (mapE != null) {
            return mapE.get(obj);
        }
        int i2 = i(obj);
        if (i2 == -1) {
            return null;
        }
        return c()[i2];
    }

    public final int h(int i2, int i3, int i4, int i5) {
        int i6 = i3 - 1;
        Object objA = zzgsl.a(i3);
        if (i5 != 0) {
            zzgsl.c(i4 & i6, i5 + 1, objA);
        }
        Object obj = this.f33156a;
        Objects.requireNonNull(obj);
        int[] iArrA = a();
        for (int i7 = 0; i7 <= i2; i7++) {
            int iB = zzgsl.b(i7, obj);
            while (iB != 0) {
                int i8 = iB - 1;
                int i9 = iArrA[i8];
                int i10 = ((~i2) & i9) | i7;
                int i11 = i10 & i6;
                int iB2 = zzgsl.b(i11, objA);
                zzgsl.c(i11, iB, objA);
                iArrA[i8] = ((~i6) & i10) | (iB2 & i6);
                iB = i9 & i2;
            }
        }
        this.f33156a = objA;
        this.f33160e = ((32 - Integer.numberOfLeadingZeros(i6)) & 31) | (this.f33160e & (-32));
        return i6;
    }

    public final int i(Object obj) {
        if (d()) {
            return -1;
        }
        int iB = zzgsw.b(obj);
        int iG = g();
        Object obj2 = this.f33156a;
        Objects.requireNonNull(obj2);
        int iB2 = zzgsl.b(iB & iG, obj2);
        if (iB2 != 0) {
            int i2 = ~iG;
            int i3 = iB & i2;
            do {
                int i4 = iB2 - 1;
                int i5 = a()[i4];
                if ((i5 & i2) == i3 && Objects.equals(obj, b()[i4])) {
                    return i4;
                }
                iB2 = i5 & iG;
            } while (iB2 != 0);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object j(Object obj) {
        if (!d()) {
            int iG = g();
            Object obj2 = this.f33156a;
            Objects.requireNonNull(obj2);
            int iD = zzgsl.d(obj, null, iG, obj2, a(), b(), null);
            if (iD != -1) {
                Object obj3 = c()[iD];
                f(iD, iG);
                this.f33161f--;
                this.f33160e += 32;
                return obj3;
            }
        }
        return f33155j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f33162g;
        if (set != null) {
            return set;
        }
        zzgsh zzgshVar = new zzgsh(this);
        this.f33162g = zzgshVar;
        return zzgshVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i2;
        int i3 = 32;
        if (d()) {
            zzgqa.g("Arrays already allocated", d());
            int i4 = this.f33160e;
            int iMax = Math.max(i4 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.f33156a = zzgsl.a(iMax2);
            this.f33160e = ((32 - Integer.numberOfLeadingZeros(iMax2 - 1)) & 31) | (this.f33160e & (-32));
            this.f33157b = new int[i4];
            this.f33158c = new Object[i4];
            this.f33159d = new Object[i4];
        }
        Map mapE = e();
        if (mapE != null) {
            return mapE.put(obj, obj2);
        }
        int[] iArrA = a();
        Object[] objArrB = b();
        Object[] objArrC = c();
        int i5 = this.f33161f;
        int i6 = i5 + 1;
        int iB = zzgsw.b(obj);
        int iG = g();
        int i7 = iB & iG;
        Object obj3 = this.f33156a;
        Objects.requireNonNull(obj3);
        int iB2 = zzgsl.b(i7, obj3);
        if (iB2 == 0) {
            if (i6 > iG) {
                iG = h(iG, (iG + 1) * (iG < 32 ? 4 : 2), iB, i5);
            } else {
                Object obj4 = this.f33156a;
                Objects.requireNonNull(obj4);
                zzgsl.c(i7, i6, obj4);
            }
            i2 = 1;
        } else {
            int i8 = ~iG;
            int i9 = iB & i8;
            int i10 = 0;
            while (true) {
                int i11 = iB2 - 1;
                int i12 = iArrA[i11];
                i2 = 1;
                int i13 = i12 & i8;
                int i14 = i3;
                if (i13 == i9 && Objects.equals(obj, objArrB[i11])) {
                    Object obj5 = objArrC[i11];
                    objArrC[i11] = obj2;
                    return obj5;
                }
                int i15 = i12 & iG;
                int i16 = i10 + 1;
                if (i15 != 0) {
                    i10 = i16;
                    iB2 = i15;
                    i3 = i14;
                } else {
                    if (i16 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(g() + 1, 1.0f);
                        int i17 = isEmpty() ? -1 : 0;
                        while (i17 >= 0) {
                            linkedHashMap.put(b()[i17], c()[i17]);
                            int i18 = i17 + 1;
                            i17 = i18 < this.f33161f ? i18 : -1;
                        }
                        this.f33156a = linkedHashMap;
                        this.f33157b = null;
                        this.f33158c = null;
                        this.f33159d = null;
                        this.f33160e += 32;
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i6 > iG) {
                        iG = h(iG, (iG + 1) * (iG < i14 ? 4 : 2), iB, i5);
                    } else {
                        iArrA[i11] = i13 | (i6 & iG);
                    }
                }
            }
        }
        int length = a().length;
        if (i6 > length) {
            int i19 = i2;
            int iMin = Math.min(1073741823, (Math.max(i19, length >>> 1) + length) | i19);
            if (iMin != length) {
                this.f33157b = Arrays.copyOf(a(), iMin);
                this.f33158c = Arrays.copyOf(b(), iMin);
                this.f33159d = Arrays.copyOf(c(), iMin);
            }
        }
        a()[i5] = (~iG) & iB;
        b()[i5] = obj;
        c()[i5] = obj2;
        this.f33161f = i6;
        this.f33160e += 32;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapE = e();
        if (mapE != null) {
            return mapE.remove(obj);
        }
        Object objJ = j(obj);
        if (objJ == f33155j) {
            return null;
        }
        return objJ;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapE = e();
        return mapE != null ? mapE.size() : this.f33161f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f33164i;
        if (collection != null) {
            return collection;
        }
        zzgsj zzgsjVar = new zzgsj(this);
        this.f33164i = zzgsjVar;
        return zzgsjVar;
    }

    public zzgsk(int i2) {
    }
}
