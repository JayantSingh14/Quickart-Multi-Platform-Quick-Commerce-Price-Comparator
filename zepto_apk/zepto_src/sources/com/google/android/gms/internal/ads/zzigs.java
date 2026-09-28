package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzigs extends zziar implements zzicd {
    private static final zzigs zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzigs zzigsVar = new zzigs();
        zzd = zzigsVar;
        zziar.x(zzigs.class, zzigsVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziax zziaxVar = zzigr.f34824a;
            return new zzico(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zza", "zzb", zziaxVar, "zzc", zziaxVar});
        }
        if (iOrdinal == 3) {
            return new zzigs();
        }
        if (iOrdinal == 4) {
            return new zzigq(zzd);
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
        synchronized (zzigs.class) {
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
