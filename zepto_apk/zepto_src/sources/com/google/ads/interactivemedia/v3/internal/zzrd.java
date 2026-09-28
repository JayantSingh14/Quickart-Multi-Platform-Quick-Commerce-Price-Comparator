package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzrd extends zzqk {
    static final zzrd zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzrd(objArr, 0, objArr, 0, 0);
    }

    public zzrd(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.zzb = objArr;
        this.zze = i2;
        this.zzc = objArr2;
        this.zzf = i3;
        this.zzg = i4;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZzc = zzpz.zzc(obj);
                while (true) {
                    int i2 = iZzc & this.zzf;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZzc = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzc() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    /* renamed from: zze */
    public final zzrl iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final Object[] zzg() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk
    public final boolean zzi() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk
    public final zzqf zzk() {
        return zzqf.zzj(this.zzb, this.zzg);
    }
}
