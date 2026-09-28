package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziep extends zziar implements zzicd {
    private static final zziep zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private long zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zziep zziepVar = new zziep();
        zze = zziepVar;
        zziar.x(zziep.class, zziepVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", zzieo.f34810a, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zziep();
        }
        if (iOrdinal == 4) {
            return new zzien(zze);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzf;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zziep.class) {
            try {
                zziamVar = zzf;
                if (zziamVar == null) {
                    zziamVar = new zziam(zze);
                    zzf = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
