package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzada extends zzabj implements RandomAccess, zzade, zzaem {

    /* renamed from: d, reason: collision with root package name */
    public static final zzada f37407d;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37408b;

    /* renamed from: c, reason: collision with root package name */
    public int f37409c;

    static {
        zzada zzadaVar = new zzada(new int[0], 0);
        f37407d = zzadaVar;
        zzadaVar.f37350a = false;
    }

    public zzada(int[] iArr, int i2) {
        this.f37408b = iArr;
        this.f37409c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37409c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37409c, "Index:", ", Size:"));
        }
        int[] iArr = this.f37408b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f37408b, i2, iArr2, i2 + 1, this.f37409c - i2);
            this.f37408b = iArr2;
        }
        this.f37408b[i2] = iIntValue;
        this.f37409c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzadg.f37410a;
        collection.getClass();
        if (!(collection instanceof zzada)) {
            return super.addAll(collection);
        }
        zzada zzadaVar = (zzada) collection;
        int i2 = zzadaVar.f37409c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37409c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f37408b;
        if (i4 > iArr.length) {
            this.f37408b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zzadaVar.f37408b, 0, this.f37408b, this.f37409c, zzadaVar.f37409c);
        this.f37409c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        b();
        int i3 = this.f37409c;
        int[] iArr = this.f37408b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f37408b = iArr2;
        }
        int[] iArr3 = this.f37408b;
        int i4 = this.f37409c;
        this.f37409c = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzada)) {
            return super.equals(obj);
        }
        zzada zzadaVar = (zzada) obj;
        if (this.f37409c != zzadaVar.f37409c) {
            return false;
        }
        int[] iArr = zzadaVar.f37408b;
        for (int i2 = 0; i2 < this.f37409c; i2++) {
            if (this.f37408b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzi(i2);
        return Integer.valueOf(this.f37408b[i2]);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37409c; i3++) {
            i2 = (i2 * 31) + this.f37408b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f37409c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37408b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        zzi(i2);
        int[] iArr = this.f37408b;
        int i3 = iArr[i2];
        if (i2 < this.f37409c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f37409c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f37408b;
        System.arraycopy(iArr, i3, iArr, i2, this.f37409c - i3);
        this.f37409c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        zzi(i2);
        int[] iArr = this.f37408b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37409c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 >= this.f37409c) {
            return new zzada(Arrays.copyOf(this.f37408b, i2), this.f37409c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzi(int i2) {
        if (i2 < 0 || i2 >= this.f37409c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37409c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
