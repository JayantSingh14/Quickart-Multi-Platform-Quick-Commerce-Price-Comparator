package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class zzaej extends zzaax implements RandomAccess {
    private static final zzaej zza = new zzaej(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    public zzaej() {
        this(new Object[10], 0, true);
    }

    public static zzaej zze() {
        return zza;
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
    public final void add(int i2, Object obj) {
        int i3;
        zza();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        int i4 = i2 + 1;
        Object[] objArr = this.zzb;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i4, i3 - i2);
        } else {
            Object[] objArr2 = new Object[android.support.v4.media.a.x(i3, 3, 2, 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.zzb, i2, objArr2, i4, this.zzc - i2);
            this.zzb = objArr2;
        }
        this.zzb[i2] = obj;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        zzg(i2);
        return this.zzb[i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        zza();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj = objArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        zza();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacw
    public final /* bridge */ /* synthetic */ zzacw zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzaej(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzaej(Object[] objArr, int i2, boolean z) {
        super(z);
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i2 = this.zzc;
        Object[] objArr = this.zzb;
        if (i2 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
