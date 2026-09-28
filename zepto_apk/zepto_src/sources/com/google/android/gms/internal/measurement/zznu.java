package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zznu extends zzkt implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f37164d;

    /* renamed from: e, reason: collision with root package name */
    public static final zznu f37165e;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f37166b;

    /* renamed from: c, reason: collision with root package name */
    public int f37167c;

    static {
        Object[] objArr = new Object[0];
        f37164d = objArr;
        f37165e = new zznu(objArr, 0, false);
    }

    public zznu(Object[] objArr, int i2, boolean z) {
        super(z);
        this.f37166b = objArr;
        this.f37167c = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.f37167c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37167c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        Object[] objArr = this.f37166b;
        int length = objArr.length;
        if (i3 < length) {
            System.arraycopy(objArr, i2, objArr, i4, i3 - i2);
        } else {
            Object[] objArr2 = new Object[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37166b, 0, objArr2, 0, i2);
            System.arraycopy(this.f37166b, i2, objArr2, i4, this.f37167c - i2);
            this.f37166b = objArr2;
        }
        this.f37166b[i2] = obj;
        this.f37167c++;
        ((AbstractList) this).modCount++;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f37167c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37167c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        d(i2);
        return this.f37166b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        d(i2);
        Object[] objArr = this.f37166b;
        Object obj = objArr[i2];
        if (i2 < this.f37167c - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f37167c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        d(i2);
        Object[] objArr = this.f37166b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37167c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    public final /* bridge */ /* synthetic */ zzmn zzg(int i2) {
        if (i2 >= this.f37167c) {
            return new zznu(i2 == 0 ? f37164d : Arrays.copyOf(this.f37166b, i2), this.f37167c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i2 = this.f37167c;
        int length = this.f37166b.length;
        if (i2 == length) {
            this.f37166b = Arrays.copyOf(this.f37166b, e.d(length, 3, 2, 1, 10));
        }
        Object[] objArr = this.f37166b;
        int i3 = this.f37167c;
        this.f37167c = i3 + 1;
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
