package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzabn extends zzabj implements RandomAccess, zzadf, zzaem {

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f37356b;

    /* renamed from: c, reason: collision with root package name */
    public int f37357c;

    static {
        new zzabn(new boolean[0], 0).f37350a = false;
    }

    public zzabn(boolean[] zArr, int i2) {
        this.f37356b = zArr;
        this.f37357c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37357c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37357c, "Index:", ", Size:"));
        }
        boolean[] zArr = this.f37356b;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f37356b, i2, zArr2, i2 + 1, this.f37357c - i2);
            this.f37356b = zArr2;
        }
        this.f37356b[i2] = zBooleanValue;
        this.f37357c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzadg.f37410a;
        collection.getClass();
        if (!(collection instanceof zzabn)) {
            return super.addAll(collection);
        }
        zzabn zzabnVar = (zzabn) collection;
        int i2 = zzabnVar.f37357c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37357c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f37356b;
        if (i4 > zArr.length) {
            this.f37356b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(zzabnVar.f37356b, 0, this.f37356b, this.f37357c, zzabnVar.f37357c);
        this.f37357c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z) {
        b();
        int i2 = this.f37357c;
        boolean[] zArr = this.f37356b;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[android.support.v4.media.a.x(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f37356b = zArr2;
        }
        boolean[] zArr3 = this.f37356b;
        int i3 = this.f37357c;
        this.f37357c = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzabn)) {
            return super.equals(obj);
        }
        zzabn zzabnVar = (zzabn) obj;
        if (this.f37357c != zzabnVar.f37357c) {
            return false;
        }
        boolean[] zArr = zzabnVar.f37356b;
        for (int i2 = 0; i2 < this.f37357c; i2++) {
            if (this.f37356b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f37357c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37357c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Boolean.valueOf(this.f37356b[i2]);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37357c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.f37356b[i3];
            Charset charset = zzadg.f37410a;
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
        int i2 = this.f37357c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37356b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        boolean[] zArr = this.f37356b;
        boolean z = zArr[i2];
        if (i2 < this.f37357c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f37357c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f37356b;
        System.arraycopy(zArr, i3, zArr, i2, this.f37357c - i3);
        this.f37357c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i2);
        boolean[] zArr = this.f37356b;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37357c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 >= this.f37357c) {
            return new zzabn(Arrays.copyOf(this.f37356b, i2), this.f37357c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
