package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfot extends zziar implements zzicd {
    private static final zzfot zzc;
    private static volatile zzick zzd;
    private boolean zza;
    private boolean zzb;

    static {
        zzfot zzfotVar = new zzfot();
        zzc = zzfotVar;
        zziar.x(zzfot.class, zzfotVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u0007", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfot();
        }
        if (iOrdinal == 4) {
            return new zzfos(zzc);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzd;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfot.class) {
            try {
                zziamVar = zzd;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzc);
                    zzd = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
