package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzmf extends zzkt implements RandomAccess, zzml, zzns {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f37108d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzmf f37109e;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37110b;

    /* renamed from: c, reason: collision with root package name */
    public int f37111c;

    static {
        int[] iArr = new int[0];
        f37108d = iArr;
        f37109e = new zzmf(iArr, 0, false);
    }

    public zzmf(int[] iArr, int i2, boolean z) {
        super(z);
        this.f37110b = iArr;
        this.f37111c = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37111c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37111c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        int[] iArr = this.f37110b;
        int length = iArr.length;
        if (i3 < length) {
            System.arraycopy(iArr, i2, iArr, i4, i3 - i2);
        } else {
            int[] iArr2 = new int[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37110b, 0, iArr2, 0, i2);
            System.arraycopy(this.f37110b, i2, iArr2, i4, this.f37111c - i2);
            this.f37110b = iArr2;
        }
        this.f37110b[i2] = iIntValue;
        this.f37111c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzmo.f37112a;
        collection.getClass();
        if (!(collection instanceof zzmf)) {
            return super.addAll(collection);
        }
        zzmf zzmfVar = (zzmf) collection;
        int i2 = zzmfVar.f37111c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37111c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f37110b;
        if (i4 > iArr.length) {
            this.f37110b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zzmfVar.f37110b, 0, this.f37110b, this.f37111c, zzmfVar.f37111c);
        this.f37111c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* renamed from: c */
    public final zzml zzg(int i2) {
        if (i2 >= this.f37111c) {
            return new zzmf(i2 == 0 ? f37108d : Arrays.copyOf(this.f37110b, i2), this.f37111c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i2) {
        f(i2);
        return this.f37110b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmf)) {
            return super.equals(obj);
        }
        zzmf zzmfVar = (zzmf) obj;
        if (this.f37111c != zzmfVar.f37111c) {
            return false;
        }
        int[] iArr = zzmfVar.f37110b;
        for (int i2 = 0; i2 < this.f37111c; i2++) {
            if (this.f37110b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f37111c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37111c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Integer.valueOf(this.f37110b[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37111c; i3++) {
            i2 = (i2 * 31) + this.f37110b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f37111c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37110b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        int[] iArr = this.f37110b;
        int i3 = iArr[i2];
        if (i2 < this.f37111c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f37111c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f37110b;
        System.arraycopy(iArr, i3, iArr, i2, this.f37111c - i3);
        this.f37111c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        f(i2);
        int[] iArr = this.f37110b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37111c;
    }

    public final void zzh(int i2) {
        b();
        int i3 = this.f37111c;
        int length = this.f37110b.length;
        if (i3 == length) {
            int[] iArr = new int[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37110b, 0, iArr, 0, this.f37111c);
            this.f37110b = iArr;
        }
        int[] iArr2 = this.f37110b;
        int i4 = this.f37111c;
        this.f37111c = i4 + 1;
        iArr2[i4] = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
