package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class zzaba {
    public static int zza(byte[] bArr, int i2, zzaaz zzaazVar) throws zzacz {
        int iZzh = zzh(bArr, i2, zzaazVar);
        int i3 = zzaazVar.zza;
        if (i3 < 0) {
            throw zzacz.zzf();
        }
        if (i3 > bArr.length - iZzh) {
            throw zzacz.zzi();
        }
        if (i3 == 0) {
            zzaazVar.zzc = zzabn.zzb;
            return iZzh;
        }
        zzaazVar.zzc = zzabn.zzs(bArr, iZzh, i3);
        return iZzh + i3;
    }

    public static int zzb(byte[] bArr, int i2) {
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public static int zzc(zzaet zzaetVar, byte[] bArr, int i2, int i3, int i4, zzaaz zzaazVar) throws IOException {
        Object objZze = zzaetVar.zze();
        int iZzl = zzl(objZze, zzaetVar, bArr, i2, i3, i4, zzaazVar);
        zzaetVar.zzf(objZze);
        zzaazVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzaet zzaetVar, byte[] bArr, int i2, int i3, zzaaz zzaazVar) throws IOException {
        Object objZze = zzaetVar.zze();
        int iZzm = zzm(objZze, zzaetVar, bArr, i2, i3, zzaazVar);
        zzaetVar.zzf(objZze);
        zzaazVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzaet zzaetVar, int i2, byte[] bArr, int i3, int i4, zzacw zzacwVar, zzaaz zzaazVar) throws IOException {
        int iZzd = zzd(zzaetVar, bArr, i3, i4, zzaazVar);
        zzacwVar.add(zzaazVar.zzc);
        while (iZzd < i4) {
            int iZzh = zzh(bArr, iZzd, zzaazVar);
            if (i2 != zzaazVar.zza) {
                break;
            }
            iZzd = zzd(zzaetVar, bArr, iZzh, i4, zzaazVar);
            zzacwVar.add(zzaazVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i2, zzacw zzacwVar, zzaaz zzaazVar) throws IOException {
        zzacr zzacrVar = (zzacr) zzacwVar;
        int iZzh = zzh(bArr, i2, zzaazVar);
        int i3 = zzaazVar.zza + iZzh;
        while (iZzh < i3) {
            iZzh = zzh(bArr, iZzh, zzaazVar);
            zzacrVar.zzg(zzaazVar.zza);
        }
        if (iZzh == i3) {
            return iZzh;
        }
        throw zzacz.zzi();
    }

    public static int zzg(int i2, byte[] bArr, int i3, int i4, zzafl zzaflVar, zzaaz zzaazVar) throws zzacz {
        if ((i2 >>> 3) == 0) {
            throw zzacz.zzc();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iZzk = zzk(bArr, i3, zzaazVar);
            zzaflVar.zzj(i2, Long.valueOf(zzaazVar.zzb));
            return iZzk;
        }
        if (i5 == 1) {
            zzaflVar.zzj(i2, Long.valueOf(zzn(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iZzh = zzh(bArr, i3, zzaazVar);
            int i6 = zzaazVar.zza;
            if (i6 < 0) {
                throw zzacz.zzf();
            }
            if (i6 > bArr.length - iZzh) {
                throw zzacz.zzi();
            }
            if (i6 == 0) {
                zzaflVar.zzj(i2, zzabn.zzb);
            } else {
                zzaflVar.zzj(i2, zzabn.zzs(bArr, iZzh, i6));
            }
            return iZzh + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw zzacz.zzc();
            }
            zzaflVar.zzj(i2, Integer.valueOf(zzb(bArr, i3)));
            return i3 + 4;
        }
        int i7 = (i2 & (-8)) | 4;
        zzafl zzaflVarZzf = zzafl.zzf();
        int i8 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iZzh2 = zzh(bArr, i3, zzaazVar);
            i8 = zzaazVar.zza;
            if (i8 == i7) {
                i3 = iZzh2;
                break;
            }
            i3 = zzg(i8, bArr, iZzh2, i4, zzaflVarZzf, zzaazVar);
        }
        if (i3 > i4 || i8 != i7) {
            throw zzacz.zzg();
        }
        zzaflVar.zzj(i2, zzaflVarZzf);
        return i3;
    }

    public static int zzh(byte[] bArr, int i2, zzaaz zzaazVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return zzi(b2, bArr, i3, zzaazVar);
        }
        zzaazVar.zza = b2;
        return i3;
    }

    public static int zzi(int i2, byte[] bArr, int i3, zzaaz zzaazVar) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & WKSRecord.Service.LOCUS_CON;
        if (b2 >= 0) {
            zzaazVar.zza = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzaazVar.zza = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzaazVar.zza = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzaazVar.zza = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzaazVar.zza = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int zzj(int i2, byte[] bArr, int i3, int i4, zzacw zzacwVar, zzaaz zzaazVar) {
        zzacr zzacrVar = (zzacr) zzacwVar;
        int iZzh = zzh(bArr, i3, zzaazVar);
        zzacrVar.zzg(zzaazVar.zza);
        while (iZzh < i4) {
            int iZzh2 = zzh(bArr, iZzh, zzaazVar);
            if (i2 != zzaazVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzaazVar);
            zzacrVar.zzg(zzaazVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i2, zzaaz zzaazVar) {
        long j2 = bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            zzaazVar.zzb = j2;
            return i3;
        }
        int i4 = i2 + 2;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | ((b2 & 127) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & 127) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        zzaazVar.zzb = j3;
        return i4;
    }

    public static int zzl(Object obj, zzaet zzaetVar, byte[] bArr, int i2, int i3, int i4, zzaaz zzaazVar) throws IOException {
        int iZzc = ((zzaec) zzaetVar).zzc(obj, bArr, i2, i3, i4, zzaazVar);
        zzaazVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzaet zzaetVar, byte[] bArr, int i2, int i3, zzaaz zzaazVar) throws IOException {
        int iZzi = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iZzi = zzi(i4, bArr, iZzi, zzaazVar);
            i4 = zzaazVar.zza;
        }
        int i5 = iZzi;
        if (i4 < 0 || i4 > i3 - i5) {
            throw zzacz.zzi();
        }
        int i6 = i5 + i4;
        zzaetVar.zzi(obj, bArr, i5, i6, zzaazVar);
        zzaazVar.zzc = obj;
        return i6;
    }

    public static long zzn(byte[] bArr, int i2) {
        return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }
}
