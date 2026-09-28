package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzkx extends zzkt implements RandomAccess, zzmg, zzns {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean[] f37064d;

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f37065b;

    /* renamed from: c, reason: collision with root package name */
    public int f37066c;

    static {
        boolean[] zArr = new boolean[0];
        f37064d = zArr;
        new zzkx(zArr, 0, false);
    }

    public zzkx(boolean[] zArr, int i2, boolean z) {
        super(z);
        this.f37065b = zArr;
        this.f37066c = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37066c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37066c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        boolean[] zArr = this.f37065b;
        int length = zArr.length;
        if (i3 < length) {
            System.arraycopy(zArr, i2, zArr, i4, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37065b, 0, zArr2, 0, i2);
            System.arraycopy(this.f37065b, i2, zArr2, i4, this.f37066c - i2);
            this.f37065b = zArr2;
        }
        this.f37065b[i2] = zBooleanValue;
        this.f37066c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzmo.f37112a;
        collection.getClass();
        if (!(collection instanceof zzkx)) {
            return super.addAll(collection);
        }
        zzkx zzkxVar = (zzkx) collection;
        int i2 = zzkxVar.f37066c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37066c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f37065b;
        if (i4 > zArr.length) {
            this.f37065b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(zzkxVar.f37065b, 0, this.f37065b, this.f37066c, zzkxVar.f37066c);
        this.f37066c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean d(int i2) {
        zzi(i2);
        return this.f37065b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkx)) {
            return super.equals(obj);
        }
        zzkx zzkxVar = (zzkx) obj;
        if (this.f37066c != zzkxVar.f37066c) {
            return false;
        }
        boolean[] zArr = zzkxVar.f37065b;
        for (int i2 = 0; i2 < this.f37066c; i2++) {
            if (this.f37065b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z) {
        b();
        int i2 = this.f37066c;
        int length = this.f37065b.length;
        if (i2 == length) {
            boolean[] zArr = new boolean[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37065b, 0, zArr, 0, this.f37066c);
            this.f37065b = zArr;
        }
        boolean[] zArr2 = this.f37065b;
        int i3 = this.f37066c;
        this.f37066c = i3 + 1;
        zArr2[i3] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzi(i2);
        return Boolean.valueOf(this.f37065b[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37066c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.f37065b[i3];
            Charset charset = zzmo.f37112a;
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
        int i2 = this.f37066c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37065b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        zzi(i2);
        boolean[] zArr = this.f37065b;
        boolean z = zArr[i2];
        if (i2 < this.f37066c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f37066c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f37065b;
        System.arraycopy(zArr, i3, zArr, i2, this.f37066c - i3);
        this.f37066c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        zzi(i2);
        boolean[] zArr = this.f37065b;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37066c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* renamed from: zzd */
    public final zzmg zzg(int i2) {
        if (i2 >= this.f37066c) {
            return new zzkx(i2 == 0 ? f37064d : Arrays.copyOf(this.f37065b, i2), this.f37066c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzi(int i2) {
        if (i2 < 0 || i2 >= this.f37066c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37066c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Boolean) obj).booleanValue());
        return true;
    }
}
