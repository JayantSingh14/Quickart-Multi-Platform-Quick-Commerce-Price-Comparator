package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawg extends zziar implements zzicd {
    private static final zzawg zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private long zzc = -1;

    static {
        zzawg zzawgVar = new zzawg();
        zzd = zzawgVar;
        zziar.x(zzawg.class, zzawgVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zza", "zzb", zzavw.f24421a, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzawg();
        }
        if (iOrdinal == 4) {
            return new zzawf(zzd);
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
        synchronized (zzawg.class) {
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
