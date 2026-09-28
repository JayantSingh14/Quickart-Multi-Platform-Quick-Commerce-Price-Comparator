package com.google.android.gms.internal.auth;

import android.support.v4.media.a;
import android.support.v4.media.b;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzgg extends zzdr implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final zzgg f36389d = new zzgg(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f36390b;

    /* renamed from: c, reason: collision with root package name */
    public int f36391c;

    public zzgg(Object[] objArr, int i2, boolean z) {
        super(z);
        this.f36390b = objArr;
        this.f36391c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.f36391c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36391c, "Index:", ", Size:"));
        }
        Object[] objArr = this.f36390b;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
        } else {
            Object[] objArr2 = new Object[a.x(i3, 3, 2, 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.f36390b, i2, objArr2, i2 + 1, this.f36391c - i2);
            this.f36390b = objArr2;
        }
        this.f36390b[i2] = obj;
        this.f36391c++;
        ((AbstractList) this).modCount++;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f36391c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36391c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        d(i2);
        return this.f36390b[i2];
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        d(i2);
        Object[] objArr = this.f36390b;
        Object obj = objArr[i2];
        if (i2 < this.f36391c - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f36391c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        d(i2);
        Object[] objArr = this.f36390b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36391c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36391c) {
            return new zzgg(Arrays.copyOf(this.f36390b, i2), this.f36391c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i2 = this.f36391c;
        Object[] objArr = this.f36390b;
        if (i2 == objArr.length) {
            this.f36390b = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f36390b;
        int i3 = this.f36391c;
        this.f36391c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
