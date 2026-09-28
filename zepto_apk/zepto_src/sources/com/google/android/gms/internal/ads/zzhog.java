package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhog extends zziar implements zzicd {
    private static final zzhog zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhoi zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhog zzhogVar = new zzhog();
        zze = zzhogVar;
        zziar.x(zzhog.class, zzhogVar);
    }

    public static zzhog F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhog) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhof G() {
        return (zzhof) zze.u();
    }

    public static zzick H() {
        return zze.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhoi D() {
        zzhoi zzhoiVar = this.zzc;
        return zzhoiVar == null ? zzhoi.I() : zzhoiVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void I(zzhoi zzhoiVar) {
        this.zzc = zzhoiVar;
        this.zza |= 1;
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
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhog();
        }
        if (iOrdinal == 4) {
            return new zzhof(zze);
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
        synchronized (zzhog.class) {
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
