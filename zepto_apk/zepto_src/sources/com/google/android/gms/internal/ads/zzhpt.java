package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpt extends zziar implements zzicd {
    private static final zzhpt zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private zzhpv zzc;

    static {
        zzhpt zzhptVar = new zzhpt();
        zzd = zzhptVar;
        zziar.x(zzhpt.class, zzhptVar);
    }

    public static zzhpt E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhpt) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhps F() {
        return (zzhps) zzd.u();
    }

    public static zzick G() {
        return zzd.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhpv D() {
        zzhpv zzhpvVar = this.zzc;
        return zzhpvVar == null ? zzhpv.G() : zzhpvVar;
    }

    public final /* synthetic */ void H(zzhpv zzhpvVar) {
        this.zzc = zzhpvVar;
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
            return new zzhpt();
        }
        if (iOrdinal == 4) {
            return new zzhps(zzd);
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
        synchronized (zzhpt.class) {
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
