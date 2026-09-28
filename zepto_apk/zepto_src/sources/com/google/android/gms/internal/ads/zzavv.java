package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzavv extends zziar implements zzicd {
    private static final zzavv zzc;
    private static volatile zzick zzd;
    private int zza;
    private int zzb;

    static {
        zzavv zzavvVar = new zzavv();
        zzc = zzavvVar;
        zziar.x(zzavv.class, zzavvVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zza", "zzb", zzavy.f24423a});
        }
        if (iOrdinal == 3) {
            return new zzavv();
        }
        if (iOrdinal == 4) {
            return new zzavu(zzc);
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
        synchronized (zzavv.class) {
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
