package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzln extends zzkt implements RandomAccess, zzmh, zzns {

    /* renamed from: d, reason: collision with root package name */
    public static final double[] f37083d;

    /* renamed from: b, reason: collision with root package name */
    public double[] f37084b;

    /* renamed from: c, reason: collision with root package name */
    public int f37085c;

    static {
        double[] dArr = new double[0];
        f37083d = dArr;
        new zzln(dArr, 0, false);
    }

    public zzln(double[] dArr, int i2, boolean z) {
        super(z);
        this.f37084b = dArr;
        this.f37085c = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37085c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37085c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        double[] dArr = this.f37084b;
        int length = dArr.length;
        if (i3 < length) {
            System.arraycopy(dArr, i2, dArr, i4, i3 - i2);
        } else {
            double[] dArr2 = new double[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37084b, 0, dArr2, 0, i2);
            System.arraycopy(this.f37084b, i2, dArr2, i4, this.f37085c - i2);
            this.f37084b = dArr2;
        }
        this.f37084b[i2] = dDoubleValue;
        this.f37085c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzmo.f37112a;
        collection.getClass();
        if (!(collection instanceof zzln)) {
            return super.addAll(collection);
        }
        zzln zzlnVar = (zzln) collection;
        int i2 = zzlnVar.f37085c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37085c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f37084b;
        if (i4 > dArr.length) {
            this.f37084b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(zzlnVar.f37084b, 0, this.f37084b, this.f37085c, zzlnVar.f37085c);
        this.f37085c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final double d(int i2) {
        g(i2);
        return this.f37084b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzln)) {
            return super.equals(obj);
        }
        zzln zzlnVar = (zzln) obj;
        if (this.f37085c != zzlnVar.f37085c) {
            return false;
        }
        double[] dArr = zzlnVar.f37084b;
        for (int i2 = 0; i2 < this.f37085c; i2++) {
            if (Double.doubleToLongBits(this.f37084b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(double d2) {
        b();
        int i2 = this.f37085c;
        int length = this.f37084b.length;
        if (i2 == length) {
            double[] dArr = new double[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37084b, 0, dArr, 0, this.f37085c);
            this.f37084b = dArr;
        }
        double[] dArr2 = this.f37084b;
        int i3 = this.f37085c;
        this.f37085c = i3 + 1;
        dArr2[i3] = d2;
    }

    public final void g(int i2) {
        if (i2 < 0 || i2 >= this.f37085c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37085c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Double.valueOf(this.f37084b[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37085c; i3++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f37084b[i3]);
            Charset charset = zzmo.f37112a;
            i2 = (i2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i2 = this.f37085c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37084b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        g(i2);
        double[] dArr = this.f37084b;
        double d2 = dArr[i2];
        if (i2 < this.f37085c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f37085c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f37084b;
        System.arraycopy(dArr, i3, dArr, i2, this.f37085c - i3);
        this.f37085c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        g(i2);
        double[] dArr = this.f37084b;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37085c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* renamed from: zzd */
    public final zzmh zzg(int i2) {
        if (i2 >= this.f37085c) {
            return new zzln(i2 == 0 ? f37083d : Arrays.copyOf(this.f37084b, i2), this.f37085c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        int length = this.f37084b.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.f37084b = new double[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = e.d(length, 3, 2, 1, 10);
        }
        this.f37084b = Arrays.copyOf(this.f37084b, length);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Double) obj).doubleValue());
        return true;
    }
}
