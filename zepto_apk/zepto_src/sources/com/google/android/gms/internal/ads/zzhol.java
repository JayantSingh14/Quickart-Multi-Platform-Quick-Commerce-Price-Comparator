package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhol extends zziar implements zzicd {
    private static final zzhol zzb;
    private static volatile zzick zzc;
    private int zza;

    static {
        zzhol zzholVar = new zzhol();
        zzb = zzholVar;
        zziar.x(zzhol.class, zzholVar);
    }

    public static zzhol D(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhol) zziar.q(zzb, zzhzlVar, zziabVar);
    }

    public static zzhol E() {
        return zzb;
    }

    public final int C() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhol();
        }
        if (iOrdinal == 4) {
            return new zzhok(zzb);
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
        synchronized (zzhol.class) {
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
