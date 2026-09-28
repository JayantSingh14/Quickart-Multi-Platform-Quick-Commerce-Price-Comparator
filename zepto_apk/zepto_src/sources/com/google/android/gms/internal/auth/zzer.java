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
final class zzer extends zzdr implements RandomAccess, zzez, zzge {

    /* renamed from: b, reason: collision with root package name */
    public float[] f36348b;

    /* renamed from: c, reason: collision with root package name */
    public int f36349c;

    static {
        new zzer(new float[0], 0, false);
    }

    public zzer(float[] fArr, int i2, boolean z) {
        super(z);
        this.f36348b = fArr;
        this.f36349c = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f36349c)) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36349c, "Index:", ", Size:"));
        }
        float[] fArr = this.f36348b;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[a.x(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f36348b, i2, fArr2, i2 + 1, this.f36349c - i2);
            this.f36348b = fArr2;
        }
        this.f36348b[i2] = fFloatValue;
        this.f36349c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzfa.f36355a;
        collection.getClass();
        if (!(collection instanceof zzer)) {
            return super.addAll(collection);
        }
        zzer zzerVar = (zzer) collection;
        int i2 = zzerVar.f36349c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f36349c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f36348b;
        if (i4 > fArr.length) {
            this.f36348b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zzerVar.f36348b, 0, this.f36348b, this.f36349c, zzerVar.f36349c);
        this.f36349c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f2) {
        b();
        int i2 = this.f36349c;
        float[] fArr = this.f36348b;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[a.x(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f36348b = fArr2;
        }
        float[] fArr3 = this.f36348b;
        int i3 = this.f36349c;
        this.f36349c = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzer)) {
            return super.equals(obj);
        }
        zzer zzerVar = (zzer) obj;
        if (this.f36349c != zzerVar.f36349c) {
            return false;
        }
        float[] fArr = zzerVar.f36348b;
        for (int i2 = 0; i2 < this.f36349c; i2++) {
            if (Float.floatToIntBits(this.f36348b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f36349c) {
            throw new IndexOutOfBoundsException(b.d(i2, this.f36349c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Float.valueOf(this.f36348b[i2]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f36349c; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f36348b[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.f36349c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f36348b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        float[] fArr = this.f36348b;
        float f2 = fArr[i2];
        if (i2 < this.f36349c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f36349c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f36348b;
        System.arraycopy(fArr, i3, fArr, i2, this.f36349c - i3);
        this.f36349c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        f(i2);
        float[] fArr = this.f36348b;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36349c;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i2) {
        if (i2 >= this.f36349c) {
            return new zzer(Arrays.copyOf(this.f36348b, i2), this.f36349c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
