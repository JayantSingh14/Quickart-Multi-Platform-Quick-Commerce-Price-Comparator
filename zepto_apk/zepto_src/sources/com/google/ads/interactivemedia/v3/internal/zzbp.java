package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzbp extends zzacq implements zzaea {
    private static final zzbp zzb;
    private int zzd;
    private zzacw zze = zzacq.zzaF();
    private zzabn zzf = zzabn.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzbp zzbpVar = new zzbp();
        zzb = zzbpVar;
        zzacq.zzaL(zzbp.class, zzbpVar);
    }

    private zzbp() {
    }

    public static zzbo zza() {
        return (zzbo) zzb.zzay();
    }

    public static /* synthetic */ void zzc(zzbp zzbpVar, zzabn zzabnVar) {
        zzacw zzacwVar = zzbpVar.zze;
        if (!zzacwVar.zzc()) {
            zzbpVar.zze = zzacq.zzaG(zzacwVar);
        }
        zzbpVar.zze.add(zzabnVar);
    }

    public static /* synthetic */ void zzd(zzbp zzbpVar, zzabn zzabnVar) {
        zzbpVar.zzd |= 1;
        zzbpVar.zzf = zzabnVar;
    }

    public static /* synthetic */ void zze(zzbp zzbpVar, int i2) {
        zzbpVar.zzh = 4;
        zzbpVar.zzd = 4 | zzbpVar.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzbj.zza, "zzh", zzbh.zza});
        }
        if (i3 == 3) {
            return new zzbp();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzbo(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
