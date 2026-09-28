package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzhzb extends zzhyx implements RandomAccess, zziat, zzicl {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean[] f34542d;

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f34543b;

    /* renamed from: c, reason: collision with root package name */
    public int f34544c;

    static {
        boolean[] zArr = new boolean[0];
        f34542d = zArr;
        new zzhzb(zArr, 0, false);
    }

    public zzhzb(boolean[] zArr, int i2, boolean z) {
        super(z);
        this.f34543b = zArr;
        this.f34544c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f34544c)) {
            throw new IndexOutOfBoundsException(g(i2));
        }
        int i4 = i2 + 1;
        boolean[] zArr = this.f34543b;
        int length = zArr.length;
        if (i3 < length) {
            System.arraycopy(zArr, i2, zArr, i4, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34543b, 0, zArr2, 0, i2);
            System.arraycopy(this.f34543b, i2, zArr2, i4, this.f34544c - i2);
            this.f34543b = zArr2;
        }
        this.f34543b[i2] = zBooleanValue;
        this.f34544c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzibe.f34660a;
        collection.getClass();
        if (!(collection instanceof zzhzb)) {
            return super.addAll(collection);
        }
        zzhzb zzhzbVar = (zzhzb) collection;
        int i2 = zzhzbVar.f34544c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f34544c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f34543b;
        if (i4 > zArr.length) {
            this.f34543b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(zzhzbVar.f34543b, 0, this.f34543b, this.f34544c, zzhzbVar.f34544c);
        this.f34544c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    /* renamed from: c */
    public final zziat zzh(int i2) {
        if (i2 >= this.f34544c) {
            return new zzhzb(i2 == 0 ? f34542d : Arrays.copyOf(this.f34543b, i2), this.f34544c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z) {
        b();
        int i2 = this.f34544c;
        int length = this.f34543b.length;
        if (i2 == length) {
            boolean[] zArr = new boolean[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34543b, 0, zArr, 0, this.f34544c);
            this.f34543b = zArr;
        }
        boolean[] zArr2 = this.f34543b;
        int i3 = this.f34544c;
        this.f34544c = i3 + 1;
        zArr2[i3] = z;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhzb)) {
            return super.equals(obj);
        }
        zzhzb zzhzbVar = (zzhzb) obj;
        if (this.f34544c != zzhzbVar.f34544c) {
            return false;
        }
        boolean[] zArr = zzhzbVar.f34543b;
        for (int i2 = 0; i2 < this.f34544c; i2++) {
            if (this.f34543b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f34544c) {
            throw new IndexOutOfBoundsException(g(i2));
        }
    }

    public final String g(int i2) {
        int i3 = this.f34544c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Boolean.valueOf(this.f34543b[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f34544c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.f34543b[i3];
            Charset charset = zzibe.f34660a;
            i2 = i4 + (z ? 1231 : 1237);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.f34544c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f34543b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        boolean[] zArr = this.f34543b;
        boolean z = zArr[i2];
        if (i2 < this.f34544c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f34544c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f34543b;
        System.arraycopy(zArr, i3, zArr, i2, this.f34544c - i3);
        this.f34544c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i2);
        boolean[] zArr = this.f34543b;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34544c;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
