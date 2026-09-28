package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpv extends zziar implements zzicd {
    private static final zzhpv zzd;
    private static volatile zzick zze;
    private int zza;
    private String zzb = "";
    private zzhpd zzc;

    static {
        zzhpv zzhpvVar = new zzhpv();
        zzd = zzhpvVar;
        zziar.x(zzhpv.class, zzhpvVar);
    }

    public static zzhpv E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhpv) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhpu F() {
        return (zzhpu) zzd.u();
    }

    public static zzhpv G() {
        return zzd;
    }

    public final String C() {
        return this.zzb;
    }

    public final zzhpd D() {
        zzhpd zzhpdVar = this.zzc;
        return zzhpdVar == null ? zzhpd.I() : zzhpdVar;
    }

    public final /* synthetic */ void H(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void I(zzhpd zzhpdVar) {
        zzhpdVar.getClass();
        this.zzc = zzhpdVar;
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
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhpv();
        }
        if (iOrdinal == 4) {
            return new zzhpu(zzd);
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
        synchronized (zzhpv.class) {
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
