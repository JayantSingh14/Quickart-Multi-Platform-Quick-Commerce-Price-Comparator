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
final class zzek extends zzdr implements RandomAccess, zzez, zzge {

    /* renamed from: b, reason: collision with root package name */
    public double[] f36339b;

    /* renamed from: c, reason: collision with root package name */
    public int f36340c;

    static {
        new zzek(new double[0], 0, false);
    }

    public zzek(double[] dArr, int i2, boolean z) {
        super(z);
        this.f36339b = dArr;
        this.f36340c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36340c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36340c, "Index:", ", Size:"));
        }
        double[] dArr = this.f36339b;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[a.x(i3, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f36339b, i2, dArr2, i2 + 1, this.f36340c - i2);
            this.f36339b = dArr2;
        }
        this.f36339b[i2] = dDoubleValue;
        this.f36340c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzfa.f36355a;
        collection.getClass();
        if (!(collection instanceof zzek)) {
            return super.addAll(collection);
        }
        zzek zzekVar = (zzek) collection;
        int i2 = zzekVar.f36340c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36340c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f36339b;
        if (i4 > dArr.length) {
            this.f36339b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(zzekVar.f36339b, 0, this.f36339b, this.f36340c, zzekVar.f36340c);
        this.f36340c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d2) {
        b();
        int i2 = this.f36340c;
        double[] dArr = this.f36339b;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[a.x(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f36339b = dArr2;
        }
        double[] dArr3 = this.f36339b;
        int i3 = this.f36340c;
        this.f36340c = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzek)) {
            return super.equals(obj);
        }
        zzek zzekVar = (zzek) obj;
        if (this.f36340c != zzekVar.f36340c) {
            return false;
        }
        double[] dArr = zzekVar.f36339b;
        for (int i2 = 0; i2 < this.f36340c; i2++) {
            if (Double.doubleToLongBits(this.f36339b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f36340c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36340c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Double.valueOf(this.f36339b[i2]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36340c; i3++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f36339b[i3]);
            Charset charset = zzfa.f36355a;
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
        int i2 = this.f36340c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36339b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        double[] dArr = this.f36339b;
        double d2 = dArr[i2];
        if (i2 < this.f36340c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f36340c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f36339b;
        System.arraycopy(dArr, i3, dArr, i2, this.f36340c - i3);
        this.f36340c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        f(i2);
        double[] dArr = this.f36339b;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36340c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36340c) {
            return new zzek(Arrays.copyOf(this.f36339b, i2), this.f36340c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
