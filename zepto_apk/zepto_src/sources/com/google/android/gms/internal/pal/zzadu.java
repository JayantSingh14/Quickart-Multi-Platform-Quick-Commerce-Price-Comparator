package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzadu extends zzabj implements RandomAccess, zzadf, zzaem {

    /* renamed from: b, reason: collision with root package name */
    public long[] f37430b;

    /* renamed from: c, reason: collision with root package name */
    public int f37431c;

    static {
        new zzadu(new long[0], 0).f37350a = false;
    }

    public zzadu(long[] jArr, int i2) {
        this.f37430b = jArr;
        this.f37431c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37431c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37431c, "Index:", ", Size:"));
        }
        long[] jArr = this.f37430b;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f37430b, i2, jArr2, i2 + 1, this.f37431c - i2);
            this.f37430b = jArr2;
        }
        this.f37430b[i2] = jLongValue;
        this.f37431c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzadg.f37410a;
        collection.getClass();
        if (!(collection instanceof zzadu)) {
            return super.addAll(collection);
        }
        zzadu zzaduVar = (zzadu) collection;
        int i2 = zzaduVar.f37431c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37431c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f37430b;
        if (i4 > jArr.length) {
            this.f37430b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zzaduVar.f37430b, 0, this.f37430b, this.f37431c, zzaduVar.f37431c);
        this.f37431c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j2) {
        b();
        int i2 = this.f37431c;
        long[] jArr = this.f37430b;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[android.support.v4.media.a.x(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f37430b = jArr2;
        }
        long[] jArr3 = this.f37430b;
        int i3 = this.f37431c;
        this.f37431c = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzadu)) {
            return super.equals(obj);
        }
        zzadu zzaduVar = (zzadu) obj;
        if (this.f37431c != zzaduVar.f37431c) {
            return false;
        }
        long[] jArr = zzaduVar.f37430b;
        for (int i2 = 0; i2 < this.f37431c; i2++) {
            if (this.f37430b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzh(i2);
        return Long.valueOf(this.f37430b[i2]);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i2 = 0; i2 < this.f37431c; i2++) {
            iA = (iA * 31) + zzadg.a(this.f37430b[i2]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i2 = this.f37431c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37430b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        zzh(i2);
        long[] jArr = this.f37430b;
        long j2 = jArr[i2];
        if (i2 < this.f37431c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f37431c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f37430b;
        System.arraycopy(jArr, i3, jArr, i2, this.f37431c - i3);
        this.f37431c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        zzh(i2);
        long[] jArr = this.f37430b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37431c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 >= this.f37431c) {
            return new zzadu(Arrays.copyOf(this.f37430b, i2), this.f37431c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        if (i2 < 0 || i2 >= this.f37431c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37431c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
