package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzifk extends zziar implements zzicd {
    private static final zzifk zze;
    private static volatile zzick zzf;
    private int zza;
    private zzhzl zzb;
    private zzhzl zzc;
    private zzhzl zzd;

    static {
        zzifk zzifkVar = new zzifk();
        zze = zzifkVar;
        zziar.x(zzifk.class, zzifkVar);
    }

    public zzifk() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzb = zzhzlVar;
        this.zzc = zzhzlVar;
        this.zzd = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzifk();
        }
        if (iOrdinal == 4) {
            return new zzifj(zze);
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
        synchronized (zzifk.class) {
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
