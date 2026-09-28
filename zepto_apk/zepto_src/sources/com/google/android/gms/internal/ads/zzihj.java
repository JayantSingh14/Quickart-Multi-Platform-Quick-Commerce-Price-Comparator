package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzihj extends zziar implements zzicd {
    private static final zzihj zzp;
    private static volatile zzick zzu;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private int zzd = 4;
    private zzibd zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private double zzi;
    private zzibd zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    static {
        zzihj zzihjVar = new zzihj();
        zzp = zzihjVar;
        zziar.x(zzihj.class, zzihjVar);
    }

    public zzihj() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zze = zzicnVar;
        this.zzf = "";
        this.zzg = "";
        this.zzj = zzicnVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzp, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zza", "zzb", "zzd", zzihi.f34835a, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzihh.class, "zzc", "zzk", zzihf.f34834a, "zzl", "zzm", "zzn", "zzo"});
        }
        if (iOrdinal == 3) {
            return new zzihj();
        }
        if (iOrdinal == 4) {
            return new zzihe(zzp);
        }
        if (iOrdinal == 5) {
            return zzp;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzu;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzihj.class) {
            try {
                zziamVar = zzu;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzp);
                    zzu = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
