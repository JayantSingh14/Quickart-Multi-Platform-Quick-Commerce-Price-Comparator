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
final class zzdv extends zzdr implements RandomAccess, zzez, zzge {

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f36329b;

    /* renamed from: c, reason: collision with root package name */
    public int f36330c;

    static {
        new zzdv(new boolean[0], 0, false);
    }

    public zzdv(boolean[] zArr, int i2, boolean z) {
        super(z);
        this.f36329b = zArr;
        this.f36330c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36330c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36330c, "Index:", ", Size:"));
        }
        boolean[] zArr = this.f36329b;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[a.x(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f36329b, i2, zArr2, i2 + 1, this.f36330c - i2);
            this.f36329b = zArr2;
        }
        this.f36329b[i2] = zBooleanValue;
        this.f36330c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzfa.f36355a;
        collection.getClass();
        if (!(collection instanceof zzdv)) {
            return super.addAll(collection);
        }
        zzdv zzdvVar = (zzdv) collection;
        int i2 = zzdvVar.f36330c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36330c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f36329b;
        if (i4 > zArr.length) {
            this.f36329b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(zzdvVar.f36329b, 0, this.f36329b, this.f36330c, zzdvVar.f36330c);
        this.f36330c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z) {
        b();
        int i2 = this.f36330c;
        boolean[] zArr = this.f36329b;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[a.x(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f36329b = zArr2;
        }
        boolean[] zArr3 = this.f36329b;
        int i3 = this.f36330c;
        this.f36330c = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdv)) {
            return super.equals(obj);
        }
        zzdv zzdvVar = (zzdv) obj;
        if (this.f36330c != zzdvVar.f36330c) {
            return false;
        }
        boolean[] zArr = zzdvVar.f36329b;
        for (int i2 = 0; i2 < this.f36330c; i2++) {
            if (this.f36329b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f36330c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36330c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Boolean.valueOf(this.f36329b[i2]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36330c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.f36329b[i3];
            Charset charset = zzfa.f36355a;
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
        int i2 = this.f36330c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36329b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        boolean[] zArr = this.f36329b;
        boolean z = zArr[i2];
        if (i2 < this.f36330c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f36330c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f36329b;
        System.arraycopy(zArr, i3, zArr, i2, this.f36330c - i3);
        this.f36330c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i2);
        boolean[] zArr = this.f36329b;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36330c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36330c) {
            return new zzdv(Arrays.copyOf(this.f36329b, i2), this.f36330c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
