package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.a;
import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzdi extends zzcb implements RandomAccess, zzdm, zzev {

    /* renamed from: d, reason: collision with root package name */
    public static final zzdi f36122d = new zzdi(new int[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public int[] f36123b;

    /* renamed from: c, reason: collision with root package name */
    public int f36124c;

    public zzdi(int[] iArr, int i2, boolean z) {
        super(z);
        this.f36123b = iArr;
        this.f36124c = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36124c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36124c, "Index:", ", Size:"));
        }
        int[] iArr = this.f36123b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f36123b, i2, iArr2, i2 + 1, this.f36124c - i2);
            this.f36123b = iArr2;
        }
        this.f36123b[i2] = iIntValue;
        this.f36124c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzdp.f36125a;
        collection.getClass();
        if (!(collection instanceof zzdi)) {
            return super.addAll(collection);
        }
        zzdi zzdiVar = (zzdi) collection;
        int i2 = zzdiVar.f36124c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36124c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f36123b;
        if (i4 > iArr.length) {
            this.f36123b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zzdiVar.f36123b, 0, this.f36123b, this.f36124c, zzdiVar.f36124c);
        this.f36124c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f36124c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36124c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdi)) {
            return super.equals(obj);
        }
        zzdi zzdiVar = (zzdi) obj;
        if (this.f36124c != zzdiVar.f36124c) {
            return false;
        }
        int[] iArr = zzdiVar.f36123b;
        for (int i2 = 0; i2 < this.f36124c; i2++) {
            if (this.f36123b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        d(i2);
        return Integer.valueOf(this.f36123b[i2]);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36124c; i3++) {
            i2 = (i2 * 31) + this.f36123b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f36124c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36123b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        d(i2);
        int[] iArr = this.f36123b;
        int i3 = iArr[i2];
        if (i2 < this.f36124c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f36124c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f36123b;
        System.arraycopy(iArr, i3, iArr, i2, this.f36124c - i3);
        this.f36124c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        d(i2);
        int[] iArr = this.f36123b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36124c;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdo
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdm zzg(int i2) {
        if (i2 >= this.f36124c) {
            return new zzdi(Arrays.copyOf(this.f36123b, i2), this.f36124c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdm
    public final void zzh(int i2) {
        b();
        int i3 = this.f36124c;
        int[] iArr = this.f36123b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f36123b = iArr2;
        }
        int[] iArr3 = this.f36123b;
        int i4 = this.f36124c;
        this.f36124c = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
