package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzavl extends zziar implements zzicd {
    private static final zzavl zzg;
    private static volatile zzick zzh;
    private int zza;
    private boolean zzb;
    private int zzc = 5000;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzavl zzavlVar = new zzavl();
        zzg = zzavlVar;
        zziar.x(zzavl.class, zzavlVar);
    }

    public static zzavl H() {
        return zzg;
    }

    public final boolean C() {
        return this.zzb;
    }

    public final int D() {
        return this.zzc;
    }

    public final boolean E() {
        return this.zzd;
    }

    public final boolean F() {
        return this.zze;
    }

    public final boolean G() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzg, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzavl();
        }
        if (iOrdinal == 4) {
            return new zzavk(zzg);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzh;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzavl.class) {
            try {
                zziamVar = zzh;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzg);
                    zzh = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
