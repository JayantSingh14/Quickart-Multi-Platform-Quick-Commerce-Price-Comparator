package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzibq extends zzhyx implements RandomAccess, zzibc, zzicl {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f34689d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzibq f34690e;

    /* renamed from: b, reason: collision with root package name */
    public long[] f34691b;

    /* renamed from: c, reason: collision with root package name */
    public int f34692c;

    static {
        long[] jArr = new long[0];
        f34689d = jArr;
        f34690e = new zzibq(jArr, 0, false);
    }

    public zzibq(long[] jArr, int i2, boolean z) {
        super(z);
        this.f34691b = jArr;
        this.f34692c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f34692c)) {
            throw new IndexOutOfBoundsException(f(i2));
        }
        int i4 = i2 + 1;
        long[] jArr = this.f34691b;
        int length = jArr.length;
        if (i3 < length) {
            System.arraycopy(jArr, i2, jArr, i4, i3 - i2);
        } else {
            long[] jArr2 = new long[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34691b, 0, jArr2, 0, i2);
            System.arraycopy(this.f34691b, i2, jArr2, i4, this.f34692c - i2);
            this.f34691b = jArr2;
        }
        this.f34691b[i2] = jLongValue;
        this.f34692c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzibe.f34660a;
        collection.getClass();
        if (!(collection instanceof zzibq)) {
            return super.addAll(collection);
        }
        zzibq zzibqVar = (zzibq) collection;
        int i2 = zzibqVar.f34692c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f34692c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f34691b;
        if (i4 > jArr.length) {
            this.f34691b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zzibqVar.f34691b, 0, this.f34691b, this.f34692c, zzibqVar.f34692c);
        this.f34692c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f34692c) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzibq)) {
            return super.equals(obj);
        }
        zzibq zzibqVar = (zzibq) obj;
        if (this.f34692c != zzibqVar.f34692c) {
            return false;
        }
        long[] jArr = zzibqVar.f34691b;
        for (int i2 = 0; i2 < this.f34692c; i2++) {
            if (this.f34691b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final String f(int i2) {
        int i3 = this.f34692c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        d(i2);
        return Long.valueOf(this.f34691b[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzibc
    public final void h(long j2) {
        b();
        int i2 = this.f34692c;
        int length = this.f34691b.length;
        if (i2 == length) {
            long[] jArr = new long[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34691b, 0, jArr, 0, this.f34692c);
            this.f34691b = jArr;
        }
        long[] jArr2 = this.f34691b;
        int i3 = this.f34692c;
        this.f34692c = i3 + 1;
        jArr2[i3] = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f34692c; i3++) {
            long j2 = this.f34691b[i3];
            Charset charset = zzibe.f34660a;
            i2 = (i2 * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i2 = this.f34692c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f34691b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    public final long l(int i2) {
        d(i2);
        return this.f34691b[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        d(i2);
        long[] jArr = this.f34691b;
        long j2 = jArr[i2];
        if (i2 < this.f34692c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f34692c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f34691b;
        System.arraycopy(jArr, i3, jArr, i2, this.f34692c - i3);
        this.f34692c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        d(i2);
        long[] jArr = this.f34691b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34692c;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    /* renamed from: zzf */
    public final zzibc zzh(int i2) {
        if (i2 >= this.f34692c) {
            return new zzibq(i2 == 0 ? f34689d : Arrays.copyOf(this.f34691b, i2), this.f34692c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        h(((Long) obj).longValue());
        return true;
    }
}
