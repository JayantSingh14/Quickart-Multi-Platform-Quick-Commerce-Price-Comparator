package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnk extends zziar implements zzicd {
    private static final zzhnk zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhno zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhnk zzhnkVar = new zzhnk();
        zze = zzhnkVar;
        zziar.x(zzhnk.class, zzhnkVar);
    }

    public static zzhnk F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnk) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhnj G() {
        return (zzhnj) zze.u();
    }

    public static zzick H() {
        return zze.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhno D() {
        zzhno zzhnoVar = this.zzc;
        return zzhnoVar == null ? zzhno.E() : zzhnoVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void I(zzhno zzhnoVar) {
        this.zzc = zzhnoVar;
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
            return new zzhnk();
        }
        if (iOrdinal == 4) {
            return new zzhnj(zze);
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
        synchronized (zzhnk.class) {
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
