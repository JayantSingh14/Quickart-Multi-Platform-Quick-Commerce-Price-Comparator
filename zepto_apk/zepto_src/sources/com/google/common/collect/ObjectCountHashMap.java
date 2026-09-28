package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multisets;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class ObjectCountHashMap<K> {

    /* renamed from: a, reason: collision with root package name */
    public transient Object[] f42976a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f42977b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f42978c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f42979d;

    /* renamed from: e, reason: collision with root package name */
    public transient int[] f42980e;

    /* renamed from: f, reason: collision with root package name */
    public transient long[] f42981f;

    /* renamed from: g, reason: collision with root package name */
    public transient float f42982g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f42983h;

    public class MapEntry extends Multisets.AbstractEntry<K> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42984a;

        /* renamed from: b, reason: collision with root package name */
        public int f42985b;

        public MapEntry(int i2) {
            this.f42984a = ObjectCountHashMap.this.f42976a[i2];
            this.f42985b = i2;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final Object a() {
            return this.f42984a;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            int i2 = this.f42985b;
            ObjectCountHashMap objectCountHashMap = ObjectCountHashMap.this;
            Object obj = this.f42984a;
            if (i2 == -1 || i2 >= objectCountHashMap.f42978c || !Objects.a(obj, objectCountHashMap.f42976a[i2])) {
                this.f42985b = objectCountHashMap.g(obj);
            }
            int i3 = this.f42985b;
            if (i3 == -1) {
                return 0;
            }
            return objectCountHashMap.f42977b[i3];
        }
    }

    public void a() {
        this.f42979d++;
        Arrays.fill(this.f42976a, 0, this.f42978c, (Object) null);
        Arrays.fill(this.f42977b, 0, this.f42978c, 0);
        Arrays.fill(this.f42980e, -1);
        Arrays.fill(this.f42981f, -1L);
        this.f42978c = 0;
    }

    public final void b(int i2) {
        if (i2 > this.f42981f.length) {
            o(i2);
        }
        if (i2 >= this.f42983h) {
            p(Math.max(2, Integer.highestOneBit(i2 - 1) << 1));
        }
    }

    public int c() {
        return this.f42978c == 0 ? -1 : 0;
    }

    public final int d(Object obj) {
        int iG = g(obj);
        if (iG == -1) {
            return 0;
        }
        return this.f42977b[iG];
    }

    public final Object e(int i2) {
        Preconditions.i(i2, this.f42978c);
        return this.f42976a[i2];
    }

    public final int f(int i2) {
        Preconditions.i(i2, this.f42978c);
        return this.f42977b[i2];
    }

    public final int g(Object obj) {
        int iC = Hashing.c(obj);
        int i2 = this.f42980e[(r1.length - 1) & iC];
        while (i2 != -1) {
            long j2 = this.f42981f[i2];
            if (((int) (j2 >>> 32)) == iC && Objects.a(obj, this.f42976a[i2])) {
                return i2;
            }
            i2 = (int) j2;
        }
        return -1;
    }

    public void h(int i2) {
        Preconditions.g(i2 >= 0, "Initial capacity must be non-negative");
        int iA = Hashing.a(i2, 1.0f);
        int[] iArr = new int[iA];
        Arrays.fill(iArr, -1);
        this.f42980e = iArr;
        this.f42982g = 1.0f;
        this.f42976a = new Object[i2];
        this.f42977b = new int[i2];
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1L);
        this.f42981f = jArr;
        this.f42983h = Math.max(1, (int) (iA * 1.0f));
    }

    public void i(Object obj, int i2, int i3, int i4) {
        this.f42981f[i2] = (i4 << 32) | 4294967295L;
        this.f42976a[i2] = obj;
        this.f42977b[i2] = i3;
    }

    public void j(int i2) {
        int i3 = this.f42978c - 1;
        if (i2 >= i3) {
            this.f42976a[i2] = null;
            this.f42977b[i2] = 0;
            this.f42981f[i2] = -1;
            return;
        }
        Object[] objArr = this.f42976a;
        objArr[i2] = objArr[i3];
        int[] iArr = this.f42977b;
        iArr[i2] = iArr[i3];
        objArr[i3] = null;
        iArr[i3] = 0;
        long[] jArr = this.f42981f;
        long j2 = jArr[i3];
        jArr[i2] = j2;
        jArr[i3] = -1;
        int[] iArr2 = this.f42980e;
        int length = ((int) (j2 >>> 32)) & (iArr2.length - 1);
        int i4 = iArr2[length];
        if (i4 == i3) {
            iArr2[length] = i2;
            return;
        }
        while (true) {
            long[] jArr2 = this.f42981f;
            long j3 = jArr2[i4];
            int i5 = (int) j3;
            if (i5 == i3) {
                jArr2[i4] = (j3 & (-4294967296L)) | (4294967295L & i2);
                return;
            }
            i4 = i5;
        }
    }

    public int k(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f42978c) {
            return i3;
        }
        return -1;
    }

    public int l(int i2, int i3) {
        return i2 - 1;
    }

    public final int m(int i2, Object obj) {
        CollectPreconditions.c(i2, "count");
        long[] jArr = this.f42981f;
        Object[] objArr = this.f42976a;
        int[] iArr = this.f42977b;
        int iC = Hashing.c(obj);
        int[] iArr2 = this.f42980e;
        int length = (iArr2.length - 1) & iC;
        int i3 = this.f42978c;
        int i4 = iArr2[length];
        if (i4 == -1) {
            iArr2[length] = i3;
        } else {
            while (true) {
                long j2 = jArr[i4];
                if (((int) (j2 >>> 32)) == iC && Objects.a(obj, objArr[i4])) {
                    int i5 = iArr[i4];
                    iArr[i4] = i2;
                    return i5;
                }
                int i6 = (int) j2;
                if (i6 == -1) {
                    jArr[i4] = ((-4294967296L) & j2) | (4294967295L & i3);
                    break;
                }
                i4 = i6;
            }
        }
        int i7 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i8 = i3 + 1;
        int length2 = this.f42981f.length;
        if (i8 > length2) {
            int iMax = Math.max(1, length2 >>> 1) + length2;
            if (iMax >= 0) {
                i7 = iMax;
            }
            if (i7 != length2) {
                o(i7);
            }
        }
        i(obj, i3, i2, iC);
        this.f42978c = i8;
        if (i3 >= this.f42983h) {
            p(this.f42980e.length * 2);
        }
        this.f42979d++;
        return 0;
    }

    public final int n(int i2) {
        Object obj = this.f42976a[i2];
        int i3 = (int) (this.f42981f[i2] >>> 32);
        int length = (r1.length - 1) & i3;
        int i4 = this.f42980e[length];
        if (i4 != -1) {
            int i5 = -1;
            while (true) {
                if (((int) (this.f42981f[i4] >>> 32)) == i3 && Objects.a(obj, this.f42976a[i4])) {
                    int i6 = this.f42977b[i4];
                    if (i5 == -1) {
                        this.f42980e[length] = (int) this.f42981f[i4];
                    } else {
                        long[] jArr = this.f42981f;
                        jArr[i5] = (jArr[i5] & (-4294967296L)) | (((int) jArr[i4]) & 4294967295L);
                    }
                    j(i4);
                    this.f42978c--;
                    this.f42979d++;
                    return i6;
                }
                int i7 = (int) this.f42981f[i4];
                if (i7 == -1) {
                    break;
                }
                i5 = i4;
                i4 = i7;
            }
        }
        return 0;
    }

    public void o(int i2) {
        this.f42976a = Arrays.copyOf(this.f42976a, i2);
        this.f42977b = Arrays.copyOf(this.f42977b, i2);
        long[] jArr = this.f42981f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(jArrCopyOf, length, i2, -1L);
        }
        this.f42981f = jArrCopyOf;
    }

    public final void p(int i2) {
        if (this.f42980e.length >= 1073741824) {
            this.f42983h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        int i3 = ((int) (i2 * this.f42982g)) + 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f42981f;
        int i4 = i2 - 1;
        for (int i5 = 0; i5 < this.f42978c; i5++) {
            int i6 = (int) (jArr[i5] >>> 32);
            int i7 = i6 & i4;
            int i8 = iArr[i7];
            iArr[i7] = i5;
            jArr[i5] = (i6 << 32) | (i8 & 4294967295L);
        }
        this.f42983h = i3;
        this.f42980e = iArr;
    }
}
