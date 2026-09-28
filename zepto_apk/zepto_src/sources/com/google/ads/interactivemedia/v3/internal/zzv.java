package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzv extends zzacq implements zzaea {
    private static final zzv zzb;
    private int zzd;
    private long zzf;
    private long zzj;
    private long zzk;
    private long zzm;
    private int zzq;
    private String zze = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzl = "";
    private String zzn = "";
    private String zzo = "";
    private zzacw zzp = zzacq.zzaF();

    static {
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzacq.zzaL(zzv.class, zzvVar);
    }

    private zzv() {
    }

    public static zzr zza() {
        return (zzr) zzb.zzay();
    }

    public static /* synthetic */ void zzc(zzv zzvVar, long j2) {
        zzvVar.zzd |= 2;
        zzvVar.zzf = j2;
    }

    public static /* synthetic */ void zzd(zzv zzvVar, String str) {
        str.getClass();
        zzvVar.zzd |= 4;
        zzvVar.zzg = str;
    }

    public static /* synthetic */ void zze(zzv zzvVar, String str) {
        str.getClass();
        zzvVar.zzd |= 8;
        zzvVar.zzh = str;
    }

    public static /* synthetic */ void zzf(zzv zzvVar, String str) {
        zzvVar.zzd |= 16;
        zzvVar.zzi = str;
    }

    public static /* synthetic */ void zzg(zzv zzvVar, String str) {
        zzvVar.zzd |= 1024;
        zzvVar.zzo = str;
    }

    public static /* synthetic */ void zzh(zzv zzvVar, String str) {
        str.getClass();
        zzvVar.zzd |= 1;
        zzvVar.zze = str;
    }

    public static /* synthetic */ void zzi(zzv zzvVar, int i2) {
        zzvVar.zzq = i2 - 1;
        zzvVar.zzd |= 2048;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzt.class, "zzq", zzu.zza});
        }
        if (i3 == 3) {
            return new zzv();
        }
        zzq zzqVar = null;
        if (i3 == 4) {
            return new zzr(zzqVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
