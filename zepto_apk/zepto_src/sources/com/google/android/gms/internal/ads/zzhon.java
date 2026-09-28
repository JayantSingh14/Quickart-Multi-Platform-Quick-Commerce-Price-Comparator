package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhon extends zziar implements zzicd {
    private static final zzhon zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhzl zzc = zzhzl.f34557b;
    private zzhop zzd;

    static {
        zzhon zzhonVar = new zzhon();
        zze = zzhonVar;
        zziar.x(zzhon.class, zzhonVar);
    }

    public static zzhon F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhon) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhom G() {
        return (zzhom) zze.u();
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

    public final zzhop E() {
        zzhop zzhopVar = this.zzd;
        return zzhopVar == null ? zzhop.G() : zzhopVar;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        this.zzc = zzhzlVar;
    }

    public final /* synthetic */ void J(zzhop zzhopVar) {
        this.zzd = zzhopVar;
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
            return new zzhon();
        }
        if (iOrdinal == 4) {
            return new zzhom(zze);
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
        synchronized (zzhon.class) {
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
