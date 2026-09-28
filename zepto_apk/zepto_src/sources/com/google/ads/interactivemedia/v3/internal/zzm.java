package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzm extends zzacq implements zzaea {
    private static final zzm zzb;
    private int zzd;
    private int zze;
    private boolean zzh;
    private boolean zzf = true;
    private String zzg = "unknown_host";
    private boolean zzi = true;

    static {
        zzm zzmVar = new zzm();
        zzb = zzmVar;
        zzacq.zzaL(zzm.class, zzmVar);
    }

    private zzm() {
    }

    public static zzl zza() {
        return (zzl) zzb.zzay();
    }

    public static /* synthetic */ void zzd(zzm zzmVar, boolean z) {
        zzmVar.zzd |= 16;
        zzmVar.zzi = false;
    }

    public static /* synthetic */ void zze(zzm zzmVar, String str) {
        zzmVar.zzd |= 4;
        zzmVar.zzg = "a.3.33.0";
    }

    public static /* synthetic */ void zzf(zzm zzmVar, boolean z) {
        zzmVar.zzd |= 8;
        zzmVar.zzh = false;
    }

    public static /* synthetic */ void zzl(zzm zzmVar, int i2) {
        zzmVar.zze = 2;
        zzmVar.zzd |= 1;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", zzo.zza, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzm();
        }
        zzk zzkVar = null;
        if (i3 == 4) {
            return new zzl(zzkVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzk() {
        int iZza = zzp.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
