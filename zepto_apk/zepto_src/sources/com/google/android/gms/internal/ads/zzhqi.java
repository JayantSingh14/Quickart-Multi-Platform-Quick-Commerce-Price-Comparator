package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqi extends zziar implements zzicd {
    private static final zzhqi zze;
    private static volatile zzick zzf;
    private int zza;
    private zzhqk zzb;
    private int zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhqi zzhqiVar = new zzhqi();
        zze = zzhqiVar;
        zziar.x(zzhqi.class, zzhqiVar);
    }

    public static zzhqi F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqi) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhqh G() {
        return (zzhqh) zze.u();
    }

    public final zzhqk C() {
        zzhqk zzhqkVar = this.zzb;
        return zzhqkVar == null ? zzhqk.G() : zzhqkVar;
    }

    public final int D() {
        return this.zzc;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void H(zzhqk zzhqkVar) {
        this.zzb = zzhqkVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void I(int i2) {
        this.zzc = i2;
    }

    public final /* synthetic */ void J(zzhzl zzhzlVar) {
        this.zzd = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhqi();
        }
        if (iOrdinal == 4) {
            return new zzhqh(zze);
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
        synchronized (zzhqi.class) {
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
