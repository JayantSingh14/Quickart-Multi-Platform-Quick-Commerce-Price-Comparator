package com.google.android.gms.internal.auth;

import android.support.v4.media.a;
import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzfm extends zzdr implements RandomAccess, zzez, zzge {

    /* renamed from: b, reason: collision with root package name */
    public long[] f36361b;

    /* renamed from: c, reason: collision with root package name */
    public int f36362c;

    static {
        new zzfm(new long[0], 0, false);
    }

    public zzfm(long[] jArr, int i2, boolean z) {
        super(z);
        this.f36361b = jArr;
        this.f36362c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36362c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36362c, "Index:", ", Size:"));
        }
        long[] jArr = this.f36361b;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[a.x(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f36361b, i2, jArr2, i2 + 1, this.f36362c - i2);
            this.f36361b = jArr2;
        }
        this.f36361b[i2] = jLongValue;
        this.f36362c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzfa.f36355a;
        collection.getClass();
        if (!(collection instanceof zzfm)) {
            return super.addAll(collection);
        }
        zzfm zzfmVar = (zzfm) collection;
        int i2 = zzfmVar.f36362c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36362c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f36361b;
        if (i4 > jArr.length) {
            this.f36361b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zzfmVar.f36361b, 0, this.f36361b, this.f36362c, zzfmVar.f36362c);
        this.f36362c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j2) {
        b();
        int i2 = this.f36362c;
        long[] jArr = this.f36361b;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[a.x(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f36361b = jArr2;
        }
        long[] jArr3 = this.f36361b;
        int i3 = this.f36362c;
        this.f36362c = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return super.equals(obj);
        }
        zzfm zzfmVar = (zzfm) obj;
        if (this.f36362c != zzfmVar.f36362c) {
            return false;
        }
        long[] jArr = zzfmVar.f36361b;
        for (int i2 = 0; i2 < this.f36362c; i2++) {
            if (this.f36361b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f36362c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36362c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Long.valueOf(this.f36361b[i2]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36362c; i3++) {
            long j2 = this.f36361b[i3];
            Charset charset = zzfa.f36355a;
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
        int i2 = this.f36362c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36361b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        long[] jArr = this.f36361b;
        long j2 = jArr[i2];
        if (i2 < this.f36362c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f36362c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f36361b;
        System.arraycopy(jArr, i3, jArr, i2, this.f36362c - i3);
        this.f36362c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        f(i2);
        long[] jArr = this.f36361b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36362c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36362c) {
            return new zzfm(Arrays.copyOf(this.f36361b, i2), this.f36362c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
