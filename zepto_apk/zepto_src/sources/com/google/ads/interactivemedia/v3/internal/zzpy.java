package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzpy extends AbstractMap implements Serializable, zzpl {
    transient Object[] zza;
    transient Object[] zzb;
    transient int zzc;
    transient int zzd;
    private transient int[] zze;
    private transient int[] zzf;
    private transient int[] zzg;
    private transient int[] zzh;
    private transient int zzi;
    private transient int zzj;
    private transient int[] zzk;
    private transient int[] zzl;
    private transient Set zzm;
    private transient Set zzn;
    private transient Set zzo;

    @CheckForNull
    private transient zzpl zzp;

    private zzpy(int i2) {
        int iZza = zzpz.zza(2, 1.0d);
        this.zzc = 0;
        this.zza = new Object[2];
        this.zzb = new Object[2];
        this.zze = zzy(iZza);
        this.zzf = zzy(iZza);
        this.zzg = zzy(2);
        this.zzh = zzy(2);
        this.zzi = -2;
        this.zzj = -2;
        this.zzk = zzy(2);
        this.zzl = zzy(2);
    }

    public static zzpy zzf(int i2) {
        return new zzpy(2);
    }

    private final int zzo(int i2) {
        return i2 & (this.zze.length - 1);
    }

    private final void zzp(int i2, int i3) {
        zzpd.zzc(i2 != -1);
        int iZzo = zzo(i3);
        int[] iArr = this.zze;
        int i4 = iArr[iZzo];
        if (i4 == i2) {
            int[] iArr2 = this.zzg;
            iArr[iZzo] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i5 = this.zzg[i4];
        while (true) {
            int i6 = i4;
            i4 = i5;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with key ".concat(String.valueOf(this.zza[i2])));
            }
            if (i4 == i2) {
                int[] iArr3 = this.zzg;
                iArr3[i6] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            }
            i5 = this.zzg[i4];
        }
    }

    private final void zzq(int i2, int i3) {
        zzpd.zzc(i2 != -1);
        int iZzo = zzo(i3);
        int[] iArr = this.zzf;
        int i4 = iArr[iZzo];
        if (i4 == i2) {
            int[] iArr2 = this.zzh;
            iArr[iZzo] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i5 = this.zzh[i4];
        while (true) {
            int i6 = i4;
            i4 = i5;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with value ".concat(String.valueOf(this.zzb[i2])));
            }
            if (i4 == i2) {
                int[] iArr3 = this.zzh;
                iArr3[i6] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            }
            i5 = this.zzh[i4];
        }
    }

    private final void zzr(int i2) {
        int length = this.zzg.length;
        if (length < i2) {
            int iZza = zzqa.zza(length, i2);
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzb = Arrays.copyOf(this.zzb, iZza);
            this.zzg = zzz(this.zzg, iZza);
            this.zzh = zzz(this.zzh, iZza);
            this.zzk = zzz(this.zzk, iZza);
            this.zzl = zzz(this.zzl, iZza);
        }
        if (this.zze.length < i2) {
            int iZza2 = zzpz.zza(i2, 1.0d);
            this.zze = zzy(iZza2);
            this.zzf = zzy(iZza2);
            for (int i3 = 0; i3 < this.zzc; i3++) {
                int iZzo = zzo(zzpz.zzc(this.zza[i3]));
                int[] iArr = this.zzg;
                int[] iArr2 = this.zze;
                iArr[i3] = iArr2[iZzo];
                iArr2[iZzo] = i3;
                int iZzo2 = zzo(zzpz.zzc(this.zzb[i3]));
                int[] iArr3 = this.zzh;
                int[] iArr4 = this.zzf;
                iArr3[i3] = iArr4[iZzo2];
                iArr4[iZzo2] = i3;
            }
        }
    }

    private final void zzs(int i2, int i3) {
        zzpd.zzc(i2 != -1);
        int iZzo = zzo(i3);
        int[] iArr = this.zzg;
        int[] iArr2 = this.zze;
        iArr[i2] = iArr2[iZzo];
        iArr2[iZzo] = i2;
    }

    private final void zzt(int i2, int i3) {
        zzpd.zzc(i2 != -1);
        int iZzo = zzo(i3);
        int[] iArr = this.zzh;
        int[] iArr2 = this.zzf;
        iArr[i2] = iArr2[iZzo];
        iArr2[iZzo] = i2;
    }

    private final void zzu(int i2, int i3, int i4) {
        int i5;
        int i6;
        zzpd.zzc(i2 != -1);
        zzp(i2, i3);
        zzq(i2, i4);
        zzx(this.zzk[i2], this.zzl[i2]);
        int i7 = this.zzc - 1;
        if (i7 != i2) {
            int i8 = this.zzk[i7];
            int i9 = this.zzl[i7];
            zzx(i8, i2);
            zzx(i2, i9);
            Object[] objArr = this.zza;
            Object obj = objArr[i7];
            Object[] objArr2 = this.zzb;
            Object obj2 = objArr2[i7];
            objArr[i2] = obj;
            objArr2[i2] = obj2;
            int iZzo = zzo(zzpz.zzc(obj));
            int[] iArr = this.zze;
            int i10 = iArr[iZzo];
            if (i10 == i7) {
                iArr[iZzo] = i2;
            } else {
                int i11 = this.zzg[i10];
                while (true) {
                    i5 = i10;
                    i10 = i11;
                    if (i10 == i7) {
                        break;
                    } else {
                        i11 = this.zzg[i10];
                    }
                }
                this.zzg[i5] = i2;
            }
            int[] iArr2 = this.zzg;
            iArr2[i2] = iArr2[i7];
            iArr2[i7] = -1;
            int iZzo2 = zzo(zzpz.zzc(obj2));
            int[] iArr3 = this.zzf;
            int i12 = iArr3[iZzo2];
            if (i12 == i7) {
                iArr3[iZzo2] = i2;
            } else {
                int i13 = this.zzh[i12];
                while (true) {
                    i6 = i12;
                    i12 = i13;
                    if (i12 == i7) {
                        break;
                    } else {
                        i13 = this.zzh[i12];
                    }
                }
                this.zzh[i6] = i2;
            }
            int[] iArr4 = this.zzh;
            iArr4[i2] = iArr4[i7];
            iArr4[i7] = -1;
        }
        Object[] objArr3 = this.zza;
        int i14 = this.zzc - 1;
        objArr3[i14] = null;
        this.zzb[i14] = null;
        this.zzc = i14;
        this.zzd++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(int i2, Object obj, boolean z) {
        zzpd.zzc(i2 != -1);
        int iZzc = zzc(obj, zzpz.zzc(obj));
        int i3 = this.zzj;
        if (iZzc != -1) {
            throw new IllegalArgumentException("Key already present in map: ".concat(String.valueOf(obj)));
        }
        if (i3 == i2) {
            i3 = this.zzk[i2];
        } else if (i3 == this.zzc) {
            i3 = iZzc;
        }
        if (i2 == -2) {
            iZzc = this.zzl[-2];
        } else if (this.zzc != -2) {
            iZzc = -2;
        }
        zzx(this.zzk[i2], this.zzl[i2]);
        zzp(i2, zzpz.zzc(this.zza[i2]));
        this.zza[i2] = obj;
        zzs(i2, zzpz.zzc(obj));
        zzx(i3, i2);
        zzx(i2, iZzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw(int i2, Object obj, boolean z) {
        zzpd.zzc(i2 != -1);
        int iZzc = zzpz.zzc(obj);
        if (zzd(obj, iZzc) != -1) {
            throw new IllegalArgumentException("Value already present in map: ".concat(String.valueOf(obj)));
        }
        zzq(i2, zzpz.zzc(this.zzb[i2]));
        this.zzb[i2] = obj;
        zzt(i2, iZzc);
    }

    private final void zzx(int i2, int i3) {
        if (i2 == -2) {
            this.zzi = i3;
        } else {
            this.zzl[i2] = i3;
        }
        if (i3 == -2) {
            this.zzj = i2;
        } else {
            this.zzk[i3] = i2;
        }
    }

    private static int[] zzy(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static int[] zzz(int[] iArr, int i2) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
        Arrays.fill(iArrCopyOf, length, i2, -1);
        return iArrCopyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.zza, 0, this.zzc, (Object) null);
        Arrays.fill(this.zzb, 0, this.zzc, (Object) null);
        Arrays.fill(this.zze, -1);
        Arrays.fill(this.zzf, -1);
        Arrays.fill(this.zzg, 0, this.zzc, -1);
        Arrays.fill(this.zzh, 0, this.zzc, -1);
        Arrays.fill(this.zzk, 0, this.zzc, -1);
        Arrays.fill(this.zzl, 0, this.zzc, -1);
        this.zzc = 0;
        this.zzi = -2;
        this.zzj = -2;
        this.zzd++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return zzc(obj, zzpz.zzc(obj)) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return zzd(obj, zzpz.zzc(obj)) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzo;
        if (set != null) {
            return set;
        }
        zzpr zzprVar = new zzpr(this);
        this.zzo = zzprVar;
        return zzprVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        int iZzc = zzc(obj, zzpz.zzc(obj));
        if (iZzc == -1) {
            return null;
        }
        return this.zzb[iZzc];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzm;
        if (set != null) {
            return set;
        }
        zzpu zzpuVar = new zzpu(this);
        this.zzm = zzpuVar;
        return zzpuVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        return zzg(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        int iZzc = zzpz.zzc(obj);
        int iZzc2 = zzc(obj, iZzc);
        if (iZzc2 == -1) {
            return null;
        }
        Object obj2 = this.zzb[iZzc2];
        zzl(iZzc2, iZzc);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzc;
    }

    public final int zzb(@CheckForNull Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        int i3 = iArr[zzo(i2)];
        while (i3 != -1) {
            if (zzox.zza(objArr[i3], obj)) {
                return i3;
            }
            i3 = iArr2[i3];
        }
        return -1;
    }

    public final int zzc(@CheckForNull Object obj, int i2) {
        return zzb(obj, i2, this.zze, this.zzg, this.zza);
    }

    public final int zzd(@CheckForNull Object obj, int i2) {
        return zzb(obj, i2, this.zzf, this.zzh, this.zzb);
    }

    public final zzpl zze() {
        zzpl zzplVar = this.zzp;
        if (zzplVar != null) {
            return zzplVar;
        }
        zzps zzpsVar = new zzps(this);
        this.zzp = zzpsVar;
        return zzpsVar;
    }

    @CheckForNull
    public final Object zzg(Object obj, Object obj2, boolean z) {
        int iZzc = zzpz.zzc(obj);
        int iZzc2 = zzc(obj, iZzc);
        if (iZzc2 != -1) {
            Object obj3 = this.zzb[iZzc2];
            if (zzox.zza(obj3, obj2)) {
                return obj2;
            }
            zzw(iZzc2, obj2, false);
            return obj3;
        }
        int iZzc3 = zzpz.zzc(obj2);
        zzpd.zze(zzd(obj2, iZzc3) == -1, "Value already present: %s", obj2);
        zzr(this.zzc + 1);
        Object[] objArr = this.zza;
        int i2 = this.zzc;
        objArr[i2] = obj;
        this.zzb[i2] = obj2;
        zzs(i2, iZzc);
        zzt(this.zzc, iZzc3);
        zzx(this.zzj, this.zzc);
        zzx(this.zzc, -2);
        this.zzc++;
        this.zzd++;
        return null;
    }

    @CheckForNull
    public final Object zzh(Object obj, Object obj2, boolean z) {
        int iZzc = zzpz.zzc(obj);
        int iZzd = zzd(obj, iZzc);
        if (iZzd != -1) {
            Object obj3 = this.zza[iZzd];
            if (zzox.zza(obj3, obj2)) {
                return obj2;
            }
            zzv(iZzd, obj2, false);
            return obj3;
        }
        int i2 = this.zzj;
        int iZzc2 = zzpz.zzc(obj2);
        zzpd.zze(zzc(obj2, iZzc2) == -1, "Key already present: %s", obj2);
        zzr(this.zzc + 1);
        Object[] objArr = this.zza;
        int i3 = this.zzc;
        objArr[i3] = obj2;
        this.zzb[i3] = obj;
        zzs(i3, iZzc2);
        zzt(this.zzc, iZzc);
        int i4 = i2 == -2 ? this.zzi : this.zzl[i2];
        zzx(i2, this.zzc);
        zzx(this.zzc, i4);
        this.zzc++;
        this.zzd++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final Set values() {
        Set set = this.zzn;
        if (set != null) {
            return set;
        }
        zzpv zzpvVar = new zzpv(this);
        this.zzn = zzpvVar;
        return zzpvVar;
    }

    public final void zzl(int i2, int i3) {
        zzu(i2, i3, zzpz.zzc(this.zzb[i2]));
    }

    public final void zzm(int i2, int i3) {
        zzu(i2, zzpz.zzc(this.zza[i2]), i3);
    }
}
