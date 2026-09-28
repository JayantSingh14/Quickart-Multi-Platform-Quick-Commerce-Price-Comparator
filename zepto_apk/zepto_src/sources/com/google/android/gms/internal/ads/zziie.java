package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziie extends zziar implements zzicd {
    private static final zziie zzj;
    private static volatile zzick zzk;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private zzibd zzd;
    private zzibd zze;
    private zzibd zzf;
    private int zzg;
    private zzihn zzh;
    private String zzi;

    static {
        zziie zziieVar = new zziie();
        zzj = zziieVar;
        zziar.x(zziie.class, zziieVar);
    }

    public zziie() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zzd = zzicnVar;
        this.zze = zzicnVar;
        this.zzf = zzicnVar;
        this.zzg = -1;
        this.zzi = "";
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzj, "\u0001\b\u0000\u0001\u0001\n\b\u0000\u0003\u0000\u0001ဈ\u0001\u0002\u001b\u0003\u001b\u0004င\u0002\u0005ဈ\u0000\b\u001b\tဈ\u0004\nဉ\u0003", new Object[]{"zza", "zzc", "zzd", zzihr.class, "zze", zzihy.class, "zzg", "zzb", "zzf", zziil.class, "zzi", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zziie();
        }
        if (iOrdinal == 4) {
            return new zziid(zzj);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzk;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zziie.class) {
            try {
                zziamVar = zzk;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzj);
                    zzk = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
