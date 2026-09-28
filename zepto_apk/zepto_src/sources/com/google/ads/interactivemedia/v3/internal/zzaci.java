package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class zzaci extends zzaax implements RandomAccess, zzacw, zzaeh {
    private static final zzaci zza = new zzaci(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    public zzaci() {
        this(new float[10], 0, true);
    }

    private final String zzf(int i2) {
        return b.d(i2, this.zzc, "Index:", ", Size:");
    }

    private final void zzg(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        int i4 = i2 + 1;
        float[] fArr = this.zzb;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i4, i3 - i2);
        } else {
            float[] fArr2 = new float[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.zzb, i2, fArr2, i4, this.zzc - i2);
            this.zzb = fArr2;
        }
        this.zzb[i2] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzacx.zzd;
        collection.getClass();
        if (!(collection instanceof zzaci)) {
            return super.addAll(collection);
        }
        zzaci zzaciVar = (zzaci) collection;
        int i2 = zzaciVar.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.zzb;
        if (i4 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zzaciVar.zzb, 0, this.zzb, this.zzc, zzaciVar.zzc);
        this.zzc = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaci)) {
            return super.equals(obj);
        }
        zzaci zzaciVar = (zzaci) obj;
        if (this.zzc != zzaciVar.zzc) {
            return false;
        }
        float[] fArr = zzaciVar.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (Float.floatToIntBits(this.zzb[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzg(i2);
        return Float.valueOf(this.zzb[i2]);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzb[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzg(i2);
        float[] fArr = this.zzb;
        float f2 = fArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        zza();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i3, fArr, i2, this.zzc - i3);
        this.zzc -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzg(i2);
        float[] fArr = this.zzb;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacw
    public final /* bridge */ /* synthetic */ zzacw zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzaci(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f2) {
        zza();
        int i2 = this.zzc;
        float[] fArr = this.zzb;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[android.support.v4.media.a.x(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        fArr3[i3] = f2;
    }

    private zzaci(float[] fArr, int i2, boolean z) {
        super(z);
        this.zzb = fArr;
        this.zzc = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
