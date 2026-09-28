package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhov extends zziar implements zzicd {
    private static final zzhov zze;
    private static volatile zzick zzf;
    private int zza;
    private zzhox zzb;
    private int zzc;
    private int zzd;

    static {
        zzhov zzhovVar = new zzhov();
        zze = zzhovVar;
        zziar.x(zzhov.class, zzhovVar);
    }

    public static zzhov F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhov) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhou G() {
        return (zzhou) zze.u();
    }

    public static zzhov H() {
        return zze;
    }

    public final zzhox C() {
        zzhox zzhoxVar = this.zzb;
        return zzhoxVar == null ? zzhox.F() : zzhoxVar;
    }

    public final int D() {
        return this.zzc;
    }

    public final int E() {
        return this.zzd;
    }

    public final /* synthetic */ void I(zzhox zzhoxVar) {
        this.zzb = zzhoxVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void J(int i2) {
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhov();
        }
        if (iOrdinal == 4) {
            return new zzhou(zze);
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
        synchronized (zzhov.class) {
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
