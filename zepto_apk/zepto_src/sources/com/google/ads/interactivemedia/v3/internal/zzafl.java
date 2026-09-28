package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzafl {
    private static final zzafl zza = new zzafl(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzafl(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzafl zzc() {
        return zza;
    }

    public static zzafl zze(zzafl zzaflVar, zzafl zzaflVar2) {
        int i2 = zzaflVar.zzb + zzaflVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaflVar.zzc, i2);
        System.arraycopy(zzaflVar2.zzc, 0, iArrCopyOf, zzaflVar.zzb, zzaflVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaflVar.zzd, i2);
        System.arraycopy(zzaflVar2.zzd, 0, objArrCopyOf, zzaflVar.zzb, zzaflVar2.zzb);
        return new zzafl(i2, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzafl zzf() {
        return new zzafl(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i2) {
        int[] iArr = this.zzc;
        if (i2 > iArr.length) {
            int i3 = this.zzb;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i2);
            this.zzd = Arrays.copyOf(this.zzd, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzafl)) {
            return false;
        }
        zzafl zzaflVar = (zzafl) obj;
        int i2 = this.zzb;
        if (i2 == zzaflVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaflVar.zzc;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaflVar.zzd;
                    int i4 = this.zzb;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
                if (iArr[i3] != iArr2[i3]) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        int i3 = i2 + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i3 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }

    public final int zza() {
        int iZzw;
        int iZzx;
        int iZzw2;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iZzw3 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).getClass();
                    iZzw2 = zzabw.zzw(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzabn zzabnVar = (zzabn) this.zzd[i3];
                    int iZzw4 = zzabw.zzw(i7);
                    int iZzd = zzabnVar.zzd();
                    iZzw3 = zzabw.zzw(iZzd) + iZzd + iZzw4 + iZzw3;
                } else if (i6 == 3) {
                    int iZzw5 = zzabw.zzw(i5 << 3);
                    iZzw = iZzw5 + iZzw5;
                    iZzx = ((zzafl) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzacz.zza());
                    }
                    ((Integer) this.zzd[i3]).getClass();
                    iZzw2 = zzabw.zzw(i5 << 3) + 4;
                }
                iZzw3 = iZzw2 + iZzw3;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzw = zzabw.zzw(i8);
                iZzx = zzabw.zzx(jLongValue);
            }
            iZzw3 = iZzx + iZzw + iZzw3;
        }
        this.zze = iZzw3;
        return iZzw3;
    }

    public final int zzb() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iB = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3] >>> 3;
            zzabn zzabnVar = (zzabn) this.zzd[i3];
            int iZzw = zzabw.zzw(8);
            int iZzw2 = zzabw.zzw(i4) + zzabw.zzw(16);
            int iZzw3 = zzabw.zzw(24);
            int iZzd = zzabnVar.zzd();
            iB = b.b(iZzw + iZzw, iZzw2, android.support.v4.media.a.w(iZzd, iZzd, iZzw3), iB);
        }
        this.zze = iB;
        return iB;
    }

    public final zzafl zzd(zzafl zzaflVar) {
        if (zzaflVar.equals(zza)) {
            return this;
        }
        zzg();
        int i2 = this.zzb + zzaflVar.zzb;
        zzm(i2);
        System.arraycopy(zzaflVar.zzc, 0, this.zzc, this.zzb, zzaflVar.zzb);
        System.arraycopy(zzaflVar.zzd, 0, this.zzd, this.zzb, zzaflVar.zzb);
        this.zzb = i2;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzaeb.zzb(sb, i2, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    public final void zzj(int i2, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i3 = this.zzb;
        iArr[i3] = i2;
        this.zzd[i3] = obj;
        this.zzb = i3 + 1;
    }

    public final void zzk(zzagc zzagcVar) throws IOException {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzagcVar.zzw(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzl(zzagc zzagcVar) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i3 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 == 0) {
                    zzagcVar.zzt(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzagcVar.zzm(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzagcVar.zzd(i5, (zzabn) obj);
                } else if (i4 == 3) {
                    zzagcVar.zzF(i5);
                    ((zzafl) obj).zzl(zzagcVar);
                    zzagcVar.zzh(i5);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzacz.zza());
                    }
                    zzagcVar.zzk(i5, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzafl() {
        this(0, new int[8], new Object[8], true);
    }
}
