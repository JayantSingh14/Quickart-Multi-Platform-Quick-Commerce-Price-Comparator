package com.google.android.gms.internal.ads;

@Deprecated
/* loaded from: classes4.dex */
public final class zzifu extends zziar implements zzicd {
    private static final zzifu zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzift zzc;
    private zzift zzd;

    static {
        zzifu zzifuVar = new zzifu();
        zze = zzifuVar;
        zziar.x(zzifu.class, zzifuVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zza", "zzb", zzifr.f34817a, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzifu();
        }
        if (iOrdinal == 4) {
            return new zzifq(zze);
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
        synchronized (zzifu.class) {
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
