package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfnx extends zziar implements zzicd {
    private static final zzfnx zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzfnu zzb;

    static {
        zzfnx zzfnxVar = new zzfnx();
        zzc = zzfnxVar;
        zziar.x(zzfnx.class, zzfnxVar);
    }

    public static zzfnw C() {
        return (zzfnw) zzc.u();
    }

    public final /* synthetic */ void D(zzfnu zzfnuVar) {
        this.zzb = zzfnuVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfnx();
        }
        if (iOrdinal == 4) {
            return new zzfnw(zzc);
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
        synchronized (zzfnx.class) {
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
