package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzias extends zzhyx implements RandomAccess, zziaz, zzicl {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f34648d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzias f34649e;

    /* renamed from: b, reason: collision with root package name */
    public int[] f34650b;

    /* renamed from: c, reason: collision with root package name */
    public int f34651c;

    static {
        int[] iArr = new int[0];
        f34648d = iArr;
        f34649e = new zzias(iArr, 0, false);
    }

    public zzias(int[] iArr, int i2, boolean z) {
        super(z);
        this.f34650b = iArr;
        this.f34651c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f34651c)) {
            throw new IndexOutOfBoundsException(g(i2));
        }
        int i4 = i2 + 1;
        int[] iArr = this.f34650b;
        int length = iArr.length;
        if (i3 < length) {
            System.arraycopy(iArr, i2, iArr, i4, i3 - i2);
        } else {
            int[] iArr2 = new int[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34650b, 0, iArr2, 0, i2);
            System.arraycopy(this.f34650b, i2, iArr2, i4, this.f34651c - i2);
            this.f34650b = iArr2;
        }
        this.f34650b[i2] = iIntValue;
        this.f34651c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzibe.f34660a;
        collection.getClass();
        if (!(collection instanceof zzias)) {
            return super.addAll(collection);
        }
        zzias zziasVar = (zzias) collection;
        int i2 = zziasVar.f34651c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f34651c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f34650b;
        if (i4 > iArr.length) {
            this.f34650b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zziasVar.f34650b, 0, this.f34650b, this.f34651c, zziasVar.f34651c);
        this.f34651c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    /* renamed from: c */
    public final zziaz zzh(int i2) {
        if (i2 >= this.f34651c) {
            return new zzias(i2 == 0 ? f34648d : Arrays.copyOf(this.f34650b, i2), this.f34651c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i2) {
        f(i2);
        return this.f34650b[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzias)) {
            return super.equals(obj);
        }
        zzias zziasVar = (zzias) obj;
        if (this.f34651c != zziasVar.f34651c) {
            return false;
        }
        int[] iArr = zziasVar.f34650b;
        for (int i2 = 0; i2 < this.f34651c; i2++) {
            if (this.f34650b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f34651c) {
            throw new IndexOutOfBoundsException(g(i2));
        }
    }

    public final String g(int i2) {
        int i3 = this.f34651c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Integer.valueOf(this.f34650b[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f34651c; i3++) {
            i2 = (i2 * 31) + this.f34650b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f34651c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f34650b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        int[] iArr = this.f34650b;
        int i3 = iArr[i2];
        if (i2 < this.f34651c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f34651c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f34650b;
        System.arraycopy(iArr, i3, iArr, i2, this.f34651c - i3);
        this.f34651c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        f(i2);
        int[] iArr = this.f34650b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34651c;
    }

    @Override // com.google.android.gms.internal.ads.zziaz
    public final void zzi(int i2) {
        b();
        int i3 = this.f34651c;
        int length = this.f34650b.length;
        if (i3 == length) {
            int[] iArr = new int[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34650b, 0, iArr, 0, this.f34651c);
            this.f34650b = iArr;
        }
        int[] iArr2 = this.f34650b;
        int i4 = this.f34651c;
        this.f34651c = i4 + 1;
        iArr2[i4] = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzi(((Integer) obj).intValue());
        return true;
    }
}
