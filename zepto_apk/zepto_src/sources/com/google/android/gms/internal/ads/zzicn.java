package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzicn extends zzhyx implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f34725d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzicn f34726e;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f34727b;

    /* renamed from: c, reason: collision with root package name */
    public int f34728c;

    static {
        Object[] objArr = new Object[0];
        f34725d = objArr;
        f34726e = new zzicn(objArr, 0, false);
    }

    public zzicn(Object[] objArr, int i2, boolean z) {
        super(z);
        this.f34727b = objArr;
        this.f34728c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.f34728c)) {
            throw new IndexOutOfBoundsException(f(i2));
        }
        int i4 = i2 + 1;
        Object[] objArr = this.f34727b;
        int length = objArr.length;
        if (i3 < length) {
            System.arraycopy(objArr, i2, objArr, i4, i3 - i2);
        } else {
            Object[] objArr2 = new Object[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34727b, 0, objArr2, 0, i2);
            System.arraycopy(this.f34727b, i2, objArr2, i4, this.f34728c - i2);
            this.f34727b = objArr2;
        }
        this.f34727b[i2] = obj;
        this.f34728c++;
        ((AbstractList) this).modCount++;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f34728c) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }

    public final String f(int i2) {
        int i3 = this.f34728c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        d(i2);
        return this.f34727b[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        d(i2);
        Object[] objArr = this.f34727b;
        Object obj = objArr[i2];
        if (i2 < this.f34728c - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f34728c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        d(i2);
        Object[] objArr = this.f34727b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34728c;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    public final /* bridge */ /* synthetic */ zzibd zzh(int i2) {
        if (i2 >= this.f34728c) {
            return new zzicn(i2 == 0 ? f34725d : Arrays.copyOf(this.f34727b, i2), this.f34728c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i2 = this.f34728c;
        int length = this.f34727b.length;
        if (i2 == length) {
            this.f34727b = Arrays.copyOf(this.f34727b, androidx.fragment.app.e.d(length, 3, 2, 1, 10));
        }
        Object[] objArr = this.f34727b;
        int i3 = this.f34728c;
        this.f34728c = i3 + 1;
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
