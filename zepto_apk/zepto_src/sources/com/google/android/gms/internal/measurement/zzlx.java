package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzlx extends zzkt implements RandomAccess, zzmk, zzns {

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f37101d;

    /* renamed from: b, reason: collision with root package name */
    public float[] f37102b;

    /* renamed from: c, reason: collision with root package name */
    public int f37103c;

    static {
        float[] fArr = new float[0];
        f37101d = fArr;
        new zzlx(fArr, 0, false);
    }

    public zzlx(float[] fArr, int i2, boolean z) {
        super(z);
        this.f37102b = fArr;
        this.f37103c = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f37103c)) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37103c, i2, (byte) 13, "Index:", ", Size:"));
        }
        int i4 = i2 + 1;
        float[] fArr = this.f37102b;
        int length = fArr.length;
        if (i3 < length) {
            System.arraycopy(fArr, i2, fArr, i4, i3 - i2);
        } else {
            float[] fArr2 = new float[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37102b, 0, fArr2, 0, i2);
            System.arraycopy(this.f37102b, i2, fArr2, i4, this.f37103c - i2);
            this.f37102b = fArr2;
        }
        this.f37102b[i2] = fFloatValue;
        this.f37103c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = zzmo.f37112a;
        collection.getClass();
        if (!(collection instanceof zzlx)) {
            return super.addAll(collection);
        }
        zzlx zzlxVar = (zzlx) collection;
        int i2 = zzlxVar.f37103c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37103c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f37102b;
        if (i4 > fArr.length) {
            this.f37102b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zzlxVar.f37102b, 0, this.f37102b, this.f37103c, zzlxVar.f37103c);
        this.f37103c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final float d(int i2) {
        g(i2);
        return this.f37102b[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlx)) {
            return super.equals(obj);
        }
        zzlx zzlxVar = (zzlx) obj;
        if (this.f37103c != zzlxVar.f37103c) {
            return false;
        }
        float[] fArr = zzlxVar.f37102b;
        for (int i2 = 0; i2 < this.f37103c; i2++) {
            if (Float.floatToIntBits(this.f37102b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(float f2) {
        b();
        int i2 = this.f37103c;
        int length = this.f37102b.length;
        if (i2 == length) {
            float[] fArr = new float[e.d(length, 3, 2, 1, 10)];
            System.arraycopy(this.f37102b, 0, fArr, 0, this.f37103c);
            this.f37102b = fArr;
        }
        float[] fArr2 = this.f37102b;
        int i3 = this.f37103c;
        this.f37103c = i3 + 1;
        fArr2[i3] = f2;
    }

    public final void g(int i2) {
        if (i2 < 0 || i2 >= this.f37103c) {
            throw new IndexOutOfBoundsException(zzkv.a(this.f37103c, i2, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Float.valueOf(this.f37102b[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f37103c; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f37102b[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.f37103c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f37102b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        b();
        g(i2);
        float[] fArr = this.f37102b;
        float f2 = fArr[i2];
        if (i2 < this.f37103c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f37103c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f37102b;
        System.arraycopy(fArr, i3, fArr, i2, this.f37103c - i3);
        this.f37103c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        g(i2);
        float[] fArr = this.f37102b;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37103c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* renamed from: zzd */
    public final zzmk zzg(int i2) {
        if (i2 >= this.f37103c) {
            return new zzlx(i2 == 0 ? f37101d : Arrays.copyOf(this.f37102b, i2), this.f37103c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        int length = this.f37102b.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.f37102b = new float[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = e.d(length, 3, 2, 1, 10);
        }
        this.f37102b = Arrays.copyOf(this.f37102b, length);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Float) obj).floatValue());
        return true;
    }
}
