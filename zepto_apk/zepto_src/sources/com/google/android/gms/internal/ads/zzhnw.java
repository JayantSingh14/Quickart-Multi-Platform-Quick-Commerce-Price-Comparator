package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnw extends zziar implements zzicd {
    private static final zzhnw zzc;
    private static volatile zzick zzd;
    private int zza;
    private int zzb;

    static {
        zzhnw zzhnwVar = new zzhnw();
        zzc = zzhnwVar;
        zziar.x(zzhnw.class, zzhnwVar);
    }

    public static zzhnw E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnw) zziar.q(zzc, zzhzlVar, zziabVar);
    }

    public static zzhnv F() {
        return (zzhnv) zzc.u();
    }

    public final int C() {
        return this.zza;
    }

    public final int D() {
        return this.zzb;
    }

    public final /* synthetic */ void G(int i2) {
        this.zza = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzb", "zza"});
        }
        if (iOrdinal == 3) {
            return new zzhnw();
        }
        if (iOrdinal == 4) {
            return new zzhnv(zzc);
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
        synchronized (zzhnw.class) {
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
