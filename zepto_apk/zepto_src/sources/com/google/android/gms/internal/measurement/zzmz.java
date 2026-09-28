package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzmz extends zzkt implements RandomAccess, zzmm, zzns {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f37130d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzmz f37131e;

    /* renamed from: b, reason: collision with root package name */
    public long[] f37132b;

    /* renamed from: c, reason: collision with root package name */
    public int f37133c;

    static {
        long[] jArr = new long[0];
        f37130d = jArr;
        f37131e = new zzmz(jArr, 0, false);
    }

    public zzmz(long[] jArr, int i2, boolean z) {
        super(z);
        this.f37132b = jArr;
        this.f37133c = i2;
    }

    public static zzmz d() {
        return f37131e;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37133c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37133c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        long[] jArr = this.f37132b;
        int length = jArr.length;
        if (i3 < length) {
            System.arraycopy(jArr, i2, jArr, i4, i3 - i2);
        } else {
            long[] jArr2 = new long[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37132b, 0, jArr2, 0, i2);
            System.arraycopy(this.f37132b, i2, jArr2, i4, this.f37133c - i2);
            this.f37132b = jArr2;
        }
        this.f37132b[i2] = jLongValue;
        this.f37133c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzmo.f37112a;
        collection.getClass();
        if (!(collection instanceof zzmz)) {
            return super.addAll(collection);
        }
        zzmz zzmzVar = (zzmz) collection;
        int i2 = zzmzVar.f37133c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37133c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f37132b;
        if (i4 > jArr.length) {
            this.f37132b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zzmzVar.f37132b, 0, this.f37132b, this.f37133c, zzmzVar.f37133c);
        this.f37133c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmz)) {
            return super.equals(obj);
        }
        zzmz zzmzVar = (zzmz) obj;
        if (this.f37133c != zzmzVar.f37133c) {
            return false;
        }
        long[] jArr = zzmzVar.f37132b;
        for (int i2 = 0; i2 < this.f37133c; i2++) {
            if (this.f37132b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(long j2) {
        b();
        int i2 = this.f37133c;
        int length = this.f37132b.length;
        if (i2 == length) {
            long[] jArr = new long[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37132b, 0, jArr, 0, this.f37133c);
            this.f37132b = jArr;
        }
        long[] jArr2 = this.f37132b;
        int i3 = this.f37133c;
        this.f37133c = i3 + 1;
        jArr2[i3] = j2;
    }

    public final void g(int i2) {
        if (i2 < 0 || i2 >= this.f37133c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37133c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Long.valueOf(this.f37132b[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37133c; i3++) {
            long j2 = this.f37132b[i3];
            Charset charset = zzmo.f37112a;
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
        int i2 = this.f37133c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37132b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final long l(int i2) {
        g(i2);
        return this.f37132b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        g(i2);
        long[] jArr = this.f37132b;
        long j2 = jArr[i2];
        if (i2 < this.f37133c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f37133c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f37132b;
        System.arraycopy(jArr, i3, jArr, i2, this.f37133c - i3);
        this.f37133c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        g(i2);
        long[] jArr = this.f37132b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37133c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* renamed from: zzd */
    public final zzmm zzg(int i2) {
        if (i2 >= this.f37133c) {
            return new zzmz(i2 == 0 ? f37130d : Arrays.copyOf(this.f37132b, i2), this.f37133c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        int length = this.f37132b.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.f37132b = new long[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = e.d(length, 3, 2, 1, 10);
        }
        this.f37132b = Arrays.copyOf(this.f37132b, length);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Long) obj).longValue());
        return true;
    }
}
