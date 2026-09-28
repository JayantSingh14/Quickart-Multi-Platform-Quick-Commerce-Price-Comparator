package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpp extends zziar implements zzicd {
    private static final zzhpp zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private zzhpr zzc;

    static {
        zzhpp zzhppVar = new zzhpp();
        zzd = zzhppVar;
        zziar.x(zzhpp.class, zzhppVar);
    }

    public static zzhpp E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhpp) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhpo F() {
        return (zzhpo) zzd.u();
    }

    public static zzick G() {
        return zzd.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhpr D() {
        zzhpr zzhprVar = this.zzc;
        return zzhprVar == null ? zzhpr.F() : zzhprVar;
    }

    public final /* synthetic */ void H(zzhpr zzhprVar) {
        this.zzc = zzhprVar;
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
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhpp();
        }
        if (iOrdinal == 4) {
            return new zzhpo(zzd);
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
        synchronized (zzhpp.class) {
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
