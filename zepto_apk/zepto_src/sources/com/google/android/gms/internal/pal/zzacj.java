package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzacj extends zzabj implements RandomAccess, zzadf, zzaem {

    /* renamed from: b, reason: collision with root package name */
    public double[] f37384b;

    /* renamed from: c, reason: collision with root package name */
    public int f37385c;

    static {
        new zzacj(new double[0], 0).f37350a = false;
    }

    public zzacj(double[] dArr, int i2) {
        this.f37384b = dArr;
        this.f37385c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37385c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37385c, "Index:", ", Size:"));
        }
        double[] dArr = this.f37384b;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f37384b, i2, dArr2, i2 + 1, this.f37385c - i2);
            this.f37384b = dArr2;
        }
        this.f37384b[i2] = dDoubleValue;
        this.f37385c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzadg.f37410a;
        collection.getClass();
        if (!(collection instanceof zzacj)) {
            return super.addAll(collection);
        }
        zzacj zzacjVar = (zzacj) collection;
        int i2 = zzacjVar.f37385c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37385c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f37384b;
        if (i4 > dArr.length) {
            this.f37384b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(zzacjVar.f37384b, 0, this.f37384b, this.f37385c, zzacjVar.f37385c);
        this.f37385c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d2) {
        b();
        int i2 = this.f37385c;
        double[] dArr = this.f37384b;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[android.support.v4.media.a.x(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f37384b = dArr2;
        }
        double[] dArr3 = this.f37384b;
        int i3 = this.f37385c;
        this.f37385c = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzacj)) {
            return super.equals(obj);
        }
        zzacj zzacjVar = (zzacj) obj;
        if (this.f37385c != zzacjVar.f37385c) {
            return false;
        }
        double[] dArr = zzacjVar.f37384b;
        for (int i2 = 0; i2 < this.f37385c; i2++) {
            if (Double.doubleToLongBits(this.f37384b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f37385c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37385c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Double.valueOf(this.f37384b[i2]);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i2 = 0; i2 < this.f37385c; i2++) {
            iA = (iA * 31) + zzadg.a(Double.doubleToLongBits(this.f37384b[i2]));
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i2 = this.f37385c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37384b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        double[] dArr = this.f37384b;
        double d2 = dArr[i2];
        if (i2 < this.f37385c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f37385c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f37384b;
        System.arraycopy(dArr, i3, dArr, i2, this.f37385c - i3);
        this.f37385c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        f(i2);
        double[] dArr = this.f37384b;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37385c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 >= this.f37385c) {
            return new zzacj(Arrays.copyOf(this.f37384b, i2), this.f37385c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
