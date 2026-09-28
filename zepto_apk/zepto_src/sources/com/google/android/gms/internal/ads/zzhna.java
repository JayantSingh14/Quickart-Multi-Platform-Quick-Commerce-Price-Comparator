package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhna extends zziar implements zzicd {
    private static final zzhna zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhne zzc;
    private zzhot zzd;

    static {
        zzhna zzhnaVar = new zzhna();
        zze = zzhnaVar;
        zziar.x(zzhna.class, zzhnaVar);
    }

    public static zzhna F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhna) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhmz G() {
        return (zzhmz) zze.u();
    }

    public static zzick H() {
        return zze.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhne D() {
        zzhne zzhneVar = this.zzc;
        return zzhneVar == null ? zzhne.G() : zzhneVar;
    }

    public final zzhot E() {
        zzhot zzhotVar = this.zzd;
        return zzhotVar == null ? zzhot.H() : zzhotVar;
    }

    public final /* synthetic */ void I(zzhne zzhneVar) {
        this.zzc = zzhneVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void J(zzhot zzhotVar) {
        this.zzd = zzhotVar;
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
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhna();
        }
        if (iOrdinal == 4) {
            return new zzhmz(zze);
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
        synchronized (zzhna.class) {
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
