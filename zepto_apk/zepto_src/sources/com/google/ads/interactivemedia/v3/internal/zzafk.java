package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
abstract class zzafk {
    public abstract int zza(Object obj);

    public abstract int zzb(Object obj);

    public abstract Object zzc(Object obj);

    public abstract Object zzd(Object obj);

    public abstract Object zze(Object obj, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract void zzh(Object obj, int i2, int i3);

    public abstract void zzi(Object obj, int i2, long j2);

    public abstract void zzj(Object obj, int i2, Object obj2);

    public abstract void zzk(Object obj, int i2, zzabn zzabnVar);

    public abstract void zzl(Object obj, int i2, long j2);

    public abstract void zzm(Object obj);

    public abstract void zzn(Object obj, Object obj2);

    public abstract void zzo(Object obj, Object obj2);

    public abstract void zzp(Object obj, zzagc zzagcVar) throws IOException;

    public abstract void zzq(Object obj, zzagc zzagcVar) throws IOException;

    public final boolean zzr(Object obj, zzael zzaelVar) throws IOException {
        int iZzd = zzaelVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzl(obj, i2, zzaelVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zzi(obj, i2, zzaelVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzk(obj, i2, zzaelVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzacz.zza();
            }
            zzh(obj, i2, zzaelVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        while (zzaelVar.zzc() != Integer.MAX_VALUE && zzr(objZzf, zzaelVar)) {
        }
        if ((4 | i4) != zzaelVar.zzd()) {
            throw zzacz.zzb();
        }
        zzg(objZzf);
        zzj(obj, i2, objZzf);
        return true;
    }

    public abstract boolean zzs(zzael zzaelVar);
}
