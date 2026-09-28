package com.google.android.gms.internal.pal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzaeo extends zzabj implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final zzaeo f37460d;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f37461b;

    /* renamed from: c, reason: collision with root package name */
    public int f37462c;

    static {
        zzaeo zzaeoVar = new zzaeo(new Object[0], 0);
        f37460d = zzaeoVar;
        zzaeoVar.f37350a = false;
    }

    public zzaeo(Object[] objArr, int i2) {
        this.f37461b = objArr;
        this.f37462c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.f37462c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37462c, "Index:", ", Size:"));
        }
        Object[] objArr = this.f37461b;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
        } else {
            Object[] objArr2 = new Object[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.f37461b, i2, objArr2, i2 + 1, this.f37462c - i2);
            this.f37461b = objArr2;
        }
        this.f37461b[i2] = obj;
        this.f37462c++;
        ((AbstractList) this).modCount++;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f37462c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37462c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        d(i2);
        return this.f37461b[i2];
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        d(i2);
        Object[] objArr = this.f37461b;
        Object obj = objArr[i2];
        if (i2 < this.f37462c - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f37462c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        d(i2);
        Object[] objArr = this.f37461b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37462c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 >= this.f37462c) {
            return new zzaeo(Arrays.copyOf(this.f37461b, i2), this.f37462c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i2 = this.f37462c;
        Object[] objArr = this.f37461b;
        if (i2 == objArr.length) {
            this.f37461b = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f37461b;
        int i3 = this.f37462c;
        this.f37462c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
