package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbca extends zziar implements zzicd {
    private static final zzbca zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzbca zzbcaVar = new zzbca();
        zzd = zzbcaVar;
        zziar.x(zzbca.class, zzbcaVar);
    }

    public static zzbca E() {
        return zzd;
    }

    public final int C() {
        return this.zzb;
    }

    public final int D() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzbca();
        }
        if (iOrdinal == 4) {
            return new zzbbz(zzd);
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
        synchronized (zzbca.class) {
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
