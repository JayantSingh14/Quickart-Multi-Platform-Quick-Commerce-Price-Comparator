package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzact extends zzabj implements RandomAccess, zzadf, zzaem {

    /* renamed from: b, reason: collision with root package name */
    public float[] f37401b;

    /* renamed from: c, reason: collision with root package name */
    public int f37402c;

    static {
        new zzact(0, new float[0]).f37350a = false;
    }

    public zzact(int i2, float[] fArr) {
        this.f37401b = fArr;
        this.f37402c = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37402c)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37402c, "Index:", ", Size:"));
        }
        float[] fArr = this.f37401b;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f37401b, i2, fArr2, i2 + 1, this.f37402c - i2);
            this.f37401b = fArr2;
        }
        this.f37401b[i2] = fFloatValue;
        this.f37402c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzadg.f37410a;
        collection.getClass();
        if (!(collection instanceof zzact)) {
            return super.addAll(collection);
        }
        zzact zzactVar = (zzact) collection;
        int i2 = zzactVar.f37402c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37402c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f37401b;
        if (i4 > fArr.length) {
            this.f37401b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zzactVar.f37401b, 0, this.f37401b, this.f37402c, zzactVar.f37402c);
        this.f37402c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f2) {
        b();
        int i2 = this.f37402c;
        float[] fArr = this.f37401b;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[android.support.v4.media.a.x(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f37401b = fArr2;
        }
        float[] fArr3 = this.f37401b;
        int i3 = this.f37402c;
        this.f37402c = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzact)) {
            return super.equals(obj);
        }
        zzact zzactVar = (zzact) obj;
        if (this.f37402c != zzactVar.f37402c) {
            return false;
        }
        float[] fArr = zzactVar.f37401b;
        for (int i2 = 0; i2 < this.f37402c; i2++) {
            if (Float.floatToIntBits(this.f37401b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f37402c) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, this.f37402c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Float.valueOf(this.f37401b[i2]);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f37402c; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f37401b[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.f37402c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37401b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        float[] fArr = this.f37401b;
        float f2 = fArr[i2];
        if (i2 < this.f37402c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f37402c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f37401b;
        System.arraycopy(fArr, i3, fArr, i2, this.f37402c - i3);
        this.f37402c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        f(i2);
        float[] fArr = this.f37401b;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37402c;
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final /* bridge */ /* synthetic */ zzadf zzd(int i2) {
        if (i2 < this.f37402c) {
            throw new IllegalArgumentException();
        }
        return new zzact(this.f37402c, Arrays.copyOf(this.f37401b, i2));
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
