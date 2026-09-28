package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziij extends zziar implements zzicd {
    private static final zziij zze;
    private static volatile zzick zzf;
    private int zza;
    private String zzb = "";
    private int zzc;
    private int zzd;

    static {
        zziij zziijVar = new zziij();
        zze = zziijVar;
        zziar.x(zziij.class, zziijVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003င\u0002", new Object[]{"zza", "zzb", "zzc", zziim.f34842a, "zzd"});
        }
        if (iOrdinal == 3) {
            return new zziij();
        }
        if (iOrdinal == 4) {
            return new zziii(zze);
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
        synchronized (zziij.class) {
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
