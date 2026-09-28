package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnc extends zziar implements zzicd {
    private static final zzhnc zzd;
    private static volatile zzick zze;
    private int zza;
    private zzhng zzb;
    private zzhov zzc;

    static {
        zzhnc zzhncVar = new zzhnc();
        zzd = zzhncVar;
        zziar.x(zzhnc.class, zzhncVar);
    }

    public static zzhnc E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnc) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhnb F() {
        return (zzhnb) zzd.u();
    }

    public final zzhng C() {
        zzhng zzhngVar = this.zzb;
        return zzhngVar == null ? zzhng.F() : zzhngVar;
    }

    public final zzhov D() {
        zzhov zzhovVar = this.zzc;
        return zzhovVar == null ? zzhov.H() : zzhovVar;
    }

    public final /* synthetic */ void G(zzhng zzhngVar) {
        this.zzb = zzhngVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void H(zzhov zzhovVar) {
        this.zzc = zzhovVar;
        this.zza |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhnc();
        }
        if (iOrdinal == 4) {
            return new zzhnb(zzd);
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
        synchronized (zzhnc.class) {
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
