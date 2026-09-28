package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhmu extends zziar implements zzicd {
    private static final zzhmu zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhzl zzc = zzhzl.f34557b;
    private zzhmy zzd;

    static {
        zzhmu zzhmuVar = new zzhmu();
        zze = zzhmuVar;
        zziar.x(zzhmu.class, zzhmuVar);
    }

    public static zzhmu F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhmu) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhmt G() {
        return (zzhmt) zze.u();
    }

    public static zzick H() {
        return zze.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhzl D() {
        return this.zzc;
    }

    public final zzhmy E() {
        zzhmy zzhmyVar = this.zzd;
        return zzhmyVar == null ? zzhmy.E() : zzhmyVar;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        this.zzc = zzhzlVar;
    }

    public final /* synthetic */ void J(zzhmy zzhmyVar) {
        this.zzd = zzhmyVar;
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
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhmu();
        }
        if (iOrdinal == 4) {
            return new zzhmt(zze);
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
        synchronized (zzhmu.class) {
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
