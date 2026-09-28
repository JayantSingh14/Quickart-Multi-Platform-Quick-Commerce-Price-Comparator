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
final class zzew extends zzdr implements RandomAccess, zzez, zzge {

    /* renamed from: b, reason: collision with root package name */
    public int[] f36353b;

    /* renamed from: c, reason: collision with root package name */
    public int f36354c;

    static {
        new zzew(new int[0], 0, false);
    }

    public zzew(int[] iArr, int i2, boolean z) {
        super(z);
        this.f36353b = iArr;
        this.f36354c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36354c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36354c, "Index:", ", Size:"));
        }
        int[] iArr = this.f36353b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f36353b, i2, iArr2, i2 + 1, this.f36354c - i2);
            this.f36353b = iArr2;
        }
        this.f36353b[i2] = iIntValue;
        this.f36354c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzfa.f36355a;
        collection.getClass();
        if (!(collection instanceof zzew)) {
            return super.addAll(collection);
        }
        zzew zzewVar = (zzew) collection;
        int i2 = zzewVar.f36354c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36354c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f36353b;
        if (i4 > iArr.length) {
            this.f36353b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zzewVar.f36353b, 0, this.f36353b, this.f36354c, zzewVar.f36354c);
        this.f36354c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        b();
        int i3 = this.f36354c;
        int[] iArr = this.f36353b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f36353b = iArr2;
        }
        int[] iArr3 = this.f36353b;
        int i4 = this.f36354c;
        this.f36354c = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzew)) {
            return super.equals(obj);
        }
        zzew zzewVar = (zzew) obj;
        if (this.f36354c != zzewVar.f36354c) {
            return false;
        }
        int[] iArr = zzewVar.f36353b;
        for (int i2 = 0; i2 < this.f36354c; i2++) {
            if (this.f36353b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f36354c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36354c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Integer.valueOf(this.f36353b[i2]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f36354c; i3++) {
            i2 = (i2 * 31) + this.f36353b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f36354c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36353b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        int[] iArr = this.f36353b;
        int i3 = iArr[i2];
        if (i2 < this.f36354c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f36354c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f36353b;
        System.arraycopy(iArr, i3, iArr, i2, this.f36354c - i3);
        this.f36354c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        f(i2);
        int[] iArr = this.f36353b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36354c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36354c) {
            return new zzew(Arrays.copyOf(this.f36353b, i2), this.f36354c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
