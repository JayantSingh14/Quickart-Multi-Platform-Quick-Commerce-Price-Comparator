package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfol extends zziar implements zzicd {
    private static final zzfol zzg;
    private static volatile zzick zzh;
    private int zzb;
    private int zzc;
    private boolean zzd;
    private boolean zzf;
    private String zza = "";
    private String zze = "";

    static {
        zzfol zzfolVar = new zzfol();
        zzg = zzfolVar;
        zziar.x(zzfol.class, zzfolVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzg, "\u0004\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u0007\u0005Ȉ\u0006\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzfol();
        }
        if (iOrdinal == 4) {
            return new zzfok(zzg);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzh;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfol.class) {
            try {
                zziamVar = zzh;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzg);
                    zzh = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
