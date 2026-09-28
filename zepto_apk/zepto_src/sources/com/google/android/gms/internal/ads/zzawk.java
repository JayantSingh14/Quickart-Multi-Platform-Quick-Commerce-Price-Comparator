package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawk extends zziar implements zzicd {
    private static final zzawk zzd;
    private static volatile zzick zze;
    private int zza;
    private long zzb = -1;
    private int zzc = 1000;

    static {
        zzawk zzawkVar = new zzawk();
        zzd = zzawkVar;
        zziar.x(zzawk.class, zzawkVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zza", "zzb", "zzc", zzawx.f24427a});
        }
        if (iOrdinal == 3) {
            return new zzawk();
        }
        if (iOrdinal == 4) {
            return new zzawj(zzd);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zze;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawk.class) {
            try {
                zziamVar = zze;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzd);
                    zze = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
