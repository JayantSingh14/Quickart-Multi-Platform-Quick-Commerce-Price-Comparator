package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.a;
import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzed extends zzcb implements RandomAccess, zzdo, zzev {

    /* renamed from: b, reason: collision with root package name */
    public long[] f36146b;

    /* renamed from: c, reason: collision with root package name */
    public int f36147c;

    static {
        new zzed(new long[0], 0, false);
    }

    public zzed(long[] jArr, int i2, boolean z) {
        super(z);
        this.f36146b = jArr;
        this.f36147c = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36147c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36147c, "Index:", ", Size:"));
        }
        long[] jArr = this.f36146b;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[a.x(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f36146b, i2, jArr2, i2 + 1, this.f36147c - i2);
            this.f36146b = jArr2;
        }
        this.f36146b[i2] = jLongValue;
        this.f36147c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzdp.f36125a;
        collection.getClass();
        if (!(collection instanceof zzed)) {
            return super.addAll(collection);
        }
        zzed zzedVar = (zzed) collection;
        int i2 = zzedVar.f36147c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36147c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f36146b;
        if (i4 > jArr.length) {
            this.f36146b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zzedVar.f36146b, 0, this.f36146b, this.f36147c, zzedVar.f36147c);
        this.f36147c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f36147c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36147c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzed)) {
            return super.equals(obj);
        }
        zzed zzedVar = (zzed) obj;
        if (this.f36147c != zzedVar.f36147c) {
            return false;
        }
        long[] jArr = zzedVar.f36146b;
        for (int i2 = 0; i2 < this.f36147c; i2++) {
            if (this.f36146b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        d(i2);
        return Long.valueOf(this.f36146b[i2]);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36147c; i3++) {
            long j2 = this.f36146b[i3];
            Charset charset = zzdp.f36125a;
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
        int i2 = this.f36147c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36146b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        d(i2);
        long[] jArr = this.f36146b;
        long j2 = jArr[i2];
        if (i2 < this.f36147c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f36147c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f36146b;
        System.arraycopy(jArr, i3, jArr, i2, this.f36147c - i3);
        this.f36147c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        d(i2);
        long[] jArr = this.f36146b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36147c;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdo
    public final /* bridge */ /* synthetic */ zzdo zzg(int i2) {
        if (i2 >= this.f36147c) {
            return new zzed(Arrays.copyOf(this.f36146b, i2), this.f36147c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        int i2 = this.f36147c;
        long[] jArr = this.f36146b;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[a.x(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f36146b = jArr2;
        }
        long[] jArr3 = this.f36146b;
        int i3 = this.f36147c;
        this.f36147c = i3 + 1;
        jArr3[i3] = jLongValue;
        return true;
    }
}
