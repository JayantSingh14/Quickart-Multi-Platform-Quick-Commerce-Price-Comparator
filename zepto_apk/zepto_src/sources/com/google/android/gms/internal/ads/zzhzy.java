package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzhzy extends zzhyx implements RandomAccess, zziau, zzicl {

    /* renamed from: d, reason: collision with root package name */
    public static final double[] f34607d;

    /* renamed from: b, reason: collision with root package name */
    public double[] f34608b;

    /* renamed from: c, reason: collision with root package name */
    public int f34609c;

    static {
        double[] dArr = new double[0];
        f34607d = dArr;
        new zzhzy(dArr, 0, false);
    }

    public zzhzy(double[] dArr, int i2, boolean z) {
        super(z);
        this.f34608b = dArr;
        this.f34609c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f34609c)) {
            throw new IndexOutOfBoundsException(g(i2));
        }
        int i4 = i2 + 1;
        double[] dArr = this.f34608b;
        int length = dArr.length;
        if (i3 < length) {
            System.arraycopy(dArr, i2, dArr, i4, i3 - i2);
        } else {
            double[] dArr2 = new double[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34608b, 0, dArr2, 0, i2);
            System.arraycopy(this.f34608b, i2, dArr2, i4, this.f34609c - i2);
            this.f34608b = dArr2;
        }
        this.f34608b[i2] = dDoubleValue;
        this.f34609c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzibe.f34660a;
        collection.getClass();
        if (!(collection instanceof zzhzy)) {
            return super.addAll(collection);
        }
        zzhzy zzhzyVar = (zzhzy) collection;
        int i2 = zzhzyVar.f34609c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f34609c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f34608b;
        if (i4 > dArr.length) {
            this.f34608b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(zzhzyVar.f34608b, 0, this.f34608b, this.f34609c, zzhzyVar.f34609c);
        this.f34609c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    /* renamed from: c */
    public final zziau zzh(int i2) {
        if (i2 >= this.f34609c) {
            return new zzhzy(i2 == 0 ? f34607d : Arrays.copyOf(this.f34608b, i2), this.f34609c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d2) {
        b();
        int i2 = this.f34609c;
        int length = this.f34608b.length;
        if (i2 == length) {
            double[] dArr = new double[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34608b, 0, dArr, 0, this.f34609c);
            this.f34608b = dArr;
        }
        double[] dArr2 = this.f34608b;
        int i3 = this.f34609c;
        this.f34609c = i3 + 1;
        dArr2[i3] = d2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhzy)) {
            return super.equals(obj);
        }
        zzhzy zzhzyVar = (zzhzy) obj;
        if (this.f34609c != zzhzyVar.f34609c) {
            return false;
        }
        double[] dArr = zzhzyVar.f34608b;
        for (int i2 = 0; i2 < this.f34609c; i2++) {
            if (Double.doubleToLongBits(this.f34608b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f34609c) {
            throw new IndexOutOfBoundsException(g(i2));
        }
    }

    public final String g(int i2) {
        int i3 = this.f34609c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Double.valueOf(this.f34608b[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f34609c; i3++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f34608b[i3]);
            Charset charset = zzibe.f34660a;
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
        int i2 = this.f34609c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f34608b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        double[] dArr = this.f34608b;
        double d2 = dArr[i2];
        if (i2 < this.f34609c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f34609c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f34608b;
        System.arraycopy(dArr, i3, dArr, i2, this.f34609c - i3);
        this.f34609c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        f(i2);
        double[] dArr = this.f34608b;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34609c;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
