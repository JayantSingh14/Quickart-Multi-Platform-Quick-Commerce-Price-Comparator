package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfoh extends zziar implements zzicd {
    private static final zzfoh zzb;
    private static volatile zzick zzc;
    private boolean zza;

    static {
        zzfoh zzfohVar = new zzfoh();
        zzb = zzfohVar;
        zziar.x(zzfoh.class, zzfohVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzfoh();
        }
        if (iOrdinal == 4) {
            return new zzfog(zzb);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzc;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfoh.class) {
            try {
                zziamVar = zzc;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzb);
                    zzc = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
