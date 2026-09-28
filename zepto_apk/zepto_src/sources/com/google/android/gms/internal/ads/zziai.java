package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zziai extends zzhyx implements RandomAccess, zziay, zzicl {

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f34633d;

    /* renamed from: b, reason: collision with root package name */
    public float[] f34634b;

    /* renamed from: c, reason: collision with root package name */
    public int f34635c;

    static {
        float[] fArr = new float[0];
        f34633d = fArr;
        new zziai(fArr, 0, false);
    }

    public zziai(float[] fArr, int i2, boolean z) {
        super(z);
        this.f34634b = fArr;
        this.f34635c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f34635c)) {
            throw new IndexOutOfBoundsException(g(i2));
        }
        int i4 = i2 + 1;
        float[] fArr = this.f34634b;
        int length = fArr.length;
        if (i3 < length) {
            System.arraycopy(fArr, i2, fArr, i4, i3 - i2);
        } else {
            float[] fArr2 = new float[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34634b, 0, fArr2, 0, i2);
            System.arraycopy(this.f34634b, i2, fArr2, i4, this.f34635c - i2);
            this.f34634b = fArr2;
        }
        this.f34634b[i2] = fFloatValue;
        this.f34635c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzibe.f34660a;
        collection.getClass();
        if (!(collection instanceof zziai)) {
            return super.addAll(collection);
        }
        zziai zziaiVar = (zziai) collection;
        int i2 = zziaiVar.f34635c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f34635c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f34634b;
        if (i4 > fArr.length) {
            this.f34634b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zziaiVar.f34634b, 0, this.f34634b, this.f34635c, zziaiVar.f34635c);
        this.f34635c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzibd, com.google.android.gms.internal.ads.zziat
    /* renamed from: c */
    public final zziay zzh(int i2) {
        if (i2 >= this.f34635c) {
            return new zziai(i2 == 0 ? f34633d : Arrays.copyOf(this.f34634b, i2), this.f34635c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f2) {
        b();
        int i2 = this.f34635c;
        int length = this.f34634b.length;
        if (i2 == length) {
            float[] fArr = new float[androidx.fragment.app.e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f34634b, 0, fArr, 0, this.f34635c);
            this.f34634b = fArr;
        }
        float[] fArr2 = this.f34634b;
        int i3 = this.f34635c;
        this.f34635c = i3 + 1;
        fArr2[i3] = f2;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziai)) {
            return super.equals(obj);
        }
        zziai zziaiVar = (zziai) obj;
        if (this.f34635c != zziaiVar.f34635c) {
            return false;
        }
        float[] fArr = zziaiVar.f34634b;
        for (int i2 = 0; i2 < this.f34635c; i2++) {
            if (Float.floatToIntBits(this.f34634b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f34635c) {
            throw new IndexOutOfBoundsException(g(i2));
        }
    }

    public final String g(int i2) {
        int i3 = this.f34635c;
        return androidx.fragment.app.e.n(i2, i3, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i3).length()));
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        f(i2);
        return Float.valueOf(this.f34634b[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f34635c; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f34634b[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.f34635c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f34634b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        f(i2);
        float[] fArr = this.f34634b;
        float f2 = fArr[i2];
        if (i2 < this.f34635c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f34635c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f34634b;
        System.arraycopy(fArr, i3, fArr, i2, this.f34635c - i3);
        this.f34635c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        f(i2);
        float[] fArr = this.f34634b;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f34635c;
    }

    @Override // com.google.android.gms.internal.ads.zzhyx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
