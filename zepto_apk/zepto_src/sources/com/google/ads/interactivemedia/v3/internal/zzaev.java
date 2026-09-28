package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class zzaev {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzafk zzc;
    private static final zzafk zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzafk zzafkVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzafkVar = (zzafk) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzafkVar;
        zzd = new zzafm();
    }

    public static void zzA(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzu(i2, list, z);
    }

    public static void zzB(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzy(i2, list, z);
    }

    public static void zzC(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzA(i2, list, z);
    }

    public static void zzD(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzC(i2, list, z);
    }

    public static void zzE(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzE(i2, list, z);
    }

    public static void zzF(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzJ(i2, list, z);
    }

    public static void zzG(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzL(i2, list, z);
    }

    public static boolean zzH(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzacr)) {
            int iZzx = 0;
            while (i2 < size) {
                iZzx += zzabw.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzx;
        }
        zzacr zzacrVar = (zzacr) list;
        int iZzx2 = 0;
        while (i2 < size) {
            iZzx2 += zzabw.zzx(zzacrVar.zze(i2));
            i2++;
        }
        return iZzx2;
    }

    public static int zzb(int i2, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzabw.zzw(i2 << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i2, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzabw.zzw(i2 << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzacr)) {
            int iZzx = 0;
            while (i2 < size) {
                iZzx += zzabw.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzx;
        }
        zzacr zzacrVar = (zzacr) list;
        int iZzx2 = 0;
        while (i2 < size) {
            iZzx2 += zzabw.zzx(zzacrVar.zze(i2));
            i2++;
        }
        return iZzx2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzado)) {
            int iZzx = 0;
            while (i2 < size) {
                iZzx += zzabw.zzx(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzx;
        }
        zzado zzadoVar = (zzado) list;
        int iZzx2 = 0;
        while (i2 < size) {
            iZzx2 += zzabw.zzx(zzadoVar.zze(i2));
            i2++;
        }
        return iZzx2;
    }

    public static int zzh(int i2, Object obj, zzaet zzaetVar) {
        int i3 = i2 << 3;
        if (!(obj instanceof zzadf)) {
            return zzabw.zzu((zzadz) obj, zzaetVar) + zzabw.zzw(i3);
        }
        int iZzw = zzabw.zzw(i3);
        int iZza = ((zzadf) obj).zza();
        return android.support.v4.media.a.w(iZza, iZza, iZzw);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzacr)) {
            int iZzw = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iZzw += zzabw.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iZzw;
        }
        zzacr zzacrVar = (zzacr) list;
        int iZzw2 = 0;
        while (i2 < size) {
            int iZze = zzacrVar.zze(i2);
            iZzw2 += zzabw.zzw((iZze >> 31) ^ (iZze + iZze));
            i2++;
        }
        return iZzw2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzado)) {
            int iZzx = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iZzx += zzabw.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iZzx;
        }
        zzado zzadoVar = (zzado) list;
        int iZzx2 = 0;
        while (i2 < size) {
            long jZze = zzadoVar.zze(i2);
            iZzx2 += zzabw.zzx((jZze >> 63) ^ (jZze + jZze));
            i2++;
        }
        return iZzx2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzacr)) {
            int iZzw = 0;
            while (i2 < size) {
                iZzw += zzabw.zzw(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzw;
        }
        zzacr zzacrVar = (zzacr) list;
        int iZzw2 = 0;
        while (i2 < size) {
            iZzw2 += zzabw.zzw(zzacrVar.zze(i2));
            i2++;
        }
        return iZzw2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzado)) {
            int iZzx = 0;
            while (i2 < size) {
                iZzx += zzabw.zzx(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzx;
        }
        zzado zzadoVar = (zzado) list;
        int iZzx2 = 0;
        while (i2 < size) {
            iZzx2 += zzabw.zzx(zzadoVar.zze(i2));
            i2++;
        }
        return iZzx2;
    }

    public static zzafk zzm() {
        return zzc;
    }

    public static zzafk zzn() {
        return zzd;
    }

    public static Object zzo(Object obj, int i2, List list, zzacu zzacuVar, Object obj2, zzafk zzafkVar) {
        if (zzacuVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzacuVar.zza(iIntValue)) {
                    obj2 = zzp(obj, i2, iIntValue, obj2, zzafkVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (zzacuVar.zza(iIntValue2)) {
                if (i4 != i3) {
                    list.set(i3, num);
                }
                i3++;
            } else {
                obj2 = zzp(obj, i2, iIntValue2, obj2, zzafkVar);
            }
        }
        if (i3 != size) {
            list.subList(i3, size).clear();
        }
        return obj2;
    }

    public static Object zzp(Object obj, int i2, int i3, Object obj2, zzafk zzafkVar) {
        if (obj2 == null) {
            obj2 = zzafkVar.zzc(obj);
        }
        zzafkVar.zzl(obj2, i2, i3);
        return obj2;
    }

    public static void zzq(zzacc zzaccVar, Object obj, Object obj2) {
        zzacg zzacgVarZzb = zzaccVar.zzb(obj2);
        if (zzacgVarZzb.zza.isEmpty()) {
            return;
        }
        zzaccVar.zzc(obj).zzh(zzacgVarZzb);
    }

    public static void zzr(zzafk zzafkVar, Object obj, Object obj2) {
        zzafkVar.zzo(obj, zzafkVar.zze(zzafkVar.zzd(obj), zzafkVar.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzacq.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzt(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzc(i2, list, z);
    }

    public static void zzu(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzg(i2, list, z);
    }

    public static void zzv(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzj(i2, list, z);
    }

    public static void zzw(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzl(i2, list, z);
    }

    public static void zzx(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzn(i2, list, z);
    }

    public static void zzy(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzp(i2, list, z);
    }

    public static void zzz(int i2, List list, zzagc zzagcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagcVar.zzs(i2, list, z);
    }
}
