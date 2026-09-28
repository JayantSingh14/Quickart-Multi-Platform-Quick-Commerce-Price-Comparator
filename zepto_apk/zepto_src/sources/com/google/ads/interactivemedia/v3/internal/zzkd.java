package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzkd extends zzacq implements zzaea {
    private static final zzkd zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzacq.zzaL(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static zzkc zzd() {
        return (zzkc) zzb.zzay();
    }

    public static zzkd zzf() {
        return zzb;
    }

    public static zzkd zzg(zzabn zzabnVar) throws zzacz {
        return (zzkd) zzacq.zzaB(zzb, zzabnVar);
    }

    public static zzkd zzh(zzabn zzabnVar, zzacb zzacbVar) throws zzacz {
        return (zzkd) zzacq.zzaC(zzb, zzabnVar, zzacbVar);
    }

    public static /* synthetic */ void zzl(zzkd zzkdVar, String str) {
        str.getClass();
        zzkdVar.zzd |= 1;
        zzkdVar.zze = str;
    }

    public static /* synthetic */ void zzm(zzkd zzkdVar, long j2) {
        zzkdVar.zzd |= 16;
        zzkdVar.zzi = j2;
    }

    public static /* synthetic */ void zzn(zzkd zzkdVar, String str) {
        str.getClass();
        zzkdVar.zzd |= 2;
        zzkdVar.zzf = str;
    }

    public static /* synthetic */ void zzo(zzkd zzkdVar, long j2) {
        zzkdVar.zzd |= 4;
        zzkdVar.zzg = j2;
    }

    public static /* synthetic */ void zzp(zzkd zzkdVar, long j2) {
        zzkdVar.zzd |= 8;
        zzkdVar.zzh = j2;
    }

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzi;
    }

    public final String zzi() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzkd();
        }
        zzkb zzkbVar = null;
        if (i3 == 4) {
            return new zzkc(zzkbVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzk() {
        return this.zze;
    }
}
